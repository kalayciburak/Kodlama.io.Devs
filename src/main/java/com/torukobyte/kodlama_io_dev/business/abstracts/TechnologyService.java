package com.torukobyte.kodlama_io_dev.business.abstracts;

import com.torukobyte.kodlama_io_dev.business.requests.technologies.CreateTechnologyRequest;
import com.torukobyte.kodlama_io_dev.business.requests.technologies.UpdateTechnologyRequest;
import com.torukobyte.kodlama_io_dev.business.responses.technologies.CreateTechnologyResponse;
import com.torukobyte.kodlama_io_dev.business.responses.technologies.GetAllTechnologyResponse;
import com.torukobyte.kodlama_io_dev.business.responses.technologies.GetTechnologyResponse;
import com.torukobyte.kodlama_io_dev.business.responses.technologies.UpdateTechnologyResponse;

import java.util.List;

public interface TechnologyService {
    List<GetAllTechnologyResponse> getAll();
    GetTechnologyResponse getById(int id);
    CreateTechnologyResponse create(CreateTechnologyRequest request);
    UpdateTechnologyResponse update(UpdateTechnologyRequest request, int id);
    void delete(int id);
}