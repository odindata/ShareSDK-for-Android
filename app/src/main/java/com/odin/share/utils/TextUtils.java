package com.odin.share.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TextUtils {

    public static String format(String sepStr, HashMap<String, Object> map) {
        StringBuffer msg = new StringBuffer();
        msg.append("{\n");
        String mySepStr = sepStr + "\t";
        int i = 0;
        for (Map.Entry<String, Object> entry : map.entrySet()) {
            if (i > 0) {
                msg.append(",\n");
            }
            msg.append(mySepStr).append('\"').append(entry.getKey()).append("\":");
            Object value = entry.getValue();
            if (value instanceof HashMap<?, ?>) {
                msg.append(format(mySepStr, (HashMap<String, Object>) value));
            } else if (value instanceof ArrayList<?>) {
                msg.append(format(mySepStr, (ArrayList<Object>) value));
            } else if (value instanceof String) {
                msg.append('\"').append(value).append('\"');
            } else {
                msg.append(value);
            }
            i++;
        }
        msg.append('\n').append(sepStr).append('}');
        return msg.toString();
    }

    private static String format(String sepStr, ArrayList<Object> list) {
        StringBuffer sb = new StringBuffer();
        sb.append("[\n");
        String mySepStr = sepStr + "\t";
        int i = 0;
        for (Object value : list) {
            if (i > 0) {
                sb.append(",\n");
            }
            sb.append(mySepStr);
            if (value instanceof HashMap<?, ?>) {
                sb.append(format(mySepStr, (HashMap<String, Object>) value));
            } else if (value instanceof ArrayList<?>) {
                sb.append(format(mySepStr, (ArrayList<Object>) value));
            } else if (value instanceof String) {
                sb.append('\"').append(value).append('\"');
            } else {
                sb.append(value);
            }
            i++;
        }
        sb.append('\n').append(sepStr).append(']');
        return sb.toString();
    }
}
