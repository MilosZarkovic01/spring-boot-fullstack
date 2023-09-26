package com.somika;

import com.github.javafaker.Faker;
import com.github.javafaker.Name;
import com.somika.customer.Customer;
import com.somika.customer.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

//Configuration, EnableAutoConfiguration, ComponentScan
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        ConfigurableApplicationContext ctx = SpringApplication.run(Main.class, args);

        //printBeans(ctx);
    }

    @Bean
    CommandLineRunner runner(CustomerRepository customerRepository) {
        return args -> {
            var faker = new Faker();
            Random random = new Random();
            Name name = faker.name();
            String firstName = name.firstName();
            String lastName = name.lastName();
            Customer customer = new Customer(
                    firstName + " " + lastName,
                    firstName.toLowerCase() + "." + lastName.toLowerCase() + "@example.com",
                    random.nextInt(16, 99)
            );

            customerRepository.save(customer);
        };
    }

    @Bean("foo")
    public Foo getFoo() {
        return new Foo("bar");
    }

    record Foo(String name) {
    }

    private static void printBeans(ConfigurableApplicationContext ctx) {
        String[] beanDefinitionNames =
                ctx.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }
    }



    /*@GetMapping(path = "/greet")
    public GreetResponse greet(
            @RequestParam(value = "name", required = false) String name) {
        String greetMessage = name == null || name.isBlank() ? "Hello" : "Hello" + name;
        GreetResponse response = new GreetResponse(greetMessage,
                List.of("Java", "Golang", "Javascript"),
                new Person("Alex", 28, 30_000)
        );
        return response;
    }

    record Person(String name, int age, double savings) {
    }

    record GreetResponse(
            String greet,
            List<String> favProgrammingLanguages,
            Person person
    ) {
    }


//    class GreetResponse {
//        private final String greet;
//
//        public GreetResponse(String greet) {
//            this.greet = greet;
//        }
//
//        public String getGreet() {
//            return greet;
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            GreetResponse that = (GreetResponse) o;
//            return Objects.equals(greet, that.greet);
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(greet);
//        }
//
//        @Override
//        public String toString() {
//            return "GreetResponse{" +
//                    "greet='" + greet + '\'' +
//                    '}';
//        }
//    }*/
}
