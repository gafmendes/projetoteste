package com.example.alocacaoprofessor.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.alocacaoprofessor.R;
import com.example.alocacaoprofessor.model.Professor;

import java.util.List;

public class ProfessorAdapter extends ArrayAdapter {
    private Context context;
    private int resource;
    private List<Professor> objects;

    public ProfessorAdapter(@NonNull Context context, int resource, @NonNull List objects) {
        super(context, resource, objects);

        this.context = context;
        this.resource = resource;
        this.objects = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;
        if (view == null) {
            view = LayoutInflater.from(context).inflate(resource, parent, false);
        }

        Professor professor = objects.get(position);

        ImageView imageView = view.findViewById(R.id.ivImagem);

        TextView tvProfessorAlocado = view.findViewById(R.id.tvProfessor);

        imageView.setImageResource(R.drawable.conta_privada);
        tvProfessorAlocado.setText(professor.getName());


        return view;


    }
}
