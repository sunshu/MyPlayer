package nus.me.myplayer.ui.media.my;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;

import nus.me.myplayer.R;

public class MyFileActivity extends MyMainActivity {



    @Override
    protected View getContentView() {
        View view = LayoutInflater.from(this).inflate(R.layout.activity_my_file,null);

        return view;
    }

    @Override
    protected void clickLeftButton() {

    }

    @Override
    protected void clickRightButton() {

    }

    @Override
    protected String setTitle() {
        return null;
    }
}
