package com.example.todo;

import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;

import androidx.appcompat.app.AppCompatActivity;

import com.example.todo.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class AddTask extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        Spinner spinner = findViewById(R.id.spinner);

        // Create a list of items to display
        List<String> items = new ArrayList<>();
        items.add("Default");
        items.add("Top Order");
        items.add("Most IMP");
        // Add more items as needed...

        // Create an ArrayAdapter to populate the Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_spinner_item, // Use a default layout provided by Android
                items
        );

        // Set the dropdown layout style
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Set the adapter to the Spinner
        spinner.setAdapter(adapter);
    }

    // TO pick the time from user

    public  void showTimePick(View view)
    {
        final Calendar calendar = Calendar.getInstance();
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(this,
                new TimePickerDialog.OnTimeSetListener() {


                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        // Do something with the selected time
                        TextView textView = findViewById(R.id.timeEditText);
                        textView.setText("Selected Time: " + hourOfDay + ":" + minute);
                    }
                }, hour, minute, false);

        timePickerDialog.show();
    }

//    To see the calendar and pick the date

    public void showDatePickerDialog(View view) {
        final Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);

        DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        // Do something with the selected date
                        TextView textView = findViewById(R.id.text_view_selected_date);
                        textView.setText("Selected Date: " + year + "/" + (month + 1) + "/" + dayOfMonth);
                    }
                }, year, month, dayOfMonth);

        datePickerDialog.show();
    }

}

