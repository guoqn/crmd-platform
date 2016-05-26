package com.ffcs.crmd.platform.pub.proxy.provider;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import com.ctg.itrdc.platform.common.exception.RtManagerException;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ctg.itrdc.platform.pub.constant.ServantConstants;
import com.ctg.itrdc.platform.pub.util.ApplicationContextUtil;

/**
 * 后台服务类加载
 * 
 * @author Hushaofeng
 */
public class ServiceLoader {

	/**
	 * .
	 */
	private Map<String, String> factoryMap;

	/**
	 * .
	 */
	private static class SingletonHolder {
		private static ServiceLoader INSTANCE = new ServiceLoader();
	}

	/**
	 * .
	 */
	public static HashMap<String, Method> methodMap = new HashMap<String, Method>();

	/**
	 * .
	 * 
	 */
	public ServiceLoader() {
		factoryMap = new HashMap<String, String>();
	}

	/**
	 * .
	 * 
	 */
	public static ServiceLoader getDefaultFactory() {
		return SingletonHolder.INSTANCE;
	}

	/**
	 * .
	 * 
	 */
	public void registerService(String name, Class<Object> serviceClass) {
		factoryMap.put(name, serviceClass.getName());
	}

	public void registerService(String name, String serviceClass) {
		factoryMap.put(name, serviceClass);
	}

	/**
	 * 根据服务名，获取对应的类名
	 * 
	 * @param serviceName
	 * @return
	 */
	public String getServiceClazzName(String serviceName) {
		String fac = (String) factoryMap.get(serviceName);
		return StringUtils.isBlank(fac) ? serviceName : fac;
	}

	/**
	 * @param serviceName
	 *            String
	 * @return Object
	 */
	public Object getServiceInstance(String serviceName) {
		String serviceClazzName = this.getServiceClazzName(serviceName);
		return this.getServiceInstanceByClazzName(serviceClazzName);
	}

	/**
	 * String
	 * 
	 * @return Object
	 */
	private Object getServiceInstanceByClazzName(String serviceClazzName) {
		try {
			Object service = null;
			if (serviceClazzName.indexOf("$") == 0) { // Spring
				String beanId = serviceClazzName.replace("$", "");
				return ApplicationContextUtil.getBean(beanId);
			} else { // Class.forName
				service = Class.forName(serviceClazzName).newInstance();
			}
			return service;
		} catch (InstantiationException e) {
			throw new RtManagerException("根据服务：" + serviceClazzName + "获取实例异常",
					e);
		} catch (IllegalAccessException e) {
			throw new RtManagerException("根据服务：" + serviceClazzName + "获取实例异常",
					e);
		} catch (ClassNotFoundException e) {
			throw new RtManagerException("根据服务：" + serviceClazzName + "获取实例异常",
					e);
		}
	}

	/**
	 * @param serviceInstance
	 *            Object
	 * @param methodName
	 *            String
	 * @return Method
	 */
	public Method getClazzMethod(Object serviceInstance, String methodName,
			Object... args) {
		String key = serviceInstance.getClass().getName()
				+ ServantConstants.SERV_FACTORY_TAG + methodName
				+ ServantConstants.SERV_FACTORY_TAG + args.length;
		for (Object obj : args) {
			if (obj != null) {
				key += ServantConstants.SERV_FACTORY_TAG
						+ obj.getClass().getName();
			} else {
				key += ServantConstants.SERV_FACTORY_TAG + "null";
			}
		}
		if (!methodMap.containsKey(key)) {
			Method[] methodList = serviceInstance.getClass().getMethods();
			for (int i = 0; i < methodList.length; i++) {
				Method method = methodList[i];
				Class<?>[] param = method.getParameterTypes();
				if (param.length == args.length
						&& methodName.equals(method.getName())) {

					boolean sample = true;
					for (int j = 0; j < param.length; j++) {
						if (args[j] == null) {
							sample = sample && true;
						} else if (param[j].getName().equals(
								args[j].getClass().getName())) { // 参数类型全相同
							sample = sample && true;
						} else if (param[j]
								.isAssignableFrom(args[j].getClass())) { // 方式参数是入参的父类
							sample = sample && true;
						} else if (args[j].getClass().getName().toLowerCase()
								.contains(param[j].getName())) {
							sample = sample && true;
						} else {
							sample = false;
							break;
						}
					}
					if (sample) {
						methodMap.put(key, methodList[i]);
						break;
					}
				}
			}
		}
		return methodMap.get(key);
	}

}
