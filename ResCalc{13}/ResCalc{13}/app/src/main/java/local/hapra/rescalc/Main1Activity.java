package local.hapra.rescalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;

public class Main1Activity extends AppCompatActivity {

    int position;

    Spinner s1;
    Spinner s2;
    Spinner s3;
    Spinner s4;

    EditText et1;
    EditText et2;
    EditText et3;
    EditText et4;



    int sp1[] = {1,2,3,4,5,6,7,8,9};
    int sp2[] = {0,1,2,3,4,5,6,7,8,9};
    double sp3[] = {0.01,0.1,1,10,100,1,10,100,1,10,100,1};
    float sp4[] = {10,5,1,2,0.5f,0.25f,0.1f,0.05f};

    String t1;
    String t2;
    double res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main1);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Back");

        et1 = (EditText) findViewById(R.id.et1);
        et1.setEnabled(false);
        et2 = (EditText) findViewById(R.id.et2);
        et2.setEnabled(false);
        et3 = (EditText) findViewById(R.id.et3);
        et3.setEnabled(false);
        et4 = (EditText) findViewById(R.id.et4);
        et4.setEnabled(false);

        s1 = (Spinner) findViewById(R.id.c1);

        s2 = (Spinner) findViewById(R.id.c2);
        s3 = (Spinner) findViewById(R.id.c3);
        s4 = (Spinner) findViewById(R.id.c4);
        ArrayAdapter<CharSequence> a1 =
                ArrayAdapter.createFromResource(this,R.array.operation1,
                        android.R.layout.simple_spinner_dropdown_item);
        a1.setDropDownViewResource(android.R.layout.
                simple_spinner_dropdown_item);

        ArrayAdapter<CharSequence> a2 =
                ArrayAdapter.createFromResource(this,R.array.operation,
                        android.R.layout.simple_spinner_dropdown_item);
        a2.setDropDownViewResource(android.R.layout.
                simple_spinner_dropdown_item);

        ArrayAdapter<CharSequence> a3 =
                ArrayAdapter.createFromResource(this,R.array.operation2,
                        android.R.layout.simple_spinner_dropdown_item);
        a3.setDropDownViewResource(android.R.layout.
                simple_spinner_dropdown_item);

        ArrayAdapter<CharSequence> a4 =
                ArrayAdapter.createFromResource(this,R.array.operation3,
                        android.R.layout.simple_spinner_dropdown_item);
        a4.setDropDownViewResource(android.R.layout.
                simple_spinner_dropdown_item);

        s1.setAdapter(a1);

        s1.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                position = s1.getSelectedItemPosition();
                et1.setText(sp1[position]+"");

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        s2.setAdapter(a2);
        s2.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                position = s2.getSelectedItemPosition();
                et2.setText(sp2[position]+"");

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        s3.setAdapter(a3);
        s3.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                position = s3.getSelectedItemPosition();
                et3.setText(sp3[position]+"");

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        s4.setAdapter(a4);
        s4.setOnItemSelectedListener(new OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                position = s4.getSelectedItemPosition();
                et4.setText(sp4[position]+"");

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    public void calc(View view){

        TextView tw1 = (TextView)findViewById(R.id.tw1);
        TextView tw2 = (TextView)findViewById(R.id.tw2);
        t1 = et1.getText().toString() + et2.getText().toString();
        t2 = et3.getText().toString();
        res = Double.parseDouble(t1) * Double.parseDouble(t2);
        if(s3.getSelectedItemPosition()>=0 && s3.getSelectedItemPosition()<=4)
        tw1.setText("Widerstandswert: "+res+"Ω");
        else if(s3.getSelectedItemPosition()>=5 && s3.getSelectedItemPosition()<=7)
            tw1.setText("Widerstandswert: "+res+"kΩ");
        else if(s3.getSelectedItemPosition()>=8 && s3.getSelectedItemPosition()<=10)
            tw1.setText("Widerstandswert: "+res+"MΩ");
        else
            tw1.setText("Widerstandswert: "+res+"GΩ");

        tw2.setText("Toleranz: ±"+et4.getText()+"%");

    }

}
