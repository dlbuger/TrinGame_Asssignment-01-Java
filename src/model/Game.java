package model;
import java.util.LinkedList;

public class Game
{
    private int id = 0;
    Player p1;
    Player p2;
    Board b1;

    private LinkedList<int[]> trace = new LinkedList<int[]>();

    public Game()
    {
        setup();
        menu();
    }
    public void setup()
    {
        int size = 0;
        while (size<4)
        {
            size = In.readInt("Enter the Board's size length - (input > 3): ");
        }
        b1 = new Board(size);
        System.out.println("Game Scene initialized complete!\nSize --> " + b1.getSize());
    }

    private void menu()
    {
        System.out.println("1. Human Player With Another Human Player - PVP");
        System.out.println("2. Human Player with Bot - difficult: Easy");
        System.out.println("3. Human Player with Bot - difficulty: Hard");
        System.out.println("4. Bot with Bot - ");

        switch(In.readChar("Your Choice --> "))
        {
            case '1': initPVP();break;
            case '2': initPVC();break;
            case '4': initCVC();break;
        }
        trace.add(p1.getPosition());
        trace.add(p2.getPosition());
        RUN();
    }

    private void RUN()
    {
        System.out.println("Create Player 1 - " + p1.getColor() + " " + p1.getName());
        System.out.println("Create Player 2 - " + p2.getColor() + " " + p2.getName());
        b1.update(p1);
        b1.update(p2);
        System.out.println("test!");
        b1.display();

        update();
        while(!gameEnd())
        {
            trace.add(p1.getPosition());
            trace.add(p2.getPosition());
            update();
        }
    }

    private void update()
    {
        b1.update(p1,'0');
        b1.update(p2,'0');

        System.out.println("Red Turn:");
        p1.move(p1.generateChoice());
        In.printList(p1.getPosition());
        b1.update(p1);

        System.out.println("Blue Turn:");
        p2.move(p2.generateChoice());
        In.printList(p2.getPosition());
        b1.update(p2);

        System.out.println("\n");
        b1.display();
    }

    private boolean gameEnd()
    {
        if (p1.getPosition() == p2.getPosition())
        {
            System.out.println("Draw!");
            return true;
        }

        for (var c:trace)
            if (p1.getPosition() == c)
            {
                System.out.println(p1.getColor()+" crashed "+p2.getColor()+"'s trace!");

                return true;
            }

        for (var c:trace)
            if (p2.getPosition() == c)
            {
                System.out.println(p2.getColor()+" crashed "+p1.getColor()+"'s trace!");
                return true;
            }
        return false;
    }

    private void initPVP()
    {
        p1 = new Human(++id,In.readString("Please enter your Name: "),"RED",new int[]{1,1});
        p2 = new Human(++id,In.readString("Please enter your Name: "),"BLUE",new int[]{b1.getSize()-2,b1.getSize()-2});
    }

    private void initPVC()
    {

    }

    private void initCVC()
    {

    }
}
