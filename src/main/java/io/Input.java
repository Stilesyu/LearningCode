package io;

import java.io.*;

public class Input {

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        OutputStream outputStream = new FileOutputStream("E:\\codeFile\\io\\object.txt");
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {
            A a = new A();
            objectOutputStream.writeObject(a);
        }
        InputStream inputStream = new FileInputStream("E:\\codeFile\\io\\object.txt");
        try (ObjectInputStream objectInputStream = new ObjectInputStream(inputStream)) {
            Object o = objectInputStream.readObject();
            System.out.println(o.getClass());
        }
    }


}
