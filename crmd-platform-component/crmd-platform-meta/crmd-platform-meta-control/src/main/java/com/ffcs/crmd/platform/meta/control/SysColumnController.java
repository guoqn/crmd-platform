package com.ffcs.crmd.platform.meta.control;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.common.utils.type.NumberUtils;
import com.ffcs.crmd.platform.control.AbstractController;
import com.ffcs.crmd.platform.meta.api.dto.SysColumnDTO;
import com.ffcs.crmd.platform.meta.api.facade.ISysColumnFacade;
import com.ffcs.crmd.platform.meta.vo.MetaQryParamsVo;
import com.ffcs.crmd.platform.pub.vo.RetVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by FFCS-CAIWL on 2016/1/4.
 */
@Controller
@RequestMapping("/meta/sysColumn")
@ResponseBody
public class SysColumnController extends AbstractController {

    @Autowired
    private ISysColumnFacade sysColumnFacade;

    /**
     * 根据表ID查询表字段
     * @param vo
     * @return
     */
    @RequestMapping("/list/byTabId")
    public RetVo qrySysColumnsByTabId(@RequestBody MetaQryParamsVo vo) {
        RetVo rt;
        try {
            List<SysColumnDTO> list = sysColumnFacade.qrySysColumnsListByTabId(vo.getTabId());
            rt = new RetVo(true);
            rt.setDataList(list);
        } catch (Exception e) {
            rt = new RetVo(false);
            rt.setExceptions(e);
            rt.setDetailMsg(e.getMessage());
        }
        return rt;
    }

    @RequestMapping("/page/byTabId")
    public RetVo qrySysColumnsPageByTabId(@RequestBody MetaQryParamsVo vo) {
        RetVo rt;
        try {
            PageInfo<SysColumnDTO> info = sysColumnFacade
                .qrySysColumnsPageByTabId(vo.getTabId(), vo.getPageNumber(), vo.getPageSize());
            rt = new RetVo(true);
            rt.setPageInfo(info);
        } catch (Exception e) {
            rt = new RetVo(false);
            rt.setExceptions(e);
            rt.setDetailMsg(e.getMessage());
        }
        return rt;
    }

    @RequestMapping("/add")
    public RetVo add(@RequestBody SysColumnDTO dto) {
        RetVo rt;
        try {
            sysColumnFacade.add(dto);
            if (NumberUtils.nullToLongZero(dto.getColId()) != 0) {
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
    public RetVo update(@RequestBody SysColumnDTO dto) {
        RetVo rt;
        try {
            int updateRt = sysColumnFacade.update(dto);
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
    public RetVo del(@RequestBody SysColumnDTO dto) {
        RetVo rt;
        try {
            int delRt = sysColumnFacade.delete(dto);
            if (delRt > 0) {
                rt = new RetVo(true);
            } else {
                rt = new RetVo(false);
                rt.setDetailMsg("删除失败");
            }
        } catch (Exception e) {
            rt = new RetVo(false);
            rt.setExceptions(e);
            rt.setDetailMsg(e.getMessage());
        }
        return rt;
    }
}
