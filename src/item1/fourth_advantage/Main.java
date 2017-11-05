package item1.fourth_advantage;

import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        MyHashMap<String, String> hashMap = new MyHashMap<String, String>();

        //vs

        MyHashMap<String,String> myHashMap = MyHashMap.newInstance();
    }
}
