package br.com.raphael.coding.interview.service;


import br.com.raphael.coding.interview.model.DNAResponseDTO;

public interface GeneticService {

    Boolean isMutant(String[] dna);

    Boolean isGeneticCode(String[] dna);

    DNAResponseDTO getDnaResponse();
}
