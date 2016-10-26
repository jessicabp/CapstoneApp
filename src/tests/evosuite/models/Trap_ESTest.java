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

import capstone.mobile.models.Trap;
import org.junit.Test;

import static org.junit.Assert.*;


public class Trap_ESTest {

    //Test case number: 0
  /*
   * 90 covered goals:
   * Goal 1. capstone.mobile.models.Trap.setMoved(Z)V: root-Branch
   * Goal 2. capstone.mobile.models.Trap.isMoved()Z: root-Branch
   * Goal 3. capstone.mobile.models.Trap.<init>(IIIDDIII)V: I34 Branch 1 IF_ICMPNE L59 - true
   * Goal 4. capstone.mobile.models.Trap.<init>(IIIDDIII)V: I46 Branch 2 IF_ICMPNE L60 - true
   * Goal 5. capstone.mobile.models.Trap.<init>(IIIDDIII)V: I58 Branch 3 IF_ICMPNE L61 - true
   * Goal 6. Branch capstone.mobile.models.Trap.isMoved()Z: root-Branch in context: capstone.mobile.models.Trap:isMoved()Z
   * Goal 7. Branch capstone.mobile.models.Trap.setMoved(Z)V: root-Branch in context: capstone.mobile.models.Trap:setMoved(Z)V
   * Goal 8. Branch capstone.mobile.models.Trap.<init>(IIIDDIII)V: I34 Branch 1 IF_ICMPNE L59 - true in context: capstone.mobile.models.Trap:<init>(IIIDDIII)V
   * Goal 9. Branch capstone.mobile.models.Trap.<init>(IIIDDIII)V: I46 Branch 2 IF_ICMPNE L60 - true in context: capstone.mobile.models.Trap:<init>(IIIDDIII)V
   * Goal 10. Branch capstone.mobile.models.Trap.<init>(IIIDDIII)V: I58 Branch 3 IF_ICMPNE L61 - true in context: capstone.mobile.models.Trap:<init>(IIIDDIII)V
   * Goal 11. [Output]: capstone.mobile.models.Trap.isMoved()Z:True
   * Goal 12. capstone.mobile.models.Trap.<init>(IIIDDIII)V: Line 54
   * Goal 13. capstone.mobile.models.Trap.<init>(IIIDDIII)V: Line 55
   * Goal 14. capstone.mobile.models.Trap.<init>(IIIDDIII)V: Line 56
   * Goal 15. capstone.mobile.models.Trap.<init>(IIIDDIII)V: Line 57
   * Goal 16. capstone.mobile.models.Trap.<init>(IIIDDIII)V: Line 58
   * Goal 17. capstone.mobile.models.Trap.<init>(IIIDDIII)V: Line 59
   * Goal 18. capstone.mobile.models.Trap.<init>(IIIDDIII)V: Line 60
   * Goal 19. capstone.mobile.models.Trap.<init>(IIIDDIII)V: Line 61
   * Goal 20. capstone.mobile.models.Trap.<init>(IIIDDIII)V: Line 62
   * Goal 21. capstone.mobile.models.Trap.isMoved()Z: Line 121
   * Goal 22. capstone.mobile.models.Trap.setMoved(Z)V: Line 125
   * Goal 23. capstone.mobile.models.Trap.setMoved(Z)V: Line 126
   * Goal 24. [METHOD] capstone.mobile.models.Trap.<init>(IIIDDIII)V
   * Goal 25. [METHOD] capstone.mobile.models.Trap.isMoved()Z
   * Goal 26. [METHOD] capstone.mobile.models.Trap.setMoved(Z)V
   * Goal 27. [METHODNOEX] capstone.mobile.models.Trap.<init>(IIIDDIII)V
   * Goal 28. [METHODNOEX] capstone.mobile.models.Trap.isMoved()Z
   * Goal 29. [METHODNOEX] capstone.mobile.models.Trap.setMoved(Z)V
   * Goal 30. Weak Mutation 17: capstone.mobile.models.Trap.<init>(IIIDDIII)V:54 - ReplaceVariable id -> broken
   * Goal 31. Weak Mutation 18: capstone.mobile.models.Trap.<init>(IIIDDIII)V:54 - ReplaceVariable id -> number
   * Goal 32. Weak Mutation 20: capstone.mobile.models.Trap.<init>(IIIDDIII)V:54 - ReplaceVariable id -> side
   * Goal 33. Weak Mutation 21: capstone.mobile.models.Trap.<init>(IIIDDIII)V:54 - ReplaceVariable id -> moved
   * Goal 34. Weak Mutation 22: capstone.mobile.models.Trap.<init>(IIIDDIII)V:54 - InsertUnaryOp Negation of id
   * Goal 35. Weak Mutation 23: capstone.mobile.models.Trap.<init>(IIIDDIII)V:54 - InsertUnaryOp IINC 1 id
   * Goal 36. Weak Mutation 24: capstone.mobile.models.Trap.<init>(IIIDDIII)V:54 - InsertUnaryOp IINC -1 id
   * Goal 37. Weak Mutation 25: capstone.mobile.models.Trap.<init>(IIIDDIII)V:55 - ReplaceVariable lineId -> broken
   * Goal 38. Weak Mutation 26: capstone.mobile.models.Trap.<init>(IIIDDIII)V:55 - ReplaceVariable lineId -> number
   * Goal 39. Weak Mutation 27: capstone.mobile.models.Trap.<init>(IIIDDIII)V:55 - ReplaceVariable lineId -> side
   * Goal 40. Weak Mutation 29: capstone.mobile.models.Trap.<init>(IIIDDIII)V:55 - ReplaceVariable lineId -> moved
   * Goal 41. Weak Mutation 30: capstone.mobile.models.Trap.<init>(IIIDDIII)V:55 - InsertUnaryOp Negation of lineId
   * Goal 42. Weak Mutation 31: capstone.mobile.models.Trap.<init>(IIIDDIII)V:55 - InsertUnaryOp IINC 1 lineId
   * Goal 43. Weak Mutation 32: capstone.mobile.models.Trap.<init>(IIIDDIII)V:55 - InsertUnaryOp IINC -1 lineId
   * Goal 44. Weak Mutation 34: capstone.mobile.models.Trap.<init>(IIIDDIII)V:56 - ReplaceVariable number -> lineId
   * Goal 45. Weak Mutation 35: capstone.mobile.models.Trap.<init>(IIIDDIII)V:56 - ReplaceVariable number -> side
   * Goal 46. Weak Mutation 36: capstone.mobile.models.Trap.<init>(IIIDDIII)V:56 - ReplaceVariable number -> id
   * Goal 47. Weak Mutation 37: capstone.mobile.models.Trap.<init>(IIIDDIII)V:56 - ReplaceVariable number -> moved
   * Goal 48. Weak Mutation 38: capstone.mobile.models.Trap.<init>(IIIDDIII)V:56 - InsertUnaryOp Negation of number
   * Goal 49. Weak Mutation 39: capstone.mobile.models.Trap.<init>(IIIDDIII)V:56 - InsertUnaryOp IINC 1 number
   * Goal 50. Weak Mutation 40: capstone.mobile.models.Trap.<init>(IIIDDIII)V:56 - InsertUnaryOp IINC -1 number
   * Goal 51. Weak Mutation 41: capstone.mobile.models.Trap.<init>(IIIDDIII)V:57 - ReplaceVariable latitude -> longitude
   * Goal 52. Weak Mutation 42: capstone.mobile.models.Trap.<init>(IIIDDIII)V:57 - InsertUnaryOp Negation of latitude
   * Goal 53. Weak Mutation 43: capstone.mobile.models.Trap.<init>(IIIDDIII)V:58 - ReplaceVariable longitude -> latitude
   * Goal 54. Weak Mutation 44: capstone.mobile.models.Trap.<init>(IIIDDIII)V:58 - InsertUnaryOp Negation of longitude
   * Goal 55. Weak Mutation 45: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - ReplaceVariable side -> broken
   * Goal 56. Weak Mutation 46: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - ReplaceVariable side -> number
   * Goal 57. Weak Mutation 47: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - ReplaceVariable side -> lineId
   * Goal 58. Weak Mutation 48: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - ReplaceVariable side -> id
   * Goal 59. Weak Mutation 49: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - ReplaceVariable side -> moved
   * Goal 60. Weak Mutation 50: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - InsertUnaryOp Negation of side
   * Goal 61. Weak Mutation 51: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - InsertUnaryOp IINC 1 side
   * Goal 62. Weak Mutation 52: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - InsertUnaryOp IINC -1 side
   * Goal 63. Weak Mutation 53: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - ReplaceConstant - 1 -> 0
   * Goal 64. Weak Mutation 54: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - ReplaceComparisonOperator != -> ==
   * Goal 65. Weak Mutation 56: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - ReplaceConstant - 0 -> 1
   * Goal 66. Weak Mutation 57: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - ReplaceVariable moved -> broken
   * Goal 67. Weak Mutation 58: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - ReplaceVariable moved -> number
   * Goal 68. Weak Mutation 59: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - ReplaceVariable moved -> lineId
   * Goal 69. Weak Mutation 60: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - ReplaceVariable moved -> side
   * Goal 70. Weak Mutation 61: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - ReplaceVariable moved -> id
   * Goal 71. Weak Mutation 62: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - InsertUnaryOp Negation of moved
   * Goal 72. Weak Mutation 63: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - InsertUnaryOp IINC 1 moved
   * Goal 73. Weak Mutation 64: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - InsertUnaryOp IINC -1 moved
   * Goal 74. Weak Mutation 65: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - ReplaceConstant - 1 -> 0
   * Goal 75. Weak Mutation 66: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - ReplaceComparisonOperator != -> ==
   * Goal 76. Weak Mutation 68: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - ReplaceConstant - 0 -> 1
   * Goal 77. Weak Mutation 70: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - ReplaceVariable broken -> lineId
   * Goal 78. Weak Mutation 71: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - ReplaceVariable broken -> side
   * Goal 79. Weak Mutation 72: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - ReplaceVariable broken -> id
   * Goal 80. Weak Mutation 73: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - ReplaceVariable broken -> moved
   * Goal 81. Weak Mutation 74: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - InsertUnaryOp Negation of broken
   * Goal 82. Weak Mutation 75: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - InsertUnaryOp IINC 1 broken
   * Goal 83. Weak Mutation 76: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - InsertUnaryOp IINC -1 broken
   * Goal 84. Weak Mutation 77: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - ReplaceConstant - 1 -> 0
   * Goal 85. Weak Mutation 78: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - ReplaceComparisonOperator != -> ==
   * Goal 86. Weak Mutation 80: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - ReplaceConstant - 0 -> 1
   * Goal 87. Weak Mutation 111: capstone.mobile.models.Trap.isMoved()Z:121 - InsertUnaryOp Negation
   * Goal 88. Weak Mutation 112: capstone.mobile.models.Trap.setMoved(Z)V:125 - InsertUnaryOp Negation of moved
   * Goal 89. Weak Mutation 113: capstone.mobile.models.Trap.setMoved(Z)V:125 - InsertUnaryOp IINC 1 moved
   * Goal 90. Weak Mutation 114: capstone.mobile.models.Trap.setMoved(Z)V:125 - InsertUnaryOp IINC -1 moved
   */

    @Test(timeout = 4000)
    public void test00() throws Throwable {
        Trap trap0 = new Trap(2465, 2465, 2010, (double) 2010, 0.0, 1414, 2010, 619);
        assertFalse(trap0.isMoved());

        trap0.setMoved(true);
        boolean boolean0 = trap0.isMoved();
        assertTrue(boolean0);
    }

    //Test case number: 1
  /*
   * 21 covered goals:
   * Goal 1. capstone.mobile.models.Trap.<init>()V: root-Branch
   * Goal 2. capstone.mobile.models.Trap.isBroken()Z: root-Branch
   * Goal 3. capstone.mobile.models.Trap.setBroken(Z)V: root-Branch
   * Goal 4. Branch capstone.mobile.models.Trap.isBroken()Z: root-Branch in context: capstone.mobile.models.Trap:isBroken()Z
   * Goal 5. Branch capstone.mobile.models.Trap.setBroken(Z)V: root-Branch in context: capstone.mobile.models.Trap:setBroken(Z)V
   * Goal 6. Branch capstone.mobile.models.Trap.<init>()V: root-Branch in context: capstone.mobile.models.Trap:<init>()V
   * Goal 7. [Output]: capstone.mobile.models.Trap.isBroken()Z:True
   * Goal 8. capstone.mobile.models.Trap.<init>()V: Line 20
   * Goal 9. capstone.mobile.models.Trap.isBroken()Z: Line 113
   * Goal 10. capstone.mobile.models.Trap.setBroken(Z)V: Line 117
   * Goal 11. capstone.mobile.models.Trap.setBroken(Z)V: Line 118
   * Goal 12. [METHOD] capstone.mobile.models.Trap.<init>()V
   * Goal 13. [METHOD] capstone.mobile.models.Trap.isBroken()Z
   * Goal 14. [METHOD] capstone.mobile.models.Trap.setBroken(Z)V
   * Goal 15. [METHODNOEX] capstone.mobile.models.Trap.<init>()V
   * Goal 16. [METHODNOEX] capstone.mobile.models.Trap.isBroken()Z
   * Goal 17. [METHODNOEX] capstone.mobile.models.Trap.setBroken(Z)V
   * Goal 18. Weak Mutation 107: capstone.mobile.models.Trap.isBroken()Z:113 - InsertUnaryOp Negation
   * Goal 19. Weak Mutation 108: capstone.mobile.models.Trap.setBroken(Z)V:117 - InsertUnaryOp Negation of broken
   * Goal 20. Weak Mutation 109: capstone.mobile.models.Trap.setBroken(Z)V:117 - InsertUnaryOp IINC 1 broken
   * Goal 21. Weak Mutation 110: capstone.mobile.models.Trap.setBroken(Z)V:117 - InsertUnaryOp IINC -1 broken
   */

    @Test(timeout = 4000)
    public void test01() throws Throwable {
        Trap trap0 = new Trap();
        trap0.setBroken(true);
        boolean boolean0 = trap0.isBroken();
        assertTrue(boolean0);
    }

    //Test case number: 2
  /*
   * 81 covered goals:
   * Goal 1. capstone.mobile.models.Trap.getSide()Z: root-Branch
   * Goal 2. capstone.mobile.models.Trap.<init>(IIIDDIII)V: I34 Branch 1 IF_ICMPNE L59 - true
   * Goal 3. capstone.mobile.models.Trap.<init>(IIIDDIII)V: I46 Branch 2 IF_ICMPNE L60 - true
   * Goal 4. capstone.mobile.models.Trap.<init>(IIIDDIII)V: I58 Branch 3 IF_ICMPNE L61 - true
   * Goal 5. Branch capstone.mobile.models.Trap.getSide()Z: root-Branch in context: capstone.mobile.models.Trap:getSide()Z
   * Goal 6. Branch capstone.mobile.models.Trap.<init>(IIIDDIII)V: I34 Branch 1 IF_ICMPNE L59 - true in context: capstone.mobile.models.Trap:<init>(IIIDDIII)V
   * Goal 7. Branch capstone.mobile.models.Trap.<init>(IIIDDIII)V: I46 Branch 2 IF_ICMPNE L60 - true in context: capstone.mobile.models.Trap:<init>(IIIDDIII)V
   * Goal 8. Branch capstone.mobile.models.Trap.<init>(IIIDDIII)V: I58 Branch 3 IF_ICMPNE L61 - true in context: capstone.mobile.models.Trap:<init>(IIIDDIII)V
   * Goal 9. [Output]: capstone.mobile.models.Trap.getSide()Z:False
   * Goal 10. capstone.mobile.models.Trap.<init>(IIIDDIII)V: Line 54
   * Goal 11. capstone.mobile.models.Trap.<init>(IIIDDIII)V: Line 55
   * Goal 12. capstone.mobile.models.Trap.<init>(IIIDDIII)V: Line 56
   * Goal 13. capstone.mobile.models.Trap.<init>(IIIDDIII)V: Line 57
   * Goal 14. capstone.mobile.models.Trap.<init>(IIIDDIII)V: Line 58
   * Goal 15. capstone.mobile.models.Trap.<init>(IIIDDIII)V: Line 59
   * Goal 16. capstone.mobile.models.Trap.<init>(IIIDDIII)V: Line 60
   * Goal 17. capstone.mobile.models.Trap.<init>(IIIDDIII)V: Line 61
   * Goal 18. capstone.mobile.models.Trap.<init>(IIIDDIII)V: Line 62
   * Goal 19. capstone.mobile.models.Trap.getSide()Z: Line 89
   * Goal 20. [METHOD] capstone.mobile.models.Trap.<init>(IIIDDIII)V
   * Goal 21. [METHOD] capstone.mobile.models.Trap.getSide()Z
   * Goal 22. [METHODNOEX] capstone.mobile.models.Trap.<init>(IIIDDIII)V
   * Goal 23. [METHODNOEX] capstone.mobile.models.Trap.getSide()Z
   * Goal 24. Weak Mutation 17: capstone.mobile.models.Trap.<init>(IIIDDIII)V:54 - ReplaceVariable id -> broken
   * Goal 25. Weak Mutation 18: capstone.mobile.models.Trap.<init>(IIIDDIII)V:54 - ReplaceVariable id -> number
   * Goal 26. Weak Mutation 20: capstone.mobile.models.Trap.<init>(IIIDDIII)V:54 - ReplaceVariable id -> side
   * Goal 27. Weak Mutation 21: capstone.mobile.models.Trap.<init>(IIIDDIII)V:54 - ReplaceVariable id -> moved
   * Goal 28. Weak Mutation 22: capstone.mobile.models.Trap.<init>(IIIDDIII)V:54 - InsertUnaryOp Negation of id
   * Goal 29. Weak Mutation 23: capstone.mobile.models.Trap.<init>(IIIDDIII)V:54 - InsertUnaryOp IINC 1 id
   * Goal 30. Weak Mutation 24: capstone.mobile.models.Trap.<init>(IIIDDIII)V:54 - InsertUnaryOp IINC -1 id
   * Goal 31. Weak Mutation 25: capstone.mobile.models.Trap.<init>(IIIDDIII)V:55 - ReplaceVariable lineId -> broken
   * Goal 32. Weak Mutation 26: capstone.mobile.models.Trap.<init>(IIIDDIII)V:55 - ReplaceVariable lineId -> number
   * Goal 33. Weak Mutation 27: capstone.mobile.models.Trap.<init>(IIIDDIII)V:55 - ReplaceVariable lineId -> side
   * Goal 34. Weak Mutation 29: capstone.mobile.models.Trap.<init>(IIIDDIII)V:55 - ReplaceVariable lineId -> moved
   * Goal 35. Weak Mutation 30: capstone.mobile.models.Trap.<init>(IIIDDIII)V:55 - InsertUnaryOp Negation of lineId
   * Goal 36. Weak Mutation 31: capstone.mobile.models.Trap.<init>(IIIDDIII)V:55 - InsertUnaryOp IINC 1 lineId
   * Goal 37. Weak Mutation 32: capstone.mobile.models.Trap.<init>(IIIDDIII)V:55 - InsertUnaryOp IINC -1 lineId
   * Goal 38. Weak Mutation 34: capstone.mobile.models.Trap.<init>(IIIDDIII)V:56 - ReplaceVariable number -> lineId
   * Goal 39. Weak Mutation 35: capstone.mobile.models.Trap.<init>(IIIDDIII)V:56 - ReplaceVariable number -> side
   * Goal 40. Weak Mutation 36: capstone.mobile.models.Trap.<init>(IIIDDIII)V:56 - ReplaceVariable number -> id
   * Goal 41. Weak Mutation 37: capstone.mobile.models.Trap.<init>(IIIDDIII)V:56 - ReplaceVariable number -> moved
   * Goal 42. Weak Mutation 38: capstone.mobile.models.Trap.<init>(IIIDDIII)V:56 - InsertUnaryOp Negation of number
   * Goal 43. Weak Mutation 39: capstone.mobile.models.Trap.<init>(IIIDDIII)V:56 - InsertUnaryOp IINC 1 number
   * Goal 44. Weak Mutation 40: capstone.mobile.models.Trap.<init>(IIIDDIII)V:56 - InsertUnaryOp IINC -1 number
   * Goal 45. Weak Mutation 41: capstone.mobile.models.Trap.<init>(IIIDDIII)V:57 - ReplaceVariable latitude -> longitude
   * Goal 46. Weak Mutation 42: capstone.mobile.models.Trap.<init>(IIIDDIII)V:57 - InsertUnaryOp Negation of latitude
   * Goal 47. Weak Mutation 43: capstone.mobile.models.Trap.<init>(IIIDDIII)V:58 - ReplaceVariable longitude -> latitude
   * Goal 48. Weak Mutation 44: capstone.mobile.models.Trap.<init>(IIIDDIII)V:58 - InsertUnaryOp Negation of longitude
   * Goal 49. Weak Mutation 45: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - ReplaceVariable side -> broken
   * Goal 50. Weak Mutation 46: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - ReplaceVariable side -> number
   * Goal 51. Weak Mutation 47: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - ReplaceVariable side -> lineId
   * Goal 52. Weak Mutation 48: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - ReplaceVariable side -> id
   * Goal 53. Weak Mutation 49: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - ReplaceVariable side -> moved
   * Goal 54. Weak Mutation 50: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - InsertUnaryOp Negation of side
   * Goal 55. Weak Mutation 51: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - InsertUnaryOp IINC 1 side
   * Goal 56. Weak Mutation 52: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - InsertUnaryOp IINC -1 side
   * Goal 57. Weak Mutation 53: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - ReplaceConstant - 1 -> 0
   * Goal 58. Weak Mutation 54: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - ReplaceComparisonOperator != -> ==
   * Goal 59. Weak Mutation 56: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - ReplaceConstant - 0 -> 1
   * Goal 60. Weak Mutation 57: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - ReplaceVariable moved -> broken
   * Goal 61. Weak Mutation 58: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - ReplaceVariable moved -> number
   * Goal 62. Weak Mutation 59: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - ReplaceVariable moved -> lineId
   * Goal 63. Weak Mutation 60: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - ReplaceVariable moved -> side
   * Goal 64. Weak Mutation 61: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - ReplaceVariable moved -> id
   * Goal 65. Weak Mutation 62: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - InsertUnaryOp Negation of moved
   * Goal 66. Weak Mutation 63: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - InsertUnaryOp IINC 1 moved
   * Goal 67. Weak Mutation 64: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - InsertUnaryOp IINC -1 moved
   * Goal 68. Weak Mutation 65: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - ReplaceConstant - 1 -> 0
   * Goal 69. Weak Mutation 66: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - ReplaceComparisonOperator != -> ==
   * Goal 70. Weak Mutation 68: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - ReplaceConstant - 0 -> 1
   * Goal 71. Weak Mutation 70: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - ReplaceVariable broken -> lineId
   * Goal 72. Weak Mutation 71: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - ReplaceVariable broken -> side
   * Goal 73. Weak Mutation 72: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - ReplaceVariable broken -> id
   * Goal 74. Weak Mutation 73: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - ReplaceVariable broken -> moved
   * Goal 75. Weak Mutation 74: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - InsertUnaryOp Negation of broken
   * Goal 76. Weak Mutation 75: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - InsertUnaryOp IINC 1 broken
   * Goal 77. Weak Mutation 76: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - InsertUnaryOp IINC -1 broken
   * Goal 78. Weak Mutation 77: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - ReplaceConstant - 1 -> 0
   * Goal 79. Weak Mutation 78: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - ReplaceComparisonOperator != -> ==
   * Goal 80. Weak Mutation 80: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - ReplaceConstant - 0 -> 1
   * Goal 81. Weak Mutation 99: capstone.mobile.models.Trap.getSide()Z:89 - InsertUnaryOp Negation
   */

    @Test(timeout = 4000)
    public void test02() throws Throwable {
        Trap    trap0    = new Trap(2465, 2465, 2010, (double) 2010, 0.0, 1414, 2010, 619);
        boolean boolean0 = trap0.getSide();
        assertFalse(boolean0);
        assertEquals(2465, trap0.getId());
        assertEquals(0.0, trap0.getLongitude(), 0.01);
        assertEquals(2010, trap0.getNumber());
        assertEquals(2465, trap0.getLineId());
        assertFalse(trap0.isMoved());
        assertEquals(2010.0, trap0.getLatitude(), 0.01);
        assertFalse(trap0.isBroken());
    }

    //Test case number: 3
  /*
   * 81 covered goals:
   * Goal 1. capstone.mobile.models.Trap.getNumber()I: root-Branch
   * Goal 2. capstone.mobile.models.Trap.<init>(IIIDDIII)V: I34 Branch 1 IF_ICMPNE L59 - true
   * Goal 3. capstone.mobile.models.Trap.<init>(IIIDDIII)V: I46 Branch 2 IF_ICMPNE L60 - true
   * Goal 4. capstone.mobile.models.Trap.<init>(IIIDDIII)V: I58 Branch 3 IF_ICMPNE L61 - true
   * Goal 5. Branch capstone.mobile.models.Trap.getNumber()I: root-Branch in context: capstone.mobile.models.Trap:getNumber()I
   * Goal 6. Branch capstone.mobile.models.Trap.<init>(IIIDDIII)V: I34 Branch 1 IF_ICMPNE L59 - true in context: capstone.mobile.models.Trap:<init>(IIIDDIII)V
   * Goal 7. Branch capstone.mobile.models.Trap.<init>(IIIDDIII)V: I46 Branch 2 IF_ICMPNE L60 - true in context: capstone.mobile.models.Trap:<init>(IIIDDIII)V
   * Goal 8. Branch capstone.mobile.models.Trap.<init>(IIIDDIII)V: I58 Branch 3 IF_ICMPNE L61 - true in context: capstone.mobile.models.Trap:<init>(IIIDDIII)V
   * Goal 9. [Output]: capstone.mobile.models.Trap.getNumber()I:Negative
   * Goal 10. capstone.mobile.models.Trap.<init>(IIIDDIII)V: Line 54
   * Goal 11. capstone.mobile.models.Trap.<init>(IIIDDIII)V: Line 55
   * Goal 12. capstone.mobile.models.Trap.<init>(IIIDDIII)V: Line 56
   * Goal 13. capstone.mobile.models.Trap.<init>(IIIDDIII)V: Line 57
   * Goal 14. capstone.mobile.models.Trap.<init>(IIIDDIII)V: Line 58
   * Goal 15. capstone.mobile.models.Trap.<init>(IIIDDIII)V: Line 59
   * Goal 16. capstone.mobile.models.Trap.<init>(IIIDDIII)V: Line 60
   * Goal 17. capstone.mobile.models.Trap.<init>(IIIDDIII)V: Line 61
   * Goal 18. capstone.mobile.models.Trap.<init>(IIIDDIII)V: Line 62
   * Goal 19. capstone.mobile.models.Trap.getNumber()I: Line 81
   * Goal 20. [METHOD] capstone.mobile.models.Trap.<init>(IIIDDIII)V
   * Goal 21. [METHOD] capstone.mobile.models.Trap.getNumber()I
   * Goal 22. [METHODNOEX] capstone.mobile.models.Trap.<init>(IIIDDIII)V
   * Goal 23. [METHODNOEX] capstone.mobile.models.Trap.getNumber()I
   * Goal 24. Weak Mutation 17: capstone.mobile.models.Trap.<init>(IIIDDIII)V:54 - ReplaceVariable id -> broken
   * Goal 25. Weak Mutation 18: capstone.mobile.models.Trap.<init>(IIIDDIII)V:54 - ReplaceVariable id -> number
   * Goal 26. Weak Mutation 19: capstone.mobile.models.Trap.<init>(IIIDDIII)V:54 - ReplaceVariable id -> lineId
   * Goal 27. Weak Mutation 20: capstone.mobile.models.Trap.<init>(IIIDDIII)V:54 - ReplaceVariable id -> side
   * Goal 28. Weak Mutation 21: capstone.mobile.models.Trap.<init>(IIIDDIII)V:54 - ReplaceVariable id -> moved
   * Goal 29. Weak Mutation 22: capstone.mobile.models.Trap.<init>(IIIDDIII)V:54 - InsertUnaryOp Negation of id
   * Goal 30. Weak Mutation 23: capstone.mobile.models.Trap.<init>(IIIDDIII)V:54 - InsertUnaryOp IINC 1 id
   * Goal 31. Weak Mutation 24: capstone.mobile.models.Trap.<init>(IIIDDIII)V:54 - InsertUnaryOp IINC -1 id
   * Goal 32. Weak Mutation 26: capstone.mobile.models.Trap.<init>(IIIDDIII)V:55 - ReplaceVariable lineId -> number
   * Goal 33. Weak Mutation 27: capstone.mobile.models.Trap.<init>(IIIDDIII)V:55 - ReplaceVariable lineId -> side
   * Goal 34. Weak Mutation 28: capstone.mobile.models.Trap.<init>(IIIDDIII)V:55 - ReplaceVariable lineId -> id
   * Goal 35. Weak Mutation 29: capstone.mobile.models.Trap.<init>(IIIDDIII)V:55 - ReplaceVariable lineId -> moved
   * Goal 36. Weak Mutation 30: capstone.mobile.models.Trap.<init>(IIIDDIII)V:55 - InsertUnaryOp Negation of lineId
   * Goal 37. Weak Mutation 31: capstone.mobile.models.Trap.<init>(IIIDDIII)V:55 - InsertUnaryOp IINC 1 lineId
   * Goal 38. Weak Mutation 32: capstone.mobile.models.Trap.<init>(IIIDDIII)V:55 - InsertUnaryOp IINC -1 lineId
   * Goal 39. Weak Mutation 33: capstone.mobile.models.Trap.<init>(IIIDDIII)V:56 - ReplaceVariable number -> broken
   * Goal 40. Weak Mutation 34: capstone.mobile.models.Trap.<init>(IIIDDIII)V:56 - ReplaceVariable number -> lineId
   * Goal 41. Weak Mutation 36: capstone.mobile.models.Trap.<init>(IIIDDIII)V:56 - ReplaceVariable number -> id
   * Goal 42. Weak Mutation 37: capstone.mobile.models.Trap.<init>(IIIDDIII)V:56 - ReplaceVariable number -> moved
   * Goal 43. Weak Mutation 38: capstone.mobile.models.Trap.<init>(IIIDDIII)V:56 - InsertUnaryOp Negation of number
   * Goal 44. Weak Mutation 39: capstone.mobile.models.Trap.<init>(IIIDDIII)V:56 - InsertUnaryOp IINC 1 number
   * Goal 45. Weak Mutation 40: capstone.mobile.models.Trap.<init>(IIIDDIII)V:56 - InsertUnaryOp IINC -1 number
   * Goal 46. Weak Mutation 42: capstone.mobile.models.Trap.<init>(IIIDDIII)V:57 - InsertUnaryOp Negation of latitude
   * Goal 47. Weak Mutation 44: capstone.mobile.models.Trap.<init>(IIIDDIII)V:58 - InsertUnaryOp Negation of longitude
   * Goal 48. Weak Mutation 45: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - ReplaceVariable side -> broken
   * Goal 49. Weak Mutation 47: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - ReplaceVariable side -> lineId
   * Goal 50. Weak Mutation 48: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - ReplaceVariable side -> id
   * Goal 51. Weak Mutation 49: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - ReplaceVariable side -> moved
   * Goal 52. Weak Mutation 50: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - InsertUnaryOp Negation of side
   * Goal 53. Weak Mutation 51: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - InsertUnaryOp IINC 1 side
   * Goal 54. Weak Mutation 52: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - InsertUnaryOp IINC -1 side
   * Goal 55. Weak Mutation 53: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - ReplaceConstant - 1 -> 0
   * Goal 56. Weak Mutation 54: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - ReplaceComparisonOperator != -> ==
   * Goal 57. Weak Mutation 56: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - ReplaceConstant - 0 -> 1
   * Goal 58. Weak Mutation 57: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - ReplaceVariable moved -> broken
   * Goal 59. Weak Mutation 58: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - ReplaceVariable moved -> number
   * Goal 60. Weak Mutation 59: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - ReplaceVariable moved -> lineId
   * Goal 61. Weak Mutation 60: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - ReplaceVariable moved -> side
   * Goal 62. Weak Mutation 61: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - ReplaceVariable moved -> id
   * Goal 63. Weak Mutation 62: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - InsertUnaryOp Negation of moved
   * Goal 64. Weak Mutation 63: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - InsertUnaryOp IINC 1 moved
   * Goal 65. Weak Mutation 64: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - InsertUnaryOp IINC -1 moved
   * Goal 66. Weak Mutation 65: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - ReplaceConstant - 1 -> 0
   * Goal 67. Weak Mutation 66: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - ReplaceComparisonOperator != -> ==
   * Goal 68. Weak Mutation 68: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - ReplaceConstant - 0 -> 1
   * Goal 69. Weak Mutation 69: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - ReplaceVariable broken -> number
   * Goal 70. Weak Mutation 71: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - ReplaceVariable broken -> side
   * Goal 71. Weak Mutation 72: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - ReplaceVariable broken -> id
   * Goal 72. Weak Mutation 73: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - ReplaceVariable broken -> moved
   * Goal 73. Weak Mutation 74: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - InsertUnaryOp Negation of broken
   * Goal 74. Weak Mutation 75: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - InsertUnaryOp IINC 1 broken
   * Goal 75. Weak Mutation 76: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - InsertUnaryOp IINC -1 broken
   * Goal 76. Weak Mutation 77: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - ReplaceConstant - 1 -> 0
   * Goal 77. Weak Mutation 78: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - ReplaceComparisonOperator != -> ==
   * Goal 78. Weak Mutation 80: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - ReplaceConstant - 0 -> 1
   * Goal 79. Weak Mutation 93: capstone.mobile.models.Trap.getNumber()I:81 - InsertUnaryOp Negation
   * Goal 80. Weak Mutation 94: capstone.mobile.models.Trap.getNumber()I:81 - InsertUnaryOp +1
   * Goal 81. Weak Mutation 95: capstone.mobile.models.Trap.getNumber()I:81 - InsertUnaryOp -1
   */

    @Test(timeout = 4000)
    public void test03() throws Throwable {
        Trap trap0 = new Trap(3658, 0, (-1), 0, 0, (-1), 0, 1688);
        int  int0  = trap0.getNumber();
        assertEquals(0, trap0.getLineId());
        assertFalse(trap0.isMoved());
        assertFalse(trap0.isBroken());
        assertEquals(3658, trap0.getId());
        assertEquals((-1), int0);
        assertFalse(trap0.getSide());
    }

    //Test case number: 4
  /*
   * 36 covered goals:
   * Goal 1. capstone.mobile.models.Trap.<init>(IIDDZ)V: root-Branch
   * Goal 2. capstone.mobile.models.Trap.getLongitude()D: root-Branch
   * Goal 3. Branch capstone.mobile.models.Trap.<init>(IIDDZ)V: root-Branch in context: capstone.mobile.models.Trap:<init>(IIDDZ)V
   * Goal 4. Branch capstone.mobile.models.Trap.getLongitude()D: root-Branch in context: capstone.mobile.models.Trap:getLongitude()D
   * Goal 5. [Output]: capstone.mobile.models.Trap.getLongitude()D:Positive
   * Goal 6. capstone.mobile.models.Trap.<init>(IIDDZ)V: Line 32
   * Goal 7. capstone.mobile.models.Trap.<init>(IIDDZ)V: Line 33
   * Goal 8. capstone.mobile.models.Trap.<init>(IIDDZ)V: Line 34
   * Goal 9. capstone.mobile.models.Trap.<init>(IIDDZ)V: Line 35
   * Goal 10. capstone.mobile.models.Trap.<init>(IIDDZ)V: Line 36
   * Goal 11. capstone.mobile.models.Trap.<init>(IIDDZ)V: Line 37
   * Goal 12. capstone.mobile.models.Trap.<init>(IIDDZ)V: Line 38
   * Goal 13. capstone.mobile.models.Trap.<init>(IIDDZ)V: Line 39
   * Goal 14. capstone.mobile.models.Trap.getLongitude()D: Line 97
   * Goal 15. [METHOD] capstone.mobile.models.Trap.<init>(IIDDZ)V
   * Goal 16. [METHOD] capstone.mobile.models.Trap.getLongitude()D
   * Goal 17. [METHODNOEX] capstone.mobile.models.Trap.<init>(IIDDZ)V
   * Goal 18. [METHODNOEX] capstone.mobile.models.Trap.getLongitude()D
   * Goal 19. Weak Mutation 0: capstone.mobile.models.Trap.<init>(IIDDZ)V:32 - ReplaceVariable lineId -> number
   * Goal 20. Weak Mutation 1: capstone.mobile.models.Trap.<init>(IIDDZ)V:32 - InsertUnaryOp Negation of lineId
   * Goal 21. Weak Mutation 2: capstone.mobile.models.Trap.<init>(IIDDZ)V:32 - InsertUnaryOp IINC 1 lineId
   * Goal 22. Weak Mutation 3: capstone.mobile.models.Trap.<init>(IIDDZ)V:32 - InsertUnaryOp IINC -1 lineId
   * Goal 23. Weak Mutation 4: capstone.mobile.models.Trap.<init>(IIDDZ)V:33 - ReplaceVariable number -> lineId
   * Goal 24. Weak Mutation 5: capstone.mobile.models.Trap.<init>(IIDDZ)V:33 - InsertUnaryOp Negation of number
   * Goal 25. Weak Mutation 6: capstone.mobile.models.Trap.<init>(IIDDZ)V:33 - InsertUnaryOp IINC 1 number
   * Goal 26. Weak Mutation 7: capstone.mobile.models.Trap.<init>(IIDDZ)V:33 - InsertUnaryOp IINC -1 number
   * Goal 27. Weak Mutation 8: capstone.mobile.models.Trap.<init>(IIDDZ)V:34 - ReplaceVariable latitude -> longitude
   * Goal 28. Weak Mutation 9: capstone.mobile.models.Trap.<init>(IIDDZ)V:34 - InsertUnaryOp Negation of latitude
   * Goal 29. Weak Mutation 10: capstone.mobile.models.Trap.<init>(IIDDZ)V:35 - ReplaceVariable longitude -> latitude
   * Goal 30. Weak Mutation 11: capstone.mobile.models.Trap.<init>(IIDDZ)V:35 - InsertUnaryOp Negation of longitude
   * Goal 31. Weak Mutation 12: capstone.mobile.models.Trap.<init>(IIDDZ)V:36 - InsertUnaryOp Negation of side
   * Goal 32. Weak Mutation 13: capstone.mobile.models.Trap.<init>(IIDDZ)V:36 - InsertUnaryOp IINC 1 side
   * Goal 33. Weak Mutation 14: capstone.mobile.models.Trap.<init>(IIDDZ)V:36 - InsertUnaryOp IINC -1 side
   * Goal 34. Weak Mutation 15: capstone.mobile.models.Trap.<init>(IIDDZ)V:37 - ReplaceConstant - 0 -> 1
   * Goal 35. Weak Mutation 16: capstone.mobile.models.Trap.<init>(IIDDZ)V:38 - ReplaceConstant - 0 -> 1
   * Goal 36. Weak Mutation 103: capstone.mobile.models.Trap.getLongitude()D:97 - InsertUnaryOp Negation
   */

    @Test(timeout = 4000)
    public void test04() throws Throwable {
        Trap   trap0   = new Trap(0, (-819), 361.02871188, 380.0, false);
        double double0 = trap0.getLongitude();
        assertFalse(trap0.getSide());
        assertFalse(trap0.isBroken());
        assertEquals(-819, trap0.getNumber());
        assertEquals(0, trap0.getLineId());
        assertFalse(trap0.isMoved());
        assertEquals(361.02871188, trap0.getLatitude(), 0.01);
        assertEquals(380.0, double0, 0.01);
    }

    //Test case number: 5
  /*
   * 36 covered goals:
   * Goal 1. capstone.mobile.models.Trap.<init>(IIDDZ)V: root-Branch
   * Goal 2. capstone.mobile.models.Trap.getLongitude()D: root-Branch
   * Goal 3. Branch capstone.mobile.models.Trap.<init>(IIDDZ)V: root-Branch in context: capstone.mobile.models.Trap:<init>(IIDDZ)V
   * Goal 4. Branch capstone.mobile.models.Trap.getLongitude()D: root-Branch in context: capstone.mobile.models.Trap:getLongitude()D
   * Goal 5. [Output]: capstone.mobile.models.Trap.getLongitude()D:Negative
   * Goal 6. capstone.mobile.models.Trap.<init>(IIDDZ)V: Line 32
   * Goal 7. capstone.mobile.models.Trap.<init>(IIDDZ)V: Line 33
   * Goal 8. capstone.mobile.models.Trap.<init>(IIDDZ)V: Line 34
   * Goal 9. capstone.mobile.models.Trap.<init>(IIDDZ)V: Line 35
   * Goal 10. capstone.mobile.models.Trap.<init>(IIDDZ)V: Line 36
   * Goal 11. capstone.mobile.models.Trap.<init>(IIDDZ)V: Line 37
   * Goal 12. capstone.mobile.models.Trap.<init>(IIDDZ)V: Line 38
   * Goal 13. capstone.mobile.models.Trap.<init>(IIDDZ)V: Line 39
   * Goal 14. capstone.mobile.models.Trap.getLongitude()D: Line 97
   * Goal 15. [METHOD] capstone.mobile.models.Trap.<init>(IIDDZ)V
   * Goal 16. [METHOD] capstone.mobile.models.Trap.getLongitude()D
   * Goal 17. [METHODNOEX] capstone.mobile.models.Trap.<init>(IIDDZ)V
   * Goal 18. [METHODNOEX] capstone.mobile.models.Trap.getLongitude()D
   * Goal 19. Weak Mutation 0: capstone.mobile.models.Trap.<init>(IIDDZ)V:32 - ReplaceVariable lineId -> number
   * Goal 20. Weak Mutation 1: capstone.mobile.models.Trap.<init>(IIDDZ)V:32 - InsertUnaryOp Negation of lineId
   * Goal 21. Weak Mutation 2: capstone.mobile.models.Trap.<init>(IIDDZ)V:32 - InsertUnaryOp IINC 1 lineId
   * Goal 22. Weak Mutation 3: capstone.mobile.models.Trap.<init>(IIDDZ)V:32 - InsertUnaryOp IINC -1 lineId
   * Goal 23. Weak Mutation 4: capstone.mobile.models.Trap.<init>(IIDDZ)V:33 - ReplaceVariable number -> lineId
   * Goal 24. Weak Mutation 5: capstone.mobile.models.Trap.<init>(IIDDZ)V:33 - InsertUnaryOp Negation of number
   * Goal 25. Weak Mutation 6: capstone.mobile.models.Trap.<init>(IIDDZ)V:33 - InsertUnaryOp IINC 1 number
   * Goal 26. Weak Mutation 7: capstone.mobile.models.Trap.<init>(IIDDZ)V:33 - InsertUnaryOp IINC -1 number
   * Goal 27. Weak Mutation 8: capstone.mobile.models.Trap.<init>(IIDDZ)V:34 - ReplaceVariable latitude -> longitude
   * Goal 28. Weak Mutation 9: capstone.mobile.models.Trap.<init>(IIDDZ)V:34 - InsertUnaryOp Negation of latitude
   * Goal 29. Weak Mutation 10: capstone.mobile.models.Trap.<init>(IIDDZ)V:35 - ReplaceVariable longitude -> latitude
   * Goal 30. Weak Mutation 11: capstone.mobile.models.Trap.<init>(IIDDZ)V:35 - InsertUnaryOp Negation of longitude
   * Goal 31. Weak Mutation 12: capstone.mobile.models.Trap.<init>(IIDDZ)V:36 - InsertUnaryOp Negation of side
   * Goal 32. Weak Mutation 13: capstone.mobile.models.Trap.<init>(IIDDZ)V:36 - InsertUnaryOp IINC 1 side
   * Goal 33. Weak Mutation 14: capstone.mobile.models.Trap.<init>(IIDDZ)V:36 - InsertUnaryOp IINC -1 side
   * Goal 34. Weak Mutation 15: capstone.mobile.models.Trap.<init>(IIDDZ)V:37 - ReplaceConstant - 0 -> 1
   * Goal 35. Weak Mutation 16: capstone.mobile.models.Trap.<init>(IIDDZ)V:38 - ReplaceConstant - 0 -> 1
   * Goal 36. Weak Mutation 103: capstone.mobile.models.Trap.getLongitude()D:97 - InsertUnaryOp Negation
   */

    @Test(timeout = 4000)
    public void test05() throws Throwable {
        Trap   trap0   = new Trap((-1708), (-2466), (double) (-2466), (double) (-1708), true);
        double double0 = trap0.getLongitude();
        assertEquals(-1708, trap0.getLineId());
        assertEquals(-2466, trap0.getNumber());
        assertFalse(trap0.isMoved());
        assertEquals((-1708.0), double0, 0.01);
        assertEquals((-2466.0), trap0.getLatitude(), 0.01);
        assertFalse(trap0.isBroken());
        assertTrue(trap0.getSide());
    }

    //Test case number: 6
  /*
   * 23 covered goals:
   * Goal 1. capstone.mobile.models.Trap.<init>()V: root-Branch
   * Goal 2. capstone.mobile.models.Trap.getLineId()I: root-Branch
   * Goal 3. capstone.mobile.models.Trap.setLineId(I)V: root-Branch
   * Goal 4. Branch capstone.mobile.models.Trap.getLineId()I: root-Branch in context: capstone.mobile.models.Trap:getLineId()I
   * Goal 5. Branch capstone.mobile.models.Trap.setLineId(I)V: root-Branch in context: capstone.mobile.models.Trap:setLineId(I)V
   * Goal 6. Branch capstone.mobile.models.Trap.<init>()V: root-Branch in context: capstone.mobile.models.Trap:<init>()V
   * Goal 7. [Output]: capstone.mobile.models.Trap.getLineId()I:Positive
   * Goal 8. capstone.mobile.models.Trap.<init>()V: Line 20
   * Goal 9. capstone.mobile.models.Trap.getLineId()I: Line 73
   * Goal 10. capstone.mobile.models.Trap.setLineId(I)V: Line 77
   * Goal 11. capstone.mobile.models.Trap.setLineId(I)V: Line 78
   * Goal 12. [METHOD] capstone.mobile.models.Trap.<init>()V
   * Goal 13. [METHOD] capstone.mobile.models.Trap.getLineId()I
   * Goal 14. [METHOD] capstone.mobile.models.Trap.setLineId(I)V
   * Goal 15. [METHODNOEX] capstone.mobile.models.Trap.<init>()V
   * Goal 16. [METHODNOEX] capstone.mobile.models.Trap.getLineId()I
   * Goal 17. [METHODNOEX] capstone.mobile.models.Trap.setLineId(I)V
   * Goal 18. Weak Mutation 87: capstone.mobile.models.Trap.getLineId()I:73 - InsertUnaryOp Negation
   * Goal 19. Weak Mutation 88: capstone.mobile.models.Trap.getLineId()I:73 - InsertUnaryOp +1
   * Goal 20. Weak Mutation 89: capstone.mobile.models.Trap.getLineId()I:73 - InsertUnaryOp -1
   * Goal 21. Weak Mutation 90: capstone.mobile.models.Trap.setLineId(I)V:77 - InsertUnaryOp Negation of lineId
   * Goal 22. Weak Mutation 91: capstone.mobile.models.Trap.setLineId(I)V:77 - InsertUnaryOp IINC 1 lineId
   * Goal 23. Weak Mutation 92: capstone.mobile.models.Trap.setLineId(I)V:77 - InsertUnaryOp IINC -1 lineId
   */

    @Test(timeout = 4000)
    public void test06() throws Throwable {
        Trap trap0 = new Trap();
        trap0.setLineId(1);
        int int0 = trap0.getLineId();
        assertEquals(1, int0);
    }

    //Test case number: 7
  /*
   * 38 covered goals:
   * Goal 1. capstone.mobile.models.Trap.<init>(IIDDZ)V: root-Branch
   * Goal 2. capstone.mobile.models.Trap.getLineId()I: root-Branch
   * Goal 3. Branch capstone.mobile.models.Trap.getLineId()I: root-Branch in context: capstone.mobile.models.Trap:getLineId()I
   * Goal 4. Branch capstone.mobile.models.Trap.<init>(IIDDZ)V: root-Branch in context: capstone.mobile.models.Trap:<init>(IIDDZ)V
   * Goal 5. [Output]: capstone.mobile.models.Trap.getLineId()I:Negative
   * Goal 6. capstone.mobile.models.Trap.<init>(IIDDZ)V: Line 32
   * Goal 7. capstone.mobile.models.Trap.<init>(IIDDZ)V: Line 33
   * Goal 8. capstone.mobile.models.Trap.<init>(IIDDZ)V: Line 34
   * Goal 9. capstone.mobile.models.Trap.<init>(IIDDZ)V: Line 35
   * Goal 10. capstone.mobile.models.Trap.<init>(IIDDZ)V: Line 36
   * Goal 11. capstone.mobile.models.Trap.<init>(IIDDZ)V: Line 37
   * Goal 12. capstone.mobile.models.Trap.<init>(IIDDZ)V: Line 38
   * Goal 13. capstone.mobile.models.Trap.<init>(IIDDZ)V: Line 39
   * Goal 14. capstone.mobile.models.Trap.getLineId()I: Line 73
   * Goal 15. [METHOD] capstone.mobile.models.Trap.<init>(IIDDZ)V
   * Goal 16. [METHOD] capstone.mobile.models.Trap.getLineId()I
   * Goal 17. [METHODNOEX] capstone.mobile.models.Trap.<init>(IIDDZ)V
   * Goal 18. [METHODNOEX] capstone.mobile.models.Trap.getLineId()I
   * Goal 19. Weak Mutation 0: capstone.mobile.models.Trap.<init>(IIDDZ)V:32 - ReplaceVariable lineId -> number
   * Goal 20. Weak Mutation 1: capstone.mobile.models.Trap.<init>(IIDDZ)V:32 - InsertUnaryOp Negation of lineId
   * Goal 21. Weak Mutation 2: capstone.mobile.models.Trap.<init>(IIDDZ)V:32 - InsertUnaryOp IINC 1 lineId
   * Goal 22. Weak Mutation 3: capstone.mobile.models.Trap.<init>(IIDDZ)V:32 - InsertUnaryOp IINC -1 lineId
   * Goal 23. Weak Mutation 4: capstone.mobile.models.Trap.<init>(IIDDZ)V:33 - ReplaceVariable number -> lineId
   * Goal 24. Weak Mutation 5: capstone.mobile.models.Trap.<init>(IIDDZ)V:33 - InsertUnaryOp Negation of number
   * Goal 25. Weak Mutation 6: capstone.mobile.models.Trap.<init>(IIDDZ)V:33 - InsertUnaryOp IINC 1 number
   * Goal 26. Weak Mutation 7: capstone.mobile.models.Trap.<init>(IIDDZ)V:33 - InsertUnaryOp IINC -1 number
   * Goal 27. Weak Mutation 8: capstone.mobile.models.Trap.<init>(IIDDZ)V:34 - ReplaceVariable latitude -> longitude
   * Goal 28. Weak Mutation 9: capstone.mobile.models.Trap.<init>(IIDDZ)V:34 - InsertUnaryOp Negation of latitude
   * Goal 29. Weak Mutation 10: capstone.mobile.models.Trap.<init>(IIDDZ)V:35 - ReplaceVariable longitude -> latitude
   * Goal 30. Weak Mutation 11: capstone.mobile.models.Trap.<init>(IIDDZ)V:35 - InsertUnaryOp Negation of longitude
   * Goal 31. Weak Mutation 12: capstone.mobile.models.Trap.<init>(IIDDZ)V:36 - InsertUnaryOp Negation of side
   * Goal 32. Weak Mutation 13: capstone.mobile.models.Trap.<init>(IIDDZ)V:36 - InsertUnaryOp IINC 1 side
   * Goal 33. Weak Mutation 14: capstone.mobile.models.Trap.<init>(IIDDZ)V:36 - InsertUnaryOp IINC -1 side
   * Goal 34. Weak Mutation 15: capstone.mobile.models.Trap.<init>(IIDDZ)V:37 - ReplaceConstant - 0 -> 1
   * Goal 35. Weak Mutation 16: capstone.mobile.models.Trap.<init>(IIDDZ)V:38 - ReplaceConstant - 0 -> 1
   * Goal 36. Weak Mutation 87: capstone.mobile.models.Trap.getLineId()I:73 - InsertUnaryOp Negation
   * Goal 37. Weak Mutation 88: capstone.mobile.models.Trap.getLineId()I:73 - InsertUnaryOp +1
   * Goal 38. Weak Mutation 89: capstone.mobile.models.Trap.getLineId()I:73 - InsertUnaryOp -1
   */

    @Test(timeout = 4000)
    public void test07() throws Throwable {
        Trap trap0 = new Trap((-1708), (-2466), (double) (-2466), (double) (-1708), true);
        int  int0  = trap0.getLineId();
        assertFalse(trap0.isBroken());
        assertEquals((-1708.0), trap0.getLongitude(), 0.01);
        assertEquals(-2466, trap0.getNumber());
        assertFalse(trap0.isMoved());
        assertTrue(trap0.getSide());
        assertEquals((-2466.0), trap0.getLatitude(), 0.01);
        assertEquals((-1708), int0);
    }

    //Test case number: 8
  /*
   * 36 covered goals:
   * Goal 1. capstone.mobile.models.Trap.getLatitude()D: root-Branch
   * Goal 2. capstone.mobile.models.Trap.<init>(IIDDZ)V: root-Branch
   * Goal 3. Branch capstone.mobile.models.Trap.getLatitude()D: root-Branch in context: capstone.mobile.models.Trap:getLatitude()D
   * Goal 4. Branch capstone.mobile.models.Trap.<init>(IIDDZ)V: root-Branch in context: capstone.mobile.models.Trap:<init>(IIDDZ)V
   * Goal 5. [Output]: capstone.mobile.models.Trap.getLatitude()D:Positive
   * Goal 6. capstone.mobile.models.Trap.<init>(IIDDZ)V: Line 32
   * Goal 7. capstone.mobile.models.Trap.<init>(IIDDZ)V: Line 33
   * Goal 8. capstone.mobile.models.Trap.<init>(IIDDZ)V: Line 34
   * Goal 9. capstone.mobile.models.Trap.<init>(IIDDZ)V: Line 35
   * Goal 10. capstone.mobile.models.Trap.<init>(IIDDZ)V: Line 36
   * Goal 11. capstone.mobile.models.Trap.<init>(IIDDZ)V: Line 37
   * Goal 12. capstone.mobile.models.Trap.<init>(IIDDZ)V: Line 38
   * Goal 13. capstone.mobile.models.Trap.<init>(IIDDZ)V: Line 39
   * Goal 14. capstone.mobile.models.Trap.getLatitude()D: Line 105
   * Goal 15. [METHOD] capstone.mobile.models.Trap.<init>(IIDDZ)V
   * Goal 16. [METHOD] capstone.mobile.models.Trap.getLatitude()D
   * Goal 17. [METHODNOEX] capstone.mobile.models.Trap.<init>(IIDDZ)V
   * Goal 18. [METHODNOEX] capstone.mobile.models.Trap.getLatitude()D
   * Goal 19. Weak Mutation 0: capstone.mobile.models.Trap.<init>(IIDDZ)V:32 - ReplaceVariable lineId -> number
   * Goal 20. Weak Mutation 1: capstone.mobile.models.Trap.<init>(IIDDZ)V:32 - InsertUnaryOp Negation of lineId
   * Goal 21. Weak Mutation 2: capstone.mobile.models.Trap.<init>(IIDDZ)V:32 - InsertUnaryOp IINC 1 lineId
   * Goal 22. Weak Mutation 3: capstone.mobile.models.Trap.<init>(IIDDZ)V:32 - InsertUnaryOp IINC -1 lineId
   * Goal 23. Weak Mutation 4: capstone.mobile.models.Trap.<init>(IIDDZ)V:33 - ReplaceVariable number -> lineId
   * Goal 24. Weak Mutation 5: capstone.mobile.models.Trap.<init>(IIDDZ)V:33 - InsertUnaryOp Negation of number
   * Goal 25. Weak Mutation 6: capstone.mobile.models.Trap.<init>(IIDDZ)V:33 - InsertUnaryOp IINC 1 number
   * Goal 26. Weak Mutation 7: capstone.mobile.models.Trap.<init>(IIDDZ)V:33 - InsertUnaryOp IINC -1 number
   * Goal 27. Weak Mutation 8: capstone.mobile.models.Trap.<init>(IIDDZ)V:34 - ReplaceVariable latitude -> longitude
   * Goal 28. Weak Mutation 9: capstone.mobile.models.Trap.<init>(IIDDZ)V:34 - InsertUnaryOp Negation of latitude
   * Goal 29. Weak Mutation 10: capstone.mobile.models.Trap.<init>(IIDDZ)V:35 - ReplaceVariable longitude -> latitude
   * Goal 30. Weak Mutation 11: capstone.mobile.models.Trap.<init>(IIDDZ)V:35 - InsertUnaryOp Negation of longitude
   * Goal 31. Weak Mutation 12: capstone.mobile.models.Trap.<init>(IIDDZ)V:36 - InsertUnaryOp Negation of side
   * Goal 32. Weak Mutation 13: capstone.mobile.models.Trap.<init>(IIDDZ)V:36 - InsertUnaryOp IINC 1 side
   * Goal 33. Weak Mutation 14: capstone.mobile.models.Trap.<init>(IIDDZ)V:36 - InsertUnaryOp IINC -1 side
   * Goal 34. Weak Mutation 15: capstone.mobile.models.Trap.<init>(IIDDZ)V:37 - ReplaceConstant - 0 -> 1
   * Goal 35. Weak Mutation 16: capstone.mobile.models.Trap.<init>(IIDDZ)V:38 - ReplaceConstant - 0 -> 1
   * Goal 36. Weak Mutation 105: capstone.mobile.models.Trap.getLatitude()D:105 - InsertUnaryOp Negation
   */

    @Test(timeout = 4000)
    public void test08() throws Throwable {
        Trap   trap0   = new Trap(1798, 2710, 1084.6, (-141.0642), true);
        double double0 = trap0.getLatitude();
        assertTrue(trap0.getSide());
        assertEquals(2710, trap0.getNumber());
        assertEquals((-141.0642), trap0.getLongitude(), 0.01);
        assertEquals(1084.6, double0, 0.01);
        assertEquals(1798, trap0.getLineId());
        assertFalse(trap0.isBroken());
        assertFalse(trap0.isMoved());
    }

    //Test case number: 9
  /*
   * 19 covered goals:
   * Goal 1. capstone.mobile.models.Trap.getLatitude()D: root-Branch
   * Goal 2. capstone.mobile.models.Trap.<init>()V: root-Branch
   * Goal 3. capstone.mobile.models.Trap.setLatitude(D)V: root-Branch
   * Goal 4. Branch capstone.mobile.models.Trap.getLatitude()D: root-Branch in context: capstone.mobile.models.Trap:getLatitude()D
   * Goal 5. Branch capstone.mobile.models.Trap.setLatitude(D)V: root-Branch in context: capstone.mobile.models.Trap:setLatitude(D)V
   * Goal 6. Branch capstone.mobile.models.Trap.<init>()V: root-Branch in context: capstone.mobile.models.Trap:<init>()V
   * Goal 7. [Output]: capstone.mobile.models.Trap.getLatitude()D:Negative
   * Goal 8. capstone.mobile.models.Trap.<init>()V: Line 20
   * Goal 9. capstone.mobile.models.Trap.getLatitude()D: Line 105
   * Goal 10. capstone.mobile.models.Trap.setLatitude(D)V: Line 109
   * Goal 11. capstone.mobile.models.Trap.setLatitude(D)V: Line 110
   * Goal 12. [METHOD] capstone.mobile.models.Trap.<init>()V
   * Goal 13. [METHOD] capstone.mobile.models.Trap.getLatitude()D
   * Goal 14. [METHOD] capstone.mobile.models.Trap.setLatitude(D)V
   * Goal 15. [METHODNOEX] capstone.mobile.models.Trap.<init>()V
   * Goal 16. [METHODNOEX] capstone.mobile.models.Trap.getLatitude()D
   * Goal 17. [METHODNOEX] capstone.mobile.models.Trap.setLatitude(D)V
   * Goal 18. Weak Mutation 105: capstone.mobile.models.Trap.getLatitude()D:105 - InsertUnaryOp Negation
   * Goal 19. Weak Mutation 106: capstone.mobile.models.Trap.setLatitude(D)V:109 - InsertUnaryOp Negation of latitude
   */

    @Test(timeout = 4000)
    public void test09() throws Throwable {
        Trap trap0 = new Trap();
        trap0.setLatitude((-2348.884));
        double double0 = trap0.getLatitude();
        assertEquals((-2348.884), double0, 0.01);
    }

    //Test case number: 10
  /*
   * 83 covered goals:
   * Goal 1. capstone.mobile.models.Trap.getId()I: root-Branch
   * Goal 2. capstone.mobile.models.Trap.<init>(IIIDDIII)V: I34 Branch 1 IF_ICMPNE L59 - true
   * Goal 3. capstone.mobile.models.Trap.<init>(IIIDDIII)V: I46 Branch 2 IF_ICMPNE L60 - true
   * Goal 4. capstone.mobile.models.Trap.<init>(IIIDDIII)V: I58 Branch 3 IF_ICMPNE L61 - true
   * Goal 5. Branch capstone.mobile.models.Trap.getId()I: root-Branch in context: capstone.mobile.models.Trap:getId()I
   * Goal 6. Branch capstone.mobile.models.Trap.<init>(IIIDDIII)V: I34 Branch 1 IF_ICMPNE L59 - true in context: capstone.mobile.models.Trap:<init>(IIIDDIII)V
   * Goal 7. Branch capstone.mobile.models.Trap.<init>(IIIDDIII)V: I46 Branch 2 IF_ICMPNE L60 - true in context: capstone.mobile.models.Trap:<init>(IIIDDIII)V
   * Goal 8. Branch capstone.mobile.models.Trap.<init>(IIIDDIII)V: I58 Branch 3 IF_ICMPNE L61 - true in context: capstone.mobile.models.Trap:<init>(IIIDDIII)V
   * Goal 9. [Output]: capstone.mobile.models.Trap.getId()I:Positive
   * Goal 10. capstone.mobile.models.Trap.<init>(IIIDDIII)V: Line 54
   * Goal 11. capstone.mobile.models.Trap.<init>(IIIDDIII)V: Line 55
   * Goal 12. capstone.mobile.models.Trap.<init>(IIIDDIII)V: Line 56
   * Goal 13. capstone.mobile.models.Trap.<init>(IIIDDIII)V: Line 57
   * Goal 14. capstone.mobile.models.Trap.<init>(IIIDDIII)V: Line 58
   * Goal 15. capstone.mobile.models.Trap.<init>(IIIDDIII)V: Line 59
   * Goal 16. capstone.mobile.models.Trap.<init>(IIIDDIII)V: Line 60
   * Goal 17. capstone.mobile.models.Trap.<init>(IIIDDIII)V: Line 61
   * Goal 18. capstone.mobile.models.Trap.<init>(IIIDDIII)V: Line 62
   * Goal 19. capstone.mobile.models.Trap.getId()I: Line 65
   * Goal 20. [METHOD] capstone.mobile.models.Trap.<init>(IIIDDIII)V
   * Goal 21. [METHOD] capstone.mobile.models.Trap.getId()I
   * Goal 22. [METHODNOEX] capstone.mobile.models.Trap.<init>(IIIDDIII)V
   * Goal 23. [METHODNOEX] capstone.mobile.models.Trap.getId()I
   * Goal 24. Weak Mutation 17: capstone.mobile.models.Trap.<init>(IIIDDIII)V:54 - ReplaceVariable id -> broken
   * Goal 25. Weak Mutation 18: capstone.mobile.models.Trap.<init>(IIIDDIII)V:54 - ReplaceVariable id -> number
   * Goal 26. Weak Mutation 20: capstone.mobile.models.Trap.<init>(IIIDDIII)V:54 - ReplaceVariable id -> side
   * Goal 27. Weak Mutation 21: capstone.mobile.models.Trap.<init>(IIIDDIII)V:54 - ReplaceVariable id -> moved
   * Goal 28. Weak Mutation 22: capstone.mobile.models.Trap.<init>(IIIDDIII)V:54 - InsertUnaryOp Negation of id
   * Goal 29. Weak Mutation 23: capstone.mobile.models.Trap.<init>(IIIDDIII)V:54 - InsertUnaryOp IINC 1 id
   * Goal 30. Weak Mutation 24: capstone.mobile.models.Trap.<init>(IIIDDIII)V:54 - InsertUnaryOp IINC -1 id
   * Goal 31. Weak Mutation 25: capstone.mobile.models.Trap.<init>(IIIDDIII)V:55 - ReplaceVariable lineId -> broken
   * Goal 32. Weak Mutation 26: capstone.mobile.models.Trap.<init>(IIIDDIII)V:55 - ReplaceVariable lineId -> number
   * Goal 33. Weak Mutation 27: capstone.mobile.models.Trap.<init>(IIIDDIII)V:55 - ReplaceVariable lineId -> side
   * Goal 34. Weak Mutation 29: capstone.mobile.models.Trap.<init>(IIIDDIII)V:55 - ReplaceVariable lineId -> moved
   * Goal 35. Weak Mutation 30: capstone.mobile.models.Trap.<init>(IIIDDIII)V:55 - InsertUnaryOp Negation of lineId
   * Goal 36. Weak Mutation 31: capstone.mobile.models.Trap.<init>(IIIDDIII)V:55 - InsertUnaryOp IINC 1 lineId
   * Goal 37. Weak Mutation 32: capstone.mobile.models.Trap.<init>(IIIDDIII)V:55 - InsertUnaryOp IINC -1 lineId
   * Goal 38. Weak Mutation 34: capstone.mobile.models.Trap.<init>(IIIDDIII)V:56 - ReplaceVariable number -> lineId
   * Goal 39. Weak Mutation 35: capstone.mobile.models.Trap.<init>(IIIDDIII)V:56 - ReplaceVariable number -> side
   * Goal 40. Weak Mutation 36: capstone.mobile.models.Trap.<init>(IIIDDIII)V:56 - ReplaceVariable number -> id
   * Goal 41. Weak Mutation 37: capstone.mobile.models.Trap.<init>(IIIDDIII)V:56 - ReplaceVariable number -> moved
   * Goal 42. Weak Mutation 38: capstone.mobile.models.Trap.<init>(IIIDDIII)V:56 - InsertUnaryOp Negation of number
   * Goal 43. Weak Mutation 39: capstone.mobile.models.Trap.<init>(IIIDDIII)V:56 - InsertUnaryOp IINC 1 number
   * Goal 44. Weak Mutation 40: capstone.mobile.models.Trap.<init>(IIIDDIII)V:56 - InsertUnaryOp IINC -1 number
   * Goal 45. Weak Mutation 41: capstone.mobile.models.Trap.<init>(IIIDDIII)V:57 - ReplaceVariable latitude -> longitude
   * Goal 46. Weak Mutation 42: capstone.mobile.models.Trap.<init>(IIIDDIII)V:57 - InsertUnaryOp Negation of latitude
   * Goal 47. Weak Mutation 43: capstone.mobile.models.Trap.<init>(IIIDDIII)V:58 - ReplaceVariable longitude -> latitude
   * Goal 48. Weak Mutation 44: capstone.mobile.models.Trap.<init>(IIIDDIII)V:58 - InsertUnaryOp Negation of longitude
   * Goal 49. Weak Mutation 45: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - ReplaceVariable side -> broken
   * Goal 50. Weak Mutation 46: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - ReplaceVariable side -> number
   * Goal 51. Weak Mutation 47: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - ReplaceVariable side -> lineId
   * Goal 52. Weak Mutation 48: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - ReplaceVariable side -> id
   * Goal 53. Weak Mutation 49: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - ReplaceVariable side -> moved
   * Goal 54. Weak Mutation 50: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - InsertUnaryOp Negation of side
   * Goal 55. Weak Mutation 51: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - InsertUnaryOp IINC 1 side
   * Goal 56. Weak Mutation 52: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - InsertUnaryOp IINC -1 side
   * Goal 57. Weak Mutation 53: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - ReplaceConstant - 1 -> 0
   * Goal 58. Weak Mutation 54: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - ReplaceComparisonOperator != -> ==
   * Goal 59. Weak Mutation 56: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - ReplaceConstant - 0 -> 1
   * Goal 60. Weak Mutation 57: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - ReplaceVariable moved -> broken
   * Goal 61. Weak Mutation 58: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - ReplaceVariable moved -> number
   * Goal 62. Weak Mutation 59: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - ReplaceVariable moved -> lineId
   * Goal 63. Weak Mutation 60: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - ReplaceVariable moved -> side
   * Goal 64. Weak Mutation 61: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - ReplaceVariable moved -> id
   * Goal 65. Weak Mutation 62: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - InsertUnaryOp Negation of moved
   * Goal 66. Weak Mutation 63: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - InsertUnaryOp IINC 1 moved
   * Goal 67. Weak Mutation 64: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - InsertUnaryOp IINC -1 moved
   * Goal 68. Weak Mutation 65: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - ReplaceConstant - 1 -> 0
   * Goal 69. Weak Mutation 66: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - ReplaceComparisonOperator != -> ==
   * Goal 70. Weak Mutation 68: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - ReplaceConstant - 0 -> 1
   * Goal 71. Weak Mutation 70: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - ReplaceVariable broken -> lineId
   * Goal 72. Weak Mutation 71: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - ReplaceVariable broken -> side
   * Goal 73. Weak Mutation 72: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - ReplaceVariable broken -> id
   * Goal 74. Weak Mutation 73: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - ReplaceVariable broken -> moved
   * Goal 75. Weak Mutation 74: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - InsertUnaryOp Negation of broken
   * Goal 76. Weak Mutation 75: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - InsertUnaryOp IINC 1 broken
   * Goal 77. Weak Mutation 76: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - InsertUnaryOp IINC -1 broken
   * Goal 78. Weak Mutation 77: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - ReplaceConstant - 1 -> 0
   * Goal 79. Weak Mutation 78: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - ReplaceComparisonOperator != -> ==
   * Goal 80. Weak Mutation 80: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - ReplaceConstant - 0 -> 1
   * Goal 81. Weak Mutation 81: capstone.mobile.models.Trap.getId()I:65 - InsertUnaryOp Negation
   * Goal 82. Weak Mutation 82: capstone.mobile.models.Trap.getId()I:65 - InsertUnaryOp +1
   * Goal 83. Weak Mutation 83: capstone.mobile.models.Trap.getId()I:65 - InsertUnaryOp -1
   */

    @Test(timeout = 4000)
    public void test10() throws Throwable {
        Trap trap0 = new Trap(2465, 2465, 2010, (double) 2010, 0.0, 1414, 2010, 619);
        int  int0  = trap0.getId();
        assertFalse(trap0.getSide());
        assertEquals(2465, int0);
        assertEquals(2465, trap0.getLineId());
        assertFalse(trap0.isMoved());
        assertEquals(2010, trap0.getNumber());
        assertEquals(2010.0, trap0.getLatitude(), 0.01);
        assertEquals(0.0, trap0.getLongitude(), 0.01);
        assertFalse(trap0.isBroken());
    }

    //Test case number: 11
  /*
   * 79 covered goals:
   * Goal 1. capstone.mobile.models.Trap.getNumber()I: root-Branch
   * Goal 2. capstone.mobile.models.Trap.<init>(IIIDDIII)V: I34 Branch 1 IF_ICMPNE L59 - true
   * Goal 3. capstone.mobile.models.Trap.<init>(IIIDDIII)V: I46 Branch 2 IF_ICMPNE L60 - false
   * Goal 4. capstone.mobile.models.Trap.<init>(IIIDDIII)V: I58 Branch 3 IF_ICMPNE L61 - true
   * Goal 5. Branch capstone.mobile.models.Trap.getNumber()I: root-Branch in context: capstone.mobile.models.Trap:getNumber()I
   * Goal 6. Branch capstone.mobile.models.Trap.<init>(IIIDDIII)V: I34 Branch 1 IF_ICMPNE L59 - true in context: capstone.mobile.models.Trap:<init>(IIIDDIII)V
   * Goal 7. Branch capstone.mobile.models.Trap.<init>(IIIDDIII)V: I46 Branch 2 IF_ICMPNE L60 - false in context: capstone.mobile.models.Trap:<init>(IIIDDIII)V
   * Goal 8. Branch capstone.mobile.models.Trap.<init>(IIIDDIII)V: I58 Branch 3 IF_ICMPNE L61 - true in context: capstone.mobile.models.Trap:<init>(IIIDDIII)V
   * Goal 9. [Output]: capstone.mobile.models.Trap.getNumber()I:Positive
   * Goal 10. capstone.mobile.models.Trap.<init>(IIIDDIII)V: Line 54
   * Goal 11. capstone.mobile.models.Trap.<init>(IIIDDIII)V: Line 55
   * Goal 12. capstone.mobile.models.Trap.<init>(IIIDDIII)V: Line 56
   * Goal 13. capstone.mobile.models.Trap.<init>(IIIDDIII)V: Line 57
   * Goal 14. capstone.mobile.models.Trap.<init>(IIIDDIII)V: Line 58
   * Goal 15. capstone.mobile.models.Trap.<init>(IIIDDIII)V: Line 59
   * Goal 16. capstone.mobile.models.Trap.<init>(IIIDDIII)V: Line 60
   * Goal 17. capstone.mobile.models.Trap.<init>(IIIDDIII)V: Line 61
   * Goal 18. capstone.mobile.models.Trap.<init>(IIIDDIII)V: Line 62
   * Goal 19. capstone.mobile.models.Trap.getNumber()I: Line 81
   * Goal 20. [METHOD] capstone.mobile.models.Trap.<init>(IIIDDIII)V
   * Goal 21. [METHOD] capstone.mobile.models.Trap.getNumber()I
   * Goal 22. [METHODNOEX] capstone.mobile.models.Trap.<init>(IIIDDIII)V
   * Goal 23. [METHODNOEX] capstone.mobile.models.Trap.getNumber()I
   * Goal 24. Weak Mutation 18: capstone.mobile.models.Trap.<init>(IIIDDIII)V:54 - ReplaceVariable id -> number
   * Goal 25. Weak Mutation 19: capstone.mobile.models.Trap.<init>(IIIDDIII)V:54 - ReplaceVariable id -> lineId
   * Goal 26. Weak Mutation 20: capstone.mobile.models.Trap.<init>(IIIDDIII)V:54 - ReplaceVariable id -> side
   * Goal 27. Weak Mutation 21: capstone.mobile.models.Trap.<init>(IIIDDIII)V:54 - ReplaceVariable id -> moved
   * Goal 28. Weak Mutation 22: capstone.mobile.models.Trap.<init>(IIIDDIII)V:54 - InsertUnaryOp Negation of id
   * Goal 29. Weak Mutation 23: capstone.mobile.models.Trap.<init>(IIIDDIII)V:54 - InsertUnaryOp IINC 1 id
   * Goal 30. Weak Mutation 24: capstone.mobile.models.Trap.<init>(IIIDDIII)V:54 - InsertUnaryOp IINC -1 id
   * Goal 31. Weak Mutation 25: capstone.mobile.models.Trap.<init>(IIIDDIII)V:55 - ReplaceVariable lineId -> broken
   * Goal 32. Weak Mutation 27: capstone.mobile.models.Trap.<init>(IIIDDIII)V:55 - ReplaceVariable lineId -> side
   * Goal 33. Weak Mutation 28: capstone.mobile.models.Trap.<init>(IIIDDIII)V:55 - ReplaceVariable lineId -> id
   * Goal 34. Weak Mutation 30: capstone.mobile.models.Trap.<init>(IIIDDIII)V:55 - InsertUnaryOp Negation of lineId
   * Goal 35. Weak Mutation 31: capstone.mobile.models.Trap.<init>(IIIDDIII)V:55 - InsertUnaryOp IINC 1 lineId
   * Goal 36. Weak Mutation 32: capstone.mobile.models.Trap.<init>(IIIDDIII)V:55 - InsertUnaryOp IINC -1 lineId
   * Goal 37. Weak Mutation 33: capstone.mobile.models.Trap.<init>(IIIDDIII)V:56 - ReplaceVariable number -> broken
   * Goal 38. Weak Mutation 35: capstone.mobile.models.Trap.<init>(IIIDDIII)V:56 - ReplaceVariable number -> side
   * Goal 39. Weak Mutation 36: capstone.mobile.models.Trap.<init>(IIIDDIII)V:56 - ReplaceVariable number -> id
   * Goal 40. Weak Mutation 38: capstone.mobile.models.Trap.<init>(IIIDDIII)V:56 - InsertUnaryOp Negation of number
   * Goal 41. Weak Mutation 39: capstone.mobile.models.Trap.<init>(IIIDDIII)V:56 - InsertUnaryOp IINC 1 number
   * Goal 42. Weak Mutation 40: capstone.mobile.models.Trap.<init>(IIIDDIII)V:56 - InsertUnaryOp IINC -1 number
   * Goal 43. Weak Mutation 41: capstone.mobile.models.Trap.<init>(IIIDDIII)V:57 - ReplaceVariable latitude -> longitude
   * Goal 44. Weak Mutation 42: capstone.mobile.models.Trap.<init>(IIIDDIII)V:57 - InsertUnaryOp Negation of latitude
   * Goal 45. Weak Mutation 43: capstone.mobile.models.Trap.<init>(IIIDDIII)V:58 - ReplaceVariable longitude -> latitude
   * Goal 46. Weak Mutation 44: capstone.mobile.models.Trap.<init>(IIIDDIII)V:58 - InsertUnaryOp Negation of longitude
   * Goal 47. Weak Mutation 45: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - ReplaceVariable side -> broken
   * Goal 48. Weak Mutation 46: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - ReplaceVariable side -> number
   * Goal 49. Weak Mutation 47: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - ReplaceVariable side -> lineId
   * Goal 50. Weak Mutation 48: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - ReplaceVariable side -> id
   * Goal 51. Weak Mutation 49: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - ReplaceVariable side -> moved
   * Goal 52. Weak Mutation 50: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - InsertUnaryOp Negation of side
   * Goal 53. Weak Mutation 51: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - InsertUnaryOp IINC 1 side
   * Goal 54. Weak Mutation 52: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - InsertUnaryOp IINC -1 side
   * Goal 55. Weak Mutation 53: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - ReplaceConstant - 1 -> 0
   * Goal 56. Weak Mutation 54: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - ReplaceComparisonOperator != -> ==
   * Goal 57. Weak Mutation 56: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - ReplaceConstant - 0 -> 1
   * Goal 58. Weak Mutation 57: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - ReplaceVariable moved -> broken
   * Goal 59. Weak Mutation 60: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - ReplaceVariable moved -> side
   * Goal 60. Weak Mutation 61: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - ReplaceVariable moved -> id
   * Goal 61. Weak Mutation 62: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - InsertUnaryOp Negation of moved
   * Goal 62. Weak Mutation 63: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - InsertUnaryOp IINC 1 moved
   * Goal 63. Weak Mutation 64: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - InsertUnaryOp IINC -1 moved
   * Goal 64. Weak Mutation 65: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - ReplaceConstant - 1 -> 0
   * Goal 65. Weak Mutation 66: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - ReplaceComparisonOperator != -> ==
   * Goal 66. Weak Mutation 67: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - ReplaceConstant - 1 -> 0
   * Goal 67. Weak Mutation 69: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - ReplaceVariable broken -> number
   * Goal 68. Weak Mutation 70: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - ReplaceVariable broken -> lineId
   * Goal 69. Weak Mutation 71: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - ReplaceVariable broken -> side
   * Goal 70. Weak Mutation 73: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - ReplaceVariable broken -> moved
   * Goal 71. Weak Mutation 74: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - InsertUnaryOp Negation of broken
   * Goal 72. Weak Mutation 75: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - InsertUnaryOp IINC 1 broken
   * Goal 73. Weak Mutation 76: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - InsertUnaryOp IINC -1 broken
   * Goal 74. Weak Mutation 77: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - ReplaceConstant - 1 -> 0
   * Goal 75. Weak Mutation 78: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - ReplaceComparisonOperator != -> ==
   * Goal 76. Weak Mutation 80: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - ReplaceConstant - 0 -> 1
   * Goal 77. Weak Mutation 93: capstone.mobile.models.Trap.getNumber()I:81 - InsertUnaryOp Negation
   * Goal 78. Weak Mutation 94: capstone.mobile.models.Trap.getNumber()I:81 - InsertUnaryOp +1
   * Goal 79. Weak Mutation 95: capstone.mobile.models.Trap.getNumber()I:81 - InsertUnaryOp -1
   */

    @Test(timeout = 4000)
    public void test11() throws Throwable {
        Trap trap0 = new Trap((-1), 1, 1, 1, (-1), 1109, (-1), 1);
        int  int0  = trap0.getNumber();
        assertEquals(1, int0);
        assertEquals((-1.0), trap0.getLongitude(), 0.01);
        assertFalse(trap0.isBroken());
        assertEquals(1.0, trap0.getLatitude(), 0.01);
        assertTrue(trap0.isMoved());
        assertEquals(1, trap0.getLineId());
        assertEquals(-1, trap0.getId());
        assertFalse(trap0.getSide());
    }

    //Test case number: 12
  /*
   * 68 covered goals:
   * Goal 1. capstone.mobile.models.Trap.<init>(IIIDDIII)V: I34 Branch 1 IF_ICMPNE L59 - false
   * Goal 2. capstone.mobile.models.Trap.<init>(IIIDDIII)V: I46 Branch 2 IF_ICMPNE L60 - true
   * Goal 3. capstone.mobile.models.Trap.<init>(IIIDDIII)V: I58 Branch 3 IF_ICMPNE L61 - false
   * Goal 4. Branch capstone.mobile.models.Trap.<init>(IIIDDIII)V: I34 Branch 1 IF_ICMPNE L59 - false in context: capstone.mobile.models.Trap:<init>(IIIDDIII)V
   * Goal 5. Branch capstone.mobile.models.Trap.<init>(IIIDDIII)V: I46 Branch 2 IF_ICMPNE L60 - true in context: capstone.mobile.models.Trap:<init>(IIIDDIII)V
   * Goal 6. Branch capstone.mobile.models.Trap.<init>(IIIDDIII)V: I58 Branch 3 IF_ICMPNE L61 - false in context: capstone.mobile.models.Trap:<init>(IIIDDIII)V
   * Goal 7. capstone.mobile.models.Trap.<init>(IIIDDIII)V: Line 54
   * Goal 8. capstone.mobile.models.Trap.<init>(IIIDDIII)V: Line 55
   * Goal 9. capstone.mobile.models.Trap.<init>(IIIDDIII)V: Line 56
   * Goal 10. capstone.mobile.models.Trap.<init>(IIIDDIII)V: Line 57
   * Goal 11. capstone.mobile.models.Trap.<init>(IIIDDIII)V: Line 58
   * Goal 12. capstone.mobile.models.Trap.<init>(IIIDDIII)V: Line 59
   * Goal 13. capstone.mobile.models.Trap.<init>(IIIDDIII)V: Line 60
   * Goal 14. capstone.mobile.models.Trap.<init>(IIIDDIII)V: Line 61
   * Goal 15. capstone.mobile.models.Trap.<init>(IIIDDIII)V: Line 62
   * Goal 16. [METHOD] capstone.mobile.models.Trap.<init>(IIIDDIII)V
   * Goal 17. [METHODNOEX] capstone.mobile.models.Trap.<init>(IIIDDIII)V
   * Goal 18. Weak Mutation 17: capstone.mobile.models.Trap.<init>(IIIDDIII)V:54 - ReplaceVariable id -> broken
   * Goal 19. Weak Mutation 19: capstone.mobile.models.Trap.<init>(IIIDDIII)V:54 - ReplaceVariable id -> lineId
   * Goal 20. Weak Mutation 20: capstone.mobile.models.Trap.<init>(IIIDDIII)V:54 - ReplaceVariable id -> side
   * Goal 21. Weak Mutation 22: capstone.mobile.models.Trap.<init>(IIIDDIII)V:54 - InsertUnaryOp Negation of id
   * Goal 22. Weak Mutation 23: capstone.mobile.models.Trap.<init>(IIIDDIII)V:54 - InsertUnaryOp IINC 1 id
   * Goal 23. Weak Mutation 24: capstone.mobile.models.Trap.<init>(IIIDDIII)V:54 - InsertUnaryOp IINC -1 id
   * Goal 24. Weak Mutation 25: capstone.mobile.models.Trap.<init>(IIIDDIII)V:55 - ReplaceVariable lineId -> broken
   * Goal 25. Weak Mutation 26: capstone.mobile.models.Trap.<init>(IIIDDIII)V:55 - ReplaceVariable lineId -> number
   * Goal 26. Weak Mutation 27: capstone.mobile.models.Trap.<init>(IIIDDIII)V:55 - ReplaceVariable lineId -> side
   * Goal 27. Weak Mutation 28: capstone.mobile.models.Trap.<init>(IIIDDIII)V:55 - ReplaceVariable lineId -> id
   * Goal 28. Weak Mutation 29: capstone.mobile.models.Trap.<init>(IIIDDIII)V:55 - ReplaceVariable lineId -> moved
   * Goal 29. Weak Mutation 30: capstone.mobile.models.Trap.<init>(IIIDDIII)V:55 - InsertUnaryOp Negation of lineId
   * Goal 30. Weak Mutation 31: capstone.mobile.models.Trap.<init>(IIIDDIII)V:55 - InsertUnaryOp IINC 1 lineId
   * Goal 31. Weak Mutation 32: capstone.mobile.models.Trap.<init>(IIIDDIII)V:55 - InsertUnaryOp IINC -1 lineId
   * Goal 32. Weak Mutation 33: capstone.mobile.models.Trap.<init>(IIIDDIII)V:56 - ReplaceVariable number -> broken
   * Goal 33. Weak Mutation 34: capstone.mobile.models.Trap.<init>(IIIDDIII)V:56 - ReplaceVariable number -> lineId
   * Goal 34. Weak Mutation 35: capstone.mobile.models.Trap.<init>(IIIDDIII)V:56 - ReplaceVariable number -> side
   * Goal 35. Weak Mutation 38: capstone.mobile.models.Trap.<init>(IIIDDIII)V:56 - InsertUnaryOp Negation of number
   * Goal 36. Weak Mutation 39: capstone.mobile.models.Trap.<init>(IIIDDIII)V:56 - InsertUnaryOp IINC 1 number
   * Goal 37. Weak Mutation 40: capstone.mobile.models.Trap.<init>(IIIDDIII)V:56 - InsertUnaryOp IINC -1 number
   * Goal 38. Weak Mutation 42: capstone.mobile.models.Trap.<init>(IIIDDIII)V:57 - InsertUnaryOp Negation of latitude
   * Goal 39. Weak Mutation 44: capstone.mobile.models.Trap.<init>(IIIDDIII)V:58 - InsertUnaryOp Negation of longitude
   * Goal 40. Weak Mutation 46: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - ReplaceVariable side -> number
   * Goal 41. Weak Mutation 47: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - ReplaceVariable side -> lineId
   * Goal 42. Weak Mutation 48: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - ReplaceVariable side -> id
   * Goal 43. Weak Mutation 49: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - ReplaceVariable side -> moved
   * Goal 44. Weak Mutation 50: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - InsertUnaryOp Negation of side
   * Goal 45. Weak Mutation 51: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - InsertUnaryOp IINC 1 side
   * Goal 46. Weak Mutation 52: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - InsertUnaryOp IINC -1 side
   * Goal 47. Weak Mutation 53: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - ReplaceConstant - 1 -> 0
   * Goal 48. Weak Mutation 54: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - ReplaceComparisonOperator != -> ==
   * Goal 49. Weak Mutation 55: capstone.mobile.models.Trap.<init>(IIIDDIII)V:59 - ReplaceConstant - 1 -> 0
   * Goal 50. Weak Mutation 57: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - ReplaceVariable moved -> broken
   * Goal 51. Weak Mutation 59: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - ReplaceVariable moved -> lineId
   * Goal 52. Weak Mutation 60: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - ReplaceVariable moved -> side
   * Goal 53. Weak Mutation 62: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - InsertUnaryOp Negation of moved
   * Goal 54. Weak Mutation 63: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - InsertUnaryOp IINC 1 moved
   * Goal 55. Weak Mutation 64: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - InsertUnaryOp IINC -1 moved
   * Goal 56. Weak Mutation 65: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - ReplaceConstant - 1 -> 0
   * Goal 57. Weak Mutation 66: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - ReplaceComparisonOperator != -> ==
   * Goal 58. Weak Mutation 68: capstone.mobile.models.Trap.<init>(IIIDDIII)V:60 - ReplaceConstant - 0 -> 1
   * Goal 59. Weak Mutation 69: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - ReplaceVariable broken -> number
   * Goal 60. Weak Mutation 70: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - ReplaceVariable broken -> lineId
   * Goal 61. Weak Mutation 72: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - ReplaceVariable broken -> id
   * Goal 62. Weak Mutation 73: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - ReplaceVariable broken -> moved
   * Goal 63. Weak Mutation 74: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - InsertUnaryOp Negation of broken
   * Goal 64. Weak Mutation 75: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - InsertUnaryOp IINC 1 broken
   * Goal 65. Weak Mutation 76: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - InsertUnaryOp IINC -1 broken
   * Goal 66. Weak Mutation 77: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - ReplaceConstant - 1 -> 0
   * Goal 67. Weak Mutation 78: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - ReplaceComparisonOperator != -> ==
   * Goal 68. Weak Mutation 79: capstone.mobile.models.Trap.<init>(IIIDDIII)V:61 - ReplaceConstant - 1 -> 0
   */

    @Test(timeout = 4000)
    public void test12() throws Throwable {
        Trap trap0 = new Trap(0, 1600, 0, 0, 0, 1, 1, 0);
        assertTrue(trap0.getSide());
        assertEquals(1600, trap0.getLineId());
        assertFalse(trap0.isMoved());
        assertTrue(trap0.isBroken());
        assertEquals(0, trap0.getNumber());
        assertEquals(0, trap0.getId());
    }

    //Test case number: 13
  /*
   * 32 covered goals:
   * Goal 1. capstone.mobile.models.Trap.<init>(IIDDZ)V: root-Branch
   * Goal 2. capstone.mobile.models.Trap.getSide()Z: root-Branch
   * Goal 3. Branch capstone.mobile.models.Trap.<init>(IIDDZ)V: root-Branch in context: capstone.mobile.models.Trap:<init>(IIDDZ)V
   * Goal 4. Branch capstone.mobile.models.Trap.getSide()Z: root-Branch in context: capstone.mobile.models.Trap:getSide()Z
   * Goal 5. [Output]: capstone.mobile.models.Trap.getSide()Z:True
   * Goal 6. capstone.mobile.models.Trap.<init>(IIDDZ)V: Line 32
   * Goal 7. capstone.mobile.models.Trap.<init>(IIDDZ)V: Line 33
   * Goal 8. capstone.mobile.models.Trap.<init>(IIDDZ)V: Line 34
   * Goal 9. capstone.mobile.models.Trap.<init>(IIDDZ)V: Line 35
   * Goal 10. capstone.mobile.models.Trap.<init>(IIDDZ)V: Line 36
   * Goal 11. capstone.mobile.models.Trap.<init>(IIDDZ)V: Line 37
   * Goal 12. capstone.mobile.models.Trap.<init>(IIDDZ)V: Line 38
   * Goal 13. capstone.mobile.models.Trap.<init>(IIDDZ)V: Line 39
   * Goal 14. capstone.mobile.models.Trap.getSide()Z: Line 89
   * Goal 15. [METHOD] capstone.mobile.models.Trap.<init>(IIDDZ)V
   * Goal 16. [METHOD] capstone.mobile.models.Trap.getSide()Z
   * Goal 17. [METHODNOEX] capstone.mobile.models.Trap.<init>(IIDDZ)V
   * Goal 18. [METHODNOEX] capstone.mobile.models.Trap.getSide()Z
   * Goal 19. Weak Mutation 1: capstone.mobile.models.Trap.<init>(IIDDZ)V:32 - InsertUnaryOp Negation of lineId
   * Goal 20. Weak Mutation 2: capstone.mobile.models.Trap.<init>(IIDDZ)V:32 - InsertUnaryOp IINC 1 lineId
   * Goal 21. Weak Mutation 3: capstone.mobile.models.Trap.<init>(IIDDZ)V:32 - InsertUnaryOp IINC -1 lineId
   * Goal 22. Weak Mutation 5: capstone.mobile.models.Trap.<init>(IIDDZ)V:33 - InsertUnaryOp Negation of number
   * Goal 23. Weak Mutation 6: capstone.mobile.models.Trap.<init>(IIDDZ)V:33 - InsertUnaryOp IINC 1 number
   * Goal 24. Weak Mutation 7: capstone.mobile.models.Trap.<init>(IIDDZ)V:33 - InsertUnaryOp IINC -1 number
   * Goal 25. Weak Mutation 9: capstone.mobile.models.Trap.<init>(IIDDZ)V:34 - InsertUnaryOp Negation of latitude
   * Goal 26. Weak Mutation 11: capstone.mobile.models.Trap.<init>(IIDDZ)V:35 - InsertUnaryOp Negation of longitude
   * Goal 27. Weak Mutation 12: capstone.mobile.models.Trap.<init>(IIDDZ)V:36 - InsertUnaryOp Negation of side
   * Goal 28. Weak Mutation 13: capstone.mobile.models.Trap.<init>(IIDDZ)V:36 - InsertUnaryOp IINC 1 side
   * Goal 29. Weak Mutation 14: capstone.mobile.models.Trap.<init>(IIDDZ)V:36 - InsertUnaryOp IINC -1 side
   * Goal 30. Weak Mutation 15: capstone.mobile.models.Trap.<init>(IIDDZ)V:37 - ReplaceConstant - 0 -> 1
   * Goal 31. Weak Mutation 16: capstone.mobile.models.Trap.<init>(IIDDZ)V:38 - ReplaceConstant - 0 -> 1
   * Goal 32. Weak Mutation 99: capstone.mobile.models.Trap.getSide()Z:89 - InsertUnaryOp Negation
   */

    @Test(timeout = 4000)
    public void test13() throws Throwable {
        Trap    trap0    = new Trap(0, 0, 3649.47763648049, 3649.47763648049, true);
        boolean boolean0 = trap0.getSide();
        assertEquals(3649.47763648049, trap0.getLongitude(), 0.01);
        assertEquals(3649.47763648049, trap0.getLatitude(), 0.01);
        assertEquals(0, trap0.getLineId());
        assertEquals(0, trap0.getNumber());
        assertTrue(boolean0);
        assertFalse(trap0.isMoved());
        assertFalse(trap0.isBroken());
    }

    //Test case number: 14
  /*
   * 14 covered goals:
   * Goal 1. capstone.mobile.models.Trap.<init>()V: root-Branch
   * Goal 2. capstone.mobile.models.Trap.getNumber()I: root-Branch
   * Goal 3. Branch capstone.mobile.models.Trap.getNumber()I: root-Branch in context: capstone.mobile.models.Trap:getNumber()I
   * Goal 4. Branch capstone.mobile.models.Trap.<init>()V: root-Branch in context: capstone.mobile.models.Trap:<init>()V
   * Goal 5. [Output]: capstone.mobile.models.Trap.getNumber()I:Zero
   * Goal 6. capstone.mobile.models.Trap.<init>()V: Line 20
   * Goal 7. capstone.mobile.models.Trap.getNumber()I: Line 81
   * Goal 8. [METHOD] capstone.mobile.models.Trap.<init>()V
   * Goal 9. [METHOD] capstone.mobile.models.Trap.getNumber()I
   * Goal 10. [METHODNOEX] capstone.mobile.models.Trap.<init>()V
   * Goal 11. [METHODNOEX] capstone.mobile.models.Trap.getNumber()I
   * Goal 12. Weak Mutation 93: capstone.mobile.models.Trap.getNumber()I:81 - InsertUnaryOp Negation
   * Goal 13. Weak Mutation 94: capstone.mobile.models.Trap.getNumber()I:81 - InsertUnaryOp +1
   * Goal 14. Weak Mutation 95: capstone.mobile.models.Trap.getNumber()I:81 - InsertUnaryOp -1
   */

    @Test(timeout = 4000)
    public void test14() throws Throwable {
        Trap trap0 = new Trap();
        int  int0  = trap0.getNumber();
        assertEquals(0, int0);
    }

    //Test case number: 15
  /*
   * 12 covered goals:
   * Goal 1. capstone.mobile.models.Trap.<init>()V: root-Branch
   * Goal 2. capstone.mobile.models.Trap.getLongitude()D: root-Branch
   * Goal 3. Branch capstone.mobile.models.Trap.<init>()V: root-Branch in context: capstone.mobile.models.Trap:<init>()V
   * Goal 4. Branch capstone.mobile.models.Trap.getLongitude()D: root-Branch in context: capstone.mobile.models.Trap:getLongitude()D
   * Goal 5. [Output]: capstone.mobile.models.Trap.getLongitude()D:Zero
   * Goal 6. capstone.mobile.models.Trap.<init>()V: Line 20
   * Goal 7. capstone.mobile.models.Trap.getLongitude()D: Line 97
   * Goal 8. [METHOD] capstone.mobile.models.Trap.<init>()V
   * Goal 9. [METHOD] capstone.mobile.models.Trap.getLongitude()D
   * Goal 10. [METHODNOEX] capstone.mobile.models.Trap.<init>()V
   * Goal 11. [METHODNOEX] capstone.mobile.models.Trap.getLongitude()D
   * Goal 12. Weak Mutation 103: capstone.mobile.models.Trap.getLongitude()D:97 - InsertUnaryOp Negation
   */

    @Test(timeout = 4000)
    public void test15() throws Throwable {
        Trap   trap0   = new Trap();
        double double0 = trap0.getLongitude();
        assertEquals(0.0, double0, 0.01);
    }

    //Test case number: 16
  /*
   * 14 covered goals:
   * Goal 1. capstone.mobile.models.Trap.<init>()V: root-Branch
   * Goal 2. capstone.mobile.models.Trap.getLineId()I: root-Branch
   * Goal 3. Branch capstone.mobile.models.Trap.getLineId()I: root-Branch in context: capstone.mobile.models.Trap:getLineId()I
   * Goal 4. Branch capstone.mobile.models.Trap.<init>()V: root-Branch in context: capstone.mobile.models.Trap:<init>()V
   * Goal 5. [Output]: capstone.mobile.models.Trap.getLineId()I:Zero
   * Goal 6. capstone.mobile.models.Trap.<init>()V: Line 20
   * Goal 7. capstone.mobile.models.Trap.getLineId()I: Line 73
   * Goal 8. [METHOD] capstone.mobile.models.Trap.<init>()V
   * Goal 9. [METHOD] capstone.mobile.models.Trap.getLineId()I
   * Goal 10. [METHODNOEX] capstone.mobile.models.Trap.<init>()V
   * Goal 11. [METHODNOEX] capstone.mobile.models.Trap.getLineId()I
   * Goal 12. Weak Mutation 87: capstone.mobile.models.Trap.getLineId()I:73 - InsertUnaryOp Negation
   * Goal 13. Weak Mutation 88: capstone.mobile.models.Trap.getLineId()I:73 - InsertUnaryOp +1
   * Goal 14. Weak Mutation 89: capstone.mobile.models.Trap.getLineId()I:73 - InsertUnaryOp -1
   */

    @Test(timeout = 4000)
    public void test16() throws Throwable {
        Trap trap0 = new Trap();
        int  int0  = trap0.getLineId();
        assertEquals(0, int0);
    }

    //Test case number: 17
  /*
   * 23 covered goals:
   * Goal 1. capstone.mobile.models.Trap.getId()I: root-Branch
   * Goal 2. capstone.mobile.models.Trap.<init>()V: root-Branch
   * Goal 3. capstone.mobile.models.Trap.setId(I)V: root-Branch
   * Goal 4. Branch capstone.mobile.models.Trap.getId()I: root-Branch in context: capstone.mobile.models.Trap:getId()I
   * Goal 5. Branch capstone.mobile.models.Trap.setId(I)V: root-Branch in context: capstone.mobile.models.Trap:setId(I)V
   * Goal 6. Branch capstone.mobile.models.Trap.<init>()V: root-Branch in context: capstone.mobile.models.Trap:<init>()V
   * Goal 7. [Output]: capstone.mobile.models.Trap.getId()I:Negative
   * Goal 8. capstone.mobile.models.Trap.<init>()V: Line 20
   * Goal 9. capstone.mobile.models.Trap.getId()I: Line 65
   * Goal 10. capstone.mobile.models.Trap.setId(I)V: Line 69
   * Goal 11. capstone.mobile.models.Trap.setId(I)V: Line 70
   * Goal 12. [METHOD] capstone.mobile.models.Trap.<init>()V
   * Goal 13. [METHOD] capstone.mobile.models.Trap.getId()I
   * Goal 14. [METHOD] capstone.mobile.models.Trap.setId(I)V
   * Goal 15. [METHODNOEX] capstone.mobile.models.Trap.<init>()V
   * Goal 16. [METHODNOEX] capstone.mobile.models.Trap.getId()I
   * Goal 17. [METHODNOEX] capstone.mobile.models.Trap.setId(I)V
   * Goal 18. Weak Mutation 81: capstone.mobile.models.Trap.getId()I:65 - InsertUnaryOp Negation
   * Goal 19. Weak Mutation 82: capstone.mobile.models.Trap.getId()I:65 - InsertUnaryOp +1
   * Goal 20. Weak Mutation 83: capstone.mobile.models.Trap.getId()I:65 - InsertUnaryOp -1
   * Goal 21. Weak Mutation 84: capstone.mobile.models.Trap.setId(I)V:69 - InsertUnaryOp Negation of id
   * Goal 22. Weak Mutation 85: capstone.mobile.models.Trap.setId(I)V:69 - InsertUnaryOp IINC 1 id
   * Goal 23. Weak Mutation 86: capstone.mobile.models.Trap.setId(I)V:69 - InsertUnaryOp IINC -1 id
   */

    @Test(timeout = 4000)
    public void test17() throws Throwable {
        Trap trap0 = new Trap();
        trap0.setId((-1));
        int int0 = trap0.getId();
        assertEquals((-1), int0);
    }

    //Test case number: 18
  /*
   * 12 covered goals:
   * Goal 1. capstone.mobile.models.Trap.<init>()V: root-Branch
   * Goal 2. capstone.mobile.models.Trap.isBroken()Z: root-Branch
   * Goal 3. Branch capstone.mobile.models.Trap.isBroken()Z: root-Branch in context: capstone.mobile.models.Trap:isBroken()Z
   * Goal 4. Branch capstone.mobile.models.Trap.<init>()V: root-Branch in context: capstone.mobile.models.Trap:<init>()V
   * Goal 5. [Output]: capstone.mobile.models.Trap.isBroken()Z:False
   * Goal 6. capstone.mobile.models.Trap.<init>()V: Line 20
   * Goal 7. capstone.mobile.models.Trap.isBroken()Z: Line 113
   * Goal 8. [METHOD] capstone.mobile.models.Trap.<init>()V
   * Goal 9. [METHOD] capstone.mobile.models.Trap.isBroken()Z
   * Goal 10. [METHODNOEX] capstone.mobile.models.Trap.<init>()V
   * Goal 11. [METHODNOEX] capstone.mobile.models.Trap.isBroken()Z
   * Goal 12. Weak Mutation 107: capstone.mobile.models.Trap.isBroken()Z:113 - InsertUnaryOp Negation
   */

    @Test(timeout = 4000)
    public void test18() throws Throwable {
        Trap    trap0    = new Trap();
        boolean boolean0 = trap0.isBroken();
        assertFalse(boolean0);
    }

    //Test case number: 19
  /*
   * 12 covered goals:
   * Goal 1. capstone.mobile.models.Trap.<init>()V: root-Branch
   * Goal 2. capstone.mobile.models.Trap.setLongitude(D)V: root-Branch
   * Goal 3. Branch capstone.mobile.models.Trap.setLongitude(D)V: root-Branch in context: capstone.mobile.models.Trap:setLongitude(D)V
   * Goal 4. Branch capstone.mobile.models.Trap.<init>()V: root-Branch in context: capstone.mobile.models.Trap:<init>()V
   * Goal 5. capstone.mobile.models.Trap.<init>()V: Line 20
   * Goal 6. capstone.mobile.models.Trap.setLongitude(D)V: Line 101
   * Goal 7. capstone.mobile.models.Trap.setLongitude(D)V: Line 102
   * Goal 8. [METHOD] capstone.mobile.models.Trap.<init>()V
   * Goal 9. [METHOD] capstone.mobile.models.Trap.setLongitude(D)V
   * Goal 10. [METHODNOEX] capstone.mobile.models.Trap.<init>()V
   * Goal 11. [METHODNOEX] capstone.mobile.models.Trap.setLongitude(D)V
   * Goal 12. Weak Mutation 104: capstone.mobile.models.Trap.setLongitude(D)V:101 - InsertUnaryOp Negation of longitude
   */

    @Test(timeout = 4000)
    public void test19() throws Throwable {
        Trap trap0 = new Trap();
        trap0.setLongitude((-1128.90987855854));
        assertEquals((-1128.90987855854), trap0.getLongitude(), 0.01);
    }

    //Test case number: 20
  /*
   * 12 covered goals:
   * Goal 1. capstone.mobile.models.Trap.<init>()V: root-Branch
   * Goal 2. capstone.mobile.models.Trap.isMoved()Z: root-Branch
   * Goal 3. Branch capstone.mobile.models.Trap.<init>()V: root-Branch in context: capstone.mobile.models.Trap:<init>()V
   * Goal 4. Branch capstone.mobile.models.Trap.isMoved()Z: root-Branch in context: capstone.mobile.models.Trap:isMoved()Z
   * Goal 5. [Output]: capstone.mobile.models.Trap.isMoved()Z:False
   * Goal 6. capstone.mobile.models.Trap.<init>()V: Line 20
   * Goal 7. capstone.mobile.models.Trap.isMoved()Z: Line 121
   * Goal 8. [METHOD] capstone.mobile.models.Trap.<init>()V
   * Goal 9. [METHOD] capstone.mobile.models.Trap.isMoved()Z
   * Goal 10. [METHODNOEX] capstone.mobile.models.Trap.<init>()V
   * Goal 11. [METHODNOEX] capstone.mobile.models.Trap.isMoved()Z
   * Goal 12. Weak Mutation 111: capstone.mobile.models.Trap.isMoved()Z:121 - InsertUnaryOp Negation
   */

    @Test(timeout = 4000)
    public void test20() throws Throwable {
        Trap    trap0    = new Trap();
        boolean boolean0 = trap0.isMoved();
        assertFalse(boolean0);
    }

    //Test case number: 21
  /*
   * 12 covered goals:
   * Goal 1. capstone.mobile.models.Trap.getLatitude()D: root-Branch
   * Goal 2. capstone.mobile.models.Trap.<init>()V: root-Branch
   * Goal 3. Branch capstone.mobile.models.Trap.getLatitude()D: root-Branch in context: capstone.mobile.models.Trap:getLatitude()D
   * Goal 4. Branch capstone.mobile.models.Trap.<init>()V: root-Branch in context: capstone.mobile.models.Trap:<init>()V
   * Goal 5. [Output]: capstone.mobile.models.Trap.getLatitude()D:Zero
   * Goal 6. capstone.mobile.models.Trap.<init>()V: Line 20
   * Goal 7. capstone.mobile.models.Trap.getLatitude()D: Line 105
   * Goal 8. [METHOD] capstone.mobile.models.Trap.<init>()V
   * Goal 9. [METHOD] capstone.mobile.models.Trap.getLatitude()D
   * Goal 10. [METHODNOEX] capstone.mobile.models.Trap.<init>()V
   * Goal 11. [METHODNOEX] capstone.mobile.models.Trap.getLatitude()D
   * Goal 12. Weak Mutation 105: capstone.mobile.models.Trap.getLatitude()D:105 - InsertUnaryOp Negation
   */

    @Test(timeout = 4000)
    public void test21() throws Throwable {
        Trap   trap0   = new Trap();
        double double0 = trap0.getLatitude();
        assertEquals(0.0, double0, 0.01);
    }

    //Test case number: 22
  /*
   * 38 covered goals:
   * Goal 1. capstone.mobile.models.Trap.setSide(Z)V: root-Branch
   * Goal 2. capstone.mobile.models.Trap.<init>(IIDDZ)V: root-Branch
   * Goal 3. Branch capstone.mobile.models.Trap.<init>(IIDDZ)V: root-Branch in context: capstone.mobile.models.Trap:<init>(IIDDZ)V
   * Goal 4. Branch capstone.mobile.models.Trap.setSide(Z)V: root-Branch in context: capstone.mobile.models.Trap:setSide(Z)V
   * Goal 5. capstone.mobile.models.Trap.<init>(IIDDZ)V: Line 32
   * Goal 6. capstone.mobile.models.Trap.<init>(IIDDZ)V: Line 33
   * Goal 7. capstone.mobile.models.Trap.<init>(IIDDZ)V: Line 34
   * Goal 8. capstone.mobile.models.Trap.<init>(IIDDZ)V: Line 35
   * Goal 9. capstone.mobile.models.Trap.<init>(IIDDZ)V: Line 36
   * Goal 10. capstone.mobile.models.Trap.<init>(IIDDZ)V: Line 37
   * Goal 11. capstone.mobile.models.Trap.<init>(IIDDZ)V: Line 38
   * Goal 12. capstone.mobile.models.Trap.<init>(IIDDZ)V: Line 39
   * Goal 13. capstone.mobile.models.Trap.setSide(Z)V: Line 93
   * Goal 14. capstone.mobile.models.Trap.setSide(Z)V: Line 94
   * Goal 15. [METHOD] capstone.mobile.models.Trap.<init>(IIDDZ)V
   * Goal 16. [METHOD] capstone.mobile.models.Trap.setSide(Z)V
   * Goal 17. [METHODNOEX] capstone.mobile.models.Trap.<init>(IIDDZ)V
   * Goal 18. [METHODNOEX] capstone.mobile.models.Trap.setSide(Z)V
   * Goal 19. Weak Mutation 0: capstone.mobile.models.Trap.<init>(IIDDZ)V:32 - ReplaceVariable lineId -> number
   * Goal 20. Weak Mutation 1: capstone.mobile.models.Trap.<init>(IIDDZ)V:32 - InsertUnaryOp Negation of lineId
   * Goal 21. Weak Mutation 2: capstone.mobile.models.Trap.<init>(IIDDZ)V:32 - InsertUnaryOp IINC 1 lineId
   * Goal 22. Weak Mutation 3: capstone.mobile.models.Trap.<init>(IIDDZ)V:32 - InsertUnaryOp IINC -1 lineId
   * Goal 23. Weak Mutation 4: capstone.mobile.models.Trap.<init>(IIDDZ)V:33 - ReplaceVariable number -> lineId
   * Goal 24. Weak Mutation 5: capstone.mobile.models.Trap.<init>(IIDDZ)V:33 - InsertUnaryOp Negation of number
   * Goal 25. Weak Mutation 6: capstone.mobile.models.Trap.<init>(IIDDZ)V:33 - InsertUnaryOp IINC 1 number
   * Goal 26. Weak Mutation 7: capstone.mobile.models.Trap.<init>(IIDDZ)V:33 - InsertUnaryOp IINC -1 number
   * Goal 27. Weak Mutation 8: capstone.mobile.models.Trap.<init>(IIDDZ)V:34 - ReplaceVariable latitude -> longitude
   * Goal 28. Weak Mutation 9: capstone.mobile.models.Trap.<init>(IIDDZ)V:34 - InsertUnaryOp Negation of latitude
   * Goal 29. Weak Mutation 10: capstone.mobile.models.Trap.<init>(IIDDZ)V:35 - ReplaceVariable longitude -> latitude
   * Goal 30. Weak Mutation 11: capstone.mobile.models.Trap.<init>(IIDDZ)V:35 - InsertUnaryOp Negation of longitude
   * Goal 31. Weak Mutation 12: capstone.mobile.models.Trap.<init>(IIDDZ)V:36 - InsertUnaryOp Negation of side
   * Goal 32. Weak Mutation 13: capstone.mobile.models.Trap.<init>(IIDDZ)V:36 - InsertUnaryOp IINC 1 side
   * Goal 33. Weak Mutation 14: capstone.mobile.models.Trap.<init>(IIDDZ)V:36 - InsertUnaryOp IINC -1 side
   * Goal 34. Weak Mutation 15: capstone.mobile.models.Trap.<init>(IIDDZ)V:37 - ReplaceConstant - 0 -> 1
   * Goal 35. Weak Mutation 16: capstone.mobile.models.Trap.<init>(IIDDZ)V:38 - ReplaceConstant - 0 -> 1
   * Goal 36. Weak Mutation 100: capstone.mobile.models.Trap.setSide(Z)V:93 - InsertUnaryOp Negation of side
   * Goal 37. Weak Mutation 101: capstone.mobile.models.Trap.setSide(Z)V:93 - InsertUnaryOp IINC 1 side
   * Goal 38. Weak Mutation 102: capstone.mobile.models.Trap.setSide(Z)V:93 - InsertUnaryOp IINC -1 side
   */

    @Test(timeout = 4000)
    public void test22() throws Throwable {
        Trap trap0 = new Trap(0, (-819), 361.02871188, 380.0, false);
        assertFalse(trap0.getSide());

        trap0.setSide(true);
        assertTrue(trap0.getSide());
    }

    //Test case number: 23
  /*
   * 14 covered goals:
   * Goal 1. capstone.mobile.models.Trap.getId()I: root-Branch
   * Goal 2. capstone.mobile.models.Trap.<init>()V: root-Branch
   * Goal 3. Branch capstone.mobile.models.Trap.getId()I: root-Branch in context: capstone.mobile.models.Trap:getId()I
   * Goal 4. Branch capstone.mobile.models.Trap.<init>()V: root-Branch in context: capstone.mobile.models.Trap:<init>()V
   * Goal 5. [Output]: capstone.mobile.models.Trap.getId()I:Zero
   * Goal 6. capstone.mobile.models.Trap.<init>()V: Line 20
   * Goal 7. capstone.mobile.models.Trap.getId()I: Line 65
   * Goal 8. [METHOD] capstone.mobile.models.Trap.<init>()V
   * Goal 9. [METHOD] capstone.mobile.models.Trap.getId()I
   * Goal 10. [METHODNOEX] capstone.mobile.models.Trap.<init>()V
   * Goal 11. [METHODNOEX] capstone.mobile.models.Trap.getId()I
   * Goal 12. Weak Mutation 81: capstone.mobile.models.Trap.getId()I:65 - InsertUnaryOp Negation
   * Goal 13. Weak Mutation 82: capstone.mobile.models.Trap.getId()I:65 - InsertUnaryOp +1
   * Goal 14. Weak Mutation 83: capstone.mobile.models.Trap.getId()I:65 - InsertUnaryOp -1
   */

    @Test(timeout = 4000)
    public void test23() throws Throwable {
        Trap trap0 = new Trap();
        int  int0  = trap0.getId();
        assertEquals(0, int0);
    }

    //Test case number: 24
  /*
   * 14 covered goals:
   * Goal 1. capstone.mobile.models.Trap.setNumber(I)V: root-Branch
   * Goal 2. capstone.mobile.models.Trap.<init>()V: root-Branch
   * Goal 3. Branch capstone.mobile.models.Trap.<init>()V: root-Branch in context: capstone.mobile.models.Trap:<init>()V
   * Goal 4. Branch capstone.mobile.models.Trap.setNumber(I)V: root-Branch in context: capstone.mobile.models.Trap:setNumber(I)V
   * Goal 5. capstone.mobile.models.Trap.<init>()V: Line 20
   * Goal 6. capstone.mobile.models.Trap.setNumber(I)V: Line 85
   * Goal 7. capstone.mobile.models.Trap.setNumber(I)V: Line 86
   * Goal 8. [METHOD] capstone.mobile.models.Trap.<init>()V
   * Goal 9. [METHOD] capstone.mobile.models.Trap.setNumber(I)V
   * Goal 10. [METHODNOEX] capstone.mobile.models.Trap.<init>()V
   * Goal 11. [METHODNOEX] capstone.mobile.models.Trap.setNumber(I)V
   * Goal 12. Weak Mutation 96: capstone.mobile.models.Trap.setNumber(I)V:85 - InsertUnaryOp Negation of number
   * Goal 13. Weak Mutation 97: capstone.mobile.models.Trap.setNumber(I)V:85 - InsertUnaryOp IINC 1 number
   * Goal 14. Weak Mutation 98: capstone.mobile.models.Trap.setNumber(I)V:85 - InsertUnaryOp IINC -1 number
   */

    @Test(timeout = 4000)
    public void test24() throws Throwable {
        Trap trap0 = new Trap();
        trap0.setNumber(214);
        assertEquals(214, trap0.getNumber());
    }
}
