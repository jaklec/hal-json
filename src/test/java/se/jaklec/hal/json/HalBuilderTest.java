package se.jaklec.hal.json;

import org.junit.Before;
import org.junit.Test;
import org.skyscreamer.jsonassert.JSONAssert;
import org.skyscreamer.jsonassert.JSONCompareMode;

import java.net.URI;

public class HalBuilderTest {
    private Greeter greeter;

    @Before
    public void setUp() {
        greeter = new Greeter();
    }

    @Test
    public void shouldBuildSimpleJson() throws Exception {
        String json = new HalBuilder(greeter).build();
        String expected = "{'greeting':'Hello, World'}";
        JSONAssert.assertEquals(expected, json, JSONCompareMode.STRICT);
    }

    @Test
    public void shouldBuildJsonWithLinks() throws Exception {
        URI uri = new URI("http://foo.bar");
        String expected = "{'greeting':'Hello, World', '_links' : {'self': {'href': 'http://foo.bar'}, 'other': {'href': 'http://www.other.xyz'}}}";
        String json = new HalBuilder(greeter).withLink("self", uri).withLink("other", "http://www.other.xyz").build();
        JSONAssert.assertEquals(expected, json, JSONCompareMode.STRICT);
    }

    @Test
    public void shouldBuildJsonWithEmbeddedResource() throws Exception {
        String json = new HalBuilder(greeter).withResource(new Greeter()).build();
        String expected = "{'greeting':'Hello, World', '_embedded': { 'greeting': 'Hello, World'}}";
        JSONAssert.assertEquals(expected, json, JSONCompareMode.STRICT);
    }

    class Greeter {
        private String greeting = "Hello, World";

        public String getGreeting() {
            return greeting;
        }
    }
}
