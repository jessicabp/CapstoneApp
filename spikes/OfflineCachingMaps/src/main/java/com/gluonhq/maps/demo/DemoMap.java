/*
 * Copyright (c) 2016, Gluon
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.

 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL GLUON BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 */
package com.gluonhq.maps.demo;

import com.gluonhq.charm.down.common.JavaFXPlatform;
import com.gluonhq.charm.down.common.PlatformFactory;
import com.gluonhq.charm.down.common.Position;
import com.gluonhq.charm.down.common.PositionService;
import com.gluonhq.maps.MapLayer;
import com.gluonhq.maps.MapPoint;
import com.gluonhq.maps.MapView;
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.stage.Screen;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.LogManager;
import javafx.beans.property.ReadOnlyObjectProperty;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 *
 * Demo class showing a simple map app
 */
public class DemoMap extends Application {

    static {
        try {
            LogManager.getLogManager().readConfiguration( DemoMap.class.getResourceAsStream("/logging.properties") );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void start(Stage stage) throws Exception {
        BorderPane bp = new BorderPane();
        MapView view = new MapView();
        //view.preLoadTiles(14, 16190, 10199, 16195, 10204);
        view.addLayer(positionLayer());
        view.addLayer(myDemoLayer());
        view.setZoom(3); 
        bp.setCenter(view);
        bp.setTop(new Label ("Gluon Maps Demo"));
        Scene scene;
        if (JavaFXPlatform.isDesktop()) {
            scene = new Scene(bp, 600, 700);
        } else {
            Rectangle2D bounds = Screen.getPrimary().getVisualBounds();
            scene = new Scene (bp, bounds.getWidth(), bounds.getHeight());
        }
        stage.setScene(scene);
        stage.show();
//        MapPoint moscone = new MapPoint(37.7841772,-122.403751);
//        MapPoint sun = new MapPoint(37.396256,-121.953847);
//        view.setCenter(moscone);
//        view.flyTo(2., sun, 2.);
    }
    
    private MapLayer myDemoLayer () {
        PoiLayer answer = new PoiLayer();
        Node icon1 = new Circle(7, Color.BLUE);
        answer.addPoint(new MapPoint(50.8458,4.724), icon1);
        Node icon2 = new Circle(7, Color.GREEN);
        answer.addPoint(new MapPoint(37.396256,-121.953847), icon2);
        return answer;
    }
    
    private MapLayer positionLayer() {
        PoiLayer answer = new PoiLayer();
        PositionService positionService = PlatformFactory.getPlatform().getPositionService();
        System.out.println("POSSERVICE = "+positionService);
        if (positionService != null) {
            ReadOnlyObjectProperty<Position> positionProperty = positionService.positionProperty();
            Position position = positionProperty.get();
            if (position == null) {position = new Position(50.,4.);}
            final MapPoint mapPoint = new MapPoint(position.getLatitude(), position.getLongitude());
            answer.addPoint(mapPoint, new Circle(7, Color.RED));
            
            positionProperty.addListener(e -> {
                Position pos = positionProperty.get();
                                System.out.println("[JVDBG] NEW POSITION "+pos);

                mapPoint.update(pos.getLatitude(), pos.getLongitude());
            });
        }
        return answer;
    }
}
