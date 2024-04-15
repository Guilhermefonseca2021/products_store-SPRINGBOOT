package br.com.api.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;
import br.com.api.model.Product;

// essa anotacao diz ao spring que este é um repositorio, dando poder de fazer injecao de depencias e inversao de controles.
@Repository
public class ProductRepository {
    private ArrayList<Product> products = new ArrayList<Product>();
    private Integer lastId = 0;
    public List<Product> getAll() {
        return products;
    }
}
