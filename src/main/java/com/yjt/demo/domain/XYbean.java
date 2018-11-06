package com.yjt.demo.domain;

public class XYbean {
    String id;
    int x;
    int y;


    public XYbean(String id, int x, int y) {
        this.id = id;
        this.x = x;
        this.y = y;
    }

    public XYbean(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
