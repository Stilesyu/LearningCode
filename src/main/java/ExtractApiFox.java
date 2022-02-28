import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.util.URLUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import models.Components;
import models.OpenAPI;
import models.Operation;
import models.media.Schema;
import models.parameters.Parameter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Stiles yu
 * @since 1.0
 */
public class ExtractApiFox {

    private static Components components;

    public static void main(String[] args) throws FileNotFoundException, JsonProcessingException {
        FileReader reader = new FileReader("/Users/stilesyu/Downloads/13.json");
        String content = reader.readString();
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        OpenAPI api = mapper.readValue(content, OpenAPI.class);
        List<Car> cars = new ArrayList<>();
        components = api.getComponents();
        for (String path : api.getPaths().keySet()) {
            Car car = new Car();
            cars.add(car);
            car.setUri(path);
            Map<String, Object> map = new HashMap<>();
            Operation operation = api.getPaths().get(path).getPost();
            if (operation == null) {
                car.setType("get");
                operation = api.getPaths().get(path).getGet();
                String padding = "?";
                boolean isFirst = true;
                for (Parameter parameter : operation.getParameters()) {
                    if (parameter.getName().equals("Authorization") || parameter.getName().equals("Content-type") || !parameter.getRequired()) {
                        continue;
                    }
                    if (!isFirst) {
                        padding = padding + "&";
                    }
                    if (parameter.getName().endsWith("At") || parameter.getName().endsWith("Time")) {
                        padding = padding + parameter.getName() + "=2022-03-29T16:00:00.000Z";
                    } else {
                        padding = padding + parameter.getName() + "=2";
                    }
                    isFirst = false;
                }
                car.setMappingUri(car.getUri() + padding);
            } else {
                car.setType("post");
                if (operation.getRequestBody() == null) {
                    continue;
                }
                Schema schema = operation.getRequestBody().getContent().get("application/json").getSchema();
                if (schema.getProperties() == null) {
                    if (schema.get$ref() != null) {
                        String[] refs = schema.get$ref().split("/");
                        String name = refs[refs.length - 1];
                        map = parseSchema(name);
                    }
                } else {
                    for (Object o : schema.getProperties().keySet()) {
                        Schema innerSchema = (Schema) schema.getProperties().get(o);
                        map.put((String) o, initObject(innerSchema));
                    }
                }
                car.setRequest(JSONObject.toJSONString(map));
                car.setMappingUri(car.getUri());
            }
        }
        FileOutputStream stream = new FileOutputStream("/Users/stilesyu/Documents/request.xlsx");
        ExcelWriter writer = ExcelUtil.getWriter();
        writer.write(cars);
        writer.flush(stream);
        writer.close();
    }

    public static Map<String, Object> parseSchema(String schemaName) {
        if (schemaName.startsWith("%")) {
            schemaName = URLUtil.decode(schemaName);
        }
        Schema schema = components.getSchemas().get(schemaName);
        Map<String, Object> result = new HashMap<>();
        if (schema == null) {
            throw new NullPointerException();
        }
        if (schema.getProperties() == null) {
            return result;
        }
        for (Object o : schema.getProperties().keySet()) {
            Schema innerSchema = (Schema) schema.getProperties().get(o);
            if (innerSchema.get$ref() != null) {
                String[] refs = innerSchema.get$ref().split("/");
                String name = refs[refs.length - 1];
                result.put((String) o, parseSchema(name));
            } else {
                result.put((String) o, initObject(innerSchema));
            }
        }
        return result;
    }

    public static Object initObject(Schema schema) {
        String type = schema.getType();
        if ("integer".equals(type)) {
            return 2;
        } else if ("long".equals(type)) {
            return 2;
        } else if ("boolean".equals(type)) {
            return true;
        } else if (schema.getEnum() != null) {
            return schema.getEnum().get(0);
        } else if ("array".equals(type)) {
            List<Object> list = new ArrayList<>();
            if (schema.getItems().get$ref() != null) {
                String[] refs = schema.getItems().get$ref().split("/");
                String name = refs[refs.length - 1];
                Map<String, Object> map = parseSchema(name);
                list.add(map);
            } else {
                if ("string".equals(schema.getItems().getType())) {
                    list.add("12312");
                } else if ("object".equals(schema.getItems().getType()) && schema.getItems().getProperties() != null) {
                    Map<String, Object> map = new HashMap<>();
                    for (Object o : schema.getItems().getProperties().keySet()) {
                        Schema innerSchema = (Schema) schema.getItems().getProperties().get(o);
                        map.put((String) o, initBasicObject(innerSchema));
                    }
                    list.add(map);
                } else {
                    list.add(2);
                }
            }
            return list;
        } else if ("date-time".equals(schema.getFormat())) {
            return "2022-03-29T16:00:00.000Z";
        }
        return "222";
    }

    public static Object initBasicObject(Schema schema) {
        String type = schema.getType();
        if ("string".equals(type)) {
            return "222";
        } else if ("date-time".equals(schema.getFormat())) {
            return "2022-03-29T16:00:00.000Z";
        } else if ("boolean".equals(type)) {
            return true;
        } else {
            return 2;
        }
    }

    @Data
    static class Car {
        private String uri;
        private String mappingUri;
        private String request;
        private String type;
    }


}
