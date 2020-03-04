package com.example.gpstwodai;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText editTextname,editTextpassword;
    private TextView returnenter;  //返回登录界面
    private Button button; //注册按钮
    private ImageView returnimage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
    }

    private void init() {
        editTextname = (EditText) findViewById(R.id.er_username);
        editTextpassword = (EditText) findViewById(R.id.et_password);
        returnenter =(TextView) findViewById(R.id.ui_enter);
        button = (Button) findViewById(R.id.main_register);
        returnimage = (ImageView) findViewById(R.id.iv_back);
        button.setOnClickListener(this);
        returnenter.setOnClickListener(this);
        returnimage.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_register:
                register();
                break;
            case R.id.ui_enter:
                Intent intent = new Intent(this,EnterActivity.class);
                startActivity(intent);
                break;
        }

    }

    /**
     * 注册方法
     */

    private void register() {
        String username = editTextname.getText().toString();
        String registpassword = editTextpassword.getText().toString();
        if (TextUtils.isEmpty(username)) {
            Toast.makeText(this, "输入账号不能为空！", Toast.LENGTH_SHORT).show();
            editTextname.requestFocus();
            return;
        }else if (TextUtils.isEmpty(registpassword)) {
            Toast.makeText(this, "输入密码不能为空！", Toast.LENGTH_SHORT).show();
            editTextpassword.requestFocus();
            return;
        }
    }
}
