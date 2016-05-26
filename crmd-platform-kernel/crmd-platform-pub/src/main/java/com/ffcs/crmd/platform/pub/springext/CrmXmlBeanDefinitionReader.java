package com.ffcs.crmd.platform.pub.springext;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.BeanDefinitionStoreException;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.xml.BeanDefinitionDocumentReader;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by linzhiqiang on 16/3/3.
 */
public class CrmXmlBeanDefinitionReader extends XmlBeanDefinitionReader {
    /**
     * Create new XmlBeanDefinitionReader for the given bean factory.

     * @param registry
    the BeanFactory to load bean definitions into,
     *
    in the form of a BeanDefinitionRegistry
     */
    public CrmXmlBeanDefinitionReader(BeanDefinitionRegistry registry) {
        super(registry);
    }

    @Override
    public int loadBeanDefinitions(String location, Set<Resource> actualResources)
        throws BeanDefinitionStoreException {
        ResourceLoader resourceLoader = getResourceLoader();
        if (resourceLoader == null) {
            throw new BeanDefinitionStoreException(
                "Cannot import bean definitions from location [" + location
                    + "]: no ResourceLoader available");
        }

        if (resourceLoader instanceof ResourcePatternResolver) {
            // Resource pattern matching available.
            try {
                Resource[] allResources = ((ResourcePatternResolver) resourceLoader)
                    .getResources(location);
                List<Resource> resourceList = new ArrayList<Resource>();
                for (Resource resource : allResources) {
                    if (!ContextConfig.isSkipFile(resource.getFilename())) {
                        resourceList.add(resource);
                    } else {
                        if (logger.isDebugEnabled()) {
                            logger.debug(
                                "skip bean definitions from location [" + resource.getFilename() + "]");
                        }
                    }
                }

                Resource[] resources = new Resource[resourceList.size()];
                resourceList.toArray(resources);

                int loadCount = loadBeanDefinitions(resources);
                if (actualResources != null) {
                    for (Resource resource : resources) {
                        actualResources.add(resource);
                    }
                }
                if (logger.isDebugEnabled()) {
                    logger.debug("Loaded " + loadCount + " bean definitions from location pattern ["
                        + location + "]");
                }
                return loadCount;
            } catch (IOException ex) {
                throw new BeanDefinitionStoreException(
                    "Could not resolve bean definition resource pattern [" + location + "]", ex);
            }
        } else {
            // Can only load single resources by absolute URL.
            Resource resource = resourceLoader.getResource(location);
            int loadCount = 0;
            if (!ContextConfig.isSkipFile(resource.getFilename())) {
                loadCount = loadBeanDefinitions(resource);
                if (actualResources != null) {
                    actualResources.add(resource);
                }
            if (logger.isDebugEnabled()) {
                logger.debug(
                    "Loaded " + loadCount + " bean definitions from location [" + location + "]");
            }
            } else {
                if (logger.isDebugEnabled()) {
                    logger.debug(
                        "skip bean definitions from location [" + location + "]");
                }
            }


            return loadCount;
        }
    }

    @Override
    protected BeanDefinitionDocumentReader createBeanDefinitionDocumentReader() {
        return BeanDefinitionDocumentReader.class.cast(BeanUtils.instantiateClass(CrmBeanDefinitionDocumentReader.class));
    }
}
