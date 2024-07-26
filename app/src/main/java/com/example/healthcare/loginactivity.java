package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class loginactivity extends AppCompatActivity {

    EditText edUsername, edPassword;
    TextView tv;
    Button btn;
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        sharedPreferences = getSharedPreferences("shared_pref", Context.MODE_PRIVATE);
        if (sharedPreferences.contains("username")) {
            String username = sharedPreferences.getString("username", "");
            if (!username.isEmpty()) {
                startActivity(new Intent(loginactivity.this, HomeActivity.class));
                finish();
            }
        }

        setContentView(R.layout.activity_loginactivity);
        edUsername = findViewById(R.id.editTextLoginUsername);
        edPassword = findViewById(R.id.editTextLoginPassword);
        btn = findViewById(R.id.buttonLogin);
        tv = findViewById(R.id.textViewNewUser);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Username = edUsername.getText().toString();
                String Password = edPassword.getText().toString();
                database db = new database(getApplicationContext(),"healthcare",null,1);

                if (Username.length()==0 || Password.length()==0){
                    Toast.makeText(getApplicationContext(),"Please fill all the Details",Toast.LENGTH_SHORT).show();

                }else {
                    if(db.login(Username,Password)==1)
                    {
                        Toast.makeText(getApplicationContext(), "Log in Success", Toast.LENGTH_SHORT).show();
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("username",Username);
                        editor.apply();
                        startActivity(new Intent(loginactivity.this,HomeActivity.class));
                        finish();
                    }
                    else{
                        Toast.makeText(getApplicationContext(), "Invalid username or password", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(loginactivity.this,RegisterActivity.class));
            }
        });
    }
}
