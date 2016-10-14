package capstone.mobile.other;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class CustomGridPane extends GridPane {

    /**
     * Customised so user can specify the number of columns in the grid
     * Grid automatically sizes all columns to same width and spaces cells out
     *
     * @param noOfColumns
     */
    public CustomGridPane(int noOfColumns) {
        super();

        for (int i = 0; i < noOfColumns; i++) {
            getColumnConstraints().add(new ColumnConstraints());
            getColumnConstraints().get(i).setPercentWidth(100 / noOfColumns);
            getColumnConstraints().get(i).setHgrow(Priority.SOMETIMES);
        }

        setHgap(10);
        setVgap(10);
    }
}