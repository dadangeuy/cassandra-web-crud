package com.rizaldi.cassandra.web.crud.controller;

import com.rizaldi.cassandra.web.crud.model.Region;
import com.rizaldi.cassandra.web.crud.repository.RegionRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RegionController {
    private static final int MAX_REGION_IN_PAGE = 20;
    private final RegionRepository repository;

    public RegionController(RegionRepository repository) {
        this.repository = repository;
    }

    @GetMapping()
    public String viewRoot() {
        return "redirect:/list/0";
    }

    @GetMapping("list/{pageNumber}")
    public String viewListRegion(Model model, @PathVariable int pageNumber) {
        var regions = bruteForcePagination(pageNumber).getContent();
        model.addAttribute("regions", regions);
        model.addAttribute("startIndex", pageNumber * MAX_REGION_IN_PAGE + 1);
        model.addAttribute("currentPage", pageNumber);
        return "ListRegion";
    }

    // Cassandra currently not support pagination
    // Temporary Solution for: Paging queries for pages other than the first one require a CassandraPageRequest with a valid paging state
    private Slice<Region> bruteForcePagination(int pageNumber) {
        var page = PageRequest.of(0, MAX_REGION_IN_PAGE).first();
        for (int i = 0; i < pageNumber; i++)
            page = repository.findAll(page).nextPageable();
        return repository.findAll(page);
    }

    @GetMapping("update/{id}")
    public String viewUpdateRegion(Model model, @PathVariable long id) {
        var recipe = repository.findById(id).get();
        model.addAttribute("recipe", recipe);
        return "UpdateRegion";
    }

    @GetMapping("create")
    public String viewCreateRegion() {
        return "CreateRegion";
    }
}
