package io.github.AndreyMarqz.crudAlunos.dto;

import java.time.LocalDate;

public record AlunoRequestDto(String nome, String cpf, LocalDate dtaNascimento, String numeroMatricula, String senha) {
}
