//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
//Author: Cody King
//Date: 9/23/2023
//Desc: This program lets the user make and pick colors
//XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX
package com.example.cis183_homework02_codyking_code;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button bt_j_saveColor;
    TextView tv_j_red;
    TextView tv_j_green;
    TextView tv_j_blue;
    TextView tv_j_name;
    TextView tv_j_hex;
    SeekBar sb_j_red;
    SeekBar sb_j_green;
    SeekBar sb_j_blue;
    ListView lv_j_colorList;
    String hexVal;
    String redVal;
    String greenVal;
    String blueVal;
    ConstraintLayout cl_j_rgb;
    Integer hexInt;
    Integer redInt;
    Integer greenInt;
    Integer blueInt;
    ArrayList<ColorInfo> listOfColors;
    ColorListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_j_saveColor = findViewById(R.id.bt_v_saveColor);
        tv_j_red = findViewById(R.id.tv_v_red);
        tv_j_green = findViewById(R.id.tv_v_green);
        tv_j_blue = findViewById(R.id.tv_v_blue);
        tv_j_hex = findViewById(R.id.tv_v_hex);
        tv_j_name  = findViewById(R.id.tv_v_name);
        sb_j_red  = findViewById(R.id.sb_v_red);
        sb_j_green = findViewById(R.id.sb_v_green);
        sb_j_blue = findViewById(R.id.sb_v_blue);
        lv_j_colorList = findViewById(R.id.lv_v_colorList);
        cl_j_rgb = findViewById(R.id.cl_v_rgb);
        //ArrayList<ColorInfo> listOfColors;
        hexVal = "FFFFFF";
        redVal = "FF";
        greenVal = "FF";
        blueVal = "FF";
        redInt = 255;
        greenInt = 255;
        blueInt = 255;
        listOfColors = new ArrayList<ColorInfo>();

        saveColorButtonEventHandler();
        redSeekBarEventHandler();
        greenSeekBarEventHandler();
        blueSeekBarEventHandler();
        fillListView();
    }


    public void saveColorButtonEventHandler()
    {
        bt_j_saveColor.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                ColorInfo newColor = new ColorInfo();
                newColor.setColorRed(redInt);
                newColor.setColorGreen(greenInt);
                newColor.setColorBlue(blueInt);
                newColor.setColorHex(hexVal);
                listOfColors.add(newColor);
                fillListView();
                adapter.notifyDataSetChanged();
                reset();
            }
        });
    }
    public void redSeekBarEventHandler()
    {
        sb_j_red.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                tv_j_red.setText("Red: " + String.valueOf(sb_j_red.getProgress()));
                redVal = Integer.toHexString(sb_j_red.getProgress());
                redInt = sb_j_red.getProgress();
                //Log.d("d", redVal);
                if (redVal.length() == 1)
                {
                    redVal = "0" + redVal;
                }
                hexVal = redVal + greenVal + blueVal;
                //tv_j_name.setText(redVal);
                //Log.d("d",hexVal);
                tv_j_hex.setText("Hex Representation: " + hexVal.toUpperCase());
                hexVal = "#" + redVal + greenVal + blueVal;
                hexInt = Color.parseColor(hexVal);
                cl_j_rgb.setBackgroundColor(hexInt);
                changeTextColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });
    }
    public void greenSeekBarEventHandler()
    {
        sb_j_green.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                tv_j_green.setText("Green: " + String.valueOf(sb_j_green.getProgress()));
                greenVal = Integer.toHexString(sb_j_green.getProgress());
                greenInt = sb_j_green.getProgress();
                if (greenVal.length() == 1)
                {
                    greenVal = "0" + greenVal;
                }
                hexVal = redVal + greenVal + blueVal;
                tv_j_hex.setText("Hex Representation: " + hexVal.toUpperCase());
                hexVal = "#" + redVal + greenVal + blueVal;
                hexInt = Color.parseColor(hexVal);
                cl_j_rgb.setBackgroundColor(hexInt);
                changeTextColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });
    }
    public void blueSeekBarEventHandler()
    {
        sb_j_blue.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
        {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b)
            {
                tv_j_blue.setText("Blue: " + String.valueOf(sb_j_blue.getProgress()));
                blueVal = Integer.toHexString(sb_j_blue.getProgress());
                blueInt = sb_j_blue.getProgress();
                if (blueVal.length() == 1)
                {
                    blueVal = "0" + blueVal;
                }
                hexVal = redVal + greenVal + blueVal;
                tv_j_hex.setText("Hex Representation: " + hexVal.toUpperCase());
                hexVal = "#" + redVal + greenVal + blueVal;
                hexInt = Color.parseColor(hexVal);
                cl_j_rgb.setBackgroundColor(hexInt);
                changeTextColor();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar)
            {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar)
            {

            }
        });
    }
    public void changeTextColor()
    {
        if (redInt < 100 & greenInt < 100 & blueInt < 100)
        {
            tv_j_name.setTextColor(Color.parseColor("#FFFFFF"));
            tv_j_red.setTextColor(Color.parseColor("#FFFFFF"));
            tv_j_green.setTextColor(Color.parseColor("#FFFFFF"));
            tv_j_blue.setTextColor(Color.parseColor("#FFFFFF"));
            tv_j_hex.setTextColor(Color.parseColor("#FFFFFF"));
        }
        else
        {
            tv_j_name.setTextColor(Color.parseColor("#000000"));
            tv_j_red.setTextColor(Color.parseColor("#000000"));
            tv_j_green.setTextColor(Color.parseColor("#000000"));
            tv_j_blue.setTextColor(Color.parseColor("#000000"));
            tv_j_hex.setTextColor(Color.parseColor("#000000"));
        }
    }
    public void fillListView()
    {
        adapter = new ColorListAdapter(this, listOfColors);
        lv_j_colorList.setAdapter(adapter);
    }
    public void reset()
    {
        sb_j_red.setProgress(255);
        sb_j_green.setProgress(255);
        sb_j_blue.setProgress(255);
        tv_j_red.setText("Red: 255");
        tv_j_green.setText("Green: 255");
        tv_j_blue.setText("Blue: 255");
        tv_j_hex.setText("Hex Representation: FFFFFF");
        tv_j_name.setTextColor(Color.parseColor("#000000"));
        tv_j_red.setTextColor(Color.parseColor("#000000"));
        tv_j_green.setTextColor(Color.parseColor("#000000"));
        tv_j_blue.setTextColor(Color.parseColor("#000000"));
        tv_j_hex.setTextColor(Color.parseColor("#000000"));
    }
}