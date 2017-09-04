package armyofdragons.api.aio.gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeListener;

import armyofdragons.api.aio.AIOScript;

import javax.swing.event.ChangeEvent;
import javax.swing.JButton;

public class MainGUI extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4287392883697819511L;
	
	
	private JPanel contentPane;
	private JTextField txtWeaponId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainGUI frame = new MainGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainGUI() {
		setResizable(false);
		setTitle("ArmyofDragon's NightmareZone [Free Version]");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 430, 400);
		contentPane = new JPanel();
		contentPane.setBackground(Color.LIGHT_GRAY);
		contentPane.setToolTipText("Select the options you would like for the script and press start.");
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		ButtonGroup group = new ButtonGroup();
		
		JCheckBox chckbxUsingDharoksMethod = new JCheckBox("Using Dharok's method?");
		chckbxUsingDharoksMethod.setBounds(6, 17, 181, 23);
		contentPane.add(chckbxUsingDharoksMethod);
		
		JCheckBox chckbxSpecialAttacks = new JCheckBox("Special Attacks");
		chckbxSpecialAttacks.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				if(chckbxSpecialAttacks.isSelected()) {
					txtWeaponId.setEnabled(true);
					txtWeaponId.setEditable(true);
				}else{
					txtWeaponId.setEnabled(false);
					txtWeaponId.setEditable(false);
				}
			}
		});
		chckbxSpecialAttacks.setBounds(6, 78, 139, 23);
		contentPane.add(chckbxSpecialAttacks);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Activate Power Surges?");
		chckbxNewCheckBox.setBounds(6, 148, 190, 23);
		contentPane.add(chckbxNewCheckBox);
		
		txtWeaponId = new JTextField();
		txtWeaponId.setText("Weapon ID");
		txtWeaponId.setEditable(false);
		txtWeaponId.setEnabled(false);
		txtWeaponId.setToolTipText("Put the ID of the special weapon you are using here.");
		txtWeaponId.setBounds(140, 105, 86, 20);
		contentPane.add(txtWeaponId);
		txtWeaponId.setColumns(10);
		
		JLabel lblSpecialWeaponId = new JLabel("Special Weapon ID:");
		lblSpecialWeaponId.setBounds(16, 108, 129, 14);
		contentPane.add(lblSpecialWeaponId);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(6, 54, 398, 2);
		contentPane.add(separator);
		
		JLabel lblPotions = new JLabel("Potion(s):");
		lblPotions.setBounds(6, 203, 74, 14);
		contentPane.add(lblPotions);
		
		JRadioButton rdbtnOverloadsPrayer = new JRadioButton("Overloads + Prayer Potions");
		rdbtnOverloadsPrayer.setToolTipText("The script will use Overloads and Prayer Potions.");
		group.add(rdbtnOverloadsPrayer);
		rdbtnOverloadsPrayer.setSelected(true);
		rdbtnOverloadsPrayer.setBounds(75, 199, 215, 23);
		contentPane.add(rdbtnOverloadsPrayer);
		
		JRadioButton rdbtnOverloadsAbsorption = new JRadioButton("Overloads + Absorption Potions");
		rdbtnOverloadsAbsorption.setToolTipText("The script will use Overload and Absorption Potions.");
		group.add(rdbtnOverloadsAbsorption);
		rdbtnOverloadsAbsorption.setBounds(75, 224, 215, 23);
		contentPane.add(rdbtnOverloadsAbsorption);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(6, 275, 398, 2);
		contentPane.add(separator_1);
		
		JButton btnStartScript = new JButton("Start Script");
		btnStartScript.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				close();
			}
		});
		
		btnStartScript.setBounds(140, 327, 130, 23);
		contentPane.add(btnStartScript);
		
		JLabel lblBeforeYouStart = new JLabel("The script will not run unless you are in the Nightmare Zone.");
		lblBeforeYouStart.setBounds(40, 287, 349, 14);
		contentPane.add(lblBeforeYouStart);
	}
	
	public void close() {
		this.setVisible(false);
		this.dispose();
		
		/*
		 * --------------
		 * 
		 * Settings / Config
		 * 	   Code Block
		 * 
		 * --------------
		 */
	}
	
	public void dispose() {
		System.out.println("Window Disposed - Memory Freed");
		super.dispose();
	}
}
