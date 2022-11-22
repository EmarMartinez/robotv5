package com.miempresa.pruebav5.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.ainirobot.coreservice.client.speech.SkillApi;
import com.miempresa.pruebav5.R;

public class ActivitiesFragment extends Fragment {

    Button btnComenzar;
    Button btnParar;
    EditText etDictado;
    SkillApi mSkillApi;

    public ActivitiesFragment() {

    }

    public static ActivitiesFragment newInstance() {
        ActivitiesFragment fragment = new ActivitiesFragment();
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

        return inflater.inflate(R.layout.fragment_activities, container, false);
    }


}