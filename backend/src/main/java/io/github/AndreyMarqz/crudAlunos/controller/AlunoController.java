package io.github.AndreyMarqz.crudAlunos.controller;

import io.github.AndreyMarqz.crudAlunos.dto.AlunoRequestDto;
import io.github.AndreyMarqz.crudAlunos.dto.AlunoResponseDto;
import io.github.AndreyMarqz.crudAlunos.service.AlunoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity<AlunoResponseDto> cadastrar(@RequestBody AlunoRequestDto alunoRequestDto) {

        AlunoResponseDto alunoSalvo = alunoService.cadastrarAluno(alunoRequestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(alunoSalvo);
    }

    @GetMapping("/buscar/{id}")
    public ResponseEntity<AlunoResponseDto> buscarPorId(@PathVariable UUID id) {

        AlunoResponseDto alunoEncontrado = alunoService.buscarAlunoPorId(id);
        return ResponseEntity.ok(alunoEncontrado);
    }

    @GetMapping("/listar")
    public ResponseEntity<List<AlunoResponseDto>> listarTodos() {
        List<AlunoResponseDto> listaAlunos = alunoService.listarAlunos();
        return ResponseEntity.ok(listaAlunos);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<AlunoResponseDto> atualizar(@PathVariable UUID id, @RequestBody AlunoRequestDto alunoRequestDto) {

        AlunoResponseDto alunoAtualizado = alunoService.atualizarAluno(id, alunoRequestDto);
        return ResponseEntity.ok(alunoAtualizado);
    }

    @DeleteMapping("/deletar/{id}")
    public ResponseEntity<AlunoResponseDto> deletar(@PathVariable UUID id) {

        AlunoResponseDto alunoDeletado = alunoService.deletarAluno(id);
        return ResponseEntity.ok(alunoDeletado);
    }
}
