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

package evosuite.models;


import capstone.mobile.models.Catch;
import capstone.mobile.models.Line;
import capstone.mobile.models.Trap;
import capstone.mobile.models.Walk;
import javafx.beans.property.SimpleBooleanProperty;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class Walk_ESTest {

    //Test case number: 0
  /*
   * 28 covered goals:
   * Goal 1. capstone.mobile.models.Walk.<init>()V: root-Branch
   * Goal 2. capstone.mobile.models.Walk.setLineAtRestart(Lcapstone/mobile/models/Line;)V: root-Branch
   * Goal 3. capstone.mobile.models.Walk.startWalk(Lcapstone/mobile/models/Trap;Lcapstone/mobile/models/Trap;)V: I25 Branch 3 IF_ICMPGE L143 - false
   * Goal 4. Branch capstone.mobile.models.Walk.setLineAtRestart(Lcapstone/mobile/models/Line;)V: root-Branch in context: capstone.mobile.models.Walk:setLineAtRestart(Lcapstone/mobile/models/Line;)V
   * Goal 5. Branch capstone.mobile.models.Walk.<init>()V: root-Branch in context: capstone.mobile.models.Walk:<init>()V
   * Goal 6. Branch capstone.mobile.models.Walk.startWalk(Lcapstone/mobile/models/Trap;Lcapstone/mobile/models/Trap;)V: I25 Branch 3 IF_ICMPGE L143 - false in context: capstone.mobile.models.Walk:startWalk(Lcapstone/mobile/models/Trap;Lcapstone/mobile/models/Trap;)V
   * Goal 7. startWalk(Lcapstone/mobile/models/Trap;Lcapstone/mobile/models/Trap;)V_java.lang.NoClassDefFoundError_IMPLICIT
   * Goal 8. capstone.mobile.models.Walk.<init>()V: Line 33
   * Goal 9. capstone.mobile.models.Walk.<init>()V: Line 34
   * Goal 10. capstone.mobile.models.Walk.setLineAtRestart(Lcapstone/mobile/models/Line;)V: Line 67
   * Goal 11. capstone.mobile.models.Walk.setLineAtRestart(Lcapstone/mobile/models/Line;)V: Line 68
   * Goal 12. capstone.mobile.models.Walk.startWalk(Lcapstone/mobile/models/Trap;Lcapstone/mobile/models/Trap;)V: Line 140
   * Goal 13. capstone.mobile.models.Walk.startWalk(Lcapstone/mobile/models/Trap;Lcapstone/mobile/models/Trap;)V: Line 141
   * Goal 14. capstone.mobile.models.Walk.startWalk(Lcapstone/mobile/models/Trap;Lcapstone/mobile/models/Trap;)V: Line 142
   * Goal 15. capstone.mobile.models.Walk.startWalk(Lcapstone/mobile/models/Trap;Lcapstone/mobile/models/Trap;)V: Line 143
   * Goal 16. capstone.mobile.models.Walk.startWalk(Lcapstone/mobile/models/Trap;Lcapstone/mobile/models/Trap;)V: Line 144
   * Goal 17. capstone.mobile.models.Walk.startWalk(Lcapstone/mobile/models/Trap;Lcapstone/mobile/models/Trap;)V: Line 145
   * Goal 18. [METHOD] capstone.mobile.models.Walk.<init>()V
   * Goal 19. [METHOD] capstone.mobile.models.Walk.setLineAtRestart(Lcapstone/mobile/models/Line;)V
   * Goal 20. [METHOD] capstone.mobile.models.Walk.startWalk(Lcapstone/mobile/models/Trap;Lcapstone/mobile/models/Trap;)V
   * Goal 21. [METHODNOEX] capstone.mobile.models.Walk.<init>()V
   * Goal 22. [METHODNOEX] capstone.mobile.models.Walk.setLineAtRestart(Lcapstone/mobile/models/Line;)V
   * Goal 23. Weak Mutation 29: capstone.mobile.models.Walk.startWalk(Lcapstone/mobile/models/Trap;Lcapstone/mobile/models/Trap;)V:140 - ReplaceConstant - 1 -> 0
   * Goal 24. Weak Mutation 30: capstone.mobile.models.Walk.startWalk(Lcapstone/mobile/models/Trap;Lcapstone/mobile/models/Trap;)V:141 - ReplaceVariable start -> end
   * Goal 25. Weak Mutation 31: capstone.mobile.models.Walk.startWalk(Lcapstone/mobile/models/Trap;Lcapstone/mobile/models/Trap;)V:142 - ReplaceVariable end -> start
   * Goal 26. Weak Mutation 32: capstone.mobile.models.Walk.startWalk(Lcapstone/mobile/models/Trap;Lcapstone/mobile/models/Trap;)V:143 - ReplaceComparisonOperator >= -> -1
   * Goal 27. Weak Mutation 35: capstone.mobile.models.Walk.startWalk(Lcapstone/mobile/models/Trap;Lcapstone/mobile/models/Trap;)V:143 - ReplaceConstant - 1 -> 0
   * Goal 28. Weak Mutation 37: capstone.mobile.models.Walk.startWalk(Lcapstone/mobile/models/Trap;Lcapstone/mobile/models/Trap;)V:144 - ReplaceVariable start -> end
   */

    @Test(timeout = 4000, expected = Exception.class)
    public void test00() throws Throwable {
        Trap trap0 = new Trap();
        Walk walk0 = new Walk();
        Line line0 = new Line((-72), "E/J6TtDH", 1, 159, 3512);
        walk0.setLineAtRestart(line0);
        Trap trap1 = new Trap((-2039), 239, (double) 239, (-2722.302926607359), true);
        walk0.startWalk(trap0, trap1);
        fail("Expecting exception: NoClassDefFoundError");
    }

    //Test case number: 1
  /*
   * 20 covered goals:
   * Goal 1. capstone.mobile.models.Walk.<init>()V: root-Branch
   * Goal 2. capstone.mobile.models.Walk.startWalk(Lcapstone/mobile/models/Trap;Lcapstone/mobile/models/Trap;)V: I25 Branch 3 IF_ICMPGE L143 - true
   * Goal 3. Branch capstone.mobile.models.Walk.<init>()V: root-Branch in context: capstone.mobile.models.Walk:<init>()V
   * Goal 4. Branch capstone.mobile.models.Walk.startWalk(Lcapstone/mobile/models/Trap;Lcapstone/mobile/models/Trap;)V: I25 Branch 3 IF_ICMPGE L143 - true in context: capstone.mobile.models.Walk:startWalk(Lcapstone/mobile/models/Trap;Lcapstone/mobile/models/Trap;)V
   * Goal 5. startWalk(Lcapstone/mobile/models/Trap;Lcapstone/mobile/models/Trap;)V_java.lang.NullPointerException_IMPLICIT
   * Goal 6. capstone.mobile.models.Walk.<init>()V: Line 33
   * Goal 7. capstone.mobile.models.Walk.<init>()V: Line 34
   * Goal 8. capstone.mobile.models.Walk.startWalk(Lcapstone/mobile/models/Trap;Lcapstone/mobile/models/Trap;)V: Line 140
   * Goal 9. capstone.mobile.models.Walk.startWalk(Lcapstone/mobile/models/Trap;Lcapstone/mobile/models/Trap;)V: Line 141
   * Goal 10. capstone.mobile.models.Walk.startWalk(Lcapstone/mobile/models/Trap;Lcapstone/mobile/models/Trap;)V: Line 142
   * Goal 11. capstone.mobile.models.Walk.startWalk(Lcapstone/mobile/models/Trap;Lcapstone/mobile/models/Trap;)V: Line 143
   * Goal 12. capstone.mobile.models.Walk.startWalk(Lcapstone/mobile/models/Trap;Lcapstone/mobile/models/Trap;)V: Line 144
   * Goal 13. [METHOD] capstone.mobile.models.Walk.<init>()V
   * Goal 14. [METHOD] capstone.mobile.models.Walk.startWalk(Lcapstone/mobile/models/Trap;Lcapstone/mobile/models/Trap;)V
   * Goal 15. [METHODNOEX] capstone.mobile.models.Walk.<init>()V
   * Goal 16. Weak Mutation 29: capstone.mobile.models.Walk.startWalk(Lcapstone/mobile/models/Trap;Lcapstone/mobile/models/Trap;)V:140 - ReplaceConstant - 1 -> 0
   * Goal 17. Weak Mutation 30: capstone.mobile.models.Walk.startWalk(Lcapstone/mobile/models/Trap;Lcapstone/mobile/models/Trap;)V:141 - ReplaceVariable start -> end
   * Goal 18. Weak Mutation 31: capstone.mobile.models.Walk.startWalk(Lcapstone/mobile/models/Trap;Lcapstone/mobile/models/Trap;)V:142 - ReplaceVariable end -> start
   * Goal 19. Weak Mutation 34: capstone.mobile.models.Walk.startWalk(Lcapstone/mobile/models/Trap;Lcapstone/mobile/models/Trap;)V:143 - ReplaceComparisonOperator >= -> ==
   * Goal 20. Weak Mutation 36: capstone.mobile.models.Walk.startWalk(Lcapstone/mobile/models/Trap;Lcapstone/mobile/models/Trap;)V:143 - ReplaceConstant - 0 -> 1
   */

    @Test(timeout = 4000, expected = NullPointerException.class)
    public void test01() throws Throwable {
        Trap trap0 = new Trap();
        Walk walk0 = new Walk();
        Trap trap1 = new Trap((-2039), (-2039), (double) (-2039), (-2722.302926607359), true);
        walk0.startWalk(trap0, trap1);
        fail("Expecting exception: NullPointerException");
    }

    //Test case number: 2
  /*
   * 21 covered goals:
   * Goal 1. capstone.mobile.models.Walk.<init>()V: root-Branch
   * Goal 2. capstone.mobile.models.Walk.setLineAtRestart(Lcapstone/mobile/models/Line;)V: root-Branch
   * Goal 3. capstone.mobile.models.Walk.getLine()Lcapstone/mobile/models/Line;: root-Branch
   * Goal 4. Branch capstone.mobile.models.Walk.setLineAtRestart(Lcapstone/mobile/models/Line;)V: root-Branch in context: capstone.mobile.models.Walk:setLineAtRestart(Lcapstone/mobile/models/Line;)V
   * Goal 5. Branch capstone.mobile.models.Walk.<init>()V: root-Branch in context: capstone.mobile.models.Walk:<init>()V
   * Goal 6. Branch capstone.mobile.models.Walk.getLine()Lcapstone/mobile/models/Line;: root-Branch in context: capstone.mobile.models.Walk:getLine()Lcapstone/mobile/models/Line;
   * Goal 7. [Output]: capstone.mobile.models.Walk.getLine()Lcapstone/mobile/models/Line;:NonNull:capstone.mobile.models.Line:getAnimal1()I:Zero
   * Goal 8. [Output]: capstone.mobile.models.Walk.getLine()Lcapstone/mobile/models/Line;:NonNull:capstone.mobile.models.Line:getAnimal2()I:Zero
   * Goal 9. [Output]: capstone.mobile.models.Walk.getLine()Lcapstone/mobile/models/Line;:NonNull:capstone.mobile.models.Line:getAnimal3()I:Zero
   * Goal 10. [Output]: capstone.mobile.models.Walk.getLine()Lcapstone/mobile/models/Line;:NonNull:capstone.mobile.models.Line:getId()I:Zero
   * Goal 11. capstone.mobile.models.Walk.<init>()V: Line 33
   * Goal 12. capstone.mobile.models.Walk.<init>()V: Line 34
   * Goal 13. capstone.mobile.models.Walk.getLine()Lcapstone/mobile/models/Line;: Line 46
   * Goal 14. capstone.mobile.models.Walk.setLineAtRestart(Lcapstone/mobile/models/Line;)V: Line 67
   * Goal 15. capstone.mobile.models.Walk.setLineAtRestart(Lcapstone/mobile/models/Line;)V: Line 68
   * Goal 16. [METHOD] capstone.mobile.models.Walk.<init>()V
   * Goal 17. [METHOD] capstone.mobile.models.Walk.getLine()Lcapstone/mobile/models/Line;
   * Goal 18. [METHOD] capstone.mobile.models.Walk.setLineAtRestart(Lcapstone/mobile/models/Line;)V
   * Goal 19. [METHODNOEX] capstone.mobile.models.Walk.<init>()V
   * Goal 20. [METHODNOEX] capstone.mobile.models.Walk.getLine()Lcapstone/mobile/models/Line;
   * Goal 21. [METHODNOEX] capstone.mobile.models.Walk.setLineAtRestart(Lcapstone/mobile/models/Line;)V
   */

    @Test(timeout = 4000)
    public void test02() throws Throwable {
        Walk walk0 = new Walk();
        Line line0 = new Line();
        walk0.setLineAtRestart(line0);
        Line line1 = walk0.getLine();
        assertEquals(0, line1.getAnimal1());
    }

    //Test case number: 3
  /*
   * 21 covered goals:
   * Goal 1. capstone.mobile.models.Walk.<init>()V: root-Branch
   * Goal 2. capstone.mobile.models.Walk.setLineAtRestart(Lcapstone/mobile/models/Line;)V: root-Branch
   * Goal 3. capstone.mobile.models.Walk.getLine()Lcapstone/mobile/models/Line;: root-Branch
   * Goal 4. Branch capstone.mobile.models.Walk.setLineAtRestart(Lcapstone/mobile/models/Line;)V: root-Branch in context: capstone.mobile.models.Walk:setLineAtRestart(Lcapstone/mobile/models/Line;)V
   * Goal 5. Branch capstone.mobile.models.Walk.<init>()V: root-Branch in context: capstone.mobile.models.Walk:<init>()V
   * Goal 6. Branch capstone.mobile.models.Walk.getLine()Lcapstone/mobile/models/Line;: root-Branch in context: capstone.mobile.models.Walk:getLine()Lcapstone/mobile/models/Line;
   * Goal 7. [Output]: capstone.mobile.models.Walk.getLine()Lcapstone/mobile/models/Line;:NonNull:capstone.mobile.models.Line:getAnimal1()I:Positive
   * Goal 8. [Output]: capstone.mobile.models.Walk.getLine()Lcapstone/mobile/models/Line;:NonNull:capstone.mobile.models.Line:getAnimal2()I:Positive
   * Goal 9. [Output]: capstone.mobile.models.Walk.getLine()Lcapstone/mobile/models/Line;:NonNull:capstone.mobile.models.Line:getAnimal3()I:Negative
   * Goal 10. [Output]: capstone.mobile.models.Walk.getLine()Lcapstone/mobile/models/Line;:NonNull:capstone.mobile.models.Line:getId()I:Zero
   * Goal 11. capstone.mobile.models.Walk.<init>()V: Line 33
   * Goal 12. capstone.mobile.models.Walk.<init>()V: Line 34
   * Goal 13. capstone.mobile.models.Walk.getLine()Lcapstone/mobile/models/Line;: Line 46
   * Goal 14. capstone.mobile.models.Walk.setLineAtRestart(Lcapstone/mobile/models/Line;)V: Line 67
   * Goal 15. capstone.mobile.models.Walk.setLineAtRestart(Lcapstone/mobile/models/Line;)V: Line 68
   * Goal 16. [METHOD] capstone.mobile.models.Walk.<init>()V
   * Goal 17. [METHOD] capstone.mobile.models.Walk.getLine()Lcapstone/mobile/models/Line;
   * Goal 18. [METHOD] capstone.mobile.models.Walk.setLineAtRestart(Lcapstone/mobile/models/Line;)V
   * Goal 19. [METHODNOEX] capstone.mobile.models.Walk.<init>()V
   * Goal 20. [METHODNOEX] capstone.mobile.models.Walk.getLine()Lcapstone/mobile/models/Line;
   * Goal 21. [METHODNOEX] capstone.mobile.models.Walk.setLineAtRestart(Lcapstone/mobile/models/Line;)V
   */

    @Test(timeout = 4000)
    public void test03() throws Throwable {
        Walk walk0 = new Walk();
        Line line0 = new Line(0, "SELECT * FROM traps WHERE lineId = ", 1, 1, (-69));
        walk0.setLineAtRestart(line0);
        Line line1 = walk0.getLine();
        assertEquals("SELECT * FROM traps WHERE lineId = ", line1.getName());
    }

    //Test case number: 4
  /*
   * 21 covered goals:
   * Goal 1. capstone.mobile.models.Walk.<init>()V: root-Branch
   * Goal 2. capstone.mobile.models.Walk.setLineAtRestart(Lcapstone/mobile/models/Line;)V: root-Branch
   * Goal 3. capstone.mobile.models.Walk.getLine()Lcapstone/mobile/models/Line;: root-Branch
   * Goal 4. Branch capstone.mobile.models.Walk.setLineAtRestart(Lcapstone/mobile/models/Line;)V: root-Branch in context: capstone.mobile.models.Walk:setLineAtRestart(Lcapstone/mobile/models/Line;)V
   * Goal 5. Branch capstone.mobile.models.Walk.<init>()V: root-Branch in context: capstone.mobile.models.Walk:<init>()V
   * Goal 6. Branch capstone.mobile.models.Walk.getLine()Lcapstone/mobile/models/Line;: root-Branch in context: capstone.mobile.models.Walk:getLine()Lcapstone/mobile/models/Line;
   * Goal 7. [Output]: capstone.mobile.models.Walk.getLine()Lcapstone/mobile/models/Line;:NonNull:capstone.mobile.models.Line:getAnimal1()I:Negative
   * Goal 8. [Output]: capstone.mobile.models.Walk.getLine()Lcapstone/mobile/models/Line;:NonNull:capstone.mobile.models.Line:getAnimal2()I:Negative
   * Goal 9. [Output]: capstone.mobile.models.Walk.getLine()Lcapstone/mobile/models/Line;:NonNull:capstone.mobile.models.Line:getAnimal3()I:Positive
   * Goal 10. [Output]: capstone.mobile.models.Walk.getLine()Lcapstone/mobile/models/Line;:NonNull:capstone.mobile.models.Line:getId()I:Positive
   * Goal 11. capstone.mobile.models.Walk.<init>()V: Line 33
   * Goal 12. capstone.mobile.models.Walk.<init>()V: Line 34
   * Goal 13. capstone.mobile.models.Walk.getLine()Lcapstone/mobile/models/Line;: Line 46
   * Goal 14. capstone.mobile.models.Walk.setLineAtRestart(Lcapstone/mobile/models/Line;)V: Line 67
   * Goal 15. capstone.mobile.models.Walk.setLineAtRestart(Lcapstone/mobile/models/Line;)V: Line 68
   * Goal 16. [METHOD] capstone.mobile.models.Walk.<init>()V
   * Goal 17. [METHOD] capstone.mobile.models.Walk.getLine()Lcapstone/mobile/models/Line;
   * Goal 18. [METHOD] capstone.mobile.models.Walk.setLineAtRestart(Lcapstone/mobile/models/Line;)V
   * Goal 19. [METHODNOEX] capstone.mobile.models.Walk.<init>()V
   * Goal 20. [METHODNOEX] capstone.mobile.models.Walk.getLine()Lcapstone/mobile/models/Line;
   * Goal 21. [METHODNOEX] capstone.mobile.models.Walk.setLineAtRestart(Lcapstone/mobile/models/Line;)V
   */

    @Test(timeout = 4000)
    public void test04() throws Throwable {
        Walk walk0 = new Walk();
        Line line0 = new Line(2326, "", (-2306), (-2306), 2326);
        walk0.setLineAtRestart(line0);
        Line line1 = walk0.getLine();
        assertSame(line1, line0);
    }

    //Test case number: 5
  /*
   * 20 covered goals:
   * Goal 1. capstone.mobile.models.Walk.<init>()V: root-Branch
   * Goal 2. capstone.mobile.models.Walk.addCatch(Lcapstone/mobile/models/Catch;)V: root-Branch
   * Goal 3. capstone.mobile.models.Walk.getCatches()Ljava/util/List;: root-Branch
   * Goal 4. Branch capstone.mobile.models.Walk.getCatches()Ljava/util/List;: root-Branch in context: capstone.mobile.models.Walk:getCatches()Ljava/util/List;
   * Goal 5. Branch capstone.mobile.models.Walk.addCatch(Lcapstone/mobile/models/Catch;)V: root-Branch in context: capstone.mobile.models.Walk:addCatch(Lcapstone/mobile/models/Catch;)V
   * Goal 6. Branch capstone.mobile.models.Walk.<init>()V: root-Branch in context: capstone.mobile.models.Walk:<init>()V
   * Goal 7. [Output]: capstone.mobile.models.Walk.getCatches()Ljava/util/List;:NonNull:java.util.List:isEmpty()Z:False
   * Goal 8. [Output]: capstone.mobile.models.Walk.getCatches()Ljava/util/List;:NonNull:java.util.List:size()I:Positive
   * Goal 9. capstone.mobile.models.Walk.<init>()V: Line 33
   * Goal 10. capstone.mobile.models.Walk.<init>()V: Line 34
   * Goal 11. capstone.mobile.models.Walk.addCatch(Lcapstone/mobile/models/Catch;)V: Line 177
   * Goal 12. capstone.mobile.models.Walk.addCatch(Lcapstone/mobile/models/Catch;)V: Line 178
   * Goal 13. capstone.mobile.models.Walk.addCatch(Lcapstone/mobile/models/Catch;)V: Line 179
   * Goal 14. capstone.mobile.models.Walk.getCatches()Ljava/util/List;: Line 168
   * Goal 15. [METHOD] capstone.mobile.models.Walk.<init>()V
   * Goal 16. [METHOD] capstone.mobile.models.Walk.addCatch(Lcapstone/mobile/models/Catch;)V
   * Goal 17. [METHOD] capstone.mobile.models.Walk.getCatches()Ljava/util/List;
   * Goal 18. [METHODNOEX] capstone.mobile.models.Walk.<init>()V
   * Goal 19. [METHODNOEX] capstone.mobile.models.Walk.addCatch(Lcapstone/mobile/models/Catch;)V
   * Goal 20. [METHODNOEX] capstone.mobile.models.Walk.getCatches()Ljava/util/List;
   */

    @Test(timeout = 4000)
    public void test05() throws Throwable {
        Walk  walk0  = new Walk();
        Catch catch0 = new Catch(0, 0, 0);
        walk0.addCatch(catch0);
        List<Catch> list0 = walk0.getCatches();
        assertFalse(list0.isEmpty());
    }

    //Test case number: 6
  /*
   * 25 covered goals:
   * Goal 1. capstone.mobile.models.Walk.<init>()V: root-Branch
   * Goal 2. capstone.mobile.models.Walk.setLineAtRestart(Lcapstone/mobile/models/Line;)V: root-Branch
   * Goal 3. capstone.mobile.models.Walk.startWalk(Lcapstone/mobile/models/Trap;Lcapstone/mobile/models/Trap;)V: I25 Branch 3 IF_ICMPGE L143 - true
   * Goal 4. Branch capstone.mobile.models.Walk.setLineAtRestart(Lcapstone/mobile/models/Line;)V: root-Branch in context: capstone.mobile.models.Walk:setLineAtRestart(Lcapstone/mobile/models/Line;)V
   * Goal 5. Branch capstone.mobile.models.Walk.<init>()V: root-Branch in context: capstone.mobile.models.Walk:<init>()V
   * Goal 6. Branch capstone.mobile.models.Walk.startWalk(Lcapstone/mobile/models/Trap;Lcapstone/mobile/models/Trap;)V: I25 Branch 3 IF_ICMPGE L143 - true in context: capstone.mobile.models.Walk:startWalk(Lcapstone/mobile/models/Trap;Lcapstone/mobile/models/Trap;)V
   * Goal 7. startWalk(Lcapstone/mobile/models/Trap;Lcapstone/mobile/models/Trap;)V_java.lang.NoClassDefFoundError_IMPLICIT
   * Goal 8. capstone.mobile.models.Walk.<init>()V: Line 33
   * Goal 9. capstone.mobile.models.Walk.<init>()V: Line 34
   * Goal 10. capstone.mobile.models.Walk.setLineAtRestart(Lcapstone/mobile/models/Line;)V: Line 67
   * Goal 11. capstone.mobile.models.Walk.setLineAtRestart(Lcapstone/mobile/models/Line;)V: Line 68
   * Goal 12. capstone.mobile.models.Walk.startWalk(Lcapstone/mobile/models/Trap;Lcapstone/mobile/models/Trap;)V: Line 140
   * Goal 13. capstone.mobile.models.Walk.startWalk(Lcapstone/mobile/models/Trap;Lcapstone/mobile/models/Trap;)V: Line 141
   * Goal 14. capstone.mobile.models.Walk.startWalk(Lcapstone/mobile/models/Trap;Lcapstone/mobile/models/Trap;)V: Line 142
   * Goal 15. capstone.mobile.models.Walk.startWalk(Lcapstone/mobile/models/Trap;Lcapstone/mobile/models/Trap;)V: Line 143
   * Goal 16. capstone.mobile.models.Walk.startWalk(Lcapstone/mobile/models/Trap;Lcapstone/mobile/models/Trap;)V: Line 144
   * Goal 17. capstone.mobile.models.Walk.startWalk(Lcapstone/mobile/models/Trap;Lcapstone/mobile/models/Trap;)V: Line 145
   * Goal 18. [METHOD] capstone.mobile.models.Walk.<init>()V
   * Goal 19. [METHOD] capstone.mobile.models.Walk.setLineAtRestart(Lcapstone/mobile/models/Line;)V
   * Goal 20. [METHOD] capstone.mobile.models.Walk.startWalk(Lcapstone/mobile/models/Trap;Lcapstone/mobile/models/Trap;)V
   * Goal 21. [METHODNOEX] capstone.mobile.models.Walk.<init>()V
   * Goal 22. [METHODNOEX] capstone.mobile.models.Walk.setLineAtRestart(Lcapstone/mobile/models/Line;)V
   * Goal 23. Weak Mutation 29: capstone.mobile.models.Walk.startWalk(Lcapstone/mobile/models/Trap;Lcapstone/mobile/models/Trap;)V:140 - ReplaceConstant - 1 -> 0
   * Goal 24. Weak Mutation 33: capstone.mobile.models.Walk.startWalk(Lcapstone/mobile/models/Trap;Lcapstone/mobile/models/Trap;)V:143 - ReplaceComparisonOperator >= -> >
   * Goal 25. Weak Mutation 36: capstone.mobile.models.Walk.startWalk(Lcapstone/mobile/models/Trap;Lcapstone/mobile/models/Trap;)V:143 - ReplaceConstant - 0 -> 1
   */

    @Test(timeout = 4000, expected = Exception.class)
    public void test06() throws Throwable {
        Trap trap0 = new Trap();
        Walk walk0 = new Walk();
        Line line0 = new Line();
        walk0.setLineAtRestart(line0);
        walk0.startWalk(trap0, trap0);
        fail("Expecting exception: NoClassDefFoundError");
    }

    //Test case number: 7
  /*
   * 12 covered goals:
   * Goal 1. capstone.mobile.models.Walk.<init>()V: root-Branch
   * Goal 2. capstone.mobile.models.Walk.setLine(Lcapstone/mobile/models/Line;)V: root-Branch
   * Goal 3. Branch capstone.mobile.models.Walk.<init>()V: root-Branch in context: capstone.mobile.models.Walk:<init>()V
   * Goal 4. Branch capstone.mobile.models.Walk.setLine(Lcapstone/mobile/models/Line;)V: root-Branch in context: capstone.mobile.models.Walk:setLine(Lcapstone/mobile/models/Line;)V
   * Goal 5. setLine(Lcapstone/mobile/models/Line;)V_java.lang.NullPointerException_IMPLICIT
   * Goal 6. capstone.mobile.models.Walk.<init>()V: Line 33
   * Goal 7. capstone.mobile.models.Walk.<init>()V: Line 34
   * Goal 8. capstone.mobile.models.Walk.setLine(Lcapstone/mobile/models/Line;)V: Line 56
   * Goal 9. capstone.mobile.models.Walk.setLine(Lcapstone/mobile/models/Line;)V: Line 57
   * Goal 10. [METHOD] capstone.mobile.models.Walk.<init>()V
   * Goal 11. [METHOD] capstone.mobile.models.Walk.setLine(Lcapstone/mobile/models/Line;)V
   * Goal 12. [METHODNOEX] capstone.mobile.models.Walk.<init>()V
   */

    @Test(timeout = 4000, expected = NullPointerException.class)
    public void test07() throws Throwable {
        Walk walk0 = new Walk();
        walk0.setLine(null);
        fail("Expecting exception: NullPointerException");
    }

    //Test case number: 8
  /*
   * 12 covered goals:
   * Goal 1. capstone.mobile.models.Walk.<init>()V: root-Branch
   * Goal 2. capstone.mobile.models.Walk.setLine(Lcapstone/mobile/models/Line;)V: root-Branch
   * Goal 3. Branch capstone.mobile.models.Walk.<init>()V: root-Branch in context: capstone.mobile.models.Walk:<init>()V
   * Goal 4. Branch capstone.mobile.models.Walk.setLine(Lcapstone/mobile/models/Line;)V: root-Branch in context: capstone.mobile.models.Walk:setLine(Lcapstone/mobile/models/Line;)V
   * Goal 5. setLine(Lcapstone/mobile/models/Line;)V_java.lang.NoClassDefFoundError_IMPLICIT
   * Goal 6. capstone.mobile.models.Walk.<init>()V: Line 33
   * Goal 7. capstone.mobile.models.Walk.<init>()V: Line 34
   * Goal 8. capstone.mobile.models.Walk.setLine(Lcapstone/mobile/models/Line;)V: Line 56
   * Goal 9. capstone.mobile.models.Walk.setLine(Lcapstone/mobile/models/Line;)V: Line 57
   * Goal 10. [METHOD] capstone.mobile.models.Walk.<init>()V
   * Goal 11. [METHOD] capstone.mobile.models.Walk.setLine(Lcapstone/mobile/models/Line;)V
   * Goal 12. [METHODNOEX] capstone.mobile.models.Walk.<init>()V
   */

    @Test(timeout = 4000, expected = Exception.class)
    public void test08() throws Throwable {
        Walk walk0 = new Walk();
        Line line0 = new Line(2, "Hk||AXXvvjy.j>hm<", 2, 2, 0);
        walk0.setLine(line0);
        fail("Expecting exception: NoClassDefFoundError");
    }

    //Test case number: 9
  /*
   * 9 covered goals:
   * Goal 1. capstone.mobile.models.Walk.<init>()V: root-Branch
   * Goal 2. Branch capstone.mobile.models.Walk.<init>()V: root-Branch in context: capstone.mobile.models.Walk:<init>()V
   * Goal 3. endCurrentTrap()V_java.lang.NullPointerException_IMPLICIT
   * Goal 4. capstone.mobile.models.Walk.<init>()V: Line 33
   * Goal 5. capstone.mobile.models.Walk.<init>()V: Line 34
   * Goal 6. capstone.mobile.models.Walk.endCurrentTrap()V: Line 82
   * Goal 7. [METHOD] capstone.mobile.models.Walk.<init>()V
   * Goal 8. [METHOD] capstone.mobile.models.Walk.endCurrentTrap()V
   * Goal 9. [METHODNOEX] capstone.mobile.models.Walk.<init>()V
   */

    @Test(timeout = 4000, expected = NullPointerException.class)
    public void test09() throws Throwable {
        Walk walk0 = new Walk();
        walk0.endCurrentTrap();
        fail("Expecting exception: NullPointerException");
    }

    //Test case number: 10
  /*
   * 20 covered goals:
   * Goal 1. capstone.mobile.models.Walk.<init>()V: root-Branch
   * Goal 2. capstone.mobile.models.Walk.getChangedTraps()Ljava/util/List;: root-Branch
   * Goal 3. capstone.mobile.models.Walk.addChangedTrap(Lcapstone/mobile/models/Trap;)V: root-Branch
   * Goal 4. Branch capstone.mobile.models.Walk.getChangedTraps()Ljava/util/List;: root-Branch in context: capstone.mobile.models.Walk:getChangedTraps()Ljava/util/List;
   * Goal 5. Branch capstone.mobile.models.Walk.<init>()V: root-Branch in context: capstone.mobile.models.Walk:<init>()V
   * Goal 6. Branch capstone.mobile.models.Walk.addChangedTrap(Lcapstone/mobile/models/Trap;)V: root-Branch in context: capstone.mobile.models.Walk:addChangedTrap(Lcapstone/mobile/models/Trap;)V
   * Goal 7. [Output]: capstone.mobile.models.Walk.getChangedTraps()Ljava/util/List;:NonNull:java.util.List:isEmpty()Z:False
   * Goal 8. [Output]: capstone.mobile.models.Walk.getChangedTraps()Ljava/util/List;:NonNull:java.util.List:size()I:Positive
   * Goal 9. capstone.mobile.models.Walk.<init>()V: Line 33
   * Goal 10. capstone.mobile.models.Walk.<init>()V: Line 34
   * Goal 11. capstone.mobile.models.Walk.addChangedTrap(Lcapstone/mobile/models/Trap;)V: Line 101
   * Goal 12. capstone.mobile.models.Walk.addChangedTrap(Lcapstone/mobile/models/Trap;)V: Line 102
   * Goal 13. capstone.mobile.models.Walk.addChangedTrap(Lcapstone/mobile/models/Trap;)V: Line 103
   * Goal 14. capstone.mobile.models.Walk.getChangedTraps()Ljava/util/List;: Line 111
   * Goal 15. [METHOD] capstone.mobile.models.Walk.<init>()V
   * Goal 16. [METHOD] capstone.mobile.models.Walk.addChangedTrap(Lcapstone/mobile/models/Trap;)V
   * Goal 17. [METHOD] capstone.mobile.models.Walk.getChangedTraps()Ljava/util/List;
   * Goal 18. [METHODNOEX] capstone.mobile.models.Walk.<init>()V
   * Goal 19. [METHODNOEX] capstone.mobile.models.Walk.addChangedTrap(Lcapstone/mobile/models/Trap;)V
   * Goal 20. [METHODNOEX] capstone.mobile.models.Walk.getChangedTraps()Ljava/util/List;
   */

    @Test(timeout = 4000)
    public void test10() throws Throwable {
        Walk walk0 = new Walk();
        Trap trap0 = new Trap(1, 1, 1, 217.0, (double) 1, 239, 1, 239);
        walk0.addChangedTrap(trap0);
        List<Trap> list0 = walk0.getChangedTraps();
        assertFalse(list0.isEmpty());
    }

    //Test case number: 11
  /*
   * 12 covered goals:
   * Goal 1. capstone.mobile.models.Walk.<init>()V: root-Branch
   * Goal 2. capstone.mobile.models.Walk.getEndTrap()Lcapstone/mobile/models/Trap;: root-Branch
   * Goal 3. Branch capstone.mobile.models.Walk.getEndTrap()Lcapstone/mobile/models/Trap;: root-Branch in context: capstone.mobile.models.Walk:getEndTrap()Lcapstone/mobile/models/Trap;
   * Goal 4. Branch capstone.mobile.models.Walk.<init>()V: root-Branch in context: capstone.mobile.models.Walk:<init>()V
   * Goal 5. [Output]: capstone.mobile.models.Walk.getEndTrap()Lcapstone/mobile/models/Trap;:Null
   * Goal 6. capstone.mobile.models.Walk.<init>()V: Line 33
   * Goal 7. capstone.mobile.models.Walk.<init>()V: Line 34
   * Goal 8. capstone.mobile.models.Walk.getEndTrap()Lcapstone/mobile/models/Trap;: Line 75
   * Goal 9. [METHOD] capstone.mobile.models.Walk.<init>()V
   * Goal 10. [METHOD] capstone.mobile.models.Walk.getEndTrap()Lcapstone/mobile/models/Trap;
   * Goal 11. [METHODNOEX] capstone.mobile.models.Walk.<init>()V
   * Goal 12. [METHODNOEX] capstone.mobile.models.Walk.getEndTrap()Lcapstone/mobile/models/Trap;
   */

    @Test(timeout = 4000)
    public void test11() throws Throwable {
        Walk walk0 = new Walk();
        Trap trap0 = walk0.getEndTrap();
        assertNull(trap0);
    }

    //Test case number: 12
  /*
   * 6 covered goals:
   * Goal 1. capstone.mobile.models.Walk.isWalking()Ljavafx/beans/property/BooleanProperty;: root-Branch
   * Goal 2. Branch capstone.mobile.models.Walk.isWalking()Ljavafx/beans/property/BooleanProperty;: root-Branch in context: capstone.mobile.models.Walk:isWalking()Ljavafx/beans/property/BooleanProperty;
   * Goal 3. [Output]: capstone.mobile.models.Walk.isWalking()Ljavafx/beans/property/BooleanProperty;:NonNull
   * Goal 4. capstone.mobile.models.Walk.isWalking()Ljavafx/beans/property/BooleanProperty;: Line 42
   * Goal 5. [METHOD] capstone.mobile.models.Walk.isWalking()Ljavafx/beans/property/BooleanProperty;
   * Goal 6. [METHODNOEX] capstone.mobile.models.Walk.isWalking()Ljavafx/beans/property/BooleanProperty;
   */

    @Test(timeout = 4000)
    public void test12() throws Throwable {
        SimpleBooleanProperty simpleBooleanProperty0 = (SimpleBooleanProperty) Walk.isWalking();
        assertNotNull(simpleBooleanProperty0);
    }

    //Test case number: 13
  /*
   * 12 covered goals:
   * Goal 1. capstone.mobile.models.Walk.<init>()V: root-Branch
   * Goal 2. capstone.mobile.models.Walk.getLine()Lcapstone/mobile/models/Line;: root-Branch
   * Goal 3. Branch capstone.mobile.models.Walk.<init>()V: root-Branch in context: capstone.mobile.models.Walk:<init>()V
   * Goal 4. Branch capstone.mobile.models.Walk.getLine()Lcapstone/mobile/models/Line;: root-Branch in context: capstone.mobile.models.Walk:getLine()Lcapstone/mobile/models/Line;
   * Goal 5. [Output]: capstone.mobile.models.Walk.getLine()Lcapstone/mobile/models/Line;:Null
   * Goal 6. capstone.mobile.models.Walk.<init>()V: Line 33
   * Goal 7. capstone.mobile.models.Walk.<init>()V: Line 34
   * Goal 8. capstone.mobile.models.Walk.getLine()Lcapstone/mobile/models/Line;: Line 46
   * Goal 9. [METHOD] capstone.mobile.models.Walk.<init>()V
   * Goal 10. [METHOD] capstone.mobile.models.Walk.getLine()Lcapstone/mobile/models/Line;
   * Goal 11. [METHODNOEX] capstone.mobile.models.Walk.<init>()V
   * Goal 12. [METHODNOEX] capstone.mobile.models.Walk.getLine()Lcapstone/mobile/models/Line;
   */

    @Test(timeout = 4000)
    public void test13() throws Throwable {
        Walk walk0 = new Walk();
        Line line0 = walk0.getLine();
        assertNull(line0);
    }

    //Test case number: 14
  /*
   * 13 covered goals:
   * Goal 1. capstone.mobile.models.Walk.<init>()V: root-Branch
   * Goal 2. capstone.mobile.models.Walk.isDirection()Z: root-Branch
   * Goal 3. Branch capstone.mobile.models.Walk.isDirection()Z: root-Branch in context: capstone.mobile.models.Walk:isDirection()Z
   * Goal 4. Branch capstone.mobile.models.Walk.<init>()V: root-Branch in context: capstone.mobile.models.Walk:<init>()V
   * Goal 5. [Output]: capstone.mobile.models.Walk.isDirection()Z:False
   * Goal 6. capstone.mobile.models.Walk.<init>()V: Line 33
   * Goal 7. capstone.mobile.models.Walk.<init>()V: Line 34
   * Goal 8. capstone.mobile.models.Walk.isDirection()Z: Line 130
   * Goal 9. [METHOD] capstone.mobile.models.Walk.<init>()V
   * Goal 10. [METHOD] capstone.mobile.models.Walk.isDirection()Z
   * Goal 11. [METHODNOEX] capstone.mobile.models.Walk.<init>()V
   * Goal 12. [METHODNOEX] capstone.mobile.models.Walk.isDirection()Z
   * Goal 13. Weak Mutation 28: capstone.mobile.models.Walk.isDirection()Z:130 - InsertUnaryOp Negation
   */

    @Test(timeout = 4000)
    public void test14() throws Throwable {
        Walk    walk0    = new Walk();
        assertNull(walk0.isDirection());
    }

    //Test case number: 15
  /*
   * 13 covered goals:
   * Goal 1. capstone.mobile.models.Walk.<init>()V: root-Branch
   * Goal 2. capstone.mobile.models.Walk.getChangedTraps()Ljava/util/List;: root-Branch
   * Goal 3. Branch capstone.mobile.models.Walk.getChangedTraps()Ljava/util/List;: root-Branch in context: capstone.mobile.models.Walk:getChangedTraps()Ljava/util/List;
   * Goal 4. Branch capstone.mobile.models.Walk.<init>()V: root-Branch in context: capstone.mobile.models.Walk:<init>()V
   * Goal 5. [Output]: capstone.mobile.models.Walk.getChangedTraps()Ljava/util/List;:NonNull:java.util.List:isEmpty()Z:True
   * Goal 6. [Output]: capstone.mobile.models.Walk.getChangedTraps()Ljava/util/List;:NonNull:java.util.List:size()I:Zero
   * Goal 7. capstone.mobile.models.Walk.<init>()V: Line 33
   * Goal 8. capstone.mobile.models.Walk.<init>()V: Line 34
   * Goal 9. capstone.mobile.models.Walk.getChangedTraps()Ljava/util/List;: Line 111
   * Goal 10. [METHOD] capstone.mobile.models.Walk.<init>()V
   * Goal 11. [METHOD] capstone.mobile.models.Walk.getChangedTraps()Ljava/util/List;
   * Goal 12. [METHODNOEX] capstone.mobile.models.Walk.<init>()V
   * Goal 13. [METHODNOEX] capstone.mobile.models.Walk.getChangedTraps()Ljava/util/List;
   */

    @Test(timeout = 4000)
    public void test15() throws Throwable {
        Walk       walk0 = new Walk();
        List<Trap> list0 = walk0.getChangedTraps();
        assertEquals(0, list0.size());
    }

    //Test case number: 16
  /*
   * 12 covered goals:
   * Goal 1. capstone.mobile.models.Walk.<init>()V: root-Branch
   * Goal 2. capstone.mobile.models.Walk.setLine(Lcapstone/mobile/models/Line;)V: root-Branch
   * Goal 3. Branch capstone.mobile.models.Walk.<init>()V: root-Branch in context: capstone.mobile.models.Walk:<init>()V
   * Goal 4. Branch capstone.mobile.models.Walk.setLine(Lcapstone/mobile/models/Line;)V: root-Branch in context: capstone.mobile.models.Walk:setLine(Lcapstone/mobile/models/Line;)V
   * Goal 5. setLine(Lcapstone/mobile/models/Line;)V_org.evosuite.runtime.mock.java.lang.MockException_DECLARED
   * Goal 6. capstone.mobile.models.Walk.<init>()V: Line 33
   * Goal 7. capstone.mobile.models.Walk.<init>()V: Line 34
   * Goal 8. capstone.mobile.models.Walk.setLine(Lcapstone/mobile/models/Line;)V: Line 56
   * Goal 9. capstone.mobile.models.Walk.setLine(Lcapstone/mobile/models/Line;)V: Line 57
   * Goal 10. [METHOD] capstone.mobile.models.Walk.<init>()V
   * Goal 11. [METHOD] capstone.mobile.models.Walk.setLine(Lcapstone/mobile/models/Line;)V
   * Goal 12. [METHODNOEX] capstone.mobile.models.Walk.<init>()V
   */

    @Test(timeout = 4000, expected = Exception.class)
    public void test16() throws Throwable {
        Walk walk0 = new Walk();
        Line line0 = new Line((-2228), "", (-2228), (-2228), 484);
        walk0.setLine(line0);
        fail("Expecting exception: Exception");
    }

    //Test case number: 17
  /*
   * 18 covered goals:
   * Goal 1. capstone.mobile.models.Walk.<init>()V: root-Branch
   * Goal 2. capstone.mobile.models.Walk.endWalk()V: root-Branch
   * Goal 3. Branch capstone.mobile.models.Walk.endWalk()V: root-Branch in context: capstone.mobile.models.Walk:endWalk()V
   * Goal 4. Branch capstone.mobile.models.Walk.<init>()V: root-Branch in context: capstone.mobile.models.Walk:<init>()V
   * Goal 5. endWalk()V_java.lang.NoClassDefFoundError_IMPLICIT
   * Goal 6. capstone.mobile.models.Walk.<init>()V: Line 33
   * Goal 7. capstone.mobile.models.Walk.<init>()V: Line 34
   * Goal 8. capstone.mobile.models.Walk.endWalk()V: Line 154
   * Goal 9. capstone.mobile.models.Walk.endWalk()V: Line 155
   * Goal 10. capstone.mobile.models.Walk.endWalk()V: Line 156
   * Goal 11. capstone.mobile.models.Walk.endWalk()V: Line 157
   * Goal 12. capstone.mobile.models.Walk.endWalk()V: Line 158
   * Goal 13. capstone.mobile.models.Walk.endWalk()V: Line 159
   * Goal 14. capstone.mobile.models.Walk.endWalk()V: Line 160
   * Goal 15. [METHOD] capstone.mobile.models.Walk.<init>()V
   * Goal 16. [METHOD] capstone.mobile.models.Walk.endWalk()V
   * Goal 17. [METHODNOEX] capstone.mobile.models.Walk.<init>()V
   * Goal 18. Weak Mutation 40: capstone.mobile.models.Walk.endWalk()V:154 - ReplaceConstant - 0 -> 1
   */

    @Test(timeout = 4000, expected = Exception.class)
    public void test17() throws Throwable {
        Walk walk0 = new Walk();
        walk0.endWalk();
        fail("Expecting exception: NoClassDefFoundError");
    }

    //Test case number: 18
  /*
   * 12 covered goals:
   * Goal 1. capstone.mobile.models.Walk.<init>()V: root-Branch
   * Goal 2. capstone.mobile.models.Walk.getCurrentTrap()Lcapstone/mobile/models/Trap;: root-Branch
   * Goal 3. Branch capstone.mobile.models.Walk.<init>()V: root-Branch in context: capstone.mobile.models.Walk:<init>()V
   * Goal 4. Branch capstone.mobile.models.Walk.getCurrentTrap()Lcapstone/mobile/models/Trap;: root-Branch in context: capstone.mobile.models.Walk:getCurrentTrap()Lcapstone/mobile/models/Trap;
   * Goal 5. [Output]: capstone.mobile.models.Walk.getCurrentTrap()Lcapstone/mobile/models/Trap;:Null
   * Goal 6. capstone.mobile.models.Walk.<init>()V: Line 33
   * Goal 7. capstone.mobile.models.Walk.<init>()V: Line 34
   * Goal 8. capstone.mobile.models.Walk.getCurrentTrap()Lcapstone/mobile/models/Trap;: Line 71
   * Goal 9. [METHOD] capstone.mobile.models.Walk.<init>()V
   * Goal 10. [METHOD] capstone.mobile.models.Walk.getCurrentTrap()Lcapstone/mobile/models/Trap;
   * Goal 11. [METHODNOEX] capstone.mobile.models.Walk.<init>()V
   * Goal 12. [METHODNOEX] capstone.mobile.models.Walk.getCurrentTrap()Lcapstone/mobile/models/Trap;
   */

    @Test(timeout = 4000)
    public void test18() throws Throwable {
        Walk walk0 = new Walk();
        Trap trap0 = walk0.getCurrentTrap();
        assertNull(trap0);
    }

    //Test case number: 19
  /*
   * 12 covered goals:
   * Goal 1. capstone.mobile.models.Walk.<init>()V: root-Branch
   * Goal 2. capstone.mobile.models.Walk.addCatchFromDB(Lcapstone/mobile/models/Catch;)V: root-Branch
   * Goal 3. Branch capstone.mobile.models.Walk.addCatchFromDB(Lcapstone/mobile/models/Catch;)V: root-Branch in context: capstone.mobile.models.Walk:addCatchFromDB(Lcapstone/mobile/models/Catch;)V
   * Goal 4. Branch capstone.mobile.models.Walk.<init>()V: root-Branch in context: capstone.mobile.models.Walk:<init>()V
   * Goal 5. capstone.mobile.models.Walk.<init>()V: Line 33
   * Goal 6. capstone.mobile.models.Walk.<init>()V: Line 34
   * Goal 7. capstone.mobile.models.Walk.addCatchFromDB(Lcapstone/mobile/models/Catch;)V: Line 187
   * Goal 8. capstone.mobile.models.Walk.addCatchFromDB(Lcapstone/mobile/models/Catch;)V: Line 188
   * Goal 9. [METHOD] capstone.mobile.models.Walk.<init>()V
   * Goal 10. [METHOD] capstone.mobile.models.Walk.addCatchFromDB(Lcapstone/mobile/models/Catch;)V
   * Goal 11. [METHODNOEX] capstone.mobile.models.Walk.<init>()V
   * Goal 12. [METHODNOEX] capstone.mobile.models.Walk.addCatchFromDB(Lcapstone/mobile/models/Catch;)V
   */

    @Test(timeout = 4000)
    public void test19() throws Throwable {
        Walk  walk0  = new Walk();
        Catch catch0 = new Catch(2, 2);
        walk0.addCatchFromDB(catch0);
        assertEquals(2, catch0.getAnimalId());
    }

    //Test case number: 20
  /*
   * 21 covered goals:
   * Goal 1. capstone.mobile.models.Walk.<init>()V: root-Branch
   * Goal 2. capstone.mobile.models.Walk.setLineAtRestart(Lcapstone/mobile/models/Line;)V: root-Branch
   * Goal 3. capstone.mobile.models.Walk.getLine()Lcapstone/mobile/models/Line;: root-Branch
   * Goal 4. Branch capstone.mobile.models.Walk.setLineAtRestart(Lcapstone/mobile/models/Line;)V: root-Branch in context: capstone.mobile.models.Walk:setLineAtRestart(Lcapstone/mobile/models/Line;)V
   * Goal 5. Branch capstone.mobile.models.Walk.<init>()V: root-Branch in context: capstone.mobile.models.Walk:<init>()V
   * Goal 6. Branch capstone.mobile.models.Walk.getLine()Lcapstone/mobile/models/Line;: root-Branch in context: capstone.mobile.models.Walk:getLine()Lcapstone/mobile/models/Line;
   * Goal 7. [Output]: capstone.mobile.models.Walk.getLine()Lcapstone/mobile/models/Line;:NonNull:capstone.mobile.models.Line:getAnimal1()I:Negative
   * Goal 8. [Output]: capstone.mobile.models.Walk.getLine()Lcapstone/mobile/models/Line;:NonNull:capstone.mobile.models.Line:getAnimal2()I:Negative
   * Goal 9. [Output]: capstone.mobile.models.Walk.getLine()Lcapstone/mobile/models/Line;:NonNull:capstone.mobile.models.Line:getAnimal3()I:Positive
   * Goal 10. [Output]: capstone.mobile.models.Walk.getLine()Lcapstone/mobile/models/Line;:NonNull:capstone.mobile.models.Line:getId()I:Negative
   * Goal 11. capstone.mobile.models.Walk.<init>()V: Line 33
   * Goal 12. capstone.mobile.models.Walk.<init>()V: Line 34
   * Goal 13. capstone.mobile.models.Walk.getLine()Lcapstone/mobile/models/Line;: Line 46
   * Goal 14. capstone.mobile.models.Walk.setLineAtRestart(Lcapstone/mobile/models/Line;)V: Line 67
   * Goal 15. capstone.mobile.models.Walk.setLineAtRestart(Lcapstone/mobile/models/Line;)V: Line 68
   * Goal 16. [METHOD] capstone.mobile.models.Walk.<init>()V
   * Goal 17. [METHOD] capstone.mobile.models.Walk.getLine()Lcapstone/mobile/models/Line;
   * Goal 18. [METHOD] capstone.mobile.models.Walk.setLineAtRestart(Lcapstone/mobile/models/Line;)V
   * Goal 19. [METHODNOEX] capstone.mobile.models.Walk.<init>()V
   * Goal 20. [METHODNOEX] capstone.mobile.models.Walk.getLine()Lcapstone/mobile/models/Line;
   * Goal 21. [METHODNOEX] capstone.mobile.models.Walk.setLineAtRestart(Lcapstone/mobile/models/Line;)V
   */

    @Test(timeout = 4000)
    public void test20() throws Throwable {
        Walk walk0 = new Walk();
        Line line0 = new Line((-2228), "", (-2228), (-2228), 484);
        walk0.setLineAtRestart(line0);
        Line line1 = walk0.getLine();
        assertEquals(-2228, line1.getAnimal1());
    }

    //Test case number: 21
  /*
   * 13 covered goals:
   * Goal 1. capstone.mobile.models.Walk.<init>()V: root-Branch
   * Goal 2. capstone.mobile.models.Walk.getCatches()Ljava/util/List;: root-Branch
   * Goal 3. Branch capstone.mobile.models.Walk.getCatches()Ljava/util/List;: root-Branch in context: capstone.mobile.models.Walk:getCatches()Ljava/util/List;
   * Goal 4. Branch capstone.mobile.models.Walk.<init>()V: root-Branch in context: capstone.mobile.models.Walk:<init>()V
   * Goal 5. [Output]: capstone.mobile.models.Walk.getCatches()Ljava/util/List;:NonNull:java.util.List:isEmpty()Z:True
   * Goal 6. [Output]: capstone.mobile.models.Walk.getCatches()Ljava/util/List;:NonNull:java.util.List:size()I:Zero
   * Goal 7. capstone.mobile.models.Walk.<init>()V: Line 33
   * Goal 8. capstone.mobile.models.Walk.<init>()V: Line 34
   * Goal 9. capstone.mobile.models.Walk.getCatches()Ljava/util/List;: Line 168
   * Goal 10. [METHOD] capstone.mobile.models.Walk.<init>()V
   * Goal 11. [METHOD] capstone.mobile.models.Walk.getCatches()Ljava/util/List;
   * Goal 12. [METHODNOEX] capstone.mobile.models.Walk.<init>()V
   * Goal 13. [METHODNOEX] capstone.mobile.models.Walk.getCatches()Ljava/util/List;
   */

    @Test(timeout = 4000)
    public void test21() throws Throwable {
        Walk        walk0 = new Walk();
        List<Catch> list0 = walk0.getCatches();
        assertTrue(list0.isEmpty());
    }

    //Test case number: 22
  /*
   * 13 covered goals:
   * Goal 1. capstone.mobile.models.Walk.<init>()V: root-Branch
   * Goal 2. capstone.mobile.models.Walk.addNewTrap(Lcapstone/mobile/models/Trap;)V: root-Branch
   * Goal 3. Branch capstone.mobile.models.Walk.<init>()V: root-Branch in context: capstone.mobile.models.Walk:<init>()V
   * Goal 4. Branch capstone.mobile.models.Walk.addNewTrap(Lcapstone/mobile/models/Trap;)V: root-Branch in context: capstone.mobile.models.Walk:addNewTrap(Lcapstone/mobile/models/Trap;)V
   * Goal 5. addNewTrap(Lcapstone/mobile/models/Trap;)V_java.lang.NoClassDefFoundError_IMPLICIT
   * Goal 6. capstone.mobile.models.Walk.<init>()V: Line 33
   * Goal 7. capstone.mobile.models.Walk.<init>()V: Line 34
   * Goal 8. capstone.mobile.models.Walk.addNewTrap(Lcapstone/mobile/models/Trap;)V: Line 120
   * Goal 9. capstone.mobile.models.Walk.addNewTrap(Lcapstone/mobile/models/Trap;)V: Line 121
   * Goal 10. capstone.mobile.models.Walk.addNewTrap(Lcapstone/mobile/models/Trap;)V: Line 122
   * Goal 11. [METHOD] capstone.mobile.models.Walk.<init>()V
   * Goal 12. [METHOD] capstone.mobile.models.Walk.addNewTrap(Lcapstone/mobile/models/Trap;)V
   * Goal 13. [METHODNOEX] capstone.mobile.models.Walk.<init>()V
   */

    @Test(timeout = 4000, expected = Exception.class)
    public void test22() throws Throwable {
        Walk walk0 = new Walk();
        walk0.setLine(new Line(7634, "Hfk-f", 7, 253, 824));
        Trap trap0 = new Trap();
        walk0.addNewTrap(trap0);
        fail("Expecting exception: NoClassDefFoundError");
    }
}
