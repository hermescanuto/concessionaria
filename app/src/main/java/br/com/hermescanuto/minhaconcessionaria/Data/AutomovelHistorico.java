package br.com.hermescanuto.minhaconcessionaria.Data;

import com.orm.SugarRecord;

/**
 * Created by herme on 01/12/2015.
 */
public class AutomovelHistorico extends SugarRecord<AutomovelHistorico> {

    private String automovel_id;
    private String data;
    private String descricao;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
