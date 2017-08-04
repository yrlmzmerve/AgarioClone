package tr.org.linux.kamp.Agario.windowsbuilder;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import net.miginfocom.swing.MigLayout;
import tr.org.linux.kamp.Agario.logic.GameLogic;
import tr.org.linux.kamp.Agario.model.Difficulty;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;

/**
 * 
 * @author MerveY
 * @version 1.0
 */

public class FirstPanel extends JPanel {
	private JTextField textField;
	private JPasswordField passwordField;
	private ButtonGroup buttonGroup;

	/**
	 * Create the panel.
	 */

	public FirstPanel() {
		setLayout(null);

		JLabel lblUserName = new JLabel("User Name:");

		lblUserName.setBounds(12, 8, 82, 15);
		add(lblUserName);

		textField = new JTextField();
		textField.setBounds(100, 6, 237, 19);
		add(textField);
		textField.setColumns(10);

		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setBounds(15, 33, 79, 15);
		add(lblPassword);

		JLabel lblSelectColor = new JLabel("Select color:");
		lblSelectColor.setBounds(6, 61, 88, 15);
		add(lblSelectColor);

		/**
		 * Combobox items
		 */

		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(100, 61, 186, 24);
		comboBox.addItem("Red");
		comboBox.addItem("Blue");
		comboBox.addItem("Green");
		comboBox.addItem("Pink");
		comboBox.addItem("Cyan");
		comboBox.addItem("Magenta");

		add(comboBox);

		JLabel lblDifficulty = new JLabel("Difficulty:");
		lblDifficulty.setBounds(6, 86, 67, 15);
		add(lblDifficulty);

		JRadioButton rdbtnEasy = new JRadioButton("Easy");
		rdbtnEasy.setSelected(true);
		rdbtnEasy.setBounds(100, 88, 58, 23);
		add(rdbtnEasy);

		JRadioButton rdbtnMedium = new JRadioButton("Medium");
		rdbtnMedium.setBounds(100, 115, 80, 23);
		add(rdbtnMedium);

		JRadioButton rdbtnHard = new JRadioButton("Hard");
		rdbtnHard.setBounds(100, 143, 59, 23);
		add(rdbtnHard);

		buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnEasy);
		buttonGroup.add(rdbtnMedium);
		buttonGroup.add(rdbtnHard);
		// buttonGroup.getSelection()

		JButton btnStart = new JButton("Start");

		btnStart.addActionListener(new ActionListener() {

			/**
			 * Select combobox option is setting.
			 */

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				Color selectedColor = Color.pink;
				switch (comboBox.getSelectedItem().toString()) {

				case "Red":
					selectedColor = Color.red;
					break;
				case "Blue":
					selectedColor = Color.blue;
					break;
				case "Green":
					selectedColor = Color.green;
					break;
				case "Pink":
					selectedColor = Color.pink;
					break;
				case "Cyan":
					selectedColor = Color.cyan;
					break;
				case "Magenta":
					selectedColor = Color.magenta;
					break;

				}

				/**
				 * A enum class's items shows above radioButton / select
				 * 
				 */

				Difficulty difficulty = Difficulty.EASY;

				if (rdbtnEasy.isSelected()) {

					difficulty = Difficulty.EASY;

				} else if (rdbtnMedium.isSelected()) {

					difficulty = Difficulty.NORMAL;

				} else if (rdbtnHard.isSelected()) {

					difficulty = Difficulty.HARD;

				} else {
				}

				GameLogic gameLogic = new GameLogic(textField.getText(), selectedColor, difficulty);
				gameLogic.startApplication();

			}
		});

		btnStart.setBounds(100, 194, 70, 25);
		add(btnStart);

		JButton btnAbout = new JButton("About");
		btnAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				JOptionPane.showConfirmDialog(FirstPanel.this,
						"Bu yazilim GPL altindadır, \nOzgur bir ortamda \nOzgur yazilimlar kullanilarak "
								+ "\nOzgur bireyler tarafindan gelistirilmistir." + "\n LKD 2017 #Java",
						"About", JOptionPane.DEFAULT_OPTION);

			}
		});
		btnAbout.setBounds(100, 231, 76, 25);
		add(btnAbout);

		passwordField = new JPasswordField();
		passwordField.setBounds(100, 37, 144, 19);
		add(passwordField);

	}
}
