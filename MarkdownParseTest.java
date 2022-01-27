import static org.junit.Assert.*;
import org.junit.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class MarkdownParseTest {
    @Test
    public void addition() {
        assertEquals(2, 1 + 1);
    }

    public static void testFile(List<String> expect, String file) throws IOException {
        Path fileName = Path.of(file);
	    String contents = Files.readString(fileName);
        ArrayList<String> links = MarkdownParse.getLinks(contents);
        assertEquals(file+" does not work", expect, links);
    }

    @Test
    public void testExtaBackslash() throws IOException{
        testFile(List.of("https://somethingelse.com"), "lab4-test1.md");
    }

    @Test
    public void testExtraSpace() throws IOException{
        testFile(List.of(), "lab4-test2.md");
    }

    @Test
    public void testUnmatchedBrackets() throws IOException{
        testFile(List.of(), "lab4-test3.md");
    }

    @Test
    public void testMultiLine() throws IOException{
        testFile(List.of("https://isthisfound.com"), "lab4-test4.md");
    }

    @Test
    public void testImage() throws IOException{
        testFile(List.of(), "lab4-test5.md");
    }

    @Test
    public void testMultiLinks() throws IOException{
        testFile(List.of("firstline.com", "middle.com", "lastline.com"), "lab4-test6.md");
    }

}