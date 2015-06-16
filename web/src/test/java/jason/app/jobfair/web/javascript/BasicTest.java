package jason.app.jobfair.web.javascript;

import org.junit.Test;
import java.io.File;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

public class BasicTest {

  @Test
  public void shouldHavePhantomJsBinary() {
    String binary = System.getProperty("phantomjs.binary");
    assertNotNull(binary);
    assertTrue(new File(binary).exists());
  }

}