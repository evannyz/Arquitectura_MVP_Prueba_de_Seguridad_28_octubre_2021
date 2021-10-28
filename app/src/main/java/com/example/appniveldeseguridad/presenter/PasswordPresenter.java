package com.example.appniveldeseguridad.presenter;

import android.graphics.Color;
import android.widget.Toast;

import com.example.appniveldeseguridad.view.IPasswordView;

public class PasswordPresenter implements IPasswordPresenter {

    private IPasswordView view;

    public PasswordPresenter(IPasswordView view) {
        this.view = view;
    }

    @Override
    public void validatePassword(String password) {


        int up_case = 0;
        int low_case = 0;



        if (password.trim().isEmpty()) {
            view.clearBackground();
        } else {

            for (int i = 0; i <= password.length() - 1; i++) {

                if (Character.isUpperCase(password.charAt(i))) {
                    up_case++;

                }
                if (Character.isLowerCase(password.charAt(i))) {
                    low_case++;
                }
            }

            if (low_case < 5 && up_case <= 0) {
               view.showRedBackground();
               view.displayRedMessage();


            } else if (low_case >= 5 && up_case <= 0) {
               view.showYellowBackground();
               view.displayYellowMessage();

            } else if (low_case >= 5 && up_case >= 1) {
               view.showGreenBackground();
               view.displayGreenMessage();
            }

        }

    }
}
