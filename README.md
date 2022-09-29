## Lojinha Web Automação
Esse é um repositório que contém a automação de alguns testes Web de um software denominado Lojinha. Os sub-tópicos abaixo descrevem algumas decisões tomadas na estruturação do projeto.

## Tecnologias Utilizadas

- Java
  https://www.oracle.com/br/java/technologies/javase/jdk11-archive-downloads.html
- JUnit
  https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter-engine/5.7.1
- Maven
  https://maven.apache.org/
- WebDriver
  https://chromedriver.storage.googleapis.com/index.html?path=106.0.5249.61/

## Testes Automatizados

1. Abrir o navegador Chrome
2. Definir tempo de espera padrão de 5 segundos
3. Maximizar a tela
4. Navegar para a página Lojinha Web
5. Fazer login com usuário administrador
6. Adicionar um novo produto com o valor zerado para coincidir com Regra de Negócio que diz que o produto deve estar entre R$0,01  e R$7.000,00.

## Notas Gerais

- Notasse que possui um outro teste automatizado que está no comentário que possibilita fechar o navegador após todo o fluxo listado acima.