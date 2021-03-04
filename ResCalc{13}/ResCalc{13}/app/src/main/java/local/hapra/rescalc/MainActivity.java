package local.hapra.rescalc;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView w1 = (TextView) findViewById(R.id.textView);
        w1.setGravity(Gravity.CENTER);

        w1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent numbersIntent = new Intent(MainActivity.this, Main1Activity.class);


                startActivity(numbersIntent);
            }
        });

        TextView w2 = (TextView) findViewById(R.id.textView2);
        w2.setGravity(Gravity.CENTER);

        w2.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {
                Intent numbersIntent = new Intent(MainActivity.this, Main2Activity.class);


                startActivity(numbersIntent);
            }
        });

        TextView w3 = (TextView) findViewById(R.id.textView3);
        w3.setGravity(Gravity.CENTER);

        w3.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the numbers category is clicked on.
            @Override
            public void onClick(View view) {

                Intent numbersIntent = new Intent(MainActivity.this, Main3Activity.class);


                startActivity(numbersIntent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        boolean result = super.onCreateOptionsMenu(menu);
        MenuInflater mi = getMenuInflater();
        mi.inflate(R.menu.menu_calc, menu);
        return result;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.exit:
                new AlertDialog.Builder(this)
                        .setTitle(R.string.exitConfirmTitle)
                        .setMessage(R.string.exitConfirmText)
                        .setPositiveButton("OK", new
                                DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int
                                            which) {
                                        finish();
                                    }
                                })
                        .setNegativeButton ("Cancel", new
                                DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog,int
                                            which) {
                                        finish();
                                    }
                                })
                        .show();
        }
        return true;
    }

}
