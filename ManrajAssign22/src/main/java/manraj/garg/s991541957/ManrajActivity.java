/*
Manraj Garg s991541957
This is assignment 2 it is a pizza ordering application built for android devices
 */
package manraj.garg.s991541957;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class ManrajActivity extends AppCompatActivity {

    public static final String msg="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);
        return true;
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        Intent intent = null;
        switch (item.getItemId()) {
            case R.id.help:

                Context context = getApplicationContext();
                CharSequence text = getString(R.string.google);
                int duration = Toast.LENGTH_LONG;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(getString(R.string.google1)));
                startActivity(intent);
                break;
            case R.id.pizza1:
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(getString(R.string.PizzaPizza)));
                startActivity(intent);
                break;
            case R.id.pizza2:
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(getString(R.string.Dominos)));
                startActivity(intent);
                break;
            case R.id.pizza3:
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(getString(R.string.LittleCaesars)));
                startActivity(intent);
                break;
            case R.id.custom:
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse(getString(R.string.BigBox)));
                startActivity(intent);
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    public void callIntent(View view) {

        RadioGroup group = (RadioGroup)findViewById(R.id.manrajRadioGroup);

        Intent intent = null;
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.manrajNextBtn:
                if(group.getCheckedRadioButtonId() == R.id.manrajRadio_pizza)
                {
                    intent = new Intent(this, GargActivity1.class);
                    TextView textView = (TextView) findViewById(R.id.manrajRadio_pizza);
                    String message =textView.getText().toString();
                    intent.putExtra(msg, message);
                    intent.putExtra(getString(R.string.imageView), R.drawable.pizzapizza);
                    startActivity(intent);
                }
                else if(group.getCheckedRadioButtonId() == R.id.manrajRadio_dominos)
                {
                    intent = new Intent(this, GargActivity1.class);
                    TextView textView = (TextView) findViewById(R.id.manrajRadio_dominos);
                    String message =textView.getText().toString();
                    intent.putExtra(msg, message);
                    intent.putExtra(getString(R.string.imageView), R.drawable.dominos);
                    startActivity(intent);
                }
                else
                {
                    intent = new Intent(this, GargActivity1.class);
                    TextView textView = (TextView) findViewById(R.id.manrajRadio_ceasars);
                    String message =textView.getText().toString();
                    intent.putExtra(msg, message);
                    intent.putExtra(getString(R.string.imageView), R.drawable.littleceasers);
                    startActivity(intent);
                }
            default:
                break;
        }
    }

}