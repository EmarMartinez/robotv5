package com.miempresa.pruebav5.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.miempresa.pruebav5.R;


public class ConectionFailedFragment extends Fragment {



    public ConectionFailedFragment() {

    }


    public static ConectionFailedFragment newInstance() {
        ConectionFailedFragment fragment = new ConectionFailedFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_conection_failed, container, false);
    }
}