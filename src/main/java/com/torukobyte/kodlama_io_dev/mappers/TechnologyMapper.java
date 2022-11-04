package com.torukobyte.kodlama_io_dev.mappers;

import com.torukobyte.kodlama_io_dev.business.requests.technologies.CreateTechnologyRequest;
import com.torukobyte.kodlama_io_dev.business.requests.technologies.UpdateTechnologyRequest;
import com.torukobyte.kodlama_io_dev.business.responses.technologies.GetAllTechnologiesResponse;
import com.torukobyte.kodlama_io_dev.business.responses.technologies.GetTechnologyByIdResponse;
import com.torukobyte.kodlama_io_dev.entities.concretes.Technology;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper(componentModel = "spring")
public interface TechnologyMapper {
    List<GetAllTechnologiesResponse> toTechnologies(List<Technology> technologies);
    GetTechnologyByIdResponse toTechnology(Technology technology);
    Technology toCreateTechnologyRequest(CreateTechnologyRequest request);
    void update(@MappingTarget Technology technology, UpdateTechnologyRequest request);
}
