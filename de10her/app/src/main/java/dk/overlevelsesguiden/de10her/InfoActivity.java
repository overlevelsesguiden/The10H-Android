package dk.overlevelsesguiden.de10her;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;

public class InfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
    }

    public void goBackToMainActivity(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}