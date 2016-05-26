package com.ffcs.crmd.platform.pub.facade;

import java.util.ArrayList;
import java.util.List;

import com.ctg.itrdc.platform.common.utils.type.NumberUtils;
import com.ctg.itrdc.platform.pub.constant.BaseUnitConstants;
import com.ctg.itrdc.platform.pub.context.SessionContext;
import com.ffcs.crmd.platform.pub.ex.BaseAppException;
import com.ffcs.crmd.platform.pub.ex.ExType;

public class CrmSessionContext {

    public static final String       STAFF_ID          = "staffId";

    public static final String       ORG_ID            = "orgId";

    public static final String       REGION_ID         = "regionId";

    public static final String       WARNINGS          = "WARNINGS";

    /**
     * 事务处理状态
     */
    public static final String       SYS_WORK_STATUS   = "sysWorkStatus";

    /**
     * 事务事件集编码
     */
    public static final String       SYS_WORK_SHEET_CD = "sysWorkSheetCd";

    /**
     * 事务事件集对象
     */
    public static final String       SYS_WORK_ITEM_OBJ = "sysWorkItemObj";

    public static final String       RW_BALANCE        = BaseUnitConstants.SERVICE_DEF_PROP + "-rw";

    public static final String       RW_BALANCE_READ   = "R";
    public static final String       RW_BALANCE_WRITE  = "W";


    private static CrmSessionContext crmSessionContext = new CrmSessionContext();

    public static CrmSessionContext getContext() {
        return crmSessionContext;
    }

    public Long getStaffId() {
        Object obj = SessionContext.getValue(STAFF_ID);
        if (obj == null) {
            return null;
        }
        return NumberUtils.nullToLongZero(obj);
    }

    public void setStaffId(Long staffId) {
        SessionContext.setValue(STAFF_ID, staffId);
    }

    public Long getOrgId() {
        Object obj = SessionContext.getValue(ORG_ID);
        if (obj == null) {
            return null;
        }
        return NumberUtils.nullToLongZero(obj);
    }

    public void setOrgId(Long staffId) {
        SessionContext.setValue(ORG_ID, staffId);
    }

    public Long getRegionId() {
        Object obj = SessionContext.getValue(REGION_ID);
        if (obj == null) {
            return null;
        }
        return NumberUtils.nullToLongZero(obj);
    }

    public void setRegionId(Long staffId) {
        SessionContext.setValue(REGION_ID, staffId);
    }

    /**
     * 保存提示类异常
     * .
     * @param warning 提示类异常
     */
    @SuppressWarnings("unchecked")
    public static void addWarning(BaseAppException warning) {
        // 判断是否为提示类异常，如果不是则直接抛出异常、
        if (!ExType.WARNING.equals(warning.getExType())) {
            throw warning;
        }

        List<BaseAppException> warnings = (List<BaseAppException>) SessionContext
            .getValue(WARNINGS);
        if (warnings == null) {
            warnings = new ArrayList<BaseAppException>();
        }

        warnings.add(warning);
        SessionContext.setValue(WARNINGS, warnings);
    }

    public static void addWarnings(List<BaseAppException> warnings) {
        if (warnings != null && !warnings.isEmpty()) {
            for (BaseAppException warning : warnings) {
                addWarning(warning);
            }
        }
    }

    /**
     * 获取提示类异常
     * .
     * @return
     */
    @SuppressWarnings("unchecked")
    public static List<BaseAppException> getWarnings() {
        List<BaseAppException> warnings = (List<BaseAppException>) SessionContext
            .getValue(WARNINGS);
        if (warnings == null) {
            warnings = new ArrayList<BaseAppException>();
            SessionContext.setValue(WARNINGS, warnings);
        }

        return warnings;
    }

    /**
     *
     * 添加幂等性操作对象.
     *
     * @param sysWorkItemObj
     */
    @SuppressWarnings("unchecked")
    public void addSysWorkItemObj(Object sysWorkItemObj) {
        List<Object> list = (List<Object>) SessionContext.getValue(SYS_WORK_ITEM_OBJ);
        if (list == null) {
            list = new ArrayList<Object>();
            SessionContext.setValue(SYS_WORK_ITEM_OBJ, list);
        }
        list.add(sysWorkItemObj);
    }

    /**
     *
     * 返回幂等性缓存信息.
     *
     * @return
     */
    @SuppressWarnings("unchecked")
    public List<Object> getSysWorkItemObjList() {
        return (List<Object>) SessionContext.getValue(SYS_WORK_ITEM_OBJ);
    }

    /**
     *
     * 清空分布式事务幂等性缓存信息.
     *
     */
    public void clearSysWorkSheet() {
        //清空处理状态
        SessionContext.removeValue(SYS_WORK_STATUS);
        //清空操作对象列表
        SessionContext.removeValue(SYS_WORK_ITEM_OBJ);
        //请客事务事件集编码
        SessionContext.removeValue(SYS_WORK_SHEET_CD);
    }

    public void setSysWorkStatus(String sysWorkStatus) {
        SessionContext.setValue(SYS_WORK_STATUS, sysWorkStatus);
    }

    public String getSysWorkStatus() {
        return (String) SessionContext.getValue(SYS_WORK_STATUS);
    }

    public void setSysWorkSheetCd(String sysWorkSheetCd) {
        SessionContext.setValue(SYS_WORK_SHEET_CD, sysWorkSheetCd);
    }

    public String getSysWorkSheetCd() {
        return (String) SessionContext.getValue(SYS_WORK_SHEET_CD);
    }

    public void openForceReadFlag() {
        SessionContext.setObject2TreadLocal(RW_BALANCE,RW_BALANCE_READ);
    }

    public boolean isOpenForceReadFlag() {
        return RW_BALANCE_READ.equals(SessionContext.getObject4TreadLocal(RW_BALANCE));
    }

    public Object getValue4Thread(String key) {
        return SessionContext.getObject4TreadLocal(key);
    }

    public void setObject2Thread(String key,Object value) {
        SessionContext.setObject2TreadLocal(key,value);
    }
}
