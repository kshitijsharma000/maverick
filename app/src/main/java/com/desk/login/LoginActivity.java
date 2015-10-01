package com.desk.login;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.desk.R;
import android.view.View.OnClickListener;
public class LoginActivity extends Activity implements OnClickListener {
TextView register ;
    Button signin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        register=(TextView) findViewById(R.id.tSignup);
        signin=(Button) findViewById(R.id.btnSingIn);
        register.setOnClickListener(this);
        signin.setOnClickListener(this);

    }
    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.tSignup :
                Intent reg = new Intent(this,signUp.class);
                startActivity(reg);
            case R.id.btnSingIn:



        }

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
