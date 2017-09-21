package br.com.geq.ggti.recyclerview.service;

import android.view.View;
import android.widget.AdapterView;

/**
 * Created by 750371415 on 20/09/2017.
 */

public interface OnItemClickListenerHack {

    void onItemClicked(View v, int position);

    boolean onItemLongClicked(View v, int position);

}
