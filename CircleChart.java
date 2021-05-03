package BabyProductsRental;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CircleChart extends JFrame {

	Container contentPane;
	String[] sArr = { "������ǰ", "�̵���ǰ", "ħ����ǰ", "������ǰ", "�峭��", "���ƽı�", "����ǰ", "�Ƶ���", "���ڱ��" };
	int[] arr = { 70, 30, 25, 105, 92, 12, 34, 79, 58 };
	float[] fArr = new float[sArr.length];
	int[] iArr = new int[sArr.length];
	int[] arcAngle = new int[sArr.length];
	public ChartPanel chartPanel = new ChartPanel();

	Color[] color = { new Color(253, 115, 0), new Color(255, 175, 0), new Color(255, 236, 0), new Color(213, 243, 11),
			new Color(45, 203, 117), new Color(127, 127, 127), new Color(166, 166, 166), new Color(191, 191, 191),
			new Color(217, 217, 217), new Color(242, 242, 242), };

	public CircleChart(int[] rankInt) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = this.getContentPane();
		contentPane.add(chartPanel);
		chartPanel.setBounds(-300, -300, 300, 300);
		setVisible(true);
		drawChart(rankInt);
	}

	void drawChart(int[] rankInt) {
		Chart c = new Chart();
		sArr = c.selectSort(arr, sArr);
		arr = c.selectSort(arr);
		fArr = c.percentArray(arr);
		iArr = c.floatToIntArry(fArr);

		iArr = c.floatToIntArry(fArr);
		System.out.println(c.print(arr));
		System.out.println(c.print(fArr));
		System.out.println(c.print(iArr));
		System.out.println(c.sum_arr(iArr));

		for (int i = 0; i < rankInt.length; i++) {
			arcAngle[i] = (int) Math.round((double) rankInt[i] / (double) c.sum_arr(rankInt) * 360);
			chartPanel.repaint(); // ��Ʈ�г��� PAINTȣ��
		}
	}

	class ChartPanel extends JPanel { // ��Ʈ ǥ�� �г�
		public void paintComponent(Graphics g) {
			super.paintComponent(g);// �θ� ����Ʈȣ��
			int startAngle = 90; // 90���� 12�� ����
			for (int i = 0; i < iArr.length; i++) {
				g.setColor(color[i]);
				g.fillArc(150, 50, 200, 200, startAngle, -arcAngle[i]); // �ޱ��� ������ �ָ� �ð����
				startAngle -= arcAngle[i];// ������ �ֱ����� ���־�� ��.
			}
		
		}
	}

}
