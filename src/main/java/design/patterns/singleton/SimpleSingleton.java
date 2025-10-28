package singleton;

import java.io.Serializable;

public class SimpleSingleton implements Serializable, Cloneable {
    private static SimpleSingleton instance = null;

    private SimpleSingleton() {
        if(instance!=null){
            throw new RuntimeException("Instance Already Exists");
        }
    }

    private static class InstanceHelper {
        private static SimpleSingleton parentInstance = new SimpleSingleton();
    }

    public static SimpleSingleton getInstance() {
        if (instance == null) {
            instance = InstanceHelper.parentInstance;
        }
        return InstanceHelper.parentInstance;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return InstanceHelper.parentInstance;
    }

    protected Object readResolve() {
        return InstanceHelper.parentInstance;
    }
}
