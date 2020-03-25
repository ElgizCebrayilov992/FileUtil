/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import javax.management.RuntimeErrorException;

/**
 *
 * @author virtu
 */
public class FileUtil {
    
    public static Object readFileDeserialize(String name){
        Object obj=null;
        try {
            ObjectInputStream in=new ObjectInputStream(new FileInputStream(name));
            obj=in.readObject();
        } finally {
            return obj;
        }
    }
    
    public static boolean writeObjecttoFile(Object object,String name) throws RuntimeException{
        try(FileOutputStream fout=new FileOutputStream(name);
            ObjectOutputStream oos=new ObjectOutputStream(fout);) {

            oos.writeObject(object);
            return true;
            
        } catch (Exception e) {
        throw new RuntimeException(e);
        }
    }
    
}
