package br.com.raphael.coding.interview.model;


import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DNAResponseDTO {

    private Integer count_mutant_dna;
    private Integer count_human_dna;
    private Double ratio;
}
