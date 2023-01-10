package com.example.springbootdemo.configuration;

import com.example.springbootdemo.model.Product;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
 * @author Oksiuta Andrii
 * 10.01.2023
 * 14:27
 */
@Configuration
public class ProductConfiguration {

  @Bean
  public Product productCola() {
    return new Product(4455,"Cola",49.90);
  }
  @Bean
  public Product productFanta() {
    return new Product(3322,"Fanta",49.80);
  }
  @Bean
  public Product productPepsi() {
    return new Product(6699,"Pepsi",49.70);
  }
}
