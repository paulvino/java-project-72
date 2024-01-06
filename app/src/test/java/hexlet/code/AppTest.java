package hexlet.code;

import org.junit.jupiter.api.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AppTest {
    @Test
    public void HelloWorldTest() {
        ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStreamCaptor));
        App.printHelloWorld();
        assertEquals("Hello World" + System.lineSeparator(), outputStreamCaptor.toString());
        System.setOut(System.out);
    }
}