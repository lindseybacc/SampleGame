import java.util.HashMap;
import java.util.Scanner;

public class player_status {
    static Scanner input = new Scanner(System.in);
    static int grand_prize = 1000;                              // setting grand prize
    static int player_points;
    static String player_position = "None";
    static HashMap<Integer,String> player_inventory = new HashMap<>();

    /* Actions player can take to navigate each room
    *  Returns the number choice */
    public static int select_action() {
        boolean valid = false;
        int choose = 0;

        // Loop to make sure user chooses a number value for return statement
        while (!valid) {
            System.out.println("\nSelect an action by number:"
                    + "\n1 - See your current location"
                    + "\n2 - See location items"
                    + "\n3 - See your items"
                    + "\n4 - Take room item"
                    + "\n5 - Drop item"
                    + "\n6 - Move"
                    + "\n7 - Exit");

            try {
                choose = input.nextInt();
                if (choose >= 1 && choose <= 7) {
                    valid = true;
                }
            } catch (Exception invalidNum) {
                System.out.println("Invalid Entry");
                input.next();
            }
        }
        return choose;
    }

    public static void in_living_room() {
        player_position = "Pick";           // resetting value of position
        int further_north = 0;              // to advance from Living room
        String chosen_item = "Pick";        // resetting value
        int action = 0;                     // menu option for user

        while (action != 7) {
            action = select_action();

            switch (action) {
                case 1:
                    System.out.println("Room name: " + old_living_room.get_room_name());
                    break;
                case 2:
                    old_living_room.see_items();
                    break;
                case 3:
                    see_inventory();
                    break;
                case 4:
                    chosen_item = old_living_room.pick_item();
                    player_points = old_living_room.take_item(chosen_item);
                    add_to_inventory(chosen_item);
                    break;
                case 5:
                    System.out.println("What do you want to drop?");
                    chosen_item = input.nextLine();
                    player_points = old_living_room.put_back_item(chosen_item);
                    remove_from_inventory(chosen_item);
                    break;
                case 6:
                    player_position = old_living_room.move_direction();
                    break;
                default:
                    break;
            }

            if (player_position.equals("East")) {
                in_garage();
            } else if (player_position.equals("West")) {
                in_bedroom();

                // breaking out depending on location from here
            } else if (player_position.equals("North")) {
                System.out.println("Choose another direction BY NUMBER: "
                        + "\n1 - North West \n2 - North East");
                do {
                    try {
                        further_north = input.nextInt();
                    } catch (Exception invalidNum) {
                        System.out.println("Not a valid number");
                        input.next();
                    }
                } while (further_north != 1 && further_north != 2);

                switch (further_north) {
                    case 1:
                        in_bathroom();
                        break;
                    case 2:
                        in_kitchen();
                    default:
                        break;
                }
            }
        }
    }
    public static void in_garage(){
        player_position = "Pick";           // resetting value of position
        String chosen_item = "Pick";        // resetting value
        int action = 0;                     // menu option for user

        while (action != 7) {
            action = select_action();
            switch (action) {
                case 1:
                    System.out.println("Room name: " + old_garage.get_room_name());
                    break;
                case 2:
                    old_garage.see_items();
                    break;
                case 3:
                    see_inventory();
                    break;
                case 4:
                    chosen_item = old_garage.pick_item();
                    player_points = old_garage.take_item(chosen_item);
                    add_to_inventory(chosen_item);
                    break;
                case 5:
                    System.out.println("What do you want to drop?");
                    chosen_item = input.nextLine();
                    player_points = old_garage.put_back_item(chosen_item);
                    remove_from_inventory(chosen_item);
                    break;
                case 6:
                    player_position = old_garage.move_direction();
                    break;
                default:
                    break;
            }

            if (player_position.equals("West")) {
                in_living_room();
            }
        }

    }
    public static void in_bedroom(){
        player_position = "Pick";           // resetting value of position
        String chosen_item = "Pick";        // resetting value
        int action = 0;                     // menu option for user

        while (action != 7) {
            action = select_action();
            switch (action) {
                case 1:
                    System.out.println("Room name: " + old_bedroom.get_room_name());
                    break;
                case 2:
                    old_bedroom.see_items();
                    break;
                case 3:
                    see_inventory();
                    break;
                case 4:
                    chosen_item = old_bedroom.pick_item();
                    player_points = old_bedroom.take_item(chosen_item);
                    add_to_inventory(chosen_item);
                    break;
                case 5:
                    System.out.println("What do you want to drop?");
                    chosen_item = input.nextLine();
                    player_points = old_bedroom.put_back_item(chosen_item);
                    remove_from_inventory(chosen_item);
                    break;
                case 6:
                    player_position = old_bedroom.move_direction();
                    break;
                default:
                    break;
            }

            if (player_position.equals("East")) {
                in_living_room();
            }
        }

    }
    public static void in_bathroom() {
        player_position = "Pick";           // resetting value of position
        String chosen_item = "Pick";        // resetting value
        int action = 0;                     // menu option for user

        while (action != 7) {
            action = select_action();
            switch (action) {
                case 1:
                    System.out.println("Room name: " + old_bathroom.get_room_name());
                    break;
                case 2:
                    old_bathroom.see_items();
                    break;
                case 3:
                    see_inventory();
                    break;
                case 4:
                    chosen_item = old_bathroom.pick_item();
                    player_points = old_bathroom.take_item(chosen_item);
                    add_to_inventory(chosen_item);
                    break;
                case 5:
                    System.out.println("What do you want to drop?");
                    chosen_item = input.nextLine();
                    player_points = old_bathroom.put_back_item(chosen_item);
                    remove_from_inventory(chosen_item);
                    break;
                case 6:
                    player_position = old_bathroom.move_direction();
                    break;
                default:
                    break;
            }

            if (player_position.equals("South")) {
                in_living_room();
            }
        }
    }
    public static void in_kitchen() {
        player_position = "Pick";           // resetting value of position
        String chosen_item;
        int action;
        action = select_action();

        while (action != 7) {
            action = select_action();
            switch (action) {
                case 1:
                    System.out.println("Room name: " + old_kitchen.get_room_name());
                    break;
                case 2:
                    old_kitchen.see_items();
                    break;
                case 3:
                    see_inventory();
                    break;
                case 4:
                    chosen_item = old_kitchen.pick_item();
                    player_points = old_kitchen.take_item(chosen_item);
                    add_to_inventory(chosen_item);
                    break;
                case 5:
                    System.out.println("What do you want to drop?");
                    chosen_item = input.nextLine();
                    player_points = old_kitchen.put_back_item(chosen_item);
                    remove_from_inventory(chosen_item);
                    break;
                case 6:
                    player_position = old_kitchen.move_direction();
                    break;
                default:
                    break;
            }

            if (player_position.equals("South")) {
                in_living_room();
            } else if (player_position.equals("North")) {
                System.out.println("Congratulations! You escaped through the backyard!"
                        + "\nYou earned grand prize of 1000 points!");
                player_points += grand_prize;
                action = 7;
            }
        }
    }

    public static void see_inventory() {
        if (player_inventory.isEmpty()) {
            System.out.println("Your item bag is empty");
        } else {
            System.out.println("Items you have: ");
            for (int i : player_inventory.keySet()) {
                System.out.println(player_inventory.get(i));
            }
        }
    }
    public static int get_player_points() {
        return player_points;
    }

    public static void add_to_inventory(String item) {
        int i = player_inventory.size() + 1;
        player_inventory.put(i,item);
    }

    // removing item from inventory
    public static void remove_from_inventory(String item) {
        if (player_inventory.containsValue(item)) {
            for (int i : player_inventory.keySet()) {
                if (player_inventory.get(i).equals(item)) {
                    player_inventory.remove(i);
                }
            }
        }
    }

    // used to load all items into rooms
    public static void initialize_items() {
        old_living_room.set_items();
        old_garage.set_items();
        old_bathroom.set_items();
        old_kitchen.set_items();
    }
}
