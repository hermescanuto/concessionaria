package br.com.hermescanuto.minhaconcessionaria.Activity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import br.com.hermescanuto.minhaconcessionaria.Data.Automovel;
import br.com.hermescanuto.minhaconcessionaria.Data.Cliente;
import br.com.hermescanuto.minhaconcessionaria.Fragments.CadastroFragment;
import br.com.hermescanuto.minhaconcessionaria.R;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    private Cliente cliente;
    private List<Automovel> listaDeAutomoveis;
    private TextView subtexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setLogo(R.drawable.ic_menu_ic_vigo);

        setSupportActionBar(toolbar);

        subtexto = (TextView) toolbar.findViewById(R.id.toolbar_subtitle);


        cliente = new Cliente();
        String nome = cliente.getCliente().getNome();
        subtexto.setText( nome );

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
        if (id == R.id.menu_seu_cadastro) {

            String tag = "cadastro_cliente";
            Fragment frag = getSupportFragmentManager().findFragmentByTag(tag);
            if (frag == null) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.alvo_view, new CadastroFragment(), tag);
                transaction.addToBackStack(null);
                transaction.commit();

            }

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void setSubtexto(String subtexto) {
        this.subtexto.setText(subtexto);
    }
}
