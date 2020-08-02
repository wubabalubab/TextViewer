package com.example.textviewer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DemoActivity extends AppCompatActivity  {


    @BindView(R.id.image_1)
    ImageView image1;
    @BindView(R.id.image_2)
    ImageView image2;
    Bitmap mBitmap;
    @BindView(R.id.btn_1)
    Button btn1;
    @BindView(R.id.relative)
    RelativeLayout relative;

    private int lastX;
    private int lastY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.testdemo);
        setContentView(R.layout.activity_demo);
        ButterKnife.bind(this);
//        image1.setDrawingCacheEnabled(true);
//        image1.setOnTouchListener(this);
//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//               RelativeLayout.LayoutParams par = (RelativeLayout.LayoutParams)image1.getLayoutParams();
//
//                    par.leftMargin +=10;
//
//                image1.setLayoutParams(par);
//
//
//                RelativeLayout.LayoutParams par2 = (RelativeLayout.LayoutParams)image2.getLayoutParams();
//
//                par2.leftMargin +=10;
//
//                image2.setLayoutParams(par2);
//            }
//        });

        relative.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final int X = (int) event.getRawX()/100;

                switch (event.getAction()){
                  case MotionEvent.ACTION_DOWN:
//                      RelativeLayout.LayoutParams lParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
//                      _xDelta = X - lParams.leftMargin;
//                      _yDelta = Y - lParams.topMargin;
                      break;
                  case MotionEvent.ACTION_MOVE:

                      RelativeLayout.LayoutParams par = (RelativeLayout.LayoutParams)image1.getLayoutParams();

                      par.leftMargin +=X;

                      image1.setLayoutParams(par);

                      RelativeLayout.LayoutParams par2 = (RelativeLayout.LayoutParams)image2.getLayoutParams();

                      par2.leftMargin -=X;

                      image2.setLayoutParams(par2);

                      break;
                  default:
                      break;
              }
                return true;
            }
        });
//        image1.setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//
//                RelativeLayout.LayoutParams par=
//                        (RelativeLayout.LayoutParams)image1.getLayoutParams();
//
//
//                RelativeLayout.LayoutParams par2=(RelativeLayout.LayoutParams)image2.getLayoutParams();
//                switch (event.getAction()){
//                    case MotionEvent.ACTION_DOWN:
//                        break;
//                    case MotionEvent.ACTION_MOVE:
//                        int x_cord = (int)event.getRawX();
////                        int y_cord = (int)event.getRawY();
//                        par.leftMargin = x_cord - par.width / 2;
////                        par.topMargin = y_cord - par.height / 2 ;
//                        par2.leftMargin=x_cord+par2.width/2;
//                        image2.setLayoutParams(par2);
//                        image1.setLayoutParams(par);
//                        break;
//                    default:
//                        break;
//                }
//                return true;
//            }
//        });
    }

//    @Override
//    public boolean onTouch(View v, MotionEvent event) {
//
//        switch (event.getAction()) {
//
//            case MotionEvent.ACTION_DOWN:
//                lastX = (int) event.getRawX();
//                lastY = (int) event.getRawY();
//
//                break;
//            case MotionEvent.ACTION_MOVE:
//
//                int dx = (int) event.getRawX() - lastX;
//                int dy = (int) event.getRawY() - lastY;
//
//                int left = v.getLeft() + dx;
//                int top = v.getTop() + dy;
//                int right = v.getRight() + dx;
//                int bottom = v.getBottom() + dy;
//
//
//                Log.i("life", " left = " + left + "  v.getLeft=" + v.getLeft() + " ; event.getRawX = " + event.getRawX() + " ; lastX = " + lastX + " dx = " + dx);
//
//                v.layout(left, top, right, bottom);
//
//                lastX = (int) event.getRawX();
//                lastY = (int) event.getRawY();
//
//                break;
//            case MotionEvent.ACTION_UP:
//
//                break;
//        }
//
//        return true;
//    }
}
