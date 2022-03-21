package com.bin.david.form.data.table;


import com.bin.david.form.data.column.ArrayColumn;
import com.bin.david.form.data.column.Column;
import com.bin.david.form.data.column.MapColumn;
import com.bin.david.form.data.format.IFormat;
import com.bin.david.form.data.format.draw.IDrawFormat;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by huang on 2018/1/14.
 * Map表格数据
 * 可用于Json数据展示
 */

public class MapTableData extends TableData<Object> {

    private FilterColumnIntercept mIntercept;

    /**
     * 创建Map表格数据
     *
     * @param tableName 表格名
     * @param mapList   Map数组
     */
    public static MapTableData create(String tableName, List<Object> mapList) {
        return create(tableName, mapList, null,null);
    }

    /**
     * 创建Map表格数据
     *
     * @param tableName 表格名
     * @param mapList   Map数组
     */
    public static MapTableData create(String tableName, List<Object> mapList,String classity) {
        return create(tableName, mapList, null,classity);
    }


    /**
     * 创建Map表格数据
     *
     * @param tableName 表格名
     * @param mapList   Map数组
     * @param keyFormat map中key格式化
     */
    public static MapTableData create(String tableName, List<Object> mapList, IFormat<String> keyFormat,String classity) {
        if (mapList != null) {
            List<Column> columns = new ArrayList<>();
            getMapColumn(columns, Column.INVAL_VALUE, Column.INVAL_VALUE, mapList, keyFormat);

            if(classity!=null&&!classity.isEmpty()){
                //根据classity 设置表头
                columns = getNewColumn(columns,classity);
            }

            return new MapTableData(tableName, mapList, columns);
        }
        return null;
    }

    private static List<Column> getNewColumn(List<Column> columns, String classity) {

        try{

            if(columns.size() == 0){
                return columns;
            }

            //多表头 重新组装表头
//            List<Column> newColumns = new ArrayList<>();
//
//            if("Get_***".equals(classity)){
//                Column column0 = columns.get(0);column0.setColumnName("单位");
//                newColumns.add(column0);
//
//                Column column1 = columns.get(1);column1.setColumnName("***");
//                Column column2 = columns.get(2);column2.setColumnName("***");
//                Column column3 = columns.get(3);column3.setColumnName("***");
//                Column column4 = columns.get(4);column4.setColumnName("***");
//                Column column5 = columns.get(5);column5.setColumnName("***");
//                newColumns.add(new Column("***", column1, column2, column3, column4, column5));
//
//                Column column6 = columns.get(6);column6.setColumnName("***");
//                Column column7 = columns.get(7);column7.setColumnName("***");
//                Column column8 = columns.get(8);column8.setColumnName("***");
//                Column column9 = columns.get(9);column9.setColumnName("***");
//                Column column10 = columns.get(10);column10.setColumnName("***");
//
//                newColumns.add(new Column("***", column6, column7, column8, column9, column10));
//
//                return newColumns;
//            }else if("Get***".equals(classity)){//设施建设情况统计
//                newColumns.add(columns.get(0));
//
//                newColumns.add(new Column("***", columns.get(1), columns.get(2), columns.get(3), columns.get(4)));
//
//                Column column5 = columns.get(5);column5.setColumnName("***");
//                newColumns.add(column5);
//
//                Column column6 = columns.get(6);column6.setColumnName("***");
//                newColumns.add(column6);
//
//                newColumns.add(new Column("***", columns.get(7), columns.get(8), columns.get(9)));
//
//                newColumns.add(new Column("***", columns.get(10), columns.get(11), columns.get(12), columns.get(13)));
//
//                Column column14 = columns.get(14);column14.setColumnName("***");
//                Column column15 = columns.get(15);column15.setColumnName("***");
//                Column column16 = columns.get(16);column16.setColumnName("***");
//                Column column17 = columns.get(17);column17.setColumnName("地方");
//                Column column18 = columns.get(18);column18.setColumnName("***");
//                Column column19 = columns.get(19);column19.setColumnName("其他");
//                newColumns.add(new Column("***", column14, column15, column16, column17, column18,column19));
//
//                newColumns.add(new Column("***", columns.get(20), columns.get(21), columns.get(22)));
//
//
//                Column column23 = columns.get(23);column23.setColumnName("***");
//                newColumns.add(column23);
//
//                Column column24 = columns.get(24);column24.setColumnName("***");
//                newColumns.add(column24);
//
//                return newColumns;
//            }else if("Get***".equals(classity)){//设施运行情况统计
//                newColumns.add(columns.get(0));
//                newColumns.add(new Column("项目数量", columns.get(1), columns.get(2), columns.get(3), columns.get(4)));
//
//                newColumns.add(new Column("项目属性", columns.get(5), columns.get(6), columns.get(7), columns.get(8)));
//
//                Column column9 = columns.get(9);column9.setColumnName("合计");
//                Column column10 = columns.get(10);column10.setColumnName("***");
//                Column column11 = columns.get(11);column11.setColumnName("***");
//                Column column12 = columns.get(12);column12.setColumnName("地方");
//                Column column13 = columns.get(13);column13.setColumnName("***");
//                Column column14 = columns.get(14);column14.setColumnName("其他");
//                newColumns.add(new Column("***", column9, column10, column11, column12, column13, column14));
//
//                Column column15 = columns.get(15);column15.setColumnName("***");
//                newColumns.add(column15);
//
//
//                Column column16 = columns.get(16);column16.setColumnName("合计");
//                newColumns.add(new Column("***", column16, columns.get(17), columns.get(18)));
//
//                newColumns.add(new Column("***", columns.get(19), columns.get(20), columns.get(21)));
//
//                return newColumns;
//            }

            return columns;
        }catch (Exception e){
            e.printStackTrace();
            return columns;
        }
    }


    /**
     * 获取Map中所有字段
     * 暂时只支持Map中List数据解析 不支持数组[]
     */
    private static void getMapColumn(List<Column> columns, String fieldName, String parentKey, List<Object> mapList, IFormat<String> keyFormat) {
        if (mapList != null && mapList.size() > 0) {
            Object o = mapList.get(0);
            if (o != null) {
                if (o instanceof Map) {
                    Map<String, Object> map = (Map<String, Object>) o;
                    //暂时只能解析json每个层级一个Array
                    boolean isOneArray = true;
                    for (Map.Entry<String, Object> entry : map.entrySet()) {
                        String key = entry.getKey();
                        Object val = entry.getValue();

                        /////////////////UnitCode字段不显示在表中////////////////////////
                        if("UnitCode".equals(key)){
                            continue;
                        }
                        ////////////////////////////////////////////////////////////////

                        if (ArrayColumn.isList(val)) {
                            if (isOneArray) {
                                List<Object> list = ((List) val);
                                getMapColumn(columns, fieldName + key + ".", key, list, keyFormat);
                                isOneArray = false;
                            }
                        } else {
                            String columnName = keyFormat == null ? key : keyFormat.format(key);
                            MapColumn<Object> column = new MapColumn<>(columnName, fieldName + key);
                            columns.add(column);
                        }
                    }
                } else {
                    String columnName = keyFormat == null ? parentKey : keyFormat.format(parentKey);
                    MapColumn<Object> column = new MapColumn<>(columnName, fieldName, false);
                    columns.add(column);
                }
            }
        }
    }


    private MapTableData(String tableName, List t, List<Column> columns) {
        super(tableName, t, columns);

        //////固定第一列//////
        if(columns.size() > 0){
            columns.get(0).setFixed(true);
        }
        /////////////////////
    }

    /**
     * 设置绘制样式
     *
     * @param drawFormat
     */
    public void setDrawFormat(IDrawFormat drawFormat) {
        for (Column column : getColumns()) {
            column.setDrawFormat(drawFormat);
        }
    }

    /**
     * 设置格式化
     */
    public void setFormat(IFormat format) {
        for (Column column : getColumns()) {
            column.setFormat(format);
        }
    }

    /**
     * 设置最小宽度
     * @param minWidth
     */
    public void setMinWidth(int minWidth){
        for (Column column : getColumns()) {
            column.setMinWidth(minWidth);
        }
    }

    /**
     * 设置最小高度
     * @param minHeight
     */
    public void setMinHeight(int minHeight){
        for (Column column : getColumns()) {
            column.setMinHeight(minHeight);
        }
    }

    /**
     * 过滤列拦截器
     * 拦截则不会表格显示出来该列
     */
    public interface FilterColumnIntercept {
        /**
         * 是否拦截
         *
         * @param column     列
         * @param columnName 列名
         * @return 是否拦截
         */
        boolean onIntercept(Column column, String columnName);
    }

    /**
     * 获取过滤拦截器
     *
     * @return 过滤拦截器
     */
    public FilterColumnIntercept getFilterColumnIntercept() {
        return mIntercept;
    }

    /**
     * 设置过滤拦截器
     * 拦截则不会表格显示出来该列
     */
    public void setFilterColumnIntercept(FilterColumnIntercept intercept) {
        this.mIntercept = intercept;
        if (mIntercept != null) {
            for (int i = getColumns().size() - 1; i >= 0; i--) {
                Column column = getColumns().get(i);
                if (mIntercept.onIntercept(column, column.getColumnName())) {
                    getColumns().remove(i);
                }
            }
        }
    }



}
