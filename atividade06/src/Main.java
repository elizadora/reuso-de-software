import com.google.gson.reflect.TypeToken;
import entities.Person;
import entities.Product;
import repository.InFileRepository;
import repository.InMemoryRepository;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {
        // cria um repositorio de produtos que armazena os dados em memoria
        InMemoryRepository<Product> productRepo = new InMemoryRepository<>();

        System.out.println("Teste em memoria");
        Product p1 = new Product(1,"Cadeira", 100.0);
        Product p2 = new Product(2, "Mesa", 200.0);
        Product p3 = new Product(3, "Porta", 500.0);

        // salva os produtos em memoria
        productRepo.save(p1);
        productRepo.save(p2);
        productRepo.save(p3);

        // imprime a lista de produtos
        System.out.println("Lista de produtos");
        for(Product p : productRepo.findAll()) {
            System.out.println(p);
        }

        // atualiza o produto 1
        productRepo.update(new Product(1,"Cadeira de plastico", 90.0));
        System.out.println("\nLista de produtos apos update");
        for(Product p : productRepo.findAll()) {
            System.out.println(p);
        }

        // deleta o produto 2
        productRepo.delete(p2);
        System.out.println("\nLista de produtos apos delete");
        for(Product p : productRepo.findAll()) {
            System.out.println(p);
        }

        // busca o produto 3
        System.out.println("\nBusca por id");
        System.out.println(productRepo.findById(3));

        System.out.println("\n=====================");
        System.out.println("Teste em arquivo");

       // cria um repositorio de pessoas que armazena os dados em um arquivo
        InFileRepository<Person> personRepo = new InFileRepository<>("src/data/data.json", new TypeToken<Person>(){}.getType());

        Person person1 = new Person(1, "Joao", 20);
        Person person2 = new Person(2, "Maria", 30);
        Person person3 = new Person(3, "Jose", 40);

        // salva as pessoas no arquivo
        personRepo.save(person1);
        personRepo.save(person2);
        personRepo.save(person3);

        // imprime a lista de pessoas
        System.out.println("Lista de pessoas");
        for(Person p : personRepo.findAll()) {
            System.out.println(p);
        }

        // atualiza a pessoa 1
        personRepo.update(new Person(1, "Carlos", 12));
        System.out.println("\nLista de pessoas apos update");
        for(Person p : personRepo.findAll()) {
            System.out.println(p);
        }

        // deleta a pessoa 2
        personRepo.delete(person2);
        System.out.println("\nLista de pessoas apos delete");
        for(Person p : personRepo.findAll()) {
            System.out.println(p);
        }

        // busca a pessoa 3
        System.out.println("\nBusca por id");
        System.out.println(personRepo.findById(3));

    }


}