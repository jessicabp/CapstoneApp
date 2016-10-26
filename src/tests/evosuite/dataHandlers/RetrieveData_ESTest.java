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
import capstone.mobile.dataHandlers.RetrieveData;
import org.junit.Test;

import static org.junit.Assert.fail;

public class RetrieveData_ESTest {

    //Test case number: 1
  /*
   * 13 covered goals:
   * Goal 1. fetchTrapsList(I)Ljava/util/List;_org.evosuite.runtime.mock.java.lang.MockException_DECLARED
   * Goal 2. capstone.mobile.dataHandlers.RetrieveData.fetchTrapsList(I)Ljava/util/List;: Line 74
   * Goal 3. capstone.mobile.dataHandlers.RetrieveData.fetchTrapsList(I)Ljava/util/List;: Line 75
   * Goal 4. capstone.mobile.dataHandlers.RetrieveData.fetchTrapsList(I)Ljava/util/List;: Line 76
   * Goal 5. capstone.mobile.dataHandlers.RetrieveData.fetchTrapsList(I)Ljava/util/List;: Line 98
   * Goal 6. capstone.mobile.dataHandlers.RetrieveData.fetchTrapsList(I)Ljava/util/List;: Line 99
   * Goal 7. [METHOD] capstone.mobile.dataHandlers.RetrieveData.fetchTrapsList(I)Ljava/util/List;
   * Goal 8. Weak Mutation 17: capstone.mobile.dataHandlers.RetrieveData.fetchTrapsList(I)Ljava/util/List;:74 - ReplaceConstant - https://traptracker.pythonanywhere.com/api/trap?line_id= -> 
   * Goal 9. Weak Mutation 18: capstone.mobile.dataHandlers.RetrieveData.fetchTrapsList(I)Ljava/util/List;:74 - InsertUnaryOp Negation of lineId
   * Goal 10. Weak Mutation 19: capstone.mobile.dataHandlers.RetrieveData.fetchTrapsList(I)Ljava/util/List;:74 - InsertUnaryOp IINC 1 lineId
   * Goal 11. Weak Mutation 20: capstone.mobile.dataHandlers.RetrieveData.fetchTrapsList(I)Ljava/util/List;:74 - InsertUnaryOp IINC -1 lineId
   * Goal 12. Weak Mutation 21: capstone.mobile.dataHandlers.RetrieveData.fetchTrapsList(I)Ljava/util/List;:74 - ReplaceComparisonOperator == -> !=
   * Goal 13. Weak Mutation 22: capstone.mobile.dataHandlers.RetrieveData.fetchTrapsList(I)Ljava/util/List;:75 - ReplaceComparisonOperator == -> !=
   */

    @Test(timeout = 4000, expected = DataUnavailableException.class)
    public void test1() throws Throwable {
        RetrieveData.fetchTrapsList(1);
        fail("Expecting exception: Exception");
    }

    //Test case number: 2
  /*
   * 10 covered goals:
   * Goal 1. fetchLinesList()Ljava/util/List;_org.evosuite.runtime.mock.java.lang.MockException_DECLARED
   * Goal 2. capstone.mobile.dataHandlers.RetrieveData.fetchLinesList()Ljava/util/List;: Line 33
   * Goal 3. capstone.mobile.dataHandlers.RetrieveData.fetchLinesList()Ljava/util/List;: Line 34
   * Goal 4. capstone.mobile.dataHandlers.RetrieveData.fetchLinesList()Ljava/util/List;: Line 35
   * Goal 5. capstone.mobile.dataHandlers.RetrieveData.fetchLinesList()Ljava/util/List;: Line 60
   * Goal 6. capstone.mobile.dataHandlers.RetrieveData.fetchLinesList()Ljava/util/List;: Line 61
   * Goal 7. [METHOD] capstone.mobile.dataHandlers.RetrieveData.fetchLinesList()Ljava/util/List;
   * Goal 8. Weak Mutation 0: capstone.mobile.dataHandlers.RetrieveData.fetchLinesList()Ljava/util/List;:33 - ReplaceConstant - https://traptracker.pythonanywhere.com/api/line -> 
   * Goal 9. Weak Mutation 1: capstone.mobile.dataHandlers.RetrieveData.fetchLinesList()Ljava/util/List;:33 - ReplaceComparisonOperator == -> !=
   * Goal 10. Weak Mutation 2: capstone.mobile.dataHandlers.RetrieveData.fetchLinesList()Ljava/util/List;:34 - ReplaceComparisonOperator == -> !=
   */

    @Test(timeout = 4000, expected = Exception.class)
    public void test2() throws Throwable {
        RetrieveData.fetchLinesList();
        fail("Expecting exception: Exception");
    }

    //Test case number: 4
  /*
   * 10 covered goals:
   * Goal 1. fetchAnimalList()Ljava/util/List;_org.evosuite.runtime.mock.java.lang.MockException_DECLARED
   * Goal 2. capstone.mobile.dataHandlers.RetrieveData.fetchAnimalList()Ljava/util/List;: Line 110
   * Goal 3. capstone.mobile.dataHandlers.RetrieveData.fetchAnimalList()Ljava/util/List;: Line 111
   * Goal 4. capstone.mobile.dataHandlers.RetrieveData.fetchAnimalList()Ljava/util/List;: Line 112
   * Goal 5. capstone.mobile.dataHandlers.RetrieveData.fetchAnimalList()Ljava/util/List;: Line 137
   * Goal 6. capstone.mobile.dataHandlers.RetrieveData.fetchAnimalList()Ljava/util/List;: Line 138
   * Goal 7. [METHOD] capstone.mobile.dataHandlers.RetrieveData.fetchAnimalList()Ljava/util/List;
   * Goal 8. Weak Mutation 39: capstone.mobile.dataHandlers.RetrieveData.fetchAnimalList()Ljava/util/List;:110 - ReplaceConstant - https://traptracker.pythonanywhere.com/api/animal -> 
   * Goal 9. Weak Mutation 40: capstone.mobile.dataHandlers.RetrieveData.fetchAnimalList()Ljava/util/List;:110 - ReplaceComparisonOperator == -> !=
   * Goal 10. Weak Mutation 41: capstone.mobile.dataHandlers.RetrieveData.fetchAnimalList()Ljava/util/List;:111 - ReplaceComparisonOperator == -> !=
   */

    @Test(timeout = 4000, expected = Exception.class)
    public void test4() throws Throwable {
        RetrieveData.fetchAnimalList();
        fail("Expecting exception: Exception");
    }

    //Test case number: 6
  /*
   * 14 covered goals:
   * Goal 1. checkAuthorisation(ILjava/lang/String;)I_org.evosuite.runtime.mock.java.lang.MockException_DECLARED
   * Goal 2. capstone.mobile.dataHandlers.RetrieveData.checkAuthorisation(ILjava/lang/String;)I: Line 149
   * Goal 3. capstone.mobile.dataHandlers.RetrieveData.checkAuthorisation(ILjava/lang/String;)I: Line 150
   * Goal 4. capstone.mobile.dataHandlers.RetrieveData.checkAuthorisation(ILjava/lang/String;)I: Line 151
   * Goal 5. capstone.mobile.dataHandlers.RetrieveData.checkAuthorisation(ILjava/lang/String;)I: Line 164
   * Goal 6. capstone.mobile.dataHandlers.RetrieveData.checkAuthorisation(ILjava/lang/String;)I: Line 165
   * Goal 7. [METHOD] capstone.mobile.dataHandlers.RetrieveData.checkAuthorisation(ILjava/lang/String;)I
   * Goal 8. Weak Mutation 56: capstone.mobile.dataHandlers.RetrieveData.checkAuthorisation(ILjava/lang/String;)I:149 - ReplaceConstant - https://traptracker.pythonanywhere.com/api/checkauth?line_id= -> 
   * Goal 9. Weak Mutation 57: capstone.mobile.dataHandlers.RetrieveData.checkAuthorisation(ILjava/lang/String;)I:149 - InsertUnaryOp Negation of lineId
   * Goal 10. Weak Mutation 58: capstone.mobile.dataHandlers.RetrieveData.checkAuthorisation(ILjava/lang/String;)I:149 - InsertUnaryOp IINC 1 lineId
   * Goal 11. Weak Mutation 59: capstone.mobile.dataHandlers.RetrieveData.checkAuthorisation(ILjava/lang/String;)I:149 - InsertUnaryOp IINC -1 lineId
   * Goal 12. Weak Mutation 60: capstone.mobile.dataHandlers.RetrieveData.checkAuthorisation(ILjava/lang/String;)I:149 - ReplaceConstant - &password= -> 
   * Goal 13. Weak Mutation 61: capstone.mobile.dataHandlers.RetrieveData.checkAuthorisation(ILjava/lang/String;)I:149 - ReplaceComparisonOperator == -> !=
   * Goal 14. Weak Mutation 62: capstone.mobile.dataHandlers.RetrieveData.checkAuthorisation(ILjava/lang/String;)I:150 - ReplaceComparisonOperator == -> !=
   */

    @Test(timeout = 4000, expected = Exception.class)
    public void test6() throws Throwable {
        RetrieveData.checkAuthorisation(3161, "j%Q-%");
        fail("Expecting exception: Exception");
    }

    //Test case number: 7
  /*
   * 4 covered goals:
   * Goal 1. capstone.mobile.dataHandlers.RetrieveData.<init>()V: root-Branch
   * Goal 2. Branch capstone.mobile.dataHandlers.RetrieveData.<init>()V: root-Branch in context: capstone.mobile.dataHandlers.RetrieveData:<init>()V
   * Goal 3. [METHOD] capstone.mobile.dataHandlers.RetrieveData.<init>()V
   * Goal 4. [METHODNOEX] capstone.mobile.dataHandlers.RetrieveData.<init>()V
   */

    @Test(timeout = 4000)
    public void test7() throws Throwable {
        RetrieveData retrieveData0 = new RetrieveData();
    }
}
