package br.com.api.repository;

import org.springframework.stereotype.Repository;
import br.com.api.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

// com bancos repositorios sao criados como interface que estende de uma JpaRepository com modelo e tipo id.
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    
}
