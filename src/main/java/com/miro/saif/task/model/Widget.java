package com.miro.saif.task.model;

import com.miro.saif.task.DataSourceConfig;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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

    public Widget(int id, int x, int y, int width, int height, int zIndex){
        this.id = id;
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.zIndex = zIndex;
    }

    public static Widget retrieve(int reqId) {
        Widget widget = null;
        try
        {

            DataSource dsc = new DataSourceConfig().getDataSource();
            Connection conn = dsc.getConnection();

            String query = String.format(
                    "SELECT * FROM widgets WHERE id= %d;",
                    reqId
            );

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(query);

            while (rs.next())
            {
                int id = rs.getInt("id");
                int x = rs.getInt("x");
                int y = rs.getInt("y");
                int width = rs.getInt("width");
                int height = rs.getInt("height");
                int zIndex = rs.getInt("zIndex");

                widget = new Widget(id, x, y, width, height, zIndex);

            }

            st.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
            return null;
        }
        return widget;
    }

    public static List<Widget> retrieveAll() {
        List<Widget> widgets = new ArrayList<>();
        try
        {

            DataSource dsc = new DataSourceConfig().getDataSource();
            Connection conn = dsc.getConnection();

            String query = "SELECT * FROM widgets;";

            Statement st = conn.createStatement();

            ResultSet rs = st.executeQuery(query);

            while (rs.next())
            {
                int id = rs.getInt("id");
                int x = rs.getInt("x");
                int y = rs.getInt("y");
                int width = rs.getInt("width");
                int height = rs.getInt("height");
                int zIndex = rs.getInt("zIndex");

                widgets.add(new Widget(id, x, y, width, height, zIndex));

            }

            st.close();
        }
        catch (Exception e)
        {
            System.err.println("Got an exception! ");
            System.err.println(e.getMessage());
            return null;
        }
        return widgets;
    }



    public boolean save() {

        try
        {

            DataSource dsc = new DataSourceConfig().getDataSource();
            Connection conn = dsc.getConnection();

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

    public static boolean delete(int id) {
        try
        {

            DataSource dsc = new DataSourceConfig().getDataSource();
            Connection conn = dsc.getConnection();

            String query = String.format(
                    "DELETE FROM widgets WHERE id = %d",
                    id
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

    public int getId(){
        return id;
    }

    public void setId(int id){
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
