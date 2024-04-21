package br.com.api.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.api.model.Product;
import br.com.api.repository.ProductRepository_old;

// notacao que indica uma classe de servico, aqui injetamos a dependencia para o spring que devolve um controle, atraves da inversao de controle.(aqui deixo o spring tomar conta)
@Service
public class ProductService {
    // aqui eu digo para o spring que estou invertendo o controller(aqui eu tomo conta) tenho todos metodos do ProductRepository.
    @Autowired
    private ProductRepository_old productRepository;
    /**
     * Metodo que retorna todos produtos da lista
     * @return lista de produtos
     */
    public List<Product> getAll() {
        // colocar regras aqui, caso tenha.
        return productRepository.getAll();
    };
    /**
     * Metodo que retorna o produto encontrado pelo seu id
     * @param id do produto que sera localizado.
     * @return retorna um produto caso seja encontrado.
     */
    public Optional<Product> getProductById(Integer id) {
        return productRepository.getProductById(id);
    }
    /**
     * Metodo para adicionar um produto na lista
     * @param produto que sera adicionado.
     * @return retorna o produto que foi adicionado na lista.
     */
    public Product addProduct(Product product) {
        // poderia ter alguma regra de negocio aqui para validar o produto.
        return productRepository.addProduct(product);
    }
    /**
     * Metodo para deletar o produto por id
     * @param id do produto a ser deletado
     */
    public void delete(Integer id) {
        // poderia ter alguma regra de negocio como verificar se o usuario tem permissao de deletar.
        productRepository.delete(id);
    }
    /**
     * Metodo para atualizar o produto na lista.
     * @param produto que sera atualizado.
     * @param id do produto
     * @return retorna o produto apos atualizar a lista.
    */
    public Product update(Integer id, Product product) {
        // ter alguma validacao no id.
        product.setId(id);
        return productRepository.update(product);
    }
};
