//package com.monkey1024.alist;
//
//import com.google.common.collect.HashBasedTable;
//import com.google.common.collect.Table;
//import org.junit.jupiter.api.BeforeEach;
//
//import java.beans.IntrospectionException;
//import java.beans.PropertyDescriptor;
//import java.lang.reflect.Field;
//import java.lang.reflect.InvocationTargetException;
//import java.lang.reflect.Method;
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
///**
// * @author Peekaboo
// * @date 2023年02月10日 11:33
// * 实现类似Sql Join操作
// */
//public class JoinTest {
//
//
//    public static <R, C, V> Table<R, C, V> createTable(List<Map<C, V>> listMap, R id) {
//        Table<R, C, V> table = HashBasedTable.create();
//        for (Map<C, V> map : listMap) {
//            for (Map.Entry<C, V> entry : map.entrySet()) {
//                table.put((R) map.get(id), entry.getKey(), entry.getValue());
//            }
//        }
//        return table;
//    }
//
//
//    public static <T, R, C, V> Table<R, C, V> createTable(List<T> objects, Class<T> aClass, String primaryKey) {
//        Table<R, C, V> table = HashBasedTable.create();
//        List<String> fieldNames = getFieldNames(aClass);
//        for (T t : objects) {
//            Object primaryKeyValue = getFieldValue(aClass, t, primaryKey);
//            for (String field : fieldNames) {
//                Object fieldValue = getFieldValue(aClass, t, field);
//                table.put((R) primaryKeyValue, (C) field, (V) fieldValue);
//            }
//        }
//        return table;
//    }
//
//    /**
//     * 通过反射的方式从一个java对象中获取指定属性的值
//     *
//     * @param aClass
//     * @param t
//     * @param field
//     * @param <T>
//     * @return
//     */
//    private static <T> Object getFieldValue(Class<?> aClass, T t, String field) {
//        Method getMethod;
//        PropertyDescriptor pd;
//        Object value = null;
//        try {
//            pd = new PropertyDescriptor(field, aClass);
//            getMethod = pd.getReadMethod();// 获得get方法
//            value = getMethod.invoke(t);
//        } catch (IntrospectionException | IllegalAccessException | InvocationTargetException e) {
//            e.printStackTrace();
//        }
//        return value;
//    }
//
//    /**
//     * 通过反射的方式从一个Class对象获取其所有属性的名称列表
//     *
//     * @param clazz
//     * @return
//     */
//    private static List<String> getFieldNames(Class<?> clazz) {
//        List<String> columnList = new ArrayList<>();
//        Field[] declaredFields = clazz.getDeclaredFields();
//        for (Field declaredField : declaredFields) {
//            String fieldName = declaredField.getName();
//            if (!fieldName.equals("serialVersionUID")) {
//                columnList.add(fieldName);
//            }
//        }
//        return columnList;
//    }
//
//    private Table<String, String, Object> leftTable;
//    private Table<String, String, Object> rightTable;
//
//    @BeforeEach
//    void createTable() {
//        Map<String, Object> map = new HashMap<>();
//        Map<String, Object> map1 = new HashMap<>();
//        Map<String, Object> map2 = new HashMap<>();
//        map.put("id", "a");
//        map.put("name", "x");
//        map1.put("id", "b");
//        map1.put("name", "y");
//        map2.put("id", "c");
//        map2.put("name", "z");
//        List<Map<String, Object>> list = new ArrayList<>();
//        list.add(map);
//        list.add(map1);
//        list.add(map2);
//        leftTable = JoinUtils.createTable(list, "id");
//
//        Map<String, Object> map3 = new HashMap<>();
//        Map<String, Object> map4 = new HashMap<>();
//        Map<String, Object> map5 = new HashMap<>();
//        map3.put("id", "a");
//        map3.put("val", "o");
//        map4.put("id", "b");
//        map4.put("val", "p");
//        map5.put("id", "d");
//        map5.put("val", "q");
//        List<Map<String, Object>> list2 = new ArrayList<>();
//        list2.add(map3);
//        list2.add(map4);
//        list2.add(map5);
//        rightTable = JoinUtils.createTable(list2, "id");
//        System.out.println("LeftTable");
//        JoinUtils.printTable(leftTable);
//        System.out.println("RightTable");
//        JoinUtils.printTable(rightTable);
//    }
//}
