import java.util.Scanner;

/**
 * Created by jwartick on 3/25/17.
 */
public class Menu
{
    Scanner keyboard = new Scanner(System.in);
    String menuChoice;

    public void displayMenu()
    {
        System.out.println("(R)ead, (W)rite, or (D)isplay Cache?");
        System.out.print("> ");
        menuChoice = keyboard.nextLine();
    }

    public String getChoice()
    {
        return menuChoice;
    }

}
