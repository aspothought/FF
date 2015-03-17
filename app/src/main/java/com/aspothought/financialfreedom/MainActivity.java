package com.aspothought.financialfreedom;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.widget.DrawerLayout;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

import AppLogic.CompositeResult;
import AppLogic.User;
import CommUtil.WebPayload;
import CommUtil.WebRequestController;
import CommUtil.WebRequestPair;


public class MainActivity extends ActionBarActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnLogin = (Button)findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener( new View.OnClickListener(){
            public void onClick(View v){
                EditText etUsername = (EditText)findViewById(R.id.txtUsername);
                EditText etPassword = (EditText)findViewById(R.id.txtPassword);

                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();

                if(!(username + password).equals("")){
                    User CurrentUser = new User(username, password);

                    CompositeResult UserLoggedIn = CurrentUser.Login();

                    if (Integer.parseInt(UserLoggedIn.getResultText()) > 0){
                        Intent DashboardIntent = new Intent(MainActivity.this, activity_dashboard.class);
                        MainActivity.this.startActivity(DashboardIntent);
                    }

                }

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.main, menu);
            return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
