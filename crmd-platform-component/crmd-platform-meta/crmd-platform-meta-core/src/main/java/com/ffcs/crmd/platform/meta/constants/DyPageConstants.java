package com.ffcs.crmd.platform.meta.constants;

/**
 * 
 * 动态配置界面常量
 * 
 * @author LAIYONGMIN-PC
 *
 */
public enum DyPageConstants {

	// ::::::样式类型

	STYLE_TYPE_CLASS("class", "class类型样式"),

	STYLE_TYPE_STYLE("style", "style类型样式"),
	// 主题类型
	STYLE_TYPE_THEME("theme", "主题类型"),

	// ::::::组件类型

	COMP_TYPE_INPUT("1", "输入框"),

	COMP_TYPE_DIV("2", "层"),
	// ::::窗体类型

	// 事件窗体
	WIN_TYPE_EVENT_WIN("E_WIN", "事件窗体"),
	// 模块窗体
	WIN_TYPE_TPL_WIN("T_WIN", "模版窗体"),
	// 通用窗体
	WIN_TYPE_WIN_WIN("W_WIN", "通用窗体"),
	// 构件窗体
	WIN_TYPE_PART_WIN("P_WIN", "构件窗体"),
	// // 组合窗体
	// WIN_TYPE_GROUP_WIN("G_WIN", "组合组件窗体"),

	TEST("");

	private DyPageConstants(Object value, Object desc) {
		this.value = value;
		this.desc = desc;
	}

	private DyPageConstants(String value) {
		this.value = value;
	}

	private Object value;

	private Object desc;

	public Object getValue() {
		return value;
	}

	public void setValue(Object value) {
		this.value = value;
	}

	public Object getDesc() {
		return desc;
	}

	public void setDesc(Object desc) {
		this.desc = desc;
	}

}
