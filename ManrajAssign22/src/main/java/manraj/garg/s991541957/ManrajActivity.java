package manraj.garg.s991541957;
/*
Manraj Garg s991541957
This is assignment 2
 */

import androidx.appcompat.app.AppCompatActivity;

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
                CharSequence text = "www.google.ca";
                int duration = Toast.LENGTH_LONG;

                Toast toast = Toast.makeText(context, text, duration);
                toast.show();

                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.google.ca"));
                startActivity(intent);
                break;
            case R.id.pizza1:
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.pizzapizza.ca"));
                startActivity(intent);
                break;
            case R.id.pizza2:
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.dominos.ca"));
                startActivity(intent);
                break;
            case R.id.pizza3:
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("https://www.littlecaesars.ca"));
                startActivity(intent);
                break;
            case R.id.custom:
                intent = new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://www.bigboxpizza.ca"));
                startActivity(intent);
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }

    public void callIntent(View view) {

        RadioGroup group = (RadioGroup)findViewById(R.id.radioGroup);

        Intent intent = null;
        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.nextBtn:
                if(group.getCheckedRadioButtonId() == R.id.radio_pizza)
                {
                    intent = new Intent(this, GargActivity1.class);
                    TextView textView = (TextView) findViewById(R.id.radio_pizza);
                    String message =textView.getText().toString();
                    intent.putExtra(msg, message);
                    intent.putExtra("imageView", R.drawable.pizzapizza);
                    startActivity(intent);
                }
                else if(group.getCheckedRadioButtonId() == R.id.radio_dominos)
                {
                    intent = new Intent(this, GargActivity1.class);
                    TextView textView = (TextView) findViewById(R.id.radio_dominos);
                    String message =textView.getText().toString();
                    intent.putExtra(msg, message);
                    intent.putExtra("imageView", R.drawable.dominos);
                    startActivity(intent);
                }
                else
                {
                    intent = new Intent(this, GargActivity1.class);
                    TextView textView = (TextView) findViewById(R.id.radio_ceasars);
                    String message =textView.getText().toString();
                    intent.putExtra(msg, message);
                    intent.putExtra("imageView", R.drawable.littleceasers);
                    startActivity(intent);
                }
            default:
                break;
        }
    }

}