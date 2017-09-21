package br.com.geq.ggti.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.geq.ggti.recyclerview.R;
import br.com.geq.ggti.recyclerview.adapter.holder.UsuarioHolder;
import br.com.geq.ggti.recyclerview.model.Usuario;
import br.com.geq.ggti.recyclerview.service.OnClickListenerHack;

/**
 * Created by 750371415 on 20/09/2017.
 */

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioHolder> {

    private List<Usuario> listUsuario;
    private OnClickListenerHack listenerHack;

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
        holder.nome.setText(listUsuario.get(position).getNome());
        holder.chamado.setText(listUsuario.get(position).getN_chamado());
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
        listUsuario.clear();
        notifyDataSetChanged();
    }

    public void addAll(List<Usuario> list){
        listUsuario.addAll(list);
        notifyItemInserted(getItemCount());
        notifyDataSetChanged();
    }
}
