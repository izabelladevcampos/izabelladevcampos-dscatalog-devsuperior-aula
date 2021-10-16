package com.devsuperior.dscatalog.dto;

import com.devsuperior.dscatalog.entities.Category;

import java.io.Serializable;

public class CategoryDto implements Serializable {

    private Long id;
    private String nome;

    public CategoryDto() {
    }

    public CategoryDto(Long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public CategoryDto(Category entity) {
        this.id = entity.getId();
        this.nome = entity.getName();
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

}
