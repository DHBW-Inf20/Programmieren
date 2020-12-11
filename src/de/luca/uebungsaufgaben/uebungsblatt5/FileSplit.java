package de.luca.uebungsaufgaben.uebungsblatt5;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileSplit {

    public static void main(String[] args) throws IOException {
        String fileName;
        if (args.length == 1) {
            fileName = args[0];
        } else {
            System.out.print("Enter filename or -path: ");
            fileName = new Scanner(System.in).nextLine();
        }

        File file = new File(fileName);

        if (!file.exists()) {
            System.out.println(file.getAbsolutePath() + " doesn't exist!");
            return;
        }

        if (file.isDirectory()) {
            zipDirectory(file);
            file = new File(fileName + ".zip");
        }

        long maxBytes = (long) (1.44 * 1024L * 1024L);

        if (file.length() > maxBytes) {

            int numberOfSplitFiles = (int) (file.length() / maxBytes) + ((file.length() % maxBytes) == 0 ? 0 : 1);

            InputStream inputStream = new BufferedInputStream(
                    new FileInputStream(file));

            for (int i = 1; i <= numberOfSplitFiles; i++) {

                OutputStream outputStream = new BufferedOutputStream(
                        new FileOutputStream(file.getAbsolutePath() + "." + i));

                int nextByte;
                long writtenBytes = 0L;

                // if writtenBytes >= maxBytes: DON'T execute inputStream.read(), otherwise one Byte will be skipped
                while (writtenBytes < maxBytes
                        && (nextByte = inputStream.read()) != -1) {
                    outputStream.write(nextByte);
                    writtenBytes++;
                }

                outputStream.flush();
                outputStream.close();
            }
            inputStream.close();
        }
    }

    static void zipDirectory(File directory) throws IOException {
        if (!directory.isDirectory()) return;

        Path directoryPath = directory.toPath();
        File zipFile = new File(directory.getAbsolutePath() + ".zip");
        ZipOutputStream zipOutputStream = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(zipFile)));
        zipOutputStream.setLevel(9);
        Files.walk(directoryPath)
                .filter(path -> !Files.isDirectory(path))
                .forEach(path -> {
                    ZipEntry zipEntry = new ZipEntry(directoryPath.relativize(path).toString());
                    try {
                        zipOutputStream.putNextEntry(zipEntry);
                        Files.copy(path, zipOutputStream);
                        zipOutputStream.closeEntry();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                });
        zipOutputStream.close();
    }
}
