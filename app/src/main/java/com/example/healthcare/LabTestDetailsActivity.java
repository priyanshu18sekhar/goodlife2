package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.SharedPreferences;
import android.content.Context;


public class LabTestDetailsActivity extends AppCompatActivity {

    TextView tvPackagename,tvTotalcost;
    EditText eddetails;
    Button btnAddtocart,btnback;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test_details);
        tvPackagename = findViewById(R.id.textViewBMPack);
        tvTotalcost = findViewById(R.id.TotalCostLD);
        eddetails = findViewById(R.id.ListViewBM);
        btnback= findViewById(R.id.buttonBMback);
        btnAddtocart= findViewById(R.id.buttonBMGotocart);

        eddetails.setKeyListener(null);
        Intent intent =getIntent();
        tvPackagename.setText(intent.getStringExtra("text1"));
        eddetails.setText(intent.getStringExtra("text2"));
        tvTotalcost.setText("Total cost : "+intent.getStringExtra("text1")+"Rs");

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestDetailsActivity.this,LabTestActivity.class));
            }
        });
        btnAddtocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SharedPreferences sharedPreferences = getSharedPreferences("shared_pref", Context.MODE_PRIVATE);
                String username= sharedPreferences.getString("username","").toString();
                String product = tvPackagename.getText().toString();
                float price = Float.parseFloat(intent.getStringExtra("text3"));

                database db = new database(getApplicationContext(),"healthcare",null,1);
                if(db.Checkcart(username,product)==1){
                    Toast.makeText(getApplicationContext(),"Product alredy added",Toast.LENGTH_SHORT).show();
                }
                else{
                    db.addToCart(username,product,price,"lab");
                    Toast.makeText(getApplicationContext(),"Record inserted to the cart",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(LabTestDetailsActivity.this,LabTestActivity.class));
                }
            }
        });


    }
}