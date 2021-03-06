package com.example.thomas.cacalculator;

/**
 * Created by Thomas on 20/02/2017.
 */
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity
{
    EditText firstPercent;
    EditText secondPercent;

    TextView answer;

    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);

        firstPercent = (EditText) findViewById(R.id.firstMark);
        firstPercent.setFilters(new InputFilter[] { new InputFilter.LengthFilter(2)});

        secondPercent = (EditText) findViewById(R.id.secondMark);
        secondPercent.setFilters(new InputFilter[] { new InputFilter.LengthFilter(2)});

        firstPercent.addTextChangedListener(new TextWatcher()
        {
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
                // TODO Auto-generated method stub
            }

            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                if (!String.valueOf(firstPercent.getText()).equals("") && !String.valueOf(secondPercent.getText()).equals("") && !String.valueOf(firstPercent.getText()).equals(".") && !String.valueOf(secondPercent.getText()).equals("."))
                {
                    calculate();
                }
            }

            public void afterTextChanged(Editable s)
            {
                // TODO Auto-generated method stub
            }
        });

        secondPercent.addTextChangedListener(new TextWatcher()
        {
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {
                // TODO Auto-generated method stub
            }

            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                if (!String.valueOf(firstPercent.getText()).equals("") && !String.valueOf(secondPercent.getText()).equals("") && !String.valueOf(firstPercent.getText()).equals(".") && !String.valueOf(secondPercent.getText()).equals("."))
                {
                    calculate();
                }
            }

            public void afterTextChanged(Editable s)
            {
                // TODO Auto-generated method stub
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement

        switch (id)
        {
            case R.id.item1:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;
            case R.id.item2:
                Intent intent2 = new Intent(this, ThirdActivity.class);
                startActivity(intent2);
                return true;
            default:
        }

        return super.onOptionsItemSelected(item);
    }

    public void calculate()
    {
        boolean possible = true;

        answer = (TextView) findViewById(R.id.answer);

        float result = (Float.parseFloat(String.valueOf(firstPercent.getText())) / 100) * Float.parseFloat(String.valueOf(secondPercent.getText()));

        if (Float.parseFloat(String.valueOf(firstPercent.getText())) > Float.parseFloat(String.valueOf(secondPercent.getText())))
        {
            possible = false;
        }

        if (result <= 100 && possible)
        {
            answer.setText(String.valueOf(Math.round(result * 100.0) / 100.0) + "%");
        }
        else
        {
            answer.setText("Not Possible");
        }
    }
}
