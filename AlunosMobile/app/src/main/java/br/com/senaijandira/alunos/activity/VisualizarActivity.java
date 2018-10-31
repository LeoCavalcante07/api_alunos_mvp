package br.com.senaijandira.alunos.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import br.com.senaijandira.alunos.R;

public class VisualizarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar);

        //pega o id do aluno que ta em outra classe
        int idAluno = getIntent().getIntExtra("idAluno", 0);

        Log.d("ID_ALUNO", idAluno+"");
    }
}
