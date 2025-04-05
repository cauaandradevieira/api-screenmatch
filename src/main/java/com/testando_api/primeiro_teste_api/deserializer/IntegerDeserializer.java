package com.testando_api.primeiro_teste_api.deserializer;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;

public class IntegerDeserializer extends JsonDeserializer<Integer>
{

    @Override
    public Integer deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JacksonException {
        String responseJkson = jsonParser.getText();

        try
        {
            if(responseJkson.equalsIgnoreCase("N/A")) return 0;
            return Integer.parseInt(responseJkson);
        } catch (NumberFormatException e) {
            return 0;
        }
    }
}
