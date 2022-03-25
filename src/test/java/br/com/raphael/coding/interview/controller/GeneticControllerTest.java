package br.com.raphael.coding.interview.controller;


import br.com.raphael.coding.interview.builder.DnaSequenceBuilder;
import br.com.raphael.coding.interview.model.DNARequestDTO;
import br.com.raphael.coding.interview.service.GeneticService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class GeneticControllerTest {

    @InjectMocks private GeneticController geneticController;

    @Mock
    private GeneticService geneticService;

    @Test
    void testIsMutant(){
        DNARequestDTO dnaRequestDTO = DnaSequenceBuilder.createDnaRequestDTO();

        when(geneticService.isGeneticCode(any())).thenReturn(true);
        when(geneticService.isMutant(any())).thenReturn(true);

        ResponseEntity<String> result = geneticController.isMutant(dnaRequestDTO);

        assertEquals(result.getStatusCode(), HttpStatus.OK);
    }

    @Test
    void testIsMutantWithIncorrectDNA(){
        DNARequestDTO dnaRequestDTO = DnaSequenceBuilder.createDnaRequestDTO();

        when(geneticService.isGeneticCode(any())).thenReturn(false);

        ResponseEntity<String> result = geneticController.isMutant(dnaRequestDTO);

        assertEquals(result.getStatusCode(), HttpStatus.FORBIDDEN);
    }

}
