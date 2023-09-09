package singleton;

import java.io.Serializable;

public class SimpleSingleton implements Serializable,Cloneable{
    private SimpleSingleton(){}

    private static class InstanceHelper {
        private static SimpleSingleton parentInstance = new SimpleSingleton();
    }

    public static SimpleSingleton getInstance(){
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

