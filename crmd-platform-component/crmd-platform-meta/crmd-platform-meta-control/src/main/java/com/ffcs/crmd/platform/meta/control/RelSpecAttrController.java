package com.ffcs.crmd.platform.meta.control;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.common.utils.type.NumberUtils;
import com.ffcs.crmd.platform.control.AbstractController;
import com.ffcs.crmd.platform.meta.api.dto.RelSpecAttrDTO;
import com.ffcs.crmd.platform.meta.api.facade.IRelSpecAttrFacade;
import com.ffcs.crmd.platform.meta.vo.MetaQryParamsVo;
import com.ffcs.crmd.platform.pub.vo.RetVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by FFCS-CAIWL on 2016/1/9.
 */
@Controller
@RequestMapping("/meta/relSpecAttr")
@ResponseBody
public class RelSpecAttrController extends AbstractController {

    @Autowired
    IRelSpecAttrFacade relSpecAttrFacade;

    @RequestMapping("/page/byRelSpecId")
    public RetVo qryPageByRelSpecId(@RequestBody MetaQryParamsVo vo) {
        RetVo rt;
        try {
            PageInfo<RelSpecAttrDTO> page = relSpecAttrFacade
                .qryPageByRelSpecId(vo.getRelSpecId(), vo.getPageNumber(), vo.getPageSize());
            rt = new RetVo(true);
            rt.setPageInfo(page);
        } catch (Exception e) {
            rt = new RetVo(false);
            rt.setExceptions(e);
            rt.setDetailMsg(e.getMessage());
        }
        return rt;
    }

    @RequestMapping("/page/byAttrId")
    public RetVo qryPageByAttrId(@RequestBody MetaQryParamsVo vo) {
        RetVo rt;
        try {
            PageInfo<RelSpecAttrDTO> page = relSpecAttrFacade
                .qryPageByAttrId(vo.getAttrId(), vo.getPageNumber(), vo.getPageSize());
            rt = new RetVo(true);
            rt.setPageInfo(page);
        } catch (Exception e) {
            rt = new RetVo(false);
            rt.setExceptions(e);
            rt.setDetailMsg(e.getMessage());
        }
        return rt;
    }

    @RequestMapping("/add")
    public RetVo add(@RequestBody RelSpecAttrDTO dto) {
        RetVo rt;
        try {
            relSpecAttrFacade.add(dto);
            if (NumberUtils.nullToLongZero(dto.getRelSpecAttrId()) != 0) {
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
    public RetVo update(@RequestBody RelSpecAttrDTO dto) {
        RetVo rt;
        try {
            int updateRt = relSpecAttrFacade.update(dto);
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
    public RetVo del(@RequestBody RelSpecAttrDTO dto) {
        RetVo rt;
        try {
            int delRt = relSpecAttrFacade.delete(dto);
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
