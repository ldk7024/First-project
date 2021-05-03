package BabyProductsRental;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class CreateGUI {
	private JFrame frame;
	private JTextField tfd_IDInput;
	private JPasswordField tfd_PWInput;
	private JPasswordField tfd_ConfirmPWInput;
	private JTextField tfd_NameInput;
	private JTextField tfd_PhoneNumberInput;
	private JTextField tfd_AddressInput;
	private JTextField tfd_BankAccountInput;

	DAO_C dao_C = null;
	VO_C vo_C = null;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateGUI window = new CreateGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CreateGUI() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 1200, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel lbl_BackHome = new JLabel("\uD68C\uC6D0\uAC00\uC785");
		lbl_BackHome.setFont(new Font("����", Font.BOLD, 48));
		lbl_BackHome.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_BackHome.setBounds(0, 10, 1184, 87);
		frame.getContentPane().add(lbl_BackHome);

		tfd_IDInput = new JTextField();
		tfd_IDInput.setBounds(228, 180, 777, 24);
		frame.getContentPane().add(tfd_IDInput);
		tfd_IDInput.setColumns(10);

		tfd_PWInput = new JPasswordField();
		tfd_PWInput.setBounds(228, 220, 777, 24);
		frame.getContentPane().add(tfd_PWInput);

		tfd_ConfirmPWInput = new JPasswordField();
		tfd_ConfirmPWInput.setBounds(228, 260, 777, 24);
		frame.getContentPane().add(tfd_ConfirmPWInput);

		tfd_NameInput = new JTextField();
		tfd_NameInput.setBounds(228, 300, 777, 24);
		frame.getContentPane().add(tfd_NameInput);
		tfd_NameInput.setColumns(10);

		tfd_PhoneNumberInput = new JTextField();
		tfd_PhoneNumberInput.setBounds(228, 340, 777, 24);
		frame.getContentPane().add(tfd_PhoneNumberInput);
		tfd_PhoneNumberInput.setColumns(10);

		tfd_AddressInput = new JTextField();
		tfd_AddressInput.setBounds(228, 380, 777, 24);
		frame.getContentPane().add(tfd_AddressInput);
		tfd_AddressInput.setColumns(10);

		tfd_BankAccountInput = new JTextField();
		tfd_BankAccountInput.setBounds(228, 420, 777, 24);
		frame.getContentPane().add(tfd_BankAccountInput);
		tfd_BankAccountInput.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("ID:");
		lblNewLabel_1.setFont(new Font("����", Font.PLAIN, 24));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(120, 180, 96, 24);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblPw = new JLabel("PW:");
		lblPw.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPw.setFont(new Font("����", Font.PLAIN, 24));
		lblPw.setBounds(50, 220, 168, 29);
		frame.getContentPane().add(lblPw);

		JLabel lblNewLabel02 = new JLabel("Confirm Password:");
		lblNewLabel02.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel02.setFont(new Font("����", Font.PLAIN, 24));
		lblNewLabel02.setBounds(0, 256, 216, 29);
		frame.getContentPane().add(lblNewLabel02);

		JLabel lbl_NameInput = new JLabel("Name:");
		lbl_NameInput.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl_NameInput.setFont(new Font("����", Font.PLAIN, 24));
		lbl_NameInput.setBounds(92, 295, 124, 35);
		frame.getContentPane().add(lbl_NameInput);

		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddress.setFont(new Font("����", Font.PLAIN, 24));
		lblAddress.setBounds(37, 380, 179, 35);
		frame.getContentPane().add(lblAddress);

		JLabel lblPhoneNumber = new JLabel("Phone number:");
		lblPhoneNumber.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhoneNumber.setFont(new Font("����", Font.PLAIN, 24));
		lblPhoneNumber.setBounds(44, 341, 172, 29);
		frame.getContentPane().add(lblPhoneNumber);

		JLabel lblBankAccont = new JLabel("Bank accont:");
		lblBankAccont.setHorizontalAlignment(SwingConstants.RIGHT);
		lblBankAccont.setFont(new Font("����", Font.PLAIN, 24));
		lblBankAccont.setBounds(38, 420, 178, 24);
		frame.getContentPane().add(lblBankAccont);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		lblNewLabel_2.setBounds(0, 106, 1184, 1);
		frame.getContentPane().add(lblNewLabel_2);

		JCheckBox cbx_PrivateInfoAgree = new JCheckBox("\uAC1C\uC778\uC815\uBCF4 \uD65C\uC6A9 \uB3D9\uC758");
		cbx_PrivateInfoAgree.setFont(new Font("����", Font.PLAIN, 30));
		cbx_PrivateInfoAgree.setBackground(Color.WHITE);
		cbx_PrivateInfoAgree.setBounds(183, 461, 331, 72);
		frame.getContentPane().add(cbx_PrivateInfoAgree);

		// ȸ������ ��ư
		JButton btn_SignUp = new JButton("\uAC00\uC785\uD558\uAE30");
		btn_SignUp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// ȸ�����Կ� �ʿ��� ������ �Է¹����� �ؽ�Ʈ �ʵ��� ���ڸ� �����ͼ� ������ ����.
				String id = tfd_IDInput.getText();
				String pw = tfd_PWInput.getText();
				String confirmpassword = tfd_ConfirmPWInput.getText();
				String name = tfd_NameInput.getText();
				String phonenumber = tfd_PhoneNumberInput.getText();
				String address = tfd_AddressInput.getText();
				String bankaccount = tfd_BankAccountInput.getText();
				// �ű� ȸ�����Խ� ��ġ���� �������� �ʴ� �����̹Ƿ� money�� 0���� ����.
				int money = 0;

				// ���� �ؽ�Ʈ �ʵ忡 ������� ������
				if (!id.equals("") && !pw.equals("") && !confirmpassword.equals("") && !name.equals("")
						&& !phonenumber.equals("") && !address.equals("") && !bankaccount.equals("")) {
					// ���� �н������ �н����� Ȯ���� ���� ������
					if (pw.equals(confirmpassword)) {
						// ���� �������� Ȱ�� ���� üũ�ڽ��� üũ�Ǿ�������
						if (cbx_PrivateInfoAgree.isSelected()) {
							// insert_Create�޼��带 �̿��ؼ� DB�� ���ο� �� �����͸� �Է� �� ����.
							dao_C = new DAO_C();
							int cnt = dao_C.insert_Create(id, pw, name, phonenumber, address, bankaccount, money);
							// �Է� ���� ���� ���������� ���� cnt�� ���� �����Ѵ�.
							// ���� cnt�� ���� ����� => ���� ���������� �ԷµǾ��ٴ� �ǹ�.
							if (cnt > 0) {
								// �˸�â ��� �� LoginGUIâ ����
								JOptionPane.showMessageDialog(null, "ȸ�������� �Ǿ����ϴ�.");
								new LoginGUI();
								frame.dispose();
							} else {
								JOptionPane.showMessageDialog(null, id+ " ȸ�������� �Ǿ����ϴ�", "ȸ������", JOptionPane.ERROR_MESSAGE);
							}
						} else {
							JOptionPane.showMessageDialog(null, "�������� Ȱ�� ���Ǹ� üũ���ּ���", "ȸ������", JOptionPane.ERROR_MESSAGE);
						}
					} else {
						JOptionPane.showMessageDialog(null, "�н����带 �����ּ���", "ȸ������", JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "��� ������ �Է��Ͻÿ�", "ȸ������", JOptionPane.ERROR_MESSAGE);
				}

			}
		});
		btn_SignUp.setFont(new Font("����", Font.PLAIN, 25));
		btn_SignUp.setForeground(Color.BLACK);
		btn_SignUp.setBackground(new Color(255, 255, 255));
		btn_SignUp.setBounds(466, 539, 347, 122);
		frame.getContentPane().add(btn_SignUp);

	}
}
