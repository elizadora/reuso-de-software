use std::io;

fn main() {

   questao_01_main();
   questao_02_main();
}


fn questao_01_main(){
    // inicializando o array
    let numeros: [i32; 10] = [2, -3, 7, 0, 8, -1, 5, -4, 6, 10];

    // chamando a função media_positivos
    match media_positivos(numeros) {
        Some(media) => println!("Média dos números positivos: {}", media),
        None => println!("Não há números positivos."),
    }


    // chamando a função produto_pares
    let produto = produto_pares(numeros);
    println!("Produto dos números pares: {}", produto);


}

fn media_positivos(numeros:[i32; 10]) -> Option<f32>{
    // inicializando as variáveis
    let mut soma: i32 = 0;
    let mut qtd: i32 = 0;

    // percorrendo o array
    for numero in numeros{
        // se o número for positivo, somar e incrementar a quantidade
        if numero > 0{
            soma += numero;
            qtd += 1;
        }
    }

    // se não houver números positivos, retornar None, senão, retornar a média
    if qtd == 0{
        None
    
    }else{
        Some(soma as f32 / qtd as f32)
    }
}

fn produto_pares(numeros:[i32; 10]) -> i32{
    // inicializando a variável
    let mut result:i32 = 1;

    // percorrendo o array
    for numero in numeros{
        // se o número for par e diferente de 0, multiplicar
        if numero % 2 == 0 && numero != 0 {
            result *= numero;
        }
    }

    // retornar o resultado
    result
}


fn questao_02_main(){
    // lendo os números
    println!("Digite 3 números inteiros: ");
    let n1 = ler_inteiro();
    let n2 = ler_inteiro();
    let n3 = ler_inteiro();


    // atribuindo os números a uma tupla
    let tupla: (i32, i32, i32) = (n1, n2, n3);

    // chamando a função analisar_tupla
    let resultado = analisar_tupla(tupla);

    // exibindo o resultado
    println!("Soma: {}, Maior: {}, Menor: {}", resultado.0, resultado.1, resultado.2);

}

fn analisar_tupla(tupla: (i32, i32, i32)) -> (i32, i32, i32){
    // desestruturando a tupla
    let (n1, n2, n3) = tupla;

    // somando os números
    let soma = n1 + n2 + n3;
    // encontrando o maior e o menor número através dos métodos max e min
    let maior = n1.max(n2).max(n3);
    let menor = n1.min(n2).min(n3);

    // retornando a tupla com os resultados
    (soma, maior, menor)
}


fn ler_inteiro() -> i32{
    // inicializando a variável
    let mut input: String = String::new();

    // lendo a entrada e armazenando na variável
    io::stdin()
        .read_line(&mut input)
        .expect("Falha ao ler a linha");

    // convertendo a variável para um número inteiro
    let input: i32 = input.trim().parse().expect("Por favor, insira um número");

    // retornando o número
    input
}