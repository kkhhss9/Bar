package org.techtown.navigation;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

//import com.google.firebase.database.DatabaseReference;
//import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Register_Food extends AppCompatActivity {

    ImageButton register;

    ArrayAdapter<CharSequence> adspin0, adspin1, adspin2, adspin3;
    String choice_do="";
    String choice_se="";
    TextView txtmsg, txtNow;
    Button btnRec, btnnow;

    long mNow;
    Date mDate;
    SimpleDateFormat mFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register__food);
        txtmsg = findViewById(R.id.textView);
        register = findViewById(R.id.btn_finish);
        btnRec = findViewById(R.id.btnRec);
        txtNow = findViewById(R.id.txtNow);
        btnnow = findViewById(R.id.btnnow);

        final Spinner spnper = (Spinner)findViewById(R.id.spnPer);
        final Spinner spnfood = (Spinner)findViewById(R.id.spnFood);
        final Spinner spnfood2 = (Spinner)findViewById(R.id.spnFood2);

        adspin0 = ArrayAdapter.createFromResource(this, R.array.name, android.R.layout.simple_spinner_dropdown_item);
        adspin1 = ArrayAdapter.createFromResource(this, R.array.spinner_do, android.R.layout.simple_spinner_dropdown_item);
        adspin1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        adspin2 = ArrayAdapter.createFromResource(org.techtown.navigation.Register_Food.this, R.array.spinner_do_g, android.R.layout.simple_spinner_dropdown_item);
        adspin3 = ArrayAdapter.createFromResource(org.techtown.navigation.Register_Food.this,R.array.spinner_do_s, android.R.layout.simple_spinner_dropdown_item);
        spnfood.setAdapter(adspin1);


        ArrayAdapter PerAdapter = ArrayAdapter.createFromResource(this,
                R.array.name, android.R.layout.simple_spinner_item);
        PerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnper.setAdapter(PerAdapter);

        spnfood.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if (adspin1.getItem(i).equals("?????? ??????")) {
                    choice_do = "?????? ??????";
                    adspin2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spnfood2.setAdapter(adspin2);
                    spnfood2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            choice_se = adspin2.getItem(i).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                } else if (adspin1.getItem(i).equals("?????? ??????")) {
                    choice_do = "?????? ??????";
                    adspin3 = ArrayAdapter.createFromResource(org.techtown.navigation.Register_Food.this, R.array.spinner_do_s, android.R.layout.simple_spinner_dropdown_item);
                    adspin3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                    spnfood2.setAdapter(adspin3);
                    spnfood2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                        @Override
                        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                            choice_se = adspin3.getItem(i).toString();
                        }

                        @Override
                        public void onNothingSelected(AdapterView<?> adapterView) {
                        }
                    });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });

        btnRec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(org.techtown.navigation.Register_Food.this);
                builder.setTitle("?????? ?????????");
                builder.setMessage("??????~3?????? : ???????????? 7% \n 3??????~6?????? : ???????????? 5~7% \n 6??????~12?????? : ???????????? 4~5% \n 12?????? ?????? : ???????????? 2~3%");
                builder.setNeutralButton("??????",null);
                builder.create().show();
            }
        });

        btnnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtNow.setText(getTime());
            }
        });


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                txtmsg.setText("????????? ??? ?????? ?????? ??????!");

                //??? ?????? ??????
                /*FirebaseDatabase firebaseDatabase= FirebaseDatabase.getInstance();
                DatabaseReference rootRef= firebaseDatabase.getReference("Family Pet");

                String person = spnper.getSelectedItem().toString(); //??????
                String now = txtNow.getText().toString(); //??????
                String food1 = spnfood.getSelectedItem().toString();//?????????1
                String food2 = spnfood2.getSelectedItem().toString();//?????????2

                Food food = new Food(person, now, food1, food2);

                DatabaseReference foodRef = rootRef.child("food");
                foodRef.push().setValue(food);*/
            }
        });
    }

    private String  getTime() {
        long mNow = System.currentTimeMillis();
        Date mDate = new Date(mNow);
        return mFormat.format(mDate);
    }
}