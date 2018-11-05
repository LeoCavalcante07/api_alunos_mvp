package br.com.senaijandira.alunos.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import br.com.senaijandira.alunos.R;
import br.com.senaijandira.alunos.model.Aluno;
import br.com.senaijandira.alunos.presenter.VisualizarPresenter;
import br.com.senaijandira.alunos.service.AlunoService;
import br.com.senaijandira.alunos.service.ServiceFactory;
import br.com.senaijandira.alunos.view.VisualizarView;

public class VisualizarActivity extends AppCompatActivity implements VisualizarView{

    VisualizarPresenter presenter;
    AlunoService service;

    EditText edNome;
    EditText edDtNasc;
    EditText edCpf;
    EditText edMatricula;
    Button btnEditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visualizar);

        service = ServiceFactory.create();

        presenter = new VisualizarPresenter(this, service);

        edNome = findViewById(R.id.edNome);
        edDtNasc = findViewById(R.id.edDtNasc);
        edCpf = findViewById(R.id.edCpf);
        edMatricula = findViewById(R.id.edMatricula);
        btnEditar = findViewById(R.id.btnEdit);

        //pega o id do aluno que ta em outra classe
        int idAluno = getIntent().getIntExtra("idAluno", 0);

        //Log.d("ID_ALUNO", idAluno+"");

        //service.obterAlunoPorId(idAluno);

        presenter.carregarDadosAluno(idAluno);



    }

    @Override
    public void preencherDados(Aluno aluno) {



        edNome.setText(((aluno.getNome())));
        edMatricula.setText((String.valueOf(aluno.getMatricula())));
        edCpf.setText((String.valueOf(aluno.getDataNascimento())));
        //edDtNasc.setText((aluno.getDataNascimento()));

    }

    public void habilitarEdicao(View view) {
        edNome.setEnabled(true);
        edMatricula.setEnabled(true);
        edCpf.setEnabled(true);
        btnEditar.setEnabled(true);

    }
}
