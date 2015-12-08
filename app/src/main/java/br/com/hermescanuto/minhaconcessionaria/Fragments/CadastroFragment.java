package br.com.hermescanuto.minhaconcessionaria.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.com.hermescanuto.minhaconcessionaria.Activity.MainActivity;
import br.com.hermescanuto.minhaconcessionaria.Data.Cliente;
import br.com.hermescanuto.minhaconcessionaria.R;
import butterknife.Bind;
import butterknife.ButterKnife;

public class CadastroFragment extends Fragment {

    @Bind(R.id.user_cadastro_nome)
    TextView nome;
    @Bind(R.id.user_cadastro_email)
    TextView email;
    @Bind(R.id.user_cadastro_ddd)
    TextView ddd;
    @Bind(R.id.user_cadastro_fone)
    TextView telefone;
    @Bind(R.id.user_cadastro_cpf)
    TextView cpf;


    //  private EditText nome;
    //   private EditText email;
    //  private EditText ddd;
    //  private EditText telefone;
    //   private EditText cpf;

    private long id;

    private View cadastro;

    public final static boolean isValidEmail(CharSequence target) {
        return !TextUtils.isEmpty(target) && android.util.Patterns.EMAIL_ADDRESS.matcher(target).matches();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        cadastro = inflater.inflate(R.layout.fragment_cadastro, container, false);
        //getCadastro();

        ButterKnife.bind(this, cadastro);

        long numeroDeClientes = Cliente.count(Cliente.class, null, null);

        if (numeroDeClientes == 0) {
            id = 0;
        } else {
            setCadastro();
        }

        Button bt_salvar = (Button) cadastro.findViewById(R.id.bt_fechar);
        bt_salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (temErro() == false) {

                    salvaCadastro();

                    MainActivity mf = (MainActivity) getActivity();
                    mf.setSubtexto(nome.getText().toString());

                    FragmentManager fm = getFragmentManager();
                    fm.popBackStack();
                }
            }
        });

        Log.i("Car", "Fragmento");
        return cadastro;
    }

    public void setCadastro() {

        List<Cliente> clientes = Cliente.listAll(Cliente.class);

        nome.setText(clientes.get(0).getNome());
        email.setText(clientes.get(0).getEmail());
        cpf.setText(clientes.get(0).getCpf());
        ddd.setText(clientes.get(0).getDdd());
        telefone.setText(clientes.get(0).getTelefone());
        id = clientes.get(0).getId();

    }

    public void salvaCadastro() {

        Cliente cliente = (id == 0) ? new Cliente() : Cliente.findById(Cliente.class, id);

        String msg = (id == 0) ? getResources().getString(R.string.salvando) : getResources().getString(R.string.atualizando);

        cliente.setNome(nome.getText().toString());
        cliente.setEmail(email.getText().toString());
        cliente.setDdd(ddd.getText().toString());
        cliente.setTelefone(telefone.getText().toString());
        cliente.setCpf(cpf.getText().toString());
        cliente.save();

        Toast.makeText(getContext(), msg, Toast.LENGTH_LONG).show();

    }

    public boolean temErro() {

        if (nome.getText().toString().isEmpty()) {
            nome.setError(getResources().getString(R.string.error_name));
            return true;
        }

        if (!isValidEmail(email.getText().toString())) {
            email.setError(getResources().getString(R.string.error_email));
            return true;
        }

        if (cpf.getText().toString().isEmpty()) {
            cpf.setError(getResources().getString(R.string.error_cpf));
            return true;
        }

        if (ddd.getText().toString().isEmpty()) {
            ddd.setError(getResources().getString(R.string.error_ddd));
            return true;
        }

        if (telefone.getText().toString().isEmpty()) {
            telefone.setError(getResources().getString(R.string.error_phone));
            return true;
        }

        return false;
    }
}
