package com.ffcs.crmd.platform.base.utils;

import java.io.Reader;
import java.io.Writer;

import com.ctg.itrdc.platform.common.log.ILogger;
import com.ctg.itrdc.platform.common.log.LoggerFactory;
import com.ctg.itrdc.platform.common.exception.RtManagerException;

/**
 * Created by linzq on 2014/11/3.
 */
public class CastorUtils {
    private static final ILogger LOGGER = LoggerFactory.getLogger(CastorUtils.class);
    
    /**
     * {@inheritDoc}
     * 
     */
    public static Writer objectToSerial(Object obj) {
        Writer w = new java.io.StringWriter();
        return objectToSerial(w, obj);
    }
    
    /**
     * {@inheritDoc}
     * 
     */
    public static Object serialToObject(Reader r, Class<?> clazz) {
        try {
            return org.exolab.castor.xml.Unmarshaller.unmarshal(clazz, r);
        } catch (Exception e) {
            LOGGER.error("xml转换失败", e);
            throw new RtManagerException(e);
        }
    }
    
    /**
     * {@inheritDoc}
     * 
     */
    public static Writer objectToSerial(Writer w, Object obj) {
        try {
            org.exolab.castor.xml.Marshaller.marshal(obj, w);
        } catch (Exception e) {
            LOGGER.error("xml转换失败", e);
            throw new RtManagerException(e);
        }
        return w;
    }
    
    /**
     * {@inheritDoc}
     * 
     */
    public static Object serialToObject(String str, Class<?> clazz) {
        Reader r = new java.io.StringReader(str);
        return serialToObject(r, clazz);
    }
}
