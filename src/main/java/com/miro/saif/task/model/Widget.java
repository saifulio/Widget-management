package com.miro.saif.task.model;

public class Widget {
    private int id;
    private int x;
    private int y;
    private int width;
    private int height;
    private int zIndex;

    public Widget() {

    }

    public Widget(int x, int y, int width, int height){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.zIndex = 1;
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

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getzIndex() {
        return zIndex;
    }

    public void setzIndex(int zIndex) {
        this.zIndex = zIndex;
    }

    public String toString(){
        return "id:" + id + " x:" + x + " y:" + y + " width:" + width + " height: "+ height + " zIndex:" + zIndex;
    }
}
