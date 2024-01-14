package com.example.demoWall.model.impl;

import com.example.demoWall.model.Block;

public class BasicBlockImpl implements Block {
    private String color;
    private String material;

    public BasicBlockImpl(String color, String material) {
        this.color = color;
        this.material = material;
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public String getMaterial() {
        return material;
    }
}