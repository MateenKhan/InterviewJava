package singleton;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

import singleton.helper.EnumSingletonHelper;

public class TestEnumSingleton {
    
     @Test
    public void testSimpleInsance(){
        EnumSingleton obj1 = EnumSingletonHelper.getSimpleInstance();
        EnumSingleton obj2 = EnumSingletonHelper.getSimpleInstance();
        assertEquals(obj1.hashCode(),obj2.hashCode());
    }

    @Test
    public void testSerilizedSimpleObject(){
        EnumSingleton obj1 = EnumSingletonHelper.getSimpleInstance();
        EnumSingleton obj2 = EnumSingletonHelper.getSerilizedSimpleObject(obj1);
        assertEquals(obj1.hashCode(),obj2.hashCode());
    }

    @Test
    public void testReflectionSimpleObject(){
        EnumSingleton obj2 = EnumSingletonHelper.getReflectionSimpleObject();
        assertNull(obj2);
    }
}
