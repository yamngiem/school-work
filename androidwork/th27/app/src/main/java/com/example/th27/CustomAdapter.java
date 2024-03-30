package com.example.th27;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends BaseAdapter {
    private Context context;
    private List<String> data;

    public CustomAdapter(Context context, List<String> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.list_item, null);
        }

        // Assuming your date&name pair is separated by a comma
        String[] parts = data.get(position).split(", ");
        String date = parts[0];
        String name = parts[1];

        TextView dateTextView = view.findViewById(R.id.dateTextView);
        TextView nameTextView = view.findViewById(R.id.nameTextView);

        dateTextView.setText(date);
        nameTextView.setText(name);

        return view;
    }
}
