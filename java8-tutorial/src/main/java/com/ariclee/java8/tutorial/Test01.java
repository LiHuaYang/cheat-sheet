package com.ariclee.java8.tutorial;

import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;

public class Test01 {

    public static void main1(String[] args) {
        List<String> names = Arrays.asList("peter", "anna", "mike", "xenia");
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return b.compareTo(a);
            }
        });
        Collections.sort(names, (a, b) -> b.compareTo(a));
        Collections.sort(names, Comparator.reverseOrder());
    }

    public static void main(String[] args) {
        Converter<String, Integer> converter = (from) -> Integer.valueOf(from);
        Integer converted = converter.convert("123");
        System.out.println(converted);    // 123


        Converter<String, Integer> converter1 = Integer::valueOf;
        Integer converted1 = converter.convert("123");
        System.out.println(converted1);   // 123

        Something something = new Something();
        Converter<String, String> converter2 = something::startsWith;
        String converted2 = converter2.convert("Java");
        System.out.println(converted2);   // J
    }

    // 删除在 ori 中小于 10 的元素
    // 并把小于 10 的元素加入到另一个容器
    @Test
    public void test() {
        List<Integer> ori = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 9, 100));
        List<Integer> tar = new ArrayList<>();
//        ori = ori.stream().peek(item -> { if (item < 10) tar.add(item);}).filter(item -> item > 10).collect(Collectors.toList());
        ori.removeIf(item -> {
            if (item < 10) {
                tar.add(item);
                return true;
            }
            return false;
        });

        System.out.println("ori:" + ori); // 100
        System.out.println("tar:" + tar); // 1, 2, 3, 4, 9
    }

    @Test
    public void test2() {
        List<Integer> ori = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 9, 100)); // Arrays.asList(1, 2, 3, 4, 9, 100)
        List<Integer> aaa = ori.stream().peek(System.out::println).collect(Collectors.toList());
    }

    @Test
    public void test3() {
//        List<Integer> ori = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 9, 100)); // Arrays.asList(1, 2, 3, 4, 9, 100)
//
//        ori.forEach(i -> {
//            if (i == 1) {
//                // return ;
//                return;
//            }
//            System.out.println(i);
//        });

//        System.out.println(Arrays.stream(new String[]{"aa", "sss"}).anyMatch(item -> item.equals("aaa")));
        System.out.println("CE330002,PE330002,aaa".contains("aaa"));
    }

    private static Integer sum = 0;

    @Test
    public void test4() throws Exception {
        while (true) {
            sum++;
            System.out.println("test4");
            Thread.sleep(1000);
            if (sum == 5) {
                break;
            }
        }
    }

    @Test
    public void test5() {
        List<String> list = new ArrayList<String>();
        list.add("11"); // 能移
        list.add("11"); // 不能移
        list.add("12");
        list.add("13");
        list.add("14");
        list.add("11"); // 能移
        list.add("15");
        list.add("16");
        System.out.println("原始list元素："+ list.toString());

        //通过下表移除等于11的元素
        for (int i = 0; i < list.size(); i++) {
            String item = list.get(i);
            if("11".equals(item)) {
                list.remove(i);
            }
            if ("12".equals(item)) {
//                list.remove(i);
            }
        }
        System.out.println("通过下表移除后的list元素："+ list.toString());
    }
}
