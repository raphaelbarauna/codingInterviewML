package br.com.raphael.coding.interview.model;


import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DNARequestDTO {

    @Valid
    @NotEmpty(message = "DNA can't be empty.")
    private String[] dna;
}
