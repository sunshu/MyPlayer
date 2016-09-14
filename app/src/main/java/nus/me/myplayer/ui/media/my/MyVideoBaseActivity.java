package nus.me.myplayer.ui.media.my;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import nus.me.myplayer.R;

public abstract class MyVideoBaseActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView tv_title;
    private RelativeLayout rl_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_my_video);
        initBar();
    }

    private void initBar() {
        findViewById(R.id.btn_left).setOnClickListener(this);
        findViewById(R.id.btn_right).setOnClickListener(this);
        tv_title = (TextView) findViewById(R.id.tv_title);
        rl_content = (RelativeLayout) findViewById(R.id.rl_content);
        tv_title.setText(setTitle());
        View child = getContentView();
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
        rl_content.addView(child,params);


    }



    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_left:{
                clickLeftButton();
                break;
            }
            case R.id.btn_right:{
                clickRightButton();
            }


        }

    }

    protected abstract View getContentView();
    protected abstract void clickLeftButton();
    protected abstract void clickRightButton();
    protected abstract String setTitle();

}
