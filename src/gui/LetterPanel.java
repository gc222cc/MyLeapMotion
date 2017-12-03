package gui;
/* GUI de gösterilen harflerin dizayn ? yap?l?yor
 */

import javax.swing.*;
import javax.swing.border.MatteBorder;
import java.awt.*;

public class LetterPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public LetterPanel(ImageIcon letter) {
		setSize(new Dimension(190, 135));
		setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		setLayout(null);

		JLabel img = new JLabel("");
		img.setBounds(10, 3, 178, 130);
		img.setIcon(letter);
		add(img);

	}

}
