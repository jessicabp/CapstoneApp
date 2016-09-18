package capstone.mobile.classes;

import com.gluonhq.charm.down.common.PlatformFactory;
import com.gluonhq.charm.down.common.Position;
import com.gluonhq.charm.down.common.PositionService;
import javafx.beans.property.ReadOnlyObjectProperty;

public class LocationProvider {

    public static final String ERROR = "Location data not available";

    public static Position getPosition() /* throws DataUnavailableException */ {
        PositionService positionService = PlatformFactory.getPlatform().getPositionService();
        if(positionService == null) {
            return new Position(1, 1);
            // throw new DataUnavailableException(ERROR);
        }
        ReadOnlyObjectProperty<Position> positionProperty = positionService.positionProperty();
        Position position = positionProperty.get();
        if(position == null) {
            return new Position(2, 2);
            //throw new DataUnavailableException(ERROR);
        }
        return position;
    }

}
