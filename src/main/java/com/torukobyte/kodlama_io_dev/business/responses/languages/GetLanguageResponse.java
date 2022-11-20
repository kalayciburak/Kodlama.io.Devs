package com.torukobyte.kodlama_io_dev.business.responses.languages;

import com.torukobyte.kodlama_io_dev.business.responses.technologies.TechnologyResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetLanguageResponse {
    private int id;
    private String name;
    private List<TechnologyResponse> technologies;
}
