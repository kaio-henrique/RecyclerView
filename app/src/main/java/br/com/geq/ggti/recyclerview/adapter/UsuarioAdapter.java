package br.com.geq.ggti.recyclerview.adapter;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import br.com.geq.ggti.recyclerview.R;
import br.com.geq.ggti.recyclerview.adapter.holder.UsuarioHolder;
import br.com.geq.ggti.recyclerview.model.Usuario;
import br.com.geq.ggti.recyclerview.service.OnItemClickListenerHack;

/**
 * Created by 750371415 on 20/09/2017.
 */

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioHolder> {

    private List<Usuario> listUsuario;

    public UsuarioAdapter(List<Usuario> listUsuario){
        this.listUsuario = listUsuario;
    }

    @Override
    public UsuarioHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_recycler_view, parent, false);
        UsuarioHolder usrHolder = new UsuarioHolder(view);

        return usrHolder;
    }

    @Override
    public void onBindViewHolder(UsuarioHolder holder, int position) {

        holder.matric.setText(listUsuario.get(position).getMatricula());
        holder.nome.setText(listUsuario.get(position).getNome().toUpperCase());
        holder.chamado.setText(listUsuario.get(position).getN_chamado());

        holder.itemClickedListener(new OnItemClickListenerHack() {
            @Override
            public void onItemClicked(View v, int position) {
                Snackbar.make(v, "Selecionou " +
                                  holder.nome.getText().toString().toUpperCase(),
                                  Snackbar.LENGTH_LONG)
                                          .show();
            }

            @Override
            public boolean onItemLongClicked(View v, int position) {
                Snackbar.make(v, "Long Touch in position " + position + " / " + holder.nome.getText().toString().toUpperCase(),
                        Snackbar.LENGTH_LONG)
                        .show();
                return false;
            }
        });
    }

    @Override
    public int getItemCount() {
        if(listUsuario == null){
            return 0;
        }else{
            return listUsuario.size();
        }
    }

    public void clear(){
        listUsuario.get(0);
        notifyDataSetChanged();
    }

    public void addAll(List<Usuario> list){
        listUsuario.addAll(list);
        notifyItemInserted(getItemCount());
        notifyDataSetChanged();
    }
}
