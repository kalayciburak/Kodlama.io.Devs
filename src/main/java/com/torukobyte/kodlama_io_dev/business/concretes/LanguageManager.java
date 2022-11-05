package com.torukobyte.kodlama_io_dev.business.concretes;

import com.torukobyte.kodlama_io_dev.business.abstracts.LanguageService;
import com.torukobyte.kodlama_io_dev.business.constants.Message;
import com.torukobyte.kodlama_io_dev.business.requests.languages.CreateLanguageRequest;
import com.torukobyte.kodlama_io_dev.business.requests.languages.UpdateLanguageRequest;
import com.torukobyte.kodlama_io_dev.business.responses.languages.GetAllLanguagesResponse;
import com.torukobyte.kodlama_io_dev.business.responses.languages.GetLanguageByIdResponse;
import com.torukobyte.kodlama_io_dev.entities.concretes.Language;
import com.torukobyte.kodlama_io_dev.mappers.LanguageMapper;
import com.torukobyte.kodlama_io_dev.repository.abstracts.LanguageRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LanguageManager implements LanguageService {
    LanguageRepository languageRepository;
    LanguageMapper languageMapper;

    public LanguageManager(LanguageRepository languageRepository, LanguageMapper languageMapper) {
        this.languageRepository = languageRepository;
        this.languageMapper = languageMapper;
    }

    @Override
    public List<GetAllLanguagesResponse> getAll() {
        List<Language> languages = languageRepository.findAll();
        return languageMapper.toLanguages(languages);
    }

    @Override
    public GetLanguageByIdResponse getById(int id) {
        Language language = languageRepository.findById(id).get();
        return languageMapper.toLanguage(language);
    }

    @Override
    public CreateLanguageRequest create(CreateLanguageRequest request) {
        Language language = languageMapper.toCreateLanguageRequest(request);
        if (checkLanguageNameValid(language)) {
            throw new RuntimeException(Message.LANGUAGE_NAME_IS_NOT_VALID);
        }

        if (isLanguageExists(language)) {
            throw new RuntimeException(Message.LANGUAGE_ALREADY_EXISTS);
        }

        languageRepository.save(language);

        return request;
    }

    @Override
    public UpdateLanguageRequest update(UpdateLanguageRequest request, int id) {
        Language language = languageRepository.findById(id).get();
        languageMapper.update(language, request);

        if (checkLanguageNameValid(language)) {
            throw new RuntimeException(Message.LANGUAGE_NAME_IS_NOT_VALID);
        }

        if (isLanguageExists(language)) {
            throw new RuntimeException(Message.LANGUAGE_ALREADY_EXISTS);
        }

        languageRepository.save(language);

        return request;
    }

    @Override
    public void delete(int id) {
        languageRepository.deleteById(id);
    }

    public boolean isLanguageExists(Language language) {
        return languageRepository.existsByName(language.getName());
    }

    public boolean checkLanguageNameValid(Language language) {
        return language.getName().isEmpty() || language.getName().isBlank();
    }
}