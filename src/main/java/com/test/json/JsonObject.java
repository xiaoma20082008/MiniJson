package com.test.json;

import java.io.Serializable;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author machunxiao create at 2020-03-17
 */
public class JsonObject extends Json implements Map<String, Object>, Cloneable, Serializable {

    private static final long serialVersionUID = 1L;

    private final Map<String, Object> data;

    public JsonObject() {
        this(new LinkedHashMap<>());
    }

    public JsonObject(Map<String, Object> data) {
        this.data = data;
    }

    @Override
    public int size() {
        return this.data.size();
    }

    @Override
    public boolean isEmpty() {
        return this.data.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return this.data.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return this.data.containsValue(value);
    }

    @Override
    public Object get(Object key) {
        return this.data.get(key);
    }

    @Override
    public Object put(String key, Object value) {
        return this.data.put(key, value);
    }

    @Override
    public Object remove(Object key) {
        return this.data.remove(key);
    }

    @Override
    public void putAll(Map<? extends String, ?> m) {
        this.data.putAll(m);
    }

    @Override
    public void clear() {
        this.data.clear();
    }

    @Override
    public Set<String> keySet() {
        return this.data.keySet();
    }

    @Override
    public Collection<Object> values() {
        return this.data.values();
    }

    @Override
    public Set<Entry<String, Object>> entrySet() {
        return this.data.entrySet();
    }

    @Override
    public Object clone() {
        return new JsonObject(data instanceof LinkedHashMap ? data : new LinkedHashMap<>(data));
    }

    @Override
    public String toString() {
        return data.toString();
    }

}
