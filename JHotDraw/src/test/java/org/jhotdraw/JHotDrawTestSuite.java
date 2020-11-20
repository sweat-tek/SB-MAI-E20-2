package org.jhotdraw;

import org.jhotdraw.geom.BezierPathTest;
import org.jhotdraw.samples.svg.figures.SVGPathFigureTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        BezierPathTest.class,
        SVGPathFigureTest.class
})
public class JHotDrawTestSuite {
}
