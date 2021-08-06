package semester2.uebungsblatt04;

import javax.swing.*;
import java.awt.*;

import static java.awt.BorderLayout.*;
import static java.awt.Font.BOLD;
import static java.awt.Font.MONOSPACED;

final class CalculatorView extends JFrame {

    final JLabel expression = new JLabel();

    final JButton button0 = new JButton("0");
    final JButton button1 = new JButton("1");
    final JButton button2 = new JButton("2");
    final JButton button3 = new JButton("3");
    final JButton button4 = new JButton("4");
    final JButton button5 = new JButton("5");
    final JButton button6 = new JButton("6");
    final JButton button7 = new JButton("7");
    final JButton button8 = new JButton("8");
    final JButton button9 = new JButton("9");

    final JButton clearButton = new JButton("clear");

    final JButton multiplyButton = new JButton("*");
    final JButton divideButton = new JButton("/");
    final JButton addButton = new JButton("+");
    final JButton subtractButton = new JButton("-");

    final JButton evaluateButton = new JButton("Evaluate expression");

    CalculatorView() {
        super("Calculator");
    }

    void startDisplaying() {
        final Font bigFont = new Font(MONOSPACED, BOLD, 20);
        final Font smallFont = new Font(MONOSPACED, BOLD, 10);


        final Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());


        contentPane.add(NORTH, expression).setFont(bigFont);


        final JPanel numPad = new JPanel(new GridLayout(4, 3));
        numPad.add(button7).setFont(bigFont);
        numPad.add(button8).setFont(bigFont);
        numPad.add(button9).setFont(bigFont);
        numPad.add(button4).setFont(bigFont);
        numPad.add(button5).setFont(bigFont);
        numPad.add(button6).setFont(bigFont);
        numPad.add(button1).setFont(bigFont);
        numPad.add(button2).setFont(bigFont);
        numPad.add(button3).setFont(bigFont);
        numPad.add(button0).setFont(bigFont);
        numPad.add(clearButton).setFont(smallFont);

        final JPanel operatorPad = new JPanel(new GridLayout(2, 2));
        operatorPad.add(multiplyButton).setFont(bigFont);
        operatorPad.add(divideButton).setFont(bigFont);
        operatorPad.add(addButton).setFont(bigFont);
        operatorPad.add(subtractButton).setFont(bigFont);

        final JPanel numPadAndOperatorPad = new JPanel(new GridLayout(1, 2));
        numPadAndOperatorPad.add(numPad);
        numPadAndOperatorPad.add(operatorPad);

        contentPane.add(CENTER, numPadAndOperatorPad);


        contentPane.add(SOUTH, evaluateButton).setFont(bigFont);


        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(400, 300);
        setVisible(true);
    }
}
