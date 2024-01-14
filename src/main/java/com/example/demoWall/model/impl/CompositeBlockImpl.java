package com.example.demoWall.model.impl;

import com.example.demoWall.model.Block;
import com.example.demoWall.model.CompositeBlock;

import java.util.List;

public class CompositeBlockImpl implements CompositeBlock {
    private List<Block> blocks;

    public CompositeBlockImpl(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public String getColor() {
        return blocks.get(0).getColor();
    }

    @Override
    public String getMaterial() {
        return blocks.get(0).getMaterial();
    }

    @Override
    public List<Block> getBlocks() {
        return blocks;
    }
}