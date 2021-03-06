package com.family.grab.model;

import com.family.grab.Page;
import com.family.grab.Request;
import com.family.grab.model.annotation.ExtractBy;
import com.family.grab.model.annotation.TargetUrl;
import com.family.grab.selector.PlainText;
import org.apache.commons.io.IOUtils;
import org.junit.Test;

import java.io.IOException;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * @author code4crafter@gmail.com
 * @date 14-4-4
 */
public class ModelPageProcessorTest {

    @Test
    public void testMultiModel_should_not_skip_when_match() throws Exception {
        Page page = new Page();
        page.setRawText("<div foo='foo'></div>");
        page.setRequest(new Request("http://codecraft.us/foo"));
        page.setUrl(PlainText.create("http://codecraft.us/foo"));
        ModelPageProcessor modelPageProcessor = ModelPageProcessor.create(null, ModelFoo.class, ModelBar.class);
        modelPageProcessor.process(page);
        assertThat(page.getResultItems().isSkip()).isFalse();
    }

    @Test
    public void testExtractLinks() throws Exception {
        ModelPageProcessor modelPageProcessor = ModelPageProcessor.create(null, MockModel.class);
        Page page = getMockPage();
        modelPageProcessor.process(page);
        assertThat(page.getTargetRequests()).containsExactly(new Request("http://grab.io/list/1"), new Request("http://grab.io/list/2"), new Request("http://grab.io/post/1"), new Request("http://grab.io/post/2"));

    }

    private Page getMockPage() throws IOException {
        Page page = new Page();
        page.setRawText(IOUtils.toString(getClass().getClassLoader().getResourceAsStream("html/mock-grab.html")));
        page.setRequest(new Request("http://grab.io/list/0"));
        page.setUrl(new PlainText("http://grab.io/list/0"));
        return page;
    }

    @TargetUrl("http://codecraft.us/foo")
    public static class ModelFoo {

        @ExtractBy(value = "//div/@foo", notNull = true)
        private String foo;

    }

    @TargetUrl("http://codecraft.us/bar")
    public static class ModelBar {

        @ExtractBy(value = "//div/@bar", notNull = true)
        private String bar;

    }
}
