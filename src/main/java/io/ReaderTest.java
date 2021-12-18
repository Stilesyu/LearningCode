package io;


import lombok.SneakyThrows;

import java.nio.file.Files;
import java.nio.file.Paths;

public class ReaderTest {

    @SneakyThrows
    public static void main(String[] args) {
       byte[] chars = Files.readAllBytes(Paths.get("E:\\codeFile\\io\\ioTest.txt"));
        for (byte aChar : chars) {
            System.out.println(aChar);
        }
    }


}
