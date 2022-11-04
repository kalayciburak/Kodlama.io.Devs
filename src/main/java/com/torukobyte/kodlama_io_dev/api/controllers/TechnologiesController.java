package com.torukobyte.kodlama_io_dev.api.controllers;

import com.torukobyte.kodlama_io_dev.business.abstracts.TechnologyService;
import com.torukobyte.kodlama_io_dev.business.requests.technologies.CreateTechnologyRequest;
import com.torukobyte.kodlama_io_dev.business.requests.technologies.UpdateTechnologyRequest;
import com.torukobyte.kodlama_io_dev.business.responses.technologies.GetAllTechnologiesResponse;
import com.torukobyte.kodlama_io_dev.business.responses.technologies.GetTechnologyByIdResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/technologies")
public class TechnologiesController {
    private final TechnologyService technologyService;

    public TechnologiesController(TechnologyService technologyService) {
        this.technologyService = technologyService;
    }

    @GetMapping(name = "GetAllTechnologies")
    public List<GetAllTechnologiesResponse> getAll() {
        return technologyService.getAll();
    }

    @GetMapping(name = "GetTechnologyById", path = "/{id}")
    public GetTechnologyByIdResponse getById(@PathVariable int id) {
        return technologyService.getById(id);
    }

    @PostMapping(name = "CreateTechnology")
    @ResponseStatus(code = org.springframework.http.HttpStatus.CREATED)
    public CreateTechnologyRequest create(@RequestBody CreateTechnologyRequest technology) {
        return technologyService.create(technology);
    }

    @PutMapping(name = "UpdateTechnology", path = "/{id}")
    public UpdateTechnologyRequest update(@RequestBody UpdateTechnologyRequest technology, @PathVariable int id) {
        return technologyService.update(technology, id);
    }

    @DeleteMapping(name = "DeleteTechnology", path = "/{id}")
    @ResponseStatus(code = org.springframework.http.HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        technologyService.delete(id);
    }
}
