# Lojinha Web Automação
Esse é um repositório que contém a automação de alguns teste de aplicação Mobile de um software chamado lojinha, do curso "Programa de Testes e Qualidade de Software". Os sub-tópicos abaixo descrevem algumas decisões tomadas na estruturação do projeto.

## Tecnologias Utilizadas

 - Java
(http://jdk.java.net/java-se-ri/16)
 - JUnit
 https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-api/5.8.0-M1
 - Appium
https://mvnrepository.com/artifact/io.appium/java-client/7.5.1
 - Maven
https://maven.apache.org/

## Testes Automatizados

 - Testes para validar as partições de equivalência relacionadas ao valor do produto na Lojinha, que estão vinculados diretamente a regra de negócio que diz que o valor do produto que deve estar entre R$ 0,01 a R$ 7.000,00 reais.

## Notas Gerais

 - Sempre utilizamos a anotação Before Each para capturar o token que será utilizado posteriormente nos métodos de teste.
 - Utilização do conceito Page Object para melhor estruturação do código.
 - Nesse projeto fazemos o uso do JUnit 5, o que nos dá a possibilidade de usar a anotação DisplayName para dar descrições em Português para os testes.
