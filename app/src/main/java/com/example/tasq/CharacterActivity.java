package com.example.tasq;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.tasq.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class CharacterActivity extends AppCompatActivity {
    private ImageView imageView;
    private ImageView mainImageView;
    private ImageView shirtImageView;
    private ImageView pantsImageView;

    private BottomNavigationView bottomNavigationView;
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);
        replaceFragment(new HeadFragment());
        binding.bottomNavigationView.setOnItemSelectedListener(item -> {
            switch(item.getItemId()) {
                case R.id.hair:
                    replaceFragment(new HeadFragment());
                    break;
                case R.id.shirt:
                    replaceFragment(new ShirtFragment());
                    break;
                case R.id.trouser:
                    replaceFragment(new TrouserFragment());
                    break;
            }
            return true;
        });
        mainImageView = findViewById(R.id.head_image_view);
        shirtImageView = findViewById(R.id.shirt_image_view);
        pantsImageView = findViewById(R.id.pants_image_view);
    }

    private void replaceFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.frame_layout, fragment);
        fragmentTransaction.commit();
    }
    public void changeShirtImage(int resourceId) {
        ImageView shirtImageView = findViewById(R.id.shirt_image_view);

        shirtImageView.setImageResource(resourceId);
    }
    public void changePantsImage(int resourceId) {
        ImageView pantsImageView = findViewById(R.id.pants_image_view);

        pantsImageView.setImageResource(resourceId);
    }
    public void changeHeadImage(int resourceId) {
        ImageView headImageView = findViewById(R.id.head_image_view);

        headImageView.setImageResource(resourceId);
    }
    public void changeHead1() {
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) mainImageView.getLayoutParams();
        float density = getResources().getDisplayMetrics().density;
        int left = (int) (3 * density);
        int top = (int) (30 * density);
        layoutParams.leftMargin = left;
        layoutParams.topMargin = top;
        mainImageView.setLayoutParams(layoutParams);
    }
    public void changeHead2() {
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) mainImageView.getLayoutParams();
        float density = getResources().getDisplayMetrics().density;
        int left = (int) (2 * density);
        int top = (int) (44 * density);
        layoutParams.leftMargin = left;
        layoutParams.topMargin = top;
        mainImageView.setLayoutParams(layoutParams);
    }
    public void changeHead3() {
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) mainImageView.getLayoutParams();
        float density = getResources().getDisplayMetrics().density;
        int left = (int) (2 * density);
        int top = (int) (36 * density);
        layoutParams.leftMargin = left;
        layoutParams.topMargin = top;
        mainImageView.setLayoutParams(layoutParams);
    }
    public void changeHead4() {
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) mainImageView.getLayoutParams();
        float density = getResources().getDisplayMetrics().density;
        int left = (int) (3 * density);
        int top = (int) (37 * density);
        layoutParams.leftMargin = left;
        layoutParams.topMargin = top;
        mainImageView.setLayoutParams(layoutParams);
    }
    /*
    public void changeHead5() {
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) mainImageView.getLayoutParams();
        float density = getResources().getDisplayMetrics().density;
        int left = (int) (3 * density);
        int top = (int) (37 * density);
        layoutParams.leftMargin = left;
        layoutParams.topMargin = top;
        mainImageView.setLayoutParams(layoutParams);
     }
     */
    public void changeHead6() {
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) mainImageView.getLayoutParams();
        float density = getResources().getDisplayMetrics().density;
        int left = (int) (3 * density);
        int top = (int) (39 * density);
        layoutParams.leftMargin = left;
        layoutParams.topMargin = top;
        mainImageView.setLayoutParams(layoutParams);
    }
    public void changeHead7() {
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) mainImageView.getLayoutParams();
        float density = getResources().getDisplayMetrics().density;
        int left = (int) (3 * density);
        int top = (int) (37 * density);
        layoutParams.leftMargin = left;
        layoutParams.topMargin = top;
        mainImageView.setLayoutParams(layoutParams);
    }
    public void changeHead8() {
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) mainImageView.getLayoutParams();
        float density = getResources().getDisplayMetrics().density;
        int left = (int) (3 * density);
        int top = (int) (45 * density);
        layoutParams.leftMargin = left;
        layoutParams.topMargin = top;
        mainImageView.setLayoutParams(layoutParams);
    }
    public void changeHead10() {
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) mainImageView.getLayoutParams();
        float density = getResources().getDisplayMetrics().density;
        int left = (int) (3 * density);
        int top = (int) (37 * density);
        layoutParams.leftMargin = left;
        layoutParams.topMargin = top;
        mainImageView.setLayoutParams(layoutParams);
    }
    public void changeHead11() {
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) mainImageView.getLayoutParams();
        float density = getResources().getDisplayMetrics().density;
        int left = (int) (3 * density);
        int top = (int) (42 * density);
        layoutParams.leftMargin = left;
        layoutParams.topMargin = top;
        mainImageView.setLayoutParams(layoutParams);
    }
    public void changeHead12() {
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) mainImageView.getLayoutParams();
        float density = getResources().getDisplayMetrics().density;
        int left = (int) (3 * density);
        int top = (int) (50 * density);
        layoutParams.leftMargin = left;
        layoutParams.topMargin = top;
        mainImageView.setLayoutParams(layoutParams);
    }
    // Change Shirt
    public void changeShirt1() {
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) shirtImageView.getLayoutParams();
        float density = getResources().getDisplayMetrics().density;
        int left = (int) (3 * density);
        int top = (int) (130 * density);
        layoutParams.leftMargin = left;
        layoutParams.topMargin = top;
        shirtImageView.setLayoutParams(layoutParams);
    }
    public void changeShirt2() {
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) shirtImageView.getLayoutParams();
        float density = getResources().getDisplayMetrics().density;
        int left = (int) (0 * density);
        int top = (int) (100 * density);
        layoutParams.leftMargin = left;
        layoutParams.topMargin = top;
        shirtImageView.setLayoutParams(layoutParams);
    }
    public void changeShirt4() {
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) shirtImageView.getLayoutParams();
        float density = getResources().getDisplayMetrics().density;
        int left = (int) (0 * density);
        int top = (int) (125 * density);
        layoutParams.leftMargin = left;
        layoutParams.topMargin = top;
        shirtImageView.setLayoutParams(layoutParams);
    }
    public void changeShirt5() {
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) shirtImageView.getLayoutParams();
        float density = getResources().getDisplayMetrics().density;
        int left = (int) (0 * density);
        int top = (int) (125 * density);
        layoutParams.leftMargin = left;
        layoutParams.topMargin = top;
        shirtImageView.setLayoutParams(layoutParams);
    }
    public void changeShirt7() {
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) shirtImageView.getLayoutParams();
        float density = getResources().getDisplayMetrics().density;
        int left = (int) (0 * density);
        int top = (int) (120 * density);
        layoutParams.leftMargin = left;
        layoutParams.topMargin = top;
        shirtImageView.setLayoutParams(layoutParams);
    }
    public void changeShirt8() {
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) shirtImageView.getLayoutParams();
        float density = getResources().getDisplayMetrics().density;
        int left = (int) (2 * density);
        int top = (int) (120 * density);
        layoutParams.leftMargin = left;
        layoutParams.topMargin = top;
        shirtImageView.setLayoutParams(layoutParams);
    }
    public void changeShirt9() {
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) shirtImageView.getLayoutParams();
        float density = getResources().getDisplayMetrics().density;
        int left = (int) (4 * density);
        int top = (int) (130 * density);
        layoutParams.leftMargin = left;
        layoutParams.topMargin = top;
        shirtImageView.setLayoutParams(layoutParams);
    }
    public void changeShirt10() {
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) shirtImageView.getLayoutParams();
        float density = getResources().getDisplayMetrics().density;
        int left = (int) (1 * density);
        int top = (int) (120 * density);
        layoutParams.leftMargin = left;
        layoutParams.topMargin = top;
        shirtImageView.setLayoutParams(layoutParams);
    }
    public void changeShirt11() {
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) shirtImageView.getLayoutParams();
        float density = getResources().getDisplayMetrics().density;
        int left = (int) (3 * density);
        int top = (int) (118 * density);
        layoutParams.leftMargin = left;
        layoutParams.topMargin = top;
        shirtImageView.setLayoutParams(layoutParams);
    }
    public void changeShirt12() {
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) shirtImageView.getLayoutParams();
        float density = getResources().getDisplayMetrics().density;
        int left = (int) (1 * density);
        int top = (int) (122 * density);
        layoutParams.leftMargin = left;
        layoutParams.topMargin = top;
        shirtImageView.setLayoutParams(layoutParams);
    }
    // Change Pants
    public void changePants1() {
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) pantsImageView.getLayoutParams();
        float density = getResources().getDisplayMetrics().density;
        int left = (int) (0 * density);
        int top = (int) (216 * density);
        layoutParams.leftMargin = left;
        layoutParams.topMargin = top;
        pantsImageView.setLayoutParams(layoutParams);
    }
    public void changePants2() {
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) pantsImageView.getLayoutParams();
        float density = getResources().getDisplayMetrics().density;
        int left = (int) (0 * density);
        int top = (int) (210 * density);
        layoutParams.leftMargin = left;
        layoutParams.topMargin = top;
        pantsImageView.setLayoutParams(layoutParams);
    }
    public void changePants3() {
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) pantsImageView.getLayoutParams();
        float density = getResources().getDisplayMetrics().density;
        int left = (int) (-4 * density);
        int top = (int) (210 * density);
        layoutParams.leftMargin = left;
        layoutParams.topMargin = top;
        pantsImageView.setLayoutParams(layoutParams);
    }
    public void changePants4() {
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) pantsImageView.getLayoutParams();
        float density = getResources().getDisplayMetrics().density;
        int left = (int) (1 * density);
        int top = (int) (216 * density);
        layoutParams.leftMargin = left;
        layoutParams.topMargin = top;
        pantsImageView.setLayoutParams(layoutParams);
    }
    public void changePants5() {
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) pantsImageView.getLayoutParams();
        float density = getResources().getDisplayMetrics().density;
        int left = (int) (0 * density);
        int top = (int) (210 * density);
        layoutParams.leftMargin = left;
        layoutParams.topMargin = top;
        pantsImageView.setLayoutParams(layoutParams);
    }
    public void changePants8() {
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) pantsImageView.getLayoutParams();
        float density = getResources().getDisplayMetrics().density;
        int left = (int) (0 * density);
        int top = (int) (210 * density);
        layoutParams.leftMargin = left;
        layoutParams.topMargin = top;
        pantsImageView.setLayoutParams(layoutParams);
    }
    public void changePants12() {
        ViewGroup.MarginLayoutParams layoutParams = (ViewGroup.MarginLayoutParams) pantsImageView.getLayoutParams();
        float density = getResources().getDisplayMetrics().density;
        int left = (int) (0 * density);
        int top = (int) (212 * density);
        layoutParams.leftMargin = left;
        layoutParams.topMargin = top;
        pantsImageView.setLayoutParams(layoutParams);
    }
}