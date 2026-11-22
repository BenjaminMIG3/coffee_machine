package fr.epita.coffemachine.mapper;

import fr.epita.coffemachine.dto.CoffeeDto;
import fr.epita.coffemachine.dto.CreateCoffeeDto;
import fr.epita.coffemachine.dto.UpdateCoffeeDto;
import fr.epita.coffemachine.entity.Coffee;
import org.mapstruct.*;

// Conversion Entity <-> DTO via MapStruct
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.ERROR)
public interface CoffeeMapper {

	CoffeeDto toDto(Coffee coffee);

	// L'id est généré en base, on l'ignore à la création
	@Mapping(target = "id", ignore = true)
	Coffee toEntity(CreateCoffeeDto dto);

	// Update partiel : on ne touche pas aux champs null
	@BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
	@Mapping(target = "id", ignore = true)
	void updateEntity(@MappingTarget Coffee entity, UpdateCoffeeDto dto);

}
