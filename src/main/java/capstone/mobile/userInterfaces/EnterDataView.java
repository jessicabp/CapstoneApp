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
import capstone.mobile.models.Animal;
import capstone.mobile.models.Catch;
import capstone.mobile.models.Walk;
import capstone.mobile.other.CustomGridPane;
import capstone.mobile.other.CustomPopupView;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * View for users to enter data about a catch (e.g. animal/maintenance)
 */
public class EnterDataView extends View {

    private static List<Animal> animalList    = new ArrayList<>();
    private static ToggleButton selectedMain  = null;
    private static ToggleButton selectedOther = null;
    private        Button       done          = null;
    private Walk walk;
    private int  animal;
    private List<Animal> tempAnimalList = new ArrayList<>();

    public EnterDataView(String name, Walk walk) {
        super(name);

        this.walk = walk;

        getStylesheets().add(EnterDataView.class.getResource("userinterface.css").toExternalForm());
    }

    /**
     * Adds animal to animalList from the local database
     *
     * @param animal
     */
    public static void addAnimalFromDB(Animal animal) {
        animalList.add(animal);
    }

    public static List<Animal> getAnimalList() {
        return animalList;
    }

    public static void setAnimalList(List<Animal> fetchedAnimalList) {
        animalList = fetchedAnimalList;
    }

    /**
     * Sets up the buttons for selecting an animal (popular or other), entering maintenance, and saving the catch
     */
    private void showButtons() {
        // Create VBox for all items
        VBox controls = new VBox(20.0);
        controls.getStylesheets().add(EnterDataView.class.getResource("userinterface.css").toExternalForm());
        controls.setPadding(new Insets(40, 40, 40, 40));
        controls.setAlignment(Pos.CENTER);
        setCenter(controls);

        // Create temporary list of animals to remove popular animals from and create buttons
        tempAnimalList.clear();
        tempAnimalList.addAll(animalList);
        // Sorts animals by id (smallest to largest) to ensure correct ordering.
        Collections.sort(tempAnimalList, (a, b) -> a.getId() - b.getId());

        // Create animal selection buttons
        ToggleGroup    group = new ToggleGroup();
        CustomGridPane grid  = new CustomGridPane(2);
        controls.getChildren().add(grid);
        // Add first 4 animals (empty + 3 x line preferences) to grid and toggle group
        int[] animalNo    = {0, walk.getLine().getAnimal1(), walk.getLine().getAnimal2(), walk.getLine().getAnimal3()};
        int   animalIndex = 3;
        for (int r = 0; r < 2; r++) {
            for (int c = 0; c < 2; c++) {
                Animal       nextAnimal = tempAnimalList.remove(animalNo[animalIndex]);
                animalIndex--;
                ToggleButton button     = new ToggleButton(nextAnimal.getName());
                button.getStyleClass().add("tall");
                button.setUserData(nextAnimal.getId());
                button.setToggleGroup(group);
                // If button matches the remembered stored button, select it
                if (selectedMain != null && selectedMain.getUserData().equals(button.getUserData())) {
                    button.setSelected(true);
                }
                button.setOnAction(e -> {
                    animal = nextAnimal.getId();
                    selectedMain = button;
                    selectedOther = null;
                    done.setText("DONE");
                });
                button.setMaxWidth(Double.MAX_VALUE);
                grid.add(button, c, r);
            }
        }

        // Create button with popup for other animal options
        ToggleButton other = new ToggleButton("Other");
        controls.getChildren().add(other);
        other.setMaxWidth(Double.MAX_VALUE);
        other.setUserData("Other");
        other.setToggleGroup(group);
        // If button matches the remembered stored button, select it
        if (selectedMain != null && selectedMain.getUserData().equals(other.getUserData())) {
            other.setSelected(true);
        }

        // Popup for selecting other animal
        CustomPopupView animalPopup = new CustomPopupView(grid);
        animalPopup.getStylesheets().add(EnterDataView.class.getResource("userinterface.css").toExternalForm());
        animalPopup.setMinWidth(other.getWidth());
        ToggleGroup otherGroup = new ToggleGroup();
        VBox        animalVB   = new VBox(10);
        animalVB.getStylesheets().add(EnterDataView.class.getResource("userinterface.css").toExternalForm());
        animalVB.setPadding(new Insets(20, 20, 20, 20));
        // Create list view so user can scroll through items if there are too many
        ListView<ToggleButton>       content = new ListView<>();
        ObservableList<ToggleButton> items   = FXCollections.observableArrayList();
        content.setItems(items);
        animalVB.getChildren().add(content);
        // Add all non-popular animals to vbox and toggle group
        for (int i = 0; i < tempAnimalList.size(); i++) {
            Animal       nextAnimal = tempAnimalList.get(i);
            ToggleButton button     = new ToggleButton(nextAnimal.getName());
            button.getStyleClass().add("tall");
            button.setUserData(nextAnimal.getId());
            button.setToggleGroup(otherGroup);
            // If button matches the remembered stored button, select it
            if (selectedOther != null && selectedOther.getUserData().equals(button.getUserData())) {
                button.setSelected(true);
            }
            button.setOnAction(ev -> {
                animal = nextAnimal.getId();
                selectedMain = other;
                selectedOther = button;
                animalPopup.hide();
            });
            button.maxWidthProperty().bind(controls.widthProperty().subtract(120));
            button.minWidthProperty().bind(controls.widthProperty().subtract(120));
            items.add(button);
        }
        animalPopup.setContent(animalVB);

        // Settings for other animal button
        other.setOnAction(e -> {
            other.setSelected(true);
            animalPopup.show();
            done.setText("Done");
        });

        // Add button to mark trap as done
        done = new Button("DONE");
        done.setMaxWidth(Double.MAX_VALUE);
        done.setOnAction(e -> {
            // Check an animal is selected, then create catch and finish trap
            if ((group.getSelectedToggle() != null) && (!group.getSelectedToggle().getUserData().equals("Other") || (otherGroup.getSelectedToggle() != null))) {
                walk.addCatch(new Catch(walk.getCurrentTrap().getId(), animal));
                selectedMain = null;
                selectedOther = null;
                if (walk.getCurrentTrap().equals(walk.getEndTrap())) {
                    App.getInstance().switchScreen(App.END_WALK_VIEW);
                } else {
                    walk.endCurrentTrap();
                    App.getInstance().switchScreen(App.DO_WALK_VIEW);
                }
            } else {
                done.setText("Please select an animal");
            }
        });
        done.setGraphic(MaterialDesignIcon.SAVE.graphic());
        controls.getChildren().add(done);

        // Add buttons to add image or maintenance info
        Button maintenance = new Button("Trap Maintenance");
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