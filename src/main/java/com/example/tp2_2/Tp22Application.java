package com.example.tp2_2;

import com.example.tp2_2.entities.Product;
import com.example.tp2_2.Repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@SpringBootApplication
public class Tp22Application implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;

	public static void main(String[] args) {
		SpringApplication.run(Tp22Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Add sample products to the database
	//	productRepository.save(new Product(null, "Computer", 4300, 3));
	//	productRepository.save(new Product(null, "Printer", 1200, 4));
	//	productRepository.save(new Product(null, "Smart Phone", 3200, 32));

		// Fetch all products and print them
		productRepository.findAll().forEach(product -> System.out.println(product));

		// Fetch a product by its ID (example with ID 1)
		productRepository.findById(1L).ifPresent(product -> {
			System.out.println(" ************ ");
			System.out.println("ID: " + product.getId());
			System.out.println("Name: " + product.getName());
			System.out.println("Quantity: " + product.getQuantity());
		});
		System.out.println("****************************** " );
		// Fetch products with names containing the letter "C"
		List<Product> productList = productRepository.findByNameContains("C");
		productList.forEach(p -> {
			System.out.println(p);
		});
		System.out.println("*************** avec search repos *************** " );
		List<Product> productList2 = productRepository.search("C");
		productList.forEach(p -> {
			System.out.println(p);
		});
	}
}
