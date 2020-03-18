package com.test.json;

import com.test.json.Json;
import com.test.json.JsonUtils;
import org.junit.Test;

/**
 * @author machunxiao create at 2020-03-17
 */
public class JsonTest {

    @Test
    public void test_parse() {
        String json1 = "{\"msg\": \"\", \"table_info\": {\"t_user_advice\": {\"mobile_phone\": {\"plain_text\": \"\", \"cipher_text\": \"encryption_mobile_phone\", \"logic_text\": \"mobile_phone\", \"is_cipher\": \"True\"}, \"mobilePhone\": {\"plain_text\": \"\", \"cipher_text\": \"encryption_mobile_phone\", \"logic_text\": \"mobilePhone\", \"is_cipher\": \"True\"}}, \"t_user_info_audit\": {\"mobile_phone\":{\"plain_text\": \"\", \"cipher_text\": \"encryption_mobile_phone\", \"logic_text\": \"mobile_phone\", \"is_cipher\": \"True\"}, \"mobilePhone\": {\"plain_text\": \"\", \"cipher_text\": \"encryption_mobile_phone\", \"logic_text\": \"mobilePhone\", \"is_cipher\": \"True\"}}}, \"code\": 200, \"dbname\": \"bike_user_platform\"}";
        Json js1 = JsonUtils.parse(json1);
        System.out.println(js1);
    }

}
