package com.test.json;

import com.alibaba.fastjson.JSON;
import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;

import java.util.concurrent.TimeUnit;

/**
 * @author machunxiao create at 2020-03-18
 */
@OutputTimeUnit(TimeUnit.NANOSECONDS)
@BenchmarkMode(Mode.AverageTime)
public class Main {

    public static void main(String[] args) throws Exception {
        Options options = new OptionsBuilder().include(Main.class.getName()).forks(1).build();
        new Runner(options).run();
    }

    @Benchmark
    @Threads(5)
    public void runFastJson() {
        String json = "{\"msg\": \"\", \"table_info\": {\"t_user_advice\": {\"mobile_phone\": {\"plain_text\": \"\", \"cipher_text\": \"encryption_mobile_phone\", \"logic_text\": \"mobile_phone\", \"is_cipher\": \"True\"}, \"mobilePhone\": {\"plain_text\": \"\", \"cipher_text\": \"encryption_mobile_phone\", \"logic_text\": \"mobilePhone\", \"is_cipher\": \"True\"}}, \"t_user_info_audit\": {\"mobile_phone\":{\"plain_text\": \"\", \"cipher_text\": \"encryption_mobile_phone\", \"logic_text\": \"mobile_phone\", \"is_cipher\": \"True\"}, \"mobilePhone\": {\"plain_text\": \"\", \"cipher_text\": \"encryption_mobile_phone\", \"logic_text\": \"mobilePhone\", \"is_cipher\": \"True\"}}}, \"code\": 200, \"dbname\": \"bike_user_platform\"}";
        JSON.parse(json);
    }

    //
    @Benchmark
    @Threads(5)
    public void runMiniJson() {
        String json = "{\"msg\": \"\", \"table_info\": {\"t_user_advice\": {\"mobile_phone\": {\"plain_text\": \"\", \"cipher_text\": \"encryption_mobile_phone\", \"logic_text\": \"mobile_phone\", \"is_cipher\": \"True\"}, \"mobilePhone\": {\"plain_text\": \"\", \"cipher_text\": \"encryption_mobile_phone\", \"logic_text\": \"mobilePhone\", \"is_cipher\": \"True\"}}, \"t_user_info_audit\": {\"mobile_phone\":{\"plain_text\": \"\", \"cipher_text\": \"encryption_mobile_phone\", \"logic_text\": \"mobile_phone\", \"is_cipher\": \"True\"}, \"mobilePhone\": {\"plain_text\": \"\", \"cipher_text\": \"encryption_mobile_phone\", \"logic_text\": \"mobilePhone\", \"is_cipher\": \"True\"}}}, \"code\": 200, \"dbname\": \"bike_user_platform\"}";
        JsonUtils.parse(json);
    }
}
