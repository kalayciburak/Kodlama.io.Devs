package com.torukobyte.kodlama_io_dev.dataAccess.concretes;

import com.torukobyte.kodlama_io_dev.dataAccess.abstracts.LanguageRepository;
import com.torukobyte.kodlama_io_dev.entities.concretes.Language;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InMemoryLanguageRepository implements LanguageRepository {
    List<Language> languageList;

    public InMemoryLanguageRepository() {
        languageList = new ArrayList<>();
        languageList.add(new Language(1, "Java"));
        languageList.add(new Language(2, "JavaScript"));
        languageList.add(new Language(3, "C#"));
        languageList.add(new Language(4, "Python"));
        languageList.add(new Language(5, "GoLang"));
        languageList.add(new Language(6, "Dart"));
        languageList.add(new Language(7, "Kotlin"));
        languageList.add(new Language(8, "Ruby"));
    }

    @Override
    public List<Language> getAll() {
        return languageList;
    }

    @Override
    public Language getById(int id) {
        for (Language language : languageList) {
            if (language.getId() == id) return language;
        }
        return null;
    }

    @Override
    public void create(Language language) {
        languageList.add(language);
    }

    @Override
    public void update(Language language, int id) {
        Language newLanguage = getById(id);
        newLanguage.setName(language.getName());
    }

    @Override
    public void delete(int id) {
        Language language = getById(id);
        languageList.remove(language);
    }
}
