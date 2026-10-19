package com.example.coursecatalogue;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements CourseAdapter.OnItemClickListener {

    public static final String EXTRA_CODE = "extra_code";
    public static final String EXTRA_TITLE = "extra_title";
    public static final String EXTRA_INSTRUCTOR = "extra_instructor";
    public static final String EXTRA_EMAIL = "extra_email";
    public static final String EXTRA_DESCRIPTION = "extra_description";
    public static final String EXTRA_CREDITS = "extra_credits";

    private ArrayList<Course> courses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        courses = new ArrayList<>();
        courses.add(new Course("CS02310", "Mobile Application Development", "Dr. Ayesha Khan",
                "ayesha.khan@example.com", "Build Android apps with Java: layouts, activity lifecycle, RecyclerView and intents.", 3));
        courses.add(new Course("CS01110", "Programming Fundamentals", "Mr. Bilal Ahmed",
                "bilal.ahmed@example.com", "Basics of programming: variables, loops, functions and arrays.", 3));
        courses.add(new Course("CS02210", "Data Structures", "Dr. Sana Malik",
                "sana.malik@example.com", "Lists, stacks, queues, trees and graphs, with their algorithms.", 3));
        courses.add(new Course("CS03110", "Database Systems", "Ms. Hira Tariq",
                "hira.tariq@example.com", "Relational model, SQL, normalization and transactions.", 3));
        courses.add(new Course("CS03210", "Operating Systems", "Mr. Usman Ali",
                "usman.ali@example.com", "Processes, threads, scheduling, memory management and file systems.", 3));
        courses.add(new Course("SE04110", "Software Engineering", "Dr. Farah Nadeem",
                "farah.nadeem@example.com", "Requirements, design, testing and the software development process.", 3));
        courses.add(new Course("CS04310", "Computer Networks", "Mr. Hamza Raza",
                "hamza.raza@example.com", "Network layers, protocols, TCP/IP, routing and network security basics.", 3));
        courses.add(new Course("SE05110", "Web Engineering", "Ms. Noor Fatima",
                "noor.fatima@example.com", "Building web apps with HTML, CSS, JavaScript and server-side tools.", 3));

        RecyclerView rvCourses = findViewById(R.id.rvCourses);
        rvCourses.setLayoutManager(new LinearLayoutManager(this));
        rvCourses.setAdapter(new CourseAdapter(courses, this));
    }

    @Override
    public void onItemClick(int position) {
        Course course = courses.get(position);
        Intent intent = new Intent(this, CourseDetailActivity.class);
        intent.putExtra(EXTRA_CODE, course.getCode());
        intent.putExtra(EXTRA_TITLE, course.getTitle());
        intent.putExtra(EXTRA_INSTRUCTOR, course.getInstructor());
        intent.putExtra(EXTRA_EMAIL, course.getEmail());
        intent.putExtra(EXTRA_DESCRIPTION, course.getDescription());
        intent.putExtra(EXTRA_CREDITS, course.getCreditHours());
        startActivity(intent);
    }
}