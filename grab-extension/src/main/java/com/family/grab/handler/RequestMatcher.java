package com.family.grab.handler;

import com.family.grab.Request;

/**
 * @author code4crafer@gmail.com
 * @since 0.5.0
 */
public interface RequestMatcher {

    /**
     * Check whether to process the page.<br></br>
     * Please DO NOT change page status in this method.
     *
     * @param page
     * @return
     */
    public boolean match(Request page);

    public enum MatchOther {
        YES, NO
    }
}
