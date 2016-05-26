package com.ffcs.crmd.platform.meta.entity;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

import com.ctg.itrdc.platform.pub.annotations.ShardingBean;
import com.ctg.itrdc.platform.pub.annotations.ShardingId;
import com.ffcs.crmd.platform.core.ddd.entity.impl.AbstractCrmDomBaseEntityImpl;
import com.ffcs.crmd.platform.core.ddd.repository.RepositoryRegister;
import com.ffcs.crmd.platform.meta.repository.IDynamicEventRepository;


@ShardingBean
@Table(name = "DYNAMIC_EVENT")
public class DynamicEvent extends AbstractCrmDomBaseEntityImpl<Long> {

	private static final long serialVersionUID = -2811347047325737314L;


	/**
	 * 事件ID
	 */
	@Id
	@Column(name = "EVENT_ID")
	private Long eventId;

	/**
	 * 分片键
	 */
	@ShardingId
	@Column(name = "SHARDING_ID")
	private Long shardingId;

	/**
	 * 事件对象序号
	 */
	@Column(name = "BUS_OBJ_ID")
	private Long busObjId;

	/**
	 * 业务区域
	 */
	@Column(name = "BUS_REGION")
	private Long busRegion;

	/**
	 * 创建记录的员工标识
	 */
	@Column(name = "CREATE_STAFF")
	private Long createStaff;

	/**
	 * 修改时间
	 */
	@Column(name = "UPDATE_DATE")
	private Timestamp updateDate;

	/**
	 * 备注
	 */
	@Column(name = "REMARK")
	private String remark;

	/**
	 * 被应用程序更新的时间
	 */
	@Column(name = "STATUS_DATE")
	private Timestamp statusDate;

	/**
	 * 租户标识
	 */
	@Column(name = "TENANT_ID")
	private Long tenantId;

	/**
	 * 业务规格
	 */
	@Column(name = "BUS_SPEC")
	private Long busSpec;

	/**
	 * 更新记录的员工标识
	 */
	@Column(name = "UPDATE_STAFF")
	private Long updateStaff;

	/**
	 * 业务渠道
	 */
	@Column(name = "BUS_CHANNEL")
	private Long busChannel;

	/**
	 * 业务类型
	 */
	@Column(name = "BUS_TYPE")
	private String busType;

	/**
	 * 状态：1000有效1100无效
	 */
	@Column(name = "STATUS_CD")
	private String statusCd;

	/**
	 * 业务服务
	 */
	@Column(name = "BUS_SERVICE")
	private Long busService;

	/**
	 * 创建时间
	 */
	@Column(name = "CREATE_DATE")
	private Timestamp createDate;


	public void setEventId(Long eventId){
		this.eventId = eventId;
	}

	public Long getEventId(){
		return this.eventId;
	}

	public void setShardingId(Long shardingId){
		this.shardingId = shardingId;
	}

	public Long getShardingId(){
		return this.shardingId;
	}

	public void setBusObjId(Long busObjId){
		this.busObjId = busObjId;
	}

	public Long getBusObjId(){
		return this.busObjId;
	}

	public void setBusRegion(Long busRegion){
		this.busRegion = busRegion;
	}

	public Long getBusRegion(){
		return this.busRegion;
	}

	public void setCreateStaff(Long createStaff){
		this.createStaff = createStaff;
	}

	public Long getCreateStaff(){
		return this.createStaff;
	}

	public void setUpdateDate(Timestamp updateDate){
		this.updateDate = updateDate;
	}

	public Timestamp getUpdateDate(){
		return this.updateDate;
	}

	public void setRemark(String remark){
		this.remark = remark;
	}

	public String getRemark(){
		return this.remark;
	}

	public void setStatusDate(Timestamp statusDate){
		this.statusDate = statusDate;
	}

	public Timestamp getStatusDate(){
		return this.statusDate;
	}

	public void setTenantId(Long tenantId){
		this.tenantId = tenantId;
	}

	public Long getTenantId(){
		return this.tenantId;
	}

	public void setBusSpec(Long busSpec){
		this.busSpec = busSpec;
	}

	public Long getBusSpec(){
		return this.busSpec;
	}

	public void setUpdateStaff(Long updateStaff){
		this.updateStaff = updateStaff;
	}

	public Long getUpdateStaff(){
		return this.updateStaff;
	}

	public void setBusChannel(Long busChannel){
		this.busChannel = busChannel;
	}

	public Long getBusChannel(){
		return this.busChannel;
	}

	public void setBusType(String busType){
		this.busType = busType;
	}

	public String getBusType(){
		return this.busType;
	}

	public void setStatusCd(String statusCd){
		this.statusCd = statusCd;
	}

	public String getStatusCd(){
		return this.statusCd;
	}

	public void setBusService(Long busService){
		this.busService = busService;
	}

	public Long getBusService(){
		return this.busService;
	}

	public void setCreateDate(Timestamp createDate){
		this.createDate = createDate;
	}

	public Timestamp getCreateDate(){
		return this.createDate;
	}


	public Long getId() {
		return eventId;
	}

	public void setId(Long id) {
		this.eventId = id;
	}
	
	public DynamicEvent() {
		super();
    }

    public DynamicEvent(boolean genId) {
        if (genId) {
			setId(genEnttId());
		}
    }

	public static IDynamicEventRepository repository() {
		return (IDynamicEventRepository) RepositoryRegister.getInstance()
				.getRepository(DynamicEvent.class);
	}
	
}
