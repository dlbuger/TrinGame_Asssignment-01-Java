package model;

public class Human extends Player
{
    public Human(int id, String name, String color, int[] position)
    {
        super(id,name,color,position);
    }

    public char generateChoice()
    {
        return In.readChar("\tPlease Enter your choice - U D L R: ");
    }
}
