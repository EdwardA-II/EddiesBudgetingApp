import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.math.BigDecimal;

public class EddiesBudgetApp {
    static Scanner input;
    static String userResponse;

    static {
        try {
            input = new Scanner(new File("budget_auto_input_delete_budget.txt"));
        }
        catch (FileNotFoundException e) {
            System.err.println("Auto Input file not found.");
            System.exit(1);
        }
    }

    public static void main(String[] args) {
        System.out.println("Hey! Welcome to Eddie's Budget App!");
        System.out.println("What would you like to do today?");
        System.out.println("Please enter \"1\" to Create Budget, \"2\" to Modify Budget, \"3\" to Delete Budget, \"4\" to Display a Budget, or " +
                "\"5\" to Exit the Application");

        userResponse = input.nextLine();

        Map<String, Budget> budgetList = new HashMap<>();

        // Validate user input and do not continue until they make a valid entry.
        Set<String> validOptions = Set.of("1", "2", "3", "4", "5");

        while (!validOptions.contains(userResponse)) {
            System.out.println("Invalid option. Please enter 1, 2, 3, 4, 5:");
            userResponse = input.nextLine();
        }

        while (!userResponse.equalsIgnoreCase("5")) {
            switch (userResponse) {
                case "1" -> createBudget(budgetList);
                case "2" -> modifyBudget(budgetList);
                case "3" -> deleteBudget(budgetList);
                case "4" -> displayBudget(budgetList);
            }

            userResponse = input.nextLine();
        }

        System.out.println("Goodbye 👋");
        System.exit(0);

    }


    public static void createBudget(Map<String, Budget> budgetList) {
        System.out.println("What would you like to name this budget?");
        String budgetName = input.nextLine();
        Budget budget = new Budget();
        budget.setBudgetName(budgetName);

        System.out.println("What is your monthly income post-tax on average? (no commas)");
        userResponse = input.nextLine();
        System.out.println();

        BigDecimal income = new BigDecimal(userResponse);
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

        while (!userResponse.equalsIgnoreCase("DONE")) {
            expenseName = userResponse.split(",")[0].trim();
            String rawExpense = userResponse.split(",")[1].trim();
            expenseCost = new BigDecimal(rawExpense);
            expenses.put(expenseName, expenseCost);

            System.out.println( "You entered: " + expenseName + " : " + expenses.get(expenseName) );
            System.out.println();

            System.out.println("Enter your next expense:");
            userResponse = input.nextLine();
        }

        budget.setExpenses(expenses);
        budgetList.put(budgetName, budget);
    }

    public static void modifyBudget(Map<String, Budget> budgetList) {
    }

    public static void deleteBudget(Map<String, Budget> budgetList) {
        System.out.print("Which budget would you like to delete:");
        userResponse = input.nextLine();
        String budgetName = userResponse;

        System.out.println("Are you SURE? THIS ACTION CANNOT BE UNDONE!");
        System.out.println("Enter Y/N");
        userResponse = input.nextLine();

        if (userResponse.equalsIgnoreCase("Y")) {
            budgetList.remove(budgetName);
        }

        System.out.println(budgetName + " has been deleted!");

    }

    public static void displayBudget(Map<String, Budget> budgetList) {
        System.out.println("Which budget would you like to display?");
        String budgetName = input.nextLine();

        Budget budgetToDisplay = budgetList.get(budgetName);
        Map<String, BigDecimal> budgetExpenses = budgetToDisplay.getExpenses();

        System.out.println("Your income is listed as: " + budgetToDisplay.getIncome());

        System.out.println("Your expenses are: ");

        for (Map.Entry<String, BigDecimal> entry : budgetExpenses.entrySet()) {
            System.out.println(entry.getKey() + " - " + "$" + entry.getValue());
        }

        System.out.println("Your total expenses are: " + budgetToDisplay.tallyExpenses());
        BigDecimal totalExpenses = budgetToDisplay.totalExpenses;
        BigDecimal remaining = budgetToDisplay.getIncome().subtract(totalExpenses);
        System.out.println("So! Your remaining budget is: " + remaining);
    }

}
