package com.example.taskmanager;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText editTaskTitle;
    private EditText editTaskDescription;
    private Button btnSaveTask;
    private ListView listViewTasks;
    private DatabaseHelper databaseHelper;
    private TaskAdapter taskAdapter;
    private List<Task> taskList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTaskTitle = findViewById(R.id.editTaskTitle);
        editTaskDescription = findViewById(R.id.editTaskDescription);
        btnSaveTask = findViewById(R.id.btnSaveTask);
        listViewTasks = findViewById(R.id.listViewTasks);

        databaseHelper = new DatabaseHelper(this);
        taskList = new ArrayList<>();
        taskAdapter = new TaskAdapter(this, taskList);
        listViewTasks.setAdapter(taskAdapter);

        loadTasks();

        btnSaveTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = editTaskTitle.getText().toString().trim();
                String description = editTaskDescription.getText().toString().trim();

                if (title.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter a title", Toast.LENGTH_SHORT).show();
                    return;
                }

                Task newTask = new Task(title, description);
                databaseHelper.addTask(newTask);

                editTaskTitle.setText("");
                editTaskDescription.setText("");

                loadTasks();
                Toast.makeText(MainActivity.this, "Task added", Toast.LENGTH_SHORT).show();
            }
        });

        listViewTasks.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Task taskToDelete = taskList.get(position);
                databaseHelper.deleteTask(taskToDelete.getId());
                loadTasks();
                Toast.makeText(MainActivity.this, "Task deleted", Toast.LENGTH_SHORT).show();
                return true; // Return true to consume the long-click event
            }
        });
    }

    private void loadTasks() {
        taskList.clear();
        taskList.addAll(databaseHelper.getAllTasks());
        taskAdapter.notifyDataSetChanged();
    }
}
