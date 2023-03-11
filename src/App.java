import calculation.Functions;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class App extends Application{
    double res;
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Stage primaryWindow = primaryStage;

        //Nodes
        Label title = new Label("EasyCalc =)");
        Font font = new Font(40);
        title.setFont(font);
        title.setAlignment(Pos.CENTER);
        GridPane.setConstraints(title, 0, 0);
        GridPane.setColumnSpan(title, GridPane.REMAINING);

        TextField operation = new TextField();
        operation.setPromptText("Input the operation");
        operation.setMinWidth(192);
        GridPane.setConstraints(operation, 0, 1);

        TextField result = new TextField();
        result.setMinWidth(192);
        result.setEditable(false);
        result.setPromptText("Operation result");
        GridPane.setConstraints(result, 0, 2);
        
        Button calculate = new Button("Calculate");
        calculate.setOnAction(event -> {
            String problem = operation.getText();
            res = Functions.answer(problem);
            if (res % (int)res == 0){
                result.setText((int)res+"");
            }else{
                result.setText(res+"");
            }
        });
        calculate.setPrefWidth(120);
        GridPane.setConstraints(calculate, 1, 1);

        Button close = new Button("Close");
        close.setOnAction(event -> primaryWindow.close());
        close.setPrefWidth(120);
        GridPane.setConstraints(close, 1, 2);

        

        //Scene
        GridPane layout = new GridPane();
        layout.setPadding(new Insets(12,12,12,12));
        layout.setVgap(6);
        layout.setHgap(6);
        layout.getChildren().addAll(title,operation,result,calculate,close);
        Scene sc1 = new Scene(layout, 342, 144);
        
        //Initialize
        primaryWindow.setScene(sc1);
        primaryWindow.setTitle("EasyCalc");
        primaryWindow.getIcons().add(new Image("/resources/icon.png"));
        primaryWindow.setResizable(false);
        primaryWindow.show();
        layout.requestFocus();
    }
}