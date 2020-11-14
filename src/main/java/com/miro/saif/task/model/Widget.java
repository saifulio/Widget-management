package com.miro.saif.task.model;

import java.sql.*;

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

    public boolean save() {

        try
        {
            // create our mysql database connection
            String myUrl = "jdbc:h2:mem:task";

            Connection conn = DriverManager.getConnection(myUrl, "saif", "Saif@Miro");

            // if you only need a few columns, specify them by name instead of using "*"
            String query = String.format(
                    "INSERT INTO widgets (x, y, width, height) VALUES (%d, %d, %d, %d);",
                    this.x, this.y, this.width, this.height
            );

            // create the java statement
            Statement st = conn.createStatement();

            st.execute(query);

            st.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
            return false;
        }
        return true;
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
