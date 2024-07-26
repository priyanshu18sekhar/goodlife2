package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;


public class BuyMedicineActivity extends AppCompatActivity {
    private Button btn, btnGotocart;
    private ListView listView;
    private ArrayList<String> medicineList;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);

        btn = findViewById(R.id.buttonBMback);
        btnGotocart = findViewById(R.id.buttonBMGotocart);
        listView = findViewById(R.id.ListViewBM);

        medicineList = new ArrayList<>();
        medicineList.add("1. Paracetamol: Used to treat pain and fever.");
        medicineList.add("2. Ibuprofen: Used to relieve pain, swelling, or inflammation.");
        medicineList.add("3. Aspirin: Used to treat pain, fever, and inflammation.");
        medicineList.add("4. Omeprazole: Used to treat heartburn, reflux, and ulcers.");
        medicineList.add("5. Cetirizine: Used to relieve allergy symptoms such as watery eyes, runny nose, itching eyes/nose, and sneezing.");
        medicineList.add("6. Diphenhydramine: Used to relieve symptoms of allergies, hay fever, and the common cold.");

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, medicineList);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this, HomeActivity.class));
            }
        });

        btnGotocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(BuyMedicineActivity.this,LabCartActivity.class));
            }
        });
    }
}
