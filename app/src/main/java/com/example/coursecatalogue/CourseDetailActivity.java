package com.example.coursecatalogue;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CourseDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_detail);

        Intent intent = getIntent();
        String code = intent.getStringExtra(MainActivity.EXTRA_CODE);
        String title = intent.getStringExtra(MainActivity.EXTRA_TITLE);
        String instructor = intent.getStringExtra(MainActivity.EXTRA_INSTRUCTOR);
        String email = intent.getStringExtra(MainActivity.EXTRA_EMAIL);
        String description = intent.getStringExtra(MainActivity.EXTRA_DESCRIPTION);
        int credits = intent.getIntExtra(MainActivity.EXTRA_CREDITS, 0);

        setTitle(code);

        ((TextView) findViewById(R.id.tvDetailCode)).setText(code);
        ((TextView) findViewById(R.id.tvDetailTitle)).setText(title);
        ((TextView) findViewById(R.id.tvDetailInstructor)).setText("Instructor: " + instructor);
        ((TextView) findViewById(R.id.tvDetailCredits)).setText("Credit Hours: " + credits);
        ((TextView) findViewById(R.id.tvDetailDescription)).setText(description);

        Button btnEmail = findViewById(R.id.btnEmail);
        btnEmail.setOnClickListener(v -> {
            Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
            emailIntent.setData(Uri.parse("mailto:" + email));
            try {
                startActivity(emailIntent);
            } catch (ActivityNotFoundException e) {
                Toast.makeText(CourseDetailActivity.this,
                        "No email app found", Toast.LENGTH_SHORT).show();
            }
        });
    }
}