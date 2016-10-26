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

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;

public class CustomGridPane extends GridPane {

    /**
     * Customised so user can specify the number of columns in the grid
     * Grid automatically sizes all columns to same width and spaces cells out
     *
     * @param noOfColumns
     */
    public CustomGridPane(int noOfColumns) {
        super();

        for (int i = 0; i < noOfColumns; i++) {
            getColumnConstraints().add(new ColumnConstraints());
            getColumnConstraints().get(i).setPercentWidth(100 / noOfColumns);
            getColumnConstraints().get(i).setHgrow(Priority.SOMETIMES);
        }

        setHgap(10);
        setVgap(10);
    }
}