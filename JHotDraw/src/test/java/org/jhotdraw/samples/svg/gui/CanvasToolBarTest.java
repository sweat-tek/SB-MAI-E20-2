package org.jhotdraw.samples.svg.gui;

import org.jhotdraw.gui.JAttributeTextField;
import org.jhotdraw.gui.JPopupButton;
import org.junit.Test;

import javax.swing.*;
import java.awt.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class CanvasToolBarTest {

    private final CanvasToolBar toolbar = new CanvasToolBar();

    @Test
    public void testViewHidden() {
        assertNull("State 0 must return null", toolbar.createDisclosedComponent(0));
    }

    @Test
    public void testViewPartial() {
        JComponent component = toolbar.createDisclosedComponent(1);
        long buttons = Arrays.stream(component.getComponents()).filter(c -> c instanceof JPopupButton).count();
        long labels = Arrays.stream(component.getComponents()).filter(c -> c instanceof JLabel).count();
        long fields = Arrays.stream(component.getComponents()).filter(c -> c instanceof JAttributeTextField).count();
        assertEquals("Expect 2 buttons", 2L, buttons);
        assertEquals("Expect 2 labels", 2L, labels);
        assertEquals("Expect 2 fields", 2L, fields);
    }

    @Test
    public void testViewFull() {
        List<JPanel> panels = Arrays.stream(toolbar.createDisclosedComponent(2).getComponents())
                .map(p -> (JPanel) p)
                .collect(Collectors.toList());
        assertEquals("Expect 3 panels", 3L, panels.size());

        List<Component> components = panels.stream().flatMap(p -> Arrays.stream(p.getComponents())).collect(Collectors.toList());
        long buttons = components.stream().filter(c -> c instanceof JPopupButton).count();
        long labels = components.stream().filter(c -> c instanceof JLabel).count();
        long fields = components.stream().filter(c -> c instanceof JAttributeTextField).count();

        assertEquals("Expect 2 buttons", 2L, buttons);
        assertEquals("Expect 2 labels", 2L, labels);
        assertEquals("Expect 4 fields", 4L, fields);
    }

}