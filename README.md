# Daily Task Manager

A simple, native Android application built with Java and Android Studio for managing daily tasks.

## Features

*   **Add Tasks:** Quickly add new tasks with a title and a description.
*   **View Tasks:** See all your tasks in a scrollable list view.
*   **Delete Tasks:** Long-press on any task in the list to delete it.
*   **Persistent Storage:** Tasks are saved locally on the device using SQLite, so they remain available even after the app is closed.

## Technologies Used

*   Java
*   Android SDK
*   SQLite (via SQLiteOpenHelper)
*   XML Layouts

## How to Run

1.  Clone this repository to your local machine:
    ```bash
    git clone https://github.com/ramantiw45/Test-APK.git
    ```
2.  Open **Android Studio**.
3.  Select **Open** and choose the cloned repository folder.
4.  Wait for the Gradle sync to complete.
5.  Click the **Run** button (green play icon) in the toolbar and select an Emulator or a connected physical Android device.

## Application Architecture

*   `MainActivity.java`: Handles the UI logic, user interactions, and updating the list.
*   `Task.java`: The model class representing a single task.
*   `DatabaseHelper.java`: Manages the SQLite database creation, versioning, and CRUD operations.
*   `TaskAdapter.java`: A custom ArrayAdapter responsible for binding the `Task` data to the `ListView` UI elements.
