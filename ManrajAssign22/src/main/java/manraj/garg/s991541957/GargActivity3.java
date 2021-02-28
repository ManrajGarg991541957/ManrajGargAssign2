/*
Manraj Garg s991541957
This is assignment 2 it is a pizza ordering application built for android devices
 */
package manraj.garg.s991541957;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;
import org.w3c.dom.Text;

import java.util.Calendar;
import java.util.Date;

public class GargActivity3 extends AppCompatActivity {

    final Context context = this;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garg3);

        Intent intent = getIntent();

        String name = intent.getStringExtra("nameText");
        TextView textView = findViewById(R.id.manrajDisplayName);
        textView.setText(name);

        String credit = intent.getStringExtra("creditText");
        TextView textView2 = findViewById(R.id.manrajDisplayCredit);
        textView2.setText(credit);

        String address = intent.getStringExtra("addressText");
        TextView textView3 = findViewById(R.id.manrajDisplayAddress);
        textView3.setText(address);

        String phone = intent.getStringExtra("phoneText");
        TextView textView4 = findViewById(R.id.manrajDisplayPhone);
        textView4.setText(phone);

        String spinner = intent.getStringExtra("selectedProvince");
        TextView textView5 = findViewById(R.id.manrajDisplaySpinner);
        textView5.setText(spinner);

        String toppings = intent.getSerializableExtra("topping").toString();
        TextView textView6 = findViewById(R.id.manrajDisplayTopping);
        textView6.setText(toppings);

        String size = intent.getStringExtra("size");
        TextView textView7 = findViewById(R.id.manrajDisplaySize);
        textView7.setText(size);

        String style = intent.getStringExtra("type");
        TextView textView8 = findViewById(R.id.manrajDisplayStyle);
        textView8.setText(style);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void HomeScreen(View view)
    {
        Date currentTime = Calendar.getInstance().getTime();
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
        alertDialogBuilder.setTitle(getString(R.string.alertPart1));
        alertDialogBuilder
                .setMessage(getString(R.string.returnHome) + getString(R.string.alertPart2) + currentTime + getString(R.string.alertPart3))
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent intent = new Intent(context, ManrajActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        context.startActivity(intent);
                    }
                });
        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();
        // show it
        alertDialog.show();
    }
}