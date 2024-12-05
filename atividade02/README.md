# Padrões de Projeto
Os padrões de projeto são soluções para problemas comuns que ocorrem durante o desenvolvimento de um software. Eles são como um guia de boas práticas que ajudam a resolver problemas de forma eficiente e organizada. Agindo de forma a facilitar a manutenção e a evolução do software.

## Factory Method(Fábrica)
Esse padrão uiliza uma classe para servir de fábrica para a criação de objetos. A fábrica é uma classe que possui um método que cria e retorna objetos. O método pode ser estático. O método fábrica é utilizado para criar objetos de classes derivadas de uma classe base. Sendo assim, o método fábrica é uma forma de abstração do processo de criação de objetos.

## Problema
Um sistema deseja processar pagamentos de diferentes formas, como Google Pay, PayPal, PicPay, etc.

## Solução
Utilizar o padrão Factory Method para criar uma fábrica de pagamentos. A fábrica de pagamentos é uma classe que possui um método que cria e retorna objetos de pagamento. Cada classe de pagamento é uma classe derivada de uma classe base(Payment). 

Vantagens:
- Facilita a manutenção do código.
- Facilita a adição de novas formas de pagamento.
- Facilita a evolução do software.