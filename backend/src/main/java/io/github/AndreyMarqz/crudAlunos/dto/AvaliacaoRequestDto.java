package io.github.AndreyMarqz.crudAlunos.dto;

import io.github.AndreyMarqz.crudAlunos.entity.AlunoEntity;
import io.github.AndreyMarqz.crudAlunos.entity.MateriaEntity;

import java.util.UUID;

public record AvaliacaoRequestDto(Double nota, UUID alunoId, UUID materiaId) {
}
