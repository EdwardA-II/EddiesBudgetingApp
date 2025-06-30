import java.util.*;
public class Budget {
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
            modifyBudget();

        }
        else if (userResponse.contains("3")) {
            System.out.println("Are you SURE? THIS ACTION CANNOT BE UNDONE!");
            System.out.println("Enter Y/N");
            userResponse = input.nextLine();
            // Call this method with the Budget Name.
            deleteBudget();
        }

    }


    public static void createBudget() {
        //TODO: Give them the option to give each budget a name, do multiple budgets (a map with the name and budget
        // a the value?)

        System.out.println("What is your monthly income post-tax on average? (no commas)");
        userResponse = input.nextLine();
        System.out.println();

        int income = Integer.parseInt(userResponse);
        System.out.println("Your INCOME is listed as: " + income);
        System.out.println();

        System.out.println("What are your expenses?");
        System.out.println("Enter \"DONE\" when you are done!");
        System.out.println("Please follow this model: Expense,100");
        userResponse = input.nextLine();

        Map<String, Integer> expenses = new HashMap<>();
        String expenseName;
        Integer expenseCost;


        while (!userResponse.equalsIgnoreCase("DONE")) {
            /* TODO: Add some logic to ask them are they sure and give them the option
             *       to correct an entry (replace whole entry or the name / $ amount separately.
             */


            expenseName = userResponse.split(",")[0];
            expenseCost = Integer.valueOf( userResponse.split(",")[1] );

            expenses.put(expenseName, expenseCost);

            System.out.println("You entered: " + expenseName + " : " + expenses.get(expenseName));

            System.out.println("Enter your next expense:");
            userResponse = input.nextLine();

//            userResponse = input.nextLine();

        }


    }

    public static void modifyBudget() {
    }

    public static void deleteBudget() {
    }

}
