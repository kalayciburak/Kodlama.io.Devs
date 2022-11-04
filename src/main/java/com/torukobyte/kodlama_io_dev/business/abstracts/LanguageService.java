package com.torukobyte.kodlama_io_dev.business.abstracts;

import com.torukobyte.kodlama_io_dev.business.requests.languages.CreateLanguageRequest;
import com.torukobyte.kodlama_io_dev.business.requests.languages.UpdateLanguageRequest;
import com.torukobyte.kodlama_io_dev.business.responses.languages.GetAllLanguagesResponse;
import com.torukobyte.kodlama_io_dev.business.responses.languages.GetLanguageByIdResponse;

import java.util.List;

public interface LanguageService {
    List<GetAllLanguagesResponse> getAll();
    GetLanguageByIdResponse getById(int id);
    CreateLanguageRequest create(CreateLanguageRequest request);
    UpdateLanguageRequest update(UpdateLanguageRequest request, int id);
    void delete(int id);
}