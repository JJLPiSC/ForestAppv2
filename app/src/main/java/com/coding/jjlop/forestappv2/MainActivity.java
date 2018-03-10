package com.coding.jjlop.forestappv2;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.TextView;

import com.coding.jjlop.forestappv2.Adapter.CustomViewPagerAdapter;
import com.coding.jjlop.forestappv2.Model.Model;
import com.hold1.pagertabsindicator.PagerTabsIndicator;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<Model> models = new ArrayList<>();
    ViewPager viewPager;
    PagerTabsIndicator TabsIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       initModel();
       viewPager= findViewById(R.id.view_pager);
       TabsIndicator=findViewById(R.id.tabs_indicator);
       viewPager.setAdapter( new CustomViewPagerAdapter(models, this));
       TabsIndicator.setViewPager(viewPager);
    }

    private void initModel() {
        Model model= new Model("Propios",R.drawable.ic_autorenew_black_24dp);
        models.add(model);
        model= new Model("Intercambiar",R.drawable.ic_autorenew_black_24dp);
        models.add(model);
        model= new Model("Plantar",R.drawable.ic_local_florist_black_24dp);
        models.add(model);
        model= new Model("Mapa",R.drawable.ic_pin_drop_black_24dp);
        models.add(model);
        model= new Model("Adoptar",R.drawable.ic_local_florist_black_24dp);
        models.add(model);
    }

}
