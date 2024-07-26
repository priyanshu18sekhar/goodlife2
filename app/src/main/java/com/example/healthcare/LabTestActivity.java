package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity {

    private String[][] packages = {
            {"Package 1: Full Body CheckUp", "", "", "999"},
            {"Package 2: Body Glucose Fasting", "", "", "299"},
            {"Package 3: Covid 19 Antibody", "", "", "899"},
            {"Package 4: Thyroid Check", "", "", "499"},
            {"Package 5: Immunity Check", "", "", "699"}
    };

    private String[] package_details = {
            "Body Glucose Fasting\n" +
                    "Complete Hemogram\n" +
                    "HbA1c\n" +
                    "Iron Studies\n" +
                    "Kidney Function Test\n" +
                    "Lipid Profile\n" +
                    "Liver Function Test",
            "Body Glucose Fasting",
            "Covid-19 Antibody",
            "Thyroid Profile-Total(T3,T4,TSH US)",
            "Complete Hemogram\n" +
                    "CRP Quantitative Serum\n" +
                    "Iron Studies\n" +
                    "Kidney Function Test\n" +
                    "Vitamin-D total Hydroxy\n" +
                    "Liver Function Test\n" +
                    "Lipid profile"
    };

    ArrayList<HashMap<String, String>> list;
    SimpleAdapter sa;
    Button btnGotocart, btnBack;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);

        btnGotocart = findViewById(R.id.buttonBMGotocart);
        btnBack = findViewById(R.id.buttonBMback);
        listView = findViewById(R.id.ListViewBM);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestActivity.this, HomeActivity.class));
            }
        });

        list = new ArrayList<>();
        for (int i = 0; i < packages.length; i++) {
            HashMap<String, String> item = new HashMap<>();
            item.put("line1", packages[i][0]);
            item.put("line2", package_details[i]);
            item.put("line3", "");
            item.put("line4", "");
            item.put("line5", "Total cost: " + packages[i][3] + "Rs");
            list.add(item);
        }

        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e}
        );
        listView.setAdapter(sa);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(LabTestActivity.this, LabTestDetailsActivity.class);
                it.putExtra("text1", packages[i][0]);
                it.putExtra("text2", package_details[i]);
                it.putExtra("text3", packages[i][3]);
                startActivity(it);
            }
        });

        btnGotocart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(LabTestActivity.this,LabCartActivity.class));
            }
        });
    }
}
