package br.com.raphael.coding.interview.builder;

import br.com.raphael.coding.interview.model.DNARequestDTO;
import br.com.raphael.coding.interview.model.DNAResponseDTO;
import br.com.raphael.coding.interview.model.DNASequence;

public class DnaSequenceBuilder {
    
    public static DNASequence createDnaSequence(){
        
        return DNASequence.builder()
                .dnaSequence("ATGCGA-CAGTGC-TTATGT-AGAAGG-CCCCTA-TCACTG")
                .isMutant(false).build();
        
    }

    public static DNARequestDTO createDnaRequestDTO(){

        return new DNARequestDTO(new String[]{"XTGCGA", "CAGTGC", "TTATGT", "AGAAGG", "ACCCT", "TCACTG"});

    }

    public static DNAResponseDTO createDnaResponseDTO(){

        return DNAResponseDTO.builder()
                .count_mutant_dna(10)
                .count_human_dna(5)
                .ratio(2.0).build();
    }
    
}
