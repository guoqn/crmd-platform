package com.ffcs.crmd.platform.meta.vo;

import com.ffcs.crmd.platform.pub.vo.ConditionVo;

/**
 * 
 * 前后端参数对象
 * 
 * @author LAIYONGMIN-PC
 *
 */
public class DynamicPageVo extends ConditionVo {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// 窗体编码
	private String winCode;

	private String objType;

	private Long objId;
	// 事件ID
	private Long eventId;
	// 规格
	private Long busSpec;
	// 动作
	private Long busService;
	// 区域
	private Long busRegion;
	private String busType;
	private Long busObjId;
	private Long busChannel;
	// 样式ID
	private Long styleId;
	// 样式类型
	private String styleType;

	// 分页信息
	private Integer pageNumber;

	private Integer pageSize;

	private Integer limit;

	private Integer offset;

	private String order;

	// 窗体类型
	private String winType;

	// 窗体名称
	private String winName;
	// 窗体Id
	private Long winId;

	private String name;

	private String type;

	private String code;

	public Long getBusSpec() {
		return busSpec;
	}

	public void setBusSpec(Long busSpec) {
		this.busSpec = busSpec;
	}

	public Long getBusService() {
		return busService;
	}

	public void setBusService(Long busService) {
		this.busService = busService;
	}

	public Long getBusRegion() {
		return busRegion;
	}

	public void setBusRegion(Long busRegion) {
		this.busRegion = busRegion;
	}

	public String getWinCode() {
		return winCode;
	}

	public void setWinCode(String winCode) {
		this.winCode = winCode;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getLimit() {
		return limit;
	}

	public void setLimit(Integer limit) {
		this.limit = limit;
	}

	public Integer getOffset() {
		return offset;
	}

	public void setOffset(Integer offset) {
		this.offset = offset;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public Long getEventId() {
		return eventId;
	}

	public void setEventId(Long eventId) {
		this.eventId = eventId;
	}

	public Long getStyleId() {
		return styleId;
	}

	public void setStyleId(Long styleId) {
		this.styleId = styleId;
	}

	public String getStyleType() {
		return styleType;
	}

	public void setStyleType(String styleType) {
		this.styleType = styleType;
	}

	public String getWinType() {
		return winType;
	}

	public void setWinType(String winType) {
		this.winType = winType;
	}

	public String getWinName() {
		return winName;
	}

	public void setWinName(String winName) {
		this.winName = winName;
	}

	public Long getWinId() {
		return winId;
	}

	public void setWinId(Long winId) {
		this.winId = winId;
	}

	public String getObjType() {
		return objType;
	}

	public void setObjType(String objType) {
		this.objType = objType;
	}

	public Long getObjId() {
		return objId;
	}

	public void setObjId(Long objId) {
		this.objId = objId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getBusType() {
		return busType;
	}

	public void setBusType(String busType) {
		this.busType = busType;
	}

	public Long getBusObjId() {
		return busObjId;
	}

	public void setBusObjId(Long busObjId) {
		this.busObjId = busObjId;
	}

	public Long getBusChannel() {
		return busChannel;
	}

	public void setBusChannel(Long busChannel) {
		this.busChannel = busChannel;
	}

}
