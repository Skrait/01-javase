//package com.jg.Stream;
//import com.jg.pojo.Book;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.function.Function;
//import java.util.function.Predicate;
//import java.util.stream.Collectors;
//
///**
// * ? extends T 指T类型或T的子类型
// * ? super T   指T类型或T的父类型
// * https://blog.csdn.net/haiyoung/article/details/80934467
// */
//public class DistinctWithUserObjects {
//    public static void main(String[] args) {
//        List<Book> list = new ArrayList<>();
//        {
//           list.add(new Book("Core Java", 200));
//           list.add(new Book("Core Java", 200));
//           list.add(new Book("Learning Freemarker", 150));
//           list.add(new Book("Spring MVC", 300));
//           list.add(new Book("Spring MVC", 300));
//        }
//        long l = list.stream().distinct().count();
//        System.out.println("No. of distinct books:"+l);
//        Predicate<String> predicate = str -> str.length() > 0;
//
//        List<Book> collect = list.stream().distinct().collect(Collectors.toList());
//
//        Double l1 = 1.222332;
////        Function l2;
////        String apply = l2.apply(l1);
//        //list.stream().distinct().forEach(b -> System.out.println(b.getName()+ "," + b.getPrice()));
//        list.stream().filter(distinctByKey(book -> book.getName())).forEach(b->{
//            System.out.println(b.getName() + "," + b.getPrice());
//        });
//    }
//
//
//
////    static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
////        Map<Object,Boolean> seen = new ConcurrentHashMap<>();
////
////        //Predicate<Function> predicate = t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
////        //return predicate;
////        //return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
////
////    }
//}