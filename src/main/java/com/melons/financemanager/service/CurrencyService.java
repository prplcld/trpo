package com.melons.financemanager.service;

import com.melons.financemanager.repository.CurrencyRepository;
import com.melons.financemanager.service.dto.CurrencyDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CurrencyService {

    private final CurrencyRepository currencyRepository;

    public List<CurrencyDto> getAll() {
        return currencyRepository.findAll().stream()
                .map(CurrencyDto::fromCurrency)
                .collect(Collectors.toList());
    }
}
