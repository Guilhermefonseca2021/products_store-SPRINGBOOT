package br.com.api.repository;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;
import br.com.api.model.Product;
import br.com.api.model.exception.ResourceNotFoundException;

// essa anotacao diz ao spring que este é um repositorio, dando poder de fazer injecao de dependencias e inversao de controles.
@Repository
public class ProductRepository {
    // simulando o banco de dados
    private List<Product> products = new ArrayList<Product>();
    private Integer lastId = 0;
    /**
     * Retorna uma lista e produtos
     * @return lista de produtos
    */
    public List<Product> getAll() {
        return products;
    }
    /**
     * Metodo que retorna o produto encontrado pelo id
     * @param id do produto que ser localizado
     * @return retorna um produto caso tenha encontrado
     */
    // o optional é essencial porque o metodo findFirst sempre tem que retornar algo ou retorna erro, com optional se nao encontrar nada da null.
    public Optional<Product> getProductById(Integer id) {
        // temos varios metodos dentro de uma lista como abaixo.
        return products
            .stream()
            .filter(product -> product.getId() == id)
            .findFirst();
    }
    /**
     * Metodo apra dicionar produto na lista
     * @param product produto a ser adicionado
     * @return retorna o produto a ser adicionado na lista.
     */
    public Product addProduct(Product product) {
        lastId++;
        product.setId(lastId);
        products.add(product);
        return product;
    }
    /**
     * Metodo para deletar o produto por id
     * @param id do produto a ser deletado
     */
    public void delete(Integer id) {
        // removeIf sabe remover de uma lista de acordo com o filtro que vc passar.
        products.removeIf(product -> product.getId() ==  id);
    }
    public Product update(Product product) {
        // Encontrar produto na lista...
        Optional<Product> productFinded = getProductById(product.getId());
        if(productFinded.isEmpty()) {
            // throw new InputMismatchException("Product not found");
            throw new ResourceNotFoundException("Product Not found");
        }
        // Tenho que remover produto antigo.
        delete(product.getId());
        // Adicionar produto novo na lista. (se eu usar o metodo addProduct que criei ele vai incrementar e mudar o id, nao quero isso nunca)
        products.add(product);
        return product;
    }
}
