package com.example.appniveldeseguridad.view;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.appniveldeseguridad.databinding.FragmentFirstBinding;
import com.example.appniveldeseguridad.presenter.IPasswordPresenter;
import com.example.appniveldeseguridad.presenter.PasswordPresenter;

public class FirstFragment extends Fragment implements IPasswordView {

    private FragmentFirstBinding binding;
    private IPasswordPresenter presenter;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        initBinding(inflater,container);
        initPresenter();
        setupTextChangedListener();






        return binding.getRoot();

    }

    private void initPresenter() {
        presenter = new PasswordPresenter(this );
    }

    private void setupTextChangedListener() {
        binding.aetIngresoPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                presenter.validatePassword(charSequence.toString());

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }


    private void initBinding(LayoutInflater inflater, ViewGroup container) {
        binding = FragmentFirstBinding.inflate(inflater, container, false);
    }



    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /*binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });*/


    }

    @Override
    public void showRedBackground() {

        binding.aetIngresoPassword.setBackgroundColor(Color.RED);

    }

    @Override
    public void displayRedMessage() {
        binding.atvNivelSeguridadPassword.setText("Nivel de seguridad: Bajo");

    }

    @Override
    public void showYellowBackground() {
        binding.aetIngresoPassword.setBackgroundColor(Color.YELLOW);

    }

    @Override
    public void displayYellowMessage() {
        binding.atvNivelSeguridadPassword.setText("Nivel de seguridad: Medio");
    }

    @Override
    public void showGreenBackground() {
        binding.aetIngresoPassword.setBackgroundColor(Color.GREEN);

    }

    @Override
    public void displayGreenMessage() {
        binding.atvNivelSeguridadPassword.setText("Nivel de seguridad: Fuerte");

    }

    @Override
    public void clearBackground() {
        binding.aetIngresoPassword.setBackgroundColor(Color.WHITE);

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}