package com.example.brayandavid.homemedicines;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.brayandavid.homemedicines.Conection.TaskUserRegistry;
import com.example.brayandavid.homemedicines.Objects.User;

import java.util.concurrent.ExecutionException;


public class Registro extends AppCompatActivity {
    private EditText gender;
    private EditText password;
    private EditText user;
    private EditText name;
    private EditText lasName;
    private EditText age;
    private EditText type;
    private EditText workingHours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        gender = (EditText) findViewById(R.id.txtgender);
        password = (EditText) findViewById(R.id.txtpassword);
        user = (EditText) findViewById(R.id.txtuser);
        name = (EditText) findViewById(R.id.txtname);
        lasName = (EditText) findViewById(R.id.txtlastname);
        age = (EditText) findViewById(R.id.txtage);
        type = (EditText) findViewById(R.id.txt_type);
        workingHours = (EditText) findViewById(R.id.txt_hours);

    }

    public void btn_Registro_Click(View v) {
        TaskUserRegistry usersRegistry = new TaskUserRegistry();
        User userRegistry = new User();
        userRegistry.setAge(age.getId());
        userRegistry.setGender(gender.getText().toString());
        userRegistry.setName(name.getText().toString());
        userRegistry.setLasName(lasName.getText().toString());
        userRegistry.setPassword((password.getText().toString()));
        userRegistry.setType(type.getText().toString());
        userRegistry.setUser(user.getText().toString());
        userRegistry.setWorkingHours(workingHours.getText().toString());

        try {
            String resul = usersRegistry.execute(userRegistry).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        int code = TaskUserRegistry.getCode();
        if (code == 200) {
            Toast.makeText(this, "User created successfully, please login",
                    Toast.LENGTH_LONG).show();
            Intent i = new Intent(Registro.this, LoginUser.class);
            startActivity(i);
        }else {
            Toast.makeText(this, "Something was wrong, try again "+ code,
                    Toast.LENGTH_LONG).show();
            Intent i = new Intent(Registro.this, Registro.class);
            startActivity(i);
        }
    }


}

