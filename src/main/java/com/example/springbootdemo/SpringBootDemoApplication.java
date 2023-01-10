package com.example.springbootdemo;

import com.example.springbootdemo.services.CartService;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@AllArgsConstructor

public class SpringBootDemoApplication {

  private CartService cartService;

  public static void main(String[] args) {
    SpringApplication.run(SpringBootDemoApplication.class, args);
  }

  @EventListener(ApplicationReadyEvent.class)
  public void run(){
    cartService.runConsoleApp();
  }
}
