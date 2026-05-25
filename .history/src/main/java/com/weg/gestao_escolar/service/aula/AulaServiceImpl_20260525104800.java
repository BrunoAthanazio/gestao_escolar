package com.weg.gestao_escolar.service.aula;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.weg.gestao_escolar.dto.aula.AulaRequestDto;
import com.weg.gestao_escolar.dto.aula.AulaResponseDto;
import com.weg.gestao_escolar.mapper.AulaMapper;
import com.weg.gestao_escolar.repository.aula.AulaRepository;

@Service
public class AulaServiceImpl implements AulaService{

    private AulaMapper aulaMapper;
    private AulaRepository aulaRepository;

    public AulaServiceImpl(AulaMapper aulaMapper, AulaRepository aulaRepository){
        this.aulaMapper = aulaMapper;
        this.aulaRepository = aulaRepository;
    }

    @Override
    public AulaResponseDto save(AulaRequestDto aulaRequest) throws SQLException {
        Aula aula = aulaMapper.
    }

    @Override
    public AulaResponseDto get(Long id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'get'");
    }

    @Override
    public List<AulaResponseDto> getAll() throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAll'");
    }

    @Override
    public AulaResponseDto update(Long id, AulaRequestDto aulaRequest) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'update'");
    }

    @Override
    public void delete(Long id) throws SQLException {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
