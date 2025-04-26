package com.example.tp2_2.web;

import com.example.tp2_2.Repository.ProductRepository;
import com.example.tp2_2.entities.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")  // Ajout d'une base pour les URL
public class ProductRestService {

    @Autowired
    private ProductRepository productRepository;

    // Endpoint pour récupérer tous les produits
    @GetMapping
    public List<Product> products() {
        return productRepository.findAll();
    }

    // Endpoint pour récupérer un produit par son ID
    @GetMapping("/{id}")  // Correction de la syntaxe de l'URL
    public Product findProduct(@PathVariable Long id) {
        // Vérification si le produit existe
        return productRepository.findById(id).orElse(null);  // Retourne null si le produit n'est pas trouvé
    }
}
