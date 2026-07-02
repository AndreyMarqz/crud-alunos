package io.github.AndreyMarqz.crudAlunos.dto;

import java.util.UUID;

public record AvaliacaoResponseDto(UUID id, Double nota, String nomeAluno, String nomeMateria) {
}
