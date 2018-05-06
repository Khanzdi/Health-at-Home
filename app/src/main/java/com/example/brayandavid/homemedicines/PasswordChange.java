package com.example.brayandavid.homemedicines;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.brayandavid.homemedicines.Conection.TaskChangePassword;
import com.example.brayandavid.homemedicines.Objects.LoginChangePassword;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class PasswordChange extends AppCompatActivity {
    private EditText txtEmail;
    private EditText oldPassword;
    private EditText newPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password_change);
        txtEmail = (EditText) findViewById(R.id.txtemail_ch_p);
        oldPassword = (EditText) findViewById(R.id.txt_old_password);
        newPassword = (EditText) findViewById(R.id.txtnewpassw);
    }
    public void btnchange_P(View v) throws JSONException {
        TaskChangePassword logenTask = new TaskChangePassword();
        LoginChangePassword changePassword = new LoginChangePassword();
        changePassword.setOldPassword((oldPassword.getText().toString()));
        changePassword.setNewPassword((newPassword.getText().toString()));
        changePassword.setUser(txtEmail.getText().toString());
        int code = TaskChangePassword.getCode();

        String  resul = null;
        try {
            resul = logenTask.execute(changePassword).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


        if (code == 200 || code == 201) {
            Intent h = new Intent(PasswordChange.this, LoginUser.class);
            Toast.makeText(this, " ¡Password modification successful!", Toast.LENGTH_LONG);
            JSONObject token = new JSONObject(resul);
            Security.setToken("Bearer " + token.getString("token"));
            startActivity(h);
        }
        if (code == 404) {
            Toast.makeText(this, " Wait ¡Last Password incorrect!", Toast.LENGTH_LONG);
        }
        if (code == 401) {
            Toast.makeText(this, " Wait ¡Password or user incorrect!", Toast.LENGTH_LONG);
        }
        if (code == 403) {
            Toast.makeText(this, " ¡Access denegate! ", Toast.LENGTH_LONG);
        }
        if (code == 405) {
            Toast.makeText(this, " ¡Reset the password! ", Toast.LENGTH_LONG);
            Intent j = new Intent(this, PasswordChange.class);
            startActivity(j);
        }
    }
}
