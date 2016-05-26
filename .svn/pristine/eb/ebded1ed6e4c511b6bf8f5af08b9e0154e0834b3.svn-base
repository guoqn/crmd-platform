package com.ffcs.crmd.platform.meta.control;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.common.utils.type.NumberUtils;
import com.ffcs.crmd.platform.control.AbstractController;
import com.ffcs.crmd.platform.meta.api.dto.SysDomainDTO;
import com.ffcs.crmd.platform.meta.api.facade.ISysDomainFacade;
import com.ffcs.crmd.platform.meta.vo.MetaQryParamsVo;
import com.ffcs.crmd.platform.pub.vo.RetVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by FFCS-CAIWL on 2016/1/4.
 */
@Controller
@RequestMapping("/meta/sysDomain")
@ResponseBody
public class SysDomainController extends AbstractController {
    @Autowired
    private ISysDomainFacade sysDomainFacade;

    @RequestMapping("/page")
    public RetVo qryPageSysDomain(@RequestBody MetaQryParamsVo vo){
        RetVo rt;
        try {
            PageInfo<SysDomainDTO> sysDomainDTOPageInfo = sysDomainFacade
                .qrySysDomainPage(vo.getPageNumber(), vo.getPageSize());
            rt = new RetVo(true);
            rt.setPageInfo(sysDomainDTOPageInfo);
        } catch (Exception e) {
            rt = new RetVo(false);
            rt.setExceptions(e);
            rt.setDetailMsg(e.getMessage());
        }
        return rt;
    }

    @RequestMapping("/add")
    public RetVo add(@RequestBody SysDomainDTO dto) {
        RetVo rt;
        try {
            sysDomainFacade.add(dto);
            if (NumberUtils.nullToLongZero(dto.getDomainId()) != 0) {
                rt = new RetVo(true);
            } else {
                rt = new RetVo(false);
                rt.setDetailMsg("新增失败");
            }
        } catch (Exception e) {
            rt = new RetVo(false);
            rt.setExceptions(e);
            rt.setDetailMsg(e.getMessage());
        }
        return rt;
    }

    @RequestMapping("/update")
    public RetVo update(@RequestBody SysDomainDTO dto) {
        RetVo rt;
        try {
            int updateRt = sysDomainFacade.update(dto);
            if (updateRt > 0) {
                rt = new RetVo(true);
            } else {
                rt = new RetVo(false);
                rt.setDetailMsg("修改失败");
            }
        } catch (Exception e) {
            rt = new RetVo(false);
            rt.setExceptions(e);
            rt.setDetailMsg(e.getMessage());
        }
        return rt;
    }

    @RequestMapping("/del")
    public RetVo del(@RequestBody SysDomainDTO dto) {
        RetVo rt;
        try {
            int delRt = sysDomainFacade.delete(dto);
            if (delRt > 0) {
                rt = new RetVo(true);
            } else {
                rt = new RetVo(false);
                rt.setDetailMsg("修改失败");
            }
        } catch (Exception e) {
            rt = new RetVo(false);
            rt.setExceptions(e);
            rt.setDetailMsg(e.getMessage());
        }
        return rt;
    }
}
