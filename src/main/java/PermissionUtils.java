import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * @author Stiles yu
 * @since 1.0
 */
public class PermissionUtils {


    public static void main(String[] args) throws FileNotFoundException {
        ExcelReader reader = ExcelUtil.getReader("/Users/stilesyu/Downloads/open.xlsx");
        List<Map<String, Object>> front = reader.readAll();
        ExcelReader pr = ExcelUtil.getReader("/Users/stilesyu/Documents/权限串总对比.xlsx");
        List<Map<String, Object>> permission = pr.readAll();
        Iterator<Map<String, Object>> iterable = permission.iterator();
        First:
        while (iterable.hasNext()) {
            Map<String, Object> map = iterable.next();
            if (!map.containsKey("filters") || map.get("filters") == null || map.get("filters").equals("filters")) {
                iterable.remove();
                continue;
            }
            for (Map<String, Object> stringObjectMap : front) {
                if (map.get("filters").equals(stringObjectMap.get("filters"))) {
                    continue First;
                }
            }
            iterable.remove();
        }
        FileOutputStream stream = new FileOutputStream("/Users/stilesyu/Documents/result-open.xlsx");
        ExcelWriter writer = ExcelUtil.getWriter();
        writer.write(permission);
        writer.flush(stream);
        writer.close();
    }




}
