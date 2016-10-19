/*
 * This file was automatically generated by EvoSuite
 * Wed Oct 19 06:32:27 GMT 2016
 */

package capstone.mobile.dataHandlers;

import org.junit.Test;
import static org.junit.Assert.*;
import static org.evosuite.runtime.EvoAssertions.*;
import capstone.mobile.dataHandlers.LocalDatabase;
import capstone.mobile.models.Catch;
import capstone.mobile.models.Line;
import capstone.mobile.models.Trap;
import capstone.mobile.models.Walk;
import java.sql.SQLException;
import org.evosuite.runtime.EvoRunner;
import org.evosuite.runtime.EvoRunnerParameters;
import org.junit.runner.RunWith;

@RunWith(EvoRunner.class) @EvoRunnerParameters(mockJVMNonDeterminism = true, useVFS = true, useVNET = true, resetStaticState = true, separateClassLoader = true) 
public class LocalDatabase_ESTest extends LocalDatabase_ESTest_scaffolding {

  //Test case number: 0
  /*
   * 6 covered goals:
   * Goal 1. capstone.mobile.dataHandlers.LocalDatabase.setCurrentLine(Lcapstone/mobile/models/Line;)V: Line 263
   * Goal 2. capstone.mobile.dataHandlers.LocalDatabase.setCurrentLine(Lcapstone/mobile/models/Line;)V: Line 266
   * Goal 3. capstone.mobile.dataHandlers.LocalDatabase.setCurrentLine(Lcapstone/mobile/models/Line;)V: Line 267
   * Goal 4. capstone.mobile.dataHandlers.LocalDatabase.setCurrentLine(Lcapstone/mobile/models/Line;)V: Line 269
   * Goal 5. [METHOD] capstone.mobile.dataHandlers.LocalDatabase.setCurrentLine(Lcapstone/mobile/models/Line;)V
   * Goal 6. [METHODNOEX] capstone.mobile.dataHandlers.LocalDatabase.setCurrentLine(Lcapstone/mobile/models/Line;)V
   */

  @Test(timeout = 4000)
  public void test00()  throws Throwable  {
      Line line0 = new Line();
      LocalDatabase.setCurrentLine(line0);
      assertNull(line0.getName());
  }

  //Test case number: 1
  /*
   * 6 covered goals:
   * Goal 1. capstone.mobile.dataHandlers.LocalDatabase.removeNewTraps()V: Line 245
   * Goal 2. capstone.mobile.dataHandlers.LocalDatabase.removeNewTraps()V: Line 252
   * Goal 3. capstone.mobile.dataHandlers.LocalDatabase.removeNewTraps()V: Line 253
   * Goal 4. capstone.mobile.dataHandlers.LocalDatabase.removeNewTraps()V: Line 255
   * Goal 5. [METHOD] capstone.mobile.dataHandlers.LocalDatabase.removeNewTraps()V
   * Goal 6. [METHODNOEX] capstone.mobile.dataHandlers.LocalDatabase.removeNewTraps()V
   */

  @Test(timeout = 4000)
  public void test01()  throws Throwable  {
      LocalDatabase.removeNewTraps();
  }

  //Test case number: 2
  /*
   * 6 covered goals:
   * Goal 1. capstone.mobile.dataHandlers.LocalDatabase.removeCatches()V: Line 230
   * Goal 2. capstone.mobile.dataHandlers.LocalDatabase.removeCatches()V: Line 236
   * Goal 3. capstone.mobile.dataHandlers.LocalDatabase.removeCatches()V: Line 237
   * Goal 4. capstone.mobile.dataHandlers.LocalDatabase.removeCatches()V: Line 239
   * Goal 5. [METHOD] capstone.mobile.dataHandlers.LocalDatabase.removeCatches()V
   * Goal 6. [METHODNOEX] capstone.mobile.dataHandlers.LocalDatabase.removeCatches()V
   */

  @Test(timeout = 4000)
  public void test02()  throws Throwable  {
      LocalDatabase.removeCatches();
  }

  //Test case number: 3
  /*
   * 6 covered goals:
   * Goal 1. capstone.mobile.dataHandlers.LocalDatabase.loadDatafromLocalDatabase(Lcapstone/mobile/models/Walk;)V: Line 96
   * Goal 2. capstone.mobile.dataHandlers.LocalDatabase.loadDatafromLocalDatabase(Lcapstone/mobile/models/Walk;)V: Line 138
   * Goal 3. capstone.mobile.dataHandlers.LocalDatabase.loadDatafromLocalDatabase(Lcapstone/mobile/models/Walk;)V: Line 139
   * Goal 4. capstone.mobile.dataHandlers.LocalDatabase.loadDatafromLocalDatabase(Lcapstone/mobile/models/Walk;)V: Line 141
   * Goal 5. [METHOD] capstone.mobile.dataHandlers.LocalDatabase.loadDatafromLocalDatabase(Lcapstone/mobile/models/Walk;)V
   * Goal 6. [METHODNOEX] capstone.mobile.dataHandlers.LocalDatabase.loadDatafromLocalDatabase(Lcapstone/mobile/models/Walk;)V
   */

  @Test(timeout = 4000)
  public void test03()  throws Throwable  {
      Walk walk0 = new Walk();
      LocalDatabase.loadDatafromLocalDatabase(walk0);
  }

  //Test case number: 4
  /*
   * 6 covered goals:
   * Goal 1. capstone.mobile.dataHandlers.LocalDatabase.changeTrap(Lcapstone/mobile/models/Trap;)V: Line 164
   * Goal 2. capstone.mobile.dataHandlers.LocalDatabase.changeTrap(Lcapstone/mobile/models/Trap;)V: Line 170
   * Goal 3. capstone.mobile.dataHandlers.LocalDatabase.changeTrap(Lcapstone/mobile/models/Trap;)V: Line 171
   * Goal 4. capstone.mobile.dataHandlers.LocalDatabase.changeTrap(Lcapstone/mobile/models/Trap;)V: Line 173
   * Goal 5. [METHOD] capstone.mobile.dataHandlers.LocalDatabase.changeTrap(Lcapstone/mobile/models/Trap;)V
   * Goal 6. [METHODNOEX] capstone.mobile.dataHandlers.LocalDatabase.changeTrap(Lcapstone/mobile/models/Trap;)V
   */

  @Test(timeout = 4000)
  public void test04()  throws Throwable  {
      Trap trap0 = new Trap();
      LocalDatabase.changeTrap(trap0);
      assertFalse(trap0.isMoved());
  }

  //Test case number: 5
  /*
   * 6 covered goals:
   * Goal 1. capstone.mobile.dataHandlers.LocalDatabase.addNewTrap(Lcapstone/mobile/models/Trap;)V: Line 181
   * Goal 2. capstone.mobile.dataHandlers.LocalDatabase.addNewTrap(Lcapstone/mobile/models/Trap;)V: Line 185
   * Goal 3. capstone.mobile.dataHandlers.LocalDatabase.addNewTrap(Lcapstone/mobile/models/Trap;)V: Line 186
   * Goal 4. capstone.mobile.dataHandlers.LocalDatabase.addNewTrap(Lcapstone/mobile/models/Trap;)V: Line 188
   * Goal 5. [METHOD] capstone.mobile.dataHandlers.LocalDatabase.addNewTrap(Lcapstone/mobile/models/Trap;)V
   * Goal 6. [METHODNOEX] capstone.mobile.dataHandlers.LocalDatabase.addNewTrap(Lcapstone/mobile/models/Trap;)V
   */

  @Test(timeout = 4000)
  public void test05()  throws Throwable  {
      LocalDatabase.addNewTrap((Trap) null);
  }

  //Test case number: 6
  /*
   * 6 covered goals:
   * Goal 1. capstone.mobile.dataHandlers.LocalDatabase.addCatch(Lcapstone/mobile/models/Catch;)V: Line 149
   * Goal 2. capstone.mobile.dataHandlers.LocalDatabase.addCatch(Lcapstone/mobile/models/Catch;)V: Line 153
   * Goal 3. capstone.mobile.dataHandlers.LocalDatabase.addCatch(Lcapstone/mobile/models/Catch;)V: Line 154
   * Goal 4. capstone.mobile.dataHandlers.LocalDatabase.addCatch(Lcapstone/mobile/models/Catch;)V: Line 156
   * Goal 5. [METHOD] capstone.mobile.dataHandlers.LocalDatabase.addCatch(Lcapstone/mobile/models/Catch;)V
   * Goal 6. [METHODNOEX] capstone.mobile.dataHandlers.LocalDatabase.addCatch(Lcapstone/mobile/models/Catch;)V
   */

  @Test(timeout = 4000)
  public void test06()  throws Throwable  {
      Catch catch0 = new Catch((-2), (-2));
      LocalDatabase.addCatch(catch0);
      assertEquals(1392409281320L, catch0.getTime());
  }

  //Test case number: 7
  /*
   * 6 covered goals:
   * Goal 1. updateTraps(I)Ljava/util/List;_java.lang.ClassCastException_IMPLICIT
   * Goal 2. capstone.mobile.dataHandlers.LocalDatabase.updateTraps(I)Ljava/util/List;: Line 198
   * Goal 3. [METHOD] capstone.mobile.dataHandlers.LocalDatabase.updateTraps(I)Ljava/util/List;
   * Goal 4. Weak Mutation 84: capstone.mobile.dataHandlers.LocalDatabase.updateTraps(I)Ljava/util/List;:198 - InsertUnaryOp Negation of lineId
   * Goal 5. Weak Mutation 85: capstone.mobile.dataHandlers.LocalDatabase.updateTraps(I)Ljava/util/List;:198 - InsertUnaryOp IINC 1 lineId
   * Goal 6. Weak Mutation 86: capstone.mobile.dataHandlers.LocalDatabase.updateTraps(I)Ljava/util/List;:198 - InsertUnaryOp IINC -1 lineId
   */

  @Test(timeout = 4000)
  public void test07()  throws Throwable  {
      // Undeclared exception!
      try { 
        LocalDatabase.updateTraps((-4445));
        fail("Expecting exception: ClassCastException");
      
      } catch(ClassCastException e) {
         //
         // org.evosuite.runtime.mock.java.net.EvoHttpURLConnection cannot be cast to javax.net.ssl.HttpsURLConnection
         //
         assertThrownBy("capstone.mobile.dataHandlers.RetrieveData", e);
      }
  }

  //Test case number: 8
  /*
   * 3 covered goals:
   * Goal 1. updateLines()Ljava/util/List;_java.lang.ClassCastException_IMPLICIT
   * Goal 2. capstone.mobile.dataHandlers.LocalDatabase.updateLines()Ljava/util/List;: Line 279
   * Goal 3. [METHOD] capstone.mobile.dataHandlers.LocalDatabase.updateLines()Ljava/util/List;
   */

  @Test(timeout = 4000)
  public void test08()  throws Throwable  {
      // Undeclared exception!
      try { 
        LocalDatabase.updateLines();
        fail("Expecting exception: ClassCastException");
      
      } catch(ClassCastException e) {
         //
         // org.evosuite.runtime.mock.java.net.EvoHttpURLConnection cannot be cast to javax.net.ssl.HttpsURLConnection
         //
         assertThrownBy("capstone.mobile.dataHandlers.RetrieveData", e);
      }
  }

  //Test case number: 9
  /*
   * 3 covered goals:
   * Goal 1. updateAnimals()Ljava/util/List;_java.lang.ClassCastException_IMPLICIT
   * Goal 2. capstone.mobile.dataHandlers.LocalDatabase.updateAnimals()Ljava/util/List;: Line 309
   * Goal 3. [METHOD] capstone.mobile.dataHandlers.LocalDatabase.updateAnimals()Ljava/util/List;
   */

  @Test(timeout = 4000)
  public void test09()  throws Throwable  {
      // Undeclared exception!
      try { 
        LocalDatabase.updateAnimals();
        fail("Expecting exception: ClassCastException");
      
      } catch(ClassCastException e) {
         //
         // org.evosuite.runtime.mock.java.net.EvoHttpURLConnection cannot be cast to javax.net.ssl.HttpsURLConnection
         //
         assertThrownBy("capstone.mobile.dataHandlers.RetrieveData", e);
      }
  }

  //Test case number: 10
  /*
   * 3 covered goals:
   * Goal 1. setUpLocalDatabase()V_java.lang.NoClassDefFoundError_IMPLICIT
   * Goal 2. capstone.mobile.dataHandlers.LocalDatabase.setUpLocalDatabase()V: Line 27
   * Goal 3. [METHOD] capstone.mobile.dataHandlers.LocalDatabase.setUpLocalDatabase()V
   */

  @Test(timeout = 4000)
  public void test10()  throws Throwable  {
      // Undeclared exception!
      try { 
        LocalDatabase.setUpLocalDatabase();
        fail("Expecting exception: NoClassDefFoundError");
      
      } catch(NoClassDefFoundError e) {
         //
         // com/gluonhq/charm/down/common/PlatformFactory
         //
         assertThrownBy("capstone.mobile.dataHandlers.LocalDatabase", e);
      }
  }

  //Test case number: 11
  /*
   * 5 covered goals:
   * Goal 1. fetchLines()Ljava/util/List;_java.sql.SQLException_DECLARED
   * Goal 2. capstone.mobile.dataHandlers.LocalDatabase.fetchLines()Ljava/util/List;: Line 338
   * Goal 3. capstone.mobile.dataHandlers.LocalDatabase.fetchLines()Ljava/util/List;: Line 339
   * Goal 4. capstone.mobile.dataHandlers.LocalDatabase.fetchLines()Ljava/util/List;: Line 351
   * Goal 5. [METHOD] capstone.mobile.dataHandlers.LocalDatabase.fetchLines()Ljava/util/List;
   */

  @Test(timeout = 4000)
  public void test11()  throws Throwable  {
      try { 
        LocalDatabase.fetchLines();
        fail("Expecting exception: SQLException");
      
      } catch(SQLException e) {
         //
         // The url cannot be null
         //
         assertThrownBy("java.sql.DriverManager", e);
      }
  }

  //Test case number: 12
  /*
   * 4 covered goals:
   * Goal 1. capstone.mobile.dataHandlers.LocalDatabase.<init>()V: root-Branch
   * Goal 2. Branch capstone.mobile.dataHandlers.LocalDatabase.<init>()V: root-Branch in context: capstone.mobile.dataHandlers.LocalDatabase:<init>()V
   * Goal 3. [METHOD] capstone.mobile.dataHandlers.LocalDatabase.<init>()V
   * Goal 4. [METHODNOEX] capstone.mobile.dataHandlers.LocalDatabase.<init>()V
   */

  @Test(timeout = 4000)
  public void test12()  throws Throwable  {
      LocalDatabase localDatabase0 = new LocalDatabase();
  }
}