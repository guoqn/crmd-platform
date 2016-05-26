package com.ffcs.crmd.platform.meta.repository.impl;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.core.ddd.repository.impl.AbstractCrmDomBaseRepository;
import com.ffcs.crmd.platform.meta.constants.MetaConstants;
import com.ffcs.crmd.platform.meta.entity.AttrValue2;
import com.ffcs.crmd.platform.meta.repository.IAttrValue2Repository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("attrValue2Repository")
public class AttrValue2ImplRepository extends AbstractCrmDomBaseRepository<AttrValue2, Long>
		implements IAttrValue2Repository {

	public AttrValue2ImplRepository() {
		super(AttrValue2.class);
	}

	@SuppressWarnings("unchecked")
	@Override
	public PageInfo<AttrValue2> qryAttrValuePageByAttrId(Long attrId, Long parentValueId, int pageNum, int pageSize) {
		List<Object> params = new ArrayList<>();
		params.add(attrId);
		params.add(parentValueId);
		return this.jdbcFindPageInfoByName("attrValue2Repository.getAttrValuesBySpecId", AttrValue2.class, params,
				pageNum, pageSize);
	}

	@Override
	public List<AttrValue2> qryAttrValuesByAttrId(Long attrId) {
		if (attrId == 0) {
			return null;
		}
		List<Object> params = new ArrayList<>();
		params.add(attrId);
		params.add(MetaConstants.STATUS.META_STATUS_VALID);
		return this.jdbcFindListByName("attrValue2Repository.qryAttrValuesByAttrId", AttrValue2.class, params);
	}
}
