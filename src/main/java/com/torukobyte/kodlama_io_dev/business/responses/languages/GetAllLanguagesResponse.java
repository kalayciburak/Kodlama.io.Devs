package com.torukobyte.kodlama_io_dev.business.responses.languages;

import com.torukobyte.kodlama_io_dev.business.responses.technologies.GetAllTechnologiesResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllLanguagesResponse {
    private String name;
    private List<GetAllTechnologiesResponse> technologies;
}