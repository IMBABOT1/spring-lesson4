package ru.geekbrains.spring1.lesson4.repositories;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import ru.geekbrains.spring1.lesson4.data.Product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Repository
public class ProductRepository {

    private List<Product> products;


    @PostConstruct
    public void init() {
        products = new ArrayList<>(Arrays.asList(
                new Product(1l, "Bread", 10),
                new Product(2l, "Milk", 10),
                new Product(3l, "Apples", 10),
                new Product(4l, "Cheese", 10),
                new Product(5l, "Oranges", 10)
        ));
    }

    public Product getProductById(Long id) {
        for (Product p : products) {
            if (p.getId() == id) {
                return p;
            }
        }
        throw new RuntimeException("Product with " + id + " not found");
    }

    public List<Product> findAll() {
        return Collections.unmodifiableList(products);
    }

    public void deleteById(Long id) {
        for (int i = 0; i < products.size() ; i++) {
            if (products.get(i).getId() == id){
                products.remove(i);
            }
        }
    }
}
