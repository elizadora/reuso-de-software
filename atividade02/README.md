# Padrões de software
Os padrões de software, são métodos utilizados para contornar erros comuns de serem encontrados na criação de projetos e também para o desenvolvimento de uma estrutura de fácil implementação e manutenção.

## Problema Fictício
Um sistema deseja processar pagamentos utilizando meios diferentes como: PayPal, Google Pay e Transferência bancária.

## Solução
Utilizar o padrão Factory(Fábrica), através dele é criada uma classe responsável pela geração dos objetos das formas de pagamento mediante um parâmetro enviado.