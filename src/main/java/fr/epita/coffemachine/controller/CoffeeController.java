package fr.epita.coffemachine.controller;

import fr.epita.coffemachine.dto.CoffeeDto;
import fr.epita.coffemachine.dto.CreateCoffeeDto;
import fr.epita.coffemachine.dto.UpdateCoffeeDto;
import fr.epita.coffemachine.service.CoffeeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Endpoints REST pour gérer les cafés.
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("coffees")
public class CoffeeController {

	private final CoffeeService coffeeService;

	// Création d'un nouveau café
	@PostMapping
	public CoffeeDto create(@RequestBody @Valid CreateCoffeeDto dto) {
		return coffeeService.create(dto);
	}

	// Liste de tous les cafés
	@GetMapping
	List<CoffeeDto> coffees() {
		return coffeeService.allCoffees();
	}

	// Récupération d'un café par son id
	@GetMapping("{id}")
	ResponseEntity<CoffeeDto> coffee(@PathVariable Long id) {
		return coffeeService.oneCoffee(id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}

	// Mise à jour partielle (PATCH)
	@PatchMapping("{id}")
	ResponseEntity<CoffeeDto> update(@PathVariable Long id, @RequestBody @Valid UpdateCoffeeDto dto) {
		return coffeeService.update(dto, id)
				.map(ResponseEntity::ok)
				.orElse(ResponseEntity.notFound().build());
	}
}
