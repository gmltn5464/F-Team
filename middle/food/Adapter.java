package com.example.user.health_care_app;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import org.w3c.dom.Text;

import java.util.List;

public class Adapter extends ArrayAdapter<String> {
    private int[] kcal;
    private Context context;
    private List<String> food;
    private LayoutInflater inflate;
    private ViewHolder viewHolder;

    public Adapter(@NonNull Context context, List<String> food) {
        super(context, R.layout.listview_item);
        this.context = context;
        this.food = food;
        this.inflate = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return food.size();
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder mViewHolder = new ViewHolder();

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.listview_item, parent, false);

            mViewHolder.mText = convertView.findViewById(R.id.list_text);

            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }

        mViewHolder.mText.setText(food.get(position));

        return convertView;
    }

    static class ViewHolder {
        TextView mText;
        TextView mTime;
    }
}