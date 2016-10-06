package capstone.mobile.maps;

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
        PoiLayer layer = new PoiLayer();
        addLayer(layer);
        return layer;
    }

    public void addMarker(PoiLayer layer, MapPoint p, Node n) {
        layer.addPoint(p, n);
    }

    public PoiLayer removeMarker(PoiLayer oldLayer, MapPoint p) {
        ObservableList<Pair<MapPoint, Node>> points = oldLayer.getPoints();
        removeLayer(oldLayer);
        for (int i = 0; i < points.size(); i++) {
            Pair pair = points.get(i);
            if (pair.getKey().equals(p)) {
                points.remove(i, i + 1);
                break;
            }
        }

        PoiLayer newLayer = new PoiLayer();
        addLayer(newLayer);
        for (int i = 0; i < points.size(); i++) {
            newLayer.addPair(points.get(i));
        }

        return newLayer;
    }

    public PoiLayer clearMarkers(PoiLayer oldLayer) {
        removeLayer(oldLayer);
        PoiLayer newLayer = new PoiLayer();
        addLayer(newLayer);
        return newLayer;
    }
}
