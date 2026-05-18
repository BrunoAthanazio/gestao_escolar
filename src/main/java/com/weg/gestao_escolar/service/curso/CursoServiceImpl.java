package com.weg.gestao_escolar.service.curso;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.weg.gestao_escolar.dto.curso.CursoRequestDto;
import com.weg.gestao_escolar.dto.curso.CursoResponseDto;
import com.weg.gestao_escolar.mapper.CursoMapper;
import com.weg.gestao_escolar.model.Curso;
import com.weg.gestao_escolar.repository.curso.CursoRepository;

@Service
public class CursoServiceImpl implements CursoService{

    private CursoRepository cursoRepository;
    private CursoMapper cursoMapper;

    public CursoServiceImpl(CursoRepository cursoRepository, CursoMapper cursoMapper){
        this.cursoRepository = cursoRepository;
        this.cursoMapper = cursoMapper;
    }

    @Override
    public CursoResponseDto save(CursoRequestDto cursoRequest) throws SQLException {
        Curso curso = cursoMapper.toEntity(cursoRequest);
        cursoRepository.save(curso);
        CursoResponseDto cursoResponse = cursoMapper.toResponse(curso);
        return cursoResponse;
    }

    @Override
    public CursoResponseDto get(Long id) throws SQLException {
        Curso curso = cursoRepository.get(id);
        CursoResponseDto cursoResponse = cursoMapper.toResponse(curso);
        return cursoResponse;
    }

    @Override
    public List<CursoResponseDto> getAll() throws SQLException {
        List<Curso> cursos = cursoRepository.getAll();
        List<CursoResponseDto> cursoResponses = new ArrayList<>();
        for(Curso curso : cursos){
            CursoResponseDto cursoResponse = cursoMapper.toResponse(curso);
            cursoResponses.add(cursoResponse);
        }
        return cursoResponses;
    }

    @Override
    public CursoResponseDto update(Long id, CursoRequestDto cursoRequest) throws SQLException {
        cursoRepository.get(id);
        Curso curso = cursoMapper.toEntity(cursoRequest);
        cursoRepository.update(id, curso);
        return cursoMapper.toResponse(curso);
    }

    @Override
    public void delete(Long id) throws SQLException {
        cursoRepository.delete(id);
    }

}
