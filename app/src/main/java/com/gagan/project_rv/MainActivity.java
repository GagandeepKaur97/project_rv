package com.gagan.project_rv;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
     EditText Email;
     EditText Password;
     TextView Message;
     ImageView Login;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Email    = (EditText) findViewById(R.id.etEmail);
        Password = (EditText)findViewById(R.id.etPassword);
        Login = (ImageView) findViewById(R.id.btnlogin);
        Message = (TextView) findViewById(R.id.txtMessage);

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V) {
                if (Email.getText().toString().equals("admin@123") && (Password.getText().toString().equals("s3cr3t"))) {
                     Message.setTextColor(Color.GREEN);
                     Message.setText("login successful");
//            Toast.makeText(this,"success login",Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                    intent.putExtra("name" , "admin@123");
                    startActivity(intent);
                } else {
                     Message.setTextColor(Color.RED);
                     Message.setText("failed");
                         showAlert();
//           Toast.makeText(this,"login failed",Toast.LENGTH_SHORT).show();
                }

            }


        });

    }private void showAlert()
    {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        alertDialogBuilder.setTitle("Login error");
        alertDialogBuilder.setMessage("Invalid login details, please check Email and password");
        alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(),"enter valid data",Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog mAlertDialog = alertDialogBuilder.create();
        mAlertDialog.show();
    }

}