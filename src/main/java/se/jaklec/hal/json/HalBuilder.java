package se.jaklec.hal.json;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class HalBuilder {

    @JsonUnwrapped
    private Object resource;
    @JsonProperty("_links")
    private Map<String, Map<String, String>> links;
    @JsonProperty("_embedded")
    private Object embedded;

    public HalBuilder(Object resource) {
        this.resource = resource;
    }

    public HalBuilder withLink(final String ref, final URI uri) {
        return withLink(ref, uri.toASCIIString());
    }

    public HalBuilder withLink(final String ref, final String uri) {
        if (links == null) {
            links = new HashMap<>();
        }
        Map<String, String> map = new HashMap<>();
        map.put("href", uri);
        links.put(ref, map);
        return this;
    }

    public HalBuilder withResource(final Object resource) {
        embedded = resource;
        return this;
    }

    public String build() throws HalBuilderException {
        try {
            ObjectMapper mapper = new ObjectMapper();
            return mapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new HalBuilderException(e);
        }
    }

    public Object getResource() {
        return resource;
    }
}