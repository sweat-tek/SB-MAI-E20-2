package org.jhotdraw.samples.svg.gui;

import com.tngtech.jgiven.Stage;
import com.tngtech.jgiven.junit.SimpleScenarioTest;
import org.jhotdraw.draw.AttributeKeys;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.QuadTreeDrawing;
import org.jhotdraw.gui.JAttributeSlider;
import org.jhotdraw.gui.JAttributeTextField;
import org.jhotdraw.gui.JPopupButton;
import org.jhotdraw.util.ResourceBundleUtil;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class CanvasToolBarBddTest extends SimpleScenarioTest<CanvasToolBarBddTest.TestSteps> {

    @Test
    public void opacity_should_be_changed_in_partial_toolbar() {
        given().toolbar_of_state_$(1);

        when().set_opacity_slider_to_$(50);

        then().drawing_opacity_is_set_to_$(0.5d);
    }

    @Test
    public void opacity_should_be_changed_in_full_toolbar() {
        given().toolbar_of_state_$(2);

        when().set_opacity_slider_to_$(25);

        then().drawing_opacity_is_set_to_$(0.25d);
    }

    @Test
    public void fill_color_should_be_changed() {
        given().toolbar_of_state_$(2);

        when().set_fill_color_to_$(Color.RED);

        then().fill_color_is_set_to_$(Color.RED);
    }

    @Test
    public void width_and_height_should_be_changed() {
        given().toolbar_of_state_$(2);

        when().set_width_to_$(300)
                .and().set_height_to_$(200);

        then().width_is_set_to_$(300)
                .and().height_is_set_to_$(200);
    }

    @SuppressWarnings({"OptionalGetWithoutIsPresent", "unchecked"})
    public static class TestSteps extends Stage<TestSteps> {
        private List<Component> components;
        private DrawingView view;
        private ResourceBundleUtil labels = ResourceBundleUtil.getBundle("org.jhotdraw.samples.svg.Labels");

        public void toolbar_of_state_$(int state) {
            CanvasToolBar toolbar = new CanvasToolBar();
            new JPanel().add(toolbar); // Prevents NPE

            // Initialise an editor, view, and drawing
            DefaultDrawingEditor editor = new DefaultDrawingEditor();
            view = new DefaultDrawingView();
            editor.setActiveView(view);
            view.setDrawing(new QuadTreeDrawing());
            toolbar.setEditor(editor);

            // Inspect components
            JComponent toolbarComponent = toolbar.createDisclosedComponent(state);
            components = new ArrayList<>();
            expandDeep(components, toolbarComponent);
        }

        public void set_opacity_slider_to_$(int newValue) {
            JAttributeSlider slider = (JAttributeSlider) components.stream()
                    .filter(c -> c instanceof JAttributeSlider)
                    .findFirst()
                    .get();

            slider.setValue(newValue);
        }

        public void set_fill_color_to_$(Color color) {
            findFieldWithTooltip("attribute.canvasFillColor.toolTipText").setAttributeValue(color);
        }

        public TestSteps set_width_to_$(double width) {
            findFieldWithTooltip("attribute.canvasWidth.toolTipText").setAttributeValue(width);
            return this;
        }

        public void set_height_to_$(double height) {
            findFieldWithTooltip("attribute.canvasHeight.toolTipText").setAttributeValue(height);
        }

        public void drawing_opacity_is_set_to_$(double expected) {
            double actual = AttributeKeys.CANVAS_FILL_OPACITY.get(view.getDrawing());
            assertEquals("Opacity set", expected, actual, 0);
        }

        public void fill_color_is_set_to_$(Color expected) {
            Color actual = AttributeKeys.CANVAS_FILL_COLOR.get(view.getDrawing());
            assertEquals("Fill color set", expected, actual);
        }

        public TestSteps width_is_set_to_$(double expected) {
            double actual = AttributeKeys.CANVAS_WIDTH.get(view.getDrawing());
            assertEquals("Width set", expected, actual, 0);
            return this;
        }

        public void height_is_set_to_$(double expected) {
            double actual = AttributeKeys.CANVAS_HEIGHT.get(view.getDrawing());
            assertEquals("Height set", expected, actual, 0);
        }


        private void expandDeep(List<Component> components, Component component) {
            components.add(component);
            if (!(component instanceof JComponent)) return;
            JComponent jc = (JComponent) component;
            for (Component c : jc.getComponents()) {
                expandDeep(components, c);
                // Also grab components of submenus
                if (c instanceof JPopupButton) {
                    for (Component c2 : ((JPopupButton) c).getPopupMenu().getComponents()) {
                        expandDeep(components, c2);
                    }
                }
            }
        }

        private <T> JAttributeTextField<T> findFieldWithTooltip(String key) {
            return  (JAttributeTextField<T>) components.stream().filter(c ->
                    c instanceof JAttributeTextField
                            && ((JAttributeTextField<?>) c).getToolTipText()
                            .equals(labels.getString(key)))
                    .findFirst()
                    .get();
        }
    }
}