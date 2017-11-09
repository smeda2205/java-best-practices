package item3.singleton_second_approach;

public class Elvis {
    private static final Elvis Instance = new Elvis();
    private Elvis(){

    }


    public static Elvis getInstance(){
        return  Instance;
    }

    private Object readResolve(){
        return Instance;
    }
}
