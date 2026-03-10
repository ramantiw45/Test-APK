package com.example.taskmanager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;

public class TaskAdapter extends ArrayAdapter<Task> {
    private Context context;
    private List<Task> tasks;

    public TaskAdapter(Context context, List<Task> tasks) {
        super(context, R.layout.task_item, tasks);
        this.context = context;
        this.tasks = tasks;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.task_item, parent, false);
        }

        Task currentTask = tasks.get(position);

        TextView titleTextView = convertView.findViewById(R.id.textTaskTitle);
        TextView descriptionTextView = convertView.findViewById(R.id.textTaskDescription);

        titleTextView.setText(currentTask.getTitle());
        descriptionTextView.setText(currentTask.getDescription());

        return convertView;
    }
}
