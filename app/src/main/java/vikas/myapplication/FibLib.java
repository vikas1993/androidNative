package vikas.myapplication;

import android.util.Log;

public class FibLib {
    private static long fib(long n){
        return n <=0 ? 0:n==1?1: fib(n-1)+fib(n-2);
    }

    public  static long fibJR(long n){
        Log.d("Log from Java ","fibjrR("+n+")" );
        return fib(n);
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public  static  native long fibNR(long n);
}
