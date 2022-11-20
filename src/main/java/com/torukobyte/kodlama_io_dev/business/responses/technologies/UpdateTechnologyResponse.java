package com.torukobyte.kodlama_io_dev.business.responses.technologies;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateTechnologyResponse {
    private int id;
    private int languageId;
    private String name;
}
