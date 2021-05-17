package com.epam.rd.java.basic.practice6.part1;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class Part1 {
    private static final String USER_INPUT = "asd 43 asdf asd 43\n" +
            "434 asdf \n" +
            "kasdf asdf stop asdf\n" +
            "stop";
    private static final InputStream STD_IN = System.in;

    public static void main(String[] args) {
        System.setIn(new ByteArrayInputStream(USER_INPUT.getBytes(StandardCharsets.UTF_8)));
        WordContainer.main(args);
        System.setIn(STD_IN);

    }

}
