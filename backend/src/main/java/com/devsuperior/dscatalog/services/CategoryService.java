package com.devsuperior.dscatalog.services;

import com.devsuperior.dscatalog.dto.CategoryDto;
import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.repositories.CategoryRepository;
import com.devsuperior.dscatalog.services.exceptions.EntityNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CategoryService {

    private final CategoryRepository repository;

    public CategoryService(CategoryRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<CategoryDto> findAll() {
        List<Category> list = repository.findAll();
        return list.stream().map(x ->
                new CategoryDto(x)).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CategoryDto findById(Long id) {
        Optional<Category> obj = repository.findById(id);
        Category entity = obj.orElseThrow(() -> new EntityNotFoundException("Entity not found"));
        return new CategoryDto(entity);
    }
}
