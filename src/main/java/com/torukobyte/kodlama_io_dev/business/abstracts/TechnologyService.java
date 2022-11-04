package com.torukobyte.kodlama_io_dev.business.abstracts;

import com.torukobyte.kodlama_io_dev.business.requests.technologies.CreateTechnologyRequest;
import com.torukobyte.kodlama_io_dev.business.requests.technologies.UpdateTechnologyRequest;
import com.torukobyte.kodlama_io_dev.business.responses.technologies.GetAllTechnologiesResponse;
import com.torukobyte.kodlama_io_dev.business.responses.technologies.GetTechnologyByIdResponse;

import java.util.List;

public interface TechnologyService {
    List<GetAllTechnologiesResponse> getAll();
    GetTechnologyByIdResponse getById(int id);
    CreateTechnologyRequest create(CreateTechnologyRequest request);
    UpdateTechnologyRequest update(UpdateTechnologyRequest request, int id);
    void delete(int id);
}