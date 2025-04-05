package com.testando_api.primeiro_teste_api.deserializer;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import org.springframework.core.serializer.Deserializer;

import java.io.IOException;
import java.io.InputStream;

public class DoubleDeserializer extends JsonDeserializer<Double>
{
    @Override
    public Double deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        String responseJkson = jsonParser.getText();

        try
        {
            if(responseJkson.equalsIgnoreCase("N/A")) return 0.0;
            return Double.parseDouble(responseJkson);
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
}
