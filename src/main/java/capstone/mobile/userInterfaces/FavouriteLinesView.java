/*
This file is part of Trap Tracker.

Trap Tracker is free software: you can redistribute it and/or modify
it under the terms of the GNU General Public License as published by
the Free Software Foundation, either version 3 of the License, or
(at your option) any later version.

Trap Tracker is distributed in the hope that it will be useful,
but WITHOUT ANY WARRANTY; without even the implied warranty of
MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
GNU General Public License for more details.

You should have received a copy of the GNU General Public License
along with Trap Tracker.  If not, see <http://www.gnu.org/licenses/>.
 */

package capstone.mobile.userInterfaces;

import capstone.mobile.App;
import capstone.mobile.dataHandlers.DataUnavailableException;
import capstone.mobile.dataHandlers.LocalDatabase;
import capstone.mobile.models.Animal;
import capstone.mobile.models.Line;
import capstone.mobile.models.Walk;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import com.gluonhq.connect.GluonObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;

import java.sql.SQLException;
import java.util.List;

/**
 * Fetches and displays searchable list of available lines from server
 * Allows user to open line, checks password
 */
public class FavouriteLinesView extends DisplayLinesView {

    private static GluonObservableList<Line> observableLinesList = new GluonObservableList<>();
    private Walk walk;
    private VBox controls;
    private TextField      filter        = new TextField();
    private ListView<Line> linesListView = new ListView<>();

    public FavouriteLinesView(String name, Walk walk) {
        super(name, walk);
        this.walk = walk;

        getStylesheets().add(DisplayLinesView.class.getResource("linelist.css").toExternalForm());
        getStylesheets().add(FavouriteLinesView.class.getResource("userinterface.css").toExternalForm());

        // Create VBox to hold items
        controls = new VBox();
        controls.getStylesheets().add(DisplayLinesView.class.getResource("linelist.css").toExternalForm());
        controls.getStylesheets().add(FavouriteLinesView.class.getResource("userinterface.css").toExternalForm());
        controls.setAlignment(Pos.CENTER);
        setTop(controls);

        // Create ListView to hold lines
        linesListView = new ListView<>(observableLinesList);

        // Create filter so users can search lines
        filter.setPromptText("Search");
        filter.textProperty().addListener((observable, oldValue, newValue) -> {
            String             search = filter.getText().toLowerCase();
            FilteredList<Line> f      = new FilteredList<>(observableLinesList);
            f.setPredicate(s -> s.getName().toLowerCase().contains(search));
            linesListView.setItems(f);
        });

        // Set cell factory to create a cell for each line
        linesListView.setCellFactory(lv -> new ListCell<Line>() {
            @Override
            protected void updateItem(Line line, boolean empty) {
                super.updateItem(line, empty);
                if (empty) {
                    setText(null);
                } else {
                    setText(line.getName());
                }
                setPadding(new Insets(5, 10, 5, 10));
                setWrapText(true);
            }
        });

        // Add listener to cells
        linesListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newLine) -> {
            if (newLine != null) {
                LocalDatabase.setCurrentLine(newLine);
                selectLine(newLine, controls);
            }
        });

        // Add items to VBox
        controls.getChildren().addAll(filter, linesListView);
    }

    /**
     * Fetches lines from the server, shows popup if it fails
     */
    private void updateLinesList() {
        List<Line>   linesList  = null;
        List<Animal> animalList = null;

        // Load data from database
        try {
            linesList = LocalDatabase.fetchLines();
            animalList = LocalDatabase.updateAnimals();
        } catch (DataUnavailableException | SQLException e) {
            showServerError(controls);
            e.printStackTrace();
        }

        // Add lines to observable list so they are displayed in the ListView
        observableLinesList.clear();
        if (linesList.size() > 0) {
            observableLinesList.addAll(linesList);
        }

        // Add animals to list of animals
        if (animalList != null) {
            EnterDataView.setAnimalList(animalList);
        }

        // Clear search box
        filter.setText("");
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> MobileApplication.getInstance().showLayer(App.MENU_LAYER)));
        appBar.setTitleText("Pre-visited lines");
        appBar.getActionItems().add(MaterialDesignIcon.UNDO.button(e -> App.getInstance().switchScreen(App.HOME_VIEW)));

        updateLinesList();
    }
}
