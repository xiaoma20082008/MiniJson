package com.test.json;


import com.test.syntax.JsonBaseVisitor;
import com.test.syntax.JsonParser;

import java.util.AbstractMap;

/**
 * @author machunxiao create at 2020-03-17
 */
public class JsonVisitor extends JsonBaseVisitor<Object> {

    @Override
    public Object visitJsonObject(JsonParser.JsonObjectContext ctx) {
        JsonObject object = new JsonObject();
        ctx.pair().stream()
                .map(this::visit)
                .map(AbstractMap.SimpleEntry.class::cast)
                .forEach(se -> object.put((String) se.getKey(), se.getValue()));
        return object;
    }

    @Override
    public Object visitJsonArray(JsonParser.JsonArrayContext ctx) {
        JsonArray array = new JsonArray();
        ctx.value()
                .stream()
                .map(this::visit)
                .forEach(array::add);
        return array;
    }

    @Override
    public Object visitPair(JsonParser.PairContext ctx) {
        String key = (String) visitStringValue(ctx.name);
        Object val = visitValue(ctx.value());
        return new AbstractMap.SimpleEntry<>(key, val);
    }

    @Override
    public Object visitBooleanValue(JsonParser.BooleanValueContext ctx) {
        return "TRUE".equalsIgnoreCase(ctx.getText());
    }

    @Override
    public Object visitStringValue(JsonParser.StringValueContext ctx) {
        final String text = ctx.STRING().getText();
        return text.substring(1, text.length() - 1);
    }

    @Override
    public Object visitNumberValue(JsonParser.NumberValueContext ctx) {
        String num = ctx.NUMBER().getText();
        try {
            return Long.parseLong(num);
        } catch (NumberFormatException e) {
            //
        }
        try {
            return Integer.parseInt(num);
        } catch (NumberFormatException e) {
            //
        }
        return Double.parseDouble(num);
    }

    @Override
    public Object visitNullValue(JsonParser.NullValueContext ctx) {
        return null;
    }
}
