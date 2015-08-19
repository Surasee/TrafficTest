package com.tho.traffic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowDetailActivity extends AppCompatActivity {
    private TextView showTitleTextView, showDetailTextview;// สร้างวัตถุ คำบรรยาย
    private ImageView showTrafficImageView; //สร้างวัตถุ รูปภาพ



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_detail);

        bindWidget();

        showWidget();

    }

    private void showWidget() {
        //รับค่าจาก หน้าที่แล้ว
        int intCkick = getIntent().getIntExtra("click", 0);


        //แสดงข้อความ
        MyData objMyData = new MyData();
        String[] strTitle = objMyData.title();
        showTitleTextView.setText(strTitle[intCkick]);

        //แสดงรูปภาพ
        int[] intDrawable = objMyData.icon();
        showTrafficImageView.setImageResource(intDrawable[intCkick]);

        //แสดงรายละเอียด
        String[] strDetail = getResources().getStringArray(R.array.traffic_detail);
        showDetailTextview.setText(strDetail[intCkick]);

    }

    private void bindWidget() {
        showTitleTextView = (TextView) findViewById(R.id.txtTitleDetail);
        showDetailTextview = (TextView) findViewById(R.id.txtDetail);
        showTrafficImageView = (ImageView) findViewById(R.id.imvTrafficDetail);
    } //เชื่อมตัวแปรกับไอดีของ  Layout

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_show_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}// main class
