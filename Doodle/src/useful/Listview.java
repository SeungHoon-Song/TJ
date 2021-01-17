package useful;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
 
public class Listview extends Application {
 
    Stage window;
    Scene scene;
    Button button;
    ListView<String> listView;
 
    public static void main(String[] args) {
        launch(args);
    }
 
    @Override
    public void start(Stage primaryStage) throws Exception {
        window = primaryStage;
        window.setTitle("PC방 채팅서비스");
        button = new Button("채팅하기");
 
        listView = new ListView<>();
        listView.getItems().addAll(
                "손님1",
                "손님2",
                "손님3",
                "손님4",
                "손님5",
                "손님6",
                "손님7",
                "손님8"
        );
        //listView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE); 다중선택 가능케함
 
        button.setOnAction(e -> buttonClicked());
 
        VBox layout = new VBox(20);
        layout.setPadding(new Insets(10,10,10,10));
        layout.getChildren().addAll(listView, button);
 
        scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.show();
    }
    private void buttonClicked() {
        String msg = "";
        ObservableList<String> menus;
        menus = listView.getSelectionModel().getSelectedItems();
 
        for(String m: menus){
            msg += m + " ";
        }
        System.out.println(msg);
    }
}