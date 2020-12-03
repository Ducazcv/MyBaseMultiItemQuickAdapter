package com.example.testviewbinding;

import android.util.Size;

import com.chad.library.adapter.base.entity.MultiItemEntity;

public class MultiBean<T> implements MultiItemEntity {
    public static final int SIZE4 = 4;
    public static final int SIZE8 = 8;
    public static final int ALLSIZE = 8;
    public static final int TYPE1 = 1;
    public static final int TYPE2 = 2;
    public static final int TYPE3 = 3;
    public static final int TYPE4 = 4;
    public static final int TYPE5 = 5;
    public static final int TYPE6 = 6;
    public static final int TYPE7 = 7;
    public static final int TYPE8 = 8;

    private int size;
    private int type;
    private T object;
    public MultiBean(int size, int type,T t) {
        this.size = size;
        this.type = type;
        object = t;
    }

    public MultiBean(int size, int type) {
        this.size = size;
        this.type = type;
    }

    @Override
    public int getItemType() {
        return type;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public T getObject() {
        return object;
    }

    public void setObject(T object) {
        this.object = object;
    }
}
