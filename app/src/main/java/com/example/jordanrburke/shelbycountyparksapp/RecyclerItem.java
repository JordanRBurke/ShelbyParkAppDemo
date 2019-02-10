package com.example.jordanrburke.shelbycountyparksapp;

public class RecyclerItem {

    private String TextOfItem;

    public String getTextOfItem() {
        return TextOfItem;
    }

    public String setTextOfItem(String textOfItem) {
        TextOfItem = textOfItem;
        return textOfItem;
    }

    public RecyclerItem(String textOfItem) {
        TextOfItem = textOfItem;
    }
}
