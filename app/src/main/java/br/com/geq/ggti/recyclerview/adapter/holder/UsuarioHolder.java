package br.com.geq.ggti.recyclerview.adapter.holder;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import br.com.geq.ggti.recyclerview.R;
import br.com.geq.ggti.recyclerview.service.OnItemClickListenerHack;

/**
 * Created by 750371415 on 20/09/2017.
 */

public class UsuarioHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

    public TextView matric, nome, chamado;
    private OnItemClickListenerHack onClickHack;

    public UsuarioHolder(View view) {
        super(view);


        matric = (TextView) view.findViewById(R.id.tvMatric);
        nome = (TextView) view.findViewById(R.id.tvNome);
        chamado = (TextView) view.findViewById(R.id.tvChamado);

        view.setOnClickListener(this);
        view.setOnLongClickListener(this);
    }

    public void itemClickedListener(OnItemClickListenerHack onClickHack){
        this.onClickHack = onClickHack;
    }

    @Override
    public void onClick(View v) {
        onClickHack.onItemClicked(v, getAdapterPosition());
    }

    @Override
    public boolean onLongClick(View v) {
        onClickHack.onItemLongClicked(v, getAdapterPosition());
        return true;
    }
}
