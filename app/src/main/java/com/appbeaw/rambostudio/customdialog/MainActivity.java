package com.appbeaw.rambostudio.customdialog;

import android.app.Dialog;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    private Button btnDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //BindWidget
        bindWidget();

        //  About Button Dialog
        btnDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(MainActivity.this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.customdialog);
                dialog.setCancelable(true);

                //  Set Widget in Custom Dialog
                Button btnCloseDialog = (Button) dialog.findViewById(R.id.btnCloseDialog);
                btnCloseDialog.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getApplicationContext(), "Close dialog", Toast.LENGTH_SHORT).show();

                        dialog.dismiss();

                    }   //  onClick
                }); //  btnCloseDialog setOnClick

                TextView txtTitleDialog = (TextView) dialog.findViewById(R.id.txtTitleDialog);
                txtTitleDialog.setText("Custom Dialog");

                TextView txtContentDialog = (TextView) dialog.findViewById(R.id.txtContentDialog);
                txtContentDialog.setText("Try it yourself");

                dialog.show();

            }   //  onClick
        }); //  btnDialog setOnclick

    }   //onCreate

    private void bindWidget() {

        btnDialog = (Button) findViewById(R.id.btnDialog);

    }   //  bindWidget

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
}   //MainClass
