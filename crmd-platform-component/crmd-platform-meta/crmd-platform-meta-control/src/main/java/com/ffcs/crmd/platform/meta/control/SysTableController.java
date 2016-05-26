package com.ffcs.crmd.platform.meta.control;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.common.utils.type.NumberUtils;
import com.ffcs.crmd.platform.control.AbstractController;
import com.ffcs.crmd.platform.meta.api.dto.SysTableDTO;
import com.ffcs.crmd.platform.meta.api.facade.ISysTableFacade;
import com.ffcs.crmd.platform.meta.vo.MetaQryParamsVo;
import com.ffcs.crmd.platform.pub.vo.RetVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by FFCS-CAIWL on 2015/12/28.
 */
@Controller
@RequestMapping("/meta/sysTable")
@ResponseBody
public class SysTableController extends AbstractController {

    @Autowired
    private ISysTableFacade sysTableFacade;

    /**
     * 分页查询系统表
     * @param vo
     * @return
     */
    @RequestMapping("/page")
    public RetVo qrySysTabPage(@RequestBody MetaQryParamsVo vo) {
        RetVo rt;
        try {
            PageInfo<SysTableDTO> sysTables = sysTableFacade
                .qrySysTablePage(vo.getPageNumber(), vo.getPageSize());
            rt = new RetVo(true);
            rt.setPageInfo(sysTables);
        } catch (Exception e) {
            rt = new RetVo(false);
            rt.setExceptions(e);
            rt.setDetailMsg(e.getMessage());
        }
        return rt;
    }

    /**
     * 得到单一系统表属性
     * @param vo
     * @return
     */
    @RequestMapping("/getSysTable/byTabId")
    public RetVo getSysTableByTabId(@RequestBody MetaQryParamsVo vo) {
        RetVo rt;
        try {
            SysTableDTO dto = sysTableFacade.getSysTableByTabId(vo.getTabId(), vo.isAllColumns());
            rt = new RetVo(true);
            rt.setObject(dto);
        } catch (Exception e) {
            rt = new RetVo(false);
            rt.setExceptions(e);
            rt.setDetailMsg(e.getMessage());
        }
        return rt;
    }
    /**
     * 得到单一系统表属性
     * @param vo
     * @return
     */
    @RequestMapping("/getSysTable/byObjId")
    public RetVo getSysTableByObjId(@RequestBody MetaQryParamsVo vo) {
        RetVo rt;
        try {
            SysTableDTO dto = sysTableFacade.getSysTableByObjId(vo.getBusiObjId());
            rt = new RetVo(true);
            rt.setObject(dto);
        } catch (Exception e) {
            rt = new RetVo(false);
            rt.setExceptions(e);
            rt.setDetailMsg(e.getMessage());
        }
        return rt;
    }

    @RequestMapping("/add")
    public RetVo add(@RequestBody SysTableDTO dto) {
        RetVo rt;
        try {
            sysTableFacade.add(dto);
            if (NumberUtils.nullToLongZero(dto.getTabId()) != 0) {
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
    public RetVo update(@RequestBody SysTableDTO dto) {
        RetVo rt;
        try {
            int updateRt = sysTableFacade.update(dto);
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
    public RetVo del(@RequestBody SysTableDTO dto) {
        RetVo rt;
        try {
            int delRt = sysTableFacade.delete(dto);
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
