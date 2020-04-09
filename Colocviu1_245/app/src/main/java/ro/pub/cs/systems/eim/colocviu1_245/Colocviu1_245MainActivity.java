package ro.pub.cs.systems.eim.colocviu1_245;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;

public class Colocviu1_245MainActivity extends AppCompatActivity {

    private EditText editText;
    private TextView textView;
    private int num = 0;
    private int sum = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colocviu1_245_main);
        editText = (EditText) findViewById(R.id.editText);
        textView = (TextView) findViewById(R.id.textView);

    }


    public void addFun(View view) {
        String value= editText.getText().toString();
        textView.setText("");
        num = Integer.parseInt(value);
        if(editText != null) {
            for (int i = 1; i <= num; i++) {
                textView.append(Integer.toString(i));
                textView.append(" + ");
            }
        }else if(editText == null)
        {
            textView.setText("");
        }

    }

    public void nextActivity(View view) {
        Intent intent = new Intent(this,Colocviu1_245SecondaryActivity.class);
        intent.putExtra("Term",Integer.toString(num));
        startActivityForResult(intent,50);

        Toast.makeText(getApplicationContext(), "result " + sum, Toast.LENGTH_LONG).show();
    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        super.onActivityResult(requestCode, resultCode, intent);
        if (requestCode == 50) {
            Toast.makeText(this, "result: " + resultCode, Toast.LENGTH_LONG).show();
            sum = resultCode;
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("f1", sum);

    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent in = getIntent();
        Toast.makeText(getApplicationContext(),sum+"",Toast.LENGTH_LONG).show();
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if (savedInstanceState != null) {
            sum = savedInstanceState.getInt("f1");
        }
    }
}
