import java.util.*;
public class main {

    public static void main (String[] args) {
        System.out.println("Hey! Welcome to Eddie's Budget App!");
        System.out.println("What would you like to do today?");
        System.out.println("Please say \"Create Budget \", \"Modify Budget\", or \"Delete Budget\"");
        System.out.println();

        Scanner input = new Scanner (System.in);
        String userResponse = input.nextLine();

        if (userResponse.equals("Create Budget")) {
            createBudget();
        }
        else if (userResponse.equals("Modify Budget")) {

        }
        else if (userResponse.equals("Delete Budget")) {
            System.out.println("Are you SURE? THIS ACTION CANNOT BE UNDONE!");
            System.out.println("Enter Y/N");
            userResponse = input.nextLine();
        }



    }

    public static void createBudget() {
        System.out.println("What is your monthly income post-tax on average?");
    }

}
