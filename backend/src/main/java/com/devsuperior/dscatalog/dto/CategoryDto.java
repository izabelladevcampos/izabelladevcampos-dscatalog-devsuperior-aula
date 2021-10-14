package com.devsuperior.dscatalog.dto;

import com.devsuperior.dscatalog.entities.Category;

import java.io.Serializable;

public class CategoryDto implements Serializable {

    private Long id;
    private String name;

    public CategoryDto() {
    }

    public CategoryDto(Category entity){
        this.id = entity.getId();
        this.name = entity.getName();
    }

    public CategoryDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
