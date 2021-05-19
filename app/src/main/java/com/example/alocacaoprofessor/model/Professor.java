package com.example.alocacaoprofessor.model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Professor {

    @PrimaryKey
    private int id;
    private String name;
    private String cpf;


    public Professor(int id, String name, String cpf) {
        this.id = id;
        this.name = name;
        this.cpf = cpf;

    }

       public Professor() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


}
