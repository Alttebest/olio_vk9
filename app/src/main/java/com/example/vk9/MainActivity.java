package com.example.vk9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    EditText firstNameInput;
    EditText lastNameInput;
    EditText emailInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        UserStorage userstorage = UserStorage.getInstance();

        firstNameInput = findViewById(R.id.editFirstName);
        lastNameInput = findViewById(R.id.editLastName);
        emailInput = findViewById(R.id.editEmail);
    }

    public void switchToListUsers(View view){
        Intent intent = new Intent(this, ListUsersActivity.class);
        startActivity(intent);
    }

    public void addUser(View view){
        String degreeType = null;
        int image;
        RadioGroup rgDegreeType = findViewById(R.id.rgDegreeType);
        RadioGroup rgImage = findViewById(R.id.rgImage);

        switch (rgDegreeType.getCheckedRadioButtonId()){
            case R.id.radioTite:
                degreeType = "Tietotekniikka";
                break;
            case R.id.radioTuta:
                degreeType = "Tuotantotalous";
                break;
            case R.id.radioLate:
                degreeType = "Laskennallinen tekniikka";
                break;
            case R.id.radioSäte:
                degreeType = "Sähkötekniikka";
                break;
            default:
                degreeType = "Ei valittu";
                break;
        }

        switch (rgImage.getCheckedRadioButtonId()){
            case R.id.radioKettu:
                image = R.drawable.kettu;
                break;
            case R.id.radioKirahvi:
                image = R.drawable.kirahvi;
                break;
            case R.id.radioKissa:
                image = R.drawable.kissa;
                break;
            case R.id.radioKoira:
                image = R.drawable.koira;
                break;
            default:
                image = R.drawable.ic_launcher_foreground;
                break;
        }
        User newUser = new User(firstNameInput.getText().toString(), lastNameInput.getText().toString(), emailInput.getText().toString(), degreeType, image);
        UserStorage.getInstance().addUser(newUser);
    }
}