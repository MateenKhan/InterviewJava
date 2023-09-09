package singleton.helper;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

import singleton.EnumSingleton;

public class EnumSingletonHelper {

    public static EnumSingleton getSimpleInstance() {
        return EnumSingleton.INSTANCE;
    }

    public static EnumSingleton getSerilizedSimpleObject(EnumSingleton input) {
        EnumSingleton output = null;
        try {
            ObjectOutput out = new ObjectOutputStream(new FileOutputStream("fil1.text"));
            out.writeObject(input);
            out.close();
            ObjectInput in = new ObjectInputStream(new FileInputStream("fil1.text"));
            output = (EnumSingleton) in.readObject();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output;
    }

    public static EnumSingleton getReflectionSimpleObject() {
        EnumSingleton output = null;
        try {
            Constructor constructor = EnumSingleton.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            output = (EnumSingleton) constructor.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output;
    }

}
