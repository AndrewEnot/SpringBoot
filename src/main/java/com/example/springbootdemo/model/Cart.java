package com.example.springbootdemo.model;

import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/*
 * @author Oksiuta Andrii
 * 06.01.2023
 * 17:46
 */
@Component
@Scope("prototype")
@NoArgsConstructor
@Getter
public class Cart {

  private final List<Product> cartList = new ArrayList<>();

  public void addProductToCartById(int id, ProductRepository repository) {
    cartList.add(repository.getById(id));
  }

  public void removeProductFromCartById(int id) {
    cartList.remove(cartList.get(id));
  }

  public void info() {
    System.out.println("Cart content:");
    for (Product product : cartList) {
      System.out.println(product.getId() + " " + product.getName() + " " + product.getPrice());
    }
  }
  public static Cart getNewCart () {
    return new Cart();
  }
}
