import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Mitarbeiter {
    public static Scanner sc = new Scanner(System.in);
    public int id;
    public String name;
    public String lastname;
    public static List<Mitarbeiter> list = new ArrayList<>();

    public Mitarbeiter(int id, String name, String lastname) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
    }

    public static void create() {
        String name = "", lastname = "";
        try {
            System.out.print("Input Name: ");
            name = sc.nextLine();
            System.out.print("Input Last Name: ");
            lastname = sc.nextLine();
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        }
        int id = 1;
        for (Mitarbeiter mitarbeiter : list) {
            if (mitarbeiter != null) id++;
            else break;
        }
        list.add(new Mitarbeiter(id, name, lastname));
        menu();
    }

    public static void printList() {
        for (var x : Mitarbeiter.list) {
            System.out.println("ID: " + x.id + "\tName: " + x.name + "\tLast Name: " + x.lastname);
        }
        menu();
    }

    public static void menu()
    {
        System.out.println("************************");
        System.out.println("* 1: Neuer Mitarbeiter *");
        System.out.println("* 2: Liste ausgeben    *");
        System.out.println("* 3: Beenden           *");
        System.out.println("************************");
        System.out.print("Choose: ");
        int c = Integer.parseInt(sc.nextLine());
        if (c == 1) Mitarbeiter.create();
        else if (c == 2) Mitarbeiter.printList();
        else if(c==3) System.exit(0);
        else {
            System.out.println("Wrong Input");
            try
            {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println(e.toString());
            }
            menu();
        }
    }
}
