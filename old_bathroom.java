import java.util.ArrayList;
import java.util.Scanner;

public class old_bathroom {
    static Scanner input = new Scanner(System.in);
    static ArrayList<String> bathroom_items = new ArrayList<>();
    static String room = "Old Bathroom";

    public static String get_room_name() {
        return room;
    }
    public static void set_items() {
        bathroom_items.add("Old towel");
        bathroom_items.add("Prescription bottle");
        bathroom_items.add("Old toothbrush");
        bathroom_items.add("Makeup");
    }

    // List out and see all items
    public static void see_items() {
        System.out.println("\nItems in " + room + " are:");
        for (int i = 0; i < bathroom_items.size(); ++i) {
            System.out.println((i + 1) + " - " + bathroom_items.get(i));
        }
    }


    /* Picking and returning the item player chooses to remove from room
       Return - function will return string of item chosen
    */
    public static String pick_item() {
        String pick_item;
        see_items();

        do {
            System.out.println("Type in the name of the item from the list you want to take");
            pick_item = input.nextLine();
        } while (!pick_item.equals("Old towel") && !pick_item.equals("Prescription bottle")
                && !pick_item.equals("Old toothbrush") && !pick_item.equals("Makeup"));

        return pick_item;
    }


    /* when user wants to take item.
   if the item is the special item, extra points are given
   function will return points for player bank based on item chosen
    */
    public static int take_item(String item) {
        int player_points = 0;
        if (!bathroom_items.contains(item)) {
            System.out.println("This item is not in the bedroom.");
        } else {
            bathroom_items.remove(item);
        }
        if (item.equals("Prescription bottle")) {
            player_points = 10;
        } else {
            player_points = 2;
        }

        return player_points;
    }


    /*
        when user put back to take item.
        if the item is the special item, extra points are taken
        returning negative points to take away from player bank
    */
    public static int put_back_item(String item) {
        int player_points = 0;
        if (item.equals("Prescription bottle")) {
            player_points = -10;
        } else {
            player_points = -2;
        }
        bathroom_items.add(item);
        return player_points;
    }

    // Movement to next room from here!
    public static String move_direction() {
        String direction;
        do {
            System.out.println("\nWhich direction do you want to head in next?");
            System.out.println("South"
                    + "\nExit");
            direction = input.nextLine();
        } while (!direction.equals("South") && !direction.equals("Exit"));

        return direction;
    }
}
