package Pollito.cum.edu.pe.upc.service;

import Pollito.cum.edu.pe.upc.entity.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductService {
    Product createProduct(Product product);
    Product updateProduct(Product product, Long id);
    List<Product> findByLowerPrice(double price);
    Product findById(Long id);
    List<Product> findAll();
}
