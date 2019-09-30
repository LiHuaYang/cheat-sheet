package com.ariclee.test;

import java.util.*;

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
}
