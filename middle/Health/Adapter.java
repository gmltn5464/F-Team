package com.example.leegyounghoon.myapplication;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;


public class Adapter extends ArrayAdapter <String> {

    private List<String > names;
    private String[] names1;
    private int[] icons;
    private Context context;

    public Adapter(@NonNull Context context, List<String > sportNames, String[] calorie ,int[] sportIcons) {
        super(context, R.layout.health_list);
        this.names = sportNames;
        this.names1 = calorie;
        this.icons = sportIcons;
        this.context = context;
    }

    @Override
    public int getCount() {
        return names.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        ViewHolder mViewHolder = new ViewHolder();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.health_list,parent,false);

            mViewHolder.mText = (TextView)convertView.findViewById(R.id.textView);
            mViewHolder.mText1 = (TextView)convertView.findViewById(R.id.textView1);
            mViewHolder.mImage = (ImageView)convertView.findViewById(R.id.imageView);

            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder)convertView.getTag();
        }

        mViewHolder.mText.setText(names.get(position));
        mViewHolder.mText1 .setText(names1[position]);
        mViewHolder.mImage.setImageResource(icons[position]);

        return convertView;
    }

    static class ViewHolder {
        TextView mText;
        TextView mText1;
        ImageView mImage;
    }

}