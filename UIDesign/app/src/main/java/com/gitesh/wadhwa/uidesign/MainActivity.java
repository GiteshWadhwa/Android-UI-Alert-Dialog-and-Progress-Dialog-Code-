package com.gitesh.wadhwa.uidesign;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.support.v4.widget.CircularProgressDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ToggleButton toggleButton;
    CheckBox ch1,ch2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toggleButton=(ToggleButton)findViewById(R.id.toggleButton);
         ch1=(CheckBox)findViewById(R.id.checkBox);
         ch2=(CheckBox)findViewById(R.id.checkBox2);

         ch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
             @Override
             public void onCheckedChanged(CompoundButton compoundButton,boolean b){
                 Toast.makeText(MainActivity.this,"You changed Male",Toast.LENGTH_SHORT).show();
             }
         });
        ch2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener(){
            @Override
            public void onCheckedChanged(CompoundButton compoundButton,boolean b){
                Toast.makeText(MainActivity.this,"You changed Female",Toast.LENGTH_SHORT).show();
            }
        });

         toggleButton.setOnClickListener(new View.OnClickListener(){
             @Override
             public void onClick(View view){
                 if(toggleButton.isChecked()){
                     Toast.makeText(MainActivity.this,"You turned on the Button",Toast.LENGTH_SHORT).show();
                     }
                     else
                 {
                     Toast.makeText(MainActivity.this,"You turned off the Button",Toast.LENGTH_SHORT).show();
                 }
             }
         });
    }

    public void openALert(View view) {
        AlertDialog.Builder myAlert=new AlertDialog.Builder(this);
        myAlert.setTitle("Exit");
        myAlert.setMessage("Are you Sure");
        myAlert.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                finish();
            }
        });
        myAlert.setNegativeButton("No",new DialogInterface.OnClickListener(){
        @Override
        public void onClick(DialogInterface dialogInterface,int i){
            dialogInterface.dismiss();
        }
        });
        myAlert.show();
        myAlert.setCancelable(false);
    }

    public void openProgress(View view) {

//progress dialog is of two types 1 is of horizontal progress dialog or it will be a spinner progress dialog
     //it is used to measure our progress
        ProgressDialog pd=new ProgressDialog(this);
        pd.setTitle("Downloading");
        pd.setMessage("Plaese Wait...");
       pd.setProgressStyle(ProgressDialog.STYLE_SPINNER);//use STYLE_HORizontal (this will show a bar (whic is shown on screen when downloading starts))
       //spinner progress dialog is that kind of progress dialog which gives you a spinner
        //There will be a circle that keeps on moving around.You dont really know how much time your application is going to take to complete your dialog box.
    //for these things which u dont know how much time the process will take time to complate
        //use progressdialog.style spinner.
        //this is also known as indeterministic dialog box.
        pd.setButton(ProgressDialog.BUTTON_NEGATIVE, "cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        pd.show();
        //complete process is shown by Async task...
    }
}
