package br.com.hermescanuto.minhaconcessionaria.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.hermescanuto.minhaconcessionaria.Adapter.ListaAutomoveisAdapter;
import br.com.hermescanuto.minhaconcessionaria.R;
import butterknife.Bind;
import butterknife.ButterKnife;


public class CadastroAutomovelFragment extends Fragment {

    @Bind(R.id.cadastro_automovel_modelo)
    Spinner modelo;

    @Bind(R.id.bt_fechar)
    Button botao;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View cadastro = inflater.inflate(R.layout.fragment_cadastro_automovel, container, false);

        ButterKnife.bind(this, cadastro);

        String[] au = getResources().getStringArray(R.array.planets_array);

        List<String> automoveis = new ArrayList<>(Arrays.asList(au));

        ListaAutomoveisAdapter adapter = new ListaAutomoveisAdapter(getContext(), automoveis);

        modelo.setAdapter(adapter);



        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String item = (String) modelo.getSelectedItem();
                Toast.makeText(getContext(), "Selected: " + item, Toast.LENGTH_LONG).show();
            }
        });

        return cadastro;
    }

}
