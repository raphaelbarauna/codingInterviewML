package br.com.raphael.coding.interview.controller;

import br.com.raphael.coding.interview.model.DNARequestDTO;
import br.com.raphael.coding.interview.model.DNAResponseDTO;
import br.com.raphael.coding.interview.service.GeneticService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("dna")
@Log4j2
public class GeneticController {

    @Autowired
    private GeneticService geneticService;


    @PostMapping("/mutant")
    public ResponseEntity<String> isMutant(@Valid @RequestBody DNARequestDTO genetic) {

        var geneticCode = geneticService.isGeneticCode(genetic.getDna());

        if (!geneticCode) {
            log.info("DNA sequences contain incorrect letters. " + genetic);
            return ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);
        }

        var isMutant = geneticService.isMutant(genetic.getDna());

        return isMutant ? ResponseEntity.ok().body(null) : ResponseEntity.status(HttpStatus.FORBIDDEN).body(null);

    }

    @GetMapping("/stats")
    public ResponseEntity<DNAResponseDTO> statistics(){

        var dnaResponseDTO = geneticService.getDnaResponse();

       return ResponseEntity.ok().body(dnaResponseDTO);

    }

}
