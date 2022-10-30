package com.torukobyte.kodlama_io_dev.business.abstracts;

import com.torukobyte.kodlama_io_dev.entities.concretes.Language;

import java.util.List;

public interface LanguageService {
    List<Language> getAll();
    Language getById(int id);
    void create(Language language);
    void update(Language language,int id);
    void delete(int id);
}