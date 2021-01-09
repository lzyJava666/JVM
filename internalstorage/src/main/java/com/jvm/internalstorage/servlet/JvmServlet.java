package com.jvm.internalstorage.servlet;

import java.text.DecimalFormat;

public class JvmServlet {
    public static void main(String[] args) {
        byte[] bs = new byte[1*1024*1024];
        System.out.println("分配了1M的内存空间");
        jvmInfo();
        byte[] bs1 = new byte[4*1024*1024];
        System.out.println("分配了4M的内存空间");
        jvmInfo();
    }
    public static String toM(long byteNum) {
        float num = byteNum/(1024*1024);
        DecimalFormat df = new DecimalFormat("0.00");
        String str = df.format(num);
        return str;
    }
    public static void jvmInfo() {
        //获取配置的最大内存
        long maxMemory = Runtime.getRuntime().maxMemory();
        System.out.println("maxMemory:" + maxMemory + "字节，" + toM(maxMemory) + "M");

        //获取空闲的内存大小
        long freeMemory = Runtime.getRuntime().freeMemory();
        System.out.println("freeMemory:" + maxMemory + "字节，" + toM(freeMemory) + "M");

        //获取当前使用掉的内存大小
        long totalMemory = Runtime.getRuntime().totalMemory();
        System.out.println("totalMemory:" + maxMemory + "字节，" + toM(totalMemory) + "M");
    }
}
