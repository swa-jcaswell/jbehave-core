package org.jbehave.core.parser;

import org.jbehave.core.RunnableStory;
import org.jbehave.core.model.Story;

/**
 * <p>
 * Define {@link Story} from a given story path.
 * </p>
 */
public interface StoryDefiner {

    Story defineStory(String storyPath);

}