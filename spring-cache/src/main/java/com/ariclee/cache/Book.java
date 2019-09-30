package com.ariclee.cache;

import java.io.Serializable;

public class Book implements Serializable {

    private String id;
    private String name;
    private String desc;

    public Book() {
        this.id = String.valueOf(System.currentTimeMillis());
        this.name = "the default book name";
    }

    public Book(String name) {
        this.id = String.valueOf(System.currentTimeMillis());
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", desc='" + desc + '\'' +
                '}';
    }
}
