package com.torukobyte.kodlama_io_dev.business.responses.technologies;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetTechnologyByIdResponse {
    private int id;

    private String name;
}
