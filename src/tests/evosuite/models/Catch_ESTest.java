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
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class Catch_ESTest {

    //Test case number: 0
  /*
   * 33 covered goals:
   * Goal 1. capstone.mobile.models.Catch.setTrapId(I)V: root-Branch
   * Goal 2. capstone.mobile.models.Catch.<init>(II)V: root-Branch
   * Goal 3. capstone.mobile.models.Catch.getTrapId()I: root-Branch
   * Goal 4. Branch capstone.mobile.models.Catch.setTrapId(I)V: root-Branch in context: capstone.mobile.models.Catch:setTrapId(I)V
   * Goal 5. Branch capstone.mobile.models.Catch.getTrapId()I: root-Branch in context: capstone.mobile.models.Catch:getTrapId()I
   * Goal 6. Branch capstone.mobile.models.Catch.<init>(II)V: root-Branch in context: capstone.mobile.models.Catch:<init>(II)V
   * Goal 7. [Output]: capstone.mobile.models.Catch.getTrapId()I:Positive
   * Goal 8. capstone.mobile.models.Catch.<init>(II)V: Line 21
   * Goal 9. capstone.mobile.models.Catch.<init>(II)V: Line 22
   * Goal 10. capstone.mobile.models.Catch.<init>(II)V: Line 23
   * Goal 11. capstone.mobile.models.Catch.<init>(II)V: Line 24
   * Goal 12. capstone.mobile.models.Catch.getTrapId()I: Line 40
   * Goal 13. capstone.mobile.models.Catch.setTrapId(I)V: Line 44
   * Goal 14. capstone.mobile.models.Catch.setTrapId(I)V: Line 45
   * Goal 15. [METHOD] capstone.mobile.models.Catch.<init>(II)V
   * Goal 16. [METHOD] capstone.mobile.models.Catch.getTrapId()I
   * Goal 17. [METHOD] capstone.mobile.models.Catch.setTrapId(I)V
   * Goal 18. [METHODNOEX] capstone.mobile.models.Catch.<init>(II)V
   * Goal 19. [METHODNOEX] capstone.mobile.models.Catch.getTrapId()I
   * Goal 20. [METHODNOEX] capstone.mobile.models.Catch.setTrapId(I)V
   * Goal 21. Weak Mutation 1: capstone.mobile.models.Catch.<init>(II)V:21 - InsertUnaryOp Negation of trapId
   * Goal 22. Weak Mutation 2: capstone.mobile.models.Catch.<init>(II)V:21 - InsertUnaryOp IINC 1 trapId
   * Goal 23. Weak Mutation 3: capstone.mobile.models.Catch.<init>(II)V:21 - InsertUnaryOp IINC -1 trapId
   * Goal 24. Weak Mutation 5: capstone.mobile.models.Catch.<init>(II)V:22 - InsertUnaryOp Negation of animalId
   * Goal 25. Weak Mutation 6: capstone.mobile.models.Catch.<init>(II)V:22 - InsertUnaryOp IINC 1 animalId
   * Goal 26. Weak Mutation 7: capstone.mobile.models.Catch.<init>(II)V:22 - InsertUnaryOp IINC -1 animalId
   * Goal 27. Weak Mutation 8: capstone.mobile.models.Catch.<init>(II)V:23 - ReplaceComparisonOperator == -> !=
   * Goal 28. Weak Mutation 18: capstone.mobile.models.Catch.getTrapId()I:40 - InsertUnaryOp Negation
   * Goal 29. Weak Mutation 19: capstone.mobile.models.Catch.getTrapId()I:40 - InsertUnaryOp +1
   * Goal 30. Weak Mutation 20: capstone.mobile.models.Catch.getTrapId()I:40 - InsertUnaryOp -1
   * Goal 31. Weak Mutation 21: capstone.mobile.models.Catch.setTrapId(I)V:44 - InsertUnaryOp Negation of trapId
   * Goal 32. Weak Mutation 22: capstone.mobile.models.Catch.setTrapId(I)V:44 - InsertUnaryOp IINC 1 trapId
   * Goal 33. Weak Mutation 23: capstone.mobile.models.Catch.setTrapId(I)V:44 - InsertUnaryOp IINC -1 trapId
   */

    @Test(timeout = 4000)
    public void test0() throws Throwable {
        Catch catch0 = new Catch(0, 0);
        catch0.setTrapId(1588);
        int int0 = catch0.getTrapId();
        assertEquals(1588, int0);
    }

    //Test case number: 1
  /*
   * 33 covered goals:
   * Goal 1. capstone.mobile.models.Catch.setTrapId(I)V: root-Branch
   * Goal 2. capstone.mobile.models.Catch.<init>(II)V: root-Branch
   * Goal 3. capstone.mobile.models.Catch.getTrapId()I: root-Branch
   * Goal 4. Branch capstone.mobile.models.Catch.setTrapId(I)V: root-Branch in context: capstone.mobile.models.Catch:setTrapId(I)V
   * Goal 5. Branch capstone.mobile.models.Catch.getTrapId()I: root-Branch in context: capstone.mobile.models.Catch:getTrapId()I
   * Goal 6. Branch capstone.mobile.models.Catch.<init>(II)V: root-Branch in context: capstone.mobile.models.Catch:<init>(II)V
   * Goal 7. [Output]: capstone.mobile.models.Catch.getTrapId()I:Negative
   * Goal 8. capstone.mobile.models.Catch.<init>(II)V: Line 21
   * Goal 9. capstone.mobile.models.Catch.<init>(II)V: Line 22
   * Goal 10. capstone.mobile.models.Catch.<init>(II)V: Line 23
   * Goal 11. capstone.mobile.models.Catch.<init>(II)V: Line 24
   * Goal 12. capstone.mobile.models.Catch.getTrapId()I: Line 40
   * Goal 13. capstone.mobile.models.Catch.setTrapId(I)V: Line 44
   * Goal 14. capstone.mobile.models.Catch.setTrapId(I)V: Line 45
   * Goal 15. [METHOD] capstone.mobile.models.Catch.<init>(II)V
   * Goal 16. [METHOD] capstone.mobile.models.Catch.getTrapId()I
   * Goal 17. [METHOD] capstone.mobile.models.Catch.setTrapId(I)V
   * Goal 18. [METHODNOEX] capstone.mobile.models.Catch.<init>(II)V
   * Goal 19. [METHODNOEX] capstone.mobile.models.Catch.getTrapId()I
   * Goal 20. [METHODNOEX] capstone.mobile.models.Catch.setTrapId(I)V
   * Goal 21. Weak Mutation 1: capstone.mobile.models.Catch.<init>(II)V:21 - InsertUnaryOp Negation of trapId
   * Goal 22. Weak Mutation 2: capstone.mobile.models.Catch.<init>(II)V:21 - InsertUnaryOp IINC 1 trapId
   * Goal 23. Weak Mutation 3: capstone.mobile.models.Catch.<init>(II)V:21 - InsertUnaryOp IINC -1 trapId
   * Goal 24. Weak Mutation 5: capstone.mobile.models.Catch.<init>(II)V:22 - InsertUnaryOp Negation of animalId
   * Goal 25. Weak Mutation 6: capstone.mobile.models.Catch.<init>(II)V:22 - InsertUnaryOp IINC 1 animalId
   * Goal 26. Weak Mutation 7: capstone.mobile.models.Catch.<init>(II)V:22 - InsertUnaryOp IINC -1 animalId
   * Goal 27. Weak Mutation 8: capstone.mobile.models.Catch.<init>(II)V:23 - ReplaceComparisonOperator == -> !=
   * Goal 28. Weak Mutation 18: capstone.mobile.models.Catch.getTrapId()I:40 - InsertUnaryOp Negation
   * Goal 29. Weak Mutation 19: capstone.mobile.models.Catch.getTrapId()I:40 - InsertUnaryOp +1
   * Goal 30. Weak Mutation 20: capstone.mobile.models.Catch.getTrapId()I:40 - InsertUnaryOp -1
   * Goal 31. Weak Mutation 21: capstone.mobile.models.Catch.setTrapId(I)V:44 - InsertUnaryOp Negation of trapId
   * Goal 32. Weak Mutation 22: capstone.mobile.models.Catch.setTrapId(I)V:44 - InsertUnaryOp IINC 1 trapId
   * Goal 33. Weak Mutation 23: capstone.mobile.models.Catch.setTrapId(I)V:44 - InsertUnaryOp IINC -1 trapId
   */

    @Test(timeout = 4000)
    public void test1() throws Throwable {
        Catch catch0 = new Catch(0, 0);
        assertEquals(0, catch0.getTrapId());

        catch0.setTrapId((-1));
        int int0 = catch0.getTrapId();
        assertEquals((-1), int0);
    }

    //Test case number: 2
  /*
   * 29 covered goals:
   * Goal 1. capstone.mobile.models.Catch.getTime()J: root-Branch
   * Goal 2. capstone.mobile.models.Catch.<init>(II)V: root-Branch
   * Goal 3. capstone.mobile.models.Catch.setTime(J)V: root-Branch
   * Goal 4. Branch capstone.mobile.models.Catch.<init>(II)V: root-Branch in context: capstone.mobile.models.Catch:<init>(II)V
   * Goal 5. Branch capstone.mobile.models.Catch.getTime()J: root-Branch in context: capstone.mobile.models.Catch:getTime()J
   * Goal 6. Branch capstone.mobile.models.Catch.setTime(J)V: root-Branch in context: capstone.mobile.models.Catch:setTime(J)V
   * Goal 7. [Output]: capstone.mobile.models.Catch.getTime()J:Zero
   * Goal 8. capstone.mobile.models.Catch.<init>(II)V: Line 21
   * Goal 9. capstone.mobile.models.Catch.<init>(II)V: Line 22
   * Goal 10. capstone.mobile.models.Catch.<init>(II)V: Line 23
   * Goal 11. capstone.mobile.models.Catch.<init>(II)V: Line 24
   * Goal 12. capstone.mobile.models.Catch.getTime()J: Line 56
   * Goal 13. capstone.mobile.models.Catch.setTime(J)V: Line 60
   * Goal 14. capstone.mobile.models.Catch.setTime(J)V: Line 61
   * Goal 15. [METHOD] capstone.mobile.models.Catch.<init>(II)V
   * Goal 16. [METHOD] capstone.mobile.models.Catch.getTime()J
   * Goal 17. [METHOD] capstone.mobile.models.Catch.setTime(J)V
   * Goal 18. [METHODNOEX] capstone.mobile.models.Catch.<init>(II)V
   * Goal 19. [METHODNOEX] capstone.mobile.models.Catch.getTime()J
   * Goal 20. [METHODNOEX] capstone.mobile.models.Catch.setTime(J)V
   * Goal 21. Weak Mutation 1: capstone.mobile.models.Catch.<init>(II)V:21 - InsertUnaryOp Negation of trapId
   * Goal 22. Weak Mutation 2: capstone.mobile.models.Catch.<init>(II)V:21 - InsertUnaryOp IINC 1 trapId
   * Goal 23. Weak Mutation 3: capstone.mobile.models.Catch.<init>(II)V:21 - InsertUnaryOp IINC -1 trapId
   * Goal 24. Weak Mutation 5: capstone.mobile.models.Catch.<init>(II)V:22 - InsertUnaryOp Negation of animalId
   * Goal 25. Weak Mutation 6: capstone.mobile.models.Catch.<init>(II)V:22 - InsertUnaryOp IINC 1 animalId
   * Goal 26. Weak Mutation 7: capstone.mobile.models.Catch.<init>(II)V:22 - InsertUnaryOp IINC -1 animalId
   * Goal 27. Weak Mutation 8: capstone.mobile.models.Catch.<init>(II)V:23 - ReplaceComparisonOperator == -> !=
   * Goal 28. Weak Mutation 30: capstone.mobile.models.Catch.getTime()J:56 - InsertUnaryOp Negation
   * Goal 29. Weak Mutation 31: capstone.mobile.models.Catch.setTime(J)V:60 - InsertUnaryOp Negation of time
   */

    @Test(timeout = 4000)
    public void test2() throws Throwable {
        Catch catch0 = new Catch(0, 0);

        catch0.setTime(0);
        catch0.getTime();
        assertEquals(0, catch0.getTrapId());
    }

    //Test case number: 3
  /*
   * 29 covered goals:
   * Goal 1. capstone.mobile.models.Catch.<init>(IIJ)V: root-Branch
   * Goal 2. capstone.mobile.models.Catch.getTime()J: root-Branch
   * Goal 3. capstone.mobile.models.Catch.setTime(J)V: root-Branch
   * Goal 4. Branch capstone.mobile.models.Catch.<init>(IIJ)V: root-Branch in context: capstone.mobile.models.Catch:<init>(IIJ)V
   * Goal 5. Branch capstone.mobile.models.Catch.getTime()J: root-Branch in context: capstone.mobile.models.Catch:getTime()J
   * Goal 6. Branch capstone.mobile.models.Catch.setTime(J)V: root-Branch in context: capstone.mobile.models.Catch:setTime(J)V
   * Goal 7. [Output]: capstone.mobile.models.Catch.getTime()J:Negative
   * Goal 8. capstone.mobile.models.Catch.<init>(IIJ)V: Line 34
   * Goal 9. capstone.mobile.models.Catch.<init>(IIJ)V: Line 35
   * Goal 10. capstone.mobile.models.Catch.<init>(IIJ)V: Line 36
   * Goal 11. capstone.mobile.models.Catch.<init>(IIJ)V: Line 37
   * Goal 12. capstone.mobile.models.Catch.getTime()J: Line 56
   * Goal 13. capstone.mobile.models.Catch.setTime(J)V: Line 60
   * Goal 14. capstone.mobile.models.Catch.setTime(J)V: Line 61
   * Goal 15. [METHOD] capstone.mobile.models.Catch.<init>(IIJ)V
   * Goal 16. [METHOD] capstone.mobile.models.Catch.getTime()J
   * Goal 17. [METHOD] capstone.mobile.models.Catch.setTime(J)V
   * Goal 18. [METHODNOEX] capstone.mobile.models.Catch.<init>(IIJ)V
   * Goal 19. [METHODNOEX] capstone.mobile.models.Catch.getTime()J
   * Goal 20. [METHODNOEX] capstone.mobile.models.Catch.setTime(J)V
   * Goal 21. Weak Mutation 10: capstone.mobile.models.Catch.<init>(IIJ)V:34 - InsertUnaryOp Negation of trapId
   * Goal 22. Weak Mutation 11: capstone.mobile.models.Catch.<init>(IIJ)V:34 - InsertUnaryOp IINC 1 trapId
   * Goal 23. Weak Mutation 12: capstone.mobile.models.Catch.<init>(IIJ)V:34 - InsertUnaryOp IINC -1 trapId
   * Goal 24. Weak Mutation 14: capstone.mobile.models.Catch.<init>(IIJ)V:35 - InsertUnaryOp Negation of animalId
   * Goal 25. Weak Mutation 15: capstone.mobile.models.Catch.<init>(IIJ)V:35 - InsertUnaryOp IINC 1 animalId
   * Goal 26. Weak Mutation 16: capstone.mobile.models.Catch.<init>(IIJ)V:35 - InsertUnaryOp IINC -1 animalId
   * Goal 27. Weak Mutation 17: capstone.mobile.models.Catch.<init>(IIJ)V:36 - InsertUnaryOp Negation of time
   * Goal 28. Weak Mutation 30: capstone.mobile.models.Catch.getTime()J:56 - InsertUnaryOp Negation
   * Goal 29. Weak Mutation 31: capstone.mobile.models.Catch.setTime(J)V:60 - InsertUnaryOp Negation of time
   */

    @Test(timeout = 4000)
    public void test3() throws Throwable {
        Catch catch0 = new Catch(0, 0, 0);
        catch0.setTime((-1269L));
        long long0 = catch0.getTime();
        assertEquals((-1269L), long0);
    }

    //Test case number: 4
  /*
   * 26 covered goals:
   * Goal 1. capstone.mobile.models.Catch.<init>(II)V: root-Branch
   * Goal 2. capstone.mobile.models.Catch.getAnimalId()I: root-Branch
   * Goal 3. Branch capstone.mobile.models.Catch.getAnimalId()I: root-Branch in context: capstone.mobile.models.Catch:getAnimalId()I
   * Goal 4. Branch capstone.mobile.models.Catch.<init>(II)V: root-Branch in context: capstone.mobile.models.Catch:<init>(II)V
   * Goal 5. [Output]: capstone.mobile.models.Catch.getAnimalId()I:Positive
   * Goal 6. capstone.mobile.models.Catch.<init>(II)V: Line 21
   * Goal 7. capstone.mobile.models.Catch.<init>(II)V: Line 22
   * Goal 8. capstone.mobile.models.Catch.<init>(II)V: Line 23
   * Goal 9. capstone.mobile.models.Catch.<init>(II)V: Line 24
   * Goal 10. capstone.mobile.models.Catch.getAnimalId()I: Line 48
   * Goal 11. [METHOD] capstone.mobile.models.Catch.<init>(II)V
   * Goal 12. [METHOD] capstone.mobile.models.Catch.getAnimalId()I
   * Goal 13. [METHODNOEX] capstone.mobile.models.Catch.<init>(II)V
   * Goal 14. [METHODNOEX] capstone.mobile.models.Catch.getAnimalId()I
   * Goal 15. Weak Mutation 0: capstone.mobile.models.Catch.<init>(II)V:21 - ReplaceVariable trapId -> animalId
   * Goal 16. Weak Mutation 1: capstone.mobile.models.Catch.<init>(II)V:21 - InsertUnaryOp Negation of trapId
   * Goal 17. Weak Mutation 2: capstone.mobile.models.Catch.<init>(II)V:21 - InsertUnaryOp IINC 1 trapId
   * Goal 18. Weak Mutation 3: capstone.mobile.models.Catch.<init>(II)V:21 - InsertUnaryOp IINC -1 trapId
   * Goal 19. Weak Mutation 4: capstone.mobile.models.Catch.<init>(II)V:22 - ReplaceVariable animalId -> trapId
   * Goal 20. Weak Mutation 5: capstone.mobile.models.Catch.<init>(II)V:22 - InsertUnaryOp Negation of animalId
   * Goal 21. Weak Mutation 6: capstone.mobile.models.Catch.<init>(II)V:22 - InsertUnaryOp IINC 1 animalId
   * Goal 22. Weak Mutation 7: capstone.mobile.models.Catch.<init>(II)V:22 - InsertUnaryOp IINC -1 animalId
   * Goal 23. Weak Mutation 8: capstone.mobile.models.Catch.<init>(II)V:23 - ReplaceComparisonOperator == -> !=
   * Goal 24. Weak Mutation 24: capstone.mobile.models.Catch.getAnimalId()I:48 - InsertUnaryOp Negation
   * Goal 25. Weak Mutation 25: capstone.mobile.models.Catch.getAnimalId()I:48 - InsertUnaryOp +1
   * Goal 26. Weak Mutation 26: capstone.mobile.models.Catch.getAnimalId()I:48 - InsertUnaryOp -1
   */

    @Test(timeout = 4000)
    public void test4() throws Throwable {
        Catch catch0 = new Catch(0, 1);
        int   int0   = catch0.getAnimalId();
        assertEquals(0, catch0.getTrapId());
        assertEquals(1, int0);
    }

    //Test case number: 5
  /*
   * 26 covered goals:
   * Goal 1. capstone.mobile.models.Catch.<init>(IIJ)V: root-Branch
   * Goal 2. capstone.mobile.models.Catch.getAnimalId()I: root-Branch
   * Goal 3. Branch capstone.mobile.models.Catch.getAnimalId()I: root-Branch in context: capstone.mobile.models.Catch:getAnimalId()I
   * Goal 4. Branch capstone.mobile.models.Catch.<init>(IIJ)V: root-Branch in context: capstone.mobile.models.Catch:<init>(IIJ)V
   * Goal 5. [Output]: capstone.mobile.models.Catch.getAnimalId()I:Negative
   * Goal 6. capstone.mobile.models.Catch.<init>(IIJ)V: Line 34
   * Goal 7. capstone.mobile.models.Catch.<init>(IIJ)V: Line 35
   * Goal 8. capstone.mobile.models.Catch.<init>(IIJ)V: Line 36
   * Goal 9. capstone.mobile.models.Catch.<init>(IIJ)V: Line 37
   * Goal 10. capstone.mobile.models.Catch.getAnimalId()I: Line 48
   * Goal 11. [METHOD] capstone.mobile.models.Catch.<init>(IIJ)V
   * Goal 12. [METHOD] capstone.mobile.models.Catch.getAnimalId()I
   * Goal 13. [METHODNOEX] capstone.mobile.models.Catch.<init>(IIJ)V
   * Goal 14. [METHODNOEX] capstone.mobile.models.Catch.getAnimalId()I
   * Goal 15. Weak Mutation 9: capstone.mobile.models.Catch.<init>(IIJ)V:34 - ReplaceVariable trapId -> animalId
   * Goal 16. Weak Mutation 10: capstone.mobile.models.Catch.<init>(IIJ)V:34 - InsertUnaryOp Negation of trapId
   * Goal 17. Weak Mutation 11: capstone.mobile.models.Catch.<init>(IIJ)V:34 - InsertUnaryOp IINC 1 trapId
   * Goal 18. Weak Mutation 12: capstone.mobile.models.Catch.<init>(IIJ)V:34 - InsertUnaryOp IINC -1 trapId
   * Goal 19. Weak Mutation 13: capstone.mobile.models.Catch.<init>(IIJ)V:35 - ReplaceVariable animalId -> trapId
   * Goal 20. Weak Mutation 14: capstone.mobile.models.Catch.<init>(IIJ)V:35 - InsertUnaryOp Negation of animalId
   * Goal 21. Weak Mutation 15: capstone.mobile.models.Catch.<init>(IIJ)V:35 - InsertUnaryOp IINC 1 animalId
   * Goal 22. Weak Mutation 16: capstone.mobile.models.Catch.<init>(IIJ)V:35 - InsertUnaryOp IINC -1 animalId
   * Goal 23. Weak Mutation 17: capstone.mobile.models.Catch.<init>(IIJ)V:36 - InsertUnaryOp Negation of time
   * Goal 24. Weak Mutation 24: capstone.mobile.models.Catch.getAnimalId()I:48 - InsertUnaryOp Negation
   * Goal 25. Weak Mutation 25: capstone.mobile.models.Catch.getAnimalId()I:48 - InsertUnaryOp +1
   * Goal 26. Weak Mutation 26: capstone.mobile.models.Catch.getAnimalId()I:48 - InsertUnaryOp -1
   */

    @Test(timeout = 4000)
    public void test5() throws Throwable {
        Catch catch0 = new Catch(1588, (-1), 1L);
        int   int0   = catch0.getAnimalId();
        assertEquals(1L, catch0.getTime());
        assertEquals(1588, catch0.getTrapId());
        assertEquals((-1), int0);
    }

    //Test case number: 6
  /*
   * 24 covered goals:
   * Goal 1. capstone.mobile.models.Catch.<init>(II)V: root-Branch
   * Goal 2. capstone.mobile.models.Catch.getTrapId()I: root-Branch
   * Goal 3. Branch capstone.mobile.models.Catch.getTrapId()I: root-Branch in context: capstone.mobile.models.Catch:getTrapId()I
   * Goal 4. Branch capstone.mobile.models.Catch.<init>(II)V: root-Branch in context: capstone.mobile.models.Catch:<init>(II)V
   * Goal 5. [Output]: capstone.mobile.models.Catch.getTrapId()I:Zero
   * Goal 6. capstone.mobile.models.Catch.<init>(II)V: Line 21
   * Goal 7. capstone.mobile.models.Catch.<init>(II)V: Line 22
   * Goal 8. capstone.mobile.models.Catch.<init>(II)V: Line 23
   * Goal 9. capstone.mobile.models.Catch.<init>(II)V: Line 24
   * Goal 10. capstone.mobile.models.Catch.getTrapId()I: Line 40
   * Goal 11. [METHOD] capstone.mobile.models.Catch.<init>(II)V
   * Goal 12. [METHOD] capstone.mobile.models.Catch.getTrapId()I
   * Goal 13. [METHODNOEX] capstone.mobile.models.Catch.<init>(II)V
   * Goal 14. [METHODNOEX] capstone.mobile.models.Catch.getTrapId()I
   * Goal 15. Weak Mutation 1: capstone.mobile.models.Catch.<init>(II)V:21 - InsertUnaryOp Negation of trapId
   * Goal 16. Weak Mutation 2: capstone.mobile.models.Catch.<init>(II)V:21 - InsertUnaryOp IINC 1 trapId
   * Goal 17. Weak Mutation 3: capstone.mobile.models.Catch.<init>(II)V:21 - InsertUnaryOp IINC -1 trapId
   * Goal 18. Weak Mutation 5: capstone.mobile.models.Catch.<init>(II)V:22 - InsertUnaryOp Negation of animalId
   * Goal 19. Weak Mutation 6: capstone.mobile.models.Catch.<init>(II)V:22 - InsertUnaryOp IINC 1 animalId
   * Goal 20. Weak Mutation 7: capstone.mobile.models.Catch.<init>(II)V:22 - InsertUnaryOp IINC -1 animalId
   * Goal 21. Weak Mutation 8: capstone.mobile.models.Catch.<init>(II)V:23 - ReplaceComparisonOperator == -> !=
   * Goal 22. Weak Mutation 18: capstone.mobile.models.Catch.getTrapId()I:40 - InsertUnaryOp Negation
   * Goal 23. Weak Mutation 19: capstone.mobile.models.Catch.getTrapId()I:40 - InsertUnaryOp +1
   * Goal 24. Weak Mutation 20: capstone.mobile.models.Catch.getTrapId()I:40 - InsertUnaryOp -1
   */

    @Test(timeout = 4000)
    public void test6() throws Throwable {
        Catch catch0 = new Catch(0, 0);
        int   int0   = catch0.getTrapId();
        assertEquals(0, catch0.getAnimalId());
        assertEquals(0, int0);
    }

    //Test case number: 7
  /*
   * 24 covered goals:
   * Goal 1. capstone.mobile.models.Catch.<init>(II)V: root-Branch
   * Goal 2. capstone.mobile.models.Catch.getAnimalId()I: root-Branch
   * Goal 3. Branch capstone.mobile.models.Catch.getAnimalId()I: root-Branch in context: capstone.mobile.models.Catch:getAnimalId()I
   * Goal 4. Branch capstone.mobile.models.Catch.<init>(II)V: root-Branch in context: capstone.mobile.models.Catch:<init>(II)V
   * Goal 5. [Output]: capstone.mobile.models.Catch.getAnimalId()I:Zero
   * Goal 6. capstone.mobile.models.Catch.<init>(II)V: Line 21
   * Goal 7. capstone.mobile.models.Catch.<init>(II)V: Line 22
   * Goal 8. capstone.mobile.models.Catch.<init>(II)V: Line 23
   * Goal 9. capstone.mobile.models.Catch.<init>(II)V: Line 24
   * Goal 10. capstone.mobile.models.Catch.getAnimalId()I: Line 48
   * Goal 11. [METHOD] capstone.mobile.models.Catch.<init>(II)V
   * Goal 12. [METHOD] capstone.mobile.models.Catch.getAnimalId()I
   * Goal 13. [METHODNOEX] capstone.mobile.models.Catch.<init>(II)V
   * Goal 14. [METHODNOEX] capstone.mobile.models.Catch.getAnimalId()I
   * Goal 15. Weak Mutation 1: capstone.mobile.models.Catch.<init>(II)V:21 - InsertUnaryOp Negation of trapId
   * Goal 16. Weak Mutation 2: capstone.mobile.models.Catch.<init>(II)V:21 - InsertUnaryOp IINC 1 trapId
   * Goal 17. Weak Mutation 3: capstone.mobile.models.Catch.<init>(II)V:21 - InsertUnaryOp IINC -1 trapId
   * Goal 18. Weak Mutation 5: capstone.mobile.models.Catch.<init>(II)V:22 - InsertUnaryOp Negation of animalId
   * Goal 19. Weak Mutation 6: capstone.mobile.models.Catch.<init>(II)V:22 - InsertUnaryOp IINC 1 animalId
   * Goal 20. Weak Mutation 7: capstone.mobile.models.Catch.<init>(II)V:22 - InsertUnaryOp IINC -1 animalId
   * Goal 21. Weak Mutation 8: capstone.mobile.models.Catch.<init>(II)V:23 - ReplaceComparisonOperator == -> !=
   * Goal 22. Weak Mutation 24: capstone.mobile.models.Catch.getAnimalId()I:48 - InsertUnaryOp Negation
   * Goal 23. Weak Mutation 25: capstone.mobile.models.Catch.getAnimalId()I:48 - InsertUnaryOp +1
   * Goal 24. Weak Mutation 26: capstone.mobile.models.Catch.getAnimalId()I:48 - InsertUnaryOp -1
   */

    @Test(timeout = 4000)
    public void test7() throws Throwable {
        Catch catch0 = new Catch(0, 0);
        int   int0   = catch0.getAnimalId();
        assertEquals(0, catch0.getTrapId());
        assertEquals(0, int0);
    }

    //Test case number: 8
  /*
   * 24 covered goals:
   * Goal 1. capstone.mobile.models.Catch.setAnimalId(I)V: root-Branch
   * Goal 2. capstone.mobile.models.Catch.<init>(II)V: root-Branch
   * Goal 3. Branch capstone.mobile.models.Catch.<init>(II)V: root-Branch in context: capstone.mobile.models.Catch:<init>(II)V
   * Goal 4. Branch capstone.mobile.models.Catch.setAnimalId(I)V: root-Branch in context: capstone.mobile.models.Catch:setAnimalId(I)V
   * Goal 5. capstone.mobile.models.Catch.<init>(II)V: Line 21
   * Goal 6. capstone.mobile.models.Catch.<init>(II)V: Line 22
   * Goal 7. capstone.mobile.models.Catch.<init>(II)V: Line 23
   * Goal 8. capstone.mobile.models.Catch.<init>(II)V: Line 24
   * Goal 9. capstone.mobile.models.Catch.setAnimalId(I)V: Line 52
   * Goal 10. capstone.mobile.models.Catch.setAnimalId(I)V: Line 53
   * Goal 11. [METHOD] capstone.mobile.models.Catch.<init>(II)V
   * Goal 12. [METHOD] capstone.mobile.models.Catch.setAnimalId(I)V
   * Goal 13. [METHODNOEX] capstone.mobile.models.Catch.<init>(II)V
   * Goal 14. [METHODNOEX] capstone.mobile.models.Catch.setAnimalId(I)V
   * Goal 15. Weak Mutation 1: capstone.mobile.models.Catch.<init>(II)V:21 - InsertUnaryOp Negation of trapId
   * Goal 16. Weak Mutation 2: capstone.mobile.models.Catch.<init>(II)V:21 - InsertUnaryOp IINC 1 trapId
   * Goal 17. Weak Mutation 3: capstone.mobile.models.Catch.<init>(II)V:21 - InsertUnaryOp IINC -1 trapId
   * Goal 18. Weak Mutation 5: capstone.mobile.models.Catch.<init>(II)V:22 - InsertUnaryOp Negation of animalId
   * Goal 19. Weak Mutation 6: capstone.mobile.models.Catch.<init>(II)V:22 - InsertUnaryOp IINC 1 animalId
   * Goal 20. Weak Mutation 7: capstone.mobile.models.Catch.<init>(II)V:22 - InsertUnaryOp IINC -1 animalId
   * Goal 21. Weak Mutation 8: capstone.mobile.models.Catch.<init>(II)V:23 - ReplaceComparisonOperator == -> !=
   * Goal 22. Weak Mutation 27: capstone.mobile.models.Catch.setAnimalId(I)V:52 - InsertUnaryOp Negation of animalId
   * Goal 23. Weak Mutation 28: capstone.mobile.models.Catch.setAnimalId(I)V:52 - InsertUnaryOp IINC 1 animalId
   * Goal 24. Weak Mutation 29: capstone.mobile.models.Catch.setAnimalId(I)V:52 - InsertUnaryOp IINC -1 animalId
   */

    @Test(timeout = 4000)
    public void test8() throws Throwable {
        Catch catch0 = new Catch(0, 0);
        catch0.setAnimalId(1588);
        assertEquals(1588, catch0.getAnimalId());
    }

    //Test case number: 9
  /*
   * 22 covered goals:
   * Goal 1. capstone.mobile.models.Catch.getTime()J: root-Branch
   * Goal 2. capstone.mobile.models.Catch.<init>(II)V: root-Branch
   * Goal 3. Branch capstone.mobile.models.Catch.<init>(II)V: root-Branch in context: capstone.mobile.models.Catch:<init>(II)V
   * Goal 4. Branch capstone.mobile.models.Catch.getTime()J: root-Branch in context: capstone.mobile.models.Catch:getTime()J
   * Goal 5. [Output]: capstone.mobile.models.Catch.getTime()J:Positive
   * Goal 6. capstone.mobile.models.Catch.<init>(II)V: Line 21
   * Goal 7. capstone.mobile.models.Catch.<init>(II)V: Line 22
   * Goal 8. capstone.mobile.models.Catch.<init>(II)V: Line 23
   * Goal 9. capstone.mobile.models.Catch.<init>(II)V: Line 24
   * Goal 10. capstone.mobile.models.Catch.getTime()J: Line 56
   * Goal 11. [METHOD] capstone.mobile.models.Catch.<init>(II)V
   * Goal 12. [METHOD] capstone.mobile.models.Catch.getTime()J
   * Goal 13. [METHODNOEX] capstone.mobile.models.Catch.<init>(II)V
   * Goal 14. [METHODNOEX] capstone.mobile.models.Catch.getTime()J
   * Goal 15. Weak Mutation 1: capstone.mobile.models.Catch.<init>(II)V:21 - InsertUnaryOp Negation of trapId
   * Goal 16. Weak Mutation 2: capstone.mobile.models.Catch.<init>(II)V:21 - InsertUnaryOp IINC 1 trapId
   * Goal 17. Weak Mutation 3: capstone.mobile.models.Catch.<init>(II)V:21 - InsertUnaryOp IINC -1 trapId
   * Goal 18. Weak Mutation 5: capstone.mobile.models.Catch.<init>(II)V:22 - InsertUnaryOp Negation of animalId
   * Goal 19. Weak Mutation 6: capstone.mobile.models.Catch.<init>(II)V:22 - InsertUnaryOp IINC 1 animalId
   * Goal 20. Weak Mutation 7: capstone.mobile.models.Catch.<init>(II)V:22 - InsertUnaryOp IINC -1 animalId
   * Goal 21. Weak Mutation 8: capstone.mobile.models.Catch.<init>(II)V:23 - ReplaceComparisonOperator == -> !=
   * Goal 22. Weak Mutation 30: capstone.mobile.models.Catch.getTime()J:56 - InsertUnaryOp Negation
   */

    @Test(timeout = 4000)
    public void test9() throws Throwable {
        Catch catch0 = new Catch(0, 0);
        assertEquals(0, catch0.getAnimalId());
        assertEquals(0, catch0.getTrapId());
    }
}
