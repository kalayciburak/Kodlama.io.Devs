package com.torukobyte.kodlama_io_dev.mappers;

import com.torukobyte.kodlama_io_dev.business.requests.technologies.CreateTechnologyRequest;
import com.torukobyte.kodlama_io_dev.business.requests.technologies.UpdateTechnologyRequest;
import com.torukobyte.kodlama_io_dev.business.responses.technologies.CreateTechnologyResponse;
import com.torukobyte.kodlama_io_dev.business.responses.technologies.GetAllTechnologyResponse;
import com.torukobyte.kodlama_io_dev.business.responses.technologies.GetTechnologyResponse;
import com.torukobyte.kodlama_io_dev.business.responses.technologies.UpdateTechnologyResponse;
import com.torukobyte.kodlama_io_dev.entities.concretes.Technology;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TechnologyMapper {

    @Mapping(source = "language.name", target = "languageName")
    GetAllTechnologyResponse toGetAllTechnologyResponse(Technology technology);
    List<GetAllTechnologyResponse> toGetAllTechnologyResponse(List<Technology> technologies);
    @Mapping(source = "language.name", target = "languageName")
    GetTechnologyResponse toTechnology(Technology technology);
    @Mapping(source = "languageId", target = "language.id")
    Technology toTechnology(CreateTechnologyRequest request);
    @Mapping(source = "language.id", target = "languageId")
    CreateTechnologyResponse toCreateTechnologyResponse(Technology technology);
    @Mapping(source = "languageId", target = "language.id")
    void update(@MappingTarget Technology technology, UpdateTechnologyRequest request);
    @Mapping(source = "language.id", target = "languageId")
    UpdateTechnologyResponse toUpdateTechnologyResponse(Technology technology);
}
