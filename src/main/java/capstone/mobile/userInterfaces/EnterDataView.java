package capstone.mobile.userInterfaces;

import capstone.mobile.App;
import capstone.mobile.models.Animal;
import capstone.mobile.models.Capture;
import capstone.mobile.models.Walk;
import capstone.mobile.other.CustomGridPane;
import capstone.mobile.other.CustomPopupView;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;


/**
 * View for users to enter data about a capture (e.g. animal/maintenance)
 */
public class EnterDataView extends View {

    private static List<Animal> animalList = new ArrayList<>();
    private Walk walk;
    private int  animal;
    private Insets gridButtonInsets = new Insets(40, 0, 40, 0); // for making buttons taller

    public EnterDataView(String name, Walk walk) {
        super(name);

        this.walk = walk;

        getStylesheets().add(EnterDataView.class.getResource("DataEntry.css").toExternalForm());
        getStylesheets().add(EnterDataView.class.getResource("secondary.css").toExternalForm());

        showButtons();
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

    private void showButtons() {
        // Create VBox for all items
        VBox controls = new VBox(20.0);
        controls.setPadding(new Insets(40, 40, 40, 40));
        controls.setAlignment(Pos.CENTER);
        setCenter(controls);

        // Create animal selection buttons
        ToggleGroup    group = new ToggleGroup();
        CustomGridPane grid  = new CustomGridPane(2);
        controls.getChildren().add(grid);
        // Add first 4 animal to grid and toggle group
        int animalNo = 0;
        for (int r = 0; r < 2; r++) {
            for (int c = 0; c < 2; c++) {
                Animal       nextAnimal = animalList.get(animalNo);
                ToggleButton button     = new ToggleButton(nextAnimal.getName());
                button.getStyleClass().add("tall");
                button.setToggleGroup(group);
                button.setOnAction(e -> animal = nextAnimal.getId());
                button.setMaxWidth(Double.MAX_VALUE);
                grid.add(button, c, r);
                animalNo++;
            }
        }

        // Create button with popup for other animal options
        ToggleButton other = new ToggleButton("Other");
        controls.getChildren().add(other);

        // Popup for selecting other animal
        CustomPopupView animalPopup = new CustomPopupView(grid);
        animalPopup.getStylesheets().add(EnterDataView.class.getResource("OtherAnimals.css").toExternalForm());
        animalPopup.getStylesheets().add(EnterDataView.class.getResource("secondary.css").toExternalForm());
        animalPopup.setPrefWidth(other.getMaxWidth());
        ToggleGroup otherGroup = new ToggleGroup();
        VBox        animalVB   = new VBox(10);
        animalVB.setPadding(new Insets(20, 20, 20, 20));
        // Add all animal to grid and toggle group
        int r = 0;
        for (; r < (animalList.size() - 4); r++) {
            Animal       nextAnimal = animalList.get(animalNo);
            ToggleButton button     = new ToggleButton(nextAnimal.getName());
            button.getStyleClass().add("tall");
            button.setToggleGroup(otherGroup);
            button.setOnAction(ev -> {
                animal = nextAnimal.getId();
                animalPopup.hide();
            });
            button.maxWidthProperty().bind(controls.widthProperty().subtract(120));
            button.minWidthProperty().bind(controls.widthProperty().subtract(120));
            animalVB.getChildren().add(button);
            animalNo++;
        }
        animalPopup.setContent(animalVB);

        // Settings for other animal button
        other.setMaxWidth(Double.MAX_VALUE);
        other.setToggleGroup(group);
        other.setOnAction(e -> {
            other.setSelected(true);
            animalPopup.show();
        });

        // Add button to mark trap as done
        Button done = new Button("DONE");
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
        controls.getChildren().add(done);

        // Add buttons to add image or maintenance info
        Button maintenance = new Button("Maintenance");
        maintenance.setMaxWidth(Double.MAX_VALUE);
        maintenance.setOnAction(e -> App.getInstance().switchScreen(App.MAINTENANCE));
        controls.getChildren().add(maintenance);
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> MobileApplication.getInstance().showLayer(App.MENU_LAYER)));
        appBar.setTitleText("Trap #" + walk.getCurrentTrap().getNumber());

        showButtons();
    }
}