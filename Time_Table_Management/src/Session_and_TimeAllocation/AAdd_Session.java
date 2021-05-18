// IT19210452
// W.M.S.T Wijekoon

package Session_and_TimeAllocation;

import java.awt.Color;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import DBC.DBConnection;
import net.proteanit.sql.DbUtils;

import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import java.awt.ScrollPane;
import javax.swing.UIManager;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JMenuBar;

public class AAdd_Session {

	private JFrame AddsessFrm;

	

	
	private JComboBox lec1;
	private JComboBox lec2;
	private JComboBox subname;
	private JComboBox tag;
	private JComboBox groupId;
	private JTextField txtSubcod;
	private JTextField txtTimeTableManagement;
	
	//load data to dropdown lec1
	  public  void  loadLecturer1(){ 
		  try {

				Connection con = DBConnection.connect();

				String query="select * from lecturers ";
				PreparedStatement pst=con.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				
				while(rs.next())
				{
					String name =rs.getString("lectureName");
					lec1.addItem(name);
					 
				}

				con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
	
}
		//load data to dropdown lec2
	  public  void  loadLecturer2(){ 
		  try {

				Connection con = DBConnection.connect();

				String query="select * from lecturers ";
				PreparedStatement pst=con.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				
				while(rs.next())
				{
					String name =rs.getString("lectureName");
					lec2.addItem(name);
					 
				}

				con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}

}
		//load data to dropdown subject name
	  public  void  loadSubjectName(){ 
		  try {

				Connection con = DBConnection.connect();

				String query="select * from subjects ";
				PreparedStatement pst=con.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				
				while(rs.next())
				{
					String name =rs.getString("subName");
					subname.addItem(name);
					 
				}

				con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}

}
	//load data to dropdown tag
	  public  void  loadTag(){ 
		  try {

				Connection con = DBConnection.connect();

				String query="select * from Tags ";
				PreparedStatement pst=con.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				
				while(rs.next())
				{
					String name =rs.getString("RelatedTag");
					tag.addItem(name);
					 
				}

				con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}

}
	//load data to dropdown group id
	  public  void  loadGroup(){ 
		  try {

				Connection con = DBConnection.connect();

				String query="select * from StudentGroup ";
				PreparedStatement pst=con.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				
				while(rs.next())
				{
					String name =rs.getString("GroupID");
					groupId.addItem(name);
					 
				}

				con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}

}
	//load data to dropdown Subgroup id
	  public  void  loadSubGroup(){ 
		  try {

				Connection con = DBConnection.connect();

				String query="select * from StudentGroup ";
				PreparedStatement pst=con.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				
				while(rs.next())
				{
					String name =rs.getString("SubGroupID");
					groupId.addItem(name);
					 
				}

				con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}

}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AAdd_Session window = new AAdd_Session();
					window.AddsessFrm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public AAdd_Session() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		AddsessFrm = new JFrame();
		AddsessFrm.getContentPane().setForeground(SystemColor.activeCaption);
		AddsessFrm.getContentPane().setBackground(SystemColor.activeCaption);
		AddsessFrm.setBackground(Color.YELLOW);
		AddsessFrm.setResizable(false);
		AddsessFrm.setTitle("Sessions");
		AddsessFrm.setSize(1400, 860);
		AddsessFrm.setBounds(0, 0, 1350, 700);
		AddsessFrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		AddsessFrm.getContentPane().setLayout(null);
		AddsessFrm.setLocationRelativeTo(null);
		AddsessFrm.setVisible(true);

		JPanel panel_2 = new JPanel();
		panel_2.setForeground(SystemColor.activeCaption);
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(230, 230, 250));
		panel_2.setBounds(260, 128, 1084, 543);
		AddsessFrm.getContentPane().add(panel_2);

		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBackground(Color.DARK_GRAY);
		panel_3.setBounds(10, 54, 1055, 491);
		panel_2.add(panel_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(771, 217, 239, 57);
		panel_3.add(scrollPane);
		
		JTextArea sign = new JTextArea();
		sign.setEditable(false);
		sign.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 12));
		scrollPane.setViewportView(sign);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollPane.setRowHeaderView(scrollBar);

		JLabel lblLecturer = new JLabel("Lecturer 1");
		lblLecturer.setForeground(Color.WHITE);
		lblLecturer.setBackground(Color.WHITE);
		lblLecturer.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLecturer.setBounds(70, 37, 96, 23);
		panel_3.add(lblLecturer);

		 lec1 = new JComboBox();
		 lec1.setModel(new DefaultComboBoxModel(new String[] {"----------Select Lecturer 1 ----------"}));
		lec1.setBounds(254, 38, 239, 28);
		panel_3.add(lec1);

		JLabel label_1 = new JLabel("Tag");
		label_1.setForeground(Color.WHITE);
		label_1.setBackground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(72, 278, 132, 23);
		panel_3.add(label_1);

		 subname = new JComboBox();
	
		 subname.setModel(new DefaultComboBoxModel(new String[] {"----------Select Subject----------"}));
		subname.setBounds(254, 159, 239, 28);
		panel_3.add(subname);

		 tag = new JComboBox();
		 tag.setModel(new DefaultComboBoxModel(new String[] {"------------Select Tag ------------"}));
		tag.setBounds(254, 279, 239, 28);
		panel_3.add(tag);

		JLabel label_2 = new JLabel("Group/Sub Group ID");
		label_2.setForeground(Color.WHITE);
		label_2.setBackground(Color.WHITE);
		label_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_2.setBounds(611, 37, 150, 23);
		panel_3.add(label_2);

		 groupId = new JComboBox();
		groupId.setModel(new DefaultComboBoxModel(new String[] {"--------Select Group/Sub Group ID--------"}));
		groupId.setBounds(771, 38, 239, 28);
		panel_3.add(groupId);

		JLabel lblLecturer_1 = new JLabel("Lecturer 2");
		lblLecturer_1.setForeground(Color.WHITE);
		lblLecturer_1.setBackground(Color.WHITE);
		lblLecturer_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLecturer_1.setBounds(70, 98, 149, 23);
		panel_3.add(lblLecturer_1);

		JLabel label_4 = new JLabel("Subject Name");
		label_4.setForeground(Color.WHITE);
		label_4.setBackground(Color.WHITE);
		label_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_4.setBounds(70, 158, 149, 23);
		panel_3.add(label_4);

		JLabel label_5 = new JLabel("Selected Subject Code");
		label_5.setForeground(Color.WHITE);
		label_5.setBackground(Color.WHITE);
		label_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_5.setBounds(70, 217, 149, 23);
		panel_3.add(label_5);

		JLabel label_6 = new JLabel("No Of Students");
		label_6.setForeground(Color.WHITE);
		label_6.setBackground(Color.WHITE);
		label_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_6.setBounds(611, 98, 108, 23);
		panel_3.add(label_6);

		JSpinner students = new JSpinner();
		students.setFont(new Font("Tahoma", Font.BOLD, 12));
		students.setBounds(771, 98, 239, 28);
		panel_3.add(students);

		JLabel label_7 = new JLabel("Duration(hrs)");
		label_7.setForeground(Color.WHITE);
		label_7.setBackground(Color.WHITE);
		label_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_7.setBounds(611, 158, 108, 23);
		panel_3.add(label_7);

		JSpinner duration = new JSpinner();
		duration.setFont(new Font("Tahoma", Font.BOLD, 12));
		duration.setBounds(771, 158, 239, 28);
		panel_3.add(duration);

		
		
		

		JButton btnClear = new JButton("CLEAR");
		btnClear.setToolTipText("Click button to clear");
		
		btnClear.setForeground(Color.WHITE);
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClear.setEnabled(true);
		btnClear.setBackground(new Color(0, 128, 128));
		btnClear.setBounds(620, 418, 141, 31);
		panel_3.add(btnClear);
		
		 lec2 = new JComboBox();
		 lec2.setModel(new DefaultComboBoxModel(new String[] {"-"}));
		lec2.setBounds(254, 100, 239, 28);
		panel_3.add(lec2);
		
		JLabel lblSessionSignature = new JLabel("Session Signature");
		lblSessionSignature.setForeground(Color.WHITE);
		lblSessionSignature.setBackground(Color.WHITE);
		lblSessionSignature.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblSessionSignature.setBounds(611, 217, 126, 23);
		panel_3.add(lblSessionSignature);
		
		
		
		//generate session signature
		JButton btnGensign = new JButton("GENERATE SESSION SIGNATURE");
		btnGensign.setToolTipText("Click button to generate session signature");
		btnGensign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String lecregx = "-";
				String lecrs = "----------Select Lecturer 1 ----------";
				String namer = "----------Select Subject----------";
				String tagr = "------------Select Tag ------------";
				String grpidr = "--------Select Group/Sub Group ID--------";
				
				
				if(lec1.getSelectedItem().toString().equals(lecrs)||subname.getSelectedItem().toString().equals(namer)|| tag.getSelectedItem().toString().equals(tagr)|| groupId.getSelectedItem().toString().equals(grpidr)|| students.getValue().equals(0)|| duration.getValue().equals(0))
				{
					JOptionPane.showMessageDialog(null, "       Please Enter Values","Alert",JOptionPane.WARNING_MESSAGE);
	
					
				}else {
				if(lec2.getSelectedItem().toString().matches(lecregx ));
				{
					sign.setText(lec1.getSelectedItem().toString()+ " - "+ txtSubcod.getText()+" - "+ subname.getSelectedItem().toString()
							+" - "+tag.getSelectedItem().toString()+" - "+groupId.getSelectedItem().toString()+" - "+students.getValue().toString()+" - "+
							duration.getValue().toString());
					
				}
				
				if(!(lec2.getSelectedItem().toString().matches(lecregx)))
				{
				sign.setText(lec1.getSelectedItem().toString()+" - " + lec2.getSelectedItem().toString()+ " - "+ txtSubcod.getText()+" - "+ subname.getSelectedItem().toString()
						+" - "+tag.getSelectedItem().toString()+" - "+groupId.getSelectedItem().toString()+" - "+students.getValue().toString()+" - "+
						duration.getValue().toString());
				
				}
				
				JLabel label8 = new JLabel("Session Signature Generated Successfully");
				label8.setHorizontalAlignment(SwingConstants.CENTER);
				JOptionPane.showMessageDialog(null, label8);
				}
				
			}
		});
		
		
		// Add new session
		JButton btnAdd = new JButton("ADD");
		btnAdd.setToolTipText("Click button to save details");
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnAdd.setBackground(new Color(0, 128, 128));
		btnAdd.setBounds(339, 418, 141, 31);
		panel_3.add(btnAdd);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String lect1 = lec1.getSelectedItem().toString();
				String lect2 = lec2.getSelectedItem().toString();
				String subjname = subname.getSelectedItem().toString();
				String subjcode = txtSubcod.getText();
				String  tags = tag.getSelectedItem().toString();
				String grpId = groupId.getSelectedItem().toString();
				String count = students.getValue().toString();
				String hour = duration.getValue().toString();
				String signature =sign.getText();
				
				
		
				String lecrs = "----------Select Lecturer 1 ----------";
				String namer = "----------Select Subject----------";
				String tagr = "------------Select Tag ------------";
				String grpidr = "--------Select Group/Sub Group ID--------";
				
				
				if(sign.getText().equals("")) {
			
					JOptionPane.showMessageDialog(null, "Please Generate Session Signature.","Alert",JOptionPane.WARNING_MESSAGE);

				}
				else {

					try {

						if(lec1.getSelectedItem().toString().equals(lecrs) || subname.getSelectedItem().equals(namer) || txtSubcod.getText().equals("") ||tag.getSelectedItem().toString().equals(tagr)||groupId.getSelectedItem().toString().equals(grpidr)|| duration.getValue().equals(0)||students.getValue().equals(0)) {
							JOptionPane.showMessageDialog(null, "       Please Fill All the Fields","Failed",JOptionPane.WARNING_MESSAGE);

						}else {
							
							
						Connection con = DBConnection.connect();
						
				
						String query = "INSERT INTO session values(null, '" + lect1 + "','" + lect2 + "','" + subjcode + "', '" + subjname + "', '" + tags + "', '" + grpId + "','"+count+"','"+hour+"','"+signature+"')";

						Statement sta = con.createStatement();
						int x = sta.executeUpdate(query);
						if (x == 0) {


							JLabel label = new JLabel("This is alredy exist");
							label.setHorizontalAlignment(SwingConstants.CENTER);
							JOptionPane.showMessageDialog(null, label);


							// JOptionPane.showMessageDialog(btnNewButton, "This is alredy exist");
						} else {
							//JOptionPane.showMessageDialog(btnNewButton,"Welcome, Student Group details successfully inserted!");

							JLabel label = new JLabel("Session Created Successfully");
							label.setHorizontalAlignment(SwingConstants.CENTER);
							JOptionPane.showMessageDialog(null, label);



						}
						con.close();
					}} catch (Exception exception) {
						System.out.println("Failed!!");

					}

				}
				
				
			}
		});
		
		btnGensign.setForeground(Color.WHITE);
		btnGensign.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnGensign.setBackground(new Color(119, 136, 153));
		btnGensign.setBounds(611, 304, 399, 36);
		panel_3.add(btnGensign);
		
		txtSubcod = new JTextField();
		txtSubcod.setBackground(Color.WHITE);
		txtSubcod.setEditable(false);
		txtSubcod.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 12));
		txtSubcod.setBounds(254, 219, 239, 28);
		panel_3.add(txtSubcod);
		txtSubcod.setColumns(10);
		
		
		//Display subCode when entering subName
		 subname.addActionListener(new ActionListener() {
			 	public void actionPerformed(ActionEvent arg0) {
			 		
			 		try {
						String subject = subname.getSelectedItem().toString();
						Connection con = DBConnection.connect();
						String query = "select subCode from subjects where subName = '" + subject + "'";
						PreparedStatement pst = con.prepareStatement(query);
						ResultSet rs = pst.executeQuery();
						
						while (rs.next()) {

							String name = rs.getString("subCode");
							txtSubcod.setText(name);
							
						}
						con.close();
					} catch (Exception e) {
						
					}
			 	}
			 });
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(Color.GRAY);
		panel_2_1.setBounds(0, 615, 174, 48);
		AddsessFrm.getContentPane().add(panel_2_1);
		
		JButton btnDelete = new JButton("<<Back");
		btnDelete.setForeground(new Color(240, 248, 255));
		btnDelete.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnDelete.setBackground(Color.BLACK);
		panel_2_1.add(btnDelete);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(0, 503, 174, 113);
		AddsessFrm.getContentPane().add(panel_1);
		
		JButton btnManageSession = new JButton("MANAGE SESSION");
		btnManageSession.setForeground(Color.WHITE);
		btnManageSession.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnManageSession.setBackground(Color.BLACK);
		btnManageSession.setBounds(0, 435, 174, 35);
		AddsessFrm.getContentPane().add(btnManageSession);
		
		JButton btnManageLsession = new JButton("ADD SESSION");
		btnManageLsession.setForeground(Color.RED);
		btnManageLsession.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnManageLsession.setBackground(Color.BLACK);
		btnManageLsession.setBounds(0, 400, 174, 35);
		AddsessFrm.getContentPane().add(btnManageLsession);
		
		JButton btnUpdateSession = new JButton("MANAGE SUBJECTS");
		btnUpdateSession.setForeground(Color.WHITE);
		btnUpdateSession.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnUpdateSession.setBackground(Color.BLACK);
		btnUpdateSession.setBounds(0, 372, 174, 29);
		AddsessFrm.getContentPane().add(btnUpdateSession);
		
		JButton btnAddSession = new JButton("ADD SUBJECT");
		btnAddSession.setForeground(Color.WHITE);
		btnAddSession.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnAddSession.setBackground(Color.BLACK);
		btnAddSession.setBounds(0, 337, 174, 35);
		AddsessFrm.getContentPane().add(btnAddSession);
		
		JButton btnManageLecturer = new JButton("MANAGE LECTURERS");
		btnManageLecturer.setForeground(Color.WHITE);
		btnManageLecturer.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnManageLecturer.setBackground(Color.BLACK);
		btnManageLecturer.setBounds(0, 309, 174, 29);
		AddsessFrm.getContentPane().add(btnManageLecturer);
		
		JButton btnAddLecturer = new JButton("ADD LECTURER");
		btnAddLecturer.setForeground(Color.WHITE);
		btnAddLecturer.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnAddLecturer.setBackground(Color.BLACK);
		btnAddLecturer.setBounds(0, 274, 174, 35);
		AddsessFrm.getContentPane().add(btnAddLecturer);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.GRAY);
		panel_1_1.setBounds(0, 127, 174, 150);
		AddsessFrm.getContentPane().add(panel_1_1);
		
		txtTimeTableManagement = new JTextField();
		txtTimeTableManagement.setText("                                                                       Time Table Management System");
		txtTimeTableManagement.setForeground(Color.WHITE);
		txtTimeTableManagement.setFont(new Font("Tahoma", Font.PLAIN, 23));
		txtTimeTableManagement.setEditable(false);
		txtTimeTableManagement.setColumns(10);
		txtTimeTableManagement.setBackground(Color.GRAY);
		txtTimeTableManagement.setBounds(0, 37, 1334, 56);
		AddsessFrm.getContentPane().add(txtTimeTableManagement);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.BLACK);
		menuBar.setBorderPainted(false);
		menuBar.setBorder(null);
		menuBar.setBackground(Color.BLACK);
		menuBar.setBounds(0, 0, 1344, 27);
		AddsessFrm.getContentPane().add(menuBar);
		
				JButton btnSearchSession = new JButton("SEARCH SESSION");
				btnSearchSession.setFont(new Font("Arial Black", Font.BOLD, 11));
				btnSearchSession.setBackground(Color.BLACK);
				btnSearchSession.setForeground(Color.WHITE);
				btnSearchSession.setBounds(0, 468, 174, 37);
				AddsessFrm.getContentPane().add(btnSearchSession);
				
						JPanel panel_5 = new JPanel();
						panel_5.setBounds(0, 92, 1334, 38);
						AddsessFrm.getContentPane().add(panel_5);
						panel_5.setForeground(Color.RED);
						panel_5.setBackground(Color.BLACK);
						panel_5.setLayout(null);
						panel_5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
						
								JLabel lblAddNewSession = new JLabel("Add New Session");
								lblAddNewSession.setHorizontalAlignment(SwingConstants.CENTER);
								lblAddNewSession.setForeground(Color.RED);
								lblAddNewSession.setFont(new Font("Times New Roman", Font.BOLD, 20));
								lblAddNewSession.setBounds(507, 0, 278, 31);
								panel_5.add(lblAddNewSession);
				btnSearchSession.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {


						AddsessFrm.dispose();
						new Search_Sessions();

					}
				});

				
				
		//clear button
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				txtSubcod.setText("");
				lec1.setSelectedIndex(0);
				lec2.setSelectedIndex(0);
				subname.setSelectedIndex(0);
				tag.setSelectedIndex(0);
				groupId.setSelectedIndex(0);
				sign.setText("");
				students.setValue(0);
				duration.setValue(0);
				
			}
		});

		//load data to dropdown lec1
		loadLecturer1();
		//load data to dropdown lec2
		loadLecturer2();
		//load data to dropdown subject name
		loadSubjectName();
		//load data to dropdown tag
		loadTag();
		//load data to dropdown group id
		loadGroup();
		//load data to dropdown Subgroup id
		loadSubGroup();
	
	
	}
	

	
}