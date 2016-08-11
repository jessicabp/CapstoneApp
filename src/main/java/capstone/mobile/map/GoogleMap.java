package capstone.mobile.map;

import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebEvent;
import javafx.scene.web.WebView;
import capstone.mobile.App;
import java.net.URL;

public class GoogleMap extends Pane {

    private WebView web;
    private WebEngine engine;

    public GoogleMap() {
        this.web = new WebView();
        this.web.setMaxSize(300, 310);
        this.engine = web.getEngine();
    }

    public WebEngine load() {
        final URL template = App.class.getResource("template.html");
        this.engine.load(template.toExternalForm());
        this.engine.setOnAlert(new EventHandler<WebEvent<String>>() {
            @Override
            public void handle(WebEvent<String> e) {
                System.out.println(e.toString());
            }
        });
        this.getChildren().add(this.web);
        return this.engine;
    }

}
