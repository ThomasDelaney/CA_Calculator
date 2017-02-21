package com.example.thomas.cacalculator;

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

public class MainActivity extends AppCompatActivity
{

    EditText firstPercent;
    EditText secondPercent;

    TextView pass;
    TextView twotwo;
    TextView twoone;
    TextView first;

    float totalCA;
    float examTotal;

    float needPass;
    float needTwoTwo;
    float needTwoOne;
    float needFirst;

    float toPass;
    float toTwoTwo;
    float toTwoOne;
    float toFirst;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
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
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
                Intent intent = new Intent(this, SecondActivity.class);
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

    private void calculate()
    {
        boolean possible = true;

        pass = (TextView) findViewById(R.id.pass);
        twotwo = (TextView) findViewById(R.id.twoTwo);
        twoone = (TextView) findViewById(R.id.twoOne);
        first = (TextView) findViewById(R.id.first);

        totalCA = Float.parseFloat(String.valueOf(firstPercent.getText()));
        examTotal = 100-Float.parseFloat(String.valueOf(secondPercent.getText()));

        needPass = 40-totalCA;
        needTwoTwo = 50-totalCA;
        needTwoOne = 60-totalCA;
        needFirst = 70-totalCA;

        toPass = (needPass/examTotal)*100;
        toTwoTwo = (needTwoTwo/examTotal)*100;
        toTwoOne = (needTwoOne/examTotal)*100;
        toFirst = (needFirst/examTotal)*100;

        if (Float.parseFloat(String.valueOf(firstPercent.getText())) > Float.parseFloat(String.valueOf(secondPercent.getText())))
        {
            possible = false;
        }

        if (toPass <= 100 && toPass > 0 && possible)
        {
            pass.setText(String.valueOf(Math.round(toPass * 100.0) / 100.0) + "%");
        }
        else if (toPass <= 0)
        {
            pass.setText("Achieved");
        }
        else
        {
            pass.setText("Not Possible");
        }

        if (toTwoTwo <= 100 && toTwoTwo > 0 && possible)
        {
            twotwo.setText(String.valueOf(Math.round(toTwoTwo * 100.0) / 100.0) + "%");
        }
        else if (toTwoTwo <= 0)
        {
            twotwo.setText("Achieved");
        }
        else
        {
            twotwo.setText("Not Possible");
        }

        if (toTwoOne <= 100 && toTwoOne > 0 && possible)
        {
            twoone.setText(String.valueOf(Math.round(toTwoOne * 100.0) / 100.0) + "%");
        }
        else if (toTwoOne <= 0)
        {
            twotwo.setText("Achieved");
        }
        else
        {
            twoone.setText("Not Possible");
        }

        if (toFirst <= 100 && toFirst > 0 && possible)
        {
            first.setText(String.valueOf(Math.round(toFirst * 100.0) / 100.0) + "%");
        }
        else if (toFirst <= 0)
        {
            first.setText("Achieved");
        }
        else
        {
            first.setText("Not Possible");
        }
    }
}
