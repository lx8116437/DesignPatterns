package com.lx.adapter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

/**
 * 适配器模式
 */
public class Main {
    public static void main(String[] args) throws Exception {
        FileInputStream fileInputStream = new FileInputStream("D:\\test.txt");
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String line;
        while ((line = bufferedReader.readLine()) != null ) {
            System.out.println(line);
        }
        bufferedReader.close();
    }
}
