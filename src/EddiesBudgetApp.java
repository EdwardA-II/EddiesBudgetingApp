import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.math.BigDecimal;

public class EddiesBudgetApp {
    static Scanner input;
    static String userResponse;

    // Comment out when you want to put in the input manually.
    static {
        try {
            input = new Scanner(new File("budget_auto_input.txt"));
        }
        catch (FileNotFoundException e) {
            System.err.println("Input file not found.");
            System.exit(1);
        }
    }


    public static void main (String[] args) {
        System.out.println("Hey! Welcome to Eddie's Budget App!");
        System.out.println("What would you like to do today?");
        System.out.println("Please enter \"1\" to Create Budget, \"2\" to Modify Budget, or \"3\" to Delete Budget");

        userResponse = input.nextLine();

        Map<String, Budget> budgetList = new HashMap<>();

        //TODO: Refactor to look less uglass.
        while ( !userResponse.equalsIgnoreCase("1") &&  !userResponse.equalsIgnoreCase("2")
                && !userResponse.equalsIgnoreCase("3") )
        {
            if (userResponse.contains("1")) {
                createBudget(budgetList);
            }
            else if (userResponse.contains("2")) {
                modifyBudget(budgetList);
            }
            else if (userResponse.contains("3")) {
                deleteBudget(budgetList);
            }
            else {
                System.out.println("Invalid option. Please enter 1, 2, or 3.");
                userResponse = input.nextLine();
            }
        }




    }

    public static void createBudget(Map<String, Budget> budgetList) {
        //TODO: Give them the option to give each budget a name, do multiple budgets (a map with the name and budget
        // as the value?)

        System.out.println("What would you like to name this budget?");
        String budgetName = input.nextLine();
        Budget budget = new Budget();
        budget.setBudgetName(budgetName);


        System.out.println("What is your monthly income post-tax on average? (no commas)");
        userResponse = input.nextLine();
        System.out.println();

        int income = Integer.parseInt(userResponse);
        budget.setIncome(income);

        System.out.println("Your INCOME is listed as: " + budget.getIncome());
        System.out.println();

        System.out.println("What are your expenses?");
        System.out.println("Please follow this model: Expense,100.50");
        System.out.println("Enter \"DONE\" when you are done!");
        userResponse = input.nextLine();

        Map<String, BigDecimal> expenses = new HashMap<>();
        String expenseName;
        BigDecimal expenseCost;
        // TODO: Add categories to the expenses like subscriptions, utilities and whatnot.
        //  also make the logic to have them pick and choose which expense to edit.

        while (!userResponse.equalsIgnoreCase("DONE")) {
            /* TODO: Add some logic to ask them are they sure and give them the option
             *       to correct an entry (replace whole entry or the name / $ amount separately.
             */

            expenseName = userResponse.split(",")[0].trim();
            double rawExpense = Double.parseDouble(userResponse.split(",")[1].trim());
            expenseCost = BigDecimal.valueOf(rawExpense);
            expenses.put(expenseName, expenseCost);

            System.out.println( "You entered: " + expenseName + " : " + expenses.get(expenseName) );
            System.out.println();

            System.out.println("Enter your next expense:");
            userResponse = input.nextLine();
        }

        budget.setExpenses(expenses);

        System.out.println("Your total expenses are: " + budget.tallyExpenses());
        budgetList.put(budgetName, budget);


//        double remaining = expenseName;
//        System.out.println("Currently, your budget is the following: ");





    }

    public static void modifyBudget(Map<String, Budget> budgetList) {
    }

    public static void deleteBudget(Map<String, Budget> budgetList) {
        System.out.println("Which budget would you like to delete");
        userResponse = input.nextLine();

        System.out.println("Are you SURE? THIS ACTION CANNOT BE UNDONE!");
        System.out.println("Enter Y/N");
        userResponse = input.nextLine();
    }

}
