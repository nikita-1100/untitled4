package com.company;

import java.io.*;
import java.nio.Buffer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
Встречаемость символов
*/

public class Solution {
    public static void main(String[] args) throws IOException, InterruptedException {
        HashMap<Integer,byte[]> buffers = new HashMap<>();
        Scanner scanner = new Scanner(System.in);
        String filename=scanner.nextLine();
        String allFileName = filename.split(".part")[0];
        int count = 0;

        while (!filename.equals("end")) {
            try {
                FileInputStream fileInputStream = new FileInputStream(filename);
                byte[] buffer = new byte[fileInputStream.available()];
                fileInputStream.read(buffer);
                buffers.put(Integer.parseInt(filename.split(".part")[1]),buffer);
                fileInputStream.close();
                count+=1;
            } catch (FileNotFoundException e){
                System.out.println(filename);
                return;
            }
            filename = scanner.nextLine();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(allFileName);
        for (int i = 1; i<=count;i++) {
            fileOutputStream.write(buffers.get(i));
            System.out.println(i);
        }
        fileOutputStream.close();

//        for (int i : buffers.keySet()) {
//            System.out.println(i+" " + buffers.get(i));
//        }
    }
}

