package com.torukobyte.kodlama_io_dev.business.concretes;

import com.torukobyte.kodlama_io_dev.business.abstracts.LanguageService;
import com.torukobyte.kodlama_io_dev.business.constants.Message;
import com.torukobyte.kodlama_io_dev.business.mappers.LanguageMapper;
import com.torukobyte.kodlama_io_dev.business.requests.languages.CreateLanguageRequest;
import com.torukobyte.kodlama_io_dev.business.requests.languages.UpdateLanguageRequest;
import com.torukobyte.kodlama_io_dev.business.responses.languages.CreateLanguageResponse;
import com.torukobyte.kodlama_io_dev.business.responses.languages.GetAllLanguageResponse;
import com.torukobyte.kodlama_io_dev.business.responses.languages.GetLanguageResponse;
import com.torukobyte.kodlama_io_dev.business.responses.languages.UpdateLanguageResponse;
import com.torukobyte.kodlama_io_dev.entities.concretes.Language;
import com.torukobyte.kodlama_io_dev.repository.abstracts.LanguageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class LanguageManager implements LanguageService {
    LanguageRepository languageRepository;
    LanguageMapper mapper;

    @Override
    public List<GetAllLanguageResponse> getAll() {
        List<Language> languages = languageRepository.findAll();
        return mapper.toGetAllLanguageResponse(languages);
    }

    @Override
    public GetLanguageResponse getById(int id) {
        Language language = languageRepository.findById(id).get();
        return mapper.toGetLanguageResponse(language);
    }

    @Override
    public CreateLanguageResponse create(CreateLanguageRequest request) {
        Language language = mapper.toLanguage(request);
        if (checkLanguageNameValid(language)) {
            throw new RuntimeException(Message.LANGUAGE_NAME_IS_NOT_VALID);
        }

        if (isLanguageExists(language)) {
            throw new RuntimeException(Message.LANGUAGE_ALREADY_EXISTS);
        }

        languageRepository.save(language);

        return mapper.toCreateLanguageResponse(language);
    }

    @Override
    public UpdateLanguageResponse update(UpdateLanguageRequest request, int id) {
        Language language = languageRepository.findById(id).get();
        mapper.update(language, request);

        if (checkLanguageNameValid(language)) {
            throw new RuntimeException(Message.LANGUAGE_NAME_IS_NOT_VALID);
        }

        if (isLanguageExists(language)) {
            throw new RuntimeException(Message.LANGUAGE_ALREADY_EXISTS);
        }

        languageRepository.save(language);

        return mapper.toUpdateLanguageResponse(language);
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