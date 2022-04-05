# Aplicação Desenvolvida Utilizando JAVA 11 com Spring Boot na versão 2.6.4.

Para rodar o projeto basta utilizar o comando : spring-boot:run

Para testes unitários foi configurado o Jacoco, rodar o comando mvn clean install, após rodar o comando, verificar o arquivo index.html na
pasta: \coding.interview\target\site\jacoco

OBS: Caso o link da AWS esteja Offline, será necessário iniciar a instância.

Usuario: barauna.rafael@gmail.com
senha: 123456Barauna

- 1 Acessar o link: https://us-east-1.console.aws.amazon.com/ec2/v2/home?region=us-east-1#Instances:
- 2 Clicar com botão direito na instância EC2 e depois opção conectar.
- 3 Após se conectar, executar o comando java -jar coding.interview.jar

BANCO DE DADOS : H2 (alterar no application.properties) 

   - Url LOCALHOST para acesso: http://localhost:8080/h2-console  
  
   - url: jdbc:h2:mem:mydb
   - username: sa
   - password:
   


ENDPOINTS :

GET Para retornar estatísticas de verificações de DNA:

  - LOCALHOST : http://localhost:8080/dna/stats
  - Amazon aws: http://ec2-34-239-0-243.compute-1.amazonaws.com:8080/dna/stats

Exemplo retorno:
   {
     "count_mutant_dna": 2,
     "count_human_dna": 4,
     "ratio": 0.5
   }

POST Verificar se contém um mutant no array:

  - Localhost:  http://localhost:8080/dna/mutant 
  - Amazon aws: http://ec2-34-239-0-243.compute-1.amazonaws.com:8080/dna/mutant

Exemplo Payload:  
  {
    "dna": ["GAAATT", "CAGTGC", "GTATGT", "GGCAGG", "TCGATA", "TCACTG"]
  }



