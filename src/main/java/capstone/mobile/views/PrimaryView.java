package capstone.mobile.views;

import capstone.mobile.models.Line;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.control.Icon;
import com.gluonhq.charm.glisten.control.TextField;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import capstone.mobile.App;
import com.gluonhq.connect.GluonObservableList;
import com.gluonhq.connect.converter.InputStreamIterableInputConverter;
import com.gluonhq.connect.provider.DataProvider;
import com.gluonhq.connect.provider.RestClient;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.transformation.FilteredList;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;

import java.util.Collections;

public class PrimaryView extends View {

    public PrimaryView(String name) {
        super(name);

        // this.app = app;

        RestClient restClient = RestClient.create()
                .method("GET")
                .host("http://traptracker.pythonanywhere.com")
                .path("/line");

        InputStreamIterableInputConverter<Line> converter = new ItemsIterableInputConverter<>(Line.class);

        // retrieve a list from the DataProvider
        GluonObservableList<Line> errors = DataProvider.retrieveList(restClient.createListDataReader(converter));
        Collections.sort(errors);

        ListView<Line> lvErrors = new ListView<>(errors);

        lvErrors.setCellFactory(lv -> new ListCell<Line>() {
            @Override
            protected void updateItem(Line item, boolean empty) {
                super.updateItem(item, empty);

                if (!empty) {
                    // setText(item.getId() + " - " + item.getName());
                    setText(item.getName());
                } else {
                    setText(null);
                }
            }
        });

        lvErrors.getSelectionModel().selectedItemProperty().addListener(
                new ChangeListener<Line>() {
                    @Override
                    public void changed(ObservableValue<? extends Line> observable, Line oldValue, Line newValue) {
                        int id = newValue.getId();
                        System.out.println("Switching screens..");
                        // app.switchView2("Selected Lines View", id);
                    }
                }
        );


        TextField filter = new TextField();
        filter.textProperty().addListener((observable, oldValue, newValue) -> {

            String search = filter.getText().toLowerCase();
            final FilteredList<Line> f = new FilteredList<>(errors);
            f.setPredicate(s -> s.getName().toLowerCase().startsWith(search));
            lvErrors.setItems(f);
            lvErrors.setCellFactory(lv -> new ListCell<Line>() {
                @Override
                protected void updateItem(Line item, boolean empty) {
                    super.updateItem(item, empty);

                    if (!empty) {
                        // setText(item.getId() + " - " + item.getName());
                        setText(item.getName());
                    } else {
                        setText(null);
                    }
                }
            });
        });

        VBox layout = new VBox();
        layout.getChildren().add(filter);
        layout.getChildren().addAll(lvErrors);


        setCenter(layout);
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> MobileApplication.getInstance().showLayer(App.MENU_LAYER)));
        appBar.setTitleText("Select Line Trap");
        // appBar.getActionItems().add(MaterialDesignIcon.SEARCH.button(e -> System.out.println("Search")));
    }

}
