package com.example.brayandavid.homemedicines;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.brayandavid.homemedicines.Conection.TaskLogin;
import com.example.brayandavid.homemedicines.Objects.Login;
import com.example.brayandavid.homemedicines.View.ServicesListActivity;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginUser extends AppCompatActivity {
    private EditText txtEmailLogin;
    private EditText txtPasswordLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Security.getToken() != null)
            startActivity(new Intent(LoginUser.this, ServicesListActivity.class));
        setContentView(R.layout.activity_login_user);
        txtEmailLogin = (EditText) findViewById(R.id.txt_email_login);
        txtPasswordLogin = (EditText) findViewById(R.id.txt_pass_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbarlogin);
        txtEmailLogin.getText().clear();
        txtPasswordLogin.getText().clear();
        setSupportActionBar(toolbar);
    }

    public void btn_Login_Click(View v) throws JSONException {
        TaskLogin logenTask = new TaskLogin();
        Login login = new Login();
        login.setPassword((txtPasswordLogin.getText().toString()));
        login.setUser(txtEmailLogin.getText().toString());
        int code = TaskLogin.getCode();
        String  resul = null;
        try {
            resul = logenTask.execute(login).get();
        } catch (Exception e) {
            e.printStackTrace();
        }


        if (code == 200) {
            Intent h = new Intent(LoginUser.this, ServicesListActivity.class);
            JSONObject token = new JSONObject(resul);
            Security.setToken("Bearer " + token.getString("token"));
            startActivity(h);
        }
        if (code == 406) {
            Intent j = new Intent(LoginUser.this, PasswordChange.class);
            startActivity(j);
        }
        if (code == 401) {
            Toast.makeText(LoginUser.this, " Wait ¡Password or user incorrect!", Toast.LENGTH_LONG);
        }
        if (code == 403) {
            Toast.makeText(LoginUser.this, " ¡Access denegate! ", Toast.LENGTH_LONG);
        }

    }

}

