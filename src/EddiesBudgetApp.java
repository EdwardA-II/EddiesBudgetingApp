import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.math.BigDecimal;

public class EddiesBudgetApp {
    static Scanner input;
    static String userResponse;

    static {
        try {
            // Negative Testing - Incorrect Intro Option
            input = new Scanner(new File("budget_auto_input.txt"));
        }
        catch (FileNotFoundException e) {
            System.err.println("Auto Input file not found.");
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        System.out.println("Hey! Welcome to Eddie's Budget App!");
        System.out.println("What would you like to do today?");
        System.out.println("Please enter \"1\" to Create Budget, \"2\" to Modify Budget, \"3\" to Delete Budget, or \"4\" to Exit the Application");

        userResponse = input.nextLine();

        Map<String, Budget> budgetList = new HashMap<>();

        Set<String> validOptions = Set.of("1", "2", "3", "4");

        // Validate user input and do not continue until they make a valid entry.
        while (!validOptions.contains(userResponse)) {
            System.out.println("Invalid option. Please enter 1, 2, 3, 4:");
            userResponse = input.nextLine();
        }

        // At this point, the userResponse is guaranteed to be valid
        switch (userResponse) {
            case "1" -> createBudget(budgetList);
            case "2" -> modifyBudget(budgetList);
            case "3" -> deleteBudget(budgetList);
            case "4" -> {
                System.out.println("Goodbye 👋");
                System.exit(0);
            }
        }
    }

    public static void createBudget(Map<String, Budget> budgetList) {
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
    }

    public static void modifyBudget(Map<String, Budget> budgetList) {
    }

    public static void deleteBudget(Map<String, Budget> budgetList) {
        System.out.println("Which budget would you like to delete");
        userResponse = input.nextLine();
        String budgetName = userResponse;

        System.out.println("Are you SURE? THIS ACTION CANNOT BE UNDONE!");
        System.out.println("Enter Y/N");
        userResponse = input.nextLine();

        budgetList.remove(budgetName);
    }

    public static void displayBudget() {
        System.out.println();
    }

}
