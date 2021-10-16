package com.devsuperior.dscatalog.resources;

import com.devsuperior.dscatalog.dto.CategoryDto;
import com.devsuperior.dscatalog.entities.Category;
import com.devsuperior.dscatalog.services.CategoryService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    private final CategoryService service;

    public CategoryResource(CategoryService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<List<CategoryDto>> findAll() {
        List<CategoryDto> list = service.findAll();
        return ResponseEntity.ok().body(list);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<CategoryDto> findById(@PathVariable Long id) {
        CategoryDto dto = service.findById(id);
        return ResponseEntity.ok().body(dto);

    }

    @PostMapping
    public ResponseEntity<CategoryDto> insert(@RequestBody CategoryDto dto) {
        dto = service.insert(dto);
        URI uri = ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{id}")
                    .buildAndExpand(dto.getId())
                    .toUri();
        return ResponseEntity.created(uri).body(dto);
    }

    @PutMapping(value = "/{id}")
    public  ResponseEntity<CategoryDto> update(@PathVariable Long id, @RequestBody CategoryDto dto){
        dto = service.update(id, dto);
        return ResponseEntity.ok().body(dto);
    }
}
