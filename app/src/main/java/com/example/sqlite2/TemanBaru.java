package com.example.sqlite2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.sqlite2.database.DBController;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;

public class TemanBaru extends AppCompatActivity {

    private TextInputEditText tNama, tTelpon;
    private Button Simpanbtn;
    String nm, tlp;

    DBController kendaliDatabase = new DBController(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_teman_baru);

        tNama = (TextInputEditText) findViewById(R.id.tietNama);
        tTelpon = (TextInputEditText) findViewById(R.id.tietTelpon);
        Simpanbtn = (Button) findViewById(R.id.buttonSave);

        Simpanbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(tNama.getText().toString().equals("")||tTelpon.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(), "Data belum lengkap", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    nm = tNama.getText().toString();
                    tlp = tTelpon.getText().toString();

                    HashMap<String,String> dataKirim = new HashMap<>();
                    dataKirim.put("nama", nm);
                    dataKirim.put("telepon", tlp);

                    kendaliDatabase.tambahData(dataKirim);
                    callHome();


                }
            }
        });
    }

    public void callHome(){
        Intent in = new Intent(TemanBaru.this,MainActivity.class);
        startActivity(in);
        finish();
    }
}
