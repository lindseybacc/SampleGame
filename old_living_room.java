import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class old_living_room {
    static Scanner input = new Scanner(System.in);
    static ArrayList<String> living_room_items = new ArrayList<>();
    static String room = "Living Room";

    public static String get_room_name() {
        return room;
    }
    public static void set_items() {
        living_room_items.add("Magazine");
        living_room_items.add("Remote");
        living_room_items.add("Throw pillow");
        living_room_items.add("Photo album");
    }

    // List out and see all items
    public static void see_items() {
        System.out.println("\nItems in " + room + " are:");
        for (int i = 0; i < living_room_items.size(); ++i) {
            System.out.println((i + 1)  + " - " + living_room_items.get(i));
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
        } while (!pick_item.equals("Magazine") && !pick_item.equals("Remote")
                && !pick_item.equals("Throw pillow") && !pick_item.equals("Photo album"));

        return pick_item;
    }


    /* when user wants to take item.
   if the item is the special item, extra points are given
   function will return points for player bank based on item chosen
    */
    public static int take_item(String item) {
        int player_points = 0;
        if (!living_room_items.contains(item)) {
            System.out.println("This item is not in the kitchen.");
        } else {
            living_room_items.remove(item);
        }
        if (item.equals("Photo album")) {
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
        if (item.equals("Photo album")) {
            player_points = -10;
        } else {
            player_points = -2;
        }
        living_room_items.add(item);
        return player_points;
    }

    // Movement to next room from here!
    public static String move_direction() {
        String direction;

        do {
            System.out.println("\nWhich direction do you want to head in next?");
            System.out.println("East"
                    + "\nWest"
                    + "\nNorth"
                    + "\nExit");
            direction = input.nextLine();
        } while (!direction.equals("East") && !direction.equals("West") && !direction.equals("North")
                && !direction.equals("Exit"));

        return direction;
    }


}
