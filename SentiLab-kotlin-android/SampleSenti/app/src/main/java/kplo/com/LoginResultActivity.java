package kplo.com;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class LoginResultActivity extends AppCompatActivity {

    TextView tv_get;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_get = findViewById(R.id.tv_get);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();
        String email = bundle.getString("res_email");
        String passwd = bundle.getString("res_passwd");

        tv_get.setText(email + " / " + passwd);
    }
}
