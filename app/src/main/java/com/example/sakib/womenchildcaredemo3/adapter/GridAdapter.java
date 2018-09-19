package com.example.sakib.womenchildcaredemo3.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.sakib.womenchildcaredemo3.R;
import com.example.sakib.womenchildcaredemo3.model.ItemType;

import java.util.ArrayList;

/**
 * Created by sakib on 06-Apr-18.
 */

public class GridAdapter extends BaseAdapter
{

    ArrayList<ItemType> arrayList = new ArrayList<>();
    Context context;

    public GridAdapter(ArrayList<ItemType> arrayList, Context context) {
        this.arrayList = arrayList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View customView = inflater.inflate(R.layout.item_layout, null);

        ImageView imageView = customView.findViewById(R.id.imageView);
        TextView textView = customView.findViewById(R.id.textView);

        imageView.setImageResource(arrayList.get(position).getImageSrc());
        //textView.setText(arrayList.get(position).getTitle());

        return customView;


    }
}
