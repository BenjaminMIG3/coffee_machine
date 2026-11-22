package fr.epita.coffemachine.service;

import fr.epita.coffemachine.dto.CoffeeDto;
import fr.epita.coffemachine.dto.CreateCoffeeDto;
import fr.epita.coffemachine.dto.UpdateCoffeeDto;

import java.util.List;
import java.util.Optional;

// Contrat du service métier café
public interface CoffeeService {

	List<CoffeeDto> allCoffees();

	Optional<CoffeeDto> oneCoffee(Long id);

	CoffeeDto create(CreateCoffeeDto dto);

	Optional<CoffeeDto> update(UpdateCoffeeDto dto, Long id);

}
