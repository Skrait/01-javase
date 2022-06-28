//package com.krait.ipaddress.utils;
//
//import org.lionsoul.ip2region.DbConfig;
//import org.lionsoul.ip2region.DbMakerConfigException;
//import org.lionsoul.ip2region.DbSearcher;
//
//import java.io.FileNotFoundException;
//
///**
// * @Author Peekaboo
// * Date 2022/6/27 20:57
// */
//public class iP2RegionUtils {
//
//
//    static {
//        dbPath = createFtlFileByFtlArray() + "ip2region.db";
//        try {
//            config = new DbConfig();
//        } catch (DbMakerConfigException e) {
//            e.printStackTrace();
//        }
//        try {
//            searcher = new DbSearcher(config, dbPath);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//
//}
