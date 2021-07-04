package kplo.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText tIET_email, tIET_password;
    LinearLayout linLay_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        tIET_email = findViewById(R.id.textInp_email);
        tIET_password = findViewById(R.id.textInp_password);
        linLay_login = findViewById(R.id.linlayout_login);

        // 1. 값을 가져온다
        // 2. 클릭을 감지한다
        // 3. 1번의 값을 다음 액티비티로 넘긴다

        linLay_login.setClickable(true);
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
}
