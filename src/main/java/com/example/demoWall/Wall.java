package com.example.demoWall;

import com.example.demoWall.model.Block;
import com.example.demoWall.model.CompositeBlock;
import com.example.demoWall.model.Structure;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Data
public class Wall implements Structure {
    private List<Block> blocks;

    public Wall(List<Block> blocks) {
        this.blocks = blocks;
    }

    @Override
    public Optional<Block> findBlockByColor(String color) {
        return blocks.stream()
                .filter(block -> color.equals(block.getColor()))
                .findAny();
    }

    @Override
    public List<Block> findBlocksByMaterial(String material) {
        List<Block> result = new ArrayList<>();
        for (Block block : blocks) {
            if (material.equals(block.getMaterial())) {
                result.add(block);
            }
            if (block instanceof CompositeBlock) {
                result.addAll(((CompositeBlock) block).getBlocks());
            }
        }
        return result;
    }

    @Override
    public int count() {
        return blocks.size();
    }
}