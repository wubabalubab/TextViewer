package com.example.textviewer;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.basic.APSTSViewPager;
import com.example.fragment.HomeFragment;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

//    @BindView(R.id.tabs)
//    AdvancedPagerSlidingTabStrip mApsts;
    @BindView(R.id.vp_main)
    public APSTSViewPager mVP;

    static public final String TAG="asdf";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Toast.makeText(this,"success",Toast.LENGTH_SHORT).show();

        FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.contenter, new HomeFragment());
        fragmentTransaction.commit();


        System.out.println(0.2+0.1);
        System.out.println(0.2*0.1);
        System.out.println(0.2/0.1);

    }



}

