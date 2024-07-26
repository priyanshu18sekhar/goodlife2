package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

import android.view.View;
public class DoctorDetailsActivity extends AppCompatActivity {
    private String[][] doctor_details1 =
    {
        {"Doctor Name : Ram ratan pandey","Hospital Address : Patna","Exp : 5 years","Mobile No: 9234590801","800"},
        {"Doctor Name : Sinchan panda","Hospital Address : Koraput","Exp : 5 years","Mobile No: 9988696901","950"},
        {"Doctor Name : Abhinash choudary","Hospital Address : Bhubaneswer","Exp : 5 years","Mobile No: 9798647333","700"},
        {"Doctor Name : binayak Pardhan","Hospital Address : Rayagada","Exp : 5 years","Mobile No: 909089796","900"},
        {"Doctor Name : shamit Mishra","Hospital Address : Mumbai","Exp : 5 years","Mobile No: 9089786712","500"}


    };
    private String[][] doctor_details2 =
    {
        {"Doctor Name : Ram ratan pandey","Hospital Address : Patna","Exp : 5 years","Mobile No: 9234590801","800"},
        {"Doctor Name : Sinchan panda","Hospital Address : Koraput","Exp : 5 years","Mobile No: 9988696901","950"},
        {"Doctor Name : Abhinash choudary","Hospital Address : Bhubaneswer","Exp : 5 years","Mobile No: 9798647333","700"},
        {"Doctor Name : binayak Pardhan","Hospital Address : Rayagada","Exp : 5 years","Mobile No: 909089796","900"},
        {"Doctor Name : shamit Mishra","Hospital Address : Mumbai","Exp : 5 years","Mobile No: 9089786712","500"}


    };
    private String[][] doctor_details3 =
    {
        {"Doctor Name : Ram ratan pandey","Hospital Address : Patna","Exp : 5 years","Mobile No: 9234590801","800"},
        {"Doctor Name : Sinchan panda","Hospital Address : Koraput","Exp : 5 years","Mobile No: 9988696901","950"},
        {"Doctor Name : Abhinash choudary","Hospital Address : Bhubaneswer","Exp : 5 years","Mobile No: 9798647333","700"},
        {"Doctor Name : binayak Pardhan","Hospital Address : Rayagada","Exp : 5 years","Mobile No: 909089796","900"},
        {"Doctor Name : shamit Mishra","Hospital Address : Mumbai","Exp : 5 years","Mobile No: 9089786712","500"}


    };
    private String[][] doctor_details4 =
    {
        {"Doctor Name : Ram ratan pandey","Hospital Address : Patna","Exp : 5 years","Mobile No: 9234590801","800"},
        {"Doctor Name : Sinchan panda","Hospital Address : Koraput","Exp : 5 years","Mobile No: 9988696901","950"},
        {"Doctor Name : Abhinash choudary","Hospital Address : Bhubaneswer","Exp : 5 years","Mobile No: 9798647333","700"},
        {"Doctor Name : binayak Pardhan","Hospital Address : Rayagada","Exp : 5 years","Mobile No: 909089796","900"},
        {"Doctor Name : shamit Mishra","Hospital Address : Mumbai","Exp : 5 years","Mobile No: 9089786712","500"}


    };
    private String[][] doctor_details5 =
    {
        {"Doctor Name : Ram ratan pandey","Hospital Address : Patna","Exp : 5 years","Mobile No: 9234590801","800"},
        {"Doctor Name : Sinchan panda","Hospital Address : Koraput","Exp : 5 years","Mobile No: 9988696901","950"},
        {"Doctor Name : Abhinash choudary","Hospital Address : Bhubaneswer","Exp : 5 years","Mobile No: 9798647333","700"},
        {"Doctor Name : binayak Pardhan","Hospital Address : Rayagada","Exp : 5 years","Mobile No: 909089796","900"},
        {"Doctor Name : shamit Mishra","Hospital Address : Mumbai","Exp : 5 years","Mobile No: 9089786712","500"}


    };

    TextView tv;
    Button btn;
    String[][] doctor_details = doctor_details1;
    ArrayList list;
    SimpleAdapter sa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);
        tv= findViewById(R.id.textViewDDName);
       btn= findViewById(R.id.buttonBMGotocart);
        Intent it = getIntent();
        String title = it.getStringExtra("title");
        tv.setText(title);

        if(title.compareTo("Family Physician")==0)
            doctor_details = doctor_details1;
        else if(title.compareTo("Dietician")==0)
        doctor_details = doctor_details2;
        else if(title.compareTo("DENTIST")==0)
                doctor_details = doctor_details3;
        else if(title.compareTo("Surgeon")==0)
            doctor_details = doctor_details4;
        else if(title.compareTo("cardiologist")==0)
            doctor_details = doctor_details5;

       btn.setOnClickListener(new View.OnClickListener(){
           @Override
                   public void onClick(View view){
                startActivity(new Intent(DoctorDetailsActivity.this,FindDoctorActivity.class));
            }
        });
       HashMap<String,String> item;
       list = new ArrayList<>();
       for(int i =0;i<doctor_details.length;i++)
       {
           item = new HashMap<String,String>();
           item.put("line1",doctor_details[i][0]);
           item.put("line2",doctor_details[i][1]);
           item.put("line3",doctor_details[i][2]);
           item.put("line4",doctor_details[i][3]);
           item.put("line5","CONS FEES: "+doctor_details[i][4]+"Rs");
           list.add(item);
       }
       sa = new SimpleAdapter(this,list,
               R.layout.multi_lines,
               new String[]{"line1","line2","line3","line4","line5"},
               new int[]{R.id.line_a,R.id.line_b,R.id.line_c,R.id.line_d,R.id.line_e}
               );
        ListView lst = findViewById(R.id.ListViewBM);
        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent item = new Intent(DoctorDetailsActivity.this,BookAppointmentActivity.class);
                item.putExtra("text1",title);
                item.putExtra("text2",doctor_details[i][0]);
                item.putExtra("text3",doctor_details[i][1]);
                item.putExtra("text4",doctor_details[i][3]);
                item.putExtra("text5",doctor_details[i][4]);
                startActivity(item);
            }
        });
    }
}