package com.example.springbootdemo.model;

import com.example.springbootdemo.model.Product;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/*
 * @author Oksiuta Andrii
 * 06.01.2023
 * 16:10
 */
@Repository
public class ProductRepository {

  private final Map<Integer, Product> repository;

  @Autowired
  public ProductRepository(List<Product> list) {
    this.repository = list.stream().collect(Collectors.toMap(Product::getId, a -> a));
  }

  public Product getById(int id) {
    if (repository.containsKey(id)) {
      return repository.get(id);
    }
    System.out.println("There is no Product with such Id!!!");
    return null;
  }

  public List<Product> getAllProducts() {
    return repository.values().stream().toList();
  }
}
