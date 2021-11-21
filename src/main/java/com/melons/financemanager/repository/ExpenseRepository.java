package com.melons.financemanager.repository;

import com.melons.financemanager.model.Expense;
import com.melons.financemanager.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
    List<Expense> findAllByUser(User user);
}
