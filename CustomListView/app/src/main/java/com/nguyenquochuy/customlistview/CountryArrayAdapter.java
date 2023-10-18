package com.nguyenquochuy.customlistview;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Locale;

public class CountryArrayAdapter extends BaseAdapter {
    List<Country> dataSource;
    private LayoutInflater inflater;
    private Context context;

    public CountryArrayAdapter(List<Country> dataSource, Context context) {
        this.dataSource = dataSource;
        this.inflater = inflater.from(context);
        this.context = context;
    }
    public int getMipmapResldByName(String resName){
        String pkgName = context.getPackageName();
        int resID = context.getResources().getIdentifier(resName,"mipmap",pkgName);
        Log.i("CustomListView","Res Name: " + resName + "==> ResID = " + resID);
        return resID;
    }
    static class CountryItemViewHoder{
        ImageView flagView;
        TextView countryNameView;
        TextView populationView;
    }
    @Override
    public int getCount() {
        return dataSource.size();
    }

    @Override
    public Object getItem(int i) {
        return dataSource.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        CountryItemViewHoder itemViewHoder;
        if (view == null){
            view = inflater.inflate(R.layout.country_item_layout, null);
            itemViewHoder = new CountryItemViewHoder();
            itemViewHoder.flagView = view.findViewById(R.id.imageViewFlagName);
            itemViewHoder.countryNameView = view.findViewById(R.id.textViewCountryName);
            itemViewHoder.populationView = view.findViewById(R.id.textViewPopulation);
            view.setTag(itemViewHoder);
        }
        else {
            itemViewHoder = (CountryItemViewHoder) view.getTag();
        }
        Country country = this.dataSource.get(i);
        itemViewHoder.countryNameView.setText(country.getCountryName());
        itemViewHoder.populationView.setText("Population: " + country.getPopulation());
        int imageld = this.getMipmapResldByName(country.getFlagName());
        itemViewHoder.flagView.setImageResource(imageld);
        return view;
    }
}
