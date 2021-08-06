package semester1.uebungsblatt06;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class FileCombineOptimized {

    public static void main(String[] args) throws IOException {

        File startFile = getValidFileFromArgsOrConsole(args);
        String startFileAbsolutePath = startFile.getAbsolutePath();

        List<File> splitFiles = getSplitFiles(startFileAbsolutePath);

        int numberOfSplitFiles = splitFiles.size();

        if (numberOfSplitFiles < 2) {
            System.out.println("Couldn't find more than 1 file!");
            return;
        }

        int lastIndexOfDot = startFileAbsolutePath.lastIndexOf('.');
        String destFileAbsolutePath = startFileAbsolutePath.substring(0, lastIndexOfDot) + "-recombined"
                + startFileAbsolutePath.substring(lastIndexOfDot);

        combineFiles(destFileAbsolutePath, splitFiles);

        printSuccess(startFile.getName(), destFileAbsolutePath, numberOfSplitFiles);
    }

    private static File getValidFileFromArgsOrConsole(String[] programArgs) {

        String fileName = "";
        File file1;
        File file2;
        Scanner scanner = new Scanner(System.in);
        boolean validInput = false;

        if (programArgs.length == 1) {
            fileName = programArgs[0];
            validInput = new File(fileName + ".1").exists()
                    && new File(fileName + ".2").exists();
        }

        while (!validInput) {
            System.out.print("Enter file name or path (without \".<splitNumber>\"): ");
            fileName = scanner.nextLine();
            validInput = (file1 = new File(fileName + ".1")).exists()
                    & (file2 = new File(fileName + ".2")).exists();
            if (!validInput) {
                System.out.println(file1.getName() + " or "
                        + file2.getName() + " don't exist"
                        + (file1.getParent() == null ? "" : " in " + file1.getParent() + " ") + "!");
            }
        }
        return new File(fileName);
    }

    private static List<File> getSplitFiles(String startFileAbsolutePath) {

        List<File> splitFiles = new LinkedList<>();
        int iSplitFile = 1;

        File file;
        while ((file = new File(startFileAbsolutePath + "." + (iSplitFile++))).exists()) {
            splitFiles.add(file);
        }
        return splitFiles;
    }

    private static void combineFiles(String destFileAbsolutePath, List<File> files) throws IOException {

        FileChannel out = new FileOutputStream(destFileAbsolutePath).getChannel();

        for (File file : files) {
            FileChannel in = new FileInputStream(file).getChannel();
            in.transferTo(0, file.length(), out);
            in.close();
        }
        out.close();
    }

    private static void printSuccess(String startFileName, String destFileAbsolutePath, int numberOfSplitFiles) {

        int lastIndexOfPathSeparator = destFileAbsolutePath.lastIndexOf(File.separatorChar);
        String destFilePath = destFileAbsolutePath.substring(0, lastIndexOfPathSeparator);
        String destFileName = destFileAbsolutePath.substring(lastIndexOfPathSeparator + 1);

        System.out.println("Combined " + startFileName + ".1 - " + startFileName + "." + numberOfSplitFiles
                + " into " + destFileName + " in " + destFilePath + " !");
    }
}
