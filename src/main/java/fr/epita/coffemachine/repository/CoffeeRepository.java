package fr.epita.coffemachine.repository;

import fr.epita.coffemachine.entity.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;

// Accès aux données pour Coffee (Spring Data JPA)
public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
}
