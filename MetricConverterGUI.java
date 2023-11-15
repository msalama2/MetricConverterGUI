import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class MetricConverterGUI extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Metric Conversion App");

        Label titleLabel = new Label("Welcome to Metric Conversion App");
        titleLabel.setStyle("-fx-font-size: 18px; -fx-font-weight: bold;");

        Label instructionsLabel = new Label("Select a conversion:");
        ComboBox<String> conversionOptions = new ComboBox<>();
        conversionOptions.getItems().addAll(
                "Celsius to Fahrenheit",
                "Fahrenheit to Celsius",
                "Kilograms to Pounds",
                "Pounds to Kilograms"
        );

        Label inputLabel = new Label("Enter value:");
        TextField inputField = new TextField();

        Button convertButton = new Button("Convert");
        Label resultLabel = new Label();

        VBox layout = new VBox(10);
        layout.setStyle("-fx-padding: 20px;");
        layout.getChildren().addAll(
                titleLabel, instructionsLabel, conversionOptions,
                inputLabel, inputField, convertButton, resultLabel
        );

        convertButton.setOnAction(e -> {
            String conversion = conversionOptions.getValue();
            String input = inputField.getText();

            switch (conversion) {
                case "Celsius to Fahrenheit":
                    try {
                        double celsius = Double.parseDouble(input);
                        double fahrenheit = (celsius * 9 / 5) + 32;
                        resultLabel.setText("Conversion result: " + fahrenheit + " Fahrenheit");
                    } catch (NumberFormatException ex) {
                        resultLabel.setText("Invalid input. Enter a valid number.");
                    }
                    break;

                case "Fahrenheit to Celsius":
                    try {
                        double fahrenheit = Double.parseDouble(input);
                        double celsius = (fahrenheit - 32) * 5 / 9;
                        resultLabel.setText("Conversion result: " + celsius + " Celsius");
                    } catch (NumberFormatException ex) {
                        resultLabel.setText("Invalid input. Enter a valid number.");
                    }
                    break;

                case "Kilograms to Pounds":
                    try {
                        double kilograms = Double.parseDouble(input);
                        double pounds = kilograms * 2.205;
                        resultLabel.setText("Conversion result: " + pounds + " Pounds");
                    } catch (NumberFormatException ex) {
                        resultLabel.setText("Invalid input. Enter a valid number.");
                    }
                    break;

                case "Pounds to Kilograms":
                    try {
                        double pounds = Double.parseDouble(input);
                        double kilograms = pounds / 2.205;
                        resultLabel.setText("Conversion result: " + kilograms + " Kilograms");
                    } catch (NumberFormatException ex) {
                        resultLabel.setText("Invalid input. Enter a valid number.");
                    }
                    break;
            }
        });

        Scene scene = new Scene(layout, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
