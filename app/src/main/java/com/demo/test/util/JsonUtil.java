package com.demo.test.util;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

/**
 * Created by Administrator on 2021/9/6.
 */

public class JsonUtil {
    private static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.CHINESE);
    private static ObjectMapper mapper = new ObjectMapper();

    /**
     * JSON反序列化为对象
     *
     * @param json
     * @param cls
     * @param ignoreUnknown
     * @param dateFormat
     * @return
     */
    public static <T> List<T> jsonToObjs(String json, Class<T> cls, boolean ignoreUnknown, DateFormat dateFormat) {
        List<T> objs = null;
        try {
            if (!CharSeqUtil.isNullOrEmpty(json)) {
                ObjectMapper copyMapper = mapper.copy();
                objs = copyMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, !ignoreUnknown)
                        .setDateFormat(dateFormat)
                        .readValue(json, copyMapper.getTypeFactory().constructCollectionType(List.class, cls));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return objs;
    }

    public static <T> List<T> jsonToObjs(String json, Class<T> cls) {
        return jsonToObjs(json, cls, false, dateFormat);
    }
}
