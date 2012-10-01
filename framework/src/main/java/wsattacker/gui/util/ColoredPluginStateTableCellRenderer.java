/**
 * WS-Attacker - A Modular Web Services Penetration Testing Framework
 * Copyright (C) 2010 Christian Mainka
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU General Public License
 * as published by the Free Software Foundation; either version 2
 * of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package wsattacker.gui.util;

import java.awt.Component;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTable;
import wsattacker.main.plugin.PluginState;

public class ColoredPluginStateTableCellRenderer extends CenteredTableCellRenderer {

    private static final long serialVersionUID = 1L;
    final private static String FONTNAME = "Dialog";

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        JLabel c = (JLabel) super.getTableCellRendererComponent(
                table, value, isSelected, hasFocus, row, column);
        if (value != null) {
            c.setText(value.toString());
            PluginState state = PluginState.valueOf(c.getText());
            switch (state) {
                case Ready:
                    c.setFont(new java.awt.Font(FONTNAME, Font.PLAIN, 12));
                    break;
                case Running:
                    c.setFont(new java.awt.Font(FONTNAME, Font.ITALIC, 12));
                    c.setBackground(Colors.RUNNING);
                    c.setOpaque(true);
                    break;
                case Finished:
                    c.setFont(new java.awt.Font(FONTNAME, Font.BOLD, 12));
                    c.setBackground(Colors.OK);
                    c.setOpaque(true);
                    break;
                case Aborting:
                case Stopped:
                case Failed:
                case Not_Configured:
                    c.setFont(new java.awt.Font(FONTNAME, Font.BOLD, 12));
                    c.setBackground(Colors.INVALID);
                    c.setOpaque(true);
                default:
                    break;
            }
        }
        else {
            c.setText("");
        }
        return c;
    }
}
