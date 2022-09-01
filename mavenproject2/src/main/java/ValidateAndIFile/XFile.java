package ValidateAndIFile;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 * @author tltkh
 */
public class XFile {
    public static Object readObject(String path) throws Exception {
        try (
                FileInputStream fin = new FileInputStream(path); ObjectInputStream ois = new ObjectInputStream(fin);) {
            Object obj = ois.readObject();

            return obj;
        }
    }

    public static void writeObject(String path, Object obj) throws Exception {
        try (
                FileOutputStream fos = new FileOutputStream(path); ObjectOutputStream oos = new ObjectOutputStream(fos);) {
            oos.writeObject(obj);

        }
    }
}
