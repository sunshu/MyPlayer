package nus.me.myplayer.ui.test;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import nus.me.myplayer.R;

public class Activitymp extends AppCompatActivity {

    private ImageView iv1;
    private ImageView iv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activitymp);
        iv1 = (ImageView) findViewById(R.id.iv1);
        iv2 = (ImageView) findViewById(R.id.iv2);
        iv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TranslateAnimation animation = new TranslateAnimation(0, 2000, 0, 0);
                animation.setInterpolator(new LinearInterpolator());
                animation.setDuration(4000);
                animation.setFillAfter(true);
                iv1.startAnimation(animation);
                Log.e("an","aa");
//                ObjectAnimator anim1 = ObjectAnimator.ofFloat(iv1, "translationX", 0, 200).setDuration(2000);// 位移
//                ObjectAnimator anim2 = ObjectAnimator.ofFloat(iv1, "translationY", 0, 200).setDuration(2000);
//                ObjectAnimator anim3 = ObjectAnimator.ofFloat(iv1, "rotation", 0, 600).setDuration(2000); // 旋转、
////        ObjectAnimator anim4 = ObjectAnimator.ofFloat(iv1,"");
//
//                android.animation.AnimatorSet set1 = new AnimatorSet();
//                set1.playTogether(anim1,anim2,anim3);
//                set1.start();


            }
        });

    }




}
