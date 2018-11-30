package com.example.gmltn.health_care;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class Adapter extends ArrayAdapter<String> {

    private String[] time;
    private Context context;
    private List<String> names;
    private LayoutInflater inflate;
    private ViewHolder viewHolder;

    public Adapter(@NonNull Context context, List<String> sportNames, String[] sportTime) {
        super(context, R.layout.item);
        this.names = sportNames;
        this.time = sportTime;
        this.context = context;
        this.inflate = LayoutInflater.from(context);
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
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item, parent, false);

            mViewHolder.mText = convertView.findViewById(R.id.textView1);
            mViewHolder.mTime = convertView.findViewById(R.id.textView2);

            convertView.setTag(mViewHolder);
        } else {
            mViewHolder = (ViewHolder) convertView.getTag();
        }

        mViewHolder.mText.setText(names.get(position));
        mViewHolder.mTime.setText(time[position]);

        return convertView;
    }

    static class ViewHolder {
        TextView mText;
        TextView mTime;
    }
}