package com.torukobyte.kodlama_io_dev.business.responses.languages;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetLanguageByIdResponse {
    private int id;

    private String name;
}
