package kalkulatorDAS28.main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import kalkulatorDAS28.lib.FontConstants;

public class DataBox extends Box {
	private static final long serialVersionUID = -1322876446530464627L;

	JTextField firstField;
	JTextField secondField;
	JTextField thirdField;
	JTextField fourthField;
	JButton calculateButton;

	public DataBox() {
		super(BoxLayout.Y_AXIS);
		this.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

		QuestionPanel one = new QuestionPanel("Podaj liczbę bolesnych stawów u Pacjenta: ", 28);
		QuestionPanel two = new QuestionPanel("Podaj liczbę stawów z obrzękiem u Pacjenta: ", 28);
		QuestionPanel three = new QuestionPanel("Podaj ocenę aktywności choroby wg Pacjenta: ", 100, 50);
		QuestionPanel four = new QuestionPanel("Podaj wysokość wskaźnika OB lub CRP: ");

		firstField = one.getField();
		secondField = two.getField();
		thirdField = three.getField();
		fourthField = four.getField();

		JComboBox firstCombo = one.getCombo();
		JComboBox secondCombo = two.getCombo();
		JComboBox thirdCombo = three.getCombo();
		ComboListener cl = new ComboListener();
		firstCombo.addActionListener(cl);
		secondCombo.addActionListener(cl);
		thirdCombo.addActionListener(cl);

		this.add(one);
		this.add(Box.createVerticalStrut(15));
		this.add(two);
		this.add(Box.createVerticalStrut(15));
		this.add(three);
		this.add(Box.createVerticalStrut(15));
		this.add(four);
		this.add(Box.createVerticalStrut(25));
		this.add(createAnswerPanel());
	}

	private JPanel createAnswerPanel() {
		JPanel answerPanel = new JPanel(new BorderLayout());

		JPanel panel = new JPanel();
		JLabel answerLabel = new JLabel("Wskaźnik DAS28 dla tego Pacjenta wynosi: ");
		calculateButton = new JButton("Oblicz");
		calculateButton.setFont(FontConstants.MEDIUM_FONT_BOLD);
		calculateButton.addActionListener(new CalculateButtonListener());
		panel.add(answerLabel);
		panel.add(calculateButton);

		answerPanel.add(panel, BorderLayout.EAST);
		return answerPanel;
	}

	private void makeCalculation() {
		boolean shallCalculate = false;
		boolean firstValid = false;
		boolean secondValid = false;
		boolean thirdValid = false;
		boolean fourthValid = false;

		String lbs28 = firstField.getText();
		String los28 = secondField.getText();
		String vas = thirdField.getText();
		String obcrp = fourthField.getText();

		int lbs28int = 0;
		int los28int = 0;
		int vasint = 0;
		int obcrpint = 0;
		try {
			lbs28int = new Integer(lbs28);
			los28int = new Integer(los28);
			vasint = new Integer(vas);
			obcrpint = new Integer(obcrp);
			if (null != lbs28 && lbs28int > 0 && lbs28int <= 28) {
				firstValid = true;
			}
			if (null != los28 && los28int > 0 && los28int <= 28) {
				secondValid = true;
			}
			if (null != vas && vasint > 0 && vasint <= 100) {
				thirdValid = true;
			}
			if (null != obcrp && obcrpint > 0 && obcrpint <= 5000) {
				fourthValid = true;
			}
		} catch (NumberFormatException ex) {
			ex.printStackTrace();
		}

		if (firstValid && secondValid && thirdValid && fourthValid) {
			shallCalculate = true;
		}

		if (shallCalculate) {
			Calculus calculus = new Calculus(lbs28int, los28int, vasint, obcrpint);
			calculateButton.setText(calculus.calculateResult());
		}
	}

	private class CalculateButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			makeCalculation();
		}
	}

	private class ComboListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			//TODO: SYNCHRONIZACJA!			
			makeCalculation();
		}
	}
}
