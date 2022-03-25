# Aplicação Desenvolvida Utilizando JAVA 11 com Spring Boot na versão 2.6.4.

Para rodar o projeto basta utilizar o comando : spring-boot:run

Para testes unitários foi configurado o Jacoco, rodar o comando mvn clean install, após rodar o comando, verificar o arquivo index.html na
pasta: \coding.interview\target\site\jacoco

BANCO DE DADOS : H2 (alterar no application.properties) 

   - Url para acesso: http://localhost:8080/h2-console  
  
   - url: jdbc:h2:mem:mydb
   - username: sa
   - password:
   


ENDPOINTS :

GET :

  - Para retornar estatísticas de verificações de DNA: http://localhost:8080/dna/stats

retorno: {
          "count_mutant_dna": 2,
          "count_human_dna": 4,
          "ratio": 0.5
          }

POST :

  - Verificar se contém um mutant no array:  http://localhost:8080/dna/mutant 

Payload:  
  {
    "dna": ["GAAATT", "CAGTGC", "GTATGT", "GGCAGG", "TCGATA", "TCACTG"]
  }



