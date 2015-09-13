//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

package org.msdg.framework.controller.param;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;

public class Result extends HashMap<String, Object> {
    public Result() {
    }

    public Result(Result.STATUS status) {
        this(status, "");
    }

    public Result(Result.STATUS status, String message) {
        this.put((String)"status", status.name().toLowerCase()).put((String) "message", message);
    }

    public Result put(String key, Object value) {
        super.put(key, value);
        return this;
    }
    public String toJson() {
        StringWriter jsonWriter = new StringWriter();
        ObjectMapper mapper = new ObjectMapper();

        try {
            mapper.writeValue(jsonWriter, this);
            return jsonWriter.toString();
        } catch (IOException var4) {
            var4.printStackTrace();
            return "";
        }
    }

    public String toJson(String callback) {
        return StringUtils.isEmpty(callback)?this.toJson():callback + "(" + this.toJson() + ")";
    }

    public Result clone() {
        return (Result)super.clone();
    }

    public String toString() {
        return this.toJson();
    }

    public static enum STATUS {
        OK,
        FAIL;

        private STATUS() {
        }
    }
}
