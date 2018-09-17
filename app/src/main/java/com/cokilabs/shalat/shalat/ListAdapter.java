package com.cokilabs.shalat.shalat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by user on 01/09/2018.
 */

class ListAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<DataGerakanSholat> dataGerakan;

    public ListAdapter(Context c, ArrayList<DataGerakanSholat> dataGerakan) {
        this.mContext = c;
        this.dataGerakan = dataGerakan;
    }

    @Override
    public int getCount() {
        return this.dataGerakan.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        DataGerakanSholat data = this.dataGerakan.get(position);


        if (convertView == null){
            final LayoutInflater layoutInflater = LayoutInflater.from(mContext);
            convertView = layoutInflater.inflate(R.layout.item_title, null);
        }

        final TextView tvJudul = (TextView) convertView.findViewById(R.id.tv_nama);

        tvJudul.setText(data.getTxtNamaGerakan());

        return convertView;
    }
}
