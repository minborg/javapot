package com.blogspot.minborgsjavapot.escape_analysis;

import java.io.IOException;

public class Main {

    /*
    -server
-XX:BCEATraceLevel=3
-XX:+PrintCompilation
-XX:+UnlockDiagnosticVMOptions
-XX:+PrintInlining
-verbose:gc
-XX:MaxInlineSize=256
-XX:FreqInlineSize=1024
-XX:MaxBCEAEstimateSize=1024
-XX:MaxInlineLevel=22
-XX:CompileThreshold=10
-Xmx4g
-Xms4g

     */
    public static void main(String[] args) throws IOException, InterruptedException {

        Point p = new Point(100, 200);

        sum(p);
        System.gc();
        System.out.println("Press any key to continue");
        System.in.read();
        //Thread.sleep(1_000);
        long sum = sum(p);

        System.out.println(sum);
        System.out.println("Press any key to continue2");
        System.in.read();

        sum = sum(p);

        System.out.println(sum);
        System.out.println("Press any key to exit");
        System.in.read();

    }

    private static long sum(Point p) {
        long sumLen = 0;
        for (int i = 0; i < 1_000_000; i++) {
            sumLen += p.toString().length();
        }
        return sumLen;

    }

}
