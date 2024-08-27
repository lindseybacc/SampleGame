/*
 * @name Lindsey Baccellieri
 * @project Movement Game
 * @warning Logic may be a little incorrect
 */

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int exit_game = 9;

        System.out.println("\nFind the backyard to escape the Old House!");
        System.out.println("Pick up items from rooms to earn possible bonus points.");

        // initializing items for game
        player_status.initialize_items();

        // User will come back to main menu when they exit house
        while (exit_game != 0) {
            System.out.println("Would you like to enter the old house? \n1 - Enter \n0 - Exit");
            try {
                exit_game = input.nextInt();
            } catch (Exception invalidNumber) {
                System.out.println("You did not enter a number.");
                input.next();
            }

            if (exit_game == 1) {
                    player_status.in_living_room();
            }

        }

        System.out.println("Thank you for playing the game!"
                + "\nYou earned: " + player_status.get_player_points() + " points.");

        if (player_status.player_points >= 1000) {
            System.out.println("Congratulations - you beat the game by making it to the backyard!");
        }

    }
}