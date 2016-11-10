package uwstout.basketballapp;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.LayerDrawable;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

public class ShotLocation extends AppCompatActivity {


    private Button test;
    private Button dismiss;
    private PopupWindow popupWindow;
    private LayoutInflater layoutInflater;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shot_location);

        final Drawable imgShot = getResources().getDrawable(R.drawable.shot);
        final int h = imgShot.getIntrinsicHeight();
        final int w = imgShot.getIntrinsicWidth();

        final RelativeLayout r1 = (RelativeLayout) findViewById(R.id.r1);
            /*r1.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    if(event.getAction() == MotionEvent.ACTION_DOWN){
                        int x = (int) event.getX();
                        int y = (int) event.getY();
                        RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                        final ImageView iv = new ImageView(getApplicationContext());
                        lp.setMargins(x-h/2, y-w/2, 0, 0);
                        iv.setLayoutParams(lp);
                        iv.setImageDrawable(imgShot);
                        ((ViewGroup) v).addView(iv);
                        new CountDownTimer(5000, 1000) {
                            public void onTick(long mSec){

                            }
                            public void onFinish(){
                                iv.setImageDrawable(null);
                            }
                        }.start();
                    }
                    return false;
                }
            });*/

        //test = (Button) findViewById(R.id.button);
        dismiss = (Button) findViewById(R.id.dismiss);
        r1.setOnTouchListener(new View.OnTouchListener(){
            public boolean onTouch(View view, MotionEvent event){
                if(event.getAction() == MotionEvent.ACTION_DOWN){
                    int x = (int) event.getX();
                    int y = (int) event.getY();
                    layoutInflater = (LayoutInflater) getApplicationContext().getSystemService(LAYOUT_INFLATER_SERVICE);
                    ViewGroup container = (ViewGroup) layoutInflater.inflate(R.layout.popup, null);
                    popupWindow = new PopupWindow(container, WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT, true);
                    popupWindow.showAtLocation(r1, Gravity.NO_GRAVITY, x, y);

                    container.setOnTouchListener(new View.OnTouchListener(){
                       public boolean onTouch(View view, MotionEvent motionEvent){
                           /*if(motionEvent.getAction() == MotionEvent.ACTION_OUTSIDE){
                               popupWindow.dismiss();
                               return true;
                           }
                           return false;*/
                           popupWindow.dismiss();
                           return true;
                       }
                    });


                    RelativeLayout.LayoutParams lp = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                    final ImageView iv = new ImageView(getApplicationContext());
                    lp.setMargins(x-h/2, y-w/2, 0, 0);
                    iv.setLayoutParams(lp);
                    iv.setImageDrawable(imgShot);
                    ((ViewGroup) view).addView(iv);
                    new CountDownTimer(5000, 1000) {
                        public void onTick(long mSec){

                        }
                        public void onFinish(){
                            iv.setImageDrawable(null);
                        }
                    }.start();

                    /*popupWindow.setBackgroundDrawable(new BitmapDrawable(getResources(), ""));
                    popupWindow.setOutsideTouchable(true);
                    popupWindow.setFocusable(true);*/
                }
                return false;
            }
        });

    }

}
