package nus.me.myplayer.ui.Bezier;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import nus.me.myplayer.MainActivity;
import nus.me.myplayer.R;

public class ActivityListView extends AppCompatActivity {
    ListView lv;
    private ImageView iv;
    private TextView tv;

    List<ProductBean> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_list_view);
       initView();

        initData();


    }

    private void initData() {
        list = new ArrayList<ProductBean>();
        for (int i = 0; i < 20; i++) {
            ProductBean b = new ProductBean();
            b.name = "name ="+i;
            b.info = "info = "+i;
            list.add(b);
        }

        MyAdapter adapter = new MyAdapter(this,list);
        lv.setAdapter(adapter);



    }

    private void initView() {
        lv = (ListView) findViewById(R.id.lv);
        iv = (ImageView) findViewById(R.id.iv);
        tv = (TextView) findViewById(R.id.tv);

    }


}


class MyAdapter extends BaseAdapter{
    Context context;
    List<ProductBean> list_product = new ArrayList<ProductBean>();

    public MyAdapter(Context context, List<ProductBean> list_product) {
        this.context = context;
        this.list_product = list_product;
    }

    @Override
    public int getCount() {
        return list_product.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    class Holder{
        Button btn_item;
        TextView tv_name;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    Holder holder = null;

        if (convertView == null){
            holder = new Holder();
            convertView = LayoutInflater.from(context).inflate(R.layout.item,null);
            holder.btn_item = (Button) convertView.findViewById(R.id.btn_item);
            holder.tv_name = (TextView) convertView.findViewById(R.id.tv_name);
            convertView.setTag(holder);

        }else{
            holder = (Holder) convertView.getTag();

        }

        holder.tv_name.setText(list_product.get(position).name);
        final View finalConvertView = convertView;
        holder.btn_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e("Button item","onClick"+"  "+"position = "+v.getMeasuredHeight());
                Redview btn = new Redview( context);
                btn.setText("1");
                btn.setTextColor(Color.WHITE);

                btn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {



                        ObjectAnimator anim1 = ObjectAnimator.ofFloat(v, "translationX", 0, 200).setDuration(2000);// 位移
                        ObjectAnimator anim2 = ObjectAnimator.ofFloat(v, "translationY", 0, 200).setDuration(2000);
                        ObjectAnimator anim3 = ObjectAnimator.ofFloat(v, "rotation", 0, 600).setDuration(2000); // 旋转、
                        AnimatorSet set = new AnimatorSet();
                        set.playTogether(anim1,anim2,anim3);
                        set.start();

                    }
                });

                ((RelativeLayout) finalConvertView).addView(btn);





            }
        });



        return convertView;
    }
}