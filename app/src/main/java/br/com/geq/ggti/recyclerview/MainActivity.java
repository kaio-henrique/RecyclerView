package br.com.geq.ggti.recyclerview;

import android.app.ProgressDialog;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import br.com.geq.ggti.recyclerview.adapter.UsuarioAdapter;
import br.com.geq.ggti.recyclerview.api.ApiClient;
import br.com.geq.ggti.recyclerview.model.Usuario;
import br.com.geq.ggti.recyclerview.service.ApiService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private  String TAG = MainActivity.class.getSimpleName();

    private RecyclerView recyclerView;
    private List<Usuario> listUsuarios;
    private UsuarioAdapter adapter;
    ProgressDialog progressDialog;
    private LinearLayoutManager layoutManager;
    private SwipeRefreshLayout swipeContainer, swipeContainerEmpty;
    private TextView tvTextEmpty;
    private Typeface fontFamily;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initViews();

    }

    private void initViews() {

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage("Please Wait...");
        progressDialog.setCancelable(false);
        progressDialog.show();

        new Thread(){
            @Override
            public void run(){
                try{
                    sleep(1500);
                    getUsuarioList();
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        }.start();
    }

    private void getUsuarioList() {
        try {

            ApiService service = ApiClient.getRetrofit().create(ApiService.class);

            Call<List<Usuario>> call = service.getDadosUsuarios();
            call.enqueue(new Callback<List<Usuario>>() {

                @Override
                public void onResponse(Call<List<Usuario>> call, Response<List<Usuario>> response) {

                    listUsuarios = response.body();

                    setContentView(R.layout.activity_main);

                    layoutManager = new LinearLayoutManager(MainActivity.this);
                    recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
                    recyclerView.setLayoutManager(layoutManager);
                    adapter = new UsuarioAdapter(listUsuarios);
                    recyclerView.setAdapter(adapter);

                    swipeContainer = (SwipeRefreshLayout) findViewById(R.id.swipeContainer);
                    swipeContainer.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                        @Override
                        public void onRefresh() {
                            fetchTimelineAsync(0);
                        }
                    });

                    Snackbar.make(recyclerView, response.message() + " - Dados Carregados", Snackbar.LENGTH_LONG)
                            .setAction("Action", null)
                            .show();
                    progressDialog.dismiss();

                }

                @Override
                public void onFailure(Call<List<Usuario>> call, Throwable t) {
                    Log.d(TAG, "Erro ao processar dado!");
                    setContentView(R.layout.activity_vazia);
                    tvTextEmpty = (TextView) findViewById(R.id.tvTextEmpty);
                    fontFamily = Typeface.createFromAsset(getAssets(), "fonts/fontawesome-webfont.ttf");
                    tvTextEmpty.setTypeface(fontFamily);
                    swipeContainerEmpty = (SwipeRefreshLayout) findViewById(R.id.swipeContainerEmpty);
                    swipeContainerEmpty.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
                        @Override
                        public void onRefresh() {
                            fetchTimelineAsync(0);
                        }
                    });
                    Snackbar.make(findViewById(R.id.swipeContainerEmpty), "Nenhum Registro Encontrado!", Snackbar.LENGTH_LONG)
                            .setAction("Action", null)
                            .show();
                    progressDialog.dismiss();
                }
            });

        } catch (Exception e){
            e.printStackTrace();
            Log.d(TAG, e.getMessage());
            Snackbar.make(recyclerView, e.getMessage(), Snackbar.LENGTH_LONG)
                    .setAction("Action", null)
                    .show();
            progressDialog.dismiss();
        }
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        initViews();
    }

    public void fetchTimelineAsync(int page){

        if(listUsuarios == null || listUsuarios.size() == 0){
            swipeContainerEmpty.setRefreshing(false);
            initViews();
        }else{
            adapter.clear();
            //adapter.addAll(listUsuarios);
            swipeContainer.setRefreshing(false);
            initViews();
        }
    }
}
