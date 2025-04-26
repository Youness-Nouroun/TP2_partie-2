package com.example.tp2_2.Repository;

import com.example.tp2_2.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // Méthode de recherche par nom contenant une sous-chaîne
    List<Product> findByNameContains(String mc);

    // Méthode pour trouver des produits dont le prix est supérieur à une valeur donnée
    List<Product> findByPriceGreaterThan(double price);

    // Requête personnalisée avec JPQL pour rechercher des produits par nom
    @Query("select p from Product p where p.name like :x")
    List<Product> search(@Param("x") String mc);

    // Requête personnalisée avec JPQL pour rechercher des produits dont le prix est supérieur à une valeur donnée
    @Query("select p from Product p where p.price > :x")
    List<Product> searchByPrice(@Param("x") double price);
}
