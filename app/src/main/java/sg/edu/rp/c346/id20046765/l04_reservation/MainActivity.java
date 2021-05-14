package sg.edu.rp.c346.id20046765.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etPhone;
    EditText etNumber;
    CheckBox checkboxSmoking;
    TimePicker tp;
    DatePicker dp;
    Button submitButton;
    Button resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etPhone = findViewById(R.id.etPhone);
        etNumber = findViewById(R.id.etNumber);
        checkboxSmoking = findViewById(R.id.checkboxSmoking);
        tp = findViewById(R.id.timePicker);
        dp = findViewById(R.id.datePicker);
        submitButton = findViewById(R.id.buttonSubmit);
        resetButton = findViewById(R.id.buttonReset);


        tp.setCurrentHour(7);
        tp.setCurrentMinute(30);
        dp.updateDate(2020, 6, 1);



        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String table = "";

                if (checkboxSmoking.isChecked()) {
                   table = "Smoking Area";
                } else {
                    table = "Non-smoking Area";
                }
                String time = tp.getCurrentHour() + ":" + tp.getCurrentMinute();
                int day = dp.getDayOfMonth();
                int month = dp.getMonth() + 1;
                int year = dp.getYear();
                String date = day + "/" + month + "/" + year;
                String name = etName.getText().toString();
                String phone = etPhone.getText().toString();
                String number = etNumber.getText().toString();
                String message = String.format("Hi, %s, you have successfully booked a %s person(s) in the %s's table on %s at %s. Your phone number is %s.", name, number, table, date, time, phone);
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
            }
        });

        resetButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tp.setCurrentHour(7);
                tp.setCurrentMinute(30);
                dp.updateDate(2020, 6, 1);

                etName.setText("");
                etPhone.setText("");
                etNumber.setText("");
            }
        });
    }
}