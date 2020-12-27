package sec02.exam03_stage_scene;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class AppMain extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		VBox root = new VBox();
		root.setPrefWidth(350);
		root.setPrefHeight(150);
		root.setAlignment(Pos.CENTER);	//정렬
		root.setSpacing(20);			//간격
		
		Label label = new Label();		//글자표현 컴퍼넌트
		label.setText("Hello, JavaFx");
		label.setFont(new Font(50));
		
		Button button = new Button();
		button.setText("나를 눌러도 종료");
		button.setOnAction(event->Platform.exit());	//System.exit(0)해도 종료 , Platform이 javafx에서 제공
		
		root.getChildren().add(label);
		root.getChildren().add(button);
		
		
		
		Scene scene = new Scene(root);
		primaryStage.setTitle("AppMain");
		primaryStage.setScene(scene);	//primaryStage 윈도우창
		primaryStage.show();
		
	}
	public static void main(String[] args) {
		launch(args);

	}

}
