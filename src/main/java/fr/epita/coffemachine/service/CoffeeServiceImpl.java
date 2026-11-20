package fr.epita.coffemachine.service;

import fr.epita.coffemachine.dto.CoffeeDto;
import fr.epita.coffemachine.dto.CreateCoffeeDto;
import fr.epita.coffemachine.entity.Coffee;
import fr.epita.coffemachine.mapper.CoffeeMapper;
import fr.epita.coffemachine.repository.CoffeeRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CoffeeServiceImpl implements CoffeeService {

	private final CoffeeRepository repository;
	private final CoffeeMapper mapper;

	// Je précharge quelques cafés au démarrage pour tester
	@PostConstruct
	void initDb() {
		repository.saveAll(List.of(
				new Coffee("Expresso", 54),
				new Coffee("Latte", 52),
				new Coffee("Caffé au lait", 54)
		));
	}

	@Override
	public List<CoffeeDto> allCoffees() {
		return repository.findAll()
				.stream()
				.map(mapper::toDto)
				.toList();
	}

	@Override
	public Optional<CoffeeDto> oneCoffee(@PathVariable Long id) {
		return repository.findById(id).map(mapper::toDto);
	}

	@Override
	public CoffeeDto create(CreateCoffeeDto dto) {
		return mapper.toDto(repository.save(mapper.toEntity(dto)));
	}

}
