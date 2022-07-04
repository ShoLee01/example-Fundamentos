package Pollito.cum.edu.pe.upc.repository;

import Pollito.cum.edu.pe.upc.entity.Product;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
@Qualifier("productRepository")
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT p FROM Product p where p.price < ?1")
    List<Product> findByLowerPrice(double price);
}
