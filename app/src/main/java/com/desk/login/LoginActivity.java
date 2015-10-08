package com.desk.login;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.desk.R;
import com.desk.dataStore.LoginDataBaseAdapter;

import android.view.View.OnClickListener;
import android.widget.Toast;

public class LoginActivity extends Activity  {
    TextView register ;
    Button signin;
    EditText email , password;
    LoginDataBaseAdapter loginDataBaseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        // Get The Refference Of Buttons
        register=(TextView) findViewById(R.id.tSignup);
        signin=(Button) findViewById(R.id.btnSingIn);


        email=(EditText)findViewById(R.id.etsEmail);
        password=(EditText)findViewById(R.id.etsPassw);

        loginDataBaseAdapter=new LoginDataBaseAdapter(this);
        loginDataBaseAdapter=loginDataBaseAdapter.open();




        // Set OnClick Listener on SignUp button
        register.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub

                /// Create Intent for SignUpActivity  abd Start The Activity
                Intent intentSignUP = new Intent(getApplicationContext(), signUp.class);
                startActivity(intentSignUP);
            }
        });
        signin.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String myemail=email.getText().toString();
                String mypassword=password.getText().toString();
                /// Create Intent for SignUpActivity  abd Start The Activity
                String storedPassword=loginDataBaseAdapter.getSinlgeEntry(myemail);
                if(mypassword.equals(storedPassword))
                {
                    Toast.makeText(LoginActivity.this, "Congrats: Login Successfull", Toast.LENGTH_LONG).show();
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
