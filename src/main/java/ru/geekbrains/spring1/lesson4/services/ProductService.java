package ru.geekbrains.spring1.lesson4.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.geekbrains.spring1.lesson4.data.Product;
import ru.geekbrains.spring1.lesson4.repositories.ProductDao;
import ru.geekbrains.spring1.lesson4.repositories.ProductDaoImpl;


import java.util.List;

@Service
public class ProductService {



    private ProductDao productRepository;

    @Autowired
    public void setProductRepository(ProductDaoImpl productDao) {
        this.productRepository = productDao;
    }

    public Product getProductById(Long id){
        return productRepository.getProductById(id);
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    }

    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    public void changePrice(Long id, Integer delta) {
        Product p = productRepository.getProductById(id);
        p.setPrice(p.getPrice() + delta);
        productRepository.save(p);

    }
}
