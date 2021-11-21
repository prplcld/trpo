package com.melons.financemanager.service;

import com.melons.financemanager.model.Category;
import com.melons.financemanager.model.Expense;
import com.melons.financemanager.model.User;
import com.melons.financemanager.repository.CategoryRepository;
import com.melons.financemanager.repository.CurrencyRepository;
import com.melons.financemanager.repository.ExpenseRepository;
import com.melons.financemanager.repository.UserRepository;
import com.melons.financemanager.service.dto.ExpenseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ExpenseService {

    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;
    private final CurrencyRepository currencyRepository;
    private final CategoryRepository categoryRepository;


    public List<ExpenseDto> getByUser(String username) {
        User user = userRepository.findByUsername(username);
        List<Expense> expenses = expenseRepository.findAllByUser(user);

        return expenses.stream()
                .map(ExpenseDto::fromExpense)
                .collect(Collectors.toList());
    }

    public ExpenseDto create(ExpenseDto expenseDto, String username) {
        User user = userRepository.findByUsername(username);
        expenseDto.setDate(LocalDateTime.now());
        Expense expense = expenseDto.toExpense();
        expense.setCurrency(currencyRepository.findByName(expenseDto.getCurrency()));
        expense.setUser(user);
        Category category = categoryRepository.findByName(expenseDto.getCategory());
        expense.setCategory(category);
        return ExpenseDto.fromExpense(expenseRepository.save(expense));
    }
}
