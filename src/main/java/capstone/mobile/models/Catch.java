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

package capstone.mobile.models;

import java.util.Date;

/**
 * Used to store what has been found in a trap along with the time.
 */
public class Catch {

    private int  trapId;
    private long time;
    private int  animalId;

    /**
     * Constructor.
     *
     * @param trapId   The ID number of the trap
     * @param animalId The ID number of the animal
     */
    public Catch(int trapId, int animalId) {
        this.trapId = trapId;
        this.animalId = animalId;
        time = new Date().getTime();
    }

    /**
     * Constructor.
     *
     * @param trapId   The ID number of the trap
     * @param animalId The ID of the animal
     * @param time     Timestamp containing the catch time
     */
    public Catch(int trapId, int animalId, long time) {
        this.trapId = trapId;
        this.animalId = animalId;
        this.time = time;
    }

    public int getTrapId() {
        return trapId;
    }

    public void setTrapId(int trapId) {
        this.trapId = trapId;
    }

    public int getAnimalId() {
        return animalId;
    }

    public void setAnimalId(int animalId) {
        this.animalId = animalId;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}
