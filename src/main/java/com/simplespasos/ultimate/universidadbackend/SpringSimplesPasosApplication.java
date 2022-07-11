package com.simplespasos.ultimate.universidadbackend;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringSimplesPasosApplication {



    public static void main(String[] args) {
        String[] beanDefinitionNames = SpringApplication.run(SpringSimplesPasosApplication.class, args).getBeanDefinitionNames();
    }


}
