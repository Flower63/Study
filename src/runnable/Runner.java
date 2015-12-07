package runnable;

/**
 * Created by Flower on 12/7/2015.
 */
public class Runner implements Runnable {
    public static int[] arr = new int[10];
    public static int result;

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Runner());

        for (int i = 0; i < 10; i++) {
            arr[i] = i;
        }

        thread.start();

        int res = 0;

        for (int i = arr.length / 2; i < arr.length; i++) {
            res += arr[i];
        }

        thread.join();

        result += res;

        System.out.println(result);
    }

    @Override
    public void run() {
        int res = 0;

        for (int i = 0; i < arr.length / 2; i++) {
            res += arr[i];
        }

        result += res;
    }
}
