package com.torukobyte.kodlama_io_dev.business.abstracts;

import com.torukobyte.kodlama_io_dev.business.requests.languages.CreateLanguageRequest;
import com.torukobyte.kodlama_io_dev.business.requests.languages.UpdateLanguageRequest;
import com.torukobyte.kodlama_io_dev.business.responses.languages.CreateLanguageResponse;
import com.torukobyte.kodlama_io_dev.business.responses.languages.GetAllLanguageResponse;
import com.torukobyte.kodlama_io_dev.business.responses.languages.GetLanguageResponse;
import com.torukobyte.kodlama_io_dev.business.responses.languages.UpdateLanguageResponse;

import java.util.List;

public interface LanguageService {
    List<GetAllLanguageResponse> getAll();
    GetLanguageResponse getById(int id);
    CreateLanguageResponse create(CreateLanguageRequest request);
    UpdateLanguageResponse update(UpdateLanguageRequest request, int id);
    void delete(int id);
}