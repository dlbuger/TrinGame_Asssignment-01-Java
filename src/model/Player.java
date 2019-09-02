package model;

import java.util.LinkedList;

public class Player {
    private int id;
    private String name;
    private String color;
    private int[] position;

    private LinkedList<int[]> selfTrace = new LinkedList<int[]>();

    public Player(int id, String name, String color, int[] position) {
        this.id = id;
        this.name = name;
        this.color = color;
        this.position = position;
        selfTrace.add(position);
    }

    protected char generateChoice()
    {
        return 'a';
    }
    public String getColor()
    {
        return color;
    }
    public void move(char direction)
    {
        switch (direction)
        {
            case 'U': moveUp();break;
            case 'D': moveDown();break;
            case 'L': moveLeft();break;
            case 'R': moveRight();break;
            default: System.out.println("Incorrect instruction!");
        }
        selfTrace.add(position);
    }
    public int[] getPosition()
    {
        return position;
    }

    public String getName()
    {
        return name;
    }

    private void moveUp()
    {
        position[0]--;
    }
    private void moveDown()
    {
        position[0]++;
    }
    private void moveLeft()
    {
        position[1]--;
    }
    private void moveRight()
    {
        position[1]++;
    }
}
