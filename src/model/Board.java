package model;
import java.util.LinkedList;


public class Board
{
    private int size;
    private LinkedList<Cell> SCENE = new LinkedList<Cell>();

    public Board(int size)
    {
        this.size = size;
        for(int i=0;i<size;i++)
            for(int k=0;k<size;k++)
            {
                SCENE.add(new Cell());
            }
    }

    public void display()
    {
        for(int i=0;i<size;i++)
        {
            for (int k = 0; k < size; k++)
                SCENE.get(k).showA();
            System.out.println();
            for (int k = 0; k < size; k++)
                SCENE.get(k).showB();
            System.out.print("|");
            System.out.println();
        }
        for (int k = 0; k < size; k++)
            SCENE.get(k).showA();
    }

    public int getSize()
    {
        return size;
    }

    public void update(Player p, char mark)
    {
        int x = p.getPosition()[0];
        int y = p.getPosition()[1];
        int index = x*size + y;

        try{
            SCENE.get(index).modify(mark);
        }catch(Exception e){
            System.out.println("\tGame Over");
            System.out.println(p.getColor() + " Enter Dead Zone");
        }

    }

    public void update(Player p)
    {
        int x = p.getPosition()[0];
        int y = p.getPosition()[1];
        int index = x*size + y;

        try{
            SCENE.get(index).modify(p.getColor().charAt(0));
            System.out.println("Update Complete");
        }catch(Exception e){
            System.out.println("\tGame Over");
            System.out.println(p.getColor() + " Enter Dead Zone");
        }

    }
}
