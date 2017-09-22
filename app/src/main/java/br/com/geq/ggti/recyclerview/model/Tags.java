package br.com.geq.ggti.recyclerview.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by 750371415 on 22/09/2017.
 */

public class Tags {

    private String resp;
    private String qtd_dias;
    private String tipo;
    private String status;

    public String getResp() {
        return resp;
    }

    public void setResp(String resp) {
        this.resp = resp;
    }

    public String getQtd_dias() {
        return qtd_dias;
    }

    public void setQtd_dias(String qtd_dias) {
        this.qtd_dias = qtd_dias;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
