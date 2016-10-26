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

package evosuite.dataHandlers;

import capstone.mobile.dataHandlers.DataUnavailableException;
import org.junit.Test;

public class DataUnavailableException_ESTest {

    //Test case number: 0
  /*
   * 5 covered goals:
   * Goal 1. capstone.mobile.dataHandlers.DataUnavailableException.<init>(Ljava/lang/String;)V: root-Branch
   * Goal 2. Branch capstone.mobile.dataHandlers.DataUnavailableException.<init>(Ljava/lang/String;)V: root-Branch in context: capstone.mobile.dataHandlers.DataUnavailableException:<init>(Ljava/lang/String;)V
   * Goal 3. capstone.mobile.dataHandlers.DataUnavailableException.<init>(Ljava/lang/String;)V: Line 7
   * Goal 4. [METHOD] capstone.mobile.dataHandlers.DataUnavailableException.<init>(Ljava/lang/String;)V
   * Goal 5. [METHODNOEX] capstone.mobile.dataHandlers.DataUnavailableException.<init>(Ljava/lang/String;)V
   */

    @Test(timeout = 4000)
    public void test0() throws Throwable {
        DataUnavailableException dataUnavailableException0 = new DataUnavailableException("capstone.mobile.dataHandlers.DataUnavailableException");
    }
}
