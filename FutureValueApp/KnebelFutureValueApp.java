package FutureValueApp;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class KnebelFutureValueApp extends Application {

    private TextField txtMonthlyPayment = new TextField();
    private TextField txtInterestRate = new TextField();
    private TextArea txtResult = new TextArea();
    private Label lblMonthlyPayment = new Label("Monthly Payment:");
    private Label lblInterestRate = new Label("Interest Rate:");
    private Label lblYears = new Label("Number of Years:");
    private Label lblFutureValue = new Label("Future Value:");
    private Label lblInterestRateFormat = new Label("Enter 11.1% as 11.1");
    private ComboBox<Integer> cmbYears = new ComboBox<>();
    private Button btnCalculate = new Button("Calculate");
    private Button btnClear = new Button("Clear");

    @Override
    public void start(Stage primaryStage) {

        // Initialize ComboBox with years (1 to 30)
        for (int i = 1; i <= 30; i++) {
            cmbYears.getItems().add(i);
        }
        cmbYears.setValue(1);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setPadding(new Insets(11.5, 12.5, 13.5, 14.5));
        grid.setHgap(5.5);
        grid.setVgap(5.5);

        grid.add(lblMonthlyPayment, 0, 0);
        grid.add(txtMonthlyPayment, 1, 0);
        grid.add(lblInterestRate, 0, 1);
        grid.add(txtInterestRate, 1, 1);
        grid.add(lblYears, 0, 2);
        grid.add(cmbYears, 1, 2);
        grid.add(lblFutureValue, 0, 3);
        grid.add(txtResult, 1, 3);

        lblInterestRateFormat.setTextFill(Color.RED);
        grid.add(lblInterestRateFormat, 1, 4);
        GridPane.setHalignment(lblInterestRateFormat, HPos.RIGHT);

        HBox actionBtnContainer = new HBox();
        actionBtnContainer.setPadding(new Insets(15, 0, 15, 30));
        actionBtnContainer.setSpacing(10);
        actionBtnContainer.getChildren().addAll(btnClear, btnCalculate);

        grid.add(actionBtnContainer, 1, 5);

        Scene scene = new Scene(grid, 700, 500);
        primaryStage.setTitle("Knebel Future Value App");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}