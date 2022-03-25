package br.com.raphael.coding.interview.service.impl;


import br.com.raphael.coding.interview.model.DNAResponseDTO;
import br.com.raphael.coding.interview.model.DNASequence;
import br.com.raphael.coding.interview.repository.GeneticRepository;
import br.com.raphael.coding.interview.service.GeneticService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;
import java.util.stream.Collectors;


@Service
@Log4j2
public class GeneticServiceImpl implements GeneticService {


    @Autowired
    private GeneticRepository geneticRepository;

    /**
     * Method to valid the DNA sequence, will check if it contains different letters of a DNA sequence.
     *
     * @param dna
     * @return boolean
     */
    public Boolean isGeneticCode(String[] dna) {

        var dnaList = new ArrayList<>(Arrays.asList(dna));
        var lengthString = dnaList.get(0).length();

        var matchingList = dnaList.stream()
                .filter(s -> !s.matches("([A|T|C|G]+)"))
                .collect(Collectors.toList());

        var sizeList = dnaList.stream()
                .anyMatch(s -> (s.length() < lengthString || s.length() > lengthString));

        return matchingList.size() <= 0 && !sizeList;
    }


    /**
     * Method to verify if the DNA sequence is from a Mutant
     * also valid if the DNA is already registered, if not, will register.
     * @param dna
     * @return Boolean
     */
    public Boolean isMutant(String[] dna) {

        var dnaList = new ArrayList<>(Arrays.asList(dna));
        AtomicReference<Map<Integer, String>> map = new AtomicReference<>(new HashMap<>());

        boolean mutant;

        mutant = dnaList.stream().anyMatch(seq -> lookForSequenceHorizontal(seq) == 3);

        if(!mutant){
            map.set(invertVerticalToHorizontal(dna));

            mutant = map.get().values().stream().anyMatch(seq -> lookForSequenceHorizontal(seq) == 3);
        }

        String dnaString = String.join("-", dna);

        DNASequence dnaSequence = DNASequence.builder()
                .dnaSequence(dnaString)
                .isMutant(mutant).build();

        if(geneticRepository.findByDnaSequence(dnaString).size() > 0)
            log.info("This dna has already been registered.");
        else
            geneticRepository.save(dnaSequence);

        log.info(dnaSequence);


        return mutant;
    }

    public DNAResponseDTO getDnaResponse(){

       int mutant = geneticRepository.countByIsMutant(true);
       int human = geneticRepository.countByIsMutant(false);

        return DNAResponseDTO.builder()
               .count_human_dna(human)
               .count_mutant_dna(mutant)
               .ratio((double) mutant / (double) human)
               .build();
    }

    static int lookForSequenceHorizontal(String s) {
        int count = 0;
        if (s.length() > 0) {
            char letter = s.charAt(0);
            for (int windowEnd = 1; windowEnd < s.length(); windowEnd++) {
                if (letter == s.charAt(windowEnd)) {
                    count++;
                } else if(count < 3) {
                    count = 0;
                    letter = s.charAt(windowEnd);
                }
            }
        }
        return count;
    }

    static  Map<Integer, String> invertVerticalToHorizontal(String[] dna) {

        Map<Integer, String> newMap = new HashMap<>();

        Arrays.asList(dna).forEach(s -> {
            if (s.length() > 0) {
                char[] chars = s.toCharArray();
                for (int windowEnd = 0; windowEnd < chars.length; windowEnd++) {
                    if(newMap.size() >= chars.length){
                        newMap.put(windowEnd,  newMap.get(windowEnd).concat(String.valueOf(chars[windowEnd])));
                    }else {
                        newMap.put(windowEnd,  String.valueOf(chars[windowEnd]));
                    }
                }
            }
        });

        return newMap;
    }

}
