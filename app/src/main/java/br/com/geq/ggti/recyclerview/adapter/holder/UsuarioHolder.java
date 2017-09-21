package br.com.geq.ggti.recyclerview.adapter.holder;

import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

import br.com.geq.ggti.recyclerview.R;
import br.com.geq.ggti.recyclerview.service.OnClickListenerHack;

/**
 * Created by 750371415 on 20/09/2017.
 */

public class UsuarioHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView matric, nome, chamado;

    public UsuarioHolder(View view) {
        super(view);

        view.setOnClickListener(this);

        matric = (TextView) view.findViewById(R.id.tvMatric);
        nome = (TextView) view.findViewById(R.id.tvNome);
        chamado = (TextView) view.findViewById(R.id.tvChamado);

    }

    @Override
    public void onClick(View v) {
        Snackbar.make(v, "Selecionou " + nome.getText(),  Snackbar.LENGTH_LONG).show();
    }
}
