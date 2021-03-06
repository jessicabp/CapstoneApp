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

import org.junit.Test;

import static org.junit.Assert.*;

import capstone.mobile.models.Animal;


public class Animal_ESTest {

    //Test case number: 0
  /*
   * 16 covered goals:
   * Goal 1. capstone.mobile.models.Animal.<init>(ILjava/lang/String;)V: root-Branch
   * Goal 2. capstone.mobile.models.Animal.getName()Ljava/lang/String;: root-Branch
   * Goal 3. Branch capstone.mobile.models.Animal.<init>(ILjava/lang/String;)V: root-Branch in context: capstone.mobile.models.Animal:<init>(ILjava/lang/String;)V
   * Goal 4. Branch capstone.mobile.models.Animal.getName()Ljava/lang/String;: root-Branch in context: capstone.mobile.models.Animal:getName()Ljava/lang/String;
   * Goal 5. [Output]: capstone.mobile.models.Animal.getName()Ljava/lang/String;:EmptyString
   * Goal 6. capstone.mobile.models.Animal.<init>(ILjava/lang/String;)V: Line 16
   * Goal 7. capstone.mobile.models.Animal.<init>(ILjava/lang/String;)V: Line 17
   * Goal 8. capstone.mobile.models.Animal.<init>(ILjava/lang/String;)V: Line 18
   * Goal 9. capstone.mobile.models.Animal.getName()Ljava/lang/String;: Line 29
   * Goal 10. [METHOD] capstone.mobile.models.Animal.<init>(ILjava/lang/String;)V
   * Goal 11. [METHOD] capstone.mobile.models.Animal.getName()Ljava/lang/String;
   * Goal 12. [METHODNOEX] capstone.mobile.models.Animal.<init>(ILjava/lang/String;)V
   * Goal 13. [METHODNOEX] capstone.mobile.models.Animal.getName()Ljava/lang/String;
   * Goal 14. Weak Mutation 0: capstone.mobile.models.Animal.<init>(ILjava/lang/String;)V:16 - InsertUnaryOp Negation of id
   * Goal 15. Weak Mutation 1: capstone.mobile.models.Animal.<init>(ILjava/lang/String;)V:16 - InsertUnaryOp IINC 1 id
   * Goal 16. Weak Mutation 2: capstone.mobile.models.Animal.<init>(ILjava/lang/String;)V:16 - InsertUnaryOp IINC -1 id
   */

    @Test(timeout = 4000)
    public void test0() throws Throwable {
        Animal animal0 = new Animal(2205, "");
        animal0.getName();
        assertEquals(2205, animal0.getId());
    }

    //Test case number: 1
  /*
   * 23 covered goals:
   * Goal 1. capstone.mobile.models.Animal.<init>()V: root-Branch
   * Goal 2. capstone.mobile.models.Animal.getId()I: root-Branch
   * Goal 3. capstone.mobile.models.Animal.setId(I)V: root-Branch
   * Goal 4. Branch capstone.mobile.models.Animal.getId()I: root-Branch in context: capstone.mobile.models.Animal:getId()I
   * Goal 5. Branch capstone.mobile.models.Animal.<init>()V: root-Branch in context: capstone.mobile.models.Animal:<init>()V
   * Goal 6. Branch capstone.mobile.models.Animal.setId(I)V: root-Branch in context: capstone.mobile.models.Animal:setId(I)V
   * Goal 7. [Output]: capstone.mobile.models.Animal.getId()I:Negative
   * Goal 8. capstone.mobile.models.Animal.<init>()V: Line 13
   * Goal 9. capstone.mobile.models.Animal.getId()I: Line 21
   * Goal 10. capstone.mobile.models.Animal.setId(I)V: Line 25
   * Goal 11. capstone.mobile.models.Animal.setId(I)V: Line 26
   * Goal 12. [METHOD] capstone.mobile.models.Animal.<init>()V
   * Goal 13. [METHOD] capstone.mobile.models.Animal.getId()I
   * Goal 14. [METHOD] capstone.mobile.models.Animal.setId(I)V
   * Goal 15. [METHODNOEX] capstone.mobile.models.Animal.<init>()V
   * Goal 16. [METHODNOEX] capstone.mobile.models.Animal.getId()I
   * Goal 17. [METHODNOEX] capstone.mobile.models.Animal.setId(I)V
   * Goal 18. Weak Mutation 3: capstone.mobile.models.Animal.getId()I:21 - InsertUnaryOp Negation
   * Goal 19. Weak Mutation 4: capstone.mobile.models.Animal.getId()I:21 - InsertUnaryOp +1
   * Goal 20. Weak Mutation 5: capstone.mobile.models.Animal.getId()I:21 - InsertUnaryOp -1
   * Goal 21. Weak Mutation 6: capstone.mobile.models.Animal.setId(I)V:25 - InsertUnaryOp Negation of id
   * Goal 22. Weak Mutation 7: capstone.mobile.models.Animal.setId(I)V:25 - InsertUnaryOp IINC 1 id
   * Goal 23. Weak Mutation 8: capstone.mobile.models.Animal.setId(I)V:25 - InsertUnaryOp IINC -1 id
   */

    @Test(timeout = 4000)
    public void test1() throws Throwable {
        Animal animal0 = new Animal();
        animal0.setId((-1215));
        int int0 = animal0.getId();
        assertEquals((-1215), int0);
    }

    //Test case number: 2
  /*
   * 23 covered goals:
   * Goal 1. capstone.mobile.models.Animal.<init>()V: root-Branch
   * Goal 2. capstone.mobile.models.Animal.getId()I: root-Branch
   * Goal 3. capstone.mobile.models.Animal.setId(I)V: root-Branch
   * Goal 4. Branch capstone.mobile.models.Animal.getId()I: root-Branch in context: capstone.mobile.models.Animal:getId()I
   * Goal 5. Branch capstone.mobile.models.Animal.<init>()V: root-Branch in context: capstone.mobile.models.Animal:<init>()V
   * Goal 6. Branch capstone.mobile.models.Animal.setId(I)V: root-Branch in context: capstone.mobile.models.Animal:setId(I)V
   * Goal 7. [Output]: capstone.mobile.models.Animal.getId()I:Positive
   * Goal 8. capstone.mobile.models.Animal.<init>()V: Line 13
   * Goal 9. capstone.mobile.models.Animal.getId()I: Line 21
   * Goal 10. capstone.mobile.models.Animal.setId(I)V: Line 25
   * Goal 11. capstone.mobile.models.Animal.setId(I)V: Line 26
   * Goal 12. [METHOD] capstone.mobile.models.Animal.<init>()V
   * Goal 13. [METHOD] capstone.mobile.models.Animal.getId()I
   * Goal 14. [METHOD] capstone.mobile.models.Animal.setId(I)V
   * Goal 15. [METHODNOEX] capstone.mobile.models.Animal.<init>()V
   * Goal 16. [METHODNOEX] capstone.mobile.models.Animal.getId()I
   * Goal 17. [METHODNOEX] capstone.mobile.models.Animal.setId(I)V
   * Goal 18. Weak Mutation 3: capstone.mobile.models.Animal.getId()I:21 - InsertUnaryOp Negation
   * Goal 19. Weak Mutation 4: capstone.mobile.models.Animal.getId()I:21 - InsertUnaryOp +1
   * Goal 20. Weak Mutation 5: capstone.mobile.models.Animal.getId()I:21 - InsertUnaryOp -1
   * Goal 21. Weak Mutation 6: capstone.mobile.models.Animal.setId(I)V:25 - InsertUnaryOp Negation of id
   * Goal 22. Weak Mutation 7: capstone.mobile.models.Animal.setId(I)V:25 - InsertUnaryOp IINC 1 id
   * Goal 23. Weak Mutation 8: capstone.mobile.models.Animal.setId(I)V:25 - InsertUnaryOp IINC -1 id
   */

    @Test(timeout = 4000)
    public void test2() throws Throwable {
        Animal animal0 = new Animal();
        animal0.setId(1404);
        int int0 = animal0.getId();
        assertEquals(1404, int0);
    }

    //Test case number: 3
  /*
   * 11 covered goals:
   * Goal 1. capstone.mobile.models.Animal.<init>()V: root-Branch
   * Goal 2. capstone.mobile.models.Animal.getName()Ljava/lang/String;: root-Branch
   * Goal 3. Branch capstone.mobile.models.Animal.<init>()V: root-Branch in context: capstone.mobile.models.Animal:<init>()V
   * Goal 4. Branch capstone.mobile.models.Animal.getName()Ljava/lang/String;: root-Branch in context: capstone.mobile.models.Animal:getName()Ljava/lang/String;
   * Goal 5. [Output]: capstone.mobile.models.Animal.getName()Ljava/lang/String;:Null
   * Goal 6. capstone.mobile.models.Animal.<init>()V: Line 13
   * Goal 7. capstone.mobile.models.Animal.getName()Ljava/lang/String;: Line 29
   * Goal 8. [METHOD] capstone.mobile.models.Animal.<init>()V
   * Goal 9. [METHOD] capstone.mobile.models.Animal.getName()Ljava/lang/String;
   * Goal 10. [METHODNOEX] capstone.mobile.models.Animal.<init>()V
   * Goal 11. [METHODNOEX] capstone.mobile.models.Animal.getName()Ljava/lang/String;
   */

    @Test(timeout = 4000)
    public void test3() throws Throwable {
        Animal animal0 = new Animal();
        String string0 = animal0.getName();
        assertNull(string0);
    }

    //Test case number: 4
  /*
   * 14 covered goals:
   * Goal 1. capstone.mobile.models.Animal.<init>()V: root-Branch
   * Goal 2. capstone.mobile.models.Animal.getId()I: root-Branch
   * Goal 3. Branch capstone.mobile.models.Animal.getId()I: root-Branch in context: capstone.mobile.models.Animal:getId()I
   * Goal 4. Branch capstone.mobile.models.Animal.<init>()V: root-Branch in context: capstone.mobile.models.Animal:<init>()V
   * Goal 5. [Output]: capstone.mobile.models.Animal.getId()I:Zero
   * Goal 6. capstone.mobile.models.Animal.<init>()V: Line 13
   * Goal 7. capstone.mobile.models.Animal.getId()I: Line 21
   * Goal 8. [METHOD] capstone.mobile.models.Animal.<init>()V
   * Goal 9. [METHOD] capstone.mobile.models.Animal.getId()I
   * Goal 10. [METHODNOEX] capstone.mobile.models.Animal.<init>()V
   * Goal 11. [METHODNOEX] capstone.mobile.models.Animal.getId()I
   * Goal 12. Weak Mutation 3: capstone.mobile.models.Animal.getId()I:21 - InsertUnaryOp Negation
   * Goal 13. Weak Mutation 4: capstone.mobile.models.Animal.getId()I:21 - InsertUnaryOp +1
   * Goal 14. Weak Mutation 5: capstone.mobile.models.Animal.getId()I:21 - InsertUnaryOp -1
   */

    @Test(timeout = 4000)
    public void test4() throws Throwable {
        Animal animal0 = new Animal();
        int int0 = animal0.getId();
        assertEquals(0, int0);
    }

    //Test case number: 5
  /*
   * 16 covered goals:
   * Goal 1. capstone.mobile.models.Animal.<init>(ILjava/lang/String;)V: root-Branch
   * Goal 2. capstone.mobile.models.Animal.getName()Ljava/lang/String;: root-Branch
   * Goal 3. Branch capstone.mobile.models.Animal.<init>(ILjava/lang/String;)V: root-Branch in context: capstone.mobile.models.Animal:<init>(ILjava/lang/String;)V
   * Goal 4. Branch capstone.mobile.models.Animal.getName()Ljava/lang/String;: root-Branch in context: capstone.mobile.models.Animal:getName()Ljava/lang/String;
   * Goal 5. [Output]: capstone.mobile.models.Animal.getName()Ljava/lang/String;:NonEmptyString
   * Goal 6. capstone.mobile.models.Animal.<init>(ILjava/lang/String;)V: Line 16
   * Goal 7. capstone.mobile.models.Animal.<init>(ILjava/lang/String;)V: Line 17
   * Goal 8. capstone.mobile.models.Animal.<init>(ILjava/lang/String;)V: Line 18
   * Goal 9. capstone.mobile.models.Animal.getName()Ljava/lang/String;: Line 29
   * Goal 10. [METHOD] capstone.mobile.models.Animal.<init>(ILjava/lang/String;)V
   * Goal 11. [METHOD] capstone.mobile.models.Animal.getName()Ljava/lang/String;
   * Goal 12. [METHODNOEX] capstone.mobile.models.Animal.<init>(ILjava/lang/String;)V
   * Goal 13. [METHODNOEX] capstone.mobile.models.Animal.getName()Ljava/lang/String;
   * Goal 14. Weak Mutation 0: capstone.mobile.models.Animal.<init>(ILjava/lang/String;)V:16 - InsertUnaryOp Negation of id
   * Goal 15. Weak Mutation 1: capstone.mobile.models.Animal.<init>(ILjava/lang/String;)V:16 - InsertUnaryOp IINC 1 id
   * Goal 16. Weak Mutation 2: capstone.mobile.models.Animal.<init>(ILjava/lang/String;)V:16 - InsertUnaryOp IINC -1 id
   */

    @Test(timeout = 4000)
    public void test5() throws Throwable {
        Animal animal0 = new Animal(0, "e'5?:K:n*b5");
        animal0.getName();
        assertEquals(0, animal0.getId());
    }

    //Test case number: 6
  /*
   * 11 covered goals:
   * Goal 1. capstone.mobile.models.Animal.setName(Ljava/lang/String;)V: root-Branch
   * Goal 2. capstone.mobile.models.Animal.<init>()V: root-Branch
   * Goal 3. Branch capstone.mobile.models.Animal.<init>()V: root-Branch in context: capstone.mobile.models.Animal:<init>()V
   * Goal 4. Branch capstone.mobile.models.Animal.setName(Ljava/lang/String;)V: root-Branch in context: capstone.mobile.models.Animal:setName(Ljava/lang/String;)V
   * Goal 5. capstone.mobile.models.Animal.<init>()V: Line 13
   * Goal 6. capstone.mobile.models.Animal.setName(Ljava/lang/String;)V: Line 33
   * Goal 7. capstone.mobile.models.Animal.setName(Ljava/lang/String;)V: Line 34
   * Goal 8. [METHOD] capstone.mobile.models.Animal.<init>()V
   * Goal 9. [METHOD] capstone.mobile.models.Animal.setName(Ljava/lang/String;)V
   * Goal 10. [METHODNOEX] capstone.mobile.models.Animal.<init>()V
   * Goal 11. [METHODNOEX] capstone.mobile.models.Animal.setName(Ljava/lang/String;)V
   */

    @Test(timeout = 4000)
    public void test6() throws Throwable {
        Animal animal0 = new Animal();
        animal0.setName("");
        assertEquals("", animal0.getName());
    }
}
