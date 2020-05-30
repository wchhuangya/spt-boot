package com.ch.wchya.study.sptboot.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @program: spt-boot
 * @description: Excel 工具类
 * @author: 王超
 * @create: 2020-05-25 22:32
 **/
public class ExcelOperUtils {

    public static final Map<String, Integer> positionRes = new HashMap<>();
    public static final Map<String, String> columnNameRes = new HashMap<>();

    static {
        List<String> columns = new ArrayList<>();
        for (char i = 'A'; i <= 'Z'; i++) {
            columns.add(String.valueOf(i));
        }
        for (char i = 'A'; i <= 'Z'; i++) {
            for (char j = 'A'; j <= 'Z'; j++) {
                columns.add(String.valueOf(i) + String.valueOf(j));
            }
        }
        for (int i = 0; i < columns.size(); i++) {
            positionRes.put(columns.get(i), i);
        }
        for (int i = 0; i < columns.size(); i++) {
            columnNameRes.put(String.valueOf(i), columns.get(i));
        }
    }

    /**
     * 根据列名获取列的序号（从 0 开始）
     * @param columnName 列名，例如：A，B，AA 等
     * @return 列名对应的列索引值（从 0 开始）
     */
    public static int getIndexByColumnName (String columnName) {
        return positionRes.get(columnName.toUpperCase());
    }

    public static String getColumnNameByIndex (int index) {
        return columnNameRes.get(String.valueOf(index));
    }
}
