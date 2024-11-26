use std::{cmp::Ordering, io};
use rand::Rng;

fn main() {
    println!("**GUESS THE NUMBER!**");
    println!("Please, input your guess: ");

    // generating random number
    let secret_number = rand::thread_rng().gen_range(1..=100);

    println!("The secret number is {secret_number}");

    // create variable string mutable
    let mut guess = String::new();

    // input, read_line(reference), if error print falied
    io::stdin()
        .read_line(&mut guess)
        .expect("Falied to read line");

    let guess: u32 = guess.trim().parse().expect("Please enter a number");


    // {} define where variable is exposeds
    
    println!("You guessed: {}", guess);

    // comparing guess with secret_number
    match guess.cmp(&secret_number){
        Ordering::Less => println!("To small"),
        Ordering::Greater => println!("To big"),
        Ordering::Equal => println!("You win!"),
    }// match-cmp
}
