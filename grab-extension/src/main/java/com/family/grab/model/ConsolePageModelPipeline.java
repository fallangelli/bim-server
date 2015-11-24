package com.family.grab.model;

import com.family.grab.Task;
import com.family.grab.pipeline.PageModelPipeline;
import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * Print page com.family.grabserver.model in console.<br>
 * Usually used in test.<br>
 *
 * @author code4crafter@gmail.com <br>
 * @since 0.2.0
 */
public class ConsolePageModelPipeline implements PageModelPipeline {
    @Override
    public void process(Object o, Task task) {
        System.out.println(ToStringBuilder.reflectionToString(o));
    }
}
