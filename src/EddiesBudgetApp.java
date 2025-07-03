import java.util.*;
import java.math.BigDecimal;

public class EddiesBudgetApp {
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
        // as the value?)

        System.out.println("What would you like to name this budget?");
        String budgetName = input.nextLine();
        Budget budget = new Budget(budgetName);


        System.out.println("What is your monthly income post-tax on average? (no commas)");
        userResponse = input.nextLine();
        System.out.println();

        int income = Integer.parseInt(userResponse);
        budget.setIncome(income);

        System.out.println("Your INCOME is listed as: " + budget.getIncome());
        System.out.println();

        System.out.println("What are your expenses?");
        System.out.println("Please follow this model: Expense,100");
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


//        double remaining = expenseName;
//        System.out.println("Currently, your budget is the following: ");





    }

    public static void modifyBudget() {
    }

    public static void deleteBudget() {
    }

}
