package com.ffcs.crmd.platform.meta.api.dto;

import com.ffcs.crmd.platform.core.ddd.api.dto.impl.DomBaseDTO;

import java.sql.Timestamp;

/**
 * @author FFCS-CAIWL
 */
public class AttrSpecDTO extends DomBaseDTO {

    /**
     * 记录属性的主键
     */
    private Long attrId;

    /**
     * 记录属性规格取值范围之最小值
     */
    private String startValue;

    /**
     *
     */
    private String addEffType;

    /**
     * 多个用;号隔开（解决cns_type不能取并集的问题）:NCP页面不可拷贝
     */
    private String cnsTypeExtra;

    /**
     * 记录属性值在业务对象实例中唯一
     */
    private String isUnique;

    /**
     * 记录外部属性编码
     */
    private String extAttrCd;

    /**
     *
     */
    private String attrLevel;

    /**
     * 记录属性规格值格式(正则表达式),用于属性值生成、合法性效验
     */
    private String attrFormat;

    /**
     * 记录属性编码
     */
    private String attrNbr;

    /**
     * 记录是否可空
     */
    private String isNullable;

    /**
     *
     */
    private String codeBuilder;

    /**
     *
     */
    private String groupCd;

    /**
     * 订单查询，档案查询。属性展示的规则，如属性保存的是产品实例id，界面要展示成业务号码；-1的界面不展示等是否显示标识，-1--订单申请信息不显示，1--档案查询密码展示明文2
     */
    private String printExt;

    /**
     *
     */
    private Long isMultiValue;

    /**
     *
     */
    private String attrIoType;

    /**
     * 描述记录删除到历史表的时间，在用表一般为空
     */
    private Timestamp recUpdateDate;

    /**
     *
     */
    private String completeAction;

    /**
     *
     */
    private String codeParam;

    /**
     *
     */
    private String extFlag;

    /**
     *
     */
    private String isTrans;

    /**
     *
     */
    private Long attrSort;

    /**
     * 0:不送1:送
     */
    private String hbPost;

    /**
     * LOVE,记录属性值类型，如输入框、下拉框
     */
    private String attrValueType;

    /**
     * 0:不送1:送
     */
    private String pfPost;

    /**
     *
     */
    private Long refBusyTypeId;

    /**
     * 接口主数据通过该字段标识接口是否关闭；PPM配置界面控制是否需要展示属性
     */
    private String isVisible;

    /**
     * 记录业务大类主键
     */
    private Long busiTypeId;

    /**
     * 记录业务对象属性规格名称
     */
    private String attrName;

    /**
     * 记录父级属性的标识
     */
    private Long parAttrId;

    /**
     * 记录业务对象属性规格详细描述
     */
    private String attrDesc;

    /**
     * 描述记录所属的C3区域标识
     */
    private Long areaId;

    /**
     * 记录是否动态属性，动态属性在横表，静态属性在纵表
     */
    private String isDanyAttr;

    /**
     *
     */
    private String procType;

    /**
     * 记录属性规格取值范围之最大值
     */
    private String endValue;

    /**
     *
     */
    private String defaultTypePeriod;

    /**
     *
     */
    private String ownerApp;

    /**
     * 持久化类型，属性类型（输入T1,关联T2,选择T3,自动编码属性T4,内存属性T5）
     */
    private String attrPersistType;

    /**
     *
     */
    private String printFormat;

    /**
     *
     */
    private String modEffType;

    /**
     * 记录属性规格值长度
     */
    private Long attrLength;

    /**
     * LOVE,当属性值分类为输入型时，属性值数据类型为日期型、日期时间型、字符型、数值型等
     */
    private String attrValueDataType;

    /**
     * 记录属性规格默认取值
     */
    private String defaultValue;

    /**
     *
     */
    private String seqName;

    /**
     * 2.0集团规范字段目前仅有一个值ATTR，用于集团下发销售品属性区分
     */
    private String attrSpecExtRule;

    /**
     *
     */
    private String expireType;

    public void setAttrId(Long attrId) {
        this.attrId = attrId;
    }

    public Long getAttrId() {
        return this.attrId;
    }

    public void setStartValue(String startValue) {
        this.startValue = startValue;
    }

    public String getStartValue() {
        return this.startValue;
    }

    public void setAddEffType(String addEffType) {
        this.addEffType = addEffType;
    }

    public String getAddEffType() {
        return this.addEffType;
    }

    public void setCnsTypeExtra(String cnsTypeExtra) {
        this.cnsTypeExtra = cnsTypeExtra;
    }

    public String getCnsTypeExtra() {
        return this.cnsTypeExtra;
    }

    public void setIsUnique(String isUnique) {
        this.isUnique = isUnique;
    }

    public String getIsUnique() {
        return this.isUnique;
    }

    public void setExtAttrCd(String extAttrCd) {
        this.extAttrCd = extAttrCd;
    }

    public String getExtAttrCd() {
        return this.extAttrCd;
    }

    public void setAttrLevel(String attrLevel) {
        this.attrLevel = attrLevel;
    }

    public String getAttrLevel() {
        return this.attrLevel;
    }

    public void setAttrFormat(String attrFormat) {
        this.attrFormat = attrFormat;
    }

    public String getAttrFormat() {
        return this.attrFormat;
    }

    public void setAttrNbr(String attrNbr) {
        this.attrNbr = attrNbr;
    }

    public String getAttrNbr() {
        return this.attrNbr;
    }

    public void setIsNullable(String isNullable) {
        this.isNullable = isNullable;
    }

    public String getIsNullable() {
        return this.isNullable;
    }

    public void setCodeBuilder(String codeBuilder) {
        this.codeBuilder = codeBuilder;
    }

    public String getCodeBuilder() {
        return this.codeBuilder;
    }

    public void setGroupCd(String groupCd) {
        this.groupCd = groupCd;
    }

    public String getGroupCd() {
        return this.groupCd;
    }

    public void setPrintExt(String printExt) {
        this.printExt = printExt;
    }

    public String getPrintExt() {
        return this.printExt;
    }

    public void setIsMultiValue(Long isMultiValue) {
        this.isMultiValue = isMultiValue;
    }

    public Long getIsMultiValue() {
        return this.isMultiValue;
    }

    public void setAttrIoType(String attrIoType) {
        this.attrIoType = attrIoType;
    }

    public String getAttrIoType() {
        return this.attrIoType;
    }

    public void setRecUpdateDate(Timestamp recUpdateDate) {
        this.recUpdateDate = recUpdateDate;
    }

    public Timestamp getRecUpdateDate() {
        return this.recUpdateDate;
    }

    public void setCompleteAction(String completeAction) {
        this.completeAction = completeAction;
    }

    public String getCompleteAction() {
        return this.completeAction;
    }

    public void setCodeParam(String codeParam) {
        this.codeParam = codeParam;
    }

    public String getCodeParam() {
        return this.codeParam;
    }

    public void setExtFlag(String extFlag) {
        this.extFlag = extFlag;
    }

    public String getExtFlag() {
        return this.extFlag;
    }

    public void setIsTrans(String isTrans) {
        this.isTrans = isTrans;
    }

    public String getIsTrans() {
        return this.isTrans;
    }

    public void setAttrSort(Long attrSort) {
        this.attrSort = attrSort;
    }

    public Long getAttrSort() {
        return this.attrSort;
    }

    public void setHbPost(String hbPost) {
        this.hbPost = hbPost;
    }

    public String getHbPost() {
        return this.hbPost;
    }

    public void setAttrValueType(String attrValueType) {
        this.attrValueType = attrValueType;
    }

    public String getAttrValueType() {
        return this.attrValueType;
    }

    public void setPfPost(String pfPost) {
        this.pfPost = pfPost;
    }

    public String getPfPost() {
        return this.pfPost;
    }

    public void setRefBusyTypeId(Long refBusyTypeId) {
        this.refBusyTypeId = refBusyTypeId;
    }

    public Long getRefBusyTypeId() {
        return this.refBusyTypeId;
    }

    public void setIsVisible(String isVisible) {
        this.isVisible = isVisible;
    }

    public String getIsVisible() {
        return this.isVisible;
    }

    public void setBusiTypeId(Long busiTypeId) {
        this.busiTypeId = busiTypeId;
    }

    public Long getBusiTypeId() {
        return this.busiTypeId;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    public String getAttrName() {
        return this.attrName;
    }

    public void setParAttrId(Long parAttrId) {
        this.parAttrId = parAttrId;
    }

    public Long getParAttrId() {
        return this.parAttrId;
    }

    public void setAttrDesc(String attrDesc) {
        this.attrDesc = attrDesc;
    }

    public String getAttrDesc() {
        return this.attrDesc;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Long getAreaId() {
        return this.areaId;
    }

    public void setIsDanyAttr(String isDanyAttr) {
        this.isDanyAttr = isDanyAttr;
    }

    public String getIsDanyAttr() {
        return this.isDanyAttr;
    }

    public void setProcType(String procType) {
        this.procType = procType;
    }

    public String getProcType() {
        return this.procType;
    }

    public void setEndValue(String endValue) {
        this.endValue = endValue;
    }

    public String getEndValue() {
        return this.endValue;
    }

    public void setDefaultTypePeriod(String defaultTypePeriod) {
        this.defaultTypePeriod = defaultTypePeriod;
    }

    public String getDefaultTypePeriod() {
        return this.defaultTypePeriod;
    }

    public void setOwnerApp(String ownerApp) {
        this.ownerApp = ownerApp;
    }

    public String getOwnerApp() {
        return this.ownerApp;
    }

    public void setAttrPersistType(String attrPersistType) {
        this.attrPersistType = attrPersistType;
    }

    public String getAttrPersistType() {
        return this.attrPersistType;
    }

    public void setPrintFormat(String printFormat) {
        this.printFormat = printFormat;
    }

    public String getPrintFormat() {
        return this.printFormat;
    }

    public void setModEffType(String modEffType) {
        this.modEffType = modEffType;
    }

    public String getModEffType() {
        return this.modEffType;
    }

    public void setAttrLength(Long attrLength) {
        this.attrLength = attrLength;
    }

    public Long getAttrLength() {
        return this.attrLength;
    }

    public void setAttrValueDataType(String attrValueDataType) {
        this.attrValueDataType = attrValueDataType;
    }

    public String getAttrValueDataType() {
        return this.attrValueDataType;
    }

    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    public String getDefaultValue() {
        return this.defaultValue;
    }

    public void setSeqName(String seqName) {
        this.seqName = seqName;
    }

    public String getSeqName() {
        return this.seqName;
    }

    public void setAttrSpecExtRule(String attrSpecExtRule) {
        this.attrSpecExtRule = attrSpecExtRule;
    }

    public String getAttrSpecExtRule() {
        return this.attrSpecExtRule;
    }

    public void setExpireType(String expireType) {
        this.expireType = expireType;
    }

    public String getExpireType() {
        return this.expireType;
    }

}
