package com.torukobyte.kodlama_io_dev.business.responses.technologies;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetAllTechnologyResponse {
    private int id;
    private String name;
    private String languageName;
}
