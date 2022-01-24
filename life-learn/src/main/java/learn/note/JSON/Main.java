package learn.note.JSON;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONValidator;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author WangWenLei
 * @DATE: 2021/4/16
 **/
public class Main {
    public static void main(String[] args) {
        String json = "{\n" +
                "    \"appraisedisposeid\":50,\n" +
                "    \"oauserids\":[\n" +
                "        {\n" +
                "            \"appraisedisposeid\":50,\n" +
                "            \"oauserids\":[\n" +
                "                \"233950\",\n" +
                "                \"235887\"\n" +
                "            ],\n" +
                "            \"groupName\":\"平台集团\",\n" +
                "            \"type\":1\n" +
                "        },\n" +
                "        {\n" +
                "            \"appraisedisposeid\":50,\n" +
                "            \"oauserids\":[\n" +
                "                \"233950\",\n" +
                "                {\n" +
                "                    \"appraisedisposeid\":50,\n" +
                "                    \"oauserids\":[\n" +
                "                        \"233950\",\n" +
                "                        \"235887\"\n" +
                "                    ],\n" +
                "                    \"groupName\":\"平台集团\",\n" +
                "                    \"type\":1,\n" +
                "                    \"pageSize\":\"20\"\n" +
                "                }\n" +
                "            ],\n" +
                "            \"groupName\":\"平台集团\",\n" +
                "            \"type\":1\n" +
                "        }\n" +
                "    ],\n" +
                "    \"groupName\":\"平台集团\",\n" +
                "    \"type\":1\n" +
                "}";
        Map<String, String> hitMap = new HashMap<>();
        String keyName = "pageSize";
        findInResponseBody(hitMap, json, keyName,"测试");
        System.out.println(hitMap.toString());
    }

    private static void findInResponseBody(Map<String, String> hitMap, String json, String keyName, String name) {
        if (StringUtils.isBlank(json)) {
            return;
        }
        JSONValidator from = JSONValidator.from(json);
        if(!from.validate()){
            return;
        }
        if ("Array".equals(from.getType().name())) {
            JSONArray jsonArray = JSONArray.parseArray(json);
            jsonArray.stream().forEach(item -> {
                findInResponseBody(hitMap, JSONObject.toJSONString(item), keyName, name);
            });
        } else if ("Object".equals(from.getType().name())) {
            JSONObject data = JSONObject.parseObject(json);
            if (data.containsKey(keyName)) {
                String hitData = data.getString(keyName);
                hitMap.put(name, hitData);
                return;
            }

            data.entrySet().forEach(item -> {
                findInResponseBody(hitMap, JSONObject.toJSONString(item.getValue()), keyName, name);
            });
        } else if("Value".equals(from.getType().name())){
            return;
        } else {
            return;
        }
    }
}