package com.ffcs.crmd.platform.pub.springext;

import org.springframework.beans.factory.xml.BeanDefinitionParserDelegate;
import org.springframework.beans.factory.xml.DefaultBeanDefinitionDocumentReader;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * Created by linzhiqiang on 16/3/3.
 */
public class CrmBeanDefinitionDocumentReader extends DefaultBeanDefinitionDocumentReader {

    @Override
    protected void parseBeanDefinitions(Element root, BeanDefinitionParserDelegate delegate) {
        if (delegate.isDefaultNamespace(root)) {
            NodeList nl = root.getChildNodes();
            for (int i = 0; i < nl.getLength(); i++) {
                Node node = nl.item(i);
                if (node instanceof Element) {
                    Element ele = (Element) node;

                    String id = ele.getAttribute(BeanDefinitionParserDelegate.ID_ATTRIBUTE);
                    String nameAttr = ele.getAttribute(BeanDefinitionParserDelegate.NAME_ATTRIBUTE);
                    String className = ele
                        .getAttribute(BeanDefinitionParserDelegate.CLASS_ATTRIBUTE);
                    if (!ContextConfig.isSkipBean(id, nameAttr, className)) {
                        if (delegate.isDefaultNamespace(ele)) {
                            parseDefaultElement(ele, delegate);
                        } else {
                            delegate.parseCustomElement(ele);
                        }
                    } else {
                        if (logger.isDebugEnabled()) {
                            logger.debug(
                                "skip bean ," + "id:" + id + " ,name:" + nameAttr + " ,className:"
                                    + className);
                        }
                    }
                }
            }
        } else {
            delegate.parseCustomElement(root);
        }
    }

    private void parseDefaultElement(Element ele, BeanDefinitionParserDelegate delegate) {
        if (delegate.nodeNameEquals(ele, IMPORT_ELEMENT)) {
            importBeanDefinitionResource(ele);
        } else if (delegate.nodeNameEquals(ele, ALIAS_ELEMENT)) {
            processAliasRegistration(ele);
        } else if (delegate.nodeNameEquals(ele, BEAN_ELEMENT)) {
            processBeanDefinition(ele, delegate);
        } else if (delegate.nodeNameEquals(ele, NESTED_BEANS_ELEMENT)) {
            // recurse
            doRegisterBeanDefinitions(ele);
        }
    }
}
