package com.example.healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


public class FindDoctorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_doctor);

        CardView exit= findViewById(R.id.cardexit);
        exit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                startActivity(new Intent(FindDoctorActivity.this,HomeActivity.class));
            }
        });

        CardView familyphysician= findViewById(R.id.FDFamilyPhysician);
        familyphysician.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
                it.putExtra("title", "Family Physician");
                startActivity(it);
            }
    });
            CardView diet= findViewById(R.id.FDDietician);
                    diet.setOnClickListener(new View.OnClickListener(){
                        @Override
                        public void onClick(View view) {
                            Intent it = new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
                            it.putExtra("title", "Dietician");
                            startActivity(it);
                        }
                        });


                CardView dentist= findViewById(R.id.cardFDDentist);
                        dentist.setOnClickListener(new View.OnClickListener(){
                            @Override
                            public void onClick(View view) {
                                Intent it = new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
                                it.putExtra("title", "DENTIST");
                                startActivity(it);
                            }
                            });


                            CardView Surgeon= findViewById(R.id.cardFDSurgeon);
                                    Surgeon.setOnClickListener(new View.OnClickListener(){
                                        @Override
                                        public void onClick(View view) {
                                            Intent it = new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
                                            it.putExtra("title", "Surgeon");
                                            startActivity(it);
                                        }
                                        });
                                CardView Cardio= findViewById(R.id.FDCardiologist);
                                        Cardio.setOnClickListener(new View.OnClickListener(){
                                            @Override
                                            public void onClick(View view) {
                                                Intent it = new Intent(FindDoctorActivity.this, DoctorDetailsActivity.class);
                                                it.putExtra("title", "cardiologist");
                                                startActivity(it);
                                            }
                                            });
         }
    }