package kplo.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText tIET_email, tIET_password;
    LinearLayout linLay_login;
    String emailOk = "gmail";
    String passwdOk = "1234";

    String inpEmail = "";
    String inpPwd = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tIET_email = findViewById(R.id.textInp_email);
        tIET_password = findViewById(R.id.textInp_password);
        linLay_login = findViewById(R.id.linlayout_login);

        // 1. 값을 가져온다 - 검사 (123@gmail.com / 1234)
        // 2. 클릭을 감지한다
        // 3. 1번의 값을 다음 액티비티로 넘긴다

        linLay_login.setClickable(false);

        tIET_email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                Log.d("SENTI", s+ ","+count);
                if(s != null)
                    inpEmail = s.toString();

                linLay_login.setClickable(validation()); // 똑똑한 코딩...!
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        tIET_password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                Log.d("SENTI", s+ ","+count);
                if(s != null)
                    inpPwd = s.toString();

                linLay_login.setClickable(validation());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }

    public boolean validation(){
        boolean val = (inpEmail.equals(emailOk)) && (inpPwd.equals(passwdOk));

        if(val == true){
            linLay_login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String email = tIET_email.getText().toString();
                    String passwd = tIET_password.getText().toString();

                    Intent intent = new Intent(MainActivity.this, LoginResultActivity.class);
                    intent.putExtra("res_email",email);
                    intent.putExtra("res_passwd",passwd);
                    startActivity(intent);
                }
            });
        }
        return val;
    }
}
