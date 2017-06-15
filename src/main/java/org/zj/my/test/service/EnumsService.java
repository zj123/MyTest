package org.zj.my.test.service;

import javax.annotation.PostConstruct;

import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;
import org.zj.my.test.enums.EnumEntity;
import org.zj.my.test.util.ClassPathEnumEntityScanner;

@Service
public class EnumsService {

    @Value("${sao.enum.entity.packages}")
    private String[] enumEntityPackages;

    @PostConstruct
    public void init() {
        if (ArrayUtils.isEmpty(enumEntityPackages)) {
            return;
        }

        ClassPathEnumEntityScanner scanner = new ClassPathEnumEntityScanner();

        for (String enumEntityPackage : enumEntityPackages) {
            for (BeanDefinition beanDefinition : scanner.findCandidateComponents(enumEntityPackage)) {
                @SuppressWarnings("unchecked")
                Class<? extends EnumEntity<Object>> type = (Class<? extends EnumEntity<Object>>) ClassUtils
                        .resolveClassName(beanDefinition.getBeanClassName(), ClassUtils.getDefaultClassLoader());
                if (!type.isAnonymousClass() && type.isEnum()) {
                    EnumsFactory.getEnumMap(type);
                }
            }
        }
    }
}
