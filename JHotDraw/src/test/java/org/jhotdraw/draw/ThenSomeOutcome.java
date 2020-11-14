package org.jhotdraw.draw;

/**
 *
 * @author Rene_
 */
import com.tngtech.jgiven.Stage;
import org.junit.Assert;

public class ThenSomeOutcome extends Stage<ThenSomeOutcome> {
    public ThenSomeOutcome theOldTextIsReplacedWithNewLineOfText(String oldText, String newText) {
        Assert.assertNotEquals("Text field has been edit", oldText, newText);
        return self();
    }
}