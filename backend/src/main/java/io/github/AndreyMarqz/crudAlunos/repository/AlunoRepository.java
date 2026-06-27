package io.github.AndreyMarqz.crudAlunos.repository;

import io.github.AndreyMarqz.crudAlunos.entity.AlunoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AlunoRepository extends JpaRepository<AlunoEntity, UUID> {
}
