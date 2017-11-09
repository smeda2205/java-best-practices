package item3.singleton_first_approach;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Method;

public class Elvis {
    //Singleton with public final field
    public static final Elvis INSTANCE = new Elvis();
    private Elvis(){

    }


}
