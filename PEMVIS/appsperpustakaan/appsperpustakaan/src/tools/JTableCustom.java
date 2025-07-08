
package tools;

import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;

public class JTableCustom extends JTable {

    public JTableCustom() {
        setRowHeight(30);
        setGridColor(new Color(230, 230, 230));
        setShowVerticalLines(false);
        setSelectionBackground(new Color(179, 224, 255));
        setSelectionForeground(Color.BLACK);
        setFont(new Font("Segoe UI", Font.PLAIN, 14));
        getTableHeader().setReorderingAllowed(false);

        JTableHeader header = getTableHeader();
        header.setFont(new Font("Segoe UI", Font.BOLD, 14));
        header.setBackground(new Color(240, 240, 240));
        header.setForeground(Color.BLACK);
        ((DefaultTableCellRenderer) header.getDefaultRenderer()).setHorizontalAlignment(JLabel.CENTER);
    }

    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        Component c = super.prepareRenderer(renderer, row, column);
        if (!isRowSelected(row)) {
            c.setBackground(row % 2 == 0 ? Color.WHITE : new Color(245, 245, 245));
        }
        return c;
    }
}