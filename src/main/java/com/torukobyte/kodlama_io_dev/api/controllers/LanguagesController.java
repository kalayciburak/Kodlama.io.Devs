package com.torukobyte.kodlama_io_dev.api.controllers;

import com.torukobyte.kodlama_io_dev.business.abstracts.LanguageService;
import com.torukobyte.kodlama_io_dev.entities.concretes.Language;
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
    public List<Language> getAll() {
        return languageService.getAll();
    }

    @GetMapping("/{id}")
    public Language getById(@PathVariable int id) {
        return languageService.getById(id);
    }

    @PostMapping
    public void create(@RequestBody Language language) {
        languageService.create(language);
    }

    @PutMapping("/{id}")
    public void update(@RequestBody Language language, @PathVariable int id) {
        languageService.update(language, id);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id) {
        languageService.delete(id);
    }
}
