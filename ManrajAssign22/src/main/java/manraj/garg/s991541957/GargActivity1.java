package manraj.garg.s991541957;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class GargActivity1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_garg1);
        Bundle extras = getIntent().getExtras();
        if (extras == null)
        {
            return;
        }
        int res = extras.getInt("imageView");
        ImageView view = (ImageView) findViewById(R.id.image1);
        view.setImageResource(res);
        Intent intent = getIntent();
        String message = intent.getStringExtra(ManrajActivity.msg);
        TextView textView = findViewById(R.id.selectedStore);
        textView.setText(message);
    }

    public void callIntent (View view)
    {
        Intent intent = null;

        switch (view.getId()) {
            case R.id.nextBtn:

        }
    }
}