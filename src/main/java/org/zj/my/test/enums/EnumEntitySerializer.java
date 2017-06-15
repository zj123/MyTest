package org.zj.my.test.enums;

import java.io.IOException;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

public class EnumEntitySerializer extends JsonSerializer<EnumEntity<?>> {

    @Override
    public void serialize(EnumEntity<?> enumEntity, JsonGenerator generator, SerializerProvider provider)
            throws IOException, JsonProcessingException {

        Object value = null;
        if (enumEntity != null) {
            value = enumEntity.getValue();
        }
        generator.writeObject(value);
    }
}
