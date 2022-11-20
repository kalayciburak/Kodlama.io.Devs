package com.torukobyte.kodlama_io_dev.api.controllers;

import com.torukobyte.kodlama_io_dev.business.abstracts.LanguageService;
import com.torukobyte.kodlama_io_dev.business.requests.languages.CreateLanguageRequest;
import com.torukobyte.kodlama_io_dev.business.requests.languages.UpdateLanguageRequest;
import com.torukobyte.kodlama_io_dev.business.responses.languages.CreateLanguageResponse;
import com.torukobyte.kodlama_io_dev.business.responses.languages.GetAllLanguageResponse;
import com.torukobyte.kodlama_io_dev.business.responses.languages.GetLanguageResponse;
import com.torukobyte.kodlama_io_dev.business.responses.languages.UpdateLanguageResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/languages")
public class LanguagesController {
    private final LanguageService languageService;

    public LanguagesController(LanguageService languageService) {
        this.languageService = languageService;
    }

    @GetMapping
    public List<GetAllLanguageResponse> getAll() {
        return languageService.getAll();
    }

    @GetMapping("/{id}")
    public GetLanguageResponse getById(@PathVariable int id) {
        return languageService.getById(id);
    }

    @PostMapping
    @ResponseStatus(code = org.springframework.http.HttpStatus.CREATED)
    public CreateLanguageResponse create(@RequestBody CreateLanguageRequest language) {
        return languageService.create(language);
    }

    @PutMapping("/{id}")
    public UpdateLanguageResponse update(@RequestBody UpdateLanguageRequest language, @PathVariable int id) {
        return languageService.update(language, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = org.springframework.http.HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        languageService.delete(id);
    }
}
