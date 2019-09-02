package model;

import java.util.Scanner;

public class In
{
    private static Scanner in = new Scanner(System.in);

    public static int readInt(String mes)
    {
        System.out.print(mes);
        return in.nextInt();
    }

    public static char readChar(String mes)
    {
        System.out.print(mes);
        return in.next().toUpperCase().charAt(0);
    }

    public static String readString(String mes)
    {
        System.out.println(mes);
        return in.next();
    }

    public static void printList(int [] input)
    {
        System.out.print("[ ");
        for ( int c:input)
            System.out.print(c + " ");
        System.out.println("]");
    }
}
