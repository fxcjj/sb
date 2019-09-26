package com.vic.sb09.vo;

/**
 * @author 罗利华
 * date: 2019/8/28 14:23
 */
public class Test {

    public static void main(String[] args) {
        String a = "27146661";
        Long relationId = Long.valueOf(a);
//        System.out.println(relationId);
        test();

    }

    private static void test() {
        try {
            int a = 1/0;

        } catch (Exception e) {
            System.out.println("关闭1");
            throw e;
        } finally {
            System.out.println("关闭2");
            System.out.println("aa");
        }
    }
}
