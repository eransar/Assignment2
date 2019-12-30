package test;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import system.*;

import java.nio.file.DirectoryNotEmptyException;

import static org.junit.Assert.*;

public class FileSystemTest {
    FileSystem theAmazingFileSystem;
    String root = "root";
    String theAmazingLampa = "theAmazingLampa";
    String theAmazingDog = "theAmazingDog";
    String theAmazingPompa = "theAmazingPompa";
    String [] theAmazingPathLampa = {root,theAmazingLampa};
    String [] theAmazingPath2 = {root,theAmazingDog};
    String [] theAmazingPath3 = {root,theAmazingPompa};
    String [] theEvilPath = {"theEvilPompa",theAmazingPompa};
    String [] theEvilPath2 = {"theEvilLampa",theAmazingPompa};
    String[] theAmazingFile = {"root", theAmazingLampa, "theAmazingFile"};
    String[] theAmazingEvilPath = {"root", theAmazingPompa, "theEvilLampa"};
    String[] theAmazingSuperEvilPath = {"evil", theAmazingPompa, "theEvilLampa"};
    @Before
    public void setUp() throws Exception {
        theAmazingFileSystem = new FileSystem(50);
        theAmazingFileSystem.dir(theAmazingPathLampa);
        theAmazingFileSystem.file(theAmazingFile,10);
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void dir() throws BadFileNameException {
        assertNotNull(theAmazingFileSystem.DirExists(theAmazingPathLampa));
        assertEquals(new Tree("a").getClass().getName(),theAmazingFileSystem.DirExists(theAmazingPathLampa).getClass().getName());
        int i =5;


    }
    @Test(expected = BadFileNameException.class)
    public void evildir() throws BadFileNameException {
        theAmazingFileSystem.dir(theEvilPath);
    }
    @Test(expected = ClassCastException.class)
    public void evildir2() throws ClassCastException, BadFileNameException {
        theAmazingFileSystem.dir(theAmazingPathLampa);
    }



    @Test
    public void disk() {
        String[][] diskcheck = theAmazingFileSystem.disk();
        int counter=0;
        for(String[] s : diskcheck){
            if(s!=null){
                counter++;
            }
        }
        assertEquals(10,counter);
    }

    @Test(expected = NullPointerException.class)
    public void file() throws NullPointerException, BadFileNameException, OutOfSpaceException {
        theAmazingFileSystem.file(theAmazingFile,55);

    }

    @Test(expected = OutOfSpaceException.class)
    public void evilfile() throws OutOfSpaceException, BadFileNameException {
        theAmazingFileSystem.file(theAmazingEvilPath,60);
    }
    @Test(expected = BadFileNameException.class)
    public void evilfile2() throws OutOfSpaceException, BadFileNameException {
        theAmazingFileSystem.file(theAmazingSuperEvilPath,60);
    }

    @Test
    public void lsdir() {
        assertNotNull(theAmazingFileSystem.lsdir(theAmazingPathLampa));
        assertNull(theAmazingFileSystem.lsdir(theAmazingSuperEvilPath));
        assertEquals(theAmazingFile[theAmazingFile.length-1],theAmazingFileSystem.lsdir(theAmazingPathLampa)[0]);

    }

    @Test
    public void rmfile() {
        theAmazingFileSystem.rmfile(theAmazingFile);
        assertEquals(50,theAmazingFileSystem.fileStorage.countFreeSpace());
        theAmazingFileSystem.rmfile(theAmazingSuperEvilPath);
    }

    @Test
    public void rmdir() throws BadFileNameException, DirectoryNotEmptyException {
        theAmazingFileSystem.dir(theAmazingPath2);
        theAmazingFileSystem.rmdir(theAmazingPath2);
        assertNull(theAmazingFileSystem.lsdir(theAmazingPath2));
        assertNull(theAmazingFileSystem.DirExists(theAmazingPath2));
        assertEquals(1,theAmazingFileSystem.DirExists(theAmazingPathLampa).parent.children.size());
    }

    @Test
    public void fileExists() throws OutOfSpaceException {
    assertNotNull(theAmazingFileSystem.FileExists(theAmazingFile));
    assertEquals(new Leaf("3",1).getClass().getName(),theAmazingFileSystem.FileExists(theAmazingFile).getClass().getName());
    }

    @Test
    public void dirExists() {
        assertNotNull(theAmazingFileSystem.DirExists(theAmazingPathLampa));
    }

    @Test(expected = DirectoryNotEmptyException.class)
    public void evilrmdir() throws DirectoryNotEmptyException, BadFileNameException {
        theAmazingFileSystem.rmdir(theAmazingPathLampa);
    }
}