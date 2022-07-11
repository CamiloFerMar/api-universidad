package com.simplespasos.ultimate.universidadbackend.util;

import java.net.InetSocketAddress;
import java.util.HashMap;
import java.util.Map;

public class ResponseEntityUtil {

    public ResponseEntityUtil() {
    }

    public Map<String, Object> getResponseBadRequest(String message){
        Map<String, Object> result = new HashMap<>();
        result.put("success", Boolean.FALSE);
        result.put("message", message);

        return result;
    }

    public Map<String, Object> getResponseOk(Object object){
        Map<String, Object> result = new HashMap<>();
        result.put("success", Boolean.TRUE);
        result.put("datos", object);

        return result;
    }
}
