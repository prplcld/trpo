package com.melons.financemanager.api.controller;

import com.melons.financemanager.service.CurrencyService;
import com.melons.financemanager.service.dto.CurrencyDto;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/currencies")
public class CurrencyController {

    private final CurrencyService currencyService;

    @GetMapping
    public List<CurrencyDto> getAll() {
        return currencyService.getAll();
    }
}
