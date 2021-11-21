package com.melons.financemanager.service.dto;

import com.melons.financemanager.model.Expense;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExpenseDto {
    private Integer id;
    private BigDecimal amount;
    private String description;
    private String location;
    private LocalDateTime date;
    private String category;
    private String username;
    private String currency;

    public static ExpenseDto fromExpense(Expense expense) {
        ExpenseDto expenseDto = new ExpenseDto();
        expenseDto.setId(expense.getId());
        expenseDto.setAmount(expense.getAmount());
        expenseDto.setDescription(expense.getDescription());
        expenseDto.setLocation(expense.getLocation());
        expenseDto.setDate(expense.getDate());
        expenseDto.setCategory(expense.getCategory().getName());
        expenseDto.setUsername(expense.getUser().getUsername());
        expenseDto.setCurrency(expense.getCurrency().getName());
        return expenseDto;
    }

    public Expense toExpense() {
        Expense expense = new Expense();
        expense.setId(id);
        expense.setAmount(amount);
        expense.setDescription(description);
        expense.setLocation(location);
        expense.setDate(date);
        return expense;
    }
}
