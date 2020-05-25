package pl.technologieobiektowe.backendjava;

import org.springframework.stereotype.Component;

import java.util.Random;

//@Component
public class TestData {

    private static String data1k;
    private static String data3k;
    private static String data5k;
    private static String data10k;
    private static String data20k;
    private static String data50k;
    private static String data1m;
    private static String data3m;
    private static String data5m;
    private static String data10m;

    private static String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ 0123456789";
    Random rnd = new Random();

    public TestData() {
        System.out.println("Konstruktor");
        data1k = prepareData(1);
        System.out.println("1k - generated");
        data3k = prepareData(3);
        System.out.println("3k - generated");
        data5k = prepareData(5);
        System.out.println("5k - generated");
        data10k = prepareData(10);
        System.out.println("10k - generated");
        data20k = prepareData(20);
        System.out.println("20k - generated");
        data50k = prepareData(50);
        System.out.println("50k - generated");
        data1m = prepareData(1024);
        System.out.println("1m - generated");
        data3m = prepareData(1024*3);
        System.out.println("3m - generated");
        data5m = prepareData(1024*5);
        System.out.println("5m - generated");
        data10m = prepareData(10240);
        System.out.println("10m - generated");
        System.out.println("Test data prepared");
    }

    private String prepareData(int howMuchDataKB) {
        String data = new String();
        String tmp = new String();
        for (int i = 0; i < 1024 ; i++) {
            tmp += chars.charAt(rnd.nextInt(chars.length()));
        }
        for (int i = 0; i < howMuchDataKB; i++) {
            data += tmp;
        }
        return data;
    }


    public static String getData1k() {
        return data1k;
    }
    public static String getData3k() {
        return data3k;
    }
    public static String getData5k() {
        return data5k;
    }
    public static String getData10k() {
        return data10k;
    }
    public static String getData20k() {
        return data20k;
    }
    public static String getData50k() {
        return data50k;
    }
    public static String getData1m() {
        return data1m;
    }
    public static String getData3m() {
        return data3m;
    }
    public static String getData5m() {
        return data5m;
    }
    public static String getData10m() {
        return data10m;
    }
//    public static String getData10m() {
//        return data10m;
//    }
}
