package com.miempresa.pruebav5;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.ainirobot.coreservice.client.ApiListener;
import com.ainirobot.coreservice.client.RobotApi;
import com.miempresa.pruebav5.application.ModuleCallback;
import com.miempresa.pruebav5.fragments.ConectionFailedFragment;
import com.miempresa.pruebav5.fragments.InfoFragment;
import com.miempresa.pruebav5.fragments.MainFragment;

public class MainActivity extends AppCompatActivity {

    Button btnInfo;
    Button btnActivities;

    FragmentTransaction transaction;
    Fragment fragmentMain;
    Fragment fragmentInfo;

    private int checkTimes;

    private FrameLayout mContent;

    private static MainActivity mInstance;

    public static MainActivity getInstance(){
        return mInstance;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkTimes = 0;
        btnInfo = (Button)findViewById(R.id.btn_info);
        btnActivities = (Button)findViewById(R.id.btn_activities);
        mContent = findViewById(R.id.main_fragment);
        conectarRobot();
        iniciarRobot();

        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                transaction = getSupportFragmentManager().beginTransaction();
                fragmentInfo = new InfoFragment();
                transaction.replace(R.id.main_fragment,fragmentInfo).commit();
            }
        });


    }

    private void conectarRobot() {
        RobotApi.getInstance().connectServer(this, new ApiListener() {
            @Override
            public void handleApiDisabled() {

            }

            @Override
            public void handleApiConnected() {
                RobotApi.getInstance().setCallback(new ModuleCallback());
            }

            @Override
            public void handleApiDisconnected() {

            }
        });
    }

    public void switchFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.main_fragment, fragment, fragment.getClass().getName())
                .commit();
    }
    public void iniciarRobot() {
        checkTimes++;
        if(checkTimes>10) {
            Fragment fragment = ConectionFailedFragment.newInstance();
            switchFragment(fragment);
            System.out.println("Error en la conexion");
        }
        else if(RobotApi.getInstance().isApiConnectedService()) {
            fragmentMain = new MainFragment();
            getSupportFragmentManager().beginTransaction().add(R.id.main_fragment, fragmentMain).commit();
            System.out.println("Conexion aceptada");
        }
        else
        {
            mContent.postDelayed(new Runnable() {
                @Override
                public void run() {
                    System.out.println("conectando...");
                    iniciarRobot();
                }
            },300);
        }

    }



}