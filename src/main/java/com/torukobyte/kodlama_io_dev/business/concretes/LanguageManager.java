package com.torukobyte.kodlama_io_dev.business.concretes;

import com.torukobyte.kodlama_io_dev.business.abstracts.LanguageService;
import com.torukobyte.kodlama_io_dev.dataAccess.abstracts.LanguageRepository;
import com.torukobyte.kodlama_io_dev.entities.concretes.Language;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageManager implements LanguageService {
    LanguageRepository languageRepository;

    public LanguageManager(LanguageRepository languageRepository) {
        this.languageRepository = languageRepository;
    }

    @Override
    public List<Language> getAll() {
        return languageRepository.getAll();
    }

    @Override
    public Language getById(int id) {
        return languageRepository.getById(id);
    }

    @Override
    public void create(Language language) {
        if (isLanguageExists(language)) {
            throw new RuntimeException("Language already exists");
        }

        if (checkLanguageNameValid(language)) {
            throw new RuntimeException("Language name is not valid");
        }

        languageRepository.create(language);
    }

    @Override
    public void update(Language language, int id) {
        if (languageRepository.getById(id) == null) {
            throw new RuntimeException("Language id is not valid");
        }

        if (isLanguageExists(language)) {
            throw new RuntimeException("Language already exists");
        }

        if (checkLanguageNameValid(language)) {
            throw new RuntimeException("Language name is not valid");
        }

        languageRepository.update(language, id);
    }

    @Override
    public void delete(int id) {
        languageRepository.delete(id);
    }

    public boolean isLanguageExists(Language language) {
        return languageRepository.getAll().stream().anyMatch(l -> l.getName()
                                                                   .equals(language.getName()));
    }

    public boolean checkLanguageNameValid(Language language) {
        return language.getName().isEmpty() || language.getName().isBlank() || language.getName()
                                                                                       .length() < 2;
    }
}