package com.ffcs.crmd.platform.meta.client;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ctg.itrdc.event.utils.JSONUtils;
import com.ctg.itrdc.platform.common.utils.type.DateUtils;
import com.ffcs.crmd.platform.meta.entity.AttrSpec;
import com.ffcs.crmd.platform.meta.entity.AttrValue;
import com.ffcs.crmd.platform.meta.repository.IAttrSpecRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:conf/spring/applicationContext*.xml",
		"classpath*:conf/spring/**/applicationContext*.xml" })
public class SqlBuildTest {

	@Autowired
	IAttrSpecRepository specRepository;

	@Test
	public void checkNotAllParam() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("attr_name", "延期生效订单");
		params.put("status_cd", "1000");
		specRepository.queryListByName("attrSpecRepositorytest.method01", AttrSpec.class, params);
	}

	@Test
	public void checkLikeParam() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("attr_name", "延期");
		specRepository.queryListByName("attrSpecRepositorytest.method02", AttrSpec.class, params);
	}

	@Test
	public void checkListParam() {
		Map<String, Object> params = new HashMap<String, Object>();
		List<Object> obj = new ArrayList<Object>();
		obj.add(900020066);
		obj.add(-800034313);
		params.put("attr_ids", obj);
		specRepository.queryListByName("attrSpecRepositorytest.method03", AttrSpec.class, params);
	}

	@Test
	public void checkIncludeSqlInParam() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("java_code", "-800034313");
		specRepository.queryListByName("attrSpecRepositorytest.method04", AttrSpec.class, params);
	}

	@Test
	public void checkIncludeSqlOutParam() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("class_id", "-800034313");
		specRepository.queryListByName("attrSpecRepositorytest.method04", AttrSpec.class, params);
	}

	@Test
	public void checkPageMethod() {
		Map<String, Object> params = new HashMap<String, Object>();
		List<Object> obj = new ArrayList<Object>();
		obj.add(900020066);
		obj.add(-800034313);
		params.put("attr_ids", obj);
		specRepository.queryPageInfoByName("attrSpecRepositorytest.method03", AttrSpec.class, params, 1, 10);
	}

	@Test
	public void checkTypeEqualSql() {
		List<Object> params = new ArrayList<Object>();
		params.add(-1);
		specRepository.jdbcFindListByName("attrSpecRepositorytest.method05", AttrSpec.class, params);
	}

	@Test
	public void checkAtferWhereHavCondition() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("attr_id", "800034399");
		specRepository.queryListByName("attrSpecRepositorytest.method06", AttrValue.class, params);
	}

	@Test
	public void checkNotParam() {
		Map<String, Object> params = new HashMap<String, Object>();
		specRepository.queryListByName("attrSpecRepositorytest.method01", AttrSpec.class, params);
	}

	@Test
	public void checkContainsExistsNotParam() {
		Map<String, Object> params = new HashMap<String, Object>();
		specRepository.queryPageInfoByName("attrSpecRepositorytest.method07", AttrSpec.class, params, 1, 1);
	}

	@Test
	public void checkContainsExistsHavParam() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("attrId2", "1");
		specRepository.queryPageInfoByName("attrSpecRepositorytest.method07", AttrSpec.class, params, 1, 1);
	}

	@Test
	public void checkContainsExistsBeforeHavParam() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("attrId", "1");
		params.put("attrId2", "1");
		specRepository.queryPageInfoByName("attrSpecRepositorytest.method07", AttrSpec.class, params, 1, 1);
	}

	@Test
	public void checkContainsExistsAfterHavParam() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("javaCode", "1");
		params.put("attrId2", "1");
		specRepository.queryPageInfoByName("attrSpecRepositorytest.method07", AttrSpec.class, params, 1, 1);
	}

	@Test
	public void checkContainsExistsOnlyAfterHavParam() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("javaCode", "1");
		specRepository.queryPageInfoByName("attrSpecRepositorytest.method07", AttrSpec.class, params, 1, 1);
	}

	@Test
	public void checkContainsExistsOnlyBeforeHavParam() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("attrId", "1");
		specRepository.queryPageInfoByName("attrSpecRepositorytest.method07", AttrSpec.class, params, 1, 1);
	}

	@Test
	public void checkLambdaParam() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("attrId", "1");
		params.put("attrId2", "4");
		params.put("createDate", DateUtils.formatDate(DateUtils.getCurDate(), DateUtils.YYYYMMDD));
		params.put("orderclumn", "attr_id");
		params.put("desc", "desc");
		specRepository.queryPageInfoByName("attrSpecRepositorytest.method08", AttrSpec.class, params, 1, 1);
	}

	@Test
	public void checkSampleBetween() {
		Map<String, Object> params = new HashMap<String, Object>();
		List<Object> attrIds = new ArrayList<Object>();
		attrIds.add(-900020067);
		attrIds.add(-900020066);
		params.put("attrIds", attrIds);
		List<AttrSpec> spec = specRepository.queryListByName("attrSpecRepositorytest.sampleBetween", AttrSpec.class,
				params);
		System.out.println(JSONUtils.listToJsonString(spec, null));
	}

	@Test
	public void checkBetween() {
		Map<String, Object> params = new HashMap<String, Object>();
		List<Object> attrIds = new ArrayList<Object>();
		attrIds.add(-900020067);
		attrIds.add(-900020066);
		params.put("attrIds", attrIds);
		List<AttrSpec> spec = specRepository.queryListByName("attrSpecRepositorytest.between", AttrSpec.class, params);
		System.out.println(JSONUtils.listToJsonString(spec, null));
	}

}
