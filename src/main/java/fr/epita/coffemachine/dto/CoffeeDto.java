package fr.epita.coffemachine.dto;

// DTO renvoyé au client (lecture)
public record CoffeeDto(Long id, String name, int price) {
}
