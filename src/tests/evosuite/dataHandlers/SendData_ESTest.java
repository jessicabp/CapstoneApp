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

import capstone.mobile.dataHandlers.SendData;
import capstone.mobile.models.Walk;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SendData_ESTest {

    //Test case number: 0
  /*
   * 39 covered goals:
   * Goal 1. capstone.mobile.dataHandlers.SendData.sendWalkData(Lcapstone/mobile/models/Walk;)I: I9 Branch 1 IF_ICMPEQ L25 - false
   * Goal 2. capstone.mobile.dataHandlers.SendData.sendWalkData(Lcapstone/mobile/models/Walk;)I: I14 Branch 2 IF_ICMPNE L26 - true
   * Goal 3. Branch capstone.mobile.dataHandlers.SendData.sendWalkData(Lcapstone/mobile/models/Walk;)I: I9 Branch 1 IF_ICMPEQ L25 - false in context: capstone.mobile.dataHandlers.SendData:sendWalkData(Lcapstone/mobile/models/Walk;)I
   * Goal 4. Branch capstone.mobile.dataHandlers.SendData.sendWalkData(Lcapstone/mobile/models/Walk;)I: I14 Branch 2 IF_ICMPNE L26 - true in context: capstone.mobile.dataHandlers.SendData:sendWalkData(Lcapstone/mobile/models/Walk;)I
   * Goal 5. [Output]: capstone.mobile.dataHandlers.SendData.sendWalkData(Lcapstone/mobile/models/Walk;)I:Positive
   * Goal 6. capstone.mobile.dataHandlers.SendData.sendTrapsData(Lcapstone/mobile/models/Walk;)I: Line 101
   * Goal 7. capstone.mobile.dataHandlers.SendData.sendTrapsData(Lcapstone/mobile/models/Walk;)I: Line 103
   * Goal 8. capstone.mobile.dataHandlers.SendData.sendTrapsData(Lcapstone/mobile/models/Walk;)I: Line 104
   * Goal 9. capstone.mobile.dataHandlers.SendData.sendTrapsData(Lcapstone/mobile/models/Walk;)I: Line 140
   * Goal 10. capstone.mobile.dataHandlers.SendData.sendTrapsData(Lcapstone/mobile/models/Walk;)I: Line 141
   * Goal 11. capstone.mobile.dataHandlers.SendData.sendTrapsData(Lcapstone/mobile/models/Walk;)I: Line 143
   * Goal 12. capstone.mobile.dataHandlers.SendData.sendWalkData(Lcapstone/mobile/models/Walk;)I: Line 24
   * Goal 13. capstone.mobile.dataHandlers.SendData.sendWalkData(Lcapstone/mobile/models/Walk;)I: Line 25
   * Goal 14. capstone.mobile.dataHandlers.SendData.sendWalkData(Lcapstone/mobile/models/Walk;)I: Line 26
   * Goal 15. capstone.mobile.dataHandlers.SendData.sendWalkData(Lcapstone/mobile/models/Walk;)I: Line 29
   * Goal 16. [METHOD] capstone.mobile.dataHandlers.SendData.sendWalkData(Lcapstone/mobile/models/Walk;)I
   * Goal 17. [METHODNOEX] capstone.mobile.dataHandlers.SendData.sendWalkData(Lcapstone/mobile/models/Walk;)I
   * Goal 18. Weak Mutation 0: capstone.mobile.dataHandlers.SendData.sendWalkData(Lcapstone/mobile/models/Walk;)I:25 - InsertUnaryOp Negation of traps
   * Goal 19. Weak Mutation 1: capstone.mobile.dataHandlers.SendData.sendWalkData(Lcapstone/mobile/models/Walk;)I:25 - InsertUnaryOp IINC 1 traps
   * Goal 20. Weak Mutation 2: capstone.mobile.dataHandlers.SendData.sendWalkData(Lcapstone/mobile/models/Walk;)I:25 - InsertUnaryOp IINC -1 traps
   * Goal 21. Weak Mutation 3: capstone.mobile.dataHandlers.SendData.sendWalkData(Lcapstone/mobile/models/Walk;)I:25 - InsertUnaryOp Negation
   * Goal 22. Weak Mutation 4: capstone.mobile.dataHandlers.SendData.sendWalkData(Lcapstone/mobile/models/Walk;)I:25 - InsertUnaryOp +1
   * Goal 23. Weak Mutation 5: capstone.mobile.dataHandlers.SendData.sendWalkData(Lcapstone/mobile/models/Walk;)I:25 - InsertUnaryOp -1
   * Goal 24. Weak Mutation 7: capstone.mobile.dataHandlers.SendData.sendWalkData(Lcapstone/mobile/models/Walk;)I:25 - ReplaceComparisonOperator == -> >=
   * Goal 25. Weak Mutation 9: capstone.mobile.dataHandlers.SendData.sendWalkData(Lcapstone/mobile/models/Walk;)I:26 - InsertUnaryOp Negation of traps
   * Goal 26. Weak Mutation 10: capstone.mobile.dataHandlers.SendData.sendWalkData(Lcapstone/mobile/models/Walk;)I:26 - InsertUnaryOp IINC 1 traps
   * Goal 27. Weak Mutation 11: capstone.mobile.dataHandlers.SendData.sendWalkData(Lcapstone/mobile/models/Walk;)I:26 - InsertUnaryOp IINC -1 traps
   * Goal 28. Weak Mutation 12: capstone.mobile.dataHandlers.SendData.sendWalkData(Lcapstone/mobile/models/Walk;)I:26 - InsertUnaryOp Negation
   * Goal 29. Weak Mutation 13: capstone.mobile.dataHandlers.SendData.sendWalkData(Lcapstone/mobile/models/Walk;)I:26 - InsertUnaryOp +1
   * Goal 30. Weak Mutation 14: capstone.mobile.dataHandlers.SendData.sendWalkData(Lcapstone/mobile/models/Walk;)I:26 - InsertUnaryOp -1
   * Goal 31. Weak Mutation 16: capstone.mobile.dataHandlers.SendData.sendWalkData(Lcapstone/mobile/models/Walk;)I:26 - ReplaceComparisonOperator != -> <
   * Goal 32. Weak Mutation 19: capstone.mobile.dataHandlers.SendData.sendWalkData(Lcapstone/mobile/models/Walk;)I:29 - ReplaceConstant - 2 -> 0
   * Goal 33. Weak Mutation 20: capstone.mobile.dataHandlers.SendData.sendWalkData(Lcapstone/mobile/models/Walk;)I:29 - ReplaceConstant - 2 -> 1
   * Goal 34. Weak Mutation 21: capstone.mobile.dataHandlers.SendData.sendWalkData(Lcapstone/mobile/models/Walk;)I:29 - ReplaceConstant - 2 -> -1
   * Goal 35. Weak Mutation 22: capstone.mobile.dataHandlers.SendData.sendWalkData(Lcapstone/mobile/models/Walk;)I:29 - ReplaceConstant - 2 -> 3
   * Goal 36. Weak Mutation 67: capstone.mobile.dataHandlers.SendData.sendTrapsData(Lcapstone/mobile/models/Walk;)I:101 - ReplaceConstant - https://traptracker.pythonanywhere.com/api/trap -> 
   * Goal 37. Weak Mutation 68: capstone.mobile.dataHandlers.SendData.sendTrapsData(Lcapstone/mobile/models/Walk;)I:103 - ReplaceConstant - https://traptracker.pythonanywhere.com/api/trap -> 
   * Goal 38. Weak Mutation 69: capstone.mobile.dataHandlers.SendData.sendTrapsData(Lcapstone/mobile/models/Walk;)I:103 - ReplaceComparisonOperator == -> !=
   * Goal 39. Weak Mutation 70: capstone.mobile.dataHandlers.SendData.sendTrapsData(Lcapstone/mobile/models/Walk;)I:104 - ReplaceComparisonOperator == -> !=
   */

    @Test(timeout = 4000)
    public void test0() throws Throwable {
        Walk walk0 = new Walk();
        int  int0  = SendData.sendWalkData(walk0);
        assertEquals(2, int0);
    }

    //Test case number: 1
  /*
   * 4 covered goals:
   * Goal 1. capstone.mobile.dataHandlers.SendData.<init>()V: root-Branch
   * Goal 2. Branch capstone.mobile.dataHandlers.SendData.<init>()V: root-Branch in context: capstone.mobile.dataHandlers.SendData:<init>()V
   * Goal 3. [METHOD] capstone.mobile.dataHandlers.SendData.<init>()V
   * Goal 4. [METHODNOEX] capstone.mobile.dataHandlers.SendData.<init>()V
   */

    @Test(timeout = 4000)
    public void test1() throws Throwable {
        SendData sendData0 = new SendData();
    }
}
