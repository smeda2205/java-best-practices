package item4.noninstantiable;

public class UtilityClass {

    private UtilityClass(){
        throw new AssertionError();
    }
}
