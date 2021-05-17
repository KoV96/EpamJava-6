package com.epam.rd.java.basic.practice6.part6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Part6 {
    private String fileName;
    private  String input;

    public boolean consoleOutput(String str, String filename, String str2, String operation) {
        if (!(str.equals("--input") || str.equals("-i"))) {
            System.err.println("Wrong operation");
            return false;
        }
        this.fileName = filename;
        readFile();
        if (!(str2.equals("--task") || str2.equals("-t"))) {
            System.err.println("Wrong task");
            return false;
        }
        switch (operation) {
            case "frequency":
                Part61 part61 = new Part61(input.split(" "));
                System.out.println(part61.getResult());
                break;
            case "length":
                Part62 part62 = new Part62(input.split(" "));
                System.out.println(part62.getResult());
                break;
            case "duplicates":
                Part63 part63 = new Part63(input.split(" "));
                System.out.println(part63.getResult());
                break;
            default: return false;
        }
        return true;
    }

    private void readFile() {
        StringBuilder sb = new StringBuilder();
        try(Scanner scanner = new Scanner(new File(fileName), "Cp1251")) {
            while (scanner.hasNextLine()){
                String line = scanner.nextLine();
                sb.append(line).append(" ");
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found" + e.getMessage());
        }
        input = sb.toString().trim();
    }


    public static void main(String[] args) {
        if (args.length != 4){
            throw new IllegalArgumentException();
        }
        Part6 part6 = new Part6();
        part6.consoleOutput(args[0], args[1], args[2], args[3]);

    }
    
}
