package com.miempresa.pruebav5.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ainirobot.coreservice.client.RobotApi;
import com.ainirobot.coreservice.client.listener.CommandListener;
import com.miempresa.pruebav5.R;


public class CabezaFragment extends Fragment {

    Button btnSubir;
    Button btnIzquierda;
    Button btnBajar;
    Button btnDerecha;
    Button btnStop;


    public CabezaFragment() {
    }

    public static CabezaFragment newInstance() {
        CabezaFragment fragment = new CabezaFragment();
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

        return inflater.inflate(R.layout.fragment_cabeza, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnSubir = (Button)view.findViewById(R.id.btn_subir);
        btnBajar = (Button)view.findViewById(R.id.btn_bajar);
        btnIzquierda = (Button)view.findViewById(R.id.btn_izq);
        btnDerecha = (Button)view.findViewById(R.id.btn_derecha);
        btnStop = (Button)view.findViewById(R.id.btn_stop);


        btnSubir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Avanzando..........");
                RobotApi.getInstance().goForward(0, 0.2f,null);
            }
        });
        btnBajar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Retrocediendo..........");
                RobotApi.getInstance().goBackward(0, 0.2f, null);
            }
        });
        btnIzquierda.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Izquierda..........");
                RobotApi.getInstance().turnLeft(0, 0.2f, null);
            }
        });
        btnDerecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Derecha..........");
                RobotApi.getInstance().turnRight(0, 0.2f, null);
            }
        });
        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println("Parando movimiento....");
                RobotApi.getInstance().stopMove(0, null);
            }
        });

    }
}