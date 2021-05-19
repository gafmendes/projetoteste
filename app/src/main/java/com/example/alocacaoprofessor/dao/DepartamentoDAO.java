package com.example.alocacaoprofessor.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import com.example.alocacaoprofessor.model.Departamento;

import java.util.List;

@Dao
public interface DepartamentoDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void insert(List<Departamento> departamento);

}
