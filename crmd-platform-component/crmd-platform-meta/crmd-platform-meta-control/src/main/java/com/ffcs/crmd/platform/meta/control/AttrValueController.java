package com.ffcs.crmd.platform.meta.control;

import com.ctg.itrdc.platform.common.entity.PageInfo;
import com.ctg.itrdc.platform.common.utils.type.NumberUtils;
import com.ffcs.crmd.platform.control.AbstractController;
import com.ffcs.crmd.platform.meta.api.dto.AttrValueDTO;
import com.ffcs.crmd.platform.meta.api.facade.IAttrValueFacade;
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
@RequestMapping("/meta/attrValue")
@ResponseBody
public class AttrValueController extends AbstractController {

    @Autowired
    private IAttrValueFacade attrValueFacade;

    @RequestMapping("/page/byAttrId")
    public RetVo qryAttrSpecPageByAttrId(@RequestBody MetaQryParamsVo vo) {
        RetVo rt;
        try {
            PageInfo<AttrValueDTO> info = attrValueFacade
                .qryAttrValuePageByAttrId(vo.getAttrId(), vo.getParentValueId(), vo.getPageNumber(),
                    vo.getPageSize());
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
    public RetVo add(@RequestBody AttrValueDTO dto) {
        RetVo rt;
        try {
            attrValueFacade.add(dto);
            if (NumberUtils.nullToLongZero(dto.getAttrValueId()) != 0) {
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
    public RetVo update(@RequestBody AttrValueDTO dto) {
        RetVo rt;
        try {
            int updateRt = attrValueFacade.update(dto);
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
    public RetVo del(@RequestBody AttrValueDTO dto) {
        RetVo rt;
        try {
            int delRt = attrValueFacade.delete(dto);
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
