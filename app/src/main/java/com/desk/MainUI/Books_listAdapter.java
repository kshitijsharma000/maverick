package com.desk.mainUI;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.desk.R;

import java.util.ArrayList;

/**
 * Created by kshitij.sharma on 9/30/2015.
 */
public class Books_listAdapter extends BaseAdapter {

    Context context;
    LayoutInflater layoutInflater;
    ArrayList<Categories_list> categories_lists;


    public Books_listAdapter(Context context, ArrayList<Categories_list> categories_lists) {
        this.context = context;
        this.categories_lists = categories_lists;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return categories_lists.size();
    }

    @Override
    public Object getItem(int position) {
        return categories_lists.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.category_books_layout, parent, false);
            holder = new ViewHolder();
            holder.textView = (TextView) convertView.findViewById(R.id.books_category_title);
            holder.recyclerView = (RecyclerView) convertView.findViewById(R.id.books_category_list);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.textView.setText("Category " + position);
        return convertView;
    }

    private class ViewHolder {
        TextView textView;
        RecyclerView recyclerView;
    }
}
