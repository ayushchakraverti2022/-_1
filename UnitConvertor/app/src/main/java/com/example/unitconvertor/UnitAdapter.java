package com.example.unitconvertor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class UnitAdapter extends ArrayAdapter<ModelClass> {


    public UnitAdapter(@NonNull Context context, ArrayList<ModelClass> courseModelArrayList) {
        super(context, 0, courseModelArrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listitemView = convertView;
        if (listitemView == null) {
            // Layout Inflater inflates each item to be displayed in GridView.
            listitemView = LayoutInflater.from(getContext()).inflate(R.layout.card_items, parent, false);
        }

        ModelClass courseModel = getItem(position);
        TextView courseTV = listitemView.findViewById(R.id.cardunitname);
        ImageView courseIV = listitemView.findViewById(R.id.cardunitimage);

        courseTV.setText(courseModel.getUnit_name());
        courseIV.setImageResource(courseModel.getImgid());
        return listitemView;
    }
}
