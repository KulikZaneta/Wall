package com.example.demoWall;

import com.example.demoWall.model.impl.BasicBlockImpl;
import com.example.demoWall.model.impl.CompositeBlockImpl;
import com.example.demoWall.model.Block;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class WallTest {
    @Test
    public void testFindBlockByColor() {
        List<Block> blocks = Arrays.asList(
                new BasicBlockImpl("Red", "Brick"),
                new BasicBlockImpl("Blue", "Concrete")
        );

        Wall wall = new Wall(blocks);

        Optional<Block> redBlock = wall.findBlockByColor("Red");
        assertTrue(redBlock.isPresent());
        assertEquals("Red", redBlock.get().getColor());

        Optional<Block> greenBlock = wall.findBlockByColor("Green");
        assertFalse(greenBlock.isPresent());
    }

    @Test
    public void testFindBlocksByMaterial() {
        List<Block> blocks = Arrays.asList(
                new BasicBlockImpl("Red", "Brick"),
                new BasicBlockImpl("Blue", "Concrete"),
                new CompositeBlockImpl(Arrays.asList(
                        new BasicBlockImpl("Green", "Wood"),
                        new BasicBlockImpl("Brown", "Wood")
                ))
        );

        Wall wall = new Wall(blocks);

        List<Block> woodBlocks = wall.findBlocksByMaterial("Wood");
        assertEquals(3, woodBlocks.size());
    }

    @Test
    public void testCount() {
        List<Block> blocks = Arrays.asList(
                new BasicBlockImpl("Red", "Brick"),
                new BasicBlockImpl("Blue", "Concrete"),
                new CompositeBlockImpl(Arrays.asList(
                        new BasicBlockImpl("Green", "Wood"),
                        new BasicBlockImpl("Brown", "Wood")
                ))
        );

        Wall wall = new Wall(blocks);

        assertEquals(3, wall.count());
    }

    @Test
    public void testFindBlockByColorInNestedComposite() {
        List<Block> blocks = Arrays.asList(
                new CompositeBlockImpl(Arrays.asList(
                        new BasicBlockImpl("Red", "Brick"),
                        new BasicBlockImpl("Blue", "Concrete")
                )),
                new BasicBlockImpl("Green", "Wood")
        );

        Wall wall = new Wall(blocks);

        Optional<Block> redBlock = wall.findBlockByColor("Red");
        assertTrue(redBlock.isPresent());
        assertEquals("Red", redBlock.get().getColor());
    }

    @Test
    public void testFindBlocksByMaterialInNestedComposite() {
        List<Block> blocks = Arrays.asList(
                new CompositeBlockImpl(Arrays.asList(
                        new BasicBlockImpl("Red", "Brick"),
                        new BasicBlockImpl("Blue", "Concrete")
                )),
                new BasicBlockImpl("Green", "Wood")
        );

        Wall wall = new Wall(blocks);

        List<Block> woodBlocks = wall.findBlocksByMaterial("Wood");
        assertEquals(3, woodBlocks.size());
    }
}