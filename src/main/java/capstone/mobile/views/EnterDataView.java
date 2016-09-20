package capstone.mobile.views;

import capstone.mobile.App;
import capstone.mobile.classes.*;
import com.gluonhq.charm.glisten.application.GlassPane;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.layout.layer.PopupView;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.List;

import static java.util.Arrays.asList;


/**
 * View for users to enter data about a capture (e.g. species/maintenance)
 */
public class EnterDataView extends View {

    private Walk walk;
    private int  species;
    private Insets        gridButtonInsets = new Insets(40, 0, 40, 0); // for making buttons taller
    // TODO: load species from line?
    private List<Species> speciesList      = ListDataSource.fetchSpeciesList();

    public EnterDataView(String name, Walk walk) {
        super(name);

        this.walk = walk;

        getStylesheets().add(EnterDataView.class.getResource("secondary.css").toExternalForm());

        // Create species selection buttons
        ToggleGroup group = new ToggleGroup();
        CustomGridPane grid = new CustomGridPane();
        // Add first 4 species to grid and toggle group
        int speciesNo = 0;
        for (int r = 0; r < 2; r++) {
            for (int c = 0; c < 2; c++) {
                Species nextSpecies = speciesList.get(speciesNo);
                ToggleButton button = new ToggleButton(nextSpecies.getName());
                button.setToggleGroup(group);
                button.setOnAction(e -> species = nextSpecies.getId());
                button.setMaxWidth(Double.MAX_VALUE);
                button.setPadding(gridButtonInsets); // TODO: Not working. Need to make buttons taller.
                grid.add(button, c, r);
                speciesNo++;
            }
        }

        // Create button with popup for other species options
        ToggleButton other = new ToggleButton("Other");

        // Popup for selecting other species
        PopupView   speciesPopup = new PopupView(other);
        ToggleGroup otherGroup   = new ToggleGroup();
        CustomGridPane otherGrid = new CustomGridPane();
        otherGrid.setPadding(new Insets(20, 20, 20, 20));
        // Add all species to grid and toggle group
        int r = 0;
        for (; r < (speciesList.size()-4) / 2; r++) {
            for (int c = 0; c < 2; c++) {
                Species nextSpecies = speciesList.get(speciesNo);
                ToggleButton button = new ToggleButton(nextSpecies.getName());
                button.setToggleGroup(otherGroup);
                button.setOnAction(ev -> {
                    species = nextSpecies.getId();
                    speciesPopup.hide();
                    App.getInstance().getGlassPane().setBackgroundFade(0);
                });
                button.setMaxWidth(Double.MAX_VALUE); // TODO: other species buttons aren't wide enough
                button.setPadding(gridButtonInsets); // TODO: Not working. Need to make buttons taller.
                otherGrid.add(button, c, r);
                speciesNo++;
            }
        }
        // If there's an odd number of species, make sure the last one is included
        if (speciesList.size() % 2 != 0) {
            Species nextSpecies = speciesList.get(speciesNo);
            ToggleButton button = new ToggleButton(nextSpecies.getName());
            button.setToggleGroup(otherGroup);
            button.setOnAction(ev -> {
                species = nextSpecies.getId();
                speciesPopup.hide();
                App.getInstance().getGlassPane().setBackgroundFade(0);
            });
            button.setMaxWidth(Double.MAX_VALUE);
            button.setPadding(gridButtonInsets); // TODO: Not working. Need to make buttons taller.
            otherGrid.add(button, 0, r);
        }
        speciesPopup.setContent(otherGrid);

        // Settings for other species button
        other.setMaxWidth(Double.MAX_VALUE);
        other.setToggleGroup(group);
        other.setOnAction(e -> {
            other.setSelected(true);
            speciesPopup.show();
            App.getInstance().getGlassPane().setBackgroundFade(GlassPane.DEFAULT_BACKGROUND_FADE_LEVEL);
        });

        // Add button to mark trap as done
        Button done = new Button("Done");
        done.setMaxWidth(Double.MAX_VALUE);
        done.setOnAction(e -> {
            if (group.getSelectedToggle() != null) {
                walk.addCapture(new Capture(walk.getCurrentTrap().getId(), species));
                group.getSelectedToggle().setSelected(false);
                if (walk.getCurrentTrap() != walk.getFinishTrap()) {
                    walk.finishCurrentTrap();
                    // Switch to another view and back to refresh data on screen
                    App.getInstance().switchView(App.ENTER_DATA_VIEW);
                    App.getInstance().switchView(App.DO_WALK_VIEW);
                } else {
                    App.getInstance().switchView(App.END_WALK_VIEW);
                }
            } else {
                done.setText("Please select a species");
            }
        });
        done.setGraphic(MaterialDesignIcon.SAVE.graphic());

        // Add buttons to add image or maintenance info
        HBox   hb3   = new HBox(15.0);
        Button photo = new Button("Photo");
        photo.setOnAction(e -> App.getInstance().switchView(App.CAMERA));
        Button maintenance = new Button("Maintenance");
        maintenance.setOnAction(e -> App.getInstance().switchView(App.MAINTENANCE));
        hb3.getChildren().addAll(photo, maintenance);
        hb3.setAlignment(Pos.CENTER);

        // Create VBox for all items
        VBox controls = new VBox(15.0, grid, other, done, hb3);
        controls.setPadding(new Insets(40, 40, 40, 40));
        controls.setAlignment(Pos.CENTER);
        setCenter(controls);
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> MobileApplication.getInstance().showLayer(App.MENU_LAYER)));
        appBar.setTitleText("Trap #" + walk.getCurrentTrap().getNumber());
    }
}