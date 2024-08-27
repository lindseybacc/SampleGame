import java.util.ArrayList;
import java.util.Scanner;

public class old_bedroom {
    static Scanner input = new Scanner(System.in);
    static ArrayList<String> bedroom_items = new ArrayList<>();
    static String room = "Old Bedroom";

    public static String get_room_name() {
        return room;
    }
    public static void set_items() {
        bedroom_items.add("Shirt");
        bedroom_items.add("Blanket");
        bedroom_items.add("Old diary");
        bedroom_items.add("Lamp");
    }

    // List out and see all items
    public static void see_items() {
        System.out.println("\nItems in " + room + " are:");
        for (int i = 0; i < bedroom_items.size(); ++i) {
            System.out.println((i + 1) + " - " + bedroom_items.get(i));
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
        } while (!pick_item.equals("Shirt") && !pick_item.equals("Blanket")
                && !pick_item.equals("Old diary") && !pick_item.equals("Lamp"));

        return pick_item;
    }


    /* when user wants to take item.
   if the item is the special item, extra points are given
   function will return points for player bank based on item chosen
    */
    public static int take_item(String item) {
        int player_points = 0;
        if (!bedroom_items.contains(item)) {
            System.out.println("This item is not in the bedroom.");
        } else {
            bedroom_items.remove(item);
        }
        if (item.equals("Old diary")) {
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
        if (item.equals("Old diary")) {
            player_points = -10;
        } else {
            player_points = -2;
        }
        bedroom_items.add(item);
        return player_points;
    }

    // Movement to next room from here!
    public static String move_direction() {
        String direction;
        do {
            System.out.println("\nWhich direction do you want to head in next?");
            System.out.println("East"
                    + "\nExit");
            direction = input.nextLine();
        } while (!direction.equals("East") && !direction.equals("Exit"));

        return direction;
    }
}
