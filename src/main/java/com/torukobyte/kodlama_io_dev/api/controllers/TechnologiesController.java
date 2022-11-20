package com.torukobyte.kodlama_io_dev.api.controllers;

import com.torukobyte.kodlama_io_dev.business.abstracts.TechnologyService;
import com.torukobyte.kodlama_io_dev.business.requests.technologies.CreateTechnologyRequest;
import com.torukobyte.kodlama_io_dev.business.requests.technologies.UpdateTechnologyRequest;
import com.torukobyte.kodlama_io_dev.business.responses.technologies.CreateTechnologyResponse;
import com.torukobyte.kodlama_io_dev.business.responses.technologies.GetAllTechnologyResponse;
import com.torukobyte.kodlama_io_dev.business.responses.technologies.GetTechnologyResponse;
import com.torukobyte.kodlama_io_dev.business.responses.technologies.UpdateTechnologyResponse;
import org.springframework.http.HttpStatus;
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
    public List<GetAllTechnologyResponse> getAll() {
        return technologyService.getAll();
    }

    @GetMapping(name = "GetTechnologyById", path = "/{id}")
    public GetTechnologyResponse getById(@PathVariable int id) {
        return technologyService.getById(id);
    }

    @PostMapping(name = "CreateTechnology")
    @ResponseStatus(code = HttpStatus.CREATED)
    public CreateTechnologyResponse create(@RequestBody CreateTechnologyRequest technology) {
        return technologyService.create(technology);
    }

    @PutMapping(name = "UpdateTechnology", path = "/{id}")
    public UpdateTechnologyResponse update(@RequestBody UpdateTechnologyRequest technology, @PathVariable int id) {
        return technologyService.update(technology, id);
    }

    @DeleteMapping(name = "DeleteTechnology", path = "/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        technologyService.delete(id);
    }
}
