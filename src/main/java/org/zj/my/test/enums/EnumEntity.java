package org.zj.my.test.enums;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize(using = EnumEntitySerializer.class)
public interface EnumEntity<T> {

    @JsonProperty("id")
    T getValue();
}
