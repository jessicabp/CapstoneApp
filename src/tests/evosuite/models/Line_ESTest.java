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


import capstone.mobile.models.Line;
import capstone.mobile.models.Trap;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;


public class Line_ESTest {

    //Test case number: 0
  /*
   * 34 covered goals:
   * Goal 1. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: root-Branch
   * Goal 2. Branch capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: root-Branch in context: capstone.mobile.models.Line:<init>(ILjava/lang/String;III)V
   * Goal 3. capstone.mobile.models.Line.<init>()V: Line 17
   * Goal 4. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 17
   * Goal 5. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 33
   * Goal 6. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 34
   * Goal 7. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 35
   * Goal 8. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 36
   * Goal 9. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 37
   * Goal 10. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 38
   * Goal 11. [METHOD] capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V
   * Goal 12. [METHODNOEX] capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V
   * Goal 13. Weak Mutation 0: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - ReplaceVariable id -> animal1
   * Goal 14. Weak Mutation 1: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - ReplaceVariable id -> animal2
   * Goal 15. Weak Mutation 2: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - ReplaceVariable id -> animal3
   * Goal 16. Weak Mutation 3: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp Negation of id
   * Goal 17. Weak Mutation 4: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp IINC 1 id
   * Goal 18. Weak Mutation 5: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp IINC -1 id
   * Goal 19. Weak Mutation 6: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - ReplaceVariable animal1 -> animal2
   * Goal 20. Weak Mutation 7: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - ReplaceVariable animal1 -> id
   * Goal 21. Weak Mutation 8: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - ReplaceVariable animal1 -> animal3
   * Goal 22. Weak Mutation 9: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp Negation of animal1
   * Goal 23. Weak Mutation 10: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp IINC 1 animal1
   * Goal 24. Weak Mutation 11: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp IINC -1 animal1
   * Goal 25. Weak Mutation 12: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - ReplaceVariable animal2 -> animal1
   * Goal 26. Weak Mutation 13: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - ReplaceVariable animal2 -> id
   * Goal 27. Weak Mutation 15: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp Negation of animal2
   * Goal 28. Weak Mutation 16: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp IINC 1 animal2
   * Goal 29. Weak Mutation 17: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp IINC -1 animal2
   * Goal 30. Weak Mutation 18: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - ReplaceVariable animal3 -> animal1
   * Goal 31. Weak Mutation 20: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - ReplaceVariable animal3 -> id
   * Goal 32. Weak Mutation 21: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp Negation of animal3
   * Goal 33. Weak Mutation 22: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp IINC 1 animal3
   * Goal 34. Weak Mutation 23: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp IINC -1 animal3
   */

    @Test(timeout = 4000)
    public void test00() throws Throwable {
        Line line0 = new Line((-2404), "f;", (-2304), 0, 0);
        assertEquals(-2404, line0.getId());
        assertEquals(0, line0.getAnimal2());
        assertEquals(-2304, line0.getAnimal1());
        assertEquals(0, line0.getAnimal3());
    }

    //Test case number: 1
  /*
   * 19 covered goals:
   * Goal 1. capstone.mobile.models.Line.getTraps()Ljava/util/List;: root-Branch
   * Goal 2. capstone.mobile.models.Line.setTraps(Ljava/util/List;)V: root-Branch
   * Goal 3. capstone.mobile.models.Line.<init>()V: root-Branch
   * Goal 4. Branch capstone.mobile.models.Line.<init>()V: root-Branch in context: capstone.mobile.models.Line:<init>()V
   * Goal 5. Branch capstone.mobile.models.Line.setTraps(Ljava/util/List;)V: root-Branch in context: capstone.mobile.models.Line:setTraps(Ljava/util/List;)V
   * Goal 6. Branch capstone.mobile.models.Line.getTraps()Ljava/util/List;: root-Branch in context: capstone.mobile.models.Line:getTraps()Ljava/util/List;
   * Goal 7. [Output]: capstone.mobile.models.Line.getTraps()Ljava/util/List;:Null
   * Goal 8. capstone.mobile.models.Line.<init>()V: Line 17
   * Goal 9. capstone.mobile.models.Line.<init>()V: Line 21
   * Goal 10. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 17
   * Goal 11. capstone.mobile.models.Line.getTraps()Ljava/util/List;: Line 100
   * Goal 12. capstone.mobile.models.Line.setTraps(Ljava/util/List;)V: Line 104
   * Goal 13. capstone.mobile.models.Line.setTraps(Ljava/util/List;)V: Line 105
   * Goal 14. [METHOD] capstone.mobile.models.Line.<init>()V
   * Goal 15. [METHOD] capstone.mobile.models.Line.getTraps()Ljava/util/List;
   * Goal 16. [METHOD] capstone.mobile.models.Line.setTraps(Ljava/util/List;)V
   * Goal 17. [METHODNOEX] capstone.mobile.models.Line.<init>()V
   * Goal 18. [METHODNOEX] capstone.mobile.models.Line.getTraps()Ljava/util/List;
   * Goal 19. [METHODNOEX] capstone.mobile.models.Line.setTraps(Ljava/util/List;)V
   */

    @Test(timeout = 4000)
    public void test01() throws Throwable {
        Line line0 = new Line();
        line0.setTraps(null);
        List<Trap> list0 = line0.getTraps();
        assertNull(list0);
    }

    //Test case number: 2
  /*
   * 22 covered goals:
   * Goal 1. capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;: root-Branch
   * Goal 2. capstone.mobile.models.Line.<init>()V: root-Branch
   * Goal 3. capstone.mobile.models.Line.addTrap(Lcapstone/mobile/models/Trap;)V: root-Branch
   * Goal 4. Branch capstone.mobile.models.Line.addTrap(Lcapstone/mobile/models/Trap;)V: root-Branch in context: capstone.mobile.models.Line:addTrap(Lcapstone/mobile/models/Trap;)V
   * Goal 5. Branch capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;: root-Branch in context: capstone.mobile.models.Line:getTrapByIndex(I)Lcapstone/mobile/models/Trap;
   * Goal 6. Branch capstone.mobile.models.Line.<init>()V: root-Branch in context: capstone.mobile.models.Line:<init>()V
   * Goal 7. [Output]: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:Null
   * Goal 8. capstone.mobile.models.Line.<init>()V: Line 17
   * Goal 9. capstone.mobile.models.Line.<init>()V: Line 21
   * Goal 10. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 17
   * Goal 11. capstone.mobile.models.Line.addTrap(Lcapstone/mobile/models/Trap;)V: Line 46
   * Goal 12. capstone.mobile.models.Line.addTrap(Lcapstone/mobile/models/Trap;)V: Line 47
   * Goal 13. capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;: Line 56
   * Goal 14. [METHOD] capstone.mobile.models.Line.<init>()V
   * Goal 15. [METHOD] capstone.mobile.models.Line.addTrap(Lcapstone/mobile/models/Trap;)V
   * Goal 16. [METHOD] capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;
   * Goal 17. [METHODNOEX] capstone.mobile.models.Line.<init>()V
   * Goal 18. [METHODNOEX] capstone.mobile.models.Line.addTrap(Lcapstone/mobile/models/Trap;)V
   * Goal 19. [METHODNOEX] capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;
   * Goal 20. Weak Mutation 24: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:56 - InsertUnaryOp Negation of index
   * Goal 21. Weak Mutation 25: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:56 - InsertUnaryOp IINC 1 index
   * Goal 22. Weak Mutation 26: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:56 - InsertUnaryOp IINC -1 index
   */

    @Test(timeout = 4000)
    public void test02() throws Throwable {
        Line line0 = new Line();
        line0.addTrap((Trap) null);
        Trap trap0 = line0.getTrapByIndex(0);
        assertNull(trap0);
    }

    //Test case number: 3
  /*
   * 29 covered goals:
   * Goal 1. capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;: root-Branch
   * Goal 2. capstone.mobile.models.Line.<init>()V: root-Branch
   * Goal 3. capstone.mobile.models.Line.addTrap(Lcapstone/mobile/models/Trap;)V: root-Branch
   * Goal 4. Branch capstone.mobile.models.Line.addTrap(Lcapstone/mobile/models/Trap;)V: root-Branch in context: capstone.mobile.models.Line:addTrap(Lcapstone/mobile/models/Trap;)V
   * Goal 5. Branch capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;: root-Branch in context: capstone.mobile.models.Line:getTrapByIndex(I)Lcapstone/mobile/models/Trap;
   * Goal 6. Branch capstone.mobile.models.Line.<init>()V: root-Branch in context: capstone.mobile.models.Line:<init>()V
   * Goal 7. [Output]: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:NonNull:capstone.mobile.models.Trap:getId()I:Zero
   * Goal 8. [Output]: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:NonNull:capstone.mobile.models.Trap:getLatitude()D:Zero
   * Goal 9. [Output]: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:NonNull:capstone.mobile.models.Trap:getLineId()I:Zero
   * Goal 10. [Output]: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:NonNull:capstone.mobile.models.Trap:getLongitude()D:Zero
   * Goal 11. [Output]: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:NonNull:capstone.mobile.models.Trap:getNumber()I:Zero
   * Goal 12. [Output]: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:NonNull:capstone.mobile.models.Trap:getSide()Z:False
   * Goal 13. [Output]: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:NonNull:capstone.mobile.models.Trap:isBroken()Z:False
   * Goal 14. [Output]: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:NonNull:capstone.mobile.models.Trap:isMoved()Z:True
   * Goal 15. capstone.mobile.models.Line.<init>()V: Line 17
   * Goal 16. capstone.mobile.models.Line.<init>()V: Line 21
   * Goal 17. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 17
   * Goal 18. capstone.mobile.models.Line.addTrap(Lcapstone/mobile/models/Trap;)V: Line 46
   * Goal 19. capstone.mobile.models.Line.addTrap(Lcapstone/mobile/models/Trap;)V: Line 47
   * Goal 20. capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;: Line 56
   * Goal 21. [METHOD] capstone.mobile.models.Line.<init>()V
   * Goal 22. [METHOD] capstone.mobile.models.Line.addTrap(Lcapstone/mobile/models/Trap;)V
   * Goal 23. [METHOD] capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;
   * Goal 24. [METHODNOEX] capstone.mobile.models.Line.<init>()V
   * Goal 25. [METHODNOEX] capstone.mobile.models.Line.addTrap(Lcapstone/mobile/models/Trap;)V
   * Goal 26. [METHODNOEX] capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;
   * Goal 27. Weak Mutation 24: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:56 - InsertUnaryOp Negation of index
   * Goal 28. Weak Mutation 25: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:56 - InsertUnaryOp IINC 1 index
   * Goal 29. Weak Mutation 26: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:56 - InsertUnaryOp IINC -1 index
   */

    @Test(timeout = 4000)
    public void test03() throws Throwable {
        Line line0 = new Line();
        Trap trap0 = new Trap();
        trap0.setMoved(true);
        line0.addTrap(trap0);
        Trap trap1 = line0.getTrapByIndex(0);
        assertEquals(0, trap1.getId());
    }

    //Test case number: 4
  /*
   * 46 covered goals:
   * Goal 1. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: root-Branch
   * Goal 2. capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;: root-Branch
   * Goal 3. capstone.mobile.models.Line.addTrap(Lcapstone/mobile/models/Trap;)V: root-Branch
   * Goal 4. Branch capstone.mobile.models.Line.addTrap(Lcapstone/mobile/models/Trap;)V: root-Branch in context: capstone.mobile.models.Line:addTrap(Lcapstone/mobile/models/Trap;)V
   * Goal 5. Branch capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;: root-Branch in context: capstone.mobile.models.Line:getTrapByIndex(I)Lcapstone/mobile/models/Trap;
   * Goal 6. Branch capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: root-Branch in context: capstone.mobile.models.Line:<init>(ILjava/lang/String;III)V
   * Goal 7. [Output]: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:NonNull:capstone.mobile.models.Trap:getId()I:Zero
   * Goal 8. [Output]: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:NonNull:capstone.mobile.models.Trap:getLatitude()D:Negative
   * Goal 9. [Output]: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:NonNull:capstone.mobile.models.Trap:getLineId()I:Zero
   * Goal 10. [Output]: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:NonNull:capstone.mobile.models.Trap:getLongitude()D:Zero
   * Goal 11. [Output]: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:NonNull:capstone.mobile.models.Trap:getNumber()I:Negative
   * Goal 12. [Output]: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:NonNull:capstone.mobile.models.Trap:getSide()Z:False
   * Goal 13. [Output]: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:NonNull:capstone.mobile.models.Trap:isBroken()Z:True
   * Goal 14. [Output]: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:NonNull:capstone.mobile.models.Trap:isMoved()Z:False
   * Goal 15. capstone.mobile.models.Line.<init>()V: Line 17
   * Goal 16. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 17
   * Goal 17. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 33
   * Goal 18. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 34
   * Goal 19. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 35
   * Goal 20. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 36
   * Goal 21. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 37
   * Goal 22. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 38
   * Goal 23. capstone.mobile.models.Line.addTrap(Lcapstone/mobile/models/Trap;)V: Line 46
   * Goal 24. capstone.mobile.models.Line.addTrap(Lcapstone/mobile/models/Trap;)V: Line 47
   * Goal 25. capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;: Line 56
   * Goal 26. [METHOD] capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V
   * Goal 27. [METHOD] capstone.mobile.models.Line.addTrap(Lcapstone/mobile/models/Trap;)V
   * Goal 28. [METHOD] capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;
   * Goal 29. [METHODNOEX] capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V
   * Goal 30. [METHODNOEX] capstone.mobile.models.Line.addTrap(Lcapstone/mobile/models/Trap;)V
   * Goal 31. [METHODNOEX] capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;
   * Goal 32. Weak Mutation 3: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp Negation of id
   * Goal 33. Weak Mutation 4: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp IINC 1 id
   * Goal 34. Weak Mutation 5: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp IINC -1 id
   * Goal 35. Weak Mutation 9: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp Negation of animal1
   * Goal 36. Weak Mutation 10: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp IINC 1 animal1
   * Goal 37. Weak Mutation 11: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp IINC -1 animal1
   * Goal 38. Weak Mutation 15: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp Negation of animal2
   * Goal 39. Weak Mutation 16: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp IINC 1 animal2
   * Goal 40. Weak Mutation 17: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp IINC -1 animal2
   * Goal 41. Weak Mutation 21: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp Negation of animal3
   * Goal 42. Weak Mutation 22: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp IINC 1 animal3
   * Goal 43. Weak Mutation 23: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp IINC -1 animal3
   * Goal 44. Weak Mutation 24: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:56 - InsertUnaryOp Negation of index
   * Goal 45. Weak Mutation 25: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:56 - InsertUnaryOp IINC 1 index
   * Goal 46. Weak Mutation 26: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:56 - InsertUnaryOp IINC -1 index
   */

    @Test(timeout = 4000)
    public void test04() throws Throwable {
        Line line0 = new Line(464, "", 464, 464, 464);
        Trap trap0 = new Trap(0, (-4042), (double) (-4042), 0.0, false);
        trap0.setBroken(true);
        line0.addTrap(trap0);
        line0.getTrapByIndex(0);
        assertEquals(464, line0.getId());
        assertEquals(464, line0.getAnimal3());
        assertEquals(464, line0.getAnimal1());
        assertEquals(464, line0.getAnimal2());
    }

    //Test case number: 5
  /*
   * 54 covered goals:
   * Goal 1. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: root-Branch
   * Goal 2. capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;: root-Branch
   * Goal 3. capstone.mobile.models.Line.addTrap(Lcapstone/mobile/models/Trap;)V: root-Branch
   * Goal 4. Branch capstone.mobile.models.Line.addTrap(Lcapstone/mobile/models/Trap;)V: root-Branch in context: capstone.mobile.models.Line:addTrap(Lcapstone/mobile/models/Trap;)V
   * Goal 5. Branch capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;: root-Branch in context: capstone.mobile.models.Line:getTrapByIndex(I)Lcapstone/mobile/models/Trap;
   * Goal 6. Branch capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: root-Branch in context: capstone.mobile.models.Line:<init>(ILjava/lang/String;III)V
   * Goal 7. [Output]: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:NonNull:capstone.mobile.models.Trap:getId()I:Zero
   * Goal 8. [Output]: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:NonNull:capstone.mobile.models.Trap:getLatitude()D:Negative
   * Goal 9. [Output]: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:NonNull:capstone.mobile.models.Trap:getLineId()I:Negative
   * Goal 10. [Output]: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:NonNull:capstone.mobile.models.Trap:getLongitude()D:Negative
   * Goal 11. [Output]: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:NonNull:capstone.mobile.models.Trap:getNumber()I:Positive
   * Goal 12. [Output]: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:NonNull:capstone.mobile.models.Trap:getSide()Z:True
   * Goal 13. [Output]: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:NonNull:capstone.mobile.models.Trap:isBroken()Z:False
   * Goal 14. [Output]: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:NonNull:capstone.mobile.models.Trap:isMoved()Z:False
   * Goal 15. capstone.mobile.models.Line.<init>()V: Line 17
   * Goal 16. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 17
   * Goal 17. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 33
   * Goal 18. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 34
   * Goal 19. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 35
   * Goal 20. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 36
   * Goal 21. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 37
   * Goal 22. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 38
   * Goal 23. capstone.mobile.models.Line.addTrap(Lcapstone/mobile/models/Trap;)V: Line 46
   * Goal 24. capstone.mobile.models.Line.addTrap(Lcapstone/mobile/models/Trap;)V: Line 47
   * Goal 25. capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;: Line 56
   * Goal 26. [METHOD] capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V
   * Goal 27. [METHOD] capstone.mobile.models.Line.addTrap(Lcapstone/mobile/models/Trap;)V
   * Goal 28. [METHOD] capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;
   * Goal 29. [METHODNOEX] capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V
   * Goal 30. [METHODNOEX] capstone.mobile.models.Line.addTrap(Lcapstone/mobile/models/Trap;)V
   * Goal 31. [METHODNOEX] capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;
   * Goal 32. Weak Mutation 0: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - ReplaceVariable id -> animal1
   * Goal 33. Weak Mutation 2: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - ReplaceVariable id -> animal3
   * Goal 34. Weak Mutation 3: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp Negation of id
   * Goal 35. Weak Mutation 4: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp IINC 1 id
   * Goal 36. Weak Mutation 5: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp IINC -1 id
   * Goal 37. Weak Mutation 6: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - ReplaceVariable animal1 -> animal2
   * Goal 38. Weak Mutation 7: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - ReplaceVariable animal1 -> id
   * Goal 39. Weak Mutation 9: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp Negation of animal1
   * Goal 40. Weak Mutation 10: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp IINC 1 animal1
   * Goal 41. Weak Mutation 11: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp IINC -1 animal1
   * Goal 42. Weak Mutation 12: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - ReplaceVariable animal2 -> animal1
   * Goal 43. Weak Mutation 14: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - ReplaceVariable animal2 -> animal3
   * Goal 44. Weak Mutation 15: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp Negation of animal2
   * Goal 45. Weak Mutation 16: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp IINC 1 animal2
   * Goal 46. Weak Mutation 17: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp IINC -1 animal2
   * Goal 47. Weak Mutation 19: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - ReplaceVariable animal3 -> animal2
   * Goal 48. Weak Mutation 20: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - ReplaceVariable animal3 -> id
   * Goal 49. Weak Mutation 21: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp Negation of animal3
   * Goal 50. Weak Mutation 22: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp IINC 1 animal3
   * Goal 51. Weak Mutation 23: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp IINC -1 animal3
   * Goal 52. Weak Mutation 24: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:56 - InsertUnaryOp Negation of index
   * Goal 53. Weak Mutation 25: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:56 - InsertUnaryOp IINC 1 index
   * Goal 54. Weak Mutation 26: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:56 - InsertUnaryOp IINC -1 index
   */

    @Test(timeout = 4000)
    public void test05() throws Throwable {
        Line line0 = new Line(4625, "KF&<+E|6b", 0, 4625, 0);
        Trap trap0 = new Trap((-1), 460, (-894.9), 0.0, true);
        trap0.setLongitude((-1.0));
        line0.addTrap(trap0);
        line0.getTrapByIndex(0);
        assertEquals(4625, line0.getId());
        assertEquals(0, line0.getAnimal3());
        assertEquals(4625, line0.getAnimal2());
        assertEquals(0, line0.getAnimal1());
    }

    //Test case number: 6
  /*
   * 46 covered goals:
   * Goal 1. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: root-Branch
   * Goal 2. capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;: root-Branch
   * Goal 3. capstone.mobile.models.Line.addTrap(Lcapstone/mobile/models/Trap;)V: root-Branch
   * Goal 4. Branch capstone.mobile.models.Line.addTrap(Lcapstone/mobile/models/Trap;)V: root-Branch in context: capstone.mobile.models.Line:addTrap(Lcapstone/mobile/models/Trap;)V
   * Goal 5. Branch capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;: root-Branch in context: capstone.mobile.models.Line:getTrapByIndex(I)Lcapstone/mobile/models/Trap;
   * Goal 6. Branch capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: root-Branch in context: capstone.mobile.models.Line:<init>(ILjava/lang/String;III)V
   * Goal 7. [Output]: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:NonNull:capstone.mobile.models.Trap:getId()I:Zero
   * Goal 8. [Output]: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:NonNull:capstone.mobile.models.Trap:getLatitude()D:Positive
   * Goal 9. [Output]: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:NonNull:capstone.mobile.models.Trap:getLineId()I:Positive
   * Goal 10. [Output]: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:NonNull:capstone.mobile.models.Trap:getLongitude()D:Positive
   * Goal 11. [Output]: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:NonNull:capstone.mobile.models.Trap:getNumber()I:Positive
   * Goal 12. [Output]: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:NonNull:capstone.mobile.models.Trap:getSide()Z:False
   * Goal 13. [Output]: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:NonNull:capstone.mobile.models.Trap:isBroken()Z:False
   * Goal 14. [Output]: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:NonNull:capstone.mobile.models.Trap:isMoved()Z:False
   * Goal 15. capstone.mobile.models.Line.<init>()V: Line 17
   * Goal 16. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 17
   * Goal 17. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 33
   * Goal 18. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 34
   * Goal 19. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 35
   * Goal 20. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 36
   * Goal 21. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 37
   * Goal 22. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 38
   * Goal 23. capstone.mobile.models.Line.addTrap(Lcapstone/mobile/models/Trap;)V: Line 46
   * Goal 24. capstone.mobile.models.Line.addTrap(Lcapstone/mobile/models/Trap;)V: Line 47
   * Goal 25. capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;: Line 56
   * Goal 26. [METHOD] capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V
   * Goal 27. [METHOD] capstone.mobile.models.Line.addTrap(Lcapstone/mobile/models/Trap;)V
   * Goal 28. [METHOD] capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;
   * Goal 29. [METHODNOEX] capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V
   * Goal 30. [METHODNOEX] capstone.mobile.models.Line.addTrap(Lcapstone/mobile/models/Trap;)V
   * Goal 31. [METHODNOEX] capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;
   * Goal 32. Weak Mutation 3: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp Negation of id
   * Goal 33. Weak Mutation 4: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp IINC 1 id
   * Goal 34. Weak Mutation 5: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp IINC -1 id
   * Goal 35. Weak Mutation 9: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp Negation of animal1
   * Goal 36. Weak Mutation 10: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp IINC 1 animal1
   * Goal 37. Weak Mutation 11: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp IINC -1 animal1
   * Goal 38. Weak Mutation 15: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp Negation of animal2
   * Goal 39. Weak Mutation 16: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp IINC 1 animal2
   * Goal 40. Weak Mutation 17: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp IINC -1 animal2
   * Goal 41. Weak Mutation 21: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp Negation of animal3
   * Goal 42. Weak Mutation 22: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp IINC 1 animal3
   * Goal 43. Weak Mutation 23: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp IINC -1 animal3
   * Goal 44. Weak Mutation 24: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:56 - InsertUnaryOp Negation of index
   * Goal 45. Weak Mutation 25: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:56 - InsertUnaryOp IINC 1 index
   * Goal 46. Weak Mutation 26: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:56 - InsertUnaryOp IINC -1 index
   */

    @Test(timeout = 4000)
    public void test06() throws Throwable {
        Line line0 = new Line(1340, "", 1340, 1340, 1340);
        Trap trap0 = new Trap(1340, 1866, (double) 1340, (double) 1340, false);
        line0.addTrap(trap0);
        line0.getTrapByIndex(0);
        assertEquals(1340, line0.getId());
        assertEquals(1340, line0.getAnimal2());
        assertEquals(1340, line0.getAnimal1());
        assertEquals(1340, line0.getAnimal3());
    }

    //Test case number: 7
  /*
   * 46 covered goals:
   * Goal 1. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: root-Branch
   * Goal 2. capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;: root-Branch
   * Goal 3. capstone.mobile.models.Line.addTrap(Lcapstone/mobile/models/Trap;)V: root-Branch
   * Goal 4. Branch capstone.mobile.models.Line.addTrap(Lcapstone/mobile/models/Trap;)V: root-Branch in context: capstone.mobile.models.Line:addTrap(Lcapstone/mobile/models/Trap;)V
   * Goal 5. Branch capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;: root-Branch in context: capstone.mobile.models.Line:getTrapByIndex(I)Lcapstone/mobile/models/Trap;
   * Goal 6. Branch capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: root-Branch in context: capstone.mobile.models.Line:<init>(ILjava/lang/String;III)V
   * Goal 7. [Output]: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:NonNull:capstone.mobile.models.Trap:getId()I:Positive
   * Goal 8. [Output]: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:NonNull:capstone.mobile.models.Trap:getLatitude()D:Positive
   * Goal 9. [Output]: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:NonNull:capstone.mobile.models.Trap:getLineId()I:Negative
   * Goal 10. [Output]: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:NonNull:capstone.mobile.models.Trap:getLongitude()D:Positive
   * Goal 11. [Output]: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:NonNull:capstone.mobile.models.Trap:getNumber()I:Positive
   * Goal 12. [Output]: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:NonNull:capstone.mobile.models.Trap:getSide()Z:False
   * Goal 13. [Output]: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:NonNull:capstone.mobile.models.Trap:isBroken()Z:False
   * Goal 14. [Output]: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:NonNull:capstone.mobile.models.Trap:isMoved()Z:False
   * Goal 15. capstone.mobile.models.Line.<init>()V: Line 17
   * Goal 16. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 17
   * Goal 17. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 33
   * Goal 18. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 34
   * Goal 19. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 35
   * Goal 20. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 36
   * Goal 21. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 37
   * Goal 22. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 38
   * Goal 23. capstone.mobile.models.Line.addTrap(Lcapstone/mobile/models/Trap;)V: Line 46
   * Goal 24. capstone.mobile.models.Line.addTrap(Lcapstone/mobile/models/Trap;)V: Line 47
   * Goal 25. capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;: Line 56
   * Goal 26. [METHOD] capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V
   * Goal 27. [METHOD] capstone.mobile.models.Line.addTrap(Lcapstone/mobile/models/Trap;)V
   * Goal 28. [METHOD] capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;
   * Goal 29. [METHODNOEX] capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V
   * Goal 30. [METHODNOEX] capstone.mobile.models.Line.addTrap(Lcapstone/mobile/models/Trap;)V
   * Goal 31. [METHODNOEX] capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;
   * Goal 32. Weak Mutation 3: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp Negation of id
   * Goal 33. Weak Mutation 4: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp IINC 1 id
   * Goal 34. Weak Mutation 5: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp IINC -1 id
   * Goal 35. Weak Mutation 9: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp Negation of animal1
   * Goal 36. Weak Mutation 10: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp IINC 1 animal1
   * Goal 37. Weak Mutation 11: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp IINC -1 animal1
   * Goal 38. Weak Mutation 15: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp Negation of animal2
   * Goal 39. Weak Mutation 16: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp IINC 1 animal2
   * Goal 40. Weak Mutation 17: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp IINC -1 animal2
   * Goal 41. Weak Mutation 21: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp Negation of animal3
   * Goal 42. Weak Mutation 22: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp IINC 1 animal3
   * Goal 43. Weak Mutation 23: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp IINC -1 animal3
   * Goal 44. Weak Mutation 24: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:56 - InsertUnaryOp Negation of index
   * Goal 45. Weak Mutation 25: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:56 - InsertUnaryOp IINC 1 index
   * Goal 46. Weak Mutation 26: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:56 - InsertUnaryOp IINC -1 index
   */

    @Test(timeout = 4000)
    public void test07() throws Throwable {
        Line line0 = new Line(464, "", 464, 464, 464);
        Trap trap0 = new Trap(2836, (-2994), 464, 2484.2034, (double) 2836, (-4042), 0, 464);
        line0.addTrap(trap0);
        line0.getTrapByIndex(0);
        assertEquals(464, line0.getId());
        assertEquals(464, line0.getAnimal2());
        assertEquals(464, line0.getAnimal3());
        assertEquals(464, line0.getAnimal1());
    }

    //Test case number: 8
  /*
   * 46 covered goals:
   * Goal 1. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: root-Branch
   * Goal 2. capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;: root-Branch
   * Goal 3. capstone.mobile.models.Line.addTrap(Lcapstone/mobile/models/Trap;)V: root-Branch
   * Goal 4. Branch capstone.mobile.models.Line.addTrap(Lcapstone/mobile/models/Trap;)V: root-Branch in context: capstone.mobile.models.Line:addTrap(Lcapstone/mobile/models/Trap;)V
   * Goal 5. Branch capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;: root-Branch in context: capstone.mobile.models.Line:getTrapByIndex(I)Lcapstone/mobile/models/Trap;
   * Goal 6. Branch capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: root-Branch in context: capstone.mobile.models.Line:<init>(ILjava/lang/String;III)V
   * Goal 7. [Output]: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:NonNull:capstone.mobile.models.Trap:getId()I:Negative
   * Goal 8. [Output]: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:NonNull:capstone.mobile.models.Trap:getLatitude()D:Zero
   * Goal 9. [Output]: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:NonNull:capstone.mobile.models.Trap:getLineId()I:Zero
   * Goal 10. [Output]: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:NonNull:capstone.mobile.models.Trap:getLongitude()D:Zero
   * Goal 11. [Output]: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:NonNull:capstone.mobile.models.Trap:getNumber()I:Negative
   * Goal 12. [Output]: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:NonNull:capstone.mobile.models.Trap:getSide()Z:True
   * Goal 13. [Output]: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:NonNull:capstone.mobile.models.Trap:isBroken()Z:False
   * Goal 14. [Output]: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:NonNull:capstone.mobile.models.Trap:isMoved()Z:False
   * Goal 15. capstone.mobile.models.Line.<init>()V: Line 17
   * Goal 16. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 17
   * Goal 17. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 33
   * Goal 18. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 34
   * Goal 19. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 35
   * Goal 20. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 36
   * Goal 21. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 37
   * Goal 22. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 38
   * Goal 23. capstone.mobile.models.Line.addTrap(Lcapstone/mobile/models/Trap;)V: Line 46
   * Goal 24. capstone.mobile.models.Line.addTrap(Lcapstone/mobile/models/Trap;)V: Line 47
   * Goal 25. capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;: Line 56
   * Goal 26. [METHOD] capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V
   * Goal 27. [METHOD] capstone.mobile.models.Line.addTrap(Lcapstone/mobile/models/Trap;)V
   * Goal 28. [METHOD] capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;
   * Goal 29. [METHODNOEX] capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V
   * Goal 30. [METHODNOEX] capstone.mobile.models.Line.addTrap(Lcapstone/mobile/models/Trap;)V
   * Goal 31. [METHODNOEX] capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;
   * Goal 32. Weak Mutation 3: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp Negation of id
   * Goal 33. Weak Mutation 4: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp IINC 1 id
   * Goal 34. Weak Mutation 5: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp IINC -1 id
   * Goal 35. Weak Mutation 9: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp Negation of animal1
   * Goal 36. Weak Mutation 10: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp IINC 1 animal1
   * Goal 37. Weak Mutation 11: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp IINC -1 animal1
   * Goal 38. Weak Mutation 15: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp Negation of animal2
   * Goal 39. Weak Mutation 16: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp IINC 1 animal2
   * Goal 40. Weak Mutation 17: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp IINC -1 animal2
   * Goal 41. Weak Mutation 21: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp Negation of animal3
   * Goal 42. Weak Mutation 22: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp IINC 1 animal3
   * Goal 43. Weak Mutation 23: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp IINC -1 animal3
   * Goal 44. Weak Mutation 24: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:56 - InsertUnaryOp Negation of index
   * Goal 45. Weak Mutation 25: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:56 - InsertUnaryOp IINC 1 index
   * Goal 46. Weak Mutation 26: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:56 - InsertUnaryOp IINC -1 index
   */

    @Test(timeout = 4000)
    public void test08() throws Throwable {
        Line line0 = new Line(0, "f;", 0, 0, 0);
        Trap trap0 = new Trap(0, (-2304), 0.0, 0.0, true);
        trap0.setId((-2304));
        line0.addTrap(trap0);
        line0.getTrapByIndex(0);
        assertEquals(0, line0.getAnimal2());
        assertEquals(0, line0.getAnimal3());
        assertEquals(0, line0.getId());
        assertEquals(0, line0.getAnimal1());
    }

    //Test case number: 9
  /*
   * 36 covered goals:
   * Goal 1. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: root-Branch
   * Goal 2. capstone.mobile.models.Line.getName()Ljava/lang/String;: root-Branch
   * Goal 3. Branch capstone.mobile.models.Line.getName()Ljava/lang/String;: root-Branch in context: capstone.mobile.models.Line:getName()Ljava/lang/String;
   * Goal 4. Branch capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: root-Branch in context: capstone.mobile.models.Line:<init>(ILjava/lang/String;III)V
   * Goal 5. [Output]: capstone.mobile.models.Line.getName()Ljava/lang/String;:NonEmptyString
   * Goal 6. capstone.mobile.models.Line.<init>()V: Line 17
   * Goal 7. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 17
   * Goal 8. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 33
   * Goal 9. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 34
   * Goal 10. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 35
   * Goal 11. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 36
   * Goal 12. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 37
   * Goal 13. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 38
   * Goal 14. capstone.mobile.models.Line.getName()Ljava/lang/String;: Line 68
   * Goal 15. [METHOD] capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V
   * Goal 16. [METHOD] capstone.mobile.models.Line.getName()Ljava/lang/String;
   * Goal 17. [METHODNOEX] capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V
   * Goal 18. [METHODNOEX] capstone.mobile.models.Line.getName()Ljava/lang/String;
   * Goal 19. Weak Mutation 2: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - ReplaceVariable id -> animal3
   * Goal 20. Weak Mutation 3: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp Negation of id
   * Goal 21. Weak Mutation 4: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp IINC 1 id
   * Goal 22. Weak Mutation 5: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp IINC -1 id
   * Goal 23. Weak Mutation 8: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - ReplaceVariable animal1 -> animal3
   * Goal 24. Weak Mutation 9: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp Negation of animal1
   * Goal 25. Weak Mutation 10: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp IINC 1 animal1
   * Goal 26. Weak Mutation 11: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp IINC -1 animal1
   * Goal 27. Weak Mutation 14: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - ReplaceVariable animal2 -> animal3
   * Goal 28. Weak Mutation 15: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp Negation of animal2
   * Goal 29. Weak Mutation 16: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp IINC 1 animal2
   * Goal 30. Weak Mutation 17: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp IINC -1 animal2
   * Goal 31. Weak Mutation 18: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - ReplaceVariable animal3 -> animal1
   * Goal 32. Weak Mutation 19: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - ReplaceVariable animal3 -> animal2
   * Goal 33. Weak Mutation 20: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - ReplaceVariable animal3 -> id
   * Goal 34. Weak Mutation 21: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp Negation of animal3
   * Goal 35. Weak Mutation 22: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp IINC 1 animal3
   * Goal 36. Weak Mutation 23: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp IINC -1 animal3
   */

    @Test(timeout = 4000)
    public void test09() throws Throwable {
        Line line0 = new Line((-2115), "(T}ZO", (-2115), (-2115), 0);
        line0.getName();
        assertEquals(0, line0.getAnimal3());
        assertEquals(-2115, line0.getAnimal2());
        assertEquals(-2115, line0.getId());
        assertEquals(-2115, line0.getAnimal1());
    }

    //Test case number: 10
  /*
   * 19 covered goals:
   * Goal 1. capstone.mobile.models.Line.setName(Ljava/lang/String;)V: root-Branch
   * Goal 2. capstone.mobile.models.Line.<init>()V: root-Branch
   * Goal 3. capstone.mobile.models.Line.getName()Ljava/lang/String;: root-Branch
   * Goal 4. Branch capstone.mobile.models.Line.getName()Ljava/lang/String;: root-Branch in context: capstone.mobile.models.Line:getName()Ljava/lang/String;
   * Goal 5. Branch capstone.mobile.models.Line.setName(Ljava/lang/String;)V: root-Branch in context: capstone.mobile.models.Line:setName(Ljava/lang/String;)V
   * Goal 6. Branch capstone.mobile.models.Line.<init>()V: root-Branch in context: capstone.mobile.models.Line:<init>()V
   * Goal 7. [Output]: capstone.mobile.models.Line.getName()Ljava/lang/String;:EmptyString
   * Goal 8. capstone.mobile.models.Line.<init>()V: Line 17
   * Goal 9. capstone.mobile.models.Line.<init>()V: Line 21
   * Goal 10. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 17
   * Goal 11. capstone.mobile.models.Line.getName()Ljava/lang/String;: Line 68
   * Goal 12. capstone.mobile.models.Line.setName(Ljava/lang/String;)V: Line 72
   * Goal 13. capstone.mobile.models.Line.setName(Ljava/lang/String;)V: Line 73
   * Goal 14. [METHOD] capstone.mobile.models.Line.<init>()V
   * Goal 15. [METHOD] capstone.mobile.models.Line.getName()Ljava/lang/String;
   * Goal 16. [METHOD] capstone.mobile.models.Line.setName(Ljava/lang/String;)V
   * Goal 17. [METHODNOEX] capstone.mobile.models.Line.<init>()V
   * Goal 18. [METHODNOEX] capstone.mobile.models.Line.getName()Ljava/lang/String;
   * Goal 19. [METHODNOEX] capstone.mobile.models.Line.setName(Ljava/lang/String;)V
   */

    @Test(timeout = 4000)
    public void test10() throws Throwable {
        Line line0 = new Line();
        line0.setName("");
        String string0 = line0.getName();
        assertEquals("", string0);
    }

    //Test case number: 11
  /*
   * 33 covered goals:
   * Goal 1. capstone.mobile.models.Line.getId()I: root-Branch
   * Goal 2. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: root-Branch
   * Goal 3. Branch capstone.mobile.models.Line.getId()I: root-Branch in context: capstone.mobile.models.Line:getId()I
   * Goal 4. Branch capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: root-Branch in context: capstone.mobile.models.Line:<init>(ILjava/lang/String;III)V
   * Goal 5. [Output]: capstone.mobile.models.Line.getId()I:Zero
   * Goal 6. capstone.mobile.models.Line.<init>()V: Line 17
   * Goal 7. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 17
   * Goal 8. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 33
   * Goal 9. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 34
   * Goal 10. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 35
   * Goal 11. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 36
   * Goal 12. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 37
   * Goal 13. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 38
   * Goal 14. capstone.mobile.models.Line.getId()I: Line 60
   * Goal 15. [METHOD] capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V
   * Goal 16. [METHOD] capstone.mobile.models.Line.getId()I
   * Goal 17. [METHODNOEX] capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V
   * Goal 18. [METHODNOEX] capstone.mobile.models.Line.getId()I
   * Goal 19. Weak Mutation 3: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp Negation of id
   * Goal 20. Weak Mutation 4: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp IINC 1 id
   * Goal 21. Weak Mutation 5: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp IINC -1 id
   * Goal 22. Weak Mutation 9: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp Negation of animal1
   * Goal 23. Weak Mutation 10: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp IINC 1 animal1
   * Goal 24. Weak Mutation 11: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp IINC -1 animal1
   * Goal 25. Weak Mutation 15: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp Negation of animal2
   * Goal 26. Weak Mutation 16: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp IINC 1 animal2
   * Goal 27. Weak Mutation 17: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp IINC -1 animal2
   * Goal 28. Weak Mutation 21: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp Negation of animal3
   * Goal 29. Weak Mutation 22: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp IINC 1 animal3
   * Goal 30. Weak Mutation 23: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp IINC -1 animal3
   * Goal 31. Weak Mutation 27: capstone.mobile.models.Line.getId()I:60 - InsertUnaryOp Negation
   * Goal 32. Weak Mutation 28: capstone.mobile.models.Line.getId()I:60 - InsertUnaryOp +1
   * Goal 33. Weak Mutation 29: capstone.mobile.models.Line.getId()I:60 - InsertUnaryOp -1
   */

    @Test(timeout = 4000)
    public void test11() throws Throwable {
        Line line0 = new Line(0, "OZ", 0, 0, 0);
        int  int0  = line0.getId();
        assertEquals(0, line0.getAnimal1());
        assertEquals(0, line0.getAnimal2());
        assertEquals(0, line0.getAnimal3());
        assertEquals(0, int0);
    }

    //Test case number: 12
  /*
   * 33 covered goals:
   * Goal 1. capstone.mobile.models.Line.getId()I: root-Branch
   * Goal 2. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: root-Branch
   * Goal 3. Branch capstone.mobile.models.Line.getId()I: root-Branch in context: capstone.mobile.models.Line:getId()I
   * Goal 4. Branch capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: root-Branch in context: capstone.mobile.models.Line:<init>(ILjava/lang/String;III)V
   * Goal 5. [Output]: capstone.mobile.models.Line.getId()I:Negative
   * Goal 6. capstone.mobile.models.Line.<init>()V: Line 17
   * Goal 7. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 17
   * Goal 8. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 33
   * Goal 9. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 34
   * Goal 10. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 35
   * Goal 11. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 36
   * Goal 12. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 37
   * Goal 13. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 38
   * Goal 14. capstone.mobile.models.Line.getId()I: Line 60
   * Goal 15. [METHOD] capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V
   * Goal 16. [METHOD] capstone.mobile.models.Line.getId()I
   * Goal 17. [METHODNOEX] capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V
   * Goal 18. [METHODNOEX] capstone.mobile.models.Line.getId()I
   * Goal 19. Weak Mutation 3: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp Negation of id
   * Goal 20. Weak Mutation 4: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp IINC 1 id
   * Goal 21. Weak Mutation 5: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp IINC -1 id
   * Goal 22. Weak Mutation 9: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp Negation of animal1
   * Goal 23. Weak Mutation 10: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp IINC 1 animal1
   * Goal 24. Weak Mutation 11: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp IINC -1 animal1
   * Goal 25. Weak Mutation 15: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp Negation of animal2
   * Goal 26. Weak Mutation 16: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp IINC 1 animal2
   * Goal 27. Weak Mutation 17: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp IINC -1 animal2
   * Goal 28. Weak Mutation 21: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp Negation of animal3
   * Goal 29. Weak Mutation 22: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp IINC 1 animal3
   * Goal 30. Weak Mutation 23: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp IINC -1 animal3
   * Goal 31. Weak Mutation 27: capstone.mobile.models.Line.getId()I:60 - InsertUnaryOp Negation
   * Goal 32. Weak Mutation 28: capstone.mobile.models.Line.getId()I:60 - InsertUnaryOp +1
   * Goal 33. Weak Mutation 29: capstone.mobile.models.Line.getId()I:60 - InsertUnaryOp -1
   */

    @Test(timeout = 4000)
    public void test12() throws Throwable {
        Line line0 = new Line((-1547), "-O>", (-1547), (-1547), (-1547));
        int  int0  = line0.getId();
        assertEquals((-1547), int0);
        assertEquals(-1547, line0.getAnimal3());
        assertEquals(-1547, line0.getAnimal1());
        assertEquals(-1547, line0.getAnimal2());
    }

    //Test case number: 13
  /*
   * 42 covered goals:
   * Goal 1. capstone.mobile.models.Line.getAnimal3()I: root-Branch
   * Goal 2. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: root-Branch
   * Goal 3. capstone.mobile.models.Line.setAnimal3(I)V: root-Branch
   * Goal 4. Branch capstone.mobile.models.Line.getAnimal3()I: root-Branch in context: capstone.mobile.models.Line:getAnimal3()I
   * Goal 5. Branch capstone.mobile.models.Line.setAnimal3(I)V: root-Branch in context: capstone.mobile.models.Line:setAnimal3(I)V
   * Goal 6. Branch capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: root-Branch in context: capstone.mobile.models.Line:<init>(ILjava/lang/String;III)V
   * Goal 7. [Output]: capstone.mobile.models.Line.getAnimal3()I:Negative
   * Goal 8. capstone.mobile.models.Line.<init>()V: Line 17
   * Goal 9. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 17
   * Goal 10. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 33
   * Goal 11. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 34
   * Goal 12. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 35
   * Goal 13. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 36
   * Goal 14. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 37
   * Goal 15. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 38
   * Goal 16. capstone.mobile.models.Line.getAnimal3()I: Line 92
   * Goal 17. capstone.mobile.models.Line.setAnimal3(I)V: Line 96
   * Goal 18. capstone.mobile.models.Line.setAnimal3(I)V: Line 97
   * Goal 19. [METHOD] capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V
   * Goal 20. [METHOD] capstone.mobile.models.Line.getAnimal3()I
   * Goal 21. [METHOD] capstone.mobile.models.Line.setAnimal3(I)V
   * Goal 22. [METHODNOEX] capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V
   * Goal 23. [METHODNOEX] capstone.mobile.models.Line.getAnimal3()I
   * Goal 24. [METHODNOEX] capstone.mobile.models.Line.setAnimal3(I)V
   * Goal 25. Weak Mutation 3: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp Negation of id
   * Goal 26. Weak Mutation 4: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp IINC 1 id
   * Goal 27. Weak Mutation 5: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp IINC -1 id
   * Goal 28. Weak Mutation 9: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp Negation of animal1
   * Goal 29. Weak Mutation 10: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp IINC 1 animal1
   * Goal 30. Weak Mutation 11: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp IINC -1 animal1
   * Goal 31. Weak Mutation 15: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp Negation of animal2
   * Goal 32. Weak Mutation 16: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp IINC 1 animal2
   * Goal 33. Weak Mutation 17: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp IINC -1 animal2
   * Goal 34. Weak Mutation 21: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp Negation of animal3
   * Goal 35. Weak Mutation 22: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp IINC 1 animal3
   * Goal 36. Weak Mutation 23: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp IINC -1 animal3
   * Goal 37. Weak Mutation 45: capstone.mobile.models.Line.getAnimal3()I:92 - InsertUnaryOp Negation
   * Goal 38. Weak Mutation 46: capstone.mobile.models.Line.getAnimal3()I:92 - InsertUnaryOp +1
   * Goal 39. Weak Mutation 47: capstone.mobile.models.Line.getAnimal3()I:92 - InsertUnaryOp -1
   * Goal 40. Weak Mutation 48: capstone.mobile.models.Line.setAnimal3(I)V:96 - InsertUnaryOp Negation of animal3
   * Goal 41. Weak Mutation 49: capstone.mobile.models.Line.setAnimal3(I)V:96 - InsertUnaryOp IINC 1 animal3
   * Goal 42. Weak Mutation 50: capstone.mobile.models.Line.setAnimal3(I)V:96 - InsertUnaryOp IINC -1 animal3
   */

    @Test(timeout = 4000)
    public void test13() throws Throwable {
        Line line0 = new Line(0, "f;", 0, 0, 0);
        line0.setAnimal3((-2304));
        int int0 = line0.getAnimal3();
        assertEquals((-2304), int0);
    }

    //Test case number: 14
  /*
   * 16 covered goals:
   * Goal 1. capstone.mobile.models.Line.<init>()V: root-Branch
   * Goal 2. capstone.mobile.models.Line.getAnimal2()I: root-Branch
   * Goal 3. Branch capstone.mobile.models.Line.<init>()V: root-Branch in context: capstone.mobile.models.Line:<init>()V
   * Goal 4. Branch capstone.mobile.models.Line.getAnimal2()I: root-Branch in context: capstone.mobile.models.Line:getAnimal2()I
   * Goal 5. [Output]: capstone.mobile.models.Line.getAnimal2()I:Zero
   * Goal 6. capstone.mobile.models.Line.<init>()V: Line 17
   * Goal 7. capstone.mobile.models.Line.<init>()V: Line 21
   * Goal 8. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 17
   * Goal 9. capstone.mobile.models.Line.getAnimal2()I: Line 84
   * Goal 10. [METHOD] capstone.mobile.models.Line.<init>()V
   * Goal 11. [METHOD] capstone.mobile.models.Line.getAnimal2()I
   * Goal 12. [METHODNOEX] capstone.mobile.models.Line.<init>()V
   * Goal 13. [METHODNOEX] capstone.mobile.models.Line.getAnimal2()I
   * Goal 14. Weak Mutation 39: capstone.mobile.models.Line.getAnimal2()I:84 - InsertUnaryOp Negation
   * Goal 15. Weak Mutation 40: capstone.mobile.models.Line.getAnimal2()I:84 - InsertUnaryOp +1
   * Goal 16. Weak Mutation 41: capstone.mobile.models.Line.getAnimal2()I:84 - InsertUnaryOp -1
   */

    @Test(timeout = 4000)
    public void test14() throws Throwable {
        Line line0 = new Line();
        int  int0  = line0.getAnimal2();
        assertEquals(0, int0);
    }

    //Test case number: 15
  /*
   * 33 covered goals:
   * Goal 1. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: root-Branch
   * Goal 2. capstone.mobile.models.Line.getAnimal2()I: root-Branch
   * Goal 3. Branch capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: root-Branch in context: capstone.mobile.models.Line:<init>(ILjava/lang/String;III)V
   * Goal 4. Branch capstone.mobile.models.Line.getAnimal2()I: root-Branch in context: capstone.mobile.models.Line:getAnimal2()I
   * Goal 5. [Output]: capstone.mobile.models.Line.getAnimal2()I:Negative
   * Goal 6. capstone.mobile.models.Line.<init>()V: Line 17
   * Goal 7. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 17
   * Goal 8. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 33
   * Goal 9. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 34
   * Goal 10. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 35
   * Goal 11. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 36
   * Goal 12. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 37
   * Goal 13. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 38
   * Goal 14. capstone.mobile.models.Line.getAnimal2()I: Line 84
   * Goal 15. [METHOD] capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V
   * Goal 16. [METHOD] capstone.mobile.models.Line.getAnimal2()I
   * Goal 17. [METHODNOEX] capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V
   * Goal 18. [METHODNOEX] capstone.mobile.models.Line.getAnimal2()I
   * Goal 19. Weak Mutation 3: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp Negation of id
   * Goal 20. Weak Mutation 4: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp IINC 1 id
   * Goal 21. Weak Mutation 5: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp IINC -1 id
   * Goal 22. Weak Mutation 9: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp Negation of animal1
   * Goal 23. Weak Mutation 10: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp IINC 1 animal1
   * Goal 24. Weak Mutation 11: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp IINC -1 animal1
   * Goal 25. Weak Mutation 15: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp Negation of animal2
   * Goal 26. Weak Mutation 16: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp IINC 1 animal2
   * Goal 27. Weak Mutation 17: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp IINC -1 animal2
   * Goal 28. Weak Mutation 21: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp Negation of animal3
   * Goal 29. Weak Mutation 22: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp IINC 1 animal3
   * Goal 30. Weak Mutation 23: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp IINC -1 animal3
   * Goal 31. Weak Mutation 39: capstone.mobile.models.Line.getAnimal2()I:84 - InsertUnaryOp Negation
   * Goal 32. Weak Mutation 40: capstone.mobile.models.Line.getAnimal2()I:84 - InsertUnaryOp +1
   * Goal 33. Weak Mutation 41: capstone.mobile.models.Line.getAnimal2()I:84 - InsertUnaryOp -1
   */

    @Test(timeout = 4000)
    public void test15() throws Throwable {
        Line line0 = new Line((-691), "Ir4N?{F>", (-691), (-691), (-691));
        int  int0  = line0.getAnimal2();
        assertEquals(-691, line0.getAnimal1());
        assertEquals(-691, line0.getId());
        assertEquals((-691), int0);
        assertEquals(-691, line0.getAnimal3());
    }

    //Test case number: 16
  /*
   * 33 covered goals:
   * Goal 1. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: root-Branch
   * Goal 2. capstone.mobile.models.Line.getAnimal1()I: root-Branch
   * Goal 3. Branch capstone.mobile.models.Line.getAnimal1()I: root-Branch in context: capstone.mobile.models.Line:getAnimal1()I
   * Goal 4. Branch capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: root-Branch in context: capstone.mobile.models.Line:<init>(ILjava/lang/String;III)V
   * Goal 5. [Output]: capstone.mobile.models.Line.getAnimal1()I:Positive
   * Goal 6. capstone.mobile.models.Line.<init>()V: Line 17
   * Goal 7. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 17
   * Goal 8. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 33
   * Goal 9. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 34
   * Goal 10. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 35
   * Goal 11. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 36
   * Goal 12. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 37
   * Goal 13. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 38
   * Goal 14. capstone.mobile.models.Line.getAnimal1()I: Line 76
   * Goal 15. [METHOD] capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V
   * Goal 16. [METHOD] capstone.mobile.models.Line.getAnimal1()I
   * Goal 17. [METHODNOEX] capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V
   * Goal 18. [METHODNOEX] capstone.mobile.models.Line.getAnimal1()I
   * Goal 19. Weak Mutation 3: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp Negation of id
   * Goal 20. Weak Mutation 4: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp IINC 1 id
   * Goal 21. Weak Mutation 5: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp IINC -1 id
   * Goal 22. Weak Mutation 9: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp Negation of animal1
   * Goal 23. Weak Mutation 10: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp IINC 1 animal1
   * Goal 24. Weak Mutation 11: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp IINC -1 animal1
   * Goal 25. Weak Mutation 15: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp Negation of animal2
   * Goal 26. Weak Mutation 16: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp IINC 1 animal2
   * Goal 27. Weak Mutation 17: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp IINC -1 animal2
   * Goal 28. Weak Mutation 21: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp Negation of animal3
   * Goal 29. Weak Mutation 22: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp IINC 1 animal3
   * Goal 30. Weak Mutation 23: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp IINC -1 animal3
   * Goal 31. Weak Mutation 33: capstone.mobile.models.Line.getAnimal1()I:76 - InsertUnaryOp Negation
   * Goal 32. Weak Mutation 34: capstone.mobile.models.Line.getAnimal1()I:76 - InsertUnaryOp +1
   * Goal 33. Weak Mutation 35: capstone.mobile.models.Line.getAnimal1()I:76 - InsertUnaryOp -1
   */

    @Test(timeout = 4000)
    public void test16() throws Throwable {
        Line line0 = new Line(1340, "", 1340, 1340, 1340);
        int  int0  = line0.getAnimal1();
        assertEquals(1340, line0.getId());
        assertEquals(1340, line0.getAnimal2());
        assertEquals(1340, line0.getAnimal3());
        assertEquals(1340, int0);
    }

    //Test case number: 17
  /*
   * 42 covered goals:
   * Goal 1. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: root-Branch
   * Goal 2. capstone.mobile.models.Line.getAnimal1()I: root-Branch
   * Goal 3. capstone.mobile.models.Line.setAnimal1(I)V: root-Branch
   * Goal 4. Branch capstone.mobile.models.Line.getAnimal1()I: root-Branch in context: capstone.mobile.models.Line:getAnimal1()I
   * Goal 5. Branch capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: root-Branch in context: capstone.mobile.models.Line:<init>(ILjava/lang/String;III)V
   * Goal 6. Branch capstone.mobile.models.Line.setAnimal1(I)V: root-Branch in context: capstone.mobile.models.Line:setAnimal1(I)V
   * Goal 7. [Output]: capstone.mobile.models.Line.getAnimal1()I:Negative
   * Goal 8. capstone.mobile.models.Line.<init>()V: Line 17
   * Goal 9. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 17
   * Goal 10. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 33
   * Goal 11. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 34
   * Goal 12. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 35
   * Goal 13. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 36
   * Goal 14. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 37
   * Goal 15. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 38
   * Goal 16. capstone.mobile.models.Line.getAnimal1()I: Line 76
   * Goal 17. capstone.mobile.models.Line.setAnimal1(I)V: Line 80
   * Goal 18. capstone.mobile.models.Line.setAnimal1(I)V: Line 81
   * Goal 19. [METHOD] capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V
   * Goal 20. [METHOD] capstone.mobile.models.Line.getAnimal1()I
   * Goal 21. [METHOD] capstone.mobile.models.Line.setAnimal1(I)V
   * Goal 22. [METHODNOEX] capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V
   * Goal 23. [METHODNOEX] capstone.mobile.models.Line.getAnimal1()I
   * Goal 24. [METHODNOEX] capstone.mobile.models.Line.setAnimal1(I)V
   * Goal 25. Weak Mutation 3: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp Negation of id
   * Goal 26. Weak Mutation 4: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp IINC 1 id
   * Goal 27. Weak Mutation 5: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp IINC -1 id
   * Goal 28. Weak Mutation 9: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp Negation of animal1
   * Goal 29. Weak Mutation 10: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp IINC 1 animal1
   * Goal 30. Weak Mutation 11: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp IINC -1 animal1
   * Goal 31. Weak Mutation 15: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp Negation of animal2
   * Goal 32. Weak Mutation 16: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp IINC 1 animal2
   * Goal 33. Weak Mutation 17: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp IINC -1 animal2
   * Goal 34. Weak Mutation 21: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp Negation of animal3
   * Goal 35. Weak Mutation 22: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp IINC 1 animal3
   * Goal 36. Weak Mutation 23: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp IINC -1 animal3
   * Goal 37. Weak Mutation 33: capstone.mobile.models.Line.getAnimal1()I:76 - InsertUnaryOp Negation
   * Goal 38. Weak Mutation 34: capstone.mobile.models.Line.getAnimal1()I:76 - InsertUnaryOp +1
   * Goal 39. Weak Mutation 35: capstone.mobile.models.Line.getAnimal1()I:76 - InsertUnaryOp -1
   * Goal 40. Weak Mutation 36: capstone.mobile.models.Line.setAnimal1(I)V:80 - InsertUnaryOp Negation of animal1
   * Goal 41. Weak Mutation 37: capstone.mobile.models.Line.setAnimal1(I)V:80 - InsertUnaryOp IINC 1 animal1
   * Goal 42. Weak Mutation 38: capstone.mobile.models.Line.setAnimal1(I)V:80 - InsertUnaryOp IINC -1 animal1
   */

    @Test(timeout = 4000)
    public void test17() throws Throwable {
        Line line0 = new Line(0, "f;", 0, 0, 0);
        line0.setAnimal1((-2304));
        int int0 = line0.getAnimal1();
        assertEquals((-2304), int0);
    }

    //Test case number: 18
  /*
   * 21 covered goals:
   * Goal 1. capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;: root-Branch
   * Goal 2. capstone.mobile.models.Line.setTraps(Ljava/util/List;)V: root-Branch
   * Goal 3. capstone.mobile.models.Line.<init>()V: root-Branch
   * Goal 4. Branch capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;: root-Branch in context: capstone.mobile.models.Line:getTrapByIndex(I)Lcapstone/mobile/models/Trap;
   * Goal 5. Branch capstone.mobile.models.Line.<init>()V: root-Branch in context: capstone.mobile.models.Line:<init>()V
   * Goal 6. Branch capstone.mobile.models.Line.setTraps(Ljava/util/List;)V: root-Branch in context: capstone.mobile.models.Line:setTraps(Ljava/util/List;)V
   * Goal 7. getTrapByIndex(I)Lcapstone/mobile/models/Trap;_java.lang.NullPointerException_IMPLICIT
   * Goal 8. capstone.mobile.models.Line.<init>()V: Line 17
   * Goal 9. capstone.mobile.models.Line.<init>()V: Line 21
   * Goal 10. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 17
   * Goal 11. capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;: Line 56
   * Goal 12. capstone.mobile.models.Line.setTraps(Ljava/util/List;)V: Line 104
   * Goal 13. capstone.mobile.models.Line.setTraps(Ljava/util/List;)V: Line 105
   * Goal 14. [METHOD] capstone.mobile.models.Line.<init>()V
   * Goal 15. [METHOD] capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;
   * Goal 16. [METHOD] capstone.mobile.models.Line.setTraps(Ljava/util/List;)V
   * Goal 17. [METHODNOEX] capstone.mobile.models.Line.<init>()V
   * Goal 18. [METHODNOEX] capstone.mobile.models.Line.setTraps(Ljava/util/List;)V
   * Goal 19. Weak Mutation 24: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:56 - InsertUnaryOp Negation of index
   * Goal 20. Weak Mutation 25: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:56 - InsertUnaryOp IINC 1 index
   * Goal 21. Weak Mutation 26: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:56 - InsertUnaryOp IINC -1 index
   */

    @Test(timeout = 4000, expected = NullPointerException.class)
    public void test18() throws Throwable {
        Line line0 = new Line();
        line0.setTraps(null);
        line0.getTrapByIndex(0);
        fail("Expecting exception: NullPointerException");
    }

    //Test case number: 19
  /*
   * 15 covered goals:
   * Goal 1. capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;: root-Branch
   * Goal 2. capstone.mobile.models.Line.<init>()V: root-Branch
   * Goal 3. Branch capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;: root-Branch in context: capstone.mobile.models.Line:getTrapByIndex(I)Lcapstone/mobile/models/Trap;
   * Goal 4. Branch capstone.mobile.models.Line.<init>()V: root-Branch in context: capstone.mobile.models.Line:<init>()V
   * Goal 5. getTrapByIndex(I)Lcapstone/mobile/models/Trap;_java.lang.ArrayIndexOutOfBoundsException_IMPLICIT
   * Goal 6. capstone.mobile.models.Line.<init>()V: Line 17
   * Goal 7. capstone.mobile.models.Line.<init>()V: Line 21
   * Goal 8. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 17
   * Goal 9. capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;: Line 56
   * Goal 10. [METHOD] capstone.mobile.models.Line.<init>()V
   * Goal 11. [METHOD] capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;
   * Goal 12. [METHODNOEX] capstone.mobile.models.Line.<init>()V
   * Goal 13. Weak Mutation 24: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:56 - InsertUnaryOp Negation of index
   * Goal 14. Weak Mutation 25: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:56 - InsertUnaryOp IINC 1 index
   * Goal 15. Weak Mutation 26: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:56 - InsertUnaryOp IINC -1 index
   */

    @Test(timeout = 4000)
    public void test19() throws Throwable {
        Line line0 = new Line();
        // Undeclared exception!
        try {
            line0.getTrapByIndex((-279));
            fail("Expecting exception: ArrayIndexOutOfBoundsException");

        } catch (ArrayIndexOutOfBoundsException e) {
            //
            // no message in exception (getMessage() returned null)
            //
        }
    }

    //Test case number: 20
  /*
   * 18 covered goals:
   * Goal 1. capstone.mobile.models.Line.setTraps(Ljava/util/List;)V: root-Branch
   * Goal 2. capstone.mobile.models.Line.<init>()V: root-Branch
   * Goal 3. capstone.mobile.models.Line.addTrap(Lcapstone/mobile/models/Trap;)V: root-Branch
   * Goal 4. Branch capstone.mobile.models.Line.addTrap(Lcapstone/mobile/models/Trap;)V: root-Branch in context: capstone.mobile.models.Line:addTrap(Lcapstone/mobile/models/Trap;)V
   * Goal 5. Branch capstone.mobile.models.Line.<init>()V: root-Branch in context: capstone.mobile.models.Line:<init>()V
   * Goal 6. Branch capstone.mobile.models.Line.setTraps(Ljava/util/List;)V: root-Branch in context: capstone.mobile.models.Line:setTraps(Ljava/util/List;)V
   * Goal 7. addTrap(Lcapstone/mobile/models/Trap;)V_java.lang.NullPointerException_IMPLICIT
   * Goal 8. capstone.mobile.models.Line.<init>()V: Line 17
   * Goal 9. capstone.mobile.models.Line.<init>()V: Line 21
   * Goal 10. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 17
   * Goal 11. capstone.mobile.models.Line.addTrap(Lcapstone/mobile/models/Trap;)V: Line 46
   * Goal 12. capstone.mobile.models.Line.setTraps(Ljava/util/List;)V: Line 104
   * Goal 13. capstone.mobile.models.Line.setTraps(Ljava/util/List;)V: Line 105
   * Goal 14. [METHOD] capstone.mobile.models.Line.<init>()V
   * Goal 15. [METHOD] capstone.mobile.models.Line.addTrap(Lcapstone/mobile/models/Trap;)V
   * Goal 16. [METHOD] capstone.mobile.models.Line.setTraps(Ljava/util/List;)V
   * Goal 17. [METHODNOEX] capstone.mobile.models.Line.<init>()V
   * Goal 18. [METHODNOEX] capstone.mobile.models.Line.setTraps(Ljava/util/List;)V
   */

    @Test(timeout = 4000, expected = NullPointerException.class)
    public void test20() throws Throwable {
        Line line0 = new Line();
        line0.setTraps(null);
        Trap trap0 = new Trap(4743, (-422), (-1.0), (-1.0), false);
        line0.addTrap(trap0);
        fail("Expecting exception: NullPointerException");
    }

    //Test case number: 21
  /*
   * 41 covered goals:
   * Goal 1. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: root-Branch
   * Goal 2. capstone.mobile.models.Line.getAnimal2()I: root-Branch
   * Goal 3. Branch capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: root-Branch in context: capstone.mobile.models.Line:<init>(ILjava/lang/String;III)V
   * Goal 4. Branch capstone.mobile.models.Line.getAnimal2()I: root-Branch in context: capstone.mobile.models.Line:getAnimal2()I
   * Goal 5. [Output]: capstone.mobile.models.Line.getAnimal2()I:Positive
   * Goal 6. capstone.mobile.models.Line.<init>()V: Line 17
   * Goal 7. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 17
   * Goal 8. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 33
   * Goal 9. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 34
   * Goal 10. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 35
   * Goal 11. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 36
   * Goal 12. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 37
   * Goal 13. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 38
   * Goal 14. capstone.mobile.models.Line.getAnimal2()I: Line 84
   * Goal 15. [METHOD] capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V
   * Goal 16. [METHOD] capstone.mobile.models.Line.getAnimal2()I
   * Goal 17. [METHODNOEX] capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V
   * Goal 18. [METHODNOEX] capstone.mobile.models.Line.getAnimal2()I
   * Goal 19. Weak Mutation 0: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - ReplaceVariable id -> animal1
   * Goal 20. Weak Mutation 2: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - ReplaceVariable id -> animal3
   * Goal 21. Weak Mutation 3: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp Negation of id
   * Goal 22. Weak Mutation 4: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp IINC 1 id
   * Goal 23. Weak Mutation 5: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp IINC -1 id
   * Goal 24. Weak Mutation 6: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - ReplaceVariable animal1 -> animal2
   * Goal 25. Weak Mutation 7: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - ReplaceVariable animal1 -> id
   * Goal 26. Weak Mutation 9: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp Negation of animal1
   * Goal 27. Weak Mutation 10: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp IINC 1 animal1
   * Goal 28. Weak Mutation 11: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp IINC -1 animal1
   * Goal 29. Weak Mutation 12: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - ReplaceVariable animal2 -> animal1
   * Goal 30. Weak Mutation 14: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - ReplaceVariable animal2 -> animal3
   * Goal 31. Weak Mutation 15: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp Negation of animal2
   * Goal 32. Weak Mutation 16: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp IINC 1 animal2
   * Goal 33. Weak Mutation 17: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp IINC -1 animal2
   * Goal 34. Weak Mutation 19: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - ReplaceVariable animal3 -> animal2
   * Goal 35. Weak Mutation 20: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - ReplaceVariable animal3 -> id
   * Goal 36. Weak Mutation 21: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp Negation of animal3
   * Goal 37. Weak Mutation 22: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp IINC 1 animal3
   * Goal 38. Weak Mutation 23: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp IINC -1 animal3
   * Goal 39. Weak Mutation 39: capstone.mobile.models.Line.getAnimal2()I:84 - InsertUnaryOp Negation
   * Goal 40. Weak Mutation 40: capstone.mobile.models.Line.getAnimal2()I:84 - InsertUnaryOp +1
   * Goal 41. Weak Mutation 41: capstone.mobile.models.Line.getAnimal2()I:84 - InsertUnaryOp -1
   */

    @Test(timeout = 4000)
    public void test21() throws Throwable {
        Line line0 = new Line(4625, "KF&<+E|6b", 0, 4625, 0);
        int  int0  = line0.getAnimal2();
        assertEquals(0, line0.getAnimal3());
        assertEquals(4625, int0);
        assertEquals(4625, line0.getId());
        assertEquals(0, line0.getAnimal1());
    }

    //Test case number: 22
  /*
   * 33 covered goals:
   * Goal 1. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: root-Branch
   * Goal 2. capstone.mobile.models.Line.getAnimal1()I: root-Branch
   * Goal 3. Branch capstone.mobile.models.Line.getAnimal1()I: root-Branch in context: capstone.mobile.models.Line:getAnimal1()I
   * Goal 4. Branch capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: root-Branch in context: capstone.mobile.models.Line:<init>(ILjava/lang/String;III)V
   * Goal 5. [Output]: capstone.mobile.models.Line.getAnimal1()I:Zero
   * Goal 6. capstone.mobile.models.Line.<init>()V: Line 17
   * Goal 7. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 17
   * Goal 8. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 33
   * Goal 9. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 34
   * Goal 10. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 35
   * Goal 11. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 36
   * Goal 12. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 37
   * Goal 13. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 38
   * Goal 14. capstone.mobile.models.Line.getAnimal1()I: Line 76
   * Goal 15. [METHOD] capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V
   * Goal 16. [METHOD] capstone.mobile.models.Line.getAnimal1()I
   * Goal 17. [METHODNOEX] capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V
   * Goal 18. [METHODNOEX] capstone.mobile.models.Line.getAnimal1()I
   * Goal 19. Weak Mutation 3: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp Negation of id
   * Goal 20. Weak Mutation 4: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp IINC 1 id
   * Goal 21. Weak Mutation 5: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp IINC -1 id
   * Goal 22. Weak Mutation 9: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp Negation of animal1
   * Goal 23. Weak Mutation 10: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp IINC 1 animal1
   * Goal 24. Weak Mutation 11: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp IINC -1 animal1
   * Goal 25. Weak Mutation 15: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp Negation of animal2
   * Goal 26. Weak Mutation 16: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp IINC 1 animal2
   * Goal 27. Weak Mutation 17: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp IINC -1 animal2
   * Goal 28. Weak Mutation 21: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp Negation of animal3
   * Goal 29. Weak Mutation 22: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp IINC 1 animal3
   * Goal 30. Weak Mutation 23: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp IINC -1 animal3
   * Goal 31. Weak Mutation 33: capstone.mobile.models.Line.getAnimal1()I:76 - InsertUnaryOp Negation
   * Goal 32. Weak Mutation 34: capstone.mobile.models.Line.getAnimal1()I:76 - InsertUnaryOp +1
   * Goal 33. Weak Mutation 35: capstone.mobile.models.Line.getAnimal1()I:76 - InsertUnaryOp -1
   */

    @Test(timeout = 4000)
    public void test22() throws Throwable {
        Line line0 = new Line(0, "f;", 0, 0, 0);
        int  int0  = line0.getAnimal1();
        assertEquals(0, int0);
        assertEquals(0, line0.getId());
        assertEquals(0, line0.getAnimal3());
        assertEquals(0, line0.getAnimal2());
    }

    //Test case number: 23
  /*
   * 37 covered goals:
   * Goal 1. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: root-Branch
   * Goal 2. capstone.mobile.models.Line.getTraps()Ljava/util/List;: root-Branch
   * Goal 3. capstone.mobile.models.Line.addTrap(Lcapstone/mobile/models/Trap;)V: root-Branch
   * Goal 4. Branch capstone.mobile.models.Line.addTrap(Lcapstone/mobile/models/Trap;)V: root-Branch in context: capstone.mobile.models.Line:addTrap(Lcapstone/mobile/models/Trap;)V
   * Goal 5. Branch capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: root-Branch in context: capstone.mobile.models.Line:<init>(ILjava/lang/String;III)V
   * Goal 6. Branch capstone.mobile.models.Line.getTraps()Ljava/util/List;: root-Branch in context: capstone.mobile.models.Line:getTraps()Ljava/util/List;
   * Goal 7. [Output]: capstone.mobile.models.Line.getTraps()Ljava/util/List;:NonNull:java.util.List:isEmpty()Z:False
   * Goal 8. [Output]: capstone.mobile.models.Line.getTraps()Ljava/util/List;:NonNull:java.util.List:size()I:Positive
   * Goal 9. capstone.mobile.models.Line.<init>()V: Line 17
   * Goal 10. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 17
   * Goal 11. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 33
   * Goal 12. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 34
   * Goal 13. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 35
   * Goal 14. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 36
   * Goal 15. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 37
   * Goal 16. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 38
   * Goal 17. capstone.mobile.models.Line.addTrap(Lcapstone/mobile/models/Trap;)V: Line 46
   * Goal 18. capstone.mobile.models.Line.addTrap(Lcapstone/mobile/models/Trap;)V: Line 47
   * Goal 19. capstone.mobile.models.Line.getTraps()Ljava/util/List;: Line 100
   * Goal 20. [METHOD] capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V
   * Goal 21. [METHOD] capstone.mobile.models.Line.addTrap(Lcapstone/mobile/models/Trap;)V
   * Goal 22. [METHOD] capstone.mobile.models.Line.getTraps()Ljava/util/List;
   * Goal 23. [METHODNOEX] capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V
   * Goal 24. [METHODNOEX] capstone.mobile.models.Line.addTrap(Lcapstone/mobile/models/Trap;)V
   * Goal 25. [METHODNOEX] capstone.mobile.models.Line.getTraps()Ljava/util/List;
   * Goal 26. Weak Mutation 3: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp Negation of id
   * Goal 27. Weak Mutation 4: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp IINC 1 id
   * Goal 28. Weak Mutation 5: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp IINC -1 id
   * Goal 29. Weak Mutation 9: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp Negation of animal1
   * Goal 30. Weak Mutation 10: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp IINC 1 animal1
   * Goal 31. Weak Mutation 11: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp IINC -1 animal1
   * Goal 32. Weak Mutation 15: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp Negation of animal2
   * Goal 33. Weak Mutation 16: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp IINC 1 animal2
   * Goal 34. Weak Mutation 17: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp IINC -1 animal2
   * Goal 35. Weak Mutation 21: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp Negation of animal3
   * Goal 36. Weak Mutation 22: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp IINC 1 animal3
   * Goal 37. Weak Mutation 23: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp IINC -1 animal3
   */

    @Test(timeout = 4000)
    public void test23() throws Throwable {
        Line line0 = new Line(0, "f;", 0, 0, 0);
        Trap trap0 = new Trap(0, (-2304), 0.0, 0.0, true);
        line0.addTrap(trap0);
        line0.getTraps();
        assertEquals(0, line0.getAnimal1());
        assertEquals(0, line0.getAnimal2());
        assertEquals(0, line0.getAnimal3());
        assertEquals(0, line0.getId());
    }

    //Test case number: 24
  /*
   * 13 covered goals:
   * Goal 1. capstone.mobile.models.Line.<init>()V: root-Branch
   * Goal 2. capstone.mobile.models.Line.getName()Ljava/lang/String;: root-Branch
   * Goal 3. Branch capstone.mobile.models.Line.getName()Ljava/lang/String;: root-Branch in context: capstone.mobile.models.Line:getName()Ljava/lang/String;
   * Goal 4. Branch capstone.mobile.models.Line.<init>()V: root-Branch in context: capstone.mobile.models.Line:<init>()V
   * Goal 5. [Output]: capstone.mobile.models.Line.getName()Ljava/lang/String;:Null
   * Goal 6. capstone.mobile.models.Line.<init>()V: Line 17
   * Goal 7. capstone.mobile.models.Line.<init>()V: Line 21
   * Goal 8. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 17
   * Goal 9. capstone.mobile.models.Line.getName()Ljava/lang/String;: Line 68
   * Goal 10. [METHOD] capstone.mobile.models.Line.<init>()V
   * Goal 11. [METHOD] capstone.mobile.models.Line.getName()Ljava/lang/String;
   * Goal 12. [METHODNOEX] capstone.mobile.models.Line.<init>()V
   * Goal 13. [METHODNOEX] capstone.mobile.models.Line.getName()Ljava/lang/String;
   */

    @Test(timeout = 4000)
    public void test24() throws Throwable {
        Line   line0   = new Line();
        String string0 = line0.getName();
        assertNull(string0);
    }

    //Test case number: 25
  /*
   * 42 covered goals:
   * Goal 1. capstone.mobile.models.Line.getAnimal3()I: root-Branch
   * Goal 2. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: root-Branch
   * Goal 3. capstone.mobile.models.Line.setAnimal3(I)V: root-Branch
   * Goal 4. Branch capstone.mobile.models.Line.getAnimal3()I: root-Branch in context: capstone.mobile.models.Line:getAnimal3()I
   * Goal 5. Branch capstone.mobile.models.Line.setAnimal3(I)V: root-Branch in context: capstone.mobile.models.Line:setAnimal3(I)V
   * Goal 6. Branch capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: root-Branch in context: capstone.mobile.models.Line:<init>(ILjava/lang/String;III)V
   * Goal 7. [Output]: capstone.mobile.models.Line.getAnimal3()I:Positive
   * Goal 8. capstone.mobile.models.Line.<init>()V: Line 17
   * Goal 9. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 17
   * Goal 10. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 33
   * Goal 11. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 34
   * Goal 12. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 35
   * Goal 13. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 36
   * Goal 14. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 37
   * Goal 15. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 38
   * Goal 16. capstone.mobile.models.Line.getAnimal3()I: Line 92
   * Goal 17. capstone.mobile.models.Line.setAnimal3(I)V: Line 96
   * Goal 18. capstone.mobile.models.Line.setAnimal3(I)V: Line 97
   * Goal 19. [METHOD] capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V
   * Goal 20. [METHOD] capstone.mobile.models.Line.getAnimal3()I
   * Goal 21. [METHOD] capstone.mobile.models.Line.setAnimal3(I)V
   * Goal 22. [METHODNOEX] capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V
   * Goal 23. [METHODNOEX] capstone.mobile.models.Line.getAnimal3()I
   * Goal 24. [METHODNOEX] capstone.mobile.models.Line.setAnimal3(I)V
   * Goal 25. Weak Mutation 3: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp Negation of id
   * Goal 26. Weak Mutation 4: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp IINC 1 id
   * Goal 27. Weak Mutation 5: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp IINC -1 id
   * Goal 28. Weak Mutation 9: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp Negation of animal1
   * Goal 29. Weak Mutation 10: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp IINC 1 animal1
   * Goal 30. Weak Mutation 11: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp IINC -1 animal1
   * Goal 31. Weak Mutation 15: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp Negation of animal2
   * Goal 32. Weak Mutation 16: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp IINC 1 animal2
   * Goal 33. Weak Mutation 17: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp IINC -1 animal2
   * Goal 34. Weak Mutation 21: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp Negation of animal3
   * Goal 35. Weak Mutation 22: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp IINC 1 animal3
   * Goal 36. Weak Mutation 23: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp IINC -1 animal3
   * Goal 37. Weak Mutation 45: capstone.mobile.models.Line.getAnimal3()I:92 - InsertUnaryOp Negation
   * Goal 38. Weak Mutation 46: capstone.mobile.models.Line.getAnimal3()I:92 - InsertUnaryOp +1
   * Goal 39. Weak Mutation 47: capstone.mobile.models.Line.getAnimal3()I:92 - InsertUnaryOp -1
   * Goal 40. Weak Mutation 48: capstone.mobile.models.Line.setAnimal3(I)V:96 - InsertUnaryOp Negation of animal3
   * Goal 41. Weak Mutation 49: capstone.mobile.models.Line.setAnimal3(I)V:96 - InsertUnaryOp IINC 1 animal3
   * Goal 42. Weak Mutation 50: capstone.mobile.models.Line.setAnimal3(I)V:96 - InsertUnaryOp IINC -1 animal3
   */

    @Test(timeout = 4000)
    public void test25() throws Throwable {
        Line line0 = new Line(0, "f;", 0, 0, 0);
        line0.setAnimal3(1239);
        int int0 = line0.getAnimal3();
        assertEquals(1239, int0);
    }

    //Test case number: 26
  /*
   * 33 covered goals:
   * Goal 1. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: root-Branch
   * Goal 2. capstone.mobile.models.Line.setId(I)V: root-Branch
   * Goal 3. Branch capstone.mobile.models.Line.setId(I)V: root-Branch in context: capstone.mobile.models.Line:setId(I)V
   * Goal 4. Branch capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: root-Branch in context: capstone.mobile.models.Line:<init>(ILjava/lang/String;III)V
   * Goal 5. capstone.mobile.models.Line.<init>()V: Line 17
   * Goal 6. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 17
   * Goal 7. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 33
   * Goal 8. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 34
   * Goal 9. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 35
   * Goal 10. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 36
   * Goal 11. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 37
   * Goal 12. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 38
   * Goal 13. capstone.mobile.models.Line.setId(I)V: Line 64
   * Goal 14. capstone.mobile.models.Line.setId(I)V: Line 65
   * Goal 15. [METHOD] capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V
   * Goal 16. [METHOD] capstone.mobile.models.Line.setId(I)V
   * Goal 17. [METHODNOEX] capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V
   * Goal 18. [METHODNOEX] capstone.mobile.models.Line.setId(I)V
   * Goal 19. Weak Mutation 3: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp Negation of id
   * Goal 20. Weak Mutation 4: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp IINC 1 id
   * Goal 21. Weak Mutation 5: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp IINC -1 id
   * Goal 22. Weak Mutation 9: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp Negation of animal1
   * Goal 23. Weak Mutation 10: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp IINC 1 animal1
   * Goal 24. Weak Mutation 11: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp IINC -1 animal1
   * Goal 25. Weak Mutation 15: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp Negation of animal2
   * Goal 26. Weak Mutation 16: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp IINC 1 animal2
   * Goal 27. Weak Mutation 17: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp IINC -1 animal2
   * Goal 28. Weak Mutation 21: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp Negation of animal3
   * Goal 29. Weak Mutation 22: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp IINC 1 animal3
   * Goal 30. Weak Mutation 23: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp IINC -1 animal3
   * Goal 31. Weak Mutation 30: capstone.mobile.models.Line.setId(I)V:64 - InsertUnaryOp Negation of id
   * Goal 32. Weak Mutation 31: capstone.mobile.models.Line.setId(I)V:64 - InsertUnaryOp IINC 1 id
   * Goal 33. Weak Mutation 32: capstone.mobile.models.Line.setId(I)V:64 - InsertUnaryOp IINC -1 id
   */

    @Test(timeout = 4000)
    public void test26() throws Throwable {
        Line line0 = new Line(0, "f;", 0, 0, 0);
        line0.setId(2603);
        assertEquals(2603, line0.getId());
    }

    //Test case number: 27
  /*
   * 37 covered goals:
   * Goal 1. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: root-Branch
   * Goal 2. capstone.mobile.models.Line.getTraps()Ljava/util/List;: root-Branch
   * Goal 3. capstone.mobile.models.Line.setTraps(Ljava/util/List;)V: root-Branch
   * Goal 4. Branch capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: root-Branch in context: capstone.mobile.models.Line:<init>(ILjava/lang/String;III)V
   * Goal 5. Branch capstone.mobile.models.Line.setTraps(Ljava/util/List;)V: root-Branch in context: capstone.mobile.models.Line:setTraps(Ljava/util/List;)V
   * Goal 6. Branch capstone.mobile.models.Line.getTraps()Ljava/util/List;: root-Branch in context: capstone.mobile.models.Line:getTraps()Ljava/util/List;
   * Goal 7. [Output]: capstone.mobile.models.Line.getTraps()Ljava/util/List;:NonNull:java.util.List:isEmpty()Z:True
   * Goal 8. [Output]: capstone.mobile.models.Line.getTraps()Ljava/util/List;:NonNull:java.util.List:size()I:Zero
   * Goal 9. capstone.mobile.models.Line.<init>()V: Line 17
   * Goal 10. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 17
   * Goal 11. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 33
   * Goal 12. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 34
   * Goal 13. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 35
   * Goal 14. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 36
   * Goal 15. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 37
   * Goal 16. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 38
   * Goal 17. capstone.mobile.models.Line.getTraps()Ljava/util/List;: Line 100
   * Goal 18. capstone.mobile.models.Line.setTraps(Ljava/util/List;)V: Line 104
   * Goal 19. capstone.mobile.models.Line.setTraps(Ljava/util/List;)V: Line 105
   * Goal 20. [METHOD] capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V
   * Goal 21. [METHOD] capstone.mobile.models.Line.getTraps()Ljava/util/List;
   * Goal 22. [METHOD] capstone.mobile.models.Line.setTraps(Ljava/util/List;)V
   * Goal 23. [METHODNOEX] capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V
   * Goal 24. [METHODNOEX] capstone.mobile.models.Line.getTraps()Ljava/util/List;
   * Goal 25. [METHODNOEX] capstone.mobile.models.Line.setTraps(Ljava/util/List;)V
   * Goal 26. Weak Mutation 3: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp Negation of id
   * Goal 27. Weak Mutation 4: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp IINC 1 id
   * Goal 28. Weak Mutation 5: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp IINC -1 id
   * Goal 29. Weak Mutation 9: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp Negation of animal1
   * Goal 30. Weak Mutation 10: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp IINC 1 animal1
   * Goal 31. Weak Mutation 11: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp IINC -1 animal1
   * Goal 32. Weak Mutation 15: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp Negation of animal2
   * Goal 33. Weak Mutation 16: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp IINC 1 animal2
   * Goal 34. Weak Mutation 17: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp IINC -1 animal2
   * Goal 35. Weak Mutation 21: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp Negation of animal3
   * Goal 36. Weak Mutation 22: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp IINC 1 animal3
   * Goal 37. Weak Mutation 23: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp IINC -1 animal3
   */

    @Test(timeout = 4000)
    public void test27() throws Throwable {
        Line       line0 = new Line(0, "f;", 0, 0, 0);
        List<Trap> list0 = line0.getTraps();
        line0.setTraps(list0);
        assertEquals(0, line0.getAnimal1());
        assertEquals(0, line0.getAnimal2());
        assertEquals(0, line0.getId());
        assertEquals(0, line0.getAnimal3());
    }

    //Test case number: 28
  /*
   * 41 covered goals:
   * Goal 1. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: root-Branch
   * Goal 2. capstone.mobile.models.Line.setAnimal2(I)V: root-Branch
   * Goal 3. Branch capstone.mobile.models.Line.setAnimal2(I)V: root-Branch in context: capstone.mobile.models.Line:setAnimal2(I)V
   * Goal 4. Branch capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: root-Branch in context: capstone.mobile.models.Line:<init>(ILjava/lang/String;III)V
   * Goal 5. capstone.mobile.models.Line.<init>()V: Line 17
   * Goal 6. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 17
   * Goal 7. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 33
   * Goal 8. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 34
   * Goal 9. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 35
   * Goal 10. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 36
   * Goal 11. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 37
   * Goal 12. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 38
   * Goal 13. capstone.mobile.models.Line.setAnimal2(I)V: Line 88
   * Goal 14. capstone.mobile.models.Line.setAnimal2(I)V: Line 89
   * Goal 15. [METHOD] capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V
   * Goal 16. [METHOD] capstone.mobile.models.Line.setAnimal2(I)V
   * Goal 17. [METHODNOEX] capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V
   * Goal 18. [METHODNOEX] capstone.mobile.models.Line.setAnimal2(I)V
   * Goal 19. Weak Mutation 0: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - ReplaceVariable id -> animal1
   * Goal 20. Weak Mutation 2: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - ReplaceVariable id -> animal3
   * Goal 21. Weak Mutation 3: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp Negation of id
   * Goal 22. Weak Mutation 4: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp IINC 1 id
   * Goal 23. Weak Mutation 5: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp IINC -1 id
   * Goal 24. Weak Mutation 6: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - ReplaceVariable animal1 -> animal2
   * Goal 25. Weak Mutation 7: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - ReplaceVariable animal1 -> id
   * Goal 26. Weak Mutation 9: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp Negation of animal1
   * Goal 27. Weak Mutation 10: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp IINC 1 animal1
   * Goal 28. Weak Mutation 11: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp IINC -1 animal1
   * Goal 29. Weak Mutation 12: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - ReplaceVariable animal2 -> animal1
   * Goal 30. Weak Mutation 14: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - ReplaceVariable animal2 -> animal3
   * Goal 31. Weak Mutation 15: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp Negation of animal2
   * Goal 32. Weak Mutation 16: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp IINC 1 animal2
   * Goal 33. Weak Mutation 17: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp IINC -1 animal2
   * Goal 34. Weak Mutation 19: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - ReplaceVariable animal3 -> animal2
   * Goal 35. Weak Mutation 20: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - ReplaceVariable animal3 -> id
   * Goal 36. Weak Mutation 21: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp Negation of animal3
   * Goal 37. Weak Mutation 22: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp IINC 1 animal3
   * Goal 38. Weak Mutation 23: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp IINC -1 animal3
   * Goal 39. Weak Mutation 42: capstone.mobile.models.Line.setAnimal2(I)V:88 - InsertUnaryOp Negation of animal2
   * Goal 40. Weak Mutation 43: capstone.mobile.models.Line.setAnimal2(I)V:88 - InsertUnaryOp IINC 1 animal2
   * Goal 41. Weak Mutation 44: capstone.mobile.models.Line.setAnimal2(I)V:88 - InsertUnaryOp IINC -1 animal2
   */

    @Test(timeout = 4000)
    public void test28() throws Throwable {
        Line line0 = new Line(4625, "KF&<+E|6b", 0, 4625, 0);
        assertEquals(4625, line0.getAnimal2());

        line0.setAnimal2(0);
        assertEquals(0, line0.getAnimal2());
    }

    //Test case number: 29
  /*
   * 32 covered goals:
   * Goal 1. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: root-Branch
   * Goal 2. capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;: root-Branch
   * Goal 3. Branch capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;: root-Branch in context: capstone.mobile.models.Line:getTrapByIndex(I)Lcapstone/mobile/models/Trap;
   * Goal 4. Branch capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: root-Branch in context: capstone.mobile.models.Line:<init>(ILjava/lang/String;III)V
   * Goal 5. getTrapByIndex(I)Lcapstone/mobile/models/Trap;_java.lang.IndexOutOfBoundsException_IMPLICIT
   * Goal 6. capstone.mobile.models.Line.<init>()V: Line 17
   * Goal 7. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 17
   * Goal 8. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 33
   * Goal 9. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 34
   * Goal 10. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 35
   * Goal 11. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 36
   * Goal 12. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 37
   * Goal 13. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 38
   * Goal 14. capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;: Line 56
   * Goal 15. [METHOD] capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V
   * Goal 16. [METHOD] capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;
   * Goal 17. [METHODNOEX] capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V
   * Goal 18. Weak Mutation 3: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp Negation of id
   * Goal 19. Weak Mutation 4: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp IINC 1 id
   * Goal 20. Weak Mutation 5: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp IINC -1 id
   * Goal 21. Weak Mutation 9: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp Negation of animal1
   * Goal 22. Weak Mutation 10: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp IINC 1 animal1
   * Goal 23. Weak Mutation 11: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp IINC -1 animal1
   * Goal 24. Weak Mutation 15: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp Negation of animal2
   * Goal 25. Weak Mutation 16: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp IINC 1 animal2
   * Goal 26. Weak Mutation 17: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp IINC -1 animal2
   * Goal 27. Weak Mutation 21: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp Negation of animal3
   * Goal 28. Weak Mutation 22: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp IINC 1 animal3
   * Goal 29. Weak Mutation 23: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp IINC -1 animal3
   * Goal 30. Weak Mutation 24: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:56 - InsertUnaryOp Negation of index
   * Goal 31. Weak Mutation 25: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:56 - InsertUnaryOp IINC 1 index
   * Goal 32. Weak Mutation 26: capstone.mobile.models.Line.getTrapByIndex(I)Lcapstone/mobile/models/Trap;:56 - InsertUnaryOp IINC -1 index
   */

    @Test(timeout = 4000, expected = IndexOutOfBoundsException.class)
    public void test29() throws Throwable {
        Line line0 = new Line(0, "f;", 0, 0, 0);
        line0.getTrapByIndex(0);
        fail("Expecting exception: IndexOutOfBoundsException");
    }

    //Test case number: 30
  /*
   * 33 covered goals:
   * Goal 1. capstone.mobile.models.Line.getAnimal3()I: root-Branch
   * Goal 2. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: root-Branch
   * Goal 3. Branch capstone.mobile.models.Line.getAnimal3()I: root-Branch in context: capstone.mobile.models.Line:getAnimal3()I
   * Goal 4. Branch capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: root-Branch in context: capstone.mobile.models.Line:<init>(ILjava/lang/String;III)V
   * Goal 5. [Output]: capstone.mobile.models.Line.getAnimal3()I:Zero
   * Goal 6. capstone.mobile.models.Line.<init>()V: Line 17
   * Goal 7. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 17
   * Goal 8. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 33
   * Goal 9. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 34
   * Goal 10. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 35
   * Goal 11. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 36
   * Goal 12. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 37
   * Goal 13. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 38
   * Goal 14. capstone.mobile.models.Line.getAnimal3()I: Line 92
   * Goal 15. [METHOD] capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V
   * Goal 16. [METHOD] capstone.mobile.models.Line.getAnimal3()I
   * Goal 17. [METHODNOEX] capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V
   * Goal 18. [METHODNOEX] capstone.mobile.models.Line.getAnimal3()I
   * Goal 19. Weak Mutation 3: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp Negation of id
   * Goal 20. Weak Mutation 4: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp IINC 1 id
   * Goal 21. Weak Mutation 5: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp IINC -1 id
   * Goal 22. Weak Mutation 9: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp Negation of animal1
   * Goal 23. Weak Mutation 10: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp IINC 1 animal1
   * Goal 24. Weak Mutation 11: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp IINC -1 animal1
   * Goal 25. Weak Mutation 15: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp Negation of animal2
   * Goal 26. Weak Mutation 16: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp IINC 1 animal2
   * Goal 27. Weak Mutation 17: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp IINC -1 animal2
   * Goal 28. Weak Mutation 21: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp Negation of animal3
   * Goal 29. Weak Mutation 22: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp IINC 1 animal3
   * Goal 30. Weak Mutation 23: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp IINC -1 animal3
   * Goal 31. Weak Mutation 45: capstone.mobile.models.Line.getAnimal3()I:92 - InsertUnaryOp Negation
   * Goal 32. Weak Mutation 46: capstone.mobile.models.Line.getAnimal3()I:92 - InsertUnaryOp +1
   * Goal 33. Weak Mutation 47: capstone.mobile.models.Line.getAnimal3()I:92 - InsertUnaryOp -1
   */

    @Test(timeout = 4000)
    public void test30() throws Throwable {
        Line line0 = new Line(0, "f;", 0, 0, 0);
        int  int0  = line0.getAnimal3();
        assertEquals(0, int0);
        assertEquals(0, line0.getAnimal2());
        assertEquals(0, line0.getAnimal1());
        assertEquals(0, line0.getId());
    }

    //Test case number: 31
  /*
   * 33 covered goals:
   * Goal 1. capstone.mobile.models.Line.getId()I: root-Branch
   * Goal 2. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: root-Branch
   * Goal 3. Branch capstone.mobile.models.Line.getId()I: root-Branch in context: capstone.mobile.models.Line:getId()I
   * Goal 4. Branch capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: root-Branch in context: capstone.mobile.models.Line:<init>(ILjava/lang/String;III)V
   * Goal 5. [Output]: capstone.mobile.models.Line.getId()I:Positive
   * Goal 6. capstone.mobile.models.Line.<init>()V: Line 17
   * Goal 7. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 17
   * Goal 8. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 33
   * Goal 9. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 34
   * Goal 10. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 35
   * Goal 11. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 36
   * Goal 12. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 37
   * Goal 13. capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V: Line 38
   * Goal 14. capstone.mobile.models.Line.getId()I: Line 60
   * Goal 15. [METHOD] capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V
   * Goal 16. [METHOD] capstone.mobile.models.Line.getId()I
   * Goal 17. [METHODNOEX] capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V
   * Goal 18. [METHODNOEX] capstone.mobile.models.Line.getId()I
   * Goal 19. Weak Mutation 3: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp Negation of id
   * Goal 20. Weak Mutation 4: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp IINC 1 id
   * Goal 21. Weak Mutation 5: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:33 - InsertUnaryOp IINC -1 id
   * Goal 22. Weak Mutation 9: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp Negation of animal1
   * Goal 23. Weak Mutation 10: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp IINC 1 animal1
   * Goal 24. Weak Mutation 11: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:35 - InsertUnaryOp IINC -1 animal1
   * Goal 25. Weak Mutation 15: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp Negation of animal2
   * Goal 26. Weak Mutation 16: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp IINC 1 animal2
   * Goal 27. Weak Mutation 17: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:36 - InsertUnaryOp IINC -1 animal2
   * Goal 28. Weak Mutation 21: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp Negation of animal3
   * Goal 29. Weak Mutation 22: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp IINC 1 animal3
   * Goal 30. Weak Mutation 23: capstone.mobile.models.Line.<init>(ILjava/lang/String;III)V:37 - InsertUnaryOp IINC -1 animal3
   * Goal 31. Weak Mutation 27: capstone.mobile.models.Line.getId()I:60 - InsertUnaryOp Negation
   * Goal 32. Weak Mutation 28: capstone.mobile.models.Line.getId()I:60 - InsertUnaryOp +1
   * Goal 33. Weak Mutation 29: capstone.mobile.models.Line.getId()I:60 - InsertUnaryOp -1
   */

    @Test(timeout = 4000)
    public void test31() throws Throwable {
        Line line0 = new Line(1340, "", 1340, 1340, 1340);
        int  int0  = line0.getId();
        assertEquals(1340, int0);
        assertEquals(1340, line0.getAnimal3());
        assertEquals(1340, line0.getAnimal2());
        assertEquals(1340, line0.getAnimal1());
    }
}
