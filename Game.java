import java.util.Scanner;
import java.util.Vector;
import java.util.Enumeration;

/**
 * Write a description of class Game here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Game
{
    Scanner s1 = new Scanner(System.in);

    Location l1;
    Location l2;
    Location l3;
    Location current;
    Exit e1;
    Exit e2;
    public Game(){ 

        l1 = new Location("Cafe","You are sitting in a cafe at a small table by the window. You have no memory of\n how or why you are sitting there. The people who are\n chatting around you are speaking in a language you don't recognise.");
        l2 = new Location("Door","You leave the table and walk towards the door of the cafe. The moment you exit,\n the cafe vanishes, leaving you staring at the side of a blank wall.\n You black out.");
        l3 = new Location("Table", "You decide to stay at the table and eat your food. A few minutes later, a\n beautiful woman sits down at your table and starts to chat with you. You\n have no idea who she is or where she is from. After a while she \ntakes your hand and leads you out into the night");
        e1 = new Exit(Exit.NORTH, l2);
        e2 = new Exit(Exit.EAST, l3);
        l1.addExit(e1);
        l1.addExit(e2);
        current = l1;
    }

    public void currentLocation(){
        System.out.println((current.getDescription()));
        System.out.println("\n");
    }

    public void currentExits(){

        System.out.println("your exits are as follows\n");
        for (Enumeration e = current.getExits().elements(); e.hasMoreElements();)
        {
            Exit exit = (Exit) e.nextElement();
            System.out.println(exit.getLeadsTo().getTitle());
        }
        System.out.println("\n");
    }

    public void play(){
        currentLocation();
        currentExits();
        Enumeration e = current.getExits().elements();
        Exit ex1 = (Exit) e.nextElement();
        Exit ex2 = (Exit) e.nextElement();
        System.out.println("type the name of the place you want to go");
        System.out.println("\n");
        String word = s1.nextLine();

        
        if(word.equals("door")){
               System.out.println(ex1.getLeadsTo().getDescription()); 
        }
        else if(word.equals("table")){
               System.out.println(ex2.getLeadsTo().getDescription());
        }
        else{
               System.out.println("that isn't an  option");
        }
        
    }

}