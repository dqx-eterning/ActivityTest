package com.example.activitytest;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.activitytest.listView.ListViewActivity;

public class FirstActivity extends AppCompatActivity {


    private Button button4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        OnClick onClick = new OnClick();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        Button button1 =(Button) findViewById(R.id.button_1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               /* Toast.makeText(FirstActivity.this,"you clicked button 1",Toast.LENGTH_SHORT).show();*/

                //Intent显式用法（在多个活动间切换）
                /*  Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                startActivity(intent);*/

                //Intent隐式用法
               /* Intent intent = new Intent("com.example.activitytest.ACTION_START");
                intent.addCategory("com.example.activitytest.MY_CATEGORY");
                startActivity(intent);*/

               //更多Intent用法,启动其他程序的活动
                /*Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);*/


                //启动电话
               /* Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);*/

               //向下一个活动传递数据
               /* String data = "hello secondActivity";
                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                intent.putExtra("extra_data",data);
                startActivity(intent);*/

                //返回数据给上一个活动
                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                startActivityForResult(intent,1);
            }
        });

        button4 = findViewById(R.id.button_4);
        button4.setOnClickListener(onClick);

    }


    private class OnClick implements View.OnClickListener{
        Intent intent = null;
        @Override
        public void onClick(View v) {
            switch (v.getId()){
                case R.id.button_4:
                    intent = new Intent(FirstActivity.this, ListViewActivity.class);
                    startActivity(intent);
                default:
                    break;
            }
        }
    }

    //接受活动2返回的数据
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 1:
                if (resultCode == RESULT_OK) {
                    String data_return = data.getStringExtra("data_return");
                    Log.d("FirstActivity", data_return);
                }
                break;
            default:
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch(item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this,"you clicked add ",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"you clicked remove ",Toast.LENGTH_SHORT).show();
                break;
             default:
        }
        return true;
    }
}
