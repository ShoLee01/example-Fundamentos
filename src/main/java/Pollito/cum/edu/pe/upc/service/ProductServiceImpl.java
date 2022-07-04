package Pollito.cum.edu.pe.upc.service;

import Pollito.cum.edu.pe.upc.entity.Product;
import Pollito.cum.edu.pe.upc.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        Product product1 = new Product();
        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        product1.setStock(product.getStock());

        productRepository.save(product1);
        return product1;
    }

    @Override
    public Product updateProduct(Product product, Long id) {
        Product product1 = productRepository.findById(id).orElse(null);
        if (product1 == null) {
            return null;
        }
        product1.setName(product.getName());
        product1.setPrice(product.getPrice());
        product1.setStock(product.getStock());
        productRepository.save(product1);
        return product1;
    }

    @Override
    public List<Product> findByLowerPrice(double price) {
        return productRepository.findByLowerPrice(price);
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
