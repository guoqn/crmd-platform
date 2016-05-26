package com.ffcs.crmd.platform.data.utils;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import javax.persistence.Table;

import com.ctg.itrdc.platform.common.exception.RtManagerException;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ctg.itrdc.platform.data.entity.ClassInfoUtils;
import com.ctg.itrdc.platform.data.entity.ColumnInfo;
import com.ctg.itrdc.platform.pub.entity.BaseEntity;
import com.ffcs.crmd.platform.data.ddl.SeqServiceFactory;
import com.ffcs.crmd.platform.ddl.api.ICrmSeqService;
import com.ffcs.crmd.platform.meta.intf.IMetaEntity;
import com.ffcs.crmd.platform.meta.provider.ITableMetaData;

public class CrmEntityUtils {
	private static ConcurrentMap<Class<?>, String> seqMap = new ConcurrentHashMap<Class<?>, String>();

	private static ICrmSeqService iCrmSeqService = SeqServiceFactory.getSeqService();

	public static String getGlobalSeqName(BaseEntity entity) {
		if (entity == null) {
			throw new RtManagerException("对象不能为空");
		}
		if (!seqMap.containsKey(entity.getClass())) {
			String seq = "";
			if (entity instanceof IMetaEntity && ((IMetaEntity) entity).isUseMeta()) {
				ITableMetaData tableMetaData = ((IMetaEntity) entity).readTableMeta();
				seq = tableMetaData.getPkAttr().readSeqName();
			}
			if (StringUtils.isNullOrEmpty(seq)) {
				seq = getSeqNameForAnnotation(entity);
			}
			seqMap.put(entity.getClass(), seq);
		}
		return seqMap.get(entity.getClass());
	}

	private static String getSeqNameForAnnotation(BaseEntity entity) {
		String seq = "";

		Table t = entity.getClass().getAnnotation(Table.class);
		if (t != null && !StringUtils.isNullOrEmpty(t.name())) {
			seq = "SEQ_" + t.name() + "_ID";
			seq = seq.toUpperCase();
		} else {
			seq = "SEQ_GLOBAL_ID";
		}
		return seq;
	}

	public static Long getSeq(String seqName) {
		if (iCrmSeqService == null) {
			throw new RtManagerException("序列服务不存在");
		}
		return iCrmSeqService.getSeq(seqName);
	}

	/**
	 * 
	 * 获取分片键值.
	 * 
	 * @param entity
	 * @return
	 */
	public static Object getShardingId(Object entity) {
		if (entity == null) {
			throw new RtManagerException("对象不能为空");
		}
		List<ColumnInfo> columnList = ClassInfoUtils.getColumnMap().get(entity.getClass());
		if (columnList == null || columnList.size() == 0) {
			throw new RtManagerException("类：" + entity.getClass().getName() + "字段描述不存在");
		}
		Object value = null;
		for (ColumnInfo column : columnList) {
			if (column.isSharding()) {
				value = ClassInfoUtils.getValues(entity, column.getFiledName());
				break;
			}
		}
		return value;
	}
}
