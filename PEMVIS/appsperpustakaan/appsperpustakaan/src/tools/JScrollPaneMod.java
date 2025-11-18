package tools;

import javax.swing.*;
import javax.swing.plaf.basic.BasicScrollBarUI;
import java.awt.*;

public class JScrollPaneMod extends JScrollPane {

    public JScrollPaneMod(Component view) {
        super(view);
        setBorder(BorderFactory.createEmptyBorder());
        setViewportBorder(null);
        setBackground(Color.WHITE);

        // Terapkan custom scrollbar ke vertikal dan horizontal
        getVerticalScrollBar().setUI(new ModernScrollBarUI());
        getHorizontalScrollBar().setUI(new ModernScrollBarUI());
    }

    // Custom Scrollbar UI
    private static class ModernScrollBarUI extends BasicScrollBarUI {

        private final int SCROLLBAR_THICKNESS = 12; // ukuran track & thumb

        @Override
        protected void configureScrollBarColors() {
            this.thumbColor = new Color(120, 120, 120, 200);
            this.trackColor = new Color(245, 245, 245);
        }

        @Override
        protected JButton createDecreaseButton(int orientation) {
            return createZeroButton();
        }

        @Override
        protected JButton createIncreaseButton(int orientation) {
            return createZeroButton();
        }

        private JButton createZeroButton() {
            JButton button = new JButton();
            button.setPreferredSize(new Dimension(0, 0));
            button.setMinimumSize(new Dimension(0, 0));
            button.setMaximumSize(new Dimension(0, 0));
            button.setFocusable(false);
            button.setBorder(null);
            button.setOpaque(false);
            return button;
        }

        @Override
        public Dimension getPreferredSize(JComponent c) {
            // Mengatur ketebalan scrollbar
            if (scrollbar.getOrientation() == JScrollBar.VERTICAL) {
                return new Dimension(SCROLLBAR_THICKNESS, 0);
            } else {
                return new Dimension(0, SCROLLBAR_THICKNESS);
            }
        }

        @Override
        protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
            if (!scrollbar.isEnabled() || thumbBounds.width + thumbBounds.height < 10) return;

            Graphics2D g2 = (Graphics2D) g.create();

            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_OFF);
            g2.setPaint(new Color(140, 140, 140, 200));

            // Thumb persegi panjang
            g2.fillRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height);

            g2.dispose();
        }

        @Override
        protected void paintTrack(Graphics g, JComponent c, Rectangle trackBounds) {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setPaint(trackColor);
            g2.fillRect(trackBounds.x, trackBounds.y, trackBounds.width, trackBounds.height);
            g2.dispose();
        }
    }
}

