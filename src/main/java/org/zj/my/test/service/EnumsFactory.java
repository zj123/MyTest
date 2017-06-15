package org.zj.my.test.service;

import java.util.Map;
import java.util.Objects;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

import org.zj.my.test.enums.EnumEntity;
import org.zj.my.test.enums.WechatAccountType;

import com.google.common.collect.Maps;

public class EnumsFactory {

    private static final ConcurrentMap<Class<? extends EnumEntity<?>>, Map<Object, EnumEntity<?>>> ENUM_CACHE = new ConcurrentHashMap<>();

    public static Map<Object, EnumEntity<?>> getEnumMap(Class<? extends EnumEntity<?>> enumEntityClass) {
        return ENUM_CACHE.computeIfAbsent(enumEntityClass, clazz -> {
            EnumEntity<?>[] enumConstants = clazz.getEnumConstants();
            Map<Object, EnumEntity<?>> enumMap = Maps.newHashMapWithExpectedSize(enumConstants.length);
            for (EnumEntity<?> enumEntity : enumConstants) {
                enumMap.put(enumEntity.getValue(), enumEntity);
            }
            return enumMap;
        });
    }

    @SuppressWarnings("unchecked")
    public static <T extends EnumEntity<?>> T getUnchecked(Class<T> enumEntityClass, Object value) {
        return (T) getEnumMap(enumEntityClass).get(value);
    }

    public static <T extends EnumEntity<?>> T get(Class<T> enumEntityClass, Object value) {
        T result = getUnchecked(enumEntityClass, value);
        Objects.requireNonNull(result, () -> String.format("Can not find %s of enum %s", value, enumEntityClass));
        return result;
    }

    public static void main(String[] args) {
        getEnumMap(WechatAccountType.class);
        System.out.println(get(WechatAccountType.class, (byte) 1));
    }

}
