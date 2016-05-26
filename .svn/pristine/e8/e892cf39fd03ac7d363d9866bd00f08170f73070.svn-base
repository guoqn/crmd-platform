package com.ffcs.crmd.platform.meta.control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.control.AbstractController;
import com.ffcs.crmd.platform.meta.api.dto.SysConfigDTO;
import com.ffcs.crmd.platform.meta.api.facade.ISysConfigFacade;
import com.ffcs.crmd.platform.meta.api.vo.SysConfigVo;
import com.ffcs.crmd.platform.pub.vo.RetVo;

@Controller
@RequestMapping("/meta/sysConfigQuery")
@ResponseBody
public class SysConfigQueryController extends AbstractController {

	@Autowired
	private ISysConfigFacade sysConfigFacade;

	/**
	 * 查询 sys_config 配置表
	 * 
	 * @param configVO
	 * @return
	 */
	@RequestMapping("/qrySysConfigList")
	public RetVo qrySysConfigList(@RequestBody SysConfigVo configVO) {
		try {
			RetVo retVo = new RetVo(true);
			String name = configVO.getName();
			PageInfo<SysConfigDTO> pageInfo = sysConfigFacade.querySysConfigList(name,
					configVO.getPageNumber(), configVO.getPageSize());
			retVo.setPageInfo(pageInfo);
			return retVo;
		} catch (Exception e) {
			RetVo retVo = new RetVo(false);
			e.printStackTrace();
			return retVo;
		}
	}

	/**
	 * 保存
	 * 
	 * @param sysConfigVo
	 * @return
	 */
	@RequestMapping("/saveSysConfig")
	public RetVo saveSysConfig(@RequestBody SysConfigVo sysConfigVo) {
		try {
			RetVo retVo = new RetVo(true);
			retVo = sysConfigFacade.saveSysConfig(sysConfigVo);
			return retVo;
		} catch (Exception e) {
			e.printStackTrace();
			RetVo retVo = new RetVo(false);
			return retVo;
		}
	}

	/**
	 * 删除
	 * 
	 * @param sysConfigVo
	 * @return
	 */
	@RequestMapping("/delSysConfig")
	public RetVo delSysConfig(@RequestBody SysConfigVo sysConfigVo) {
		try {
			RetVo retVo = new RetVo(true);
			retVo = sysConfigFacade.delSysConfig(sysConfigVo.getConfId());
			return retVo;
		} catch (Exception e) {
			e.printStackTrace();
			RetVo retVo = new RetVo(false);
			return retVo;
		}
	}

	/**
	 * 根据路径清理缓存
	 * @param sysConfigVo
	 * @return
     */
	@RequestMapping("/clearCacheByPath")
	public RetVo clearCacheByPath(@RequestBody SysConfigVo sysConfigVo) {
		try {
			RetVo retVo = new RetVo(true);
			retVo = sysConfigFacade.clearCacheByPath(sysConfigVo);
			return retVo;
		} catch (Exception e) {
			RetVo retVo = new RetVo(false);
			retVo.setMsgTitle(e.getMessage());
			return retVo;
		}
	}

	/**
	 * 清理所有缓存
	 * @param sysConfigVo
	 * @return
     */
	@RequestMapping("/clearAllCache")
	public RetVo clearAllCache(@RequestBody SysConfigVo sysConfigVo) {
		try {
			RetVo retVo = new RetVo(true);
			retVo = sysConfigFacade.clearAllCache(sysConfigVo);
			return retVo;
		} catch (Exception e) {
			RetVo retVo = new RetVo(false);
			retVo.setMsgTitle(e.getMessage());
			return retVo;
		}
	}
	
	/**
	 * 清理所有子节点
	 * @param sysConfigVo
	 * @return
     */
	@RequestMapping("/clearChildCache")
	public RetVo clearChildCache(@RequestBody SysConfigVo sysConfigVo) {
		try {
			RetVo retVo = new RetVo(true);
			retVo = sysConfigFacade.clearChildCache(sysConfigVo);
			return retVo;
		} catch (Exception e) {
			RetVo retVo = new RetVo(false);
			retVo.setMsgTitle(e.getMessage());
			return retVo;
		}
	}
}
