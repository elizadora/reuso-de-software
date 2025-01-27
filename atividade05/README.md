# Exercício: Criação de uma API simples e cliente para gestão de cursos

A atividade foi feita utilizando de duas aplicações simples, uma API, que gerencia os cursos e um cliente que consome essa API. As tecnologias utilizadas para o desenvolvimento foram:

- API: Node.js, Express.js, SQLite3 e Nodemon
- Cliente: Python, Requests

## API
A API apresenta um simples CRUD de cursos(criação, leitura, atualização e deleção). Para rodar a API, basta executar o comando `npm start` ou `npm run dev` (caso deseje utilizar o nodemon).

Foi realizada uma divisão nos arquivos para uma melhor visualização da aplicação. 
- A pasta db, contém o arquivo de inicialização do banco e criação da tabela cursos.
- A pasta controllers, contém o arquivo de controle da aplicação, onde estão as funções do CRUD. 
- A pasta routes contém o arquivo de rotas da aplicação, onde estão as rotas para cada função do CRUD. E por fim, o arquivo index.js e app.js, que são respectivamente o arquivo de inicialização da aplicação e o arquivo de configuração do express.

## Cliente
O cliente foi feito em Python, utilizando a biblioteca Requests para consumir a API. O cliente apresenta um menu simples, onde o usuário pode escolher entre as opções de listar todos os cursos, buscar um curso específico, adicionar um curso, atualizar um curso e deletar um curso. Para rodar o cliente, basta executar o comando `python client.py`.