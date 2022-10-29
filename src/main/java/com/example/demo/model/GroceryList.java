package com.example.demo.model;

import java.util.ArrayList;
import java.util.List;

public class GroceryList {

    private String title;
    private List<String> list = new ArrayList<>();

    public void addItem(String item) {
        list.add(item);
    }

    public void removeItem(String item) {
        list.remove(item);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }
}
