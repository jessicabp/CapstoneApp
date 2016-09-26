package capstone.mobile.maps;

import gluonhq.maps.MapPoint;
import gluonhq.maps.PoiLayer;

public class CustomPoiLayer extends PoiLayer {

    public CustomPoiLayer() {
        super();
    }

    public void removePoint(MapPoint p) {
        super.removePoint(p);
    }

    public void clear() {
        super.clear();
    }
}
