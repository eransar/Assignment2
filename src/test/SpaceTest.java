package test;

import static org.junit.Assert.*;

import org.junit.*;
import system.FileSystem;
import system.Leaf;
import system.OutOfSpaceException;
import system.Tree;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static system.FileSystem.fileStorage;

public class SpaceTest {
     Leaf someleaf;
     FileSystem fs;
    @Before
    public void setup() throws OutOfSpaceException {
        fs = new FileSystem(30);
        someleaf=new Leaf("AmazingLeaf",5);

    }


    @org.junit.Test
    public void alloc() throws OutOfSpaceException {
        Leaf laf = new Leaf("laf",5);
        fileStorage.Alloc(5,new Leaf("a",9));
        assertEquals(6,fileStorage.countFreeSpace());


    }

    @org.junit.Test
    public void dealloc() throws OutOfSpaceException {
//        Testing Dealloc new data
        Tree root = new Tree("root");
        someleaf=new Leaf("AmazingLeaf",5);
        someleaf.parent=root;
        assertEquals(25, fileStorage.countFreeSpace());
        assertEquals(30,fileStorage.getAlloc().length);
        int counter=0;
        //        Testing Allocations
        for(Leaf laf : fileStorage.getAlloc()){
            if(laf!=null){
                counter++;
            }
        }

        assertEquals(5,counter);
        counter=0;
        fileStorage.Dealloc(someleaf);
        for(Leaf laf : fileStorage.getAlloc()){
            if(laf==null){
                counter++;
            }
        }
        assertEquals(30,counter);
        assertEquals(30, fileStorage.countFreeSpace());



        for (Leaf l : fileStorage.getAlloc()){
            assertEquals(null,l);
        }
        assertEquals(0,root.children.size());
        Leaf laf = new Leaf("laf",30);
        laf.parent=root;
        assertEquals(0,fileStorage.countFreeSpace());
        fileStorage.Dealloc(laf);
        assertEquals(30,fileStorage.countFreeSpace());


    }
    @Test(expected = NullPointerException.class)
    public void TestNullPointerException() throws OutOfSpaceException {
        Leaf laf = new Leaf("laf",55);
    }

    @org.junit.Test
    public void countFreeSpace() {
        System.out.println(fileStorage.countFreeSpace());
        assertEquals(25,fileStorage.countFreeSpace());


    }

    @org.junit.Test
    public void getAlloc() {
        int i=0;
        for (Leaf laf:fileStorage.getAlloc()
        ) {
            assertEquals(laf,fileStorage.getAlloc()[i]);
            i++;

        }

    }

    @After
    public void runAfterEachTest(){
        fs=null;
        someleaf=null;
    }
}