package com.example.alocacaoprofessor.dao;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.alocacaoprofessor.model.Curso;
import com.example.alocacaoprofessor.model.Departamento;
import com.example.alocacaoprofessor.model.Professor;

@Database(entities = {Curso.class, Departamento.class}, version = 2)
public abstract class RoomConfiguration extends RoomDatabase {

    private static RoomConfiguration instance = null;

    public abstract CursoDAO cursoDAO();

    public abstract DepartamentoDAO departamentoDAO();

    public abstract ProfessorDAO professorDAO();

    public static RoomConfiguration getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, RoomConfiguration.class, "Nome da base de dados")
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }


}
