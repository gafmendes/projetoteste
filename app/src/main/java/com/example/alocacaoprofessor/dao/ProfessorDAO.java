package com.example.alocacaoprofessor.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;

import com.example.alocacaoprofessor.model.Professor;

import java.util.List;

@Dao
public interface ProfessorDAO {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    public void insert(List<Professor> professor);
}
