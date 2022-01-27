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

    @Test
    public void testOnlyBrakets() throws IOException{
        testFile(List.of(), "lab4-test7.md");
    }

    @Test
    public void testFile1() throws IOException {
        testFile(List.of("https://something.com", "some-page.html"), "test-file.md");
    }
    @Test
    public void testFile2() throws IOException {
        testFile(List.of("https://something.com", "some-page.html"), "test-file2.md");
    }
        @Test
    public void testFile3() throws IOException {
        testFile(List.of(), "test-file3.md");
    }
    @Test
    public void testFile4() throws IOException {
        testFile(List.of(), "test-file4.md");
    }
    @Test
    public void testFile5() throws IOException {
        testFile(List.of(), "test-file5.md");
    }
    @Test
    public void testFile6() throws IOException {
        testFile(List.of(), "test-file6.md");
    }
    @Test
    public void testFile7() throws IOException {
        testFile(List.of(), "test-file7.md");
    }
    @Test
    public void testFile8() throws IOException {
        testFile(List.of(), "test-file8.md");
    }
}