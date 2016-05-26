package com.ffcs.crmd.platform.meta.entity;

import com.ffcs.crmd.platform.core.ddd.repository.RepositoryRegister;
import com.ctg.itrdc.platform.pub.annotations.ShardingBean;
import com.ctg.itrdc.platform.pub.annotations.ShardingId;
import com.ffcs.crmd.platform.core.ddd.entity.impl.AbstractCrmDomBaseEntityImpl;
import com.ffcs.crmd.platform.meta.intf.IAttrSpec2;
import com.ffcs.crmd.platform.meta.repository.IAttrSpec2Repository;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Table(name = "ATTR_SPEC")
public class AttrSpec2 extends AbstractCrmDomBaseEntityImpl<Long> implements IAttrSpec2 {

    private static final long serialVersionUID = -2811347047325737314L;

    /**
     * 记录属性的主键
     */
    @Id
    @Column(name = "ATTR_ID")
    private Long attrId;

    /**
     * 描述记录所属的C4区域标识
     */
    @Column(name = "REGION_CD")
    private Long regionCd;

    /**
     * 记录属性规格取值范围之最小值
     */
    @Column(name = "START_VALUE")
    private String startValue;

    /**
     *
     */
    @Column(name = "ADD_EFF_TYPE")
    private String addEffType;

    /**
     * 多个用;号隔开（解决cns_type不能取并集的问题）:NCP页面不可拷贝
     */
    @Column(name = "CNS_TYPE_EXTRA")
    private String cnsTypeExtra;

    /**
     * 记录属性值在业务对象实例中唯一
     */
    @Column(name = "IS_UNIQUE")
    private String isUnique;

    /**
     * 记录备注信息。
     */
    @Column(name = "REMARK")
    private String remark;

    /**
     * 记录外部属性编码
     */
    @Column(name = "EXT_ATTR_CD")
    private String extAttrCd;

    /**
     *
     */
    @Column(name = "ATTR_LEVEL")
    private String attrLevel;

    /**
     * 状态修改的时间
     */
    @Column(name = "STATUS_DATE")
    private Timestamp statusDate;

    /**
     * 记录属性规格值格式(正则表达式),用于属性值生成、合法性效验
     */
    @Column(name = "ATTR_FORMAT")
    private String attrFormat;

    /**
     * 记录属性编码
     */
    @Column(name = "ATTR_NBR")
    private String attrNbr;

    /**
     * 记录是否可空
     */
    @Column(name = "IS_NULLABLE")
    private String isNullable;

    /**
     *
     */
    @Column(name = "CODE_BUILDER")
    private String codeBuilder;

    /**
     * 描述关联表对端的分片键
     */
    @Column(name = "REL_SHARDING_ID")
    private Long relShardingId;

    /**
     *
     */
    @Column(name = "GROUP_CD")
    private String groupCd;

    /**
     * 订单查询，档案查询。属性展示的规则，如属性保存的是产品实例id，界面要展示成业务号码；-1的界面不展示等是否显示标识，-1--订单申请信息不显示，1--档案查询密码展示明文2
     */
    @Column(name = "PRINT_EXT")
    private String printExt;

    /**
     *
     */
    @Column(name = "IS_MULTI_VALUE")
    private Long isMultiValue;

    /**
     *
     */
    @Column(name = "ATTR_IO_TYPE")
    private String attrIoType;

    /**
     * 描述记录删除到历史表的时间，在用表一般为空
     */
    @Column(name = "REC_UPDATE_DATE")
    private Timestamp recUpdateDate;

    /**
     * 描述记录的分片键
     */
    @Column(name = "SHARDING_ID")
    private Long shardingId;

    /**
     *
     */
    @Column(name = "COMPLETE_ACTION")
    private String completeAction;

    /**
     *
     */
    @Column(name = "CODE_PARAM")
    private String codeParam;

    /**
     *
     */
    @Column(name = "EXT_FLAG")
    private String extFlag;

    /**
     *
     */
    @Column(name = "IS_TRANS")
    private String isTrans;

    /**
     *
     */
    @Column(name = "ATTR_SORT")
    private Long attrSort;

    /**
     * 描述记录的版本，从0开始，每更新一次版本号加1
     */
    @Column(name = "DVERSION")
    private Long dversion;

    /**
     * 0:不送1:送
     */
    @Column(name = "HB_POST")
    private String hbPost;

    /**
     * LOVE,记录属性值类型，如输入框、下拉框
     */
    @Column(name = "ATTR_VALUE_TYPE")
    private String attrValueType;

    /**
     * 记录状态
     */
    @Column(name = "STATUS_CD")
    private String statusCd;

    /**
     * 0:不送1:送
     */
    @Column(name = "PF_POST")
    private String pfPost;

    /**
     * 记录创建的时间
     */
    @Column(name = "CREATE_DATE")
    private Timestamp createDate;

    /**
     *
     */
    @Column(name = "REF_BUSY_TYPE_ID")
    private Long refBusyTypeId;

    /**
     * 接口主数据通过该字段标识接口是否关闭；PPM配置界面控制是否需要展示属性
     */
    @Column(name = "IS_VISIBLE")
    private String isVisible;

    /**
     * 记录业务大类主键
     */
    @Column(name = "BUSI_TYPE_ID")
    private Long busiTypeId;

    /**
     * 记录业务对象属性规格名称
     */
    @Column(name = "ATTR_NAME")
    private String attrName;

    /**
     * 记录父级属性的标识
     */
    @Column(name = "PAR_ATTR_ID")
    private Long parAttrId;

    /**
     * 记录创建的员工
     */
    @Column(name = "CREATE_STAFF")
    private Long createStaff;

    /**
     * 记录修改的时间
     */
    @Column(name = "UPDATE_DATE")
    private Timestamp updateDate;

    /**
     * 记录业务对象属性规格详细描述
     */
    @Column(name = "ATTR_DESC")
    private String attrDesc;

    /**
     * 描述记录所属的C3区域标识
     */
    @Column(name = "AREA_ID")
    private Long areaId;

    /**
     * 记录是否动态属性，动态属性在横表，静态属性在纵表
     */
    @Column(name = "IS_DANY_ATTR")
    private String isDanyAttr;

    /**
     * 记录修改的员工
     */
    @Column(name = "UPDATE_STAFF")
    private Long updateStaff;

    /**
     *
     */
    @Column(name = "PROC_TYPE")
    private String procType;

    /**
     * 记录属性规格取值范围之最大值
     */
    @Column(name = "END_VALUE")
    private String endValue;

    /**
     *
     */
    @Column(name = "DEFAULT_TYPE_PERIOD")
    private String defaultTypePeriod;

    /**
     *
     */
    @Column(name = "OWNER_APP")
    private String ownerApp;

    /**
     * 持久化类型，属性类型（输入T1,关联T2,选择T3,自动编码属性T4,内存属性T5）
     */
    @Column(name = "ATTR_PERSIST_TYPE")
    private String attrPersistType;

    /**
     *
     */
    @Column(name = "PRINT_FORMAT")
    private String printFormat;

    /**
     *
     */
    @Column(name = "MOD_EFF_TYPE")
    private String modEffType;

    /**
     * 记录属性规格值长度
     */
    @Column(name = "ATTR_LENGTH")
    private Long attrLength;

    /**
     * 描述记录物理的变更时间，精确到纳秒级别
     */
    @Column(name = "DTIMESTAMP")
    private Long dtimestamp;

    /**
     * LOVE,当属性值分类为输入型时，属性值数据类型为日期型、日期时间型、字符型、数值型等
     */
    @Column(name = "ATTR_VALUE_DATA_TYPE")
    private String attrValueDataType;

    /**
     * 记录属性规格默认取值
     */
    @Column(name = "DEFAULT_VALUE")
    private String defaultValue;

    /**
     *
     */
    @Column(name = "SEQ_NAME")
    private String seqName;

    /**
     * 2.0集团规范字段目前仅有一个值ATTR，用于集团下发销售品属性区分
     */
    @Column(name = "ATTR_SPEC_EXT_RULE")
    private String attrSpecExtRule;

    /**
     *
     */
    @Column(name = "EXPIRE_TYPE")
    private String expireType;

    @Override
    public void setAttrId(Long attrId) {
        this.attrId = attrId;
    }

    @Override
    public Long getAttrId() {
        return this.attrId;
    }

    @Override
    public void setRegionCd(Long regionCd) {
        this.regionCd = regionCd;
    }

    @Override
    public Long getRegionCd() {
        return this.regionCd;
    }

    @Override
    public void setStartValue(String startValue) {
        this.startValue = startValue;
    }

    @Override
    public String getStartValue() {
        return this.startValue;
    }

    @Override
    public void setAddEffType(String addEffType) {
        this.addEffType = addEffType;
    }

    @Override
    public String getAddEffType() {
        return this.addEffType;
    }

    @Override
    public void setCnsTypeExtra(String cnsTypeExtra) {
        this.cnsTypeExtra = cnsTypeExtra;
    }

    @Override
    public String getCnsTypeExtra() {
        return this.cnsTypeExtra;
    }

    @Override
    public void setIsUnique(String isUnique) {
        this.isUnique = isUnique;
    }

    @Override
    public String getIsUnique() {
        return this.isUnique;
    }

    @Override
    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String getRemark() {
        return this.remark;
    }

    @Override
    public void setExtAttrCd(String extAttrCd) {
        this.extAttrCd = extAttrCd;
    }

    @Override
    public String getExtAttrCd() {
        return this.extAttrCd;
    }

    @Override
    public void setAttrLevel(String attrLevel) {
        this.attrLevel = attrLevel;
    }

    @Override
    public String getAttrLevel() {
        return this.attrLevel;
    }

    @Override
    public void setStatusDate(Timestamp statusDate) {
        this.statusDate = statusDate;
    }

    @Override
    public Timestamp getStatusDate() {
        return this.statusDate;
    }

    @Override
    public void setAttrFormat(String attrFormat) {
        this.attrFormat = attrFormat;
    }

    @Override
    public String getAttrFormat() {
        return this.attrFormat;
    }

    @Override
    public void setAttrNbr(String attrNbr) {
        this.attrNbr = attrNbr;
    }

    @Override
    public String getAttrNbr() {
        return this.attrNbr;
    }

    @Override
    public void setIsNullable(String isNullable) {
        this.isNullable = isNullable;
    }

    @Override
    public String getIsNullable() {
        return this.isNullable;
    }

    @Override
    public void setCodeBuilder(String codeBuilder) {
        this.codeBuilder = codeBuilder;
    }

    @Override
    public String getCodeBuilder() {
        return this.codeBuilder;
    }

    @Override
    public void setRelShardingId(Long relShardingId) {
        this.relShardingId = relShardingId;
    }

    @Override
    public Long getRelShardingId() {
        return this.relShardingId;
    }

    @Override
    public void setGroupCd(String groupCd) {
        this.groupCd = groupCd;
    }

    @Override
    public String getGroupCd() {
        return this.groupCd;
    }

    @Override
    public void setPrintExt(String printExt) {
        this.printExt = printExt;
    }

    @Override
    public String getPrintExt() {
        return this.printExt;
    }

    @Override
    public void setIsMultiValue(Long isMultiValue) {
        this.isMultiValue = isMultiValue;
    }

    @Override
    public Long getIsMultiValue() {
        return this.isMultiValue;
    }

    @Override
    public void setAttrIoType(String attrIoType) {
        this.attrIoType = attrIoType;
    }

    @Override
    public String getAttrIoType() {
        return this.attrIoType;
    }

    @Override
    public void setRecUpdateDate(Timestamp recUpdateDate) {
        this.recUpdateDate = recUpdateDate;
    }

    @Override
    public Timestamp getRecUpdateDate() {
        return this.recUpdateDate;
    }

    @Override
    public void setShardingId(Long shardingId) {
        this.shardingId = shardingId;
    }

    @Override
    public Long getShardingId() {
        return this.shardingId;
    }

    @Override
    public void setCompleteAction(String completeAction) {
        this.completeAction = completeAction;
    }

    @Override
    public String getCompleteAction() {
        return this.completeAction;
    }

    @Override
    public void setCodeParam(String codeParam) {
        this.codeParam = codeParam;
    }

    @Override
    public String getCodeParam() {
        return this.codeParam;
    }

    @Override
    public void setExtFlag(String extFlag) {
        this.extFlag = extFlag;
    }

    @Override
    public String getExtFlag() {
        return this.extFlag;
    }

    @Override
    public void setIsTrans(String isTrans) {
        this.isTrans = isTrans;
    }

    @Override
    public String getIsTrans() {
        return this.isTrans;
    }

    @Override
    public void setAttrSort(Long attrSort) {
        this.attrSort = attrSort;
    }

    @Override
    public Long getAttrSort() {
        return this.attrSort;
    }

    @Override
    public void setDversion(Long dversion) {
        this.dversion = dversion;
    }

    @Override
    public Long getDversion() {
        return this.dversion;
    }

    @Override
    public void setHbPost(String hbPost) {
        this.hbPost = hbPost;
    }

    @Override
    public String getHbPost() {
        return this.hbPost;
    }

    @Override
    public void setAttrValueType(String attrValueType) {
        this.attrValueType = attrValueType;
    }

    @Override
    public String getAttrValueType() {
        return this.attrValueType;
    }

    @Override
    public void setStatusCd(String statusCd) {
        this.statusCd = statusCd;
    }

    @Override
    public String getStatusCd() {
        return this.statusCd;
    }

    @Override
    public void setPfPost(String pfPost) {
        this.pfPost = pfPost;
    }

    @Override
    public String getPfPost() {
        return this.pfPost;
    }

    @Override
    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Override
    public Timestamp getCreateDate() {
        return this.createDate;
    }

    @Override
    public void setRefBusyTypeId(Long refBusyTypeId) {
        this.refBusyTypeId = refBusyTypeId;
    }

    @Override
    public Long getRefBusyTypeId() {
        return this.refBusyTypeId;
    }

    @Override
    public void setIsVisible(String isVisible) {
        this.isVisible = isVisible;
    }

    @Override
    public String getIsVisible() {
        return this.isVisible;
    }

    @Override
    public void setBusiTypeId(Long busiTypeId) {
        this.busiTypeId = busiTypeId;
    }

    @Override
    public Long getBusiTypeId() {
        return this.busiTypeId;
    }

    @Override
    public void setAttrName(String attrName) {
        this.attrName = attrName;
    }

    @Override
    public String getAttrName() {
        return this.attrName;
    }

    @Override
    public void setParAttrId(Long parAttrId) {
        this.parAttrId = parAttrId;
    }

    @Override
    public Long getParAttrId() {
        return this.parAttrId;
    }

    @Override
    public void setCreateStaff(Long createStaff) {
        this.createStaff = createStaff;
    }

    @Override
    public Long getCreateStaff() {
        return this.createStaff;
    }

    @Override
    public void setUpdateDate(Timestamp updateDate) {
        this.updateDate = updateDate;
    }

    @Override
    public Timestamp getUpdateDate() {
        return this.updateDate;
    }

    @Override
    public void setAttrDesc(String attrDesc) {
        this.attrDesc = attrDesc;
    }

    @Override
    public String getAttrDesc() {
        return this.attrDesc;
    }

    @Override
    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    @Override
    public Long getAreaId() {
        return this.areaId;
    }

    @Override
    public void setIsDanyAttr(String isDanyAttr) {
        this.isDanyAttr = isDanyAttr;
    }

    @Override
    public String getIsDanyAttr() {
        return this.isDanyAttr;
    }

    @Override
    public void setUpdateStaff(Long updateStaff) {
        this.updateStaff = updateStaff;
    }

    @Override
    public Long getUpdateStaff() {
        return this.updateStaff;
    }

    @Override
    public void setProcType(String procType) {
        this.procType = procType;
    }

    @Override
    public String getProcType() {
        return this.procType;
    }

    @Override
    public void setEndValue(String endValue) {
        this.endValue = endValue;
    }

    @Override
    public String getEndValue() {
        return this.endValue;
    }

    @Override
    public void setDefaultTypePeriod(String defaultTypePeriod) {
        this.defaultTypePeriod = defaultTypePeriod;
    }

    @Override
    public String getDefaultTypePeriod() {
        return this.defaultTypePeriod;
    }

    @Override
    public void setOwnerApp(String ownerApp) {
        this.ownerApp = ownerApp;
    }

    @Override
    public String getOwnerApp() {
        return this.ownerApp;
    }

    @Override
    public void setAttrPersistType(String attrPersistType) {
        this.attrPersistType = attrPersistType;
    }

    @Override
    public String getAttrPersistType() {
        return this.attrPersistType;
    }

    @Override
    public void setPrintFormat(String printFormat) {
        this.printFormat = printFormat;
    }

    @Override
    public String getPrintFormat() {
        return this.printFormat;
    }

    @Override
    public void setModEffType(String modEffType) {
        this.modEffType = modEffType;
    }

    @Override
    public String getModEffType() {
        return this.modEffType;
    }

    @Override
    public void setAttrLength(Long attrLength) {
        this.attrLength = attrLength;
    }

    @Override
    public Long getAttrLength() {
        return this.attrLength;
    }

    @Override
    public void setDtimestamp(Long dtimestamp) {
        this.dtimestamp = dtimestamp;
    }

    @Override
    public Long getDtimestamp() {
        return this.dtimestamp;
    }

    @Override
    public void setAttrValueDataType(String attrValueDataType) {
        this.attrValueDataType = attrValueDataType;
    }

    @Override
    public String getAttrValueDataType() {
        return this.attrValueDataType;
    }

    @Override
    public void setDefaultValue(String defaultValue) {
        this.defaultValue = defaultValue;
    }

    @Override
    public String getDefaultValue() {
        return this.defaultValue;
    }

    @Override
    public void setSeqName(String seqName) {
        this.seqName = seqName;
    }

    @Override
    public String getSeqName() {
        return this.seqName;
    }

    @Override
    public void setAttrSpecExtRule(String attrSpecExtRule) {
        this.attrSpecExtRule = attrSpecExtRule;
    }

    @Override
    public String getAttrSpecExtRule() {
        return this.attrSpecExtRule;
    }

    @Override
    public void setExpireType(String expireType) {
        this.expireType = expireType;
    }

    @Override
    public String getExpireType() {
        return this.expireType;
    }

    @Override
    public Long getId() {
        return attrId;
    }

    @Override
    public void setId(Long id) {
        this.attrId = id;
    }

    public AttrSpec2() {
        super();
    }

    public AttrSpec2(boolean genId) {
        if (genId) {
            setId(genEnttId());
        }
    }

    public static IAttrSpec2Repository repository() {
        return (IAttrSpec2Repository) RepositoryRegister.getInstance().getRepository(AttrSpec2.class);
    }

    @Override
    public boolean isUseMeta() {
        return false;
    }
}
