package capstone.mobile.views;

import capstone.mobile.App;
import capstone.mobile.classes.Capture;
import capstone.mobile.classes.Walk;
import com.gluonhq.charm.glisten.application.GlassPane;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.layout.layer.PopupView;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.*;

import java.util.List;

import static java.util.Arrays.asList;


/**
 * View for users to enter data about a trap (e.g. species)
 */
public class EnterDataView extends View {

    private Walk    walk;
    private int     species;

    public EnterDataView(String name, Walk walk) {
        super(name);

        this.walk = walk;

        getStylesheets().add(EnterDataView.class.getResource("secondary.css").toExternalForm());

        // Create species selection buttons
        ToggleGroup group = new ToggleGroup();
        // TODO: load species from line?
        List<String> speciesList = asList("Empty", "Rat", "Stoat", "Hedgehog");

        GridPane grid = new GridPane();
        // Make buttons fill screen width
        grid.getColumnConstraints().add(new ColumnConstraints());
        grid.getColumnConstraints().add(new ColumnConstraints());
        grid.getColumnConstraints().get(0).setPercentWidth(50);
        grid.getColumnConstraints().get(0).setHgrow(Priority.SOMETIMES);
        grid.getColumnConstraints().get(1).setPercentWidth(50);
        grid.getColumnConstraints().get(1).setHgrow(Priority.SOMETIMES);
        grid.setHgap(10);
        grid.setVgap(10);
        int speciesNo = 0;
        for (int r = 0; r < speciesList.size()/2; r++) {
            for (int c = 0; c < 2; c++) {
                ToggleButton button = new ToggleButton(speciesList.get(speciesNo));
                button.setToggleGroup(group);
                int finalSpeciesNo = speciesNo;
                button.setOnAction(e -> species = finalSpeciesNo);
                button.setMaxWidth(Double.MAX_VALUE);
                button.setMinHeight(200); // TODO: Not working. Need to make buttons taller.
                grid.add(button, c, r);
                speciesNo++;
            }
        }

        ToggleButton other = new ToggleButton("Other");
        other.setMaxWidth(Double.MAX_VALUE);
        other.setToggleGroup(group);
        other.setOnAction(e -> {
            other.setSelected(true);
            PopupView   speciesPopup = new PopupView(other);
            ToggleGroup otherGroup   = new ToggleGroup();
            HBox        otherHB1     = new HBox();
            otherHB1.setPadding(new Insets(40, 40, 40, 40));
            otherHB1.setSpacing(20);
            ToggleButton cat = new ToggleButton("Cat");
            cat.setToggleGroup(otherGroup);
            cat.setOnAction(ev -> {
                species = 4;
                speciesPopup.hide();
                App.getInstance().getGlassPane().setBackgroundFade(0);
            });
            cat.setMaxWidth(Double.MAX_VALUE);
            cat.setMaxHeight(60);
            ToggleButton otherSpecies = new ToggleButton("Other");
            otherSpecies.setToggleGroup(otherGroup);
            otherSpecies.setOnAction(ev -> {
                species = 5;
                speciesPopup.hide();
                App.getInstance().getGlassPane().setBackgroundFade(0);
            });
            otherSpecies.setMaxWidth(Double.MAX_VALUE);
            otherHB1.getChildren().addAll(cat, otherSpecies);
            otherHB1.setAlignment(Pos.CENTER);
            speciesPopup.setContent(otherHB1);
            speciesPopup.show();
            App.getInstance().getGlassPane().setBackgroundFade(GlassPane.DEFAULT_BACKGROUND_FADE_LEVEL);
        });

        // Add button to mark trap as done
        Button save = new Button("Done");
        save.setOnAction(e -> {
            if (group.getSelectedToggle() != null) {
                System.out.println("Current trap info:  " + walk.getCurrentTrap().getNumber() + "  " + species);
                walk.addCapture(new Capture(walk.getCurrentTrap().getId(), species));
                if (walk.getCurrentTrap() != walk.getFinishTrap()) {
                    walk.finishCurrentTrap();
                    App.getInstance().switchView(App.DO_WALK_VIEW);
                } else {
                    App.getInstance().switchView(App.END_WALK_VIEW);
                }
            } else {
                save.setText("Please select a species");
            }
        });
        save.setGraphic(MaterialDesignIcon.SAVE.graphic());

        // Add buttons to add image or maintenance info
        HBox   hb3   = new HBox(15.0);
        Button photo = new Button("Photo");
        photo.setOnAction(e -> App.getInstance().switchView(App.CAMERA));
        Button maintenance = new Button("Maintenance");
        maintenance.setOnAction(e -> App.getInstance().switchView(App.MAINTENANCE));
        hb3.getChildren().addAll(photo, maintenance);
        hb3.setAlignment(Pos.CENTER);

        VBox controls = new VBox(15.0, grid, other, save, hb3);
        controls.setPadding( new Insets(40, 40, 40, 40));
        controls.setAlignment(Pos.CENTER);
        setCenter(controls);
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> MobileApplication.getInstance().showLayer(App.MENU_LAYER)));
        appBar.setTitleText("Trap #" + walk.getCurrentTrap().getNumber());
    }
}