# **DemoWall**

DemoWall is a simple Java 17 application that models a wall composed of different types of blocks. It includes interfaces for blocks, composite blocks, and a structure. The application provides methods to find blocks by color, find blocks by material, and count the total number of elements in the wall structure.

## **Project Structure** 

The project is organized as follows:

* src/main/java/com/example/demoWall/model: Contains interfaces for Block, CompositeBlock, and Structure.
* src/main/java/com/example/demoWall/model/impl: Contains implementations for BasicBlockImpl and CompositeBlockImpl.
* src/main/java/com/example/demoWall: Contains the Wall class implementing the Structure interface.
* src/test/java/com/example/demoWall: Contains test cases for the Wall class (WallTest).
  
## Usage
To use the Wall class, create an instance by providing a list of blocks. You can then use methods like findBlockByColor, findBlocksByMaterial, and count to analyze the wall structure.

### Example:

```java
List<Block> blocks = Arrays.asList(
    new BasicBlockImpl("Red", "Brick"),
    new BasicBlockImpl("Blue", "Concrete"),
    new CompositeBlockImpl(Arrays.asList(
        new BasicBlockImpl("Green", "Wood"),
        new BasicBlockImpl("Brown", "Wood")
    ))
);

Wall wall = new Wall(blocks);

Optional<Block> redBlock = wall.findBlockByColor("Red");
List<Block> woodBlocks = wall.findBlocksByMaterial("Wood");
int totalBlocks = wall.count();
```

## Tests
The WallTest class includes test cases to verify the functionality of methods like findBlockByColor, findBlocksByMaterial, and count. Additional test cases cover scenarios with nested composite blocks.
