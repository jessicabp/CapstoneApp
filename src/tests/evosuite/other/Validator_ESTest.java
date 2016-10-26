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

package evosuite.other;

import capstone.mobile.other.Validator;
import org.junit.Test;

import static org.junit.Assert.*;

public class Validator_ESTest {

    //Test case number: 0
  /*
   * 10 covered goals:
   * Goal 1. capstone.mobile.other.Validator.isNumber(Ljava/lang/String;)Z: root-Branch
   * Goal 2. Branch capstone.mobile.other.Validator.isNumber(Ljava/lang/String;)Z: root-Branch in context: capstone.mobile.other.Validator:isNumber(Ljava/lang/String;)Z
   * Goal 3. [Output]: capstone.mobile.other.Validator.isNumber(Ljava/lang/String;)Z:True
   * Goal 4. capstone.mobile.other.Validator.isNumber(Ljava/lang/String;)Z: Line 28
   * Goal 5. capstone.mobile.other.Validator.isNumber(Ljava/lang/String;)Z: Line 29
   * Goal 6. [METHOD] capstone.mobile.other.Validator.isNumber(Ljava/lang/String;)Z
   * Goal 7. [METHODNOEX] capstone.mobile.other.Validator.isNumber(Ljava/lang/String;)Z
   * Goal 8. Weak Mutation 3: capstone.mobile.other.Validator.isNumber(Ljava/lang/String;)Z:28 - ReplaceConstant - ^[1-9]\d{0,4}$ -> 
   * Goal 9. Weak Mutation 4: capstone.mobile.other.Validator.isNumber(Ljava/lang/String;)Z:29 - ReplaceVariable number -> pattern
   * Goal 10. Weak Mutation 5: capstone.mobile.other.Validator.isNumber(Ljava/lang/String;)Z:29 - ReplaceConstant - ^[1-9]\d{0,4}$ -> 
   */

    @Test(timeout = 4000)
    public void test0() throws Throwable {
        boolean boolean0 = Validator.isNumber("8");
        assertTrue(boolean0);
    }

    //Test case number: 1
  /*
   * 10 covered goals:
   * Goal 1. capstone.mobile.other.Validator.isCoordinate(Ljava/lang/String;)Z: root-Branch
   * Goal 2. Branch capstone.mobile.other.Validator.isCoordinate(Ljava/lang/String;)Z: root-Branch in context: capstone.mobile.other.Validator:isCoordinate(Ljava/lang/String;)Z
   * Goal 3. [Output]: capstone.mobile.other.Validator.isCoordinate(Ljava/lang/String;)Z:True
   * Goal 4. capstone.mobile.other.Validator.isCoordinate(Ljava/lang/String;)Z: Line 16
   * Goal 5. capstone.mobile.other.Validator.isCoordinate(Ljava/lang/String;)Z: Line 17
   * Goal 6. [METHOD] capstone.mobile.other.Validator.isCoordinate(Ljava/lang/String;)Z
   * Goal 7. [METHODNOEX] capstone.mobile.other.Validator.isCoordinate(Ljava/lang/String;)Z
   * Goal 8. Weak Mutation 0: capstone.mobile.other.Validator.isCoordinate(Ljava/lang/String;)Z:16 - ReplaceConstant - ^(\-)?\d{2,3}\.\d{4,7}$ -> 
   * Goal 9. Weak Mutation 1: capstone.mobile.other.Validator.isCoordinate(Ljava/lang/String;)Z:17 - ReplaceVariable coordinate -> pattern
   * Goal 10. Weak Mutation 2: capstone.mobile.other.Validator.isCoordinate(Ljava/lang/String;)Z:17 - ReplaceConstant - ^(\-)?\d{2,3}\.\d{4,7}$ -> 
   */

    @Test(timeout = 4000)
    public void test1() throws Throwable {
        boolean boolean0 = Validator.isCoordinate("00.0000");
        assertTrue(boolean0);
    }

    //Test case number: 2
  /*
   * 9 covered goals:
   * Goal 1. capstone.mobile.other.Validator.isNumber(Ljava/lang/String;)Z: root-Branch
   * Goal 2. Branch capstone.mobile.other.Validator.isNumber(Ljava/lang/String;)Z: root-Branch in context: capstone.mobile.other.Validator:isNumber(Ljava/lang/String;)Z
   * Goal 3. isNumber(Ljava/lang/String;)Z_java.lang.NullPointerException_IMPLICIT
   * Goal 4. capstone.mobile.other.Validator.isNumber(Ljava/lang/String;)Z: Line 28
   * Goal 5. capstone.mobile.other.Validator.isNumber(Ljava/lang/String;)Z: Line 29
   * Goal 6. [METHOD] capstone.mobile.other.Validator.isNumber(Ljava/lang/String;)Z
   * Goal 7. Weak Mutation 3: capstone.mobile.other.Validator.isNumber(Ljava/lang/String;)Z:28 - ReplaceConstant - ^[1-9]\d{0,4}$ -> 
   * Goal 8. Weak Mutation 4: capstone.mobile.other.Validator.isNumber(Ljava/lang/String;)Z:29 - ReplaceVariable number -> pattern
   * Goal 9. Weak Mutation 5: capstone.mobile.other.Validator.isNumber(Ljava/lang/String;)Z:29 - ReplaceConstant - ^[1-9]\d{0,4}$ -> 
   */

    @Test(timeout = 4000)
    public void test2() throws Throwable {
        // Undeclared exception!
        try {
            Validator.isNumber((String) null);
            fail("Expecting exception: NullPointerException");

        } catch (NullPointerException e) {
        }
    }

    //Test case number: 3
  /*
   * 9 covered goals:
   * Goal 1. capstone.mobile.other.Validator.isCoordinate(Ljava/lang/String;)Z: root-Branch
   * Goal 2. Branch capstone.mobile.other.Validator.isCoordinate(Ljava/lang/String;)Z: root-Branch in context: capstone.mobile.other.Validator:isCoordinate(Ljava/lang/String;)Z
   * Goal 3. isCoordinate(Ljava/lang/String;)Z_java.lang.NullPointerException_IMPLICIT
   * Goal 4. capstone.mobile.other.Validator.isCoordinate(Ljava/lang/String;)Z: Line 16
   * Goal 5. capstone.mobile.other.Validator.isCoordinate(Ljava/lang/String;)Z: Line 17
   * Goal 6. [METHOD] capstone.mobile.other.Validator.isCoordinate(Ljava/lang/String;)Z
   * Goal 7. Weak Mutation 0: capstone.mobile.other.Validator.isCoordinate(Ljava/lang/String;)Z:16 - ReplaceConstant - ^(\-)?\d{2,3}\.\d{4,7}$ -> 
   * Goal 8. Weak Mutation 1: capstone.mobile.other.Validator.isCoordinate(Ljava/lang/String;)Z:17 - ReplaceVariable coordinate -> pattern
   * Goal 9. Weak Mutation 2: capstone.mobile.other.Validator.isCoordinate(Ljava/lang/String;)Z:17 - ReplaceConstant - ^(\-)?\d{2,3}\.\d{4,7}$ -> 
   */

    @Test(timeout = 4000)
    public void test3() throws Throwable {
        // Undeclared exception!
        try {
            Validator.isCoordinate((String) null);
            fail("Expecting exception: NullPointerException");

        } catch (NullPointerException e) {
        }
    }

    //Test case number: 4
  /*
   * 10 covered goals:
   * Goal 1. capstone.mobile.other.Validator.isCoordinate(Ljava/lang/String;)Z: root-Branch
   * Goal 2. Branch capstone.mobile.other.Validator.isCoordinate(Ljava/lang/String;)Z: root-Branch in context: capstone.mobile.other.Validator:isCoordinate(Ljava/lang/String;)Z
   * Goal 3. [Output]: capstone.mobile.other.Validator.isCoordinate(Ljava/lang/String;)Z:False
   * Goal 4. capstone.mobile.other.Validator.isCoordinate(Ljava/lang/String;)Z: Line 16
   * Goal 5. capstone.mobile.other.Validator.isCoordinate(Ljava/lang/String;)Z: Line 17
   * Goal 6. [METHOD] capstone.mobile.other.Validator.isCoordinate(Ljava/lang/String;)Z
   * Goal 7. [METHODNOEX] capstone.mobile.other.Validator.isCoordinate(Ljava/lang/String;)Z
   * Goal 8. Weak Mutation 0: capstone.mobile.other.Validator.isCoordinate(Ljava/lang/String;)Z:16 - ReplaceConstant - ^(\-)?\d{2,3}\.\d{4,7}$ -> 
   * Goal 9. Weak Mutation 1: capstone.mobile.other.Validator.isCoordinate(Ljava/lang/String;)Z:17 - ReplaceVariable coordinate -> pattern
   * Goal 10. Weak Mutation 2: capstone.mobile.other.Validator.isCoordinate(Ljava/lang/String;)Z:17 - ReplaceConstant - ^(\-)?\d{2,3}\.\d{4,7}$ -> 
   */

    @Test(timeout = 4000)
    public void test4() throws Throwable {
        boolean boolean0 = Validator.isCoordinate("");
        assertFalse(boolean0);
    }

    //Test case number: 5
  /*
   * 4 covered goals:
   * Goal 1. capstone.mobile.other.Validator.<init>()V: root-Branch
   * Goal 2. Branch capstone.mobile.other.Validator.<init>()V: root-Branch in context: capstone.mobile.other.Validator:<init>()V
   * Goal 3. [METHOD] capstone.mobile.other.Validator.<init>()V
   * Goal 4. [METHODNOEX] capstone.mobile.other.Validator.<init>()V
   */

    @Test(timeout = 4000)
    public void test5() throws Throwable {
        Validator validator0 = new Validator();
    }

    //Test case number: 6
  /*
   * 10 covered goals:
   * Goal 1. capstone.mobile.other.Validator.isNumber(Ljava/lang/String;)Z: root-Branch
   * Goal 2. Branch capstone.mobile.other.Validator.isNumber(Ljava/lang/String;)Z: root-Branch in context: capstone.mobile.other.Validator:isNumber(Ljava/lang/String;)Z
   * Goal 3. [Output]: capstone.mobile.other.Validator.isNumber(Ljava/lang/String;)Z:False
   * Goal 4. capstone.mobile.other.Validator.isNumber(Ljava/lang/String;)Z: Line 28
   * Goal 5. capstone.mobile.other.Validator.isNumber(Ljava/lang/String;)Z: Line 29
   * Goal 6. [METHOD] capstone.mobile.other.Validator.isNumber(Ljava/lang/String;)Z
   * Goal 7. [METHODNOEX] capstone.mobile.other.Validator.isNumber(Ljava/lang/String;)Z
   * Goal 8. Weak Mutation 3: capstone.mobile.other.Validator.isNumber(Ljava/lang/String;)Z:28 - ReplaceConstant - ^[1-9]\d{0,4}$ -> 
   * Goal 9. Weak Mutation 4: capstone.mobile.other.Validator.isNumber(Ljava/lang/String;)Z:29 - ReplaceVariable number -> pattern
   * Goal 10. Weak Mutation 5: capstone.mobile.other.Validator.isNumber(Ljava/lang/String;)Z:29 - ReplaceConstant - ^[1-9]\d{0,4}$ -> 
   */

    @Test(timeout = 4000)
    public void test6() throws Throwable {
        boolean boolean0 = Validator.isNumber("");
        assertFalse(boolean0);
    }
}
