package br.com.api.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity  // esssa anotacao vinda do hibernate(spring-data JPA) ja faz todo objeto ser uma tabela no DB.
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO) // criando a tipagem do tipo auto para o banco de dados.
    private Integer id;
    private String name;
    private Integer quantity;
    private Double value;
    private String description;
    public Product(Integer id, String name, Integer quantity, Double value, String description) {

    }
    public Product() {}
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
