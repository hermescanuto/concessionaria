package br.com.hermescanuto.minhaconcessionaria.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.com.hermescanuto.minhaconcessionaria.Adapter.ListaAutomoveisAdapter;
import br.com.hermescanuto.minhaconcessionaria.R;
import butterknife.Bind;
import butterknife.ButterKnife;


public class CadastroAutomovelFragment extends Fragment {

    @Bind(R.id.cadastro_automovel_modelo)
    Spinner placa;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View cadastro = inflater.inflate(R.layout.fragment_cadastro_automovel, container, false);

        ButterKnife.bind(this, cadastro);

        String[] au = getResources().getStringArray(R.array.planets_array);

        List<String> automoveis = new ArrayList<String>(Arrays.asList(au));

        int layout = android.R.layout.simple_spinner_item;

        //   ArrayAdapter<String> adapter = new ArrayAdapter<String>(getContext(), layout, automoveis );

        //  adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // ListaAutomoveisAdapter adapter  = new ListaAutomoveisAdapter( getContext(), automoveis );

        ListaAutomoveisAdapter adapter = new ListaAutomoveisAdapter(getContext(), automoveis, getActivity());


        placa.setAdapter(adapter);

        return cadastro;
    }

}
