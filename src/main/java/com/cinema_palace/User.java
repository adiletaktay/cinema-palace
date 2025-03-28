package com.cinema_palace;

import java.util.ArrayList;

public class User {
    private int id;
    private String userName;
    private ArrayList<Integer> filmIds = new ArrayList<>();

    public User(String userName) {
        this.userName = userName;
    }

    public User(int id, String userName) {
        this.id = id;
        this.userName = userName;
    }

    public ArrayList<Integer> getFilmIds() {
        return filmIds;
    }

    public void setFilmIds(ArrayList<Integer> filmIds) {
        this.filmIds = filmIds;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
