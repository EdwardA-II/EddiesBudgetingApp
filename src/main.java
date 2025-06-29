import java.util.*;
public class main {
    static Scanner input = new Scanner (System.in);
    static String userResponse;


    public static void main (String[] args) {
        System.out.println("Hey! Welcome to Eddie's Budget App!");
        System.out.println("What would you like to do today?");
        System.out.println("Please enter \"1\" to Create Budget, \"2\" to Modify Budget, or \"3\" to Delete Budget");

        userResponse = input.nextLine();

        if (userResponse.contains("1")) {
            createBudget();
        }
        else if (userResponse.contains("2")) {

        }
        else if (userResponse.contains("3")) {
            System.out.println("Are you SURE? THIS ACTION CANNOT BE UNDONE!");
            System.out.println("Enter Y/N");
            userResponse = input.nextLine();
        }

    }

    public static void createBudget() {
        System.out.println("What is your monthly income post-tax on average? (no commas)");
        userResponse = input.nextLine();
        System.out.println();

        int income = Integer.parseInt(userResponse);
        System.out.println("Your income is listed as: " + income);
    }

}
