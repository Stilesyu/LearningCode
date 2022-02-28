import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Stiles yu
 * @since 1.0
 */
public class SetMethod {


//    public static void main(String[] args) throws FileNotFoundException {
//        ExcelReader reader = ExcelUtil.getReader("/Users/stilesyu/Downloads/代码中全部的权限串.xlsx");
//        List<Map<String, Object>> front = reader.readAll();
//        ExcelReader pr = ExcelUtil.getReader("/Users/stilesyu/Downloads/权限串比对结果.xlsx");
//        List<Map<String, Object>> permission = pr.readAll();
//        First:
//        for (Map<String, Object> map : permission) {
//            for (Map<String, Object> stringObjectMap : front) {
//                if (map.get("filters") == null) {
//                    continue First;
//                }
//                if (map.get("filters").equals(stringObjectMap.get("uri"))) {
//                    map.put("method", stringObjectMap.get("type"));
//                }
//            }
//        }
//        FileOutputStream stream = new FileOutputStream("/Users/stilesyu/Documents/权限串总对比.xlsx");
//        ExcelWriter writer = ExcelUtil.getWriter();
//        writer.write(permission);
//        writer.flush(stream);
//        writer.close();
//    }

//    @Test
//    public void test() throws FileNotFoundException {
//        ExcelReader reader = ExcelUtil.getReader("/Users/stilesyu/Downloads/admin未删除业务id接口版本.xlsx");
//        List<Map<String, Object>> front = reader.readAll();
//        ExcelReader pr = ExcelUtil.getReader("/Users/stilesyu/Documents/request.xlsx");
//        List<Map<String, Object>> permission = pr.readAll();
//        First:
//        for (Map<String, Object> map : permission) {
//            for (Map<String, Object> stringObjectMap : front) {
//                if (map.get("uri") == null) {
//                    continue First;
//                }
//                if (map.get("uri").equals(stringObjectMap.get("uri"))) {
//                    stringObjectMap.put("request", map.get("request"));
//                }
//            }
//        }
//        FileOutputStream stream = new FileOutputStream("/Users/stilesyu/Documents/对比.xlsx");
//        ExcelWriter writer = ExcelUtil.getWriter();
//        writer.write(front);
//        writer.flush(stream);
//        writer.close();
//    }

    public static void main(String[] args) throws FileNotFoundException {
        ExcelReader reader = ExcelUtil.getReader("/Users/stilesyu/Documents/result-font.xlsx");
        List<Map<String, Object>> front = reader.readAll();
        ExcelReader pr = ExcelUtil.getReader("/Users/stilesyu/Documents/request.xlsx");
        List<Map<String, Object>> permission = pr.readAll();
        First:
        for (Map<String, Object> map : permission) {
            for (Map<String, Object> stringObjectMap : front) {
                if (map.get("uri") == null) {
                    continue First;
                }
                if (map.get("uri").equals(stringObjectMap.get("uri"))) {
                    stringObjectMap.put("request", map.get("request"));
                    stringObjectMap.put("type", map.get("type"));
                    stringObjectMap.put("uri", map.get("mappingUri"));
                }
            }
        }
        front = front.stream().filter(s -> !((String) s.get("permission")).contains("BUSINESS")).collect(Collectors.toList());
        FileOutputStream stream = new FileOutputStream("/Users/stilesyu/Documents/对比.xlsx");
        ExcelWriter writer = ExcelUtil.getWriter();
        writer.write(front);
        writer.flush(stream);
        writer.close();
    }

}
