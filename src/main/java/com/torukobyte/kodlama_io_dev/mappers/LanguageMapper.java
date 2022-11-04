package com.torukobyte.kodlama_io_dev.mappers;

import com.torukobyte.kodlama_io_dev.business.requests.languages.CreateLanguageRequest;
import com.torukobyte.kodlama_io_dev.business.requests.languages.UpdateLanguageRequest;
import com.torukobyte.kodlama_io_dev.business.responses.languages.GetAllLanguagesResponse;
import com.torukobyte.kodlama_io_dev.business.responses.languages.GetLanguageByIdResponse;
import com.torukobyte.kodlama_io_dev.entities.concretes.Language;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper(componentModel = "spring")
public interface LanguageMapper {
    List<GetAllLanguagesResponse> toLanguages(List<Language> languages);
    GetLanguageByIdResponse toLanguage(Language language);
    Language toCreateLanguageRequest(CreateLanguageRequest request);
    void update(@MappingTarget Language language, UpdateLanguageRequest request);
}