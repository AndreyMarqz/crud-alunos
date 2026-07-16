package io.github.AndreyMarqz.crudAlunos.service;

import io.github.AndreyMarqz.crudAlunos.dto.MateriaRequestDto;
import io.github.AndreyMarqz.crudAlunos.dto.MateriaResponseDto;
import io.github.AndreyMarqz.crudAlunos.entity.MateriaEntity;
import io.github.AndreyMarqz.crudAlunos.repository.MateriaRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class MateriaService {

    private final MateriaRepository materiaRepository;

    public MateriaService(MateriaRepository materiaRepository) {
        this.materiaRepository = materiaRepository;
    }

    @Transactional
    public MateriaResponseDto cadastrarMateria(MateriaRequestDto materiaRequestDto) {

        MateriaEntity materia = new MateriaEntity();
        materia.setNome(materiaRequestDto.nome());

        MateriaEntity materiaSalva = materiaRepository.save(materia);

        return new MateriaResponseDto(materiaSalva.getId(), materiaSalva.getNome());
    }

    public MateriaResponseDto ConsultarMateriaPorId(UUID id) {

        MateriaEntity materia = materiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Matéria não encontrada com ID: " + id));

        return new MateriaResponseDto(materia.getId(), materia.getNome());
    }

    @Transactional
    public MateriaResponseDto atualizarMateria(UUID id, MateriaRequestDto materiaRequestDto) {

        MateriaEntity materia = materiaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Matéria não encontrada com o ID: " + id));

        materia.setNome(materiaRequestDto.nome());

        return new MateriaResponseDto(materia.getId(), materia.getNome());
    }

    public List<MateriaResponseDto> listarMaterias() {

        return materiaRepository.findAll()
                .stream()
                .map(materia -> new MateriaResponseDto(materia.getId(), materia.getNome()))
                .collect(Collectors.toList());
    }

    @Transactional
    public MateriaResponseDto deletarMateria(UUID id) {

        if (!materiaRepository.existsById(id)) {
            throw new RuntimeException("Matéria não encontrada para exclusão.");
        }
        materiaRepository.deleteById(id);
        return null;
    }
}
