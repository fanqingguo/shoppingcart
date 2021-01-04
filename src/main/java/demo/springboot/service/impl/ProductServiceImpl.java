package demo.springboot.service.impl;

import demo.springboot.domain.Product;
import demo.springboot.domain.ProductRepository;
import demo.springboot.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Product 业务层实现
 *
 * Created by bysocket on 30/09/2017.
 */
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductRepository productRepository;

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product insertByProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product delete(Long id) {
        Product product = productRepository.findById(id).get();
        productRepository.delete(product);
        return product;
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).get();
    }
    @Override
    public List<Product> findByProducts(Product product) {
        List<Product> all = productRepository.findAll(Example.of(product));
        return all;
    }
}
