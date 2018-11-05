package com.lequiz.practice.nav_drawer;

import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.github.ksoichiro.android.observablescrollview.ObservableScrollView;
import com.github.ksoichiro.android.observablescrollview.ObservableScrollViewCallbacks;
import com.github.ksoichiro.android.observablescrollview.ScrollState;
import com.github.ksoichiro.android.observablescrollview.ScrollUtils;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.lequiz.practice.R;
import com.lequiz.practice.base.FullScreenStatusOnly;
import com.lequiz.practice.module.Users;

import java.util.Objects;

public class ProfileActivity extends AppCompatActivity implements ObservableScrollViewCallbacks {

    private View mToolbarView;
    private ObservableScrollView mScrollView;
    private int mParallaxImageHeight;
    Window window;
    TextView title_text,user_name;
    CardView toolbar_card_view_2;
    Users userInProfile;
    FirebaseAuth mAuth;
    DatabaseReference mDatabaseRefrence;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ui_profile);
        user_name = findViewById(R.id.profile_user_name);
        mAuth = FirebaseAuth.getInstance();
        // toolbar setup
        mToolbarView = findViewById(R.id.toolbar);
        setSupportActionBar((Toolbar) mToolbarView);
        getSupportActionBar().setTitle(null);
        title_text = findViewById(R.id.toolbar_title);
        title_text.setText(getResources().getText(R.string.profile));
        title_text.setTextColor(getResources().getColor(R.color.black));
        title_text.setAlpha(0);


        //mToolbarView.setBackgroundColor(ScrollUtils.getColorWithAlpha(0, getResources().getColor(R.color.white)));

        Objects.requireNonNull(getSupportActionBar()).setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_back_arrow_default);
        toolbar_card_view_2 = findViewById(R.id.toolbar_card_view_2);
        String uId = mAuth.getCurrentUser().getUid();
        System.out.println("U id "+uId);
        mDatabaseRefrence = FirebaseDatabase.getInstance().getReferenceFromUrl("https://lequiz-4abd1.firebaseio.com/Users"+uId);

        

        toolbar_card_view_2.setVisibility(View.INVISIBLE);


        // status bar calculation
        int statusBarHeight = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            statusBarHeight = getResources().getDimensionPixelSize(resourceId);
        }
        RelativeLayout toolbarLayout = findViewById(R.id.toolbar_root_layout);
        toolbarLayout.setPadding(0,statusBarHeight,0,0);
        window= getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);


        userNameInGradient();


        mScrollView = (ObservableScrollView) findViewById(R.id.scroll);
        mScrollView.setScrollViewCallbacks(this);
        mParallaxImageHeight = getResources().getDimensionPixelSize(R.dimen.image_height_home_part_1);
        new FullScreenStatusOnly(this);




    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        onScrollChanged(mScrollView.getCurrentScrollY(), false, false);
    }

    @Override
    public void onScrollChanged(int scrollY, boolean firstScroll, boolean dragging) {
        int baseColor = getResources().getColor(R.color.colorPrimary);
        float alpha = Math.min(1, (float) scrollY / mParallaxImageHeight);
        mToolbarView.setBackgroundColor(ScrollUtils.getColorWithAlpha(alpha-(float)0.02, baseColor));
        window.setStatusBarColor(ScrollUtils.getColorWithAlpha(alpha-(float)0.03, baseColor));
        title_text.setAlpha(alpha-(float)0.035);
    }


    @Override
    public void onDownMotionEvent() {

    }

    @Override
    public void onUpOrCancelMotionEvent(ScrollState scrollState) {
    }

    public void userNameInGradient() {
        Shader textShader = new LinearGradient(0, 0, 180, 0,
                new int[]{getResources().getColor(R.color.purpleOnHomeText), getResources().getColor(R.color.blueOnProfileText)},
                new float[]{0, 1}, Shader.TileMode.CLAMP);
        user_name.getPaint().setShader(textShader);
    }
    
}