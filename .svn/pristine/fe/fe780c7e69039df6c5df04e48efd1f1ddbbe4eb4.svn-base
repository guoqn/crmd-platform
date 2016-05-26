package com.ffcs.crmd.platform.meta.lazyloader;

import com.ctg.itrdc.platform.common.utils.type.StringUtils;
import com.ffcs.crmd.platform.meta.intf.IBusiObj;
import com.ffcs.crmd.platform.meta.intf.IMetaEntity;
import com.ffcs.crmd.platform.meta.service.MetaServiceFactory;
import com.ffcs.crmd.platform.pub.bean.lazyloader.IMetaLoaderService;
import org.springframework.stereotype.Service;

/**
 * Created by linzhiqiang on 16/3/31.
 */
@Service("metaLoaderService")
public class MetaLoaderServiceImpl implements IMetaLoaderService {
    @Override
    public String getAttrValueNameByObj(Object obj, String attrNbr, Object value) {
        if (StringUtils.isNullOrEmpty(value)) {
            return "";
        }
        if (obj instanceof IMetaEntity) {
            IBusiObj busiObj = MetaServiceFactory.getMetaService().getBusiObj((IMetaEntity) obj);
            return MetaServiceFactory.getMetaService()
                .getAttrValueNameByValue(busiObj, attrNbr, value);
        } else {
            return StringUtils.strnull(value);
        }
    }

    @Override
    public String getAttrValueNameByObjNbr(String busiObjNbr, String attrNbr, Object value) {
        if (StringUtils.isNullOrEmpty(value)) {
            return "";
        }
        return MetaServiceFactory.getMetaService()
            .getAttrValueNameByValue(busiObjNbr, attrNbr, value);
    }
}
