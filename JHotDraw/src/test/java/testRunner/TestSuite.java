
import org.jhotdraw.linkPaletteAcceptenceTest.AcceptanceTestLinkPalette;
import org.jhotdraw.samples.svg.figures.LinkHandleTest;
import org.jhotdraw.samples.svg.gui.LinkToolBarTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)

@Suite.SuiteClasses({
    LinkHandleTest.class,
    LinkToolBarTest.class,
    AcceptanceTestLinkPalette.class
    
})

public class TestSuite {
}
