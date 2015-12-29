package br.com.hermescanuto.minhaconcessionaria.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.hermescanuto.minhaconcessionaria.R;
import butterknife.Bind;
import butterknife.ButterKnife;

public class ListaAutomoveisAdapter extends BaseAdapter {

    private final List<String> automoveis;

    private final Context context;

    public ListaAutomoveisAdapter(Context context, List<String> automoveis) {
        this.automoveis = automoveis;
        this.context = context;

    }


    @Override
    public int getCount() {
        return automoveis.size();
    }

    @Override
    public Object getItem(int position) {
        return automoveis.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        View view;

        if (convertView != null) {
            view = convertView;
            holder = (ViewHolder) convertView.getTag();
        } else {
            view = LayoutInflater.from(context).inflate(R.layout.automoveis_lista, parent, false);
            holder = new ViewHolder(view);
            view.setTag(holder);
        }

    /*    if (position % 2 == 0) {
            view.setBackgroundColor(Color.parseColor("#76bddd00"));
        } else {
            view.setBackgroundColor(Color.parseColor("#97CBE200"));
        }
*/

        holder.titulo.setText(automoveis.get(position));

        return view;
    }

    class ViewHolder {

        @Bind(R.id.text1)
        TextView titulo;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }


}
