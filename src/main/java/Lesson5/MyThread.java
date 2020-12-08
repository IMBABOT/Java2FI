package Lesson5;

public class MyThread implements Runnable{
    private float[] arr;
    private int offset;

    public MyThread(float[] arr, int offset){
        this.arr = arr;
        this.offset = offset;
    }


    @Override
    public void run() {
        for (int i = offset; i < arr.length ; i++) {
            arr[i] = (float)(arr[i] * Math.sin(0.2f + i / 5) * Math.cos(0.2f + i / 5) * Math.cos(0.4f + i / 2));
        }
    }
}
