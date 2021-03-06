package com.rizaldi.cassandra.web.crud.controller;

import com.rizaldi.cassandra.web.crud.model.Region;
import com.rizaldi.cassandra.web.crud.repository.RegionRepository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
public class RegionApiController {
    private final RegionRepository repository;

    public RegionApiController(RegionRepository repository) {
        this.repository = repository;
    }

    @PostMapping("create")
    private Region create(@ModelAttribute Region region) {
        return repository.insert(region);
    }

    @PostMapping("update")
    private Region update(@ModelAttribute Region region) {
        return repository.save(region);
    }

    @GetMapping("delete/{code}")
    private void delete(@PathVariable long code) {
        repository.deleteById(code);
    }
}
