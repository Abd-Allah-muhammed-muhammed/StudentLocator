package com.example.studentlocator;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import cn.pedant.SweetAlert.SweetAlertDialog;

import static com.example.studentlocator.helper.showSweetDialog;

public class LoginActivity extends AppCompatActivity {
    Button button;
    EditText id_tv;
    private boolean ok = false;

    private List<String> idsList = new ArrayList<>();
    private int requestcode = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        button = findViewById(R.id.login_button);
        id_tv = findViewById(R.id.id_student_tv);

checkPermissions();
        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference Id_student = database.getReference("Id_student");

      //  final DatabaseReference materials_DB = database.getReference("materials");

        Id_student.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Iterable<DataSnapshot> children = dataSnapshot.getChildren();
                for (DataSnapshot dataSnapshot1 : children) {
                    String value = String.valueOf(dataSnapshot1.getValue());
                    idsList.add(value);
                    Log.d("tag", "value is : "+dataSnapshot1.getValue());

                }


            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });


//        Materials materials1 = new Materials();
//        materials1.setAccounting("You Are Attended Accounting ");
//        materials1.setData_Base("You Are Attended Data Base");
//        materials1.setOperating_System("You Are Attended Operating System  ");
//        materials1.setNetworking("You Are Attended Networking ");
//        materials_DB.setValue(materials1);
//
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {

                   String id = id_tv.getText().toString().trim();

                if (idsList.contains(id)&&id!=null) {
                    SharedPreferencesManger.SaveData(LoginActivity.this,"id",id);
                    Log.v("LoginActivity:", " student id: " + id_tv.getText().toString());
                    Intent intent = new Intent(LoginActivity.this, ScannerActivity.class);
                    startActivity(intent);
                } else {
                    showSweetDialog(LoginActivity.this, SweetAlertDialog.WARNING_TYPE,"#D42D2C",
                            "WRONG ID",true);
                }


            }

        });

    }

    private void checkPermissions() {

        if (ContextCompat.checkSelfPermission(LoginActivity.this, Manifest.permission.READ_EXTERNAL_STORAGE)
                == PackageManager.PERMISSION_DENIED){
            ActivityCompat.requestPermissions(LoginActivity.this, new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, requestcode);
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        if (grantResults.length>1&&requestCode==requestcode){

        }else {
            checkPermissions();
        }
    }


}
