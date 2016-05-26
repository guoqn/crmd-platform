package com.ffcs.crmd.platform.meta.control;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.common.utils.type.NumberUtils;
import com.ffcs.crmd.platform.control.AbstractController;
import com.ffcs.crmd.platform.meta.api.dto.BusiObjDTO;
import com.ffcs.crmd.platform.meta.api.facade.IBusiObjFacade;
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
@RequestMapping("/meta/busiObj")
@ResponseBody
public class BusiObjController extends AbstractController {
    @Autowired
    private IBusiObjFacade busiObjFacade;

    @RequestMapping("/page/byTypeId")
    public RetVo qryBusiObjPageByTypeId(@RequestBody MetaQryParamsVo vo) {
        RetVo rt;
        try {
            PageInfo<BusiObjDTO> busiObjPage = busiObjFacade
                .qryBusiObjPageByTypeId(vo.getBusiTypeId(), vo.getPageNumber(), vo.getPageSize());
            rt = new RetVo(true);
            rt.setPageInfo(busiObjPage);
        } catch (Exception e) {
            rt = new RetVo(false);
            rt.setExceptions(e);
            rt.setDetailMsg(e.getMessage());
        }
        return rt;
    }

    @RequestMapping("/page/byTabId")
    public RetVo qryBusiObjPageByTabId(@RequestBody MetaQryParamsVo vo) {
        RetVo rt;
        try {
            PageInfo<BusiObjDTO> busiObjPage = busiObjFacade
                .qryBusiObjPageByTabId(vo.getTabId(), vo.getObjType(), vo.getPageNumber(),
                    vo.getPageSize());
            rt = new RetVo(true);
            rt.setPageInfo(busiObjPage);
        } catch (Exception e) {
            rt = new RetVo(false);
            rt.setExceptions(e);
            rt.setDetailMsg(e.getMessage());
        }
        return rt;
    }

    @RequestMapping("/page/byAObjId")
    public RetVo qryBusiObjPageByAObjId(@RequestBody MetaQryParamsVo vo) {
        RetVo rt;
        try {
            PageInfo<BusiObjDTO> page = busiObjFacade
                .qryBusiObjPageByAObjId(vo.getBusiObjId(), vo.getPageNumber(), vo.getPageSize());
            rt = new RetVo(true);
            rt.setPageInfo(page);
        } catch (Exception e) {
            rt = new RetVo(false);
            rt.setExceptions(e);
            rt.setDetailMsg(e.getMessage());
        }
        return rt;
    }

    @RequestMapping("/page/byZObjId")
    public RetVo qryBusiObjPageByZObjId(@RequestBody MetaQryParamsVo vo) {
        RetVo rt;
        try {
            PageInfo<BusiObjDTO> pageInfos = busiObjFacade
                .qryBusiObjPageByZObjId(vo.getBusiObjId(), vo.getPageNumber(), vo.getPageSize());
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
    public RetVo add(@RequestBody BusiObjDTO dto) {
        RetVo rt;
        try {
            busiObjFacade.add(dto);
            if (NumberUtils.nullToLongZero(dto.getBusiObjId()) != 0) {
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
    public RetVo update(@RequestBody BusiObjDTO dto) {
        RetVo rt;
        try {
            int updateRt = busiObjFacade.update(dto);
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
    public RetVo del(@RequestBody BusiObjDTO dto) {
        RetVo rt;
        try {
            int delRt = busiObjFacade.delete(dto);
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
