package singleton.helper;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

import singleton.SimpleSingleton;

public class SimpleSingletonHelper {

    public static SimpleSingleton getSimpleInstance() {
        return SimpleSingleton.getInstance();
    }

    public static SimpleSingleton getCloneObject(SimpleSingleton input) throws CloneNotSupportedException {
        return (SimpleSingleton)input.clone();
    }

    public static SimpleSingleton getSerilizedSimpleObject(SimpleSingleton input) {
        SimpleSingleton output = null;
        try {
            ObjectOutput out = new ObjectOutputStream(new FileOutputStream("fil1.text"));
            out.writeObject(input);
            out.close();
            ObjectInput in = new ObjectInputStream(new FileInputStream("fil1.text"));
            output = (SimpleSingleton) in.readObject();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return output;
    }

    public static SimpleSingleton getReflectionSimpleObject() throws Exception {
        SimpleSingleton output = null;
        try {
            Constructor constructor = SimpleSingleton.class.getDeclaredConstructor();
            constructor.setAccessible(true);
            output = (SimpleSingleton) constructor.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
            throw e;
        }
        return output;
    }

}
