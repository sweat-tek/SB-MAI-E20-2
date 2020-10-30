/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.jhotdraw.samples.svg.gui.builder;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import org.jhotdraw.gui.JAttributeTextArea;
import org.jhotdraw.gui.JAttributeTextField;

/**
 *
 * @author ALEKSTUD
 */
public class Panel {

    public static class PanelBuilder {

        private JPanel jPanel;
        private JLabel jLabel;
        private JScrollPane jScrollPane;
        private JAttributeTextArea<String> jattrTextArea;
        private JAttributeTextField<String> jattrTextField;
        private GridBagConstraints gridBagConstraints;

        public PanelBuilder setJPanelObject(JPanel jp) {
            this.jPanel = jp;
            return this;
        }

        public PanelBuilder setJLabelObject(JLabel jl) {
            this.jLabel = jl;
            return this;
        }

        public PanelBuilder setJScrollPaneObject(JScrollPane jsp) {
            this.jScrollPane = jsp;
            return this;
        }

        public PanelBuilder setJAttrTextAreaObject(JAttributeTextArea jata) {
            this.jattrTextArea = jata;
            return this;
        }

        public PanelBuilder setJAttrTextFieldObject(JAttributeTextField jatf) {
            this.jattrTextField = jatf;
            return this;
        }

        public PanelBuilder setGridBagConstraintsObject(GridBagConstraints gbc) {
            this.gridBagConstraints = gbc;
            return this;
        }

        public PanelBuilder setJPanelSettings(GridBagLayout gridbaglayout,
            EmptyBorder emptyBorder, boolean setopaque) {
            this.jPanel.setOpaque(setopaque);
            this.jPanel.setLayout(gridbaglayout);
            this.jPanel.setBorder(emptyBorder);
            return this;
        }
        
        public PanelBuilder 

    }
    /*
    private JPanel buildJPanel(GridBagLayout gridbaglayout,
            EmptyBorder emptyBorder, boolean setopaque) {

        JPanel jpanel = new JPanel();
        jpanel.setOpaque(setopaque);
        jpanel.setLayout(gridbaglayout);
        jpanel.setBorder(emptyBorder);

        return jpanel;
    }

    private JLabel buildJLabel(String tooltiptext,
            String text, Font font, Component component) {

        JLabel label = new JLabel();
        label.setUI((LabelUI) PaletteLabelUI.createUI(label));
        label.setToolTipText(tooltiptext);
        label.setText(text); // NOI18N
        label.setFont(PaletteLookAndFeel.getInstance().getFont("SmallSystemFont"));
        label.setLabelFor(component);

        return label;

    }

    private JScrollPane buildJScrollPane(int horPaneConstantPolicy, int verPaneConstantPolicy,
            String clientPropertyKey, String clientPropertyValue, Border border, Component viewPortView) {
        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setHorizontalScrollBarPolicy(horPaneConstantPolicy);
        scrollPane.setVerticalScrollBarPolicy(verPaneConstantPolicy);
        scrollPane.putClientProperty(clientPropertyKey, clientPropertyValue);
        scrollPane.setBorder(border);
        scrollPane.setViewportView(viewPortView);

        return scrollPane;
    }

    private JAttributeTextArea<String> buildTextArea(String toolTipText, int columns,
            boolean lineWrap, int rows, boolean styleWordWrap, Font font,
            JFormattedTextField.AbstractFormatterFactory formatterFactory) {

        JAttributeTextArea<String> textArea = new JAttributeTextArea<>();
        textArea.setToolTipText(toolTipText);
        textArea.setColumns(columns);
        textArea.setLineWrap(lineWrap);
        textArea.setRows(rows);
        textArea.setWrapStyleWord(styleWordWrap);
        textArea.setFont(font);
        textArea.setFormatterFactory(formatterFactory);

        return textArea;
    }

    private JAttributeTextField<String> buildTextField(String tipText, int columns, Font font, JFormattedTextField.AbstractFormatterFactory formatterFactory, TextUI textui) {
        JAttributeTextField<String> textField = new JAttributeTextField<>();

        textField.setToolTipText(tipText);
        textField.setColumns(columns);
        textField.setFont(font);
        textField.setFormatterFactory(formatterFactory);
        textField.setUI(textui);

        return textField;
    }

    private GridBagConstraints buildGridBagConstraints(int gridx, int gridy,
            Insets insets, int fill, int gridwidth, double weightx,
            double weighty, int anchor) {

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = gridx;
        gbc.gridy = gridy;
        gbc.insets = insets;
        gbc.fill = fill;
        gbc.gridwidth = gridwidth;
        gbc.weightx = weightx;
        gbc.weighty = weighty;
        gbc.anchor = anchor;

        return gbc;
    }
     */
}
