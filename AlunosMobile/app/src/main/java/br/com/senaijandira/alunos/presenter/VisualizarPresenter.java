package br.com.senaijandira.alunos.presenter;

import android.util.Log;

import br.com.senaijandira.alunos.model.Aluno;
import br.com.senaijandira.alunos.service.AlunoService;
import br.com.senaijandira.alunos.view.VisualizarView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by 17259211 on 05/11/2018.
 */

public class VisualizarPresenter {

    AlunoService service;
    VisualizarView view;

    public VisualizarPresenter(VisualizarView view, AlunoService service){
        this.view = view;
        this.service = service;
    }

    public void carregarDadosAluno(int id){
        Log.d("ID_ALUNO", id+"");
        Call<Aluno> call = service.obterAlunoPorId(id);

        call.enqueue(new Callback<Aluno>() {
            @Override
            public void onResponse(Call<Aluno> call, Response<Aluno> response) {
                Aluno aluno = response.body();
                view.preencherDados(aluno);
                Log.d("Resultado", aluno.getNome());
            }

            @Override
            public void onFailure(Call<Aluno> call, Throwable t) {
                Log.e("Erro ao carregar aluno", t.getMessage());
            }
        });
    }

}
