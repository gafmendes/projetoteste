package com.example.alocacaoprofessor.service;

import com.example.alocacaoprofessor.model.Departamento;
import com.example.alocacaoprofessor.model.Professor;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface ProfessorService {

    @GET("professor")
    Call<List<Professor>> getTodosOsProfessores();
}
