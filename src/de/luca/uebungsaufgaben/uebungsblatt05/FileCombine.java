package de.luca.uebungsaufgaben.uebungsblatt05;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileCombine {

    public static void main(String[] args) throws IOException {
        String fileName;
        if (args.length == 1) {
            fileName = args[0];
        } else {
            System.out.print("Enter filename or -path (without \".<splitNumber>\"): ");
            fileName = new Scanner(System.in).nextLine();
        }

        List<File> splitFiles = new ArrayList<>();
        int numberOfSplitFiles = 0;
        File f;

        while ((f = new File(fileName + "." + (numberOfSplitFiles + 1))).exists()) {
            splitFiles.add(f);
            numberOfSplitFiles++;
        }

        if (numberOfSplitFiles < 1) {
            System.out.println(fileName + ".1 doesn't exist!");
            return;
        }

        String absolutePath = splitFiles.get(0).getAbsolutePath();
        absolutePath = absolutePath.substring(0, absolutePath.length() - 2);
        int lastIndexOfDot = absolutePath.lastIndexOf('.');
        absolutePath = absolutePath.substring(0, lastIndexOfDot) + "-recombined"
                + absolutePath.substring(lastIndexOfDot);

        OutputStream outputStream = new BufferedOutputStream(
                new FileOutputStream(absolutePath));

        for (File file : splitFiles) {
            InputStream inputStream = new BufferedInputStream(
                    new FileInputStream(file));


            int nextByte;
            while ((nextByte = inputStream.read()) != -1) {
                outputStream.write(nextByte);
            }
            inputStream.close();
        }
        outputStream.flush();
        outputStream.close();
    }
}
