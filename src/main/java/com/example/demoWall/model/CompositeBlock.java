package com.example.demoWall.model;

import java.util.List;

public interface CompositeBlock extends Block {
    List<Block> getBlocks();
}
