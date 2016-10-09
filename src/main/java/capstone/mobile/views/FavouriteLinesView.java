package capstone.mobile.views;

import capstone.mobile.App;
import capstone.mobile.classes.*;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import com.gluonhq.connect.GluonObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.sql.*;
import java.util.ArrayList;
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

        getStylesheets().add(DisplayLinesView.class.getResource("LineList.css").toExternalForm());
        getStylesheets().add(FavouriteLinesView.class.getResource("secondary.css").toExternalForm());

        // Create VBox to hold items
        controls = new VBox();
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
                if (!empty) {
                    setText(line.getName());
                } else {
                    setText(null);
                }
                setPadding(new Insets(5, 10, 5, 10));
                setWrapText(true);
            }
        });

        // Add listener to cells
        linesListView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newLine) -> {
            if (newLine != null) {
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
        List<Line>   linesList  = new ArrayList<>();
        List<Animal> animalList = null;

        // Load data from database
        try (Connection dbConnection = DriverManager.getConnection(App.getInstance().dbUrl)) {
            Statement stmt    = dbConnection.createStatement();
            ResultSet linesRS = stmt.executeQuery("SELECT * FROM lines WHERE favourite like '%true%';");
            while (linesRS.next()) {
                // load line from database
                Line line   = new Line(linesRS.getInt("id"), linesRS.getString("name"), linesRS.getInt("a1"), linesRS.getInt("a2"), linesRS.getInt("a3"));
                linesList.add(line);
            }
            linesRS.close();
            animalList = RetrieveData.fetchAnimalList();
            // Update local database
            if (dbConnection != null) {
                stmt = dbConnection.createStatement();
                for (Animal animal : animalList) {
                    stmt.executeUpdate("insert or ignore into animals(id, name) values(" + animal.getId() + ", '" + animal.getName() + "')");
                }
            }
            stmt.close();
        } catch (DataUnavailableException | SQLException e) {
            showServerError();
            e.printStackTrace();
        }

        // Add lines to observable list so they are displayed in the ListView
        observableLinesList.clear();
        if (!(linesList.size() <= 0)) {
            observableLinesList.addAll(linesList);
        }

        // Add animals to list of animals
        EnterDataView.setAnimalList(animalList);

        // Clear search box
        filter.setText("");
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        super.updateAppBar(appBar);
        updateLinesList();
    }
}
