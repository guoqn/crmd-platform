package com.ffcs.crmd.platform.meta.constants;

/**
 * @author LAIYONGMIN
 *
 */
public class MetaConstants {

    /** 公共字段状态 */
    public interface STATUS {
        /** 有效 */
        String META_STATUS_VALID = "1000";

        /** 无效 */
        String META_STATUS_INVALID = "1100";
    }

    /**属性级别*/
    public interface ATTR_LEVEL {
        /** 集团规范级 */
        String GROUP    = "0";
        /**核心版本级 */
        String CORE     = "1";
        /** 省实施级 */
        String PROVINCE = "2";
    }

    /** 管理级别 */
    public interface MANAGE_GRAND {
        /** 集团级别 */
        String GROUP    = "10";
        /** 省级别 */
        String PROVINCE = "11";
    }

    /** 约束类型 */
    public interface PROC_TYPE {
        /** 套餐档次 */
        String GD = "GD";
        /** 非约 */
        String NA = "NA";
        /** 禁止转义 */
        String NC = "NC";
        /** 名字 */
        String NM = "NM";
        /** 子订单行 */
        String OT = "OT";
        /** 主键 */
        String PK = "PK";
        /** 权限限制 */
        String QX = "QX";
        /** 参考 */
        String RK = "RK";
        /** 备注 */
        String RM = "RM";
        /** 细分类型 */
        String ST = "ST";
        /** 营销统计 */
        String TJ = "TJ";

    }

    /** 新增生效方式 */
    public interface EFFECTIVE_TYPE {
        /** 立即生效 */
        String TYPE_0 = "0";
        /** 次月生效 */
        String TYPE_1 = "1";
        /** 当月生效 */
        String TYPE_2 = "2";
        /** 次月16日生效 */
        String TYPE_3 = "3";
    }

    /** 变更生效方式 */
    public interface MOD_EFF_TYPE {
        /** 立即生效 */
        String TYPE_0 = "0";
        /** 次月生效 */
        String TYPE_1 = "1";
        /** 当月生效 */
        String TYPE_2 = "2";
        /** 次月16日生效 */
        String TYPE_3 = "3";
    }

    /** 属性失效方式 */
    public interface EXPIRE_TYPE {
        /** 立即失效 */
        String TYPE_0 = "0";
        /** 次月失效 */
        String TYPE_1 = "1";
        /** 下个月15号失效 */
        String TYPE_2 = "12";
        /** 当月失效 */
        String TYPE_3 = "2";
        /** 完工立即失效 */
        String TYPE_4 = "3";
    }

    /** 打印类型 */
    public interface PRINT_FORMATER {
        /** 不打印 */
        String TYPE_0 = "0";
        /** 打印 */
        String TYPE_1 = "1";
        /** 暗码打印 */
        String TYPE_2 = "2";
        /** 勾选框打印 */
        String TYPE_3 = "3";
        /** 金额类型打印 */
        String TYPE_4 = "4";
        /** 折扣类型打印 */
        String TYPE_5 = "5";
        /** 可逆密码 */
        String TYPE_6 = "6";
        /** 分钟类型打印 */
        String TYPE_7 = "7";
    }

    public interface OBJ_TYPE {
        String BUSY_OBJ = "busi_obj";
    }

    public interface SYS_TABLE_TYPE {
        String TABLE_TYPE_CROSS_TABLE = "CR";

        String TABLE_TYPE_VERTICAL_TABLE = "VR";
    }

    public interface SYS_COLUMN_SHARDING_LEVEL {
        //库内分表
        Long INNER_SHARDING = 1L;

        //分片表
        Long TABLE_SHARDING = 2L;

        //库内分表+分片
        Long INNER_AND_TABLE_SHARDING = 3L;
    }

    public interface BUSI_TYPE_UPDATE_LOG_LEVEL {
        String NO_LOG = "0";

        String LOGGING = "1";
    }

    public interface BUSI_TYPE_DELETE_LOG_LEVEL {
        String NO_LOG = "0";

        String LOGGING = "1";
    }

    public interface ATTR_SPEC_IS_DANY_ATTR {
        String TRUE = "1";

        String FALSE = "0";
    }
}
