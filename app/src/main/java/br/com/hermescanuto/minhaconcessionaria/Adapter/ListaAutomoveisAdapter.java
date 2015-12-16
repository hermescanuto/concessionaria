package br.com.hermescanuto.minhaconcessionaria.Adapter;


import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import br.com.hermescanuto.minhaconcessionaria.R;
import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by herme on 12/15/2015.
 */

public class ListaAutomoveisAdapter extends BaseAdapter {

    private final List<String> automoveis;

    private final Context context;

    private final Activity activity;

    private ListaAutomoveisAdapter adapter;


    public ListaAutomoveisAdapter(Context context, List<String> automoveis, Activity activity) {
        this.automoveis = automoveis;
        this.context = context;
        this.activity = activity;
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
        return new Long(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        View view;

        if (convertView != null) {
            view = convertView;
            holder = (ViewHolder) convertView.getTag();
        } else {
           // view = activity.getLayoutInflater().inflate(R.layout.automoveis_lista, parent, false);
            view = LayoutInflater.from(context).inflate(R.layout.automoveis_lista, parent, false);
            holder = new ViewHolder(view);
            view.setTag( holder );
        }

        if (position % 2 == 0) {
          //  view.setBackgroundColor(Color.parseColor("#76bddd"));
        } else {
          //  view.setBackgroundColor(Color.parseColor("#97CBE2"));
        }

        holder = new ViewHolder(view);
        holder.titulo.setText(automoveis.get(position).toString());

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
