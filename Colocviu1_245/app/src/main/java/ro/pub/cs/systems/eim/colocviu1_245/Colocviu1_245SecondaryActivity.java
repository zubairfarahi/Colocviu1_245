package ro.pub.cs.systems.eim.colocviu1_245;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Colocviu1_245SecondaryActivity extends AppCompatActivity {
    int value = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Intent intent = getIntent();
        String take = intent.getStringExtra("Term");
        value = Integer.parseInt(take);
        int result = sumAll();
        setResult(result);
        finish();
    }

    public int sumAll(){
        int sum = 0;
        int a[] = new int[value];
        for(int i=0;i<value;i++)
        {
            a[i] = i;
        }
        for (int i = 0; i < value; i++) {
                sum += a[i];
        }
        System.out.println(sum);
        return sum;
    }


}
