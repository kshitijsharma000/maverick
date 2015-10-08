package com.desk.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.desk.R;
import com.desk.dataStore.LoginDataBaseAdapter;

public class signUp extends AppCompatActivity {




    EditText editTextEmail,editTextUserName,editTextPassword,editTextConfirmPassword,editTextContactNo;
    Button btnCreateAccount;

    LoginDataBaseAdapter loginDataBaseAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        // get Instance  of Database Adapter
        loginDataBaseAdapter=new LoginDataBaseAdapter(this);
        loginDataBaseAdapter=loginDataBaseAdapter.open();

        // Get Refferences of Views
        editTextEmail=(EditText)findViewById(R.id.etEmail);
        editTextUserName=(EditText)findViewById(R.id.etUserName);
        editTextPassword=(EditText)findViewById(R.id.etPass);
        editTextConfirmPassword=(EditText)findViewById(R.id.etRePass);
        editTextContactNo=(EditText)findViewById(R.id.etPhoneno);

        btnCreateAccount=(Button)findViewById(R.id.btnSignup);
        btnCreateAccount.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub
                String email=editTextEmail.getText().toString();
                String userName=editTextUserName.getText().toString();
                String password=editTextPassword.getText().toString();
                String confirmPassword=editTextConfirmPassword.getText().toString();
                String contactNo =editTextContactNo.getText().toString();

                // check if any of the fields are vaccant
                if(email.equals("")||userName.equals("")||password.equals("")||confirmPassword.equals("")|| contactNo.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "Please fill complete details ", Toast.LENGTH_LONG).show();
                    return;
                }
                // check if both password matches
                if(!password.equals(confirmPassword))
                {
                    Toast.makeText(getApplicationContext(), "Password does not match", Toast.LENGTH_LONG).show();
                    return;
                }
                else
                {
                    // Save the Data in Database
                    loginDataBaseAdapter.insertEntry(email,userName, password,contactNo);
                    Toast.makeText(getApplicationContext(), "Account Successfully Created ", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
    @Override
    protected void onDestroy() {
        // TODO Auto-generated method stub
        super.onDestroy();

        loginDataBaseAdapter.close();
    }
}
