package sg.edu.rp.c346.dialogdemo;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Simple Dialog Step 1a
    Button btnDemo1;
    TextView tvDemo2;
    TextView tvDemo3;
    TextView tvDemo4;
    Button btnDemo2;
    Button btnDemo3;
    Button btnDemo4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*************************SIMPLE DIALOG*********************************/

        // Simple Dialog Step 2b binding and implementing listener
        btnDemo1 = (Button)findViewById(R.id.buttonDemo1);

        btnDemo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Create the Dialog Builder
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setPositiveButton("Dismiss", null);
                // setting the look
                myBuilder.setTitle("Congratulation");
                myBuilder.setMessage("You have completed a simple Dialog Box");
                myBuilder.setCancelable(true);


                // Create and display the Dialog
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        /*****************************BUTTON DIALOG*************************/

        tvDemo2 = (TextView)findViewById(R.id.textViewDemo2);
        btnDemo2 = (Button)findViewById(R.id.buttonDemo2);

        btnDemo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                myBuilder.setTitle("Demo 2 Buttons Dialog");
                myBuilder.setMessage("Select one of the Button below.");
                myBuilder.setCancelable(true);

                // Configure the 'yes' button
                myBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // IMPORTANT: Update TextView as a form of data passing between Dialog and MainActivity
                        tvDemo2.setText("You have selected Yes.");
                    }
                });
                // Configure the 'no' button
                myBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // IMPORTANT: Update TextView as a form of data passing between Dialog and MainActivity
                        tvDemo2.setText("You have selected No.");
                    }
                });

                // Configure the 'neutral' button

                myBuilder.setNeutralButton("Neutral", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // IMPORTANT: Update TextView as a form of data passing between Dialog and MainActivity
                        tvDemo2.setText("You have selected Neutral.");
                    }
                });
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();

            }

        });

        /*******************************TEXT INPUT DIALOG***************************/
        tvDemo3 = (TextView)findViewById(R.id.textViewDemo3);
        btnDemo3 = (Button)findViewById(R.id.buttonDemo3);
        btnDemo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                /*

                //Inflate the input.xml layout file
                LayoutInflater inflater = (LayoutInflater)getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input, null);

                // Obtain the UI component in the input.xml layout
                final EditText etInput = (EditText)viewDialog.findViewById(R.id.editTextInput);
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                // Set the view of the dialog
                myBuilder.setView(viewDialog);
                myBuilder.setTitle("Demo 3-Text Input Dialog");

                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        // Extract the Text entered by the user
                        String message = etInput.getText().toString();
                        // Update the Text to TextView
                        tvDemo3.setText(message);
                    }
                });
                */

                // Worksheet exercise
                // Inflate the input.xml layout file
                LayoutInflater inflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input2, null);

                // Obtain the UI component in the input.xml layout
                final EditText etInput = (EditText) viewDialog.findViewById(R.id.editTextInput);
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                myBuilder.setNegativeButton("Cancel", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();

                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        // Extract the Text entered by the user
                        String message = etInput.getText().toString();
                        String message1 = etInput.getText().toString();
                        // Update the Text to TextView
                        tvDemo3.setText(message);
                        tvDemo3.setText(message1);
                    }
                });

                /***************************DATE PICKER**************************************/

                tvDemo4 = (TextView) findViewById(R.id.buttonDemo4);

                btnDemo4.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        // Creating the Listener to set the date
                        DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                tvDemo4.setText("Date: " + dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        };

                        // Create the Date Picker Dialog
                        DatePickerDialog myDateDialog = new DatePickerDialog(MainActivity.this, myDateListener, 2014, 11, 31);

                        myDateDialog.show();
                    }
                });


            }
        });
    }
}
