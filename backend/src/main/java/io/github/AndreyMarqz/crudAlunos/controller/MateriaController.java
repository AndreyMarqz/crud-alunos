package io.github.AndreyMarqz.crudAlunos.controller;

import io.github.AndreyMarqz.crudAlunos.dto.MateriaRequestDto;
import io.github.AndreyMarqz.crudAlunos.dto.MateriaResponseDto;
import io.github.AndreyMarqz.crudAlunos.service.MateriaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/materia")
public class MateriaController {

    private final MateriaService materiaService;

    public MateriaController(MateriaService materiaService) {
        this.materiaService = materiaService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<MateriaResponseDto> cadastrar(@RequestBody MateriaRequestDto materiaRequestDto) {

        MateriaResponseDto materiaSalva = materiaService.cadastrarMateria(materiaRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(materiaSalva);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<MateriaResponseDto> buscarPorId(@PathVariable UUID id) {

        MateriaResponseDto materiaEncontrada = materiaService.ConsultarMateriaPorId(id);
        return ResponseEntity.ok(materiaEncontrada);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<MateriaResponseDto>> listarTodos() {

        List<MateriaResponseDto> listarMaterias = materiaService.listarMaterias();
        return ResponseEntity.ok(listarMaterias);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<MateriaResponseDto> atualizar(@PathVariable UUID id, @RequestBody MateriaRequestDto materiaRequestDto) {

        MateriaResponseDto materiaAtualizada = materiaService.atualizarMateria(id, materiaRequestDto);
        return ResponseEntity.ok(materiaAtualizada);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<MateriaResponseDto> deletar(@PathVariable UUID id) {

        MateriaResponseDto materiaDeletada = materiaService.deletarMateria(id);
        return ResponseEntity.ok(materiaDeletada);
    }
}
