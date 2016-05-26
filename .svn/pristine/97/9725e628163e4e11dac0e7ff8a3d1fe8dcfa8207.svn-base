package com.ffcs.crmd.platform.pub.bean.provider.scan;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionHolder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.annotation.ClassPathBeanDefinitionScanner;
import org.springframework.core.type.classreading.MetadataReader;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.filter.AnnotationTypeFilter;
import org.springframework.core.type.filter.TypeFilter;
import org.springframework.util.Assert;

import com.ffcs.crmd.platform.pub.bean.provider.BeanConvertProvider;
import com.ffcs.crmd.platform.pub.bean.provider.IBeanConvert;

public class BeanConvertScanner extends ClassPathBeanDefinitionScanner {
    
    private Class<? extends Annotation> annotationClass;
    
    public void setAnnotationClass(Class<? extends Annotation> annotationClass) {
        this.annotationClass = annotationClass;
    }
    
    public BeanConvertScanner(BeanDefinitionRegistry registry) {
        super(registry, false);
    }
    
    @Override
    public int scan(String... basePackages) {
        int beanCountAtScanStart = this.getRegistry().getBeanDefinitionCount();
        
        doScan(basePackages);
        
        return (this.getRegistry().getBeanDefinitionCount() - beanCountAtScanStart);
    }
    
    @Override
    protected Set<BeanDefinitionHolder> doScan(String... basePackages) {
        Assert.notEmpty(basePackages, "At least one base package must be specified");
        Set<BeanDefinitionHolder> beanDefinitions = new LinkedHashSet<BeanDefinitionHolder>();
        for (String basePackage : basePackages) {
            Set<BeanDefinition> candidates = findCandidateComponents(basePackage);
            
            for (BeanDefinition candidate : candidates) {
                if (candidate instanceof GenericBeanDefinition) {
                    GenericBeanDefinition beanDefine = (GenericBeanDefinition) candidate;
                    if (logger.isDebugEnabled()) {
                        logger.debug("初始化BeanConvert:" + beanDefine.getBeanClassName() + "' ");
                    }
                    
                    // the mapper interface is the original class of the bean
                    // but, the actual class of the bean is MapperFactoryBean
                    try {
                        Class<?> clazz = beanDefine.resolveBeanClass(this.getClass()
                            .getClassLoader());
                        if (clazz != null) {
                            IBeanConvert convert = (IBeanConvert) clazz.newInstance();
                            BeanConvertProvider.putConvert(convert.getSourceClass(),
                                convert.getDestClass(), convert);
                        }
                    } catch (Exception e1) {
                        e1.printStackTrace();
                        logger.error(beanDefine.getBeanClassName() + "regist fail");
                    }
                }
            }
        }
        return beanDefinitions;
    }
    
    /**
     * Configures parent scanner to search for the right interfaces. It can
     * search for all interfaces or just for those that extends a
     * markerInterface or/and those annotated with the annotationClass
     */
    public void registerFilters() {
        boolean acceptAllInterfaces = true;
        
        // if specified, use the given annotation and / or marker interface
        if (this.annotationClass != null) {
            addIncludeFilter(new AnnotationTypeFilter(this.annotationClass));
            acceptAllInterfaces = false;
        }
        
        if (acceptAllInterfaces) {
            // default include filter that accepts all classes
            addIncludeFilter(new TypeFilter() {
                public boolean match(MetadataReader metadataReader,
                    MetadataReaderFactory metadataReaderFactory) throws IOException {
                    return true;
                }
            });
        }
    }
    
}
