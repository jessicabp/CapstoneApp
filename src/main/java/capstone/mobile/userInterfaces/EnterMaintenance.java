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
import capstone.mobile.models.Walk;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.VBox;


/**
 * View used to enter optional maintenance data for the current trap
 */
public class EnterMaintenance extends View {

    private Walk walk;

    public EnterMaintenance(String name, Walk walk) {
        super(name);
        this.walk = walk;
        getStylesheets().add(EnterMaintenance.class.getResource("userinterface.css").toExternalForm());
    }

    /**
     * Sets up user interface each time the page is visited
     *
     * @param appBar
     */
    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> MobileApplication.getInstance().showLayer(App.MENU_LAYER)));
        appBar.setTitleText("Maintenance");
        appBar.getActionItems().add(MaterialDesignIcon.UNDO.button(e -> App.getInstance().switchScreen(App.ENTER_DATA_VIEW)));

        // buttons for damage
        CheckBox broken = new CheckBox("Broken");
        broken.setSelected(walk.getCurrentTrap().isBroken());

        // button for moved trap
        CheckBox moved = new CheckBox("Moved");
        moved.setSelected(walk.getCurrentTrap().isMoved());

        // button to save
        Button save = new Button("Done");
        save.setPadding(new Insets(40, 0, 0, 0));
        save.setOnAction(e -> saveMaintenance(broken, moved));
        save.setGraphic(MaterialDesignIcon.SAVE.graphic());

        // VBox to display all elements
        VBox controls = new VBox(20, broken, moved, save);
        controls.getStylesheets().add(EnterMaintenance.class.getResource("userinterface.css").toExternalForm());
        controls.setPadding(new Insets(40, 40, 40, 40));
        controls.setAlignment(Pos.CENTER);
        setCenter(controls);
    }

    /**
     * Add trap to changed list if broken/moved has changed, change page
     *
     * @param broken
     * @param moved
     */
    private void saveMaintenance(CheckBox broken, CheckBox moved) {
        if (broken.isSelected() != walk.getCurrentTrap().isBroken() || moved.isSelected() != walk.getCurrentTrap().isMoved()) {
            walk.getCurrentTrap().setMoved(moved.isSelected());
            walk.getCurrentTrap().setBroken(broken.isSelected());
            walk.addChangedTrap(walk.getCurrentTrap());
        }
        App.getInstance().switchScreen(App.ENTER_DATA_VIEW);
    }
}
