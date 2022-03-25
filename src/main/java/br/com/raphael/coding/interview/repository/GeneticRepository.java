package br.com.raphael.coding.interview.repository;

import br.com.raphael.coding.interview.model.DNASequence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GeneticRepository extends JpaRepository<DNASequence, Integer> {

    List<DNASequence> findByDnaSequence(String dnaSequence);

    int countByIsMutant(Boolean isMutant);
}
