package ru.geekbrains.spring1.lesson4.repositories;

import org.springframework.stereotype.Repository;
import ru.geekbrains.spring1.lesson4.data.Product;

import java.util.List;


public interface ProductDao {

    List<Product> findAll();
    Product getProductById(Long id);
    void deleteById(Long id);

    void save(Product p);
}
