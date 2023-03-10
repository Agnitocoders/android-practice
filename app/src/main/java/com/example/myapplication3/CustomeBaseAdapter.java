package com.example.myapplication3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomeBaseAdapter extends BaseAdapter {
    Context constext;
    String listFruit[];
    int listImages[];
    LayoutInflater inflater;

    public  CustomeBaseAdapter(Context ctx, String [] fruitList, int [] images){
        this.constext  = ctx;
        this.listFruit = fruitList;
        this.listImages = images;
        inflater = LayoutInflater.from(ctx);

    }

    @Override
    public int getCount() {
        return listFruit.length;
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
        convertView  = inflater.inflate(R.layout.activity_custome_list_view, null);
        TextView txtView =(TextView) convertView.findViewById(R.id.textView);
        ImageView fruitImg = (ImageView) convertView.findViewById(R.id.imgIcon);
        txtView.setText(listFruit[position]);
        fruitImg.setImageResource(listImages[position]);
        return  convertView;
    }
}
