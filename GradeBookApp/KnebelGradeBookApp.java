package GradeBookApp;

import javafx.application.Application;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;

import GradeBookApp.KnebelGradeBookApp.StudentEntry;

public class KnebelGradeBookApp extends Application {

    private TextField firstNameField;
    private TextField lastNameField;
    private TextField courseField;
    private TextField scoreField;
    private TextField totalPointsField;
    private Label gradeLabel;
    private Label errorLabel;
    private TableView<StudentEntry> gradeTable;

    private static final String CSV_FILE_PATH = "grades.csv";

    @Override
    public void start(Stage primaryStage) {
        // Layout setup
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(15);
        grid.setPadding(new Insets(10, 10, 10, 10));

        // UI Components
        firstNameField = new TextField();
        lastNameField = new TextField();
        courseField = new TextField();
        scoreField = new TextField();
        totalPointsField = new TextField();
        gradeLabel = new Label();
        errorLabel = new Label();

        

        scoreField.setOnKeyReleased(event -> calculateGrade());
        totalPointsField.setOnKeyReleased(event -> calculateGrade());

        // Labels and Fields
        grid.add(new Label("First Name:"), 0, 0);
        grid.add(firstNameField, 1, 0);
        grid.add(new Label("Last Name:"), 0, 1);
        grid.add(lastNameField, 1, 1);
        grid.add(new Label("Course:"), 0, 2);
        grid.add(courseField, 1, 2);

        // Score and Total Points on Same Row
        grid.add(new Label("Score:"), 0, 3);
        grid.add(scoreField, 1, 3);
        grid.add(new Label("Total Points:"), 2, 3);
        grid.add(totalPointsField, 3, 3);

        grid.add(new Label("Grade:"), 0, 4);
        grid.add(gradeLabel, 1, 4);
        
        errorLabel.setWrapText(true);
        HBox errorBox = new HBox(errorLabel);
        errorBox.setPadding(new Insets(5, 0, 0, 0));
        errorBox.setAlignment(Pos.CENTER_LEFT);
        errorBox.setMaxWidth(Double.MAX_VALUE);
        grid.add(errorBox, 0, 6, 4, 1);

        // Buttons

        Button viewGradesButton = new Button("View Grades");
        viewGradesButton.setOnAction(e -> loadGradesToTable());
        viewGradesButton.setStyle("-fx-background-color: #18a7db; -fx-text-fill: white;");


        Button clearButton = new Button("Clear");
        clearButton.setOnAction(e -> clearForm());
        clearButton.setStyle("-fx-background-color: #f73131; -fx-text-fill: white;"); 


        Button saveButton = new Button("Save");
        saveButton.setOnAction(e -> saveGradeEntry());
        saveButton.setStyle("-fx-background-color: #06c20f; -fx-text-fill: white;"); 

        HBox leftButtonContainer = new HBox(viewGradesButton);
        leftButtonContainer.setAlignment(Pos.BASELINE_LEFT);
        
        HBox rightButtonContainer = new HBox(10, clearButton, saveButton);
        rightButtonContainer.setAlignment(Pos.BASELINE_RIGHT);

        HBox buttonContainer = new HBox(leftButtonContainer, rightButtonContainer);
        buttonContainer.setAlignment(Pos.CENTER);
        HBox.setHgrow(leftButtonContainer, Priority.ALWAYS);
        
        grid.add(buttonContainer, 0, 5, 4, 1);

        // TableView setup for displaying grades
        gradeTable = new TableView<>();
        gradeTable.setPrefHeight(200);

        // Define table columns
        TableColumn<StudentEntry, String> firstNameCol = new TableColumn<>("First Name");
        firstNameCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getFirstName()));

        TableColumn<StudentEntry, String> lastNameCol = new TableColumn<>("Last Name");
        lastNameCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getLastName()));

        TableColumn<StudentEntry, String> courseCol = new TableColumn<>("Course");
        courseCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getCourse()));

        TableColumn<StudentEntry, String> scoreCol = new TableColumn<>("Score");
        scoreCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getScore()));

        TableColumn<StudentEntry, String> totalPointsCol = new TableColumn<>("Total Points");
        totalPointsCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getTotalPoints()));

        TableColumn<StudentEntry, String> gradeCol = new TableColumn<>("Grade");
        gradeCol.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getGrade()));

        gradeTable.getColumns().addAll(firstNameCol, lastNameCol, courseCol, scoreCol, totalPointsCol, gradeCol);

        // VBox layout
        VBox vbox = new VBox(10, grid, gradeTable);
        vbox.setPadding(new Insets(10));

        // Scene setup
        Scene scene = new Scene(vbox, 700, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("GradeBookApp");
        primaryStage.show();
    }

    // Calculate grade based on score and total points
    private void calculateGrade() {
        try {
            double score = Double.parseDouble(scoreField.getText());
            double totalPoints = Double.parseDouble(totalPointsField.getText());
            if (totalPoints > 0) {
                double percentage = (score / totalPoints) * 100;
                String grade = determineGrade(percentage);
                gradeLabel.setText(grade); // Display calculated grade in label
            }
        } catch (NumberFormatException e) {
            errorLabel.setStyle("-fx-text-fill: red;");
            errorLabel.setText("");
        }
    }

    private String determineGrade(double percentage) {
        if (percentage >= 90) return "A";
        if (percentage >= 80) return "B";
        if (percentage >= 70) return "C";
        if (percentage >= 60) return "D";
        return "F";
    }

    private void saveGradeEntry() {
        // Get input values
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String course = courseField.getText();
        String scoreText = scoreField.getText();
        String totalPointsText = totalPointsField.getText();
    
        // Check if all fields are filled
        if (firstName.isEmpty() || lastName.isEmpty() || course.isEmpty() || scoreText.isEmpty() || totalPointsText.isEmpty()) {
            errorLabel.setStyle("-fx-text-fill: red;");
            errorLabel.setText("All fields must be filled in to save.");
            return;
        }

         // Check for commas in the fields
         if (firstName.contains(",") || lastName.contains(",") || course.contains(",") || scoreText.contains(",") || totalPointsText.contains(",")) {
            errorLabel.setStyle("-fx-text-fill: red;");
            errorLabel.setText("Commas are not allowed in the input fields.");
            return;
         }
    
        try {
            double score = Double.parseDouble(scoreText);
            double totalPoints = Double.parseDouble(totalPointsText);
    
            // Validate numeric values
            if (totalPoints <= 0) {
                errorLabel.setStyle("-fx-text-fill: red;");
                errorLabel.setText("Total points must be greater than 0.");
                return;
            }
            if (score > totalPoints) {
                errorLabel.setStyle("-fx-text-fill: red;");
                errorLabel.setText("Score cannot exceed total points.");
                return;
            }

            
    
            // Calculate grade
            double percentage = (score / totalPoints) * 100;
            String grade = determineGrade(percentage);
    
            // Save entry to CSV
            String csvLine = firstName + "," + lastName + "," + course + "," + score + "," + totalPoints + "," + grade;
            
            try (BufferedWriter writer = new BufferedWriter(new FileWriter(CSV_FILE_PATH, true))) {
                // Add header if the file is empty
                if (Files.size(Paths.get(CSV_FILE_PATH)) == 0) {
                    writer.write("firstName,lastName,course,score,totalPoints,grade\n");
                }
                writer.write(csvLine + "\n");
                errorLabel.setStyle("-fx-text-fill: green;");
                errorLabel.setText("Entry saved successfully.");
                clearForm();
            } catch (IOException e) {
                errorLabel.setStyle("-fx-text-fill: red;");
                errorLabel.setText("Error saving entry: " + e.getMessage());
            }
        } catch (NumberFormatException e) {
            errorLabel.setStyle("-fx-text-fill: red;");
            errorLabel.setText("Please enter valid numeric values for score and total points.");
        }
    }
    

    private void clearForm() {
        firstNameField.clear();
        lastNameField.clear();
        courseField.clear();
        scoreField.clear();
        totalPointsField.clear();
        gradeLabel.setText("");
    }

    // Loads grades.csv data into TableView
    private void loadGradesToTable() {
        gradeTable.getItems().clear();
        try (BufferedReader reader = new BufferedReader(new FileReader(CSV_FILE_PATH))) {
            String line;
            reader.readLine(); // skip header
            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                if (fields.length == 6) {
                    gradeTable.getItems().add(new StudentEntry(fields[0], fields[1], fields[2], fields[3], fields[4], fields[5]));
                }
            }
        } catch (IOException e) {
            errorLabel.setStyle("-fx-text-fill: red;");
            errorLabel.setText("Error loading entries: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }

    public static class StudentEntry {
        private final String firstName;
        private final String lastName;
        private final String course;
        private final String score;
        private final String totalPoints;
        private final String grade;

        public StudentEntry(String firstName, String lastName, String course, String score, String totalPoints, String grade) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.course = course;
            this.score = score;
            this.totalPoints = totalPoints;
            this.grade = grade;
        }

        public String getFirstName() { return firstName; }
        public String getLastName() { return lastName; }
        public String getCourse() { return course; }
        public String getScore() { return score; }
        public String getTotalPoints() { return totalPoints; }
        public String getGrade() { return grade; }
    }
}
