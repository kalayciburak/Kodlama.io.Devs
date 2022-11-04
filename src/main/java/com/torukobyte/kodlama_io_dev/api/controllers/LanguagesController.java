package com.torukobyte.kodlama_io_dev.api.controllers;

import com.torukobyte.kodlama_io_dev.business.abstracts.LanguageService;
import com.torukobyte.kodlama_io_dev.business.requests.languages.CreateLanguageRequest;
import com.torukobyte.kodlama_io_dev.business.requests.languages.UpdateLanguageRequest;
import com.torukobyte.kodlama_io_dev.business.responses.languages.GetAllLanguagesResponse;
import com.torukobyte.kodlama_io_dev.business.responses.languages.GetLanguageByIdResponse;
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
    public List<GetAllLanguagesResponse> getAll() {
        return languageService.getAll();
    }

    @GetMapping("/{id}")
    public GetLanguageByIdResponse getById(@PathVariable int id) {
        return languageService.getById(id);
    }

    @PostMapping
    @ResponseStatus(code = org.springframework.http.HttpStatus.CREATED)
    public CreateLanguageRequest create(@RequestBody CreateLanguageRequest language) {
        return languageService.create(language);
    }

    @PutMapping("/{id}")
    public UpdateLanguageRequest update(@RequestBody UpdateLanguageRequest language, @PathVariable int id) {
        return languageService.update(language, id);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = org.springframework.http.HttpStatus.NO_CONTENT)
    public void delete(@PathVariable int id) {
        languageService.delete(id);
    }
}
