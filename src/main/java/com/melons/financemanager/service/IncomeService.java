package com.melons.financemanager.service;

import com.melons.financemanager.model.Currency;
import com.melons.financemanager.model.Income;
import com.melons.financemanager.model.User;
import com.melons.financemanager.repository.CurrencyRepository;
import com.melons.financemanager.repository.IncomeRepository;
import com.melons.financemanager.repository.UserRepository;
import com.melons.financemanager.service.dto.IncomeDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class IncomeService {

    private final IncomeRepository incomeRepository;
    private final CurrencyRepository currencyRepository;
    private final UserRepository userRepository;

    public IncomeDto create(IncomeDto incomeDto, String username) {
        incomeDto.setDate(LocalDateTime.now());
        Income income = incomeDto.toIncome();
        Currency currency = new Currency();
        currency.setName(incomeDto.getCurrency());
        income.setCurrency(currencyRepository.save(currency));
        income.setUser(userRepository.findByUsername(username));
        return IncomeDto.fromIncome(incomeRepository.save(income));
    }

    public List<IncomeDto> getByUser(String username) {
        User user = userRepository.findByUsername(username);
        List<Income> incomes = incomeRepository.findAllByUser(user);
        return incomes.stream()
                .map(IncomeDto::fromIncome)
                .collect(Collectors.toList());
    }

    public List<IncomeDto> get(String username) {
        User user = userRepository.findByUsername(username);
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime localDateTimeStart = YearMonth.now().atDay(1).atStartOfDay();
        LocalDateTime localDateTimeEnd = YearMonth.now().atEndOfMonth().atTime(23, 0);
        List<Income> incomes = incomeRepository.findByUserAndDateBetween(user, localDateTimeStart, localDateTimeEnd);
        return incomes.stream()
                .map(IncomeDto::fromIncome)
                .collect(Collectors.toList());
    }
}
