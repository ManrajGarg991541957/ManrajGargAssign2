/*
Manraj Garg s991541957
This is assignment 2 it is a pizza ordering application built for android devices
 */
package manraj.garg.s991541957;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class GargActivity1 extends AppCompatActivity {

    final Context context = this;
    RadioButton selectedRadioButton;
    RadioButton selectedRadioButton2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garg1);

        Bundle extras = getIntent().getExtras();
        if (extras == null) {
            return;
        }
        int res = extras.getInt(getString(R.string.imageView));
        ImageView view = (ImageView) findViewById(R.id.manrajImage1);
        view.setImageResource(res);
        Intent intent = getIntent();
        String message = intent.getStringExtra(ManrajActivity.msg);
        TextView textView = findViewById(R.id.manrajSelectedStore);
        textView.setText(message);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }



    public void paymentScreen(View view) {
        Intent intent = null;
        ArrayList<String> toppings = new ArrayList<String>();
        RadioGroup typeGroup = (RadioGroup) findViewById(R.id.manrajTypeGroup);
        RadioGroup sizeGroup = (RadioGroup) findViewById(R.id.manrajSizeGroup);
        CheckBox chickenBox = (CheckBox) findViewById(R.id.manrajChicken);
        CheckBox tomatoBox = (CheckBox) findViewById(R.id.manrajTomato);
        CheckBox onionBox = (CheckBox) findViewById(R.id.manrajOnion);
        CheckBox mushBox = (CheckBox) findViewById(R.id.manrajMush);
        CheckBox gpBox = (CheckBox) findViewById(R.id.manrajGp);
        CheckBox pepBox = (CheckBox) findViewById(R.id.manrajPep);


        if (chickenBox.isChecked()) {
            toppings.add(getString(R.string.Chicken));
        }
        if (tomatoBox.isChecked()) {
            toppings.add(getString(R.string.Tomato));
        }
        if (onionBox.isChecked()) {
            toppings.add(getString(R.string.Onion));
        }
        if (mushBox.isChecked()) {
            toppings.add(getString(R.string.Mushroom));
        }
        if (gpBox.isChecked()) {
            toppings.add(getString(R.string.GreenPeppers));
        }
        if (pepBox.isChecked()) {
            toppings.add(getString(R.string.Pep));
        }

        if (typeGroup.getCheckedRadioButtonId() == -1 || sizeGroup.getCheckedRadioButtonId() == -1 || toppings.isEmpty()) {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
            alertDialogBuilder.setTitle(R.string.alertTitle);
            alertDialogBuilder
                    .setMessage("Click OK to exit")
                    .setCancelable(false)
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            Toast.makeText(getApplicationContext(), "Please fill out form",
                                    Toast.LENGTH_LONG).show();
                        }
                    });
            // create alert dialog
            AlertDialog alertDialog = alertDialogBuilder.create();
            // show it
            alertDialog.show();
        } else {
            intent = new Intent(this, GargActivity2.class);

            int selectedRadioButtonId = sizeGroup.getCheckedRadioButtonId();
            selectedRadioButton = findViewById(selectedRadioButtonId);
            String selectedRbText = selectedRadioButton.getText().toString();
            intent.putExtra("msg", selectedRbText);

            int selectedRadioButtonId2 = typeGroup.getCheckedRadioButtonId();
            selectedRadioButton2 = findViewById(selectedRadioButtonId2);
            String selectedRbText2 = selectedRadioButton2.getText().toString();
            intent.putExtra("msg2", selectedRbText2);

            intent.putExtra("toppings", toppings);
            startActivity(intent);
        }
    }
}
