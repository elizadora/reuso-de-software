use std::f32;

fn main() {
    // is not obrigatory to specify the type of the tuple
    let p1 : (i32, i32, i32) =(4, 5, 6);
    let p2 : (i32, i32, i32) =(7, 8, 9);

    let dist : i32 = (p1.0 - p2.0) * (p1.0 - p2.0) + 
                     (p1.1 - p2.1) * (p1.1 - p2.1) + 
                     (p1.2 - p2.2) * (p1.2 - p2.2);


    let dist : f32 = dist as f32;
    
    
    println!("Distancia entre os pontos: {}", dist.sqrt());
}
