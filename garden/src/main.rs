// para a utilização de alguma estrutura/funcao do modulo criado
use garden::vegetables::Asparagus;

// importação do modulo garden
// obs: para cada modulo se você tiver mais um módulo interno pode criar uma pasta com o mesmo nome do modulo pai
pub mod garden;

fn main() {
    let plant = Asparagus{};
    println!("I am a growing {plant:?}");
}
