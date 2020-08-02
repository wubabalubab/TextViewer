package com.example.textviewer;

import java.util.ArrayList;

/**
*   author K.K
*   created on 2020/7/28
*   @Describe ItemInfo
*/

public class ItemInfo {
    public String name;
    public String description;
    public int image;
    private static String []names={"item1","item2","item3"};
    private static String []descriptions={"item111","22222","3333"};
    private static int  []images={R.drawable.testdemo,R.drawable.testdemo,R.drawable.testdemo};

    public ItemInfo(String name, String description, int image) {
        this.name = name;
        this.description = description;
        this.image = image;
    }
    public ItemInfo() {
        name="";
        description="";
        image=0;
    }
    public static ArrayList<ItemInfo> getDefaultList(){
        ArrayList<ItemInfo> itemInfos=new ArrayList<>();
        for (int i = 0; i <names.length ; i++) {
            itemInfos.add(new ItemInfo(names[i],descriptions[i],images[i]));
        }
        return itemInfos;
    }
}
