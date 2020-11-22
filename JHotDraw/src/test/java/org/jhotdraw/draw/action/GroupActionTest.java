/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.draw.action;

import java.awt.event.ActionEvent;
import java.util.Collection;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import org.jhotdraw.draw.BezierFigure;
import org.jhotdraw.draw.CompositeFigure;
import org.jhotdraw.draw.DefaultDrawingEditor;
import org.jhotdraw.draw.DefaultDrawingView;
import org.jhotdraw.draw.DrawingEditor;
import org.jhotdraw.draw.DrawingView;
import org.jhotdraw.draw.Figure;
import org.jhotdraw.draw.GroupFigure;
import org.jhotdraw.draw.QuadTreeDrawing;
import org.jhotdraw.samples.svg.action.CombineAction;
import org.jhotdraw.samples.svg.figures.SVGGroupFigure;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 *
 * @author Jonas
 */
public class GroupActionTest {

    private GroupAction instance;
    private DrawingEditor editor;

    public GroupActionTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        editor = new DefaultDrawingEditor();
        DrawingView view = new DefaultDrawingView();
        view.setDrawing(new QuadTreeDrawing());
        editor.setActiveView(view);

        instance = new GroupAction(editor);
    }

    @After
    public void tearDown() {
    }

    private void someSelectedBezierFigures() {
        Figure f1 = new BezierFigure();
        Figure f2 = new BezierFigure();
        Figure f3 = new BezierFigure();
        editor.getActiveView().getDrawing().add(f1);
        editor.getActiveView().getDrawing().add(f2);
        editor.getActiveView().getDrawing().add(f3);
        editor.getActiveView().addToSelection(f1);
        editor.getActiveView().addToSelection(f2);
        editor.getActiveView().addToSelection(f3);
    }

    private void someUnselectedBezierFigures() {
        Figure f1 = new BezierFigure();
        Figure f2 = new BezierFigure();
        Figure f3 = new BezierFigure();
        editor.getActiveView().getDrawing().add(f1);
        editor.getActiveView().getDrawing().add(f2);
        editor.getActiveView().getDrawing().add(f3);
    }

    private void aSelectedGroupFigure() {
        CompositeFigure group1 = new SVGGroupFigure();
        Figure f1 = new BezierFigure();
        Figure f2 = new BezierFigure();
        group1.add(f1);
        group1.add(f2);
        editor.getActiveView().getDrawing().add(group1);
        editor.getActiveView().addToSelection(group1);
    }
    
    private void twoSelectedGroups() {
        aSelectedGroupFigure();
        aSelectedGroupFigure();
    }


    /**
     * Test of actionPerformed method, of class GroupAction.
     */
    @Test
    public void testUndoableAdded() {
        System.out.println("actionPerformed");
        ActionEvent e = mock(ActionEvent.class);
        UndoableEditListener mockListener = mock(UndoableEditListener.class);
        
        editor.getActiveView().getDrawing().addUndoableEditListener(mockListener);
        
        someSelectedBezierFigures();
        
        instance.actionPerformed(e);
        verify(mockListener).undoableEditHappened(any());
        
    }
    
    @Test
    public void testBezierFigures() {
        System.out.println("actionPerformed");
        ActionEvent e = mock(ActionEvent.class);
        DrawingView view = editor.getActiveView();
        
        someSelectedBezierFigures();
        
        assertTrue(view.getSelectionCount() == 3);
        
        instance.actionPerformed(e);
        
        assertTrue(view.getSelectionCount() == 1);       
    }
    
    @Test
    public void testBezierFiguresUnselected() {
        System.out.println("actionPerformed");
        ActionEvent e = mock(ActionEvent.class);
        DrawingView view = editor.getActiveView();
        
        someUnselectedBezierFigures();
        
        assertTrue(view.getSelectionCount() == 0);
        
        instance.actionPerformed(e);
        
        assertTrue(view.getSelectionCount() == 0);       
    }
    
    @Test
    public void testSelectedGroupFigure() {
        System.out.println("actionPerformed");
        ActionEvent e = mock(ActionEvent.class);
        DrawingView view = editor.getActiveView();
        
        aSelectedGroupFigure();
        
        assertTrue(view.getSelectionCount() == 1);
        
        instance.actionPerformed(e);
        
        assertTrue(view.getSelectionCount() == 1);
    }
    
    @Test
    public void testTwoSelectedGroupFigure() {
        System.out.println("actionPerformed");
        ActionEvent e = mock(ActionEvent.class);
        DrawingView view = editor.getActiveView();
        
        twoSelectedGroups();
        
        assertTrue(view.getSelectionCount() == 2);
        
        instance.actionPerformed(e);
        
        assertTrue(view.getSelectionCount() == 1);
    }

}
