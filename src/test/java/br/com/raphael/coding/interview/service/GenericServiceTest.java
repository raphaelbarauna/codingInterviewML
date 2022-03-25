package br.com.raphael.coding.interview.service;

import br.com.raphael.coding.interview.builder.DnaSequenceBuilder;
import br.com.raphael.coding.interview.model.DNASequence;
import br.com.raphael.coding.interview.repository.GeneticRepository;
import br.com.raphael.coding.interview.service.impl.GeneticServiceImpl;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
public class GenericServiceTest {

    @InjectMocks
    private GeneticServiceImpl geneticService;

    @Mock
    private GeneticRepository geneticRepository;

    @Test
    void testIfGeneticCodeContainTheRightLettersAndNumberOfLetters(){
        String[] dna = {"ATGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCTA", "TCACTG"};

        assertTrue(geneticService.isGeneticCode(dna));
    }

    @Test
    void testIfGeneticCodeContainTheRightLettersAndNumberOfLettersPassingIncorrectArray(){
        String[] dna = {"XTGCGA", "CAGTGC", "TTATGT", "AGAAGG", "CCCCT", "TCACTG"};

        assertFalse(geneticService.isGeneticCode(dna));

    }


    @Test
    void testIfIsMutant(){
        String[] dna = {"CTGCGA", "CAGTGC", "TTATGT", "AGAAGG", "ACCCT", "TCACTG"};
        List<DNASequence> dnaSequenceList = new ArrayList<>();
        dnaSequenceList.add(DnaSequenceBuilder.createDnaSequence());
        Mockito.when(geneticRepository.findByDnaSequence(anyString())).thenReturn(dnaSequenceList);

        assertTrue(geneticService.isMutant(dna));
    }

    @Test
    void testGetDnaResponse(){
        Mockito.when(geneticRepository.countByIsMutant(true)).thenReturn(10);
        Mockito.when(geneticRepository.countByIsMutant(false)).thenReturn(5);

        assertEquals(geneticService.getDnaResponse().getRatio(), 2);
    }


}
