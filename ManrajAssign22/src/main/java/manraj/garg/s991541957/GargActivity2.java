/*
Manraj Garg s991541957
This is assignment 2 it is a pizza ordering application built for android devices
 */
package manraj.garg.s991541957;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.text.BreakIterator;
import java.util.ArrayList;

public class GargActivity2 extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garg2);

        Intent intent = getIntent();

        String message = intent.getStringExtra("msg");
        TextView textView = findViewById(R.id.manrajSelectedSize);
        textView.setText(message);

        String message2 = intent.getStringExtra("msg2");
        TextView textView2 = findViewById(R.id.manrajSelectedStyle);
        textView2.setText(message2);

        textView = findViewById(R.id.manrajSelectedToppings);
        ArrayList<String> numbersList = (ArrayList<String>) getIntent().getSerializableExtra("toppings");
        textView.setText(String.valueOf(numbersList));

        spinner = findViewById(R.id.manrajSpinner);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.provinces, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void CheckOutScreen(View view) {
        Intent intent = new Intent(this, GargActivity3.class);
        EditText nameText = (EditText)findViewById(R.id.manrajETName);
        EditText creditText = (EditText)findViewById(R.id.manrajETCredit);
        EditText addressText = (EditText)findViewById(R.id.manrajETAddress);
        EditText phoneText = (EditText)findViewById(R.id.manrajETPhone);
        TextView selectedTextView = (TextView)spinner.getSelectedView();

        final String selectedProvince = selectedTextView.getText().toString();
        final String name = nameText.getText().toString();
        final String credit = creditText.getText().toString();
        final String phone = phoneText.getText().toString();
        final String address = addressText.getText().toString();

        if (validName(nameText) && validCredit(creditText) && validPhone(phoneText) && validAddress(addressText))
        {
            intent.putExtra("nameText", name);
            intent.putExtra("creditText", credit);
            intent.putExtra("phoneText", phone);
            intent.putExtra("addressText", address);
            intent.putExtra("selectedProvince", selectedProvince);
            intent.putExtra("topping", getIntent().getSerializableExtra("toppings"));
            intent.putExtra("size", getIntent().getStringExtra("msg"));
            intent.putExtra("type", getIntent().getStringExtra("msg2"));
            startActivity(intent);
        }

    }

    public boolean validName(EditText editTextName) {
        editTextName = (EditText) findViewById(R.id.manrajETName);
        String name = editTextName.getText().toString();
        //validate name input
        if (name.length() == 0) {
            editTextName.setError(getString(R.string.blankField));
            return false;
        } else if (name.length() < 3 || name.length() > 20) {
            editTextName.setError(getString(R.string.error1));
            return false;
        } else if (!name.matches("[a-zA-Z]+")) {
            editTextName.setError(getString(R.string.error2));
            return false;
        }
            return true;
    }

    public boolean validCredit(EditText editTextCredit)
    {
        editTextCredit = (EditText) findViewById(R.id.manrajETCredit);
        String credit = editTextCredit.getText().toString();
        //validate credit input
        if (credit.length() == 0) {
            editTextCredit.setError(getString(R.string.blankField));
            return false;
        } else if (credit.length() != 16) {
            editTextCredit.setError(getString(R.string.error5));
            return false;
        } else if (!credit.matches("^[0-9]*$")) {
            editTextCredit.setError(getString(R.string.error6));
            return false;
        }
        return true;
    }

    public boolean validAddress(EditText editTextAddress)
    {
        editTextAddress = (EditText) findViewById(R.id.manrajETAddress);
        //validate address input
        if (editTextAddress.getText().toString().length() == 0) {
            editTextAddress.setError(getString(R.string.blankField));
            return false;
        }
        return true;
    }

    public boolean validPhone(EditText editTextPhone)
    {
        editTextPhone = (EditText) findViewById(R.id.manrajETPhone);
        //validate phone input
        if (editTextPhone.getText().toString().length() == 0) {
            editTextPhone.setError(getString(R.string.blankField));
            return false;
        } else if (editTextPhone.getText().toString().length() != 10) {
            editTextPhone.setError(getString(R.string.error3));
            return false;
        } else if (!editTextPhone.getText().toString().matches("^[0-9]*$")) {
            editTextPhone.setError(getString(R.string.error4));
            return false;
        }
        return true;
    }

}