package entities;

public class Product {
    private int id;
    private String name;
    private double value;

    public Product() {
    }

    public Product(int id, String name, double value) {
        this.id = id;
        this.name = name;
        this.value = value;
    }


    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Produto{ " + "nome='" + name + '\'' +
                ", preco=" + value +
                " }";
    }
}
