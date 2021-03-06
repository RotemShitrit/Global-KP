package com.kp.meganet.global;

import android.content.Intent;
import android.content.pm.ActivityInfo;
//import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class PulseActivity extends AppCompatActivity implements iPulseCallback{

    private Button readPortButton;
    private Button writePortButton;
    private Button closeButton;

    private EditText portSNeditText;
    private EditText portReadeditText;
    private RadioGroup radioGroup;

    private RadioButton Port1rbo;
    private RadioButton Port2rbo;
    private RadioButton Port3rbo;
    private RadioButton Port4rbo;

    private String _toastMessageToDisplay;
    private int port = 1;
    int ndevice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pulse);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        readPortButton  = (Button) findViewById(R.id.buttonReadPort);
        writePortButton  = (Button) findViewById(R.id.buttonWretePort);
        closeButton  = (Button) findViewById(R.id.buttonClose);

        portSNeditText  = (EditText) findViewById(R.id.editTextPortSN);
        portReadeditText  = (EditText) findViewById(R.id.editTextPortRead);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroupPort);

        ndevice = getIntent().getIntExtra("ndevice",0);


        /*Port1rbo  = (RadioButton) findViewById(R.id.rboPort1);
        Port2rbo  = (RadioButton) findViewById(R.id.rboPort2);
        Port3rbo  = (RadioButton) findViewById(R.id.rboPort3);
        Port4rbo  = (RadioButton) findViewById(R.id.rboPort4);*/


        MeganetInstances.getInstance().GetMeganetEngine().InitPulse(this);

        readPortButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*int portNumVal = 1;
                if (Port1rbo.isChecked())
                {
                    portNumVal = 1;
                }
                else if(Port2rbo.isChecked())
                {
                    portNumVal = 2;
                }
                else if(Port3rbo.isChecked())
                {
                    portNumVal = 3;
                }
                else
                {
                    portNumVal = 4;
                }*/

                MeganetInstances.getInstance().GetMeganetEngine().ReadPulsePort(port);
            }
        });

        writePortButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*int portNumVal = 1;
                if (Port1rbo.isChecked())
                {
                    portNumVal = 1;
                }
                else if(Port2rbo.isChecked())
                {
                    portNumVal = 2;
                }
                else if(Port3rbo.isChecked())
                {
                    portNumVal = 3;
                }
                else
                {
                    portNumVal = 4;
                }*/

                MeganetInstances.getInstance().GetMeganetEngine().WritePulsePort(port, Integer.valueOf(portSNeditText.getText().toString()), Integer.valueOf(portReadeditText.getText().toString()));
            }
        });

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void checkPort(View v) // check which input port of device
    {
        int radioID = radioGroup.getCheckedRadioButtonId();
        if(radioID==R.id.rboPort1)
            port = 1;
        else if(radioID==R.id.rboPort2)
            port = 2;
        else if(radioID==R.id.rboPort3)
            port = 3;
        else
            port=4;
    }


    @Override
    public void OnRead(String serial_num, String reading)
    {
        portSNeditText.setText(serial_num);
        portReadeditText.setText(reading);
    }
    @Override
    public void OnErrorRead(String error)
    {

    }
    @Override
    public void OnMessageCb(String message_prm) {
    }

    @Override
    public boolean PairData(String deviceName_prm, String ndevice_pam, boolean titleOnly)
    {
        return true;
    }
    @Override
    public void OnWriteResult(boolean result)
    {
        if (result)
            _toastMessageToDisplay = "Disconnect successfully ";
        else
            _toastMessageToDisplay = "Disconnect successfully ";

        MeganetInstances.getInstance().GetMeganetEngine().MeterPowerOff();
        this.runOnUiThread(new Runnable() {
            public void run() {
                // Access/update UI here
                Toast.makeText(getApplicationContext(), _toastMessageToDisplay,
                        Toast.LENGTH_SHORT).show();
            }
        });

        Intent intent;
        MeganetInstances.getInstance().GetMeganetEngine().SetCurrentReadType(MeganetEngine.eReadType.NONE);
        MeganetInstances.getInstance().GetMeganetEngine().SetCurrentProgrammType(6);
        intent = new Intent(this, ProgrammActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }
}
