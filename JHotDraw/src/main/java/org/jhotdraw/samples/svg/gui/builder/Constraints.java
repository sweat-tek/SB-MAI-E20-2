package org.jhotdraw.samples.svg.gui.builder;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import org.jhotdraw.gui.JAttributeTextArea;
import org.jhotdraw.gui.JAttributeTextField;

/**
 *
 * @author Aleksander
 */
public class Constraints {

    private GridBagConstraints gridBagConstraints;
    private int gridx;
    private int gridy;
    private Insets insets;
    private int fill;
    private int gridwidth;
    private double weightx;
    private double weighty;
    private int anchor;

    private Constraints() {
    }

    public GridBagConstraints getGridBagConstraints() {
        return gridBagConstraints;
    }

    public static class Builder {

        private GridBagConstraints gridBagConstraints;
        private int gridx;
        private int gridy;
        private Insets insets;
        private int fill;
        private int gridwidth;
        private double weightx;
        private double weighty;
        private int anchor;

        public Builder setgbcObj(GridBagConstraints gbc) {
            this.gridBagConstraints = gbc;
            return this;
        }

        public Builder withgridx(int gridx) {
            this.gridBagConstraints.gridx = gridx;
            this.gridx = gridx;
            return this;
        }

        public Builder withgridy(int gridy) {
            this.gridBagConstraints.gridy = gridy;
            this.gridy = gridy;
            return this;
        }

        public Builder withinsets(Insets insets) {
            this.gridBagConstraints.insets = insets;
            this.insets = insets;
            return this;
        }

        public Builder withfill(int fill) {
            this.gridBagConstraints.fill = fill;
            this.fill = fill;
            return this;
        }

        public Builder withgridwidth(int gridwidth) {
            this.gridBagConstraints.gridwidth = gridwidth;
            this.gridwidth = gridwidth;
            return this;
        }

        public Builder withweightx(double weightx) {
            this.gridBagConstraints.weightx = weightx;
            this.weightx = weightx;
            return this;
        }

        public Builder withweighty(double weighty) {
            this.gridBagConstraints.weighty = weighty;
            this.weighty = weighty;
            return this;
        }

        public Builder withanchor(int anchor) {
            this.gridBagConstraints.anchor = anchor;
            this.anchor = anchor;
            return this;
        }

        public Constraints build() {
            Constraints constraints = new Constraints();
            constraints.gridBagConstraints = this.gridBagConstraints;
            constraints.gridx = this.gridx;
            constraints.gridy = this.gridy;
            constraints.insets = this.insets;
            constraints.fill = this.fill;
            constraints.gridwidth = this.gridwidth;
            constraints.weightx = this.weightx;
            constraints.weighty = this.weighty;
            constraints.anchor = this.anchor;
            
            

            return constraints;
        }

    }
}
