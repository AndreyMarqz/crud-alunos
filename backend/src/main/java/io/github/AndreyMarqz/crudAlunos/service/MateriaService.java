package io.github.AndreyMarqz.crudAlunos.service;

import io.github.AndreyMarqz.crudAlunos.repository.MateriaRepository;
import org.springframework.stereotype.Service;

@Service
public class MateriaService {

    private MateriaRepository materiaRepository;

    public MateriaService(MateriaRepository materiaRepository) {
        this.materiaRepository = materiaRepository;
    }
}
