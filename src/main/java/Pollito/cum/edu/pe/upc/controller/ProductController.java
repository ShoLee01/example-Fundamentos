package Pollito.cum.edu.pe.upc.controller;

import Pollito.cum.edu.pe.upc.entity.Product;
import Pollito.cum.edu.pe.upc.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Controller
@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping(value = "/getAllProducts")
    public List<Product> getAllProducts(){
        List<Product> products = productService.findAll();
        if (products == null) {
            return null;
        }
        return products;
    }

    @GetMapping(value = "/getProductById/{id}")
    public Product getProductById(@PathVariable("id") Long id){
        Product product = productService.findById(id);
        if (product == null) {
            return null;
        }
        return product;
    }

    @GetMapping(value = "/getByLowerPrice/{price}")
    public List<Product> getByLowerPrice(@PathVariable("price") double price){
        List<Product> products = productService.findByLowerPrice(price);
        if (products == null) {
            return null;
        }
        return products;
    }

    @PutMapping(value = "/updateProduct/{id}")
    public Product updateProduct(@RequestBody Product product, @PathVariable("id") Long id){
        Product product1 = productService.updateProduct(product, id);
        if (product1 == null) {
            return null;
        }
        return product1;
    }

    @PostMapping(value = "/createProduct")
    public Product createProduct(@RequestBody Product product){
        Product product1 = productService.createProduct(product);
        if (product1 == null) {
            return null;
        }
        return product1;
    }

}
