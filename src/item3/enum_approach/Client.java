package item3.enum_approach;

public class Client {
    public static void main(String[] args) {

        //Only once instance can be created.
        Elvis elvis = Elvis.INSTANCE;
        elvis.leaveTheBuilding();
    }
}
