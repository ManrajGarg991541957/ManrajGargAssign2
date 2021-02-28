package manraj.garg.s991541957;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.text.BreakIterator;
import java.util.ArrayList;

public class GargActivity2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garg2);

        Intent intent = getIntent();

        String message = intent.getStringExtra(GargActivity1.msg);
        TextView textView = findViewById(R.id.manrajSelectedSize);
        textView.setText(message);

        String message2 = intent.getStringExtra(GargActivity1.msg2);
        TextView textView2 = findViewById(R.id.manrajSelectedStyle);
        textView2.setText(message2);


        textView = findViewById(R.id.manrajSelectedToppings);
        ArrayList<String> numbersList = (ArrayList<String>) getIntent().getSerializableExtra("toppings");
        textView.setText(String.valueOf(numbersList));

        Spinner spinner = findViewById(R.id.manrajSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.provinces, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText( parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}