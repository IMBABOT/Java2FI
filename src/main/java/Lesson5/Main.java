package Lesson5;

import java.util.Arrays;

public class Main {

    private static final int SIZE = 10000000;
    private static final int H = SIZE/2;
    private static final float[] arr = new float[SIZE];

    private static float[] first = new float[H];
    private static float[] second = new float[SIZE];

    private static String method(){
        for (int i = 0; i < arr.length ; i++) {
            arr[i] = 1;
        }
        long a = System.currentTimeMillis();

        for (int i = 0; i < arr.length ; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }


        long time = System.currentTimeMillis() - a;

        float data = 0;
        for (int i = 0; i < arr.length; i++) {
            data += arr[i];
        }

        return time + " " + data;
    }

    private static String method1(){
        for (int i = 0; i < arr.length ; i++) {
            arr[i] = 1;
        }

        long a = System.currentTimeMillis();
        System.arraycopy(arr, 0, first, 0, H);
        System.arraycopy(arr, H, second, H, H);


        Thread t = new Thread(new MyThread(first, 0));
        Thread t2 = new Thread(new MyThread(second, H));
        t.start();
        t2.start();

        try {
            t.join();
            t2.join();
        }catch (InterruptedException e){
            e.printStackTrace();
        }


        System.arraycopy(first, 0, arr, 0, H);
        System.arraycopy(second, H, arr, H, H);

        long time = System.currentTimeMillis() - a;

        float second = 0;
        for (int i = 0; i <arr.length ; i++) {
            second += arr[i];
        }




        return time + " " + second;
    }

    public static void main(String[] args) {
        System.out.println(method());
        System.out.println(method1());


    }
}
