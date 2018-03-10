package com.coding.jjlop.forestappv2;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.TextView;

import com.hold1.pagertabsindicator.TabView;

public class TabViewItem extends TabView {

    private TextView tab_Name;
    private ImageView tab_Icon;
    private int active_Clr;
    private int tab_Clr;

    public TabViewItem(Context context, String title, int image_Id, int tab_Clr, int act_Clr) {
        super(context);
        LayoutInflater.from(context).inflate(R.layout.custom_item,this);
        tab_Name= findViewById(R.id.tab_name);
        tab_Icon=findViewById(R.id.tab_icon);
        tab_Name.setText(title);
        tab_Icon.setImageResource(image_Id);
        this.tab_Clr=tab_Clr;
        this.active_Clr=act_Clr;
        this.tab_Icon.setColorFilter(tab_Clr);
        this.tab_Name.setTextColor(tab_Clr);

    }
    @Override
    public void onOffset(float offset) {
        this.tab_Icon.setColorFilter(getColorWithOpacity(active_Clr,(int)(100*offset)));
        this.tab_Name.setTextColor(mixTwoColors(active_Clr,tab_Clr,offset));
    }

    private int mixTwoColors(int color1, int color2, float offset) {
        byte ALPHA_CHANEL=24;
        byte RED_CHANEL=16;
        byte GREEN_CHANEL=8;
        byte BLUE_CHANEL=0;
        float inverseamount=1.0f-offset;
        int a=((int)(((float)(color1>>ALPHA_CHANEL&0Xff)*offset)+
                ((float)(color2>>ALPHA_CHANEL&0xff)*inverseamount)))&0xff;
        int r=((int)(((float)(color1>>RED_CHANEL&0Xff)*offset)+
                ((float)(color2>>RED_CHANEL&0xff)*inverseamount)))&0xff;
        int g=((int)(((float)(color1>>GREEN_CHANEL&0Xff)*offset)+
                ((float)(color2>>GREEN_CHANEL&0xff)*inverseamount)))&0xff;
        int b=((int)(((float)(color1&0Xff)*offset)+
                ((float)(color2&0xff)*inverseamount)))&0xff;
        return a <<ALPHA_CHANEL | r <<RED_CHANEL | g <<GREEN_CHANEL | b <<BLUE_CHANEL;

    }

    private int getColorWithOpacity(int active_clr, int i) {
        return Color.argb(i*255/100, Color.red(active_clr),Color.green(active_clr),Color.blue(active_clr));
    }
}
