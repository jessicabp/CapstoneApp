package capstone.mobile.classes;


import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class CustomGridPane extends GridPane {

    public CustomGridPane() {
        super();

        getColumnConstraints().add(new ColumnConstraints());
        getColumnConstraints().add(new ColumnConstraints());
        getColumnConstraints().get(0).setPercentWidth(50);
        getColumnConstraints().get(0).setHgrow(Priority.SOMETIMES);
        getColumnConstraints().get(1).setPercentWidth(50);
        getColumnConstraints().get(1).setHgrow(Priority.SOMETIMES);

        setHgap(10);
        setVgap(10);
    }
}