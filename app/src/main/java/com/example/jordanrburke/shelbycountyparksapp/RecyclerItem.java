package com.example.jordanrburke.shelbycountyparksapp;

public class RecyclerItem {

    public int imageOfItem;
    public String textOfItem;

    public String getTextOfItem() {
        return textOfItem;
    }

    public String setTextOfItem(String textOfItem) {
        textOfItem = textOfItem;
        return textOfItem;
    }

    public RecyclerItem(int imageId, String textOfItem) {
        this.imageOfItem = imageId;
        textOfItem = textOfItem;
    }
}
