package view;

import java.util.Scanner;

import javax.swing.JOptionPane;

public abstract class AbsView {
	protected String getKeyInputString(String str) {//Ű����κ��� ���� �Է¹ޱ� ���� �޼ҵ�
		String input = JOptionPane.showInputDialog(str + "�Է�");
		return input;
	}
	
	protected String getEnter() {
		Scanner in = new Scanner(System.in);
		return in.nextLine();

	}
	
	protected void msg(String str) {
		JOptionPane.showMessageDialog(null, str);
	}
	
	abstract public void show();
}






 