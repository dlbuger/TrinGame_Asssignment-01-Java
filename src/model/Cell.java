package model;

public class Cell
{
    /* How a cell links like

     ---
    |

     */
    String a = " ---";
    String b = "|   ";

    public void modify(char mark)
    {
        b.toCharArray()[2] = mark;
    }
    public void showA()
    {
        System.out.print(a);
    }
    public void showB()
    {
        System.out.print(b);
    }
}
