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

import capstone.mobile.App;
import com.gluonhq.charm.glisten.application.GlassPane;
import com.gluonhq.charm.glisten.layout.layer.PopupView;
import javafx.scene.Node;


public class CustomPopupView extends PopupView {

    /**
     * Adds listener to the PopupView so background fade is always applied when a popup opens and removed when closed
     *
     * @param ownerNode
     */
    public CustomPopupView(Node ownerNode) {
        super(ownerNode);

        showingProperty().addListener((obs, ov, nv) -> {
            if (nv) {
                App.getInstance().getGlassPane().setBackgroundFade(GlassPane.DEFAULT_BACKGROUND_FADE_LEVEL);
            } else {
                App.getInstance().getGlassPane().setBackgroundFade(0);
            }
        });
    }
}
