package eu.miaplatform.customplugin.springboot;

import java.io.IOException;
import java.util.Map;

import ch.qos.logback.contrib.jackson.JacksonJsonFormatter;

public class CustomJSONFormatter extends JacksonJsonFormatter {
    @Override
    public String toJsonString(Map map) throws IOException {
        map.put("level", mapOriginalLevelToInt((String) map.get("level")));

        String message = (String) map.get("message");
        map.put("msg", message);
        map.remove("message");

        return super.toJsonString(map);
    }

    private int mapOriginalLevelToInt(String level) {
        switch (level) {
            case "TRACE": return 10;
            case "DEBUG": return 20;
            case "WARN":  return 40;
            case "ERROR": return 50;
            case "INFO":
            default:
                return 30;
        }
    }
}
