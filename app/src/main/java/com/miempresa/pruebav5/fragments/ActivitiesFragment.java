package com.miempresa.pruebav5.fragments;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.ainirobot.coreservice.client.ApiListener;
import com.ainirobot.coreservice.client.listener.TextListener;
import com.ainirobot.coreservice.client.speech.SkillApi;
import com.ainirobot.coreservice.client.speech.SkillCallback;
import com.ainirobot.coreservice.client.speech.entity.TTSEntity;
import com.miempresa.pruebav5.R;
import com.miempresa.pruebav5.application.SpeechCallback;

public class ActivitiesFragment extends Fragment {

    Button btnComenzar;
    Button btnParar;
    EditText etDictado;
    SkillCallback mSkillCallback;
    private SkillApi mSkillApi;

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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initSkillApi();

        mSkillCallback = new SpeechCallback();
        etDictado = (EditText) view.findViewById(R.id.et_dictado);

        btnComenzar = (Button) view.findViewById(R.id.btn_comenzar);
        btnComenzar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = "Hello my name is lucki";
                System.out.println("Leyendo frase....");
//                String text = etDictado.getText().toString();
//                if (text.equals("")) {
//                    text = etDictado.getHint().toString();
//                }
                playText(text);
            }
        });
        btnParar = (Button) view.findViewById(R.id.btn_parar);
        btnParar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            stopTTS();
            }
        });
    }

    private void initSkillApi() {
        mSkillApi = new SkillApi();
        ApiListener apiListener = new ApiListener() {
            @Override
            public void handleApiDisabled() {
            }

            @Override
            public void handleApiConnected() {
                mSkillApi.registerCallBack(mSkillCallback);
            }

            @Override
            public void handleApiDisconnected() {
            }
        };
        mSkillApi.addApiEventListener(apiListener);
        mSkillApi.connectApi(getContext());
    }

    private void playText(String text) {
        if (mSkillApi != null) {
            mSkillApi.playText(new TTSEntity("sid-1234567890", text), mTextListener);
        }
    }
    private TextListener mTextListener = new TextListener() {
        @Override
        public void onStart() {
            super.onStart();
        }

        @Override
        public void onStop() {
            super.onStop();
        }

        @Override
        public void onComplete() {
            super.onComplete();
        }

        @Override
        public void onError() {
            super.onError();
        }
    };
    private void stopTTS(){
        if(mSkillApi != null){
            mSkillApi.stopTTS();
        }
    }

    private void queryByText(String text){
        if(mSkillApi != null){
            mSkillApi.queryByText(text);
        }
    }


}