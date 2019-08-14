package com.mac.stockwallet.utils;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * A Gson tool class for me
 *
 * @author: 万剑一
 * @date: 2018/5/2
 */
public final class GsonTools {

    public static <T> List<T> gsonFormatToList(String jsonStr, Class<T> cls) {

        Gson gson = new Gson();
        //解决 Gson 类型泛型擦除问题
        Type type = com.google.gson.internal.$Gson$Types.newParameterizedTypeWithOwner(null,
                ArrayList.class, cls);
        return gson.fromJson(jsonStr, type);

    }

    public static <T> List<T> jsonToBeanList(String json, Class<T> t) {
        Gson gson = new Gson();
        List<T> list = new ArrayList<>();
        JsonParser parser = new JsonParser();
        JsonArray jsonarray = parser.parse(json).getAsJsonArray();

        for (JsonElement element : jsonarray) {
            list.add(gson.fromJson(element, t));
        }
        return list;
    }


}
