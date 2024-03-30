package com.example.todo;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.todo.R;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class AddTask extends AppCompatActivity {

    //Creating all the DataMembers
    Spinner spinner;
    EditText gtName,gtDescp,gtPriority;
    TextView gtTime,gtDate;
    Button submit;
    String priority;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        //Adding all the id's


        spinner = findViewById(R.id.spinner);
        submit = findViewById(R.id.addTask);
        gtName = findViewById(R.id.headofTask);
        gtDescp = findViewById(R.id.descriptionTask);
        gtTime = findViewById(R.id.timeEditText);
        gtDate = findViewById(R.id.daterTask);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parentView, View selectedItemView, int position, long id) {
                priority = parentView.getItemAtPosition(position).toString();
                // Do something with the selected item
            }

            @Override
            public void onNothingSelected(AdapterView<?> parentView) {
                // Do nothing
            }
        });

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


        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Creating all datamembers
                String name, description, date, time;

                //Getting all the data from texts

                name = gtName.getText().toString();
                description = gtDescp.getText().toString();
                date = gtDate.getText().toString();
                time = gtTime.getText().toString();

                if(name.isEmpty() || description.isEmpty() || date.isEmpty() || time.isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Enter all the feilds",Toast.LENGTH_LONG).show();
                    return;
                }

                // Checking if valid date is there or not

                // Checking if valid date and time are selected
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd", new Locale("en", "IN"));
                SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm", new Locale("en", "IN"));
                Date currentDate = new Date();
                Date selectedDate = null;
                Date selectedTime = null;


// Parse the input date and time into proper format
                try {
                    selectedDate = dateFormat.parse(date);
                    selectedTime = timeFormat.parse(time);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

// Check if both date and time are parsed successfully
                if (selectedDate != null && selectedTime != null) {
                    // Remove time components from current and selected dates for comparison
                    Calendar currentCalendar = Calendar.getInstance();
                    currentCalendar.setTime(currentDate);
                    currentCalendar.set(Calendar.HOUR_OF_DAY, 0);
                    currentCalendar.set(Calendar.MINUTE, 0);
                    currentCalendar.set(Calendar.SECOND, 0);
                    currentCalendar.set(Calendar.MILLISECOND, 0);

                    Calendar selectedCalendar = Calendar.getInstance();
                    selectedCalendar.setTime(selectedDate);
                    selectedCalendar.set(Calendar.HOUR_OF_DAY, 0);
                    selectedCalendar.set(Calendar.MINUTE, 0);
                    selectedCalendar.set(Calendar.SECOND, 0);
                    selectedCalendar.set(Calendar.MILLISECOND, 0);

                    // Compare the selected date with the current date
                    if (selectedCalendar.before(currentCalendar)) {
                        // If selected date is before the current date, show an error message
                        Toast.makeText(getApplicationContext(), "Enter a valid date", Toast.LENGTH_LONG).show();
                        return; // Exit the method, do not proceed further
                    }

                    // Check if the selected date is today
                    if (selectedCalendar.equals(currentCalendar)) {
                        // If the selected date is today, compare the selected time with the current time
                        Calendar selectedTimeCalendar = Calendar.getInstance();
                        selectedTimeCalendar.setTime(selectedTime);

                        // Compare hours, minutes, and seconds
                        if (selectedTimeCalendar.get(Calendar.HOUR_OF_DAY) < Calendar.getInstance().get(Calendar.HOUR_OF_DAY) ||
                                (selectedTimeCalendar.get(Calendar.HOUR_OF_DAY) == Calendar.getInstance().get(Calendar.HOUR_OF_DAY) &&
                                        selectedTimeCalendar.get(Calendar.MINUTE) < Calendar.getInstance().get(Calendar.MINUTE)) ||
                                (selectedTimeCalendar.get(Calendar.HOUR_OF_DAY) == Calendar.getInstance().get(Calendar.HOUR_OF_DAY) &&
                                        selectedTimeCalendar.get(Calendar.MINUTE) == Calendar.getInstance().get(Calendar.MINUTE) &&
                                        selectedTimeCalendar.get(Calendar.SECOND) < Calendar.getInstance().get(Calendar.SECOND))) {
                            // If selected time is before the current time, show an error message
                            Toast.makeText(getApplicationContext(), "Please select a time on or after now", Toast.LENGTH_SHORT).show();
                            return; // Exit the method, do not proceed further
                        }
                    }

                    // Proceed with your logic if date and time are valid
                    Log.e("data", "Name- " + name + " description- " + description + " date- " + date + " time- " + time + " priority- " + priority);
                } else {
                    // Invalid date or time format, show error message or handle it accordingly
                    Toast.makeText(getApplicationContext(), "Invalid date or time format", Toast.LENGTH_SHORT).show();
                    return;
                }



                List<RCModel> task = new ArrayList<>();


                // Printing all things to log
                startActivity(new Intent(getApplicationContext(), MainActivity.class));

                Log.e("data", "Name- " + name + " description- " + description + " date- " + date + " time- " + time + " priority- " + priority);
            }

        });
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
                        textView.setText( hourOfDay + ":" + minute);
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
                        TextView textView = findViewById(R.id.daterTask);
                        textView.setText(year + "/" + (month + 1) + "/" + dayOfMonth);
                    }
                }, year, month, dayOfMonth);

        datePickerDialog.show();
    }

}

