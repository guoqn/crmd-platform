package com.ffcs.crmd.platform.meta.control;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ffcs.crmd.platform.control.AbstractController;
import com.ffcs.crmd.platform.meta.api.dto.SysColumnDTO;
import com.ffcs.crmd.platform.meta.api.dto.SysTableDTO;
import com.ffcs.crmd.platform.meta.api.facade.ISysColumnFacade;
import com.ffcs.crmd.platform.meta.api.facade.ISysTableFacade;
import com.ffcs.crmd.platform.meta.vo.MetaQryParamsVo;
import com.ffcs.crmd.platform.pub.vo.RetVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 元数据配置
 * Created by FFCS-CAIWL on 2015/12/28.
 */
@Controller
@RequestMapping("/meta/metaQuery")
@ResponseBody
public class MetaQueryController extends AbstractController {


}
