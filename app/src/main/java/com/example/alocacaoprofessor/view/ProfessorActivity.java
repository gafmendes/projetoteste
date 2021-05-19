package com.example.alocacaoprofessor.view;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.alocacaoprofessor.R;
import com.example.alocacaoprofessor.dao.RoomConfiguration;
import com.example.alocacaoprofessor.model.Departamento;
import com.example.alocacaoprofessor.model.Professor;
import com.example.alocacaoprofessor.repository.RetrofitConfiguration;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProfessorActivity extends AppCompatActivity {
    private List<Professor> listObject = new ArrayList<>();
    private ProfessorAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_departamento);

        listObject.add(new Professor(00021, "Teste-1", "000.000.000-12"));

        ListView professorList = findViewById(R.id.lvProfessorlist);

        adapter = new ProfessorAdapter(this, R.layout.item_list, listObject);
        professorList.setAdapter(adapter);

        RoomConfiguration roomConfiguration = RoomConfiguration.getInstance(this);

        getAllItemsByServer(roomConfiguration);



    }

    private void getAllItemsByServer(RoomConfiguration roomConfiguration) {

        RetrofitConfiguration retrofitConfiguration = new RetrofitConfiguration();
        Call<List<Professor>> service = retrofitConfiguration.getProfessorService().getTodosOsProfessores();

        service.enqueue(new Callback<List<Professor>>() {
            @Override
            public void onResponse(Call<List<Professor>> call, Response<List<Professor>> response) {
                if (response.isSuccessful()) {
                    List<Professor> professores = response.body();
                    listObject.addAll(professores);
                    adapter.notifyDataSetChanged();
                    roomConfiguration.professorDAO().insert(professores);

                    for (Professor professor : listObject) {
                        Log.i(DepartamentoActivity.class.getSimpleName(), professor.getName());
                    }

                } else {
                    String mensagemErro = response.errorBody().toString();
                    Toast.makeText(ProfessorActivity.this, mensagemErro, Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<Professor>> call, Throwable t) {
                Toast.makeText(ProfessorActivity.this, "Requisição para API de Professor falhou", Toast.LENGTH_SHORT).show();
            }
        });

    }

}

