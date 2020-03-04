package com.example.gpstwodai;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class EnterActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText usnumber,uspassword;
    private TextView textViewRegister;  //跳转注册界面
    private Button btn;  //登录按钮
    private String loginnumber,loginpassword; //读取账号密码

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);
        init();
    }

    private void init() {
        btn = (Button)findViewById(R.id.main_enter);
        btn.setOnClickListener(this);
        usnumber = (EditText) findViewById(R.id.et_username);
        uspassword = (EditText) findViewById(R.id.et_password);
        textViewRegister = (TextView) findViewById(R.id.ui_register);
        textViewRegister.setOnClickListener(this);
    }

    /**
     *
     * 编写点击事件
     **/

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.main_enter:    //登录功能
                login();
                break;
            case R.id.ui_register:    //跳转注册界面
                Intent intent = new Intent(EnterActivity.this,RegisterActivity.class);
                startActivity(intent);
                finish();
                break;
        }

    }

    private void login() {
        loginnumber = usnumber.getText().toString();
        loginpassword = uspassword.getText().toString();

        if (TextUtils.isEmpty(loginnumber)) {
            Toast.makeText(this, "输入账号为空！", Toast.LENGTH_SHORT).show();

        }else if (TextUtils.isEmpty(loginpassword)) {
            Toast.makeText(this, "输入密码为空！", Toast.LENGTH_SHORT).show();
            return;
        }
        ProgressDialog pd = new ProgressDialog(EnterActivity.this);
        pd.setMessage("正在登录。。。");
        pd.show();
    }
}
