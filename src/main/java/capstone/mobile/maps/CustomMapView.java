package capstone.mobile.maps;

import gluonhq.maps.MapView;

public class CustomMapView extends MapView {

    private final static double MAP_HEIGHT = 280;
    private final static double INITIAL_ZOOM = 14.0;

    public CustomMapView() {
        super();

        setMaxSize(Double.MAX_VALUE, MAP_HEIGHT);
        setZoom(INITIAL_ZOOM);
    }
}
