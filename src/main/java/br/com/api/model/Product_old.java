package br.com.api.model;

public class Product_old {
    // tudo aqui sao metodos conectando a lista (Endereco locais) nada conectado a banco de dados.
    private Integer id;
    private String name;
    private Integer quantity;
    private Double value;
    private String description;
    public Product_old(Integer id, String name, Integer quantity, Double value, String description) {

    }
    public Product_old() {}
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
    public Double getValue() {
        return value;
    }
    public void setValue(Double value) {
        this.value = value;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
}
