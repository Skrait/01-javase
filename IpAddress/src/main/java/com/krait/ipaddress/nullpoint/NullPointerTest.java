//package com.krait.ipaddress.nullpoint;
//
//import org.apache.commons.collections4.CollectionUtils;
//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
//import org.testng.annotations.Test;
//
//import java.util.Collections;
//import java.util.List;
//import java.util.Objects;
//
///**
// * 空指针判断测试.
// * @author xindaqi
// * @date 2021-12-16 9:55
// */
//public class NullPointerTest {
//
//    private static final Logger logger = LogManager.getLogger(NullPointerTest.class);
//
//    private static final String TEST_VALUE = "test";
//
//    /**
//     * 引用类型：直接使用null判断空指针
//     */
//    @Test
//    public void nullRawTest() {
//        String var1 = null;
//        if (null == var1) {
//            logger.info(">>>>>>>>>>var1 is null");
//        } else {
//            logger.info(">>>>>>>>>>var1 is:{}", var1);
//        }
//    }
//
//    /**
//     * 引用类型：使用Objects工具判断空指针
//     */
//    @Test
//    public void nullUnderObjectsTest() {
//        String var1 = null;
//        if (Objects.isNull(var1)) {
//            logger.info(">>>>>>>>>>var1 is null");
//        } else {
//            logger.info(">>>>>>>>>>var1 is:{}", var1);
//        }
//    }
//
//    /**
//     * 集合类型：直接使用null判断空指针
//     */
//    @Test
//    public void nullCollectionUnderRawTest() {
//        List<String> list1 = null;
//        if (null == list1) {
//            logger.info(">>>>>>>>>>list1 is null");
//        } else if (list1.isEmpty()) {
//            logger.info(">>>>>>>>>>list1 is empty");
//        } else {
//            logger.info(">>>>>>>>>>list1 is:{}", list1);
//        }
//    }
//
//    /**
//     * 集合类型：使用Objects判断空指针
//     */
//    @Test
//    public void nullCollectionUnderObjectsTest() {
//        List<String> list1 = null;
//        if (Objects.isNull(list1)) {
//            logger.info(">>>>>>>>>>list1 is null");
//        } else if (list1.isEmpty()) {
//            logger.info(">>>>>>>>>>list1 is empty");
//        } else {
//            logger.info(">>>>>>>>>>list1 is:{}", list1);
//        }
//    }
//
//    /**
//     * 集合类型：使用CollectionUtils判断空指针和空数据
//     */
//    @Test
//    public void nullUnderCollectionUtilsTest() {
//        List<String> list1 = null;
//        if (CollectionUtils.isEmpty(list1)) {
//            logger.info(">>>>>>>>>>var1 is null or empty");
//        } else {
//            logger.info(">>>>>>>>>>var1 is:{}", list1);
//        }
//    }
//
//    /**
//     * 集合类型：使用CollectionUtils判断空指针和空数据
//     */
//    @Test
//    public void emptyUnderCollectionUtilsTest() {
//        List<String> list1 = Collections.emptyList();
//        if (CollectionUtils.isEmpty(list1)) {
//            logger.info(">>>>>>>>>>var1 is null or empty");
//        } else {
//            logger.info(">>>>>>>>>>var1 is:{}", list1);
//        }
//    }
//}
