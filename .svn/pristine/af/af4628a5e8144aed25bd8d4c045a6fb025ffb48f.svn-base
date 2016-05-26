package com.ffcs.crmd.platform.pub.springext;

import com.ffcs.crmd.platform.base.utils.CrmPropertiesUtil;
import com.ffcs.crmd.platform.base.utils.crypt.DESEncryptUtil;
import com.ffcs.crmd.platform.base.utils.crypt.Endecrypt;
import com.ffcs.crmd.platform.base.utils.type.CrmStringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.InvalidPropertyException;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertyPlaceholderConfigurerExt extends PropertyPlaceholderConfigurer {

    private String[] enProperty;

    private Resource keyLocation;

    public String[] getEnProperty() {
        return enProperty;
    }

    public void setEnPropertys(String[] enProperty) {
        this.enProperty = enProperty;
    }

    public void setEnProperty(String enProperty) {
        this.enProperty = new String[] { enProperty };
    }

    public Resource getKeyLocation() {
        return keyLocation;
    }

    public void setKeyLocation(Resource keyLocation) {
        this.keyLocation = keyLocation;
    }

    @Override
    protected void processProperties(ConfigurableListableBeanFactory beanFactory, Properties props)
        throws BeansException {
        if (enProperty != null && enProperty.length > 0) {

            if (getKeyLocation() == null) {
                throw new InvalidPropertyException(this.getClass(), "keyLocation",
                    "keyLocation must not null");
            }
            if (!getKeyLocation().getFilename().endsWith(".properties")) {
                throw new InvalidPropertyException(this.getClass(), "keyLocation",
                    "keyLocation must property file ");
            }
            Properties keyProps = new Properties();

            InputStream is = null;
            try {
                is = new EncodedResource(getKeyLocation(),"").getInputStream();
                keyProps.load(is);
            } catch (Exception e) {
                throw new BeanCreationException("create bean error,could not load keyLocation",e);
            } finally {
                if (is != null) {
                    try {
                        is.close();
                    } catch (IOException e) {
                        //                        e.printStackTrace();
                    }
                }
            }
            if (!keyProps.containsKey("spkey")) {
                throw new BeanCreationException("keyLocation must config spkey");
            }
            for (String prop : enProperty) {
                String password = props.getProperty(prop);
                if (!CrmStringUtils.isNullOrEmpty(password)) {
                    //解密jdbc.password属性值，并重新设置
                    props.setProperty(prop,
                        Endecrypt.getInstance().get3DESDecrypt(password, keyProps.getProperty("spkey")));
                }
            }
        }

        super.processProperties(beanFactory, props);


    }
}
