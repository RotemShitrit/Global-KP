package com.kp.meganet.global;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class ChooseDeviceActivity extends AppCompatActivity {
    private Button pitBtn;
    private Button wallBtn;
    private Button werBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_device);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        pitBtn = (Button) findViewById(R.id.pit_device);
        wallBtn = (Button) findViewById(R.id.wall_device);
        werBtn = (Button) findViewById(R.id.registers);

        //  choose pit device
        pitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                MeganetInstances.getInstance().GetMeganetEngine().SetCurrentReadType(MeganetEngine.eReadType.NONE);
                intent = new Intent(ChooseDeviceActivity.this, PitActivity.class);
                startActivity(intent);
            }
        });

        //  choose wall mount device
        wallBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                MeganetInstances.getInstance().GetMeganetEngine().SetCurrentReadType(MeganetEngine.eReadType.NONE);
                intent = new Intent(ChooseDeviceActivity.this, WallMountActivity.class);
                startActivity(intent);
            }
        });

        //  choose register device
        werBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                MeganetInstances.getInstance().GetMeganetEngine().SetCurrentReadType(MeganetEngine.eReadType.NONE);
                MeganetInstances.getInstance().GetMeganetEngine().SetCurrentProgrammType(7);
                intent = new Intent(ChooseDeviceActivity.this, ProgrammActivity.class);
                startActivity(intent);
            }
        });
    }
}
