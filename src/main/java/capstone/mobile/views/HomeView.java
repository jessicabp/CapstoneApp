package capstone.mobile.views;


import capstone.mobile.App;
import capstone.mobile.classes.Line;
import capstone.mobile.classes.Trap;
import capstone.mobile.classes.Walk;
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

    private static String currentPage = PlatformFactory.getPlatform().getSettingService().retrieve(App.CURRENTPAGE) != null ? PlatformFactory.getPlatform().getSettingService().retrieve(App.CURRENTPAGE) : App.HOME_VIEW;

    public HomeView(String name, Walk walk) {
        super(name);

        getStylesheets().add(DisplayLinesView.class.getResource("primary.css").toExternalForm());

        // Create VBox to hold items
        VBox controls = new VBox();
        controls.setPadding(new Insets(40));
        controls.setSpacing(40);
        controls.setAlignment(Pos.CENTER);
        setCenter(controls);

        // Button to view lines
        Button lines = new Button("Select an existing line");
        lines.setMaxWidth(Double.MAX_VALUE);
        lines.setOnAction(e -> App.getInstance().switchScreen(App.DISPLAY_LINES_VIEW));
        controls.getChildren().add(lines);

        if (currentPage != App.HOME_VIEW) {
            SettingService settingService = PlatformFactory.getPlatform().getSettingService();
            if (settingService.retrieve(App.CURRENTLINEID) != null) {
                int currentLineId = Integer.parseInt(settingService.retrieve(App.CURRENTLINEID));
                for (Line line : DisplayLinesView.getObservableLinesList()) {
                    if (line.getId() == currentLineId) {
                        walk.setLineAtRestart(line);
                    }
                }
                if (settingService.retrieve(App.CURRENTTRAPID) != null) {
                    int currentTrapId = Integer.parseInt(settingService.retrieve(App.CURRENTTRAPID));
                    int endTrapId     = Integer.parseInt(settingService.retrieve(App.ENDTRAPID));

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
            App.getInstance().switchScreen(currentPage);
        }
    }

    @Override
    protected void updateAppBar(AppBar appBar) {
        appBar.setNavIcon(MaterialDesignIcon.MENU.button(e -> MobileApplication.getInstance().showLayer(App.MENU_LAYER)));
        appBar.setTitleText("Home");
    }
}
