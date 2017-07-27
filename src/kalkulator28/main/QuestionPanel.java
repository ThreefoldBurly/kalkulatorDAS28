package main;

import java.awt.BorderLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class QuestionPanel extends JPanel {
	private static final long serialVersionUID = 6417667073688047532L;

	private JTextField field;
	private JComboBox combo;

	QuestionPanel(String questionString, int comboRange) {
		super(new BorderLayout());

		this.add(createQuestionPanel(questionString), BorderLayout.WEST);
		this.add(createCombo(comboRange), BorderLayout.EAST);
	}

	QuestionPanel(String questionString, int comboRange, int strut) {
		super(new BorderLayout());

		this.add(createQuestionPanel(questionString), BorderLayout.WEST);
		this.add(createCombo(comboRange), BorderLayout.EAST);
		this.add(Box.createHorizontalStrut(strut));
	}

	QuestionPanel(String questionString) {
		super(new BorderLayout());
		JPanel questionPanel = createQuestionPanel(questionString);
		field.setColumns(3);
		this.add(questionPanel, BorderLayout.WEST);
	}

	static String[] createComboArray(int range) {
		String[] comboArray = new String[range];
		for (int i = 1; i <= range; i++) {
			comboArray[i - 1] = new Integer(i).toString();
		}
		return comboArray;
	}

	private JPanel createQuestionPanel(String questionString) {
		JPanel questionPanel = new JPanel();
		JLabel question = new JLabel(questionString);
		field = new JTextField(2);
		field.setMargin(new Insets(0, 4, 0, 4));
		field.setHorizontalAlignment(JTextField.RIGHT);
		questionPanel.add(question);
		questionPanel.add(field);

		return questionPanel;
	}

	private JComboBox createCombo(int range) {
		combo = new JComboBox(createComboArray(range));
		combo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				field.setText((String) combo.getSelectedItem());
			}
		});

		return combo;
	}

	JTextField getField() {
		return field;
	}

	JComboBox getCombo() {
		return combo;
	}
}
