package fr.epita.coffemachine.dto;

import jakarta.validation.constraints.Positive;

// DTO pour la mise à jour partielle (PATCH)
// Les champs null sont ignorés côté mapper
public record UpdateCoffeeDto(
		String name,
		@Positive(message = "Price should be positive") Integer price
) {
}
