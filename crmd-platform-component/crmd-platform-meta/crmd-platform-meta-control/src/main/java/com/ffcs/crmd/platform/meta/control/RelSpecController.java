package com.ffcs.crmd.platform.meta.control;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.common.utils.type.NumberUtils;
import com.ffcs.crmd.platform.control.AbstractController;
import com.ffcs.crmd.platform.meta.api.dto.RelSpecDTO;
import com.ffcs.crmd.platform.meta.api.facade.IRelSpecFacade;
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
@RequestMapping("/meta/relSpec")
@ResponseBody
public class RelSpecController extends AbstractController {

    @Autowired
    IRelSpecFacade relSpecFacade;

    @RequestMapping("/page/byAObjId")
    public RetVo qryPageByAObjId(@RequestBody MetaQryParamsVo vo) {
        RetVo rt;
        try {
            PageInfo<RelSpecDTO> pageInfos = relSpecFacade
                .qryPageByAObjId(vo.getBusiObjId(), vo.getPageNumber(), vo.getPageSize());
            rt = new RetVo(true);
            rt.setPageInfo(pageInfos);
        } catch (Exception e) {
            rt = new RetVo(false);
            rt.setExceptions(e);
            rt.setDetailMsg(e.getMessage());
        }
        return rt;
    }

    @RequestMapping("/page/byZObjId")
    public RetVo qryPageByZObjId(@RequestBody MetaQryParamsVo vo) {
        RetVo rt;
        try {
            PageInfo<RelSpecDTO> pageInfos = relSpecFacade
                .qryPageByZObjId(vo.getBusiObjId(), vo.getPageNumber(), vo.getPageSize());
            rt = new RetVo(true);
            rt.setPageInfo(pageInfos);
        } catch (Exception e) {
            rt = new RetVo(false);
            rt.setExceptions(e);
            rt.setDetailMsg(e.getMessage());
        }
        return rt;
    }

    @RequestMapping("/add")
    public RetVo add(@RequestBody RelSpecDTO dto) {
        RetVo rt;
        try {
            relSpecFacade.add(dto);
            if (NumberUtils.nullToLongZero(dto.getRelSpecId()) != 0) {
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
    public RetVo update(@RequestBody RelSpecDTO dto) {
        RetVo rt;
        try {
            int updateRt = relSpecFacade.update(dto);
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
    public RetVo del(@RequestBody RelSpecDTO dto) {
        RetVo rt;
        try {
            int delRt = relSpecFacade.delete(dto);
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
