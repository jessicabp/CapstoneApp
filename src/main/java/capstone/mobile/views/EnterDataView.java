package capstone.mobile.views;

import capstone.mobile.App;
import capstone.mobile.classes.*;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;


/**
 * View for users to enter data about a capture (e.g. animal/maintenance)
 */
public class EnterDataView extends View {

    private Walk walk;
    private int  animal;
    private static List<Animal> animalList       = new ArrayList<>();
    private        Insets       gridButtonInsets = new Insets(40, 0, 40, 0); // for making buttons taller

    public EnterDataView(String name, Walk walk) {
        super(name);

        this.walk = walk;

        getStylesheets().add(EnterDataView.class.getResource("secondary.css").toExternalForm());

        // Create animal selection buttons
        ToggleGroup    group = new ToggleGroup();
        CustomGridPane grid  = new CustomGridPane(2);
        // Add first 4 animal to grid and toggle group
        int animalNo = 0;
        for (int r = 0; r < 2; r++) {
            for (int c = 0; c < 2; c++) {
                Animal       nextAnimal = animalList.get(animalNo);
                ToggleButton button     = new ToggleButton(nextAnimal.getName());
                button.setToggleGroup(group);
                button.setOnAction(e -> animal = nextAnimal.getId());
                button.setMaxWidth(Double.MAX_VALUE);
                button.setPadding(gridButtonInsets); // TODO: Not working. Need to make buttons taller.
                grid.add(button, c, r);
                animalNo++;
            }
        }

        // Create button with popup for other animal options
        ToggleButton other = new ToggleButton("Other");

        // Popup for selecting other animal
        CustomPopupView animalPopup = new CustomPopupView(other);
        ToggleGroup     otherGroup  = new ToggleGroup();
        CustomGridPane  otherGrid   = new CustomGridPane(2);
        otherGrid.setPadding(new Insets(20, 20, 20, 20));
        // Add all animal to grid and toggle group
        int r = 0;
        for (; r < (animalList.size() - 4) / 2; r++) {
            for (int c = 0; c < 2; c++) {
                Animal       nextAnimal = animalList.get(animalNo);
                ToggleButton button     = new ToggleButton(nextAnimal.getName());
                button.setToggleGroup(otherGroup);
                button.setOnAction(ev -> {
                    animal = nextAnimal.getId();
                    animalPopup.hide();
                });
                button.setMaxWidth(Double.MAX_VALUE); // TODO: other animal buttons aren't wide enough
                button.setPadding(gridButtonInsets); // TODO: Not working. Need to make buttons taller.
                otherGrid.add(button, c, r);
                animalNo++;
            }
        }
        // If there's an odd number of animal, make sure the last one is included
        if (animalList.size() % 2 != 0) {
            Animal       nextAnimal = animalList.get(animalNo);
            ToggleButton button     = new ToggleButton(nextAnimal.getName());
            button.setToggleGroup(otherGroup);
            button.setOnAction(ev -> {
                animal = nextAnimal.getId();
                animalPopup.hide();
            });
            button.setMaxWidth(Double.MAX_VALUE);
            button.setPadding(gridButtonInsets); // TODO: Not working. Need to make buttons taller.
            otherGrid.add(button, 0, r);
        }
        animalPopup.setContent(otherGrid);

        // Settings for other animal button
        other.setMaxWidth(Double.MAX_VALUE);
        other.setToggleGroup(group);
        other.setOnAction(e -> {
            other.setSelected(true);
            animalPopup.show();
        });

        // Add button to mark trap as done
        Button done = new Button("Done");
        done.setMaxWidth(Double.MAX_VALUE);
        done.setOnAction(e -> {
            if (group.getSelectedToggle() != null) {
                walk.addCapture(new Capture(walk.getCurrentTrap().getId(), animal));
                group.getSelectedToggle().setSelected(false);
                if (walk.getCurrentTrap() != walk.getFinishTrap()) {
                    walk.finishCurrentTrap();
                    // Switch to another view and back to refresh data on screen
                    App.getInstance().switchScreen(App.ENTER_DATA_VIEW);
                    App.getInstance().switchScreen(App.DO_WALK_VIEW);
                } else {
                    App.getInstance().switchScreen(App.END_WALK_VIEW);
                }
            } else {
                done.setText("Please select a animal");
            }
        });
        done.setGraphic(MaterialDesignIcon.SAVE.graphic());

        // Add buttons to add image or maintenance info
        HBox   hb3   = new HBox(15.0);
        Button photo = new Button("Photo");
        photo.setOnAction(e -> App.getInstance().switchScreen(App.CAMERA));
        Button maintenance = new Button("Maintenance");
        maintenance.setOnAction(e -> App.getInstance().switchScreen(App.MAINTENANCE));
        hb3.getChildren().addAll(photo, maintenance);
        hb3.setAlignment(Pos.CENTER);

        // Create VBox for all items
        VBox controls = new VBox(15.0, grid, other, done, hb3);
        controls.setPadding(new Insets(40, 40, 40, 40));
        controls.setAlignment(Pos.CENTER);
        setCenter(controls);
    }

    public static void addAnimalFromDB(Animal animal) {
        animalList.add(animal);
    }

    public static List<Animal> getAnimalList() {
        return animalList;
    }

    public static void setAnimalList(List<Animal> fetchedAnimalList) {
        animalList = fetchedAnimalList;
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> MobileApplication.getInstance().showLayer(App.MENU_LAYER)));
        appBar.setTitleText("Trap #" + walk.getCurrentTrap().getNumber());
    }
}