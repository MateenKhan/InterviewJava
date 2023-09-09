package singleton;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;


import org.junit.jupiter.api.Test;

import singleton.helper.SimpleSingletonHelper;

public class TestSimpleSingleton {
    
    @Test
    public void testSimpleInsance(){
        SimpleSingleton obj1 = SimpleSingletonHelper.getSimpleInstance();
        SimpleSingleton obj2 = SimpleSingletonHelper.getSimpleInstance();
        assertEquals(obj1.hashCode(),obj2.hashCode());
    }

    @Test
    public void testCloneObject() throws CloneNotSupportedException{
        SimpleSingleton obj1 = SimpleSingletonHelper.getSimpleInstance();
        SimpleSingleton obj2 = SimpleSingletonHelper.getCloneObject(obj1);
        assertEquals(obj1.hashCode(),obj2.hashCode());
    }

    @Test
    public void testSerilizedSimpleObject(){
        SimpleSingleton obj1 = SimpleSingletonHelper.getSimpleInstance();
        SimpleSingleton obj2 = SimpleSingletonHelper.getSerilizedSimpleObject(obj1);
        assertEquals(obj1.hashCode(),obj2.hashCode());
    }

    @Test
    public void testReflectionSimpleObject(){
        SimpleSingleton obj1 = SimpleSingletonHelper.getSimpleInstance();
        SimpleSingleton obj2 = SimpleSingletonHelper.getReflectionSimpleObject();
        assertNotEquals(obj1.hashCode(),obj2.hashCode());
    }
}
