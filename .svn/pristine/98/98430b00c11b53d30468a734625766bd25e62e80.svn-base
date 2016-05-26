package com.ffcs.crmd.platform.meta.api.facade;

import java.util.List;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.dao.api.facade.ICrmBaseFacade;
import com.ffcs.crmd.platform.meta.api.dto.DynamicComponentDTO;
import com.ffcs.crmd.platform.meta.api.dto.DynamicEventDTO;
import com.ffcs.crmd.platform.meta.api.dto.DynamicPartDTO;
import com.ffcs.crmd.platform.meta.api.dto.DynamicStyleDTO;
import com.ffcs.crmd.platform.meta.api.dto.DynamicTemplateDTO;
import com.ffcs.crmd.platform.meta.api.dto.DynamicWindowDTO;

/**
 * 
 * 获取窗体
 * 
 * @author LAIYONGMIN-PC
 *
 */
public interface IDynamicPageFacade extends ICrmBaseFacade {

	/**
	 * 获取窗体信息
	 * 
	 * @param winCode
	 * @return
	 */
	public DynamicWindowDTO getDynamicWindowDTO(String winCode);

	/**
	 * 根据条件获取营销资源窗体
	 * 
	 * @param winCode
	 * @return
	 */
	public DynamicWindowDTO getMKTDynamicWindowDTO(Long busSpec, Long busService, Long busRegion);

	/**
	 * @param busType
	 * @param busSpec
	 * @param busObjId
	 * @param busRegion
	 * @param busService
	 * @param busChannel
	 * @return
	 */
	public DynamicWindowDTO getDynamicWindowDto(String busType, Long busSpec, Long busObjId, Long busRegion,
			Long busService, Long busChannel);

	/**
	 * 根据事件ID获取窗体
	 * 
	 * @param eventId
	 * @return
	 */
	public DynamicWindowDTO getDynamicWindowDtoByEventId(Long eventId);

	/**
	 * 通过规格编号获取配置事件信息
	 * 
	 * @param busSpec
	 * @return
	 */
	public PageInfo<DynamicEventDTO> queryEventByBusspec(Long busSpec, int page, int pageSize);

	/**
	 * @param busType
	 * @param busSpec
	 * @param busObjId
	 * @param busRegion
	 * @param busService
	 * @param busChannel
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public PageInfo<DynamicEventDTO> queryPageInfoEvents(String busType, Long busSpec, Long busObjId, Long busRegion,
			Long busService, Long busChannel, int page, int pageSize);

	/**
	 * @param eventId
	 * @return
	 */
	public DynamicEventDTO getDyEventById(Long eventId);

	/**
	 * 保存数据
	 * 
	 * @param eventDto
	 * @return
	 */
	public int insertDyEvent(DynamicEventDTO eventDto);

	/**
	 * 更新数据
	 * 
	 * @param eventDto
	 * @return
	 */
	public int updateDyEvent(DynamicEventDTO eventDto);

	/**
	 * 删除数据
	 * 
	 * @param id
	 * @return
	 */
	public int deleteByEvent(Long id);

	/**
	 * 新增样式
	 * 
	 * @param styleDto
	 * @return
	 */
	public int insertDyStyle(DynamicStyleDTO styleDto);

	/**
	 * 修改样式
	 * 
	 * @param styleDto
	 * @return
	 */
	public int updateDyStyle(DynamicStyleDTO styleDto);

	/**
	 * 删除样式
	 * 
	 * @param id
	 * @return
	 */
	public int deleteDyStyle(Long id);

	/**
	 * 根据类型和样式组件获取主键信息
	 * 
	 * @param id
	 * @param type
	 * @return
	 */
	public List<DynamicStyleDTO> qryDynamicStyles(Long id, String type);

	/**
	 * 获取修改对象
	 * 
	 * @param id
	 * @return
	 */
	public DynamicStyleDTO getDyStyleById(Long id);

	/**
	 * @return
	 */
	public List<DynamicStyleDTO> qryAllStyleTreeData();

	/**
	 * 页面数据处理
	 * 
	 * @param handleData
	 */
	public void handlePageData(DynamicComponentDTO handleData);

	/**
	 * 根据具体的信息获取窗体信息
	 * 
	 * @param dto
	 * @param page
	 * @param pageSize
	 * @return
	 */
	public PageInfo<DynamicWindowDTO> qryWindowPageInfoByWin(DynamicWindowDTO dto, int page, int pageSize);

	/**
	 * @param dto
	 * @return
	 */
	public int saveSimpleWindow(DynamicWindowDTO dto);

	/**
	 * 获取简单的窗体信息 （不包含：样式、组件等信息）
	 * 
	 * @param winId
	 * @return
	 */
	public DynamicWindowDTO getSimpleWindow(Long winId);

	/**
	 * 清除 窗体、组件和样式
	 * 
	 * @param windowId
	 */
	public void deleteWindow(Long windowId);

	/*	*//**
			 * 获取构件类型
			 * 
			 * @return
			 *//*
			 * public List<DynamicPartDTO> qryPartType();
			 */

	/**
	 * 获取分页构件
	 * 
	 * @return
	 */
	public PageInfo<DynamicPartDTO> qryPageInfoPart(DynamicPartDTO dto, int page, int pageSize);

	/**
	 * 保存构件
	 * 
	 * @param dto
	 * @return
	 */
	public void savePart(DynamicPartDTO dto);

	/**
	 * 删除构件
	 * 
	 * @param dto
	 */
	public void deletePart(Long partId);

	/**
	 * 获取纯构件信息
	 * 
	 * @param partId
	 * @return
	 */
	public DynamicPartDTO getSimplePart(Long partId);

	/**
	 * 根据构件ID获取基本窗体信息
	 * 
	 * @param partId
	 * @return
	 */
	public List<DynamicWindowDTO> qrySimpleWindowByPartId(Long partId);

	/**
	 * 获取所有构件
	 * 
	 * @return
	 */
	public List<DynamicPartDTO> qryParts();

	/**
	 * 获取分页模版
	 * 
	 * @param tpl
	 * @return
	 */
	public PageInfo<DynamicTemplateDTO> qryTplPageInfo(DynamicTemplateDTO tpl, int page, int pageSize);

	/**
	 * 根据 编码获取模版
	 * 
	 * @param code
	 * @return
	 */
	public DynamicTemplateDTO getTplByCode(String code);

	/**
	 * @param Id
	 * @return
	 */
	public DynamicTemplateDTO getTplById(Long id);

	/**
	 * 保存模版
	 * 
	 * @param tplDto
	 */
	public void saveTpl(DynamicTemplateDTO tplDto);

	/**
	 * 删除
	 * 
	 * @param id
	 */
	public void delTpl(Long id);

	/**
	 * 更新
	 * 
	 * @param tplDto
	 */
	public void updateTpl(DynamicTemplateDTO tplDto);

	/**
	 * 模版ID获取窗体
	 * 
	 * @param tplId
	 * @return
	 */
	public DynamicWindowDTO getDynamicWindowByTplId(Long tplId);

	/**
	 * 模版Code获取窗体
	 * 
	 * @param tplId
	 * @return
	 */
	public DynamicWindowDTO getDynamicWindowByTplCode(String code);

	/**
	 * 类型获取模块
	 * 
	 * @param type
	 * @return
	 */
	public List<DynamicTemplateDTO> qryTplListsByType(String type);

}
