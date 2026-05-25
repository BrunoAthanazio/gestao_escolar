package com.weg.gestao_escolar.service.aula;

import java.sql.SQLException;
import java.util.List;

import org.springframework.stereotype.Service;

import com.weg.gestao_escolar.dto.aula.AulaRequestDto;
import com.weg.gestao_escolar.dto.aula.AulaResponseDto;

@Service
public class AulaServiceImpl implements AulaService{

    private 

    @Override
    public AulaResponseDto save(AulaRequestDto aulaRequest) throws SQLException {
        
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
