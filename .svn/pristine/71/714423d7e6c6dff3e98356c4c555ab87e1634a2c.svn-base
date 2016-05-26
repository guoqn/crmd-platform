package com.ffcs.crmd.platform.meta.control;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.common.utils.type.NumberUtils;
import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.platform.control.AbstractController;
import com.ffcs.crmd.platform.meta.api.dto.ObjTabRelDTO;
import com.ffcs.crmd.platform.meta.api.facade.IObjTabRelFacade;
import com.ffcs.crmd.platform.meta.vo.MetaQryParamsVo;
import com.ffcs.crmd.platform.pub.vo.RetVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 该可表示系统表与对象的关系(对象可为业务对象也可为关系规格对象)
 */

@Controller
@RequestMapping("/meta/objTabRel")
@ResponseBody
public class ObjTabRelController extends AbstractController {

    @Autowired
    IObjTabRelFacade objTabRelFacade;

    @RequestMapping("/page/byTabId")
    public RetVo qryPageByTabId(@RequestBody MetaQryParamsVo vo) {
        RetVo rt;
        try {
            PageInfo<ObjTabRelDTO> page = objTabRelFacade
                .qryPageByTabId(vo.getTabId(), vo.getPageNumber(), vo.getPageSize());
            rt = new RetVo(true);
            rt.setPageInfo(page);
        } catch (Exception e) {
            rt = new RetVo(false);
            rt.setExceptions(e);
            rt.setDetailMsg(e.getMessage());
        }
        return rt;
    }


    /**
     * 新增的时候要把关系类型带入，这是区分对象是属性哪类型的
     * @param dto
     * @return
     */
    @RequestMapping("/add")
    public RetVo add(@RequestBody ObjTabRelDTO dto) {
        RetVo rt;
        try {
            if(StringUtils.isNullOrEmpty(dto.getObjType())){
                rt = new RetVo(false);
                rt.setDetailMsg("对象类型不存在");
            }
            if (NumberUtils.nullToLongZero(dto.getObjId()) != 0
                && NumberUtils.nullToLongZero(dto.getTabId()) != 0) {
                objTabRelFacade.add(dto);
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
    public RetVo update(@RequestBody ObjTabRelDTO dto) {
        RetVo rt;
        try {
            int updateRt = objTabRelFacade.update(dto);
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
    public RetVo del(@RequestBody ObjTabRelDTO dto) {
        RetVo rt;
        try {
            int delRt = objTabRelFacade.delete(dto);
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
