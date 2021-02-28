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
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void CheckOutScreen(View view) {
        Intent intent = null;
        EditText nameText = (EditText)findViewById(R.id.manrajETName);
        EditText creditText = (EditText)findViewById(R.id.manrajETCredit);
        EditText addressText = (EditText)findViewById(R.id.manrajETAddress);
        EditText phoneText = (EditText)findViewById(R.id.manrajETPhone);

        final String name = nameText.getText().toString();
        final String credit = creditText.getText().toString();
        final String phone = phoneText.getText().toString();
        final String address = addressText.getText().toString();

        if (validName(nameText))
        {
            getIntent().putExtra("nameText", name);
        }
        if(validCredit(creditText))
        {
            getIntent().putExtra("creditText", credit);
        }
        if(validPhone(phoneText))
        {
            getIntent().putExtra("phoneText", phone);
        }
        if(validAddress(addressText))
        {
            getIntent().putExtra("addressText", address);
        }
        startActivity(intent);
    }

    public boolean validName(EditText editTextName) {
        editTextName = (EditText) findViewById(R.id.manrajETName);
        String name = editTextName.getText().toString();
        //validate name input
        if (name.length() == 0) {
            editTextName.setError("This Field cannot be blank");
        } else if (name.length() < 3 || name.length() > 20) {
            editTextName.setError("Name must be between 3-20 characters");
        } else if (!name.matches("[a-zA-Z]+")) {
            editTextName.setError("Name should only contain alphebetical characters");
        }
            return true;
    }

    public boolean validCredit(EditText editTextCredit)
    {
        editTextCredit = (EditText) findViewById(R.id.manrajETCredit);
        String credit = editTextCredit.getText().toString();
        //validate credit input
        if (credit.length() == 0) {
            editTextCredit.setError("This Field cannot be blank");
        } else if (credit.length() == 16) {
            editTextCredit.setError("Credit card must contain only numbers and be 16 digits long");
        } else if (!credit.matches("^[0-9]*$")) {
            editTextCredit.setError("Credit card must contain only numbers");
        }
        return true;
    }

    public boolean validAddress(EditText editTextAddress)
    {
        editTextAddress = (EditText) findViewById(R.id.manrajETAddress);
        //validate address input
        if (editTextAddress.getText().toString().length() == 0) {
            editTextAddress.setError("This Field cannot be blank");
        }
        return true;
    }

    public boolean validPhone(EditText editTextPhone)
    {
        editTextPhone = (EditText) findViewById(R.id.manrajETPhone);
        //validate phone input
        if (editTextPhone.getText().toString().length() == 0) {
            editTextPhone.setError("This Field cannot be blank");
        } else if (editTextPhone.getText().toString().length() != 10) {
            editTextPhone.setError("Phone must be 10 characters in length");
        } else if (!editTextPhone.getText().toString().matches("^[0-9]*$")) {
            editTextPhone.setError("Phone number must contain only numbers");
        }
        return true;
    }

}