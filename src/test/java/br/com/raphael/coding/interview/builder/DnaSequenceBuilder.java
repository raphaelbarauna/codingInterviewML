package br.com.raphael.coding.interview.builder;

import br.com.raphael.coding.interview.model.DNARequestDTO;
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
    
}
