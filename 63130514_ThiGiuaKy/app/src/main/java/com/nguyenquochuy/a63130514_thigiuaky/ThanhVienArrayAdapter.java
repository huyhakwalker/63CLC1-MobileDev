package com.nguyenquochuy.a63130514_thigiuaky;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ThanhVienArrayAdapter extends BaseAdapter {
    List<ThanhVien> dataSource;
    private LayoutInflater inflater;
    private Context context;

    public ThanhVienArrayAdapter(List<ThanhVien> dataSource, Context context) {
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
        ImageView img;
        TextView ten;
        TextView quequan;
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
            itemViewHoder.img = view.findViewById(R.id.imageTV);
            itemViewHoder.ten = view.findViewById(R.id.textViewten);
            itemViewHoder.quequan = view.findViewById(R.id.textViewquequan);
            view.setTag(itemViewHoder);
        }
        else {
            itemViewHoder = (CountryItemViewHoder) view.getTag();
        }
        ThanhVien thanhVien = this.dataSource.get(i);
        itemViewHoder.ten.setText(thanhVien.getTenTV());
        itemViewHoder.quequan.setText("Que quan: " + thanhVien.getQuequan());
        int imageld = this.getMipmapResldByName(thanhVien.getAnh());
        itemViewHoder.img.setImageResource(imageld);
        return view;
    }
}
