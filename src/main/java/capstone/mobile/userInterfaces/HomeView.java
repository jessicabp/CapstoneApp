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
import capstone.mobile.models.Line;
import capstone.mobile.models.Trap;
import capstone.mobile.models.Walk;
import com.gluonhq.charm.down.common.PlatformFactory;
import com.gluonhq.charm.down.common.SettingService;
import com.gluonhq.charm.glisten.application.MobileApplication;
import com.gluonhq.charm.glisten.control.AppBar;
import com.gluonhq.charm.glisten.mvc.View;
import com.gluonhq.charm.glisten.visual.MaterialDesignIcon;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

public class HomeView extends View {

    private Walk walk;

    public HomeView(String name, Walk walk) {
        super(name);
        this.walk = walk;

        getStylesheets().add(HomeView.class.getResource("userinterface.css").toExternalForm());

        // Create VBox to hold items
        VBox controls = new VBox();
        controls.getStylesheets().add(HomeView.class.getResource("userinterface.css").toExternalForm());
        controls.setPadding(new Insets(40));
        controls.setSpacing(40);
        controls.setAlignment(Pos.CENTER);
        setCenter(controls);

        // Button to view favourite lines
        Button favLines = new Button("Select a line you've used before");
        favLines.setWrapText(true);
        favLines.setMaxWidth(Double.MAX_VALUE);
        favLines.setOnAction(e -> App.getInstance().switchScreen(App.FAVOURITE_LINES_VIEW));
        favLines.getStyleClass().add("tall");
        controls.getChildren().add(favLines);

        // Button to view all lines
        Button allLines = new Button("Select a new line");
        allLines.setWrapText(true);
        allLines.setMaxWidth(Double.MAX_VALUE);
        allLines.setOnAction(e -> App.getInstance().switchScreen(App.DISPLAY_LINES_VIEW));
        allLines.getStyleClass().add("tall");
        controls.getChildren().add(allLines);

        // If storage lists another page as the current page, restore information from local storage
        String currentPage = PlatformFactory.getPlatform().getSettingService().retrieve(App.currentPage) != null ? PlatformFactory.getPlatform().getSettingService().retrieve(App.currentPage) : App.HOME_VIEW;
        if (!currentPage.equals(App.HOME_VIEW)) {
            SettingService settingService = PlatformFactory.getPlatform().getSettingService();
            if (settingService.retrieve(App.currentLineID) != null) {
                int currentLineId = Integer.parseInt(settingService.retrieve(App.currentLineID));
                for (Line line : DisplayLinesView.getObservableLinesList()) {
                    if (line.getId() == currentLineId) {
                        walk.setLineAtRestart(line);
                    }
                }
                if (settingService.retrieve(App.endTrapID) != null) {
                    int currentTrapId = Integer.parseInt(settingService.retrieve(App.currentTrapID));
                    int endTrapId     = Integer.parseInt(settingService.retrieve(App.endTrapID));

                    Trap start = null;
                    Trap end   = null;
                    for (Trap trap : walk.getLine().getTraps()) {
                        if (trap.getId() == currentTrapId) {
                            start = trap;
                        }
                        if (trap.getId() == endTrapId) {
                            end = trap;
                        }
                    }
                    walk.startWalk(start, end);
                }
            }
        }
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> MobileApplication.getInstance().showLayer(App.MENU_LAYER)));
        appBar.setTitleText("Home");

        String currentPage = PlatformFactory.getPlatform().getSettingService().retrieve(App.currentPage) != null ? PlatformFactory.getPlatform().getSettingService().retrieve(App.currentPage) : App.HOME_VIEW;
        if (currentPage != App.HOME_VIEW) {
            if (!currentPage.equals(App.END_WALK_VIEW) || !(walk.getLine() == null)) { // if data has not already been sent while still on EndWalkView
                App.getInstance().switchScreen(currentPage);
            }
        }
    }
}
