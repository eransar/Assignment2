package test;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import system.Tree;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TreeTest {

     Tree theTree;
     Tree theAmazingLeaf;
     Tree theEvilLeaf;
     Tree theSmartLeaf;
     Tree theBoringLeaf;
     Tree theMurderLeaf;
     Tree theThiefLeaf;

    @Before
    public  void setUp() throws Exception {
        theTree = new Tree("theTree");

        /**
         * Create Childs
         */
        theAmazingLeaf=theTree.GetChildByName("theAmazingLeaf");
        theEvilLeaf=theTree.GetChildByName("theEvilLeaf");
        theSmartLeaf=theTree.GetChildByName("theSmartLeaf");
        theBoringLeaf=theTree.GetChildByName("theBoringLeaf");
        theMurderLeaf=theTree.GetChildByName("theMurderLeaf");
        theThiefLeaf=theTree.GetChildByName("theSmartLeaf");

    }

    @After
    public void tearDown() throws Exception {
        theAmazingLeaf=null;
        theEvilLeaf=null;
        theSmartLeaf=null;
        theBoringLeaf=null;
        theMurderLeaf=null;
    }

    @Test
    public void getChildByName() {
    assertNotNull(null,theTree);
    assertNotNull(null,theEvilLeaf);
    assertNotNull(null,theSmartLeaf);
    assertNotNull(null,theBoringLeaf);
    assertNotNull(null,theMurderLeaf);
    assertTrue(theTree.children.size()>0);
//    assertEquals(theThiefLeaf,theSmartLeaf);
    assertTrue(theTree.children.containsKey("theAmazingLeaf"));
    assertTrue(theTree.children.containsKey("theEvilLeaf"));
    assertTrue(theTree.children.containsKey("theSmartLeaf"));
    assertTrue(theTree.children.containsKey("theBoringLeaf"));
    assertTrue(theTree.children.containsKey("theMurderLeaf"));

    assertEquals(null,theTree.parent);


    }
    @Test
    public void checkTreePath(){
        assertEquals(0,theTree.getPath().length);
        assertEquals(1,theBoringLeaf.getPath().length);
        assertEquals(1,theEvilLeaf.getPath().length);
        assertEquals(1,theMurderLeaf.getPath().length);
        assertEquals(1,theSmartLeaf.getPath().length);
        assertEquals(1,theThiefLeaf.getPath().length);

        ArrayList<Tree> arrayTree = new ArrayList<Tree>() {{
            add(theTree);
            add(theBoringLeaf);
            add(theEvilLeaf);
            add(theMurderLeaf);
            add(theSmartLeaf);
            add(theThiefLeaf);
        }};

        ArrayList<String[]> arrayStrings = new ArrayList<String[]>() {{
            add(new String[]{"theTree"});
            add(new String[]{"theBoringLeaf"});
            add(new String[]{"theEvilLeaf"});
            add(new String[]{"theMurderLeaf"});
            add(new String[]{"theSmartLeaf"});
            add(new String[]{"theSmartLeaf"});
        }};


        for (int i = 1; i < arrayTree.size(); i++) {
            assertEquals(arrayStrings.get(i)[0],arrayTree.get(i).getPath()[0]);
        }

    }
}