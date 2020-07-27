package demo.md3.fruitshop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import demo.md3.fruitshop.entities.BasketProduct;

@Repository
public interface BasketProductRepository extends JpaRepository<BasketProduct, Long> {

}
