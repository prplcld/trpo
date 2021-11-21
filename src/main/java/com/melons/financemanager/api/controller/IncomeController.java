package com.melons.financemanager.api.controller;

import com.melons.financemanager.model.Income;
import com.melons.financemanager.service.IncomeService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/incomes")
public class IncomeController {

    private IncomeService incomeService;

    public IncomeController(IncomeService incomeService) {
        this.incomeService = incomeService;
    }

    @PostMapping
    public Income create(@RequestBody Income income) {
        return incomeService.create(income);
    }
}
