package io.github.AndreyMarqz.crudAlunos.dto;

import java.time.LocalDate;
import java.util.UUID;

public record AlunoResponseDto(UUID id, String nome, LocalDate dtaNascimento, String numeroMatricula) {
}
