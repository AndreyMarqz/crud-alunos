package io.github.AndreyMarqz.crudAlunos.repository;

import io.github.AndreyMarqz.crudAlunos.entity.AvaliacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AvaliacaoRepository extends JpaRepository<AvaliacaoEntity, UUID> {
}
