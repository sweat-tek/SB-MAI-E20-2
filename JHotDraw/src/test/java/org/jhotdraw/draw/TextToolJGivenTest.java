package org.jhotdraw.draw;

import com.tngtech.jgiven.junit.ScenarioTest;
import org.junit.Test;

/**
 *
 * @author Rene_
 */
public class TextToolJGivenTest extends ScenarioTest<GivenSomeState, WhenSomeAction, ThenSomeOutcome>{
    private String oldText = "oldText!";
    private String newText = "newText!"; 
    
    @Test
    public void textToolDrawTextTest() {
        System.out.println("TextToolTest");
        
        given().userWantToEditText(oldText);
        when().userAddsNewLineOfText(newText);
        then().theOldTextIsReplacedWithNewLineOfText(oldText, newText);
    }
}
