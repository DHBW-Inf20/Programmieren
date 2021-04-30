package de.luca.uebungsaufgaben.semester1.uebungsblatt06;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class FileSplitOptimized {

    public static void main(String[] args) throws IOException {

        File startFile = getValidFileFromArgsOrConsole(args);

        if (!startFile.exists()) {
            System.out.println("Couldn't find file!");
            return;
        }

        long maxBytes = getValidMaxBytesFromConsole();

        // after user input => possibility to cancel
        if (startFile.isDirectory()) {
            startFile = zipDirectory(startFile);
            if (startFile == null) {
                System.out.println("Tried to zip non-directory!");
                return;
            }
        }

        int splitFiles = splitFileIntoFilesWithMaxSize(startFile, maxBytes);

        printSuccess(startFile, splitFiles);
    }

    private static File getValidFileFromArgsOrConsole(String[] programArgs) {

        File file = new File("");
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;

        if (programArgs.length == 1) {
            file = new File(programArgs[0]);
            validInput = file.exists();
        }

        while (!validInput) {
            System.out.print("Enter file/directory name or path: ");
            validInput = (file = new File(scanner.nextLine())).exists();
            if (!validInput) {
                System.out.println(file.getName() + " doesn't exist"
                        + (file.getParent() == null ? "" : " in " + file.getParent() + " ") + "!");
            }
        }
        return file;
    }

    private static long getValidMaxBytesFromConsole() {

        long maxBytes = 0;
        Scanner scanner = new Scanner(System.in);
        boolean validInput;

        do {
            System.out.print("Enter maximum output file size in bytes: ");
            String maxSizeString = scanner.nextLine();
            validInput = false;
            try {
                maxBytes = Long.parseLong(maxSizeString);
                if (maxBytes > 0) validInput = true;
                else System.out.println("Number has to be greater than 0!");
            } catch (NumberFormatException e) {
                System.out.println("Can't convert \"" + maxSizeString + "\" to number, try again.");
            }

        } while (!validInput);

        return maxBytes;
    }

    @SuppressWarnings("DuplicatedCode")
    private static File zipDirectory(File directory) throws IOException {

        if (!directory.isDirectory()) return null;

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
        return zipFile;
    }

    private static int splitFileIntoFilesWithMaxSize(File file, long maxBytes) throws IOException {

        int numberOfSplitFiles = 0;

        if (file.length() > maxBytes) { // otherwise not necessary

            numberOfSplitFiles = (int) (file.length() / maxBytes) + ((file.length() % maxBytes) == 0 ? 0 : 1);

            FileChannel in = new FileInputStream(file).getChannel();

            for (int i = 1; i <= numberOfSplitFiles; i++) {
                FileChannel out = new FileOutputStream(file.getAbsolutePath() + "." + i).getChannel();
                in.transferTo((i - 1) * maxBytes, maxBytes, out);
                out.close();
            }
            in.close();
        }
        return numberOfSplitFiles;
    }

    private static void printSuccess(File startFile, int numberOfSplitFiles) {

        String fileName = startFile.getName();
        String startFileAbsolutePath = startFile.getAbsolutePath();

        String filePath = startFileAbsolutePath.substring(0, startFileAbsolutePath.lastIndexOf(File.separatorChar));
        System.out.println("Split " + fileName + " into " + fileName + ".1 - " + fileName + "." + numberOfSplitFiles
                + " in " + filePath + " !");
    }
}
