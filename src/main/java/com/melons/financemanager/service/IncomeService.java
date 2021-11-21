package com.melons.financemanager.service;

import com.melons.financemanager.model.Income;
import com.melons.financemanager.repository.CurrencyRepository;
import com.melons.financemanager.repository.IncomeRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class IncomeService {

    private IncomeRepository incomeRepository;
    private CurrencyRepository currencyRepository;

    public IncomeService(IncomeRepository incomeRepository, CurrencyRepository currencyRepository) {
        this.incomeRepository = incomeRepository;
        this.currencyRepository = currencyRepository;
    }

    public Income create(Income income) {
        income.setCurrency(currencyRepository.findByName(income.getCurrency().getName()));
        income.setDate(LocalDateTime.now());
        return incomeRepository.save(income);
    }
}
