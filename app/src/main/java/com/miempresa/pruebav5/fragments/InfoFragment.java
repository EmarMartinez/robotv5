package com.miempresa.pruebav5.fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.ainirobot.coreservice.client.ApiListener;
import com.ainirobot.coreservice.client.Definition;
import com.ainirobot.coreservice.client.RobotApi;
import com.ainirobot.coreservice.client.robotsetting.RobotSettingApi;
import com.miempresa.pruebav5.R;
import com.miempresa.pruebav5.application.ModuleCallback;

import org.w3c.dom.Text;


public class InfoFragment extends Fragment {

    TextView labelBattery;
    TextView tvBattery;
    TextView labelInfo;
    TextView tvInfo;
    Context context;


    public InfoFragment() {

    }

    public static InfoFragment newInstance( ) {
        InfoFragment fragment = new InfoFragment();
        Bundle args = new Bundle();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        return inflater.inflate(R.layout.fragment_info, container, false);
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvBattery = (TextView) view.findViewById(R.id.battery);
        tvBattery.setText("La carga actual es: " + RobotSettingApi.getInstance().getRobotString(Definition.ROBOT_SETTINGS_BATTERY_INFO)+"%");

        tvInfo = (TextView) view.findViewById(R.id.robot_system_version);
        tvInfo.setText("La version del sistema es: " + RobotApi.getInstance().getVersion());
    }
}