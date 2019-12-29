package test;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import system.Tree;

import static org.junit.Assert.*;

public class TreeTest {

    static Tree theTree;
    static Tree theAmazingLeaf;
    static Tree theEvilLeaf;
    static Tree theSmartLeaf;
    static Tree theBoringLeaf;
    static Tree theMurderLeaf;

    @BeforeClass
    public static void setUp() throws Exception {
        theTree = new Tree("theTree");
        /**
         * Create Childs
         */
        theAmazingLeaf=theTree.GetChildByName("theAmazingLeaf");
        theEvilLeaf=theTree.GetChildByName("theEvilLeaf");
        theSmartLeaf=theTree.GetChildByName("theSmartLeaf");
        theBoringLeaf=theTree.GetChildByName("theBoringLeaf");
        theMurderLeaf=theTree.GetChildByName("theMurderLeaf");

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
    assertTrue(theTree.children.containsKey("theAmazingLeaf"));
    assertTrue(theTree.children.containsKey("theEvilLeaf"));
    assertTrue(theTree.children.containsKey("theSmartLeaf"));
    assertTrue(theTree.children.containsKey("theBoringLeaf"));
    assertTrue(theTree.children.containsKey("theMurderLeaf"));

    assertEquals(null,theTree.parent);


    }
}