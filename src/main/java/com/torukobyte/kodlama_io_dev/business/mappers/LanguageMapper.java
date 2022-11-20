package com.torukobyte.kodlama_io_dev.business.mappers;

import com.torukobyte.kodlama_io_dev.business.requests.languages.CreateLanguageRequest;
import com.torukobyte.kodlama_io_dev.business.requests.languages.UpdateLanguageRequest;
import com.torukobyte.kodlama_io_dev.business.responses.languages.CreateLanguageResponse;
import com.torukobyte.kodlama_io_dev.business.responses.languages.GetAllLanguageResponse;
import com.torukobyte.kodlama_io_dev.business.responses.languages.GetLanguageResponse;
import com.torukobyte.kodlama_io_dev.business.responses.languages.UpdateLanguageResponse;
import com.torukobyte.kodlama_io_dev.entities.concretes.Language;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface LanguageMapper {
    GetAllLanguageResponse toGetAllLanguageResponse(Language language);
    List<GetAllLanguageResponse> toGetAllLanguageResponse(List<Language> languages);
    GetLanguageResponse toGetLanguageResponse(Language language);
    Language toLanguage(CreateLanguageRequest request);
    CreateLanguageResponse toCreateLanguageResponse(Language language);
    void update(@MappingTarget Language language, UpdateLanguageRequest request);
    UpdateLanguageResponse toUpdateLanguageResponse(Language language);
}