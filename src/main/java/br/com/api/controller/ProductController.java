package br.com.api.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.model.Product;
import br.com.api.services.ProductService;

@RestController
@RequestMapping("/api/products") // escute essa url.
public class ProductController {
    @Autowired // como o servico abaixo tinha passado o controle para o servico mas agora quero usar no controller, uso autowired.
    private ProductService productService;
    /**
     * Metodo para fazer uma consulta no lado do usuario.
     * @return retorna produtos para o cliente.
    */
    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}") // path variable ler a variavel que esta na url e tenta tranforma em um id do tipo que passamos.
    public Optional<Product> getProductById(@PathVariable Integer id) {
        return productService.getProductById(id);
    }

    // preciso fazer um bind na requisicao porque ele nao sabe que oq vier é um produto, entao preciso transformar em um.
    @PostMapping // por isso o request body. digo ao spring para oq ele receber tentar converter em um produto.
    public Product addProduct(@RequestBody Product product) {
        // o metodo do servico vai devolver um produto.
        return productService.addProduct(product);
    }
    
    @DeleteMapping("/{id}") // path variable ler a variavel que esta na url e tenta tranforma em um id do tipo que passamos.
    public String delete(@PathVariable Integer id) {
        productService.delete(id);
        return "product with id " + id + " was deleted with succesfuly!";
    }

    @PutMapping("/{id}") // put sempre vai devolver um produto.
    public Product update(@RequestBody Product product, @PathVariable Integer id) {
        // quem tem que pegar o id NAO é o controller e sim a camada de service.
        return productService.update(id, product);
    }
}
