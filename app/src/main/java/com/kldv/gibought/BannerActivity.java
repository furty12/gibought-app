package com.kldv.gibought;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.viewpager2.widget.ViewPager2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.android.material.button.MaterialButton;

import java.util.ArrayList;
import java.util.List;

public class BannerActivity extends AppCompatActivity {

    private ObgAdapter obgAdapter;
    private LinearLayout layoutObg;
    private MaterialButton buttonObgAct, buttonObgPrev;

    public BannerActivity() {}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);

        layoutObg = findViewById(R.id.layoutObg);
        buttonObgAct = findViewById(R.id.buttonNextIndicatorIn);
        buttonObgPrev = findViewById(R.id.buttonPrevIndicatorIn);

        setupObgItems();
        final ViewPager2 obgViewPager = findViewById(R.id.obgViewPager);
        obgViewPager.setAdapter(obgAdapter);

        setupObgIns();
        setCurrentObgIn(0);

        obgViewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                setCurrentObgIn(position);
            }
        });

        buttonObgAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (obgViewPager.getCurrentItem() + 1 < obgAdapter.getItemCount()) {
                    obgViewPager.setCurrentItem(obgViewPager.getCurrentItem() + 1);
                } else {
                    startActivity(new Intent(getApplicationContext(), MainActivity.class));
                    finish();
                }
            }
        }

        );

        buttonObgPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (obgViewPager.getCurrentItem() - 1 < obgAdapter.getItemCount()) {
                    obgViewPager.setCurrentItem(obgViewPager.getCurrentItem() - 1);
                }
            }
        }

        );

    }

    private void setupObgItems() {

        List < ObgItem > obgItems = new ArrayList < > ();

        ObgItem itemSlide1 = new ObgItem();
        itemSlide1.setTitle("Slide 1");
        itemSlide1.setDesc("Slide 1 description");
        itemSlide1.setImg(R.drawable.slide1);

        ObgItem itemSlide2 = new ObgItem();
        itemSlide2.setTitle("Slide 2");
        itemSlide2.setDesc("Slide 2 description");
        itemSlide2.setImg(R.drawable.slide2);

        ObgItem itemSlide3 = new ObgItem();
        itemSlide3.setTitle("Slide 3");
        itemSlide3.setDesc("Slide 3 description");
        itemSlide3.setImg(R.drawable.slide3);

        ObgItem itemSlide4 = new ObgItem();
        itemSlide4.setTitle("Slide 4");
        itemSlide4.setDesc("Slide 4 description");
        itemSlide4.setImg(R.drawable.slide4);

        obgItems.add(itemSlide1);
        obgItems.add(itemSlide2);
        obgItems.add(itemSlide3);
        obgItems.add(itemSlide4);

        obgAdapter = new ObgAdapter(obgItems);

    }

    private void setupObgIns() {
        ImageView[] ins = new ImageView[obgAdapter.getItemCount()];
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(

                ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT

        );
        layoutParams.setMargins(8, 0, 8, 0);
        for (int i = 0; i < ins.length; i++) {
            ins[i] = new ImageView(getApplicationContext());
            ins[i].setImageDrawable(ContextCompat.getDrawable(
                    getApplicationContext(),
                    R.drawable.obg_indicator_inactive
            ));
            ins[i].setLayoutParams(layoutParams);
            layoutObg.addView(ins[i]);
        }
    }

    @SuppressLint("SetTextI18n")
    private void setCurrentObgIn(int index) {
        int childCount = layoutObg.getChildCount();
        for (int i = 0; i < childCount; i++) {
            ImageView imageView = (ImageView) layoutObg.getChildAt(i);
            if (i == index) {
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(), R.drawable.obg_indicator_active)
                );
            } else {
                imageView.setImageDrawable(
                        ContextCompat.getDrawable(getApplicationContext(), R.drawable.obg_indicator_inactive)
                );
            }
        }

        if (index == obgAdapter.getItemCount() - 1) {
            buttonObgAct.setText("Finish");
        } else {
            buttonObgAct.setText("Next");
        }
        if (index == obgAdapter.getItemCount() - 1) {
            buttonObgPrev.setText("Back");
            buttonObgPrev.setEnabled(true);
            buttonObgPrev.setVisibility(View.VISIBLE);
        } else if (index == 0) {
            buttonObgPrev.setEnabled(false);
            buttonObgPrev.setVisibility(View.INVISIBLE);
        } else {
            buttonObgPrev.setText("Back");
            buttonObgPrev.setEnabled(true);
            buttonObgPrev.setVisibility(View.VISIBLE);
        }

    }

}