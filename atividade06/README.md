# Framework simples em Java

## Descrição
Este é um framework simples em Java, criado para realizar o gerenciamento de entidades genéricas. Através dele é possível realizar operações de CRUD (Create, Read, Update, Delete) em qualquer entidade.
O framework faz uso de Generics para permitir a criação de métodos genéricos que possam ser utilizados por qualquer entidade, utilizando o conceito de reflexão para acessar os métodos e atributos de cada entidade.

## Estrutura do projeto
O projeto é composto por 3 pacotes principais: `entities`, `repository` e `data`, além da classe `Main` que contém o método `main` para execução do programa.

### Entities
Neste pacote estão as entidades que serão gerenciadas pelo framework. Cada entidade contém seus atributos e os metoros `toString`, `getId` e `setId`.

### Repository
Nesse pacote está a interface genérica do CRUD, `CrudRepository`, que contém os métodos genéricos para realizar as operações de CRUD. Além disso, exitem as classes `InMemoryRepository` e `InFileRepository` que implementam a interface `CrudRepository` e realizam as operações de CRUD em memória e em arquivos, respectivamente.

### Data
É onde está localizado o arquivo `data.json`, que é utilizado para persistir os dados das entidades quando se utiliza o `InFileRepository`.
Vale ressaltar que para a utilização de arquivos json foi utilizada a biblioteca `Gson` para  serialização e desserialização dos objetos.

## Execução
Para executar o programa, basta abrir o terminal e acessar a pasta out/artifacts/atividade06_jar e executar o comando `java -jar atividade06.jar`. Utilize a versão 21 do Java.