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

package capstone.mobile.other;

import gluonhq.maps.MapPoint;
import gluonhq.maps.MapView;
import gluonhq.maps.PoiLayer;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.util.Pair;


public class CustomMapView extends MapView {

    private final static double MAP_HEIGHT   = 280;
    private final static double INITIAL_ZOOM = 14.0;

    public CustomMapView() {
        super();

        setMaxSize(Double.MAX_VALUE, MAP_HEIGHT);
        setZoom(INITIAL_ZOOM);
    }

    public CustomMapView(double maxHeight) {
        super();

        setMaxSize(Double.MAX_VALUE, maxHeight);
        setZoom(INITIAL_ZOOM);
    }

    public PoiLayer createLayer() {
        final PoiLayer layer = new PoiLayer();
        addLayer(layer);
        return layer;
    }

    public void addMarker(PoiLayer layer, MapPoint p, Node n) {
        layer.addPoint(p, n);
    }

    public PoiLayer removeMarker(PoiLayer oldLayer, MapPoint p) {
        final ObservableList<Pair<MapPoint, Node>> points = oldLayer.getPoints();
        removeLayer(oldLayer);
        for (int i = 0; i < points.size(); i++) {
            final Pair pair = points.get(i);
            if (pair.getKey().equals(p)) {
                points.remove(i, i + 1);
                break;
            }
        }

        final PoiLayer newLayer = new PoiLayer();
        addLayer(newLayer);
        for (int i = 0; i < points.size(); i++) {
            newLayer.addPair(points.get(i));
        }

        return newLayer;
    }

    public PoiLayer clearMarkers(PoiLayer oldLayer) {
        removeLayer(oldLayer);
        final PoiLayer newLayer = new PoiLayer();
        addLayer(newLayer);
        return newLayer;
    }
}
