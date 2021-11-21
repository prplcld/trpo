package com.melons.financemanager.service;

import com.melons.financemanager.exception.EntityNotFoundException;
import com.melons.financemanager.model.Category;
import com.melons.financemanager.repository.CategoryRepository;
import com.melons.financemanager.service.dto.CategoryDto;
import com.melons.financemanager.service.dto.IncomeDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public List<CategoryDto> getAll() {
        return categoryRepository.findAll()
                .stream()
                .map(CategoryDto::fromCategory)
                .collect(Collectors.toList());
    }

    public CategoryDto getById(Integer id) {
        Category category = categoryRepository.findById(id).orElseThrow(EntityNotFoundException::new);
        return CategoryDto.fromCategory(category);
    }
}
