package com.example.codingchallenge5;

import java.util.HashMap;

public class ShopList {
    public HashMap<String,Integer> list=new HashMap<>();

    public void addItem(String key) {
        if(list.containsKey(key)){
            list.put(key, list.get(key)+1);
        }else{
            list.put(key,1);
        }
    }
    public HashMap<String,Integer> getItems(){
        return list;
    }
}
