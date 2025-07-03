import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class Budget {
    Map<String, BigDecimal> expenses = new HashMap<>();
    String expenseName;
    BigDecimal expenseCost;
    int income;
    BigDecimal totalExpenses = BigDecimal.valueOf(0.0);

    //TODO: Add logic to remove an item from the budget in this method. Ask them what they wanna do and allat.
    //TODO: Make a method to tally all the expenses.


    public String getBudgetName() {
        return budgetName;
    }

    public void setBudgetName(String budgetName) {
        this.budgetName = budgetName;
    }

    String budgetName;
    // TODO: Add categories to the expenses like subscriptions, utilities and whatnot.


    public Budget (String budgetName) {
        this.budgetName = budgetName;
    }

    public int getIncome() {
        return income;
    }

    public void setIncome(int income) {
        this.income = income;
    }

    public Map<String, BigDecimal> getExpenses() {
        return expenses;
    }

    public void setExpenses(Map<String, BigDecimal> expenses) {
        this.expenses = expenses;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public BigDecimal getExpenseCost() {
        return expenseCost;
    }

    public void setExpenseCost(BigDecimal expenseCost) {
        this.expenseCost = expenseCost;
    }

    public BigDecimal tallyExpenses () {
        for (String expenseName : expenses.keySet()) {
            this.totalExpenses = this.totalExpenses.add( expenses.get(expenseName) );
        }
        return this.totalExpenses;
    }
}
