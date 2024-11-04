package GradeBookApp;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class KnebelGradeBookApp extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        // Layout
        GridPane grid = new GridPane();
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));

        // Labels and Fields
        Label firstNameLabel = new Label("First Name:");
        TextField firstNameField = new TextField();
        grid.add(firstNameLabel, 0, 0);
        grid.add(firstNameField, 1, 0);

        Label lastNameLabel = new Label("Last Name:");
        TextField lastNameField = new TextField();
        grid.add(lastNameLabel, 0, 1);
        grid.add(lastNameField, 1, 1);

        Label courseLabel = new Label("Course:");
        TextField courseField = new TextField();
        grid.add(courseLabel, 0, 2);
        grid.add(courseField, 1, 2);

        Label gradeLabel = new Label("Grade:");
        TextField gradeField = new TextField();  // Or you can use ComboBox<String> for letter grades
        grid.add(gradeLabel, 0, 3);
        grid.add(gradeField, 1, 3);

        // Buttons
        Button saveButton = new Button("Save");
        Button clearButton = new Button("Clear");
        Button viewGradesButton = new Button("View Grades");

        grid.add(saveButton, 0, 4);
        grid.add(clearButton, 1, 4);
        grid.add(viewGradesButton, 2, 4);

        // Set scene and stage
        Scene scene = new Scene(grid, 500, 250);
        primaryStage.setScene(scene);
        primaryStage.setTitle("GradeBookApp");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
