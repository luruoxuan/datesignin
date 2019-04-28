package cn.llwy.com.signin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import cn.llwy.com.signin.View.MysigninView;
import cn.llwy.com.signin.bean.SigninBean;

public class MainActivity extends AppCompatActivity {
    private MysigninView msigninView;
    private TextView txt;
    private ArrayList<SigninBean> signinBen = new ArrayList<>();
    boolean flag=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Init();

        InitData();
        InitListtener();
    }

    private void InitListtener() {
        txt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag) {
                    msigninView.startSignAnimation(2);
                    flag=false;
                    txt.setBackground(getResources().getDrawable(R.mipmap.signed));
                }else{
                    Toast.makeText(MainActivity.this,"当前已签到，不允许重复签到",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private void InitData() {
        signinBen.add(new SigninBean(SigninBean.STEP_COMPLETED, 1));
        signinBen.add(new SigninBean(SigninBean.STEP_COMPLETED, 2));
        signinBen.add(new SigninBean(SigninBean.STEP_UNDO, 5));
        signinBen.add(new SigninBean(SigninBean.STEP_UNDO, 5));
        signinBen.add(new SigninBean(SigninBean.STEP_UNDO, 5));
        signinBen.add(new SigninBean(SigninBean.STEP_UNDO, 5));
        signinBen.add(new SigninBean(SigninBean.STEP_UNDO, 10));
        msigninView.setStepNum(signinBen);
    }

    private void Init() {
        msigninView = findViewById(R.id.signin_view);
        txt = findViewById(R.id.txt_click);
    }
}
