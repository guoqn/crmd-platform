package com.ffcs.crmd.platform.meta.api.vo;

import com.ffcs.crmd.platform.pub.vo.ConditionVo;

import java.sql.Timestamp;

public class RelSpecVo extends ConditionVo {

    /**
     * 记录关系规格主键
     */
    private Long relSpecId;

    /**
     * 描述记录删除到历史表的时间，在用表一般为空
     */
    private Timestamp recUpdateDate;

    /**
     * 描述记录所属的C4区域标识
     */
    private Long regionCd;

    /**
     * 描述记录的分片键
     */
    private Long shardingId;

    /**
     * 记录Z端对象主键
     */
    private Long zObjId;

    /**
     * LOVB,记录关系类型
     */
    private String relType;

    /**
     * 描述记录所属的C3区域标识
     */
    private Long areaId;

    /**
     * 记录A端对象主键
     */
    private Long aObjId;

    /**
     * 描述关联表对端的分片键
     */
    private Long relShardingId;

    public void setRelSpecId(Long relSpecId) {
        this.relSpecId = relSpecId;
    }

    public Long getRelSpecId() {
        return this.relSpecId;
    }

    public void setRecUpdateDate(Timestamp recUpdateDate) {
        this.recUpdateDate = recUpdateDate;
    }

    public Timestamp getRecUpdateDate() {
        return this.recUpdateDate;
    }

    public void setRegionCd(Long regionCd) {
        this.regionCd = regionCd;
    }

    public Long getRegionCd() {
        return this.regionCd;
    }

    public void setShardingId(Long shardingId) {
        this.shardingId = shardingId;
    }

    public Long getShardingId() {
        return this.shardingId;
    }

    public void setzObjId(Long zObjId) {
        this.zObjId = zObjId;
    }

    public Long getzObjId() {
        return this.zObjId;
    }

    public void setRelType(String relType) {
        this.relType = relType;
    }

    public String getRelType() {
        return this.relType;
    }

    public void setAreaId(Long areaId) {
        this.areaId = areaId;
    }

    public Long getAreaId() {
        return this.areaId;
    }

    public void setaObjId(Long aObjId) {
        this.aObjId = aObjId;
    }

    public Long getaObjId() {
        return this.aObjId;
    }

    public void setRelShardingId(Long relShardingId) {
        this.relShardingId = relShardingId;
    }

    public Long getRelShardingId() {
        return this.relShardingId;
    }

}
