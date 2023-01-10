package com.example.springbootdemo.services;

import com.example.springbootdemo.model.Cart;
import com.example.springbootdemo.model.Product;
import com.example.springbootdemo.model.ProductRepository;
import java.util.Scanner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/*
 * @author Oksiuta Andrii
 * 09.01.2023
 * 12:30
 */

@Service

public class CartService {

  private final ProductRepository productRepository;
  private Cart cart;

  @Autowired
  public CartService(ProductRepository productRepository, Cart cart) {
    this.productRepository = productRepository;
    this.cart = cart;
  }

  public void runConsoleApp() {
    System.out.println("App started");
    System.out.println("The contents of the repository:");

    for (Product product : productRepository.getAllProducts()) {
      System.out.println("ID: " + product.getId() + "\tName: " + product.getName() + "\tPrice: "
          + product.getPrice());
    }
    System.out.println("You may start work with repository and cartList...");

    cartSwitcher();
  }

  private void cartSwitcher() {
    while (true) {
      String command = scanner("""
          Enter command of action:
          0 - create new Cart
          1 - remove Product from Cart
          2 - add Product to Cart
          9 - finish work with Cart
          -->\s""");
      switch (Integer.parseInt(command)) {
        case 0 -> {
          cart = Cart.getNewCart();
          cart.info();
        }
        case 1 -> {
          cartRemove(cart);
          cart.info();
        }
        case 2 -> {
          cartAdd(cart);
          cart.info();
        }
        case 9 -> {
          cart.info();
          return;
        }
        default -> System.out.println("wrong command!!!");
      }
    }
  }

  private void cartAdd(Cart cart) {
    if (cart != null) {
      String addId = scanner("Enter Id of product you want to Add to Cart: ");
      cart.addProductToCartById(Integer.parseInt(addId), productRepository);
    }
  }

  private void cartRemove(Cart cart) {
    if (cart != null) {
      cart.info();
      String removeId = scanner("Enter Id of product you want to Remove from Cart: ");
      if (cart.getCartList().stream()
          .map(Product::getId)
          .toList()
          .contains(Integer.parseInt(removeId))) {
        cart.removeProductFromCartById(Integer.parseInt(removeId));
      } else {
        System.out.println("There is no Product with such Id!!!");
      }
    }
  }

  private String scanner(String line) {
    System.out.println(line);
    Scanner string = new Scanner(System.in);
    return string.next();
  }
}
