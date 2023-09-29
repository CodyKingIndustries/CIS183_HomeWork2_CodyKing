package com.example.cis183_homework02_codyking_code;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class ColorListAdapter extends BaseAdapter
{
    Context context;
    ArrayList<ColorInfo> listOfColors;
    public ColorListAdapter(Context c, ArrayList<ColorInfo> cl)
    {
        //From MainActivity
        context = c;
        listOfColors = cl;
    }
    @Override
    public int getCount()
    {
        return listOfColors.size();
    }

    @Override
    public Object getItem(int i)
    {
        return listOfColors.get(i);
    }

    @Override
    public long getItemId(int i)
    {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        if(view == null)
        {
            LayoutInflater mInflator = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view = mInflator.inflate(R.layout.color_cell, null);
        }
        TextView redCell = view.findViewById(R.id.tv_v_colorcell_red);
        TextView greenCell = view.findViewById(R.id.tv_v_colorcell_green);
        TextView blueCell = view.findViewById(R.id.tv_v_colorcell_blue);
        TextView hexCell = view.findViewById(R.id.tv_v_colorcell_hex);
        ColorInfo colorSaved = listOfColors.get(i);
        redCell.setText("Red: " + colorSaved.getColorRed());
        greenCell.setText("Green: " + colorSaved.getColorGreen());
        blueCell.setText("Blue: " + colorSaved.getColorBlue());
        hexCell.setText("Hex: " + colorSaved.getColorHex().toUpperCase());
        view.setBackgroundColor(Color.parseColor(colorSaved.getColorHex()));
        if (colorSaved.getColorRed() < 100 & colorSaved.getColorGreen() < 100 & colorSaved.getColorBlue() < 100)
        {
            redCell.setTextColor(Color.parseColor("#FFFFFF"));
            greenCell.setTextColor(Color.parseColor("#FFFFFF"));
            blueCell.setTextColor(Color.parseColor("#FFFFFF"));
            hexCell.setTextColor(Color.parseColor("#FFFFFF"));
        }
        else
        {
            redCell.setTextColor(Color.parseColor("#000000"));
            greenCell.setTextColor(Color.parseColor("#000000"));
            blueCell.setTextColor(Color.parseColor("#000000"));
            hexCell.setTextColor(Color.parseColor("#000000"));
        }
        return view;
    }
}

