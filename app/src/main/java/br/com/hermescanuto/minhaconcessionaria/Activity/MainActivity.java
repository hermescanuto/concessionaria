package br.com.hermescanuto.minhaconcessionaria.Activity;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import br.com.hermescanuto.minhaconcessionaria.Data.Cliente;
import br.com.hermescanuto.minhaconcessionaria.Fragments.CadastroAutomovelFragment;
import br.com.hermescanuto.minhaconcessionaria.Fragments.CadastroClienteFragment;
import br.com.hermescanuto.minhaconcessionaria.R;
import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.toolbar_subtitle)
    TextView subtexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.drawable.ic_menu_ic_vigo);
        setSupportActionBar(toolbar);

        ButterKnife.bind(this, toolbar);

        Cliente cliente = new Cliente();
        String nome = cliente.getCliente().getNome();
        subtexto.setText(nome);

        Log.i("Cliente", " " + cliente.getClienteId());

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement


        switch (id) {
            case R.id.menu_seu_cadastro_cliente:
                MenuCadastroCliente();
                return true;

            case R.id.menu_seu_cadastro_cliente_carro:
                MenuCadastroClienteCarro();
                return true;

            case R.id.menu_lojas:
                deleteAllFragments();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void MenuCadastroCliente() {
        String tag = "Cadastro_cliente";
        Fragment frag = getSupportFragmentManager().findFragmentByTag(tag);
        if (frag == null) {
            deleteAllFragments();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.alvo_view, new CadastroClienteFragment(), tag);
            transaction.addToBackStack(null);
            transaction.commit();
        }

        Log.i("cliente ", "Fragmente " + tag + " Criado");
    }

    private void MenuCadastroClienteCarro() {
        String tag = "Cadastro_cliente_automovel";
        Fragment frag = getSupportFragmentManager().findFragmentByTag(tag);
        if (frag == null) {
            deleteAllFragments();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            transaction.replace(R.id.alvo_view, new CadastroAutomovelFragment(), tag);
            transaction.addToBackStack(null);
            transaction.commit();
        }

        Log.i("cliente ", "Fragmente " + tag + " Criado");

    }

    // Remove todos os fragmentos
    public void deleteAllFragments() {
        try {
            String name = getSupportFragmentManager().getBackStackEntryAt(0).getName();
            getSupportFragmentManager().popBackStack(name, FragmentManager.POP_BACK_STACK_INCLUSIVE);

        } catch (Exception e) {
            Log.i("cliente", "no frags");
        }
    }


    public void setSubtexto(String subtexto) {
        this.subtexto.setText(subtexto);
    }

}
