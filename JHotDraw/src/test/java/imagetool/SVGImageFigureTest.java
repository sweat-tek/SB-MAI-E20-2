package imagetool;

import org.jhotdraw.samples.svg.figures.SVGImageFigure;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.awt.geom.Point2D;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.Assert.*;

public class SVGImageFigureTest {

    private SVGImageFigure svgImageFigure;
    private Point2D.Double point2DAnchor;
    private Point2D.Double point2DLead;
    private FileInputStream inputStream;
    private String testImagePath;

    @Before
    public void setUp() throws Exception {
        svgImageFigure = new SVGImageFigure(50, 50, 50, 50);
        point2DAnchor = new Point2D.Double(5.0, 10.0);
        point2DLead = new Point2D.Double(30.0, 20.0);
        testImagePath = "src/test/java/imagetool/test_image.jpg";
        inputStream = new FileInputStream(new File(testImagePath));
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void setBounds() {
        svgImageFigure.setBounds(point2DAnchor, point2DLead);
        assertEquals(5.0, svgImageFigure.getX(), 0.0);
        assertEquals(10.0, svgImageFigure.getY(), 0.0);
        assertEquals(30.0 - 5.0, svgImageFigure.getWidth(), 0.0);
        assertEquals(20.0 - 10.0, svgImageFigure.getHeight(), 0.0);
    }

    @Test
    public void loadImage() {
        try {
            svgImageFigure.loadImage(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        assertNotNull(svgImageFigure.getImageData());
    }
}