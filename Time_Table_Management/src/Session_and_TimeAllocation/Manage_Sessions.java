
package Session_and_TimeAllocation;

import java.awt.Color;


import java.awt.EventQueue;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.SwingConstants;



import net.proteanit.sql.DbUtils;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JSpinner;
import javax.swing.JSeparator;
import javax.swing.border.MatteBorder;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;

import DBC.DBConnection;

import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.DefaultComboBoxModel;
import javax.swing.UIManager;
import javax.swing.JMenuBar;

public class Manage_Sessions {

	private JFrame ManageSesFrm;
	
	private JTable table;
	private JComboBox lecr1;
	private JComboBox lecr2;
	private JComboBox sbj;
	private JComboBox tg;
	private JComboBox grpId;
	private JTextField cod;
	private JTextField txtSid;
	private JTextField textField;
	
	
	
	
	public void refreshtable() {

		try {

			Connection con = DBConnection.connect();
String query="select sessionID As SID, lec1 As Lecturer1,lec2 As Lecturer2,subCode As SubCode,subName As SubName,tag As Tag,studentGroup As GroupID,NoOfStudents As Students,duration As Duration,sessionSignature As SessionSignature from session ";
			
			
			PreparedStatement pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			TableColumnModel columnModel = table.getColumnModel();
			columnModel.getColumn(0).setPreferredWidth(1);
			columnModel.getColumn(1).setPreferredWidth(80);
			columnModel.getColumn(2).setPreferredWidth(80);
			columnModel.getColumn(3).setPreferredWidth(20);
			columnModel.getColumn(4).setPreferredWidth(40);
			columnModel.getColumn(5).setPreferredWidth(30);
			columnModel.getColumn(6).setPreferredWidth(50);
			columnModel.getColumn(7).setPreferredWidth(1);
			columnModel.getColumn(8).setPreferredWidth(1);
			columnModel.getColumn(9).setPreferredWidth(300);

		}
		catch(Exception e) {
			e.printStackTrace();
		}


	}

	//load data to dropdown lec1
	  public  void  loadLecturer1(){ 
		  try {

				Connection con = DBConnection.connect();

				String query="select * from Lecturers ";
				PreparedStatement pst=con.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				
				while(rs.next())
				{
					String name =rs.getString("LecturerName");
					lecr1.addItem(name);
					 
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

				String query="select * from Lecturers ";
				PreparedStatement pst=con.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				
				while(rs.next())
				{
					String name =rs.getString("LecturerName");
					lecr2.addItem(name);
					 
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

				String query="select * from SUbjects ";
				PreparedStatement pst=con.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				
				while(rs.next())
				{
					String name =rs.getString("SubjectName");
					sbj.addItem(name);
					 
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

				String query="select * from Tag ";
				PreparedStatement pst=con.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				
				while(rs.next())
				{
					String name =rs.getString("relatedtag");
					tg.addItem(name);
					 
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

				String query="select * from Student_Groups ";
				PreparedStatement pst=con.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				
				while(rs.next())
				{
					String name =rs.getString("G_ID");
					grpId.addItem(name);
					 
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

				String query="select * from Student_Groups ";
				PreparedStatement pst=con.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				
				while(rs.next())
				{
					String name =rs.getString("Sub_G_ID");
					grpId.addItem(name);
					 
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
					Manage_Sessions window = new Manage_Sessions();
					window.ManageSesFrm.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Manage_Sessions() {
		initialize();
	}

	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		ManageSesFrm = new JFrame();
		ManageSesFrm.setBounds(0, 0, 1350, 700);
		ManageSesFrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		ManageSesFrm.getContentPane().setBackground(SystemColor.activeCaption);
		ManageSesFrm.setBackground(Color.YELLOW);
		ManageSesFrm.setTitle("Time Table Management System");
		ManageSesFrm.setSize(1350, 715);
		
		//ManageSesFrm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ManageSesFrm.getContentPane().setLayout(null);
	
		ManageSesFrm.setLocationRelativeTo(null);
		ManageSesFrm.setVisible(true);

		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(Color.DARK_GRAY);
		panel_2.setBounds(264, 138, 1075, 523);
		ManageSesFrm.getContentPane().add(panel_2);

		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(10, 40, 1055, 165);
		panel_2.add(scrollPane_2);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane_2.setViewportView(scrollPane);

		table = new JTable();
		table.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
		table.setBackground(SystemColor.window);
		
		//table header
		JTableHeader h = table.getTableHeader();
		h.setBackground(new Color(	153, 153, 153));
		h.setForeground(Color.WHITE);
		h.setFont(new Font("Yu Gothic UI Semibold", Font.PLAIN, 12));
		h.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		
		table.setFont(new Font("Yu Gothic UI Semibold", Font.BOLD, 11));
		table.setModel(new DefaultTableModel( new Object[][] { }, new String[] { }
				));
		
		//display details in a table
		scrollPane.setViewportView(table);
		try {
			Connection con = DBConnection.connect();

			//String query="select * from session ";
			String query="select sessionID As SID, lec1 As Lecturer1,lec2 As Lecturer2,subCode As SubCode,subName As SubName,tag As Tag,studentGroup As GroupID,NoOfStudents As Students,duration As Duration,sessionSignature As SessionSignature from session ";
			
			
			PreparedStatement pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			TableColumnModel columnModel = table.getColumnModel();
			columnModel.getColumn(0).setPreferredWidth(1);
			columnModel.getColumn(1).setPreferredWidth(80);
			columnModel.getColumn(2).setPreferredWidth(80);
			columnModel.getColumn(3).setPreferredWidth(20);
			columnModel.getColumn(4).setPreferredWidth(40);
			columnModel.getColumn(5).setPreferredWidth(30);
			columnModel.getColumn(6).setPreferredWidth(50);
			columnModel.getColumn(7).setPreferredWidth(1);
			columnModel.getColumn(8).setPreferredWidth(1);
			columnModel.getColumn(9).setPreferredWidth(300);

		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		//new
		JSpinner noStud = new JSpinner();
		JSpinner duration = new JSpinner();
		JTextArea sign = new JTextArea();
		sign.setEditable(false);
		sign.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 12));
		
		//display selected row
		table.addMouseListener(new MouseAdapter() {

			@Override public void mouseClicked(MouseEvent arg0) {

				int i = table.getSelectedRow(); TableModel model = table.getModel();

				txtSid.setText(model.getValueAt(i, 0).toString());
				
				String combolevel1 = table.getValueAt(i, 1).toString();
				for(int j=0;j<lecr1.getItemCount();j++) {

					if(lecr1.getItemAt(j).toString().equalsIgnoreCase(combolevel1)) {
						lecr1.setSelectedIndex(j); } }

				String combolevel2 = table.getValueAt(i, 2).toString(); for(int j=0
						;j<lecr2.getItemCount();j++) {

					if(lecr2.getItemAt(j).toString().equalsIgnoreCase(combolevel2)) {
						lecr2.setSelectedIndex(j); } }
				
				cod.setText(model.getValueAt(i, 3).toString());
				String combolevel3 = table.getValueAt(i, 4).toString(); for(int j=0
						;j<sbj.getItemCount();j++) {

					if(sbj.getItemAt(j).toString().equalsIgnoreCase(combolevel3)) {
						sbj.setSelectedIndex(j); } } 
			
				String combolevel4 = table.getValueAt(i, 5).toString(); for(int j=0
						;j<tg.getItemCount();j++) {

					if(tg.getItemAt(j).toString().equalsIgnoreCase(combolevel4)) {
						tg.setSelectedIndex(j); } } 
				
				
				String combolevel5 = table.getValueAt(i, 6).toString(); for(int j=0
						;j<grpId.getItemCount();j++) {

					if(grpId.getItemAt(j).toString().equalsIgnoreCase(combolevel5)) {
						grpId.setSelectedIndex(j); } } 
				

				noStud.setValue((Integer)table.getValueAt(i,7));
				duration.setValue((Integer)table.getValueAt(i,8));
				
                sign.setText(model.getValueAt(i, 9).toString());

			} });
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBorder(new EmptyBorder(0, 0, 0, 0));
		panel_3.setBackground(new Color(245, 245, 245));
		panel_3.setBounds(10, 213, 1055, 335);
		panel_2.add(panel_3);

		JButton btnClear = new JButton("CLEAR");
		btnClear.setToolTipText("Click button to clear");
		btnClear.setForeground(Color.WHITE);
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClear.setEnabled(true);
		btnClear.setBackground(new Color(0, 128, 128));
		btnClear.setBounds(629, 272, 141, 31);
		panel_3.add(btnClear);

		JButton btnDel = new JButton("DELETE");
		btnDel.setToolTipText("Click button to delete session");
		btnDel.setForeground(Color.WHITE);
		btnDel.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDel.setEnabled(true);
		btnDel.setBackground(new Color(0, 128, 128));
		btnDel.setBounds(450, 272, 141, 31);
		panel_3.add(btnDel);

		JButton btnEdit = new JButton("EDIT");
		btnEdit.setToolTipText("Click button to edit session");
		
		btnEdit.setForeground(Color.WHITE);
		btnEdit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnEdit.setEnabled(true);
		btnEdit.setBackground(new Color(0, 128, 128));
		btnEdit.setBounds(268, 272, 141, 31);
		panel_3.add(btnEdit);

		 lecr1 = new JComboBox();
		 lecr1.setModel(new DefaultComboBoxModel(new String[] {"----------Select Lecturer 1 ----------"}));
		lecr1.setBounds(244, 12, 245, 27);
		panel_3.add(lecr1);

		JLabel lblLecturer = new JLabel("Lecturer 1");
		lblLecturer.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLecturer.setBounds(73, 11, 96, 23);
		panel_3.add(lblLecturer);

		 sbj = new JComboBox();
		 sbj.setModel(new DefaultComboBoxModel(new String[] {"---------- Select Subject  ----------"}));
		 sbj.addActionListener(new ActionListener() {
		 	public void actionPerformed(ActionEvent e) {
		 		try {
					String subject = sbj.getSelectedItem().toString();
					Connection con = DBConnection.connect();
					String query = "select SubjectCode from subjects where SubjectName = '" + subject + "'";
					PreparedStatement pst = con.prepareStatement(query);
					ResultSet rs = pst.executeQuery();
					
					while (rs.next()) {

						String name = rs.getString("SubjectCode");
						cod.setText(name);
						
					}
					con.close();
				} catch (Exception e1) {
					
				}
		 		
		 	}
		 });
		sbj.setBounds(244, 114, 245, 27);
		panel_3.add(sbj);

		JLabel label_3 = new JLabel("Subject Name");
		label_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_3.setBounds(73, 113, 149, 23);
		panel_3.add(label_3);

		JLabel label_4 = new JLabel("Selected Subject Code");
		label_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_4.setBounds(73, 170, 149, 23);
		panel_3.add(label_4);

		JLabel label_5 = new JLabel("Tag");
		label_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_5.setBounds(73, 220, 132, 23);
		panel_3.add(label_5);

		 tg = new JComboBox();
		 tg.setModel(new DefaultComboBoxModel(new String[] {"------------Select Tag ------------"}));
		tg.setBounds(244, 221, 245, 27);
		panel_3.add(tg);

		JLabel label_6 = new JLabel("Group/Sub Group ID");
		label_6.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_6.setBounds(632, 12, 150, 23);
		panel_3.add(label_6);

		 grpId = new JComboBox();
		 grpId.setModel(new DefaultComboBoxModel(new String[] {"--------Select Group/Sub Group ID--------"}));
		grpId.setBounds(792, 13, 245, 27);
		panel_3.add(grpId);

		JLabel label_7 = new JLabel("No Of Students");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_7.setBounds(632, 61, 108, 23);
		panel_3.add(label_7);

		
		noStud.setFont(new Font("Tahoma", Font.BOLD, 12));
		noStud.setBounds(792, 61, 245, 27);
		panel_3.add(noStud);

		JLabel label_8 = new JLabel("Duration(hrs)");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_8.setBounds(632, 113, 108, 23);
		panel_3.add(label_8);

		
		duration.setFont(new Font("Tahoma", Font.BOLD, 12));
		duration.setBounds(792, 113, 245, 27);
		panel_3.add(duration);
		
		JLabel lblLecturer_1 = new JLabel("Lecturer 2");
		lblLecturer_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblLecturer_1.setBounds(73, 61, 96, 23);
		panel_3.add(lblLecturer_1);
		
		 lecr2 = new JComboBox();
		 lecr2.setModel(new DefaultComboBoxModel(new String[] {"-"}));
		lecr2.setBounds(244, 61, 245, 27);
		panel_3.add(lecr2);
		
		JLabel label_1 = new JLabel("Session Signature");
		label_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_1.setBounds(632, 159, 126, 23);
		panel_3.add(label_1);
		
		JButton btnGenerateSessionSign = new JButton("GENERATE SESSION SIGNATURE");
		btnGenerateSessionSign.setToolTipText("Click button to generate session signature");
		
		btnGenerateSessionSign.setForeground(Color.WHITE);
		btnGenerateSessionSign.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnGenerateSessionSign.setBackground(new Color(119, 136, 153));
		btnGenerateSessionSign.setBounds(632, 227, 405, 33);
		panel_3.add(btnGenerateSessionSign);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(792, 161, 245, 55);
		panel_3.add(scrollPane_1);
		
		
		scrollPane_1.setViewportView(sign);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollPane_1.setRowHeaderView(scrollBar);
		
		cod = new JTextField();
		cod.setBackground(Color.WHITE);
		cod.setEditable(false);
		cod.setFont(new Font("Tahoma", Font.BOLD, 11));
		cod.setBounds(244, 172, 245, 27);
		panel_3.add(cod);
		cod.setColumns(10);
		
		txtSid = new JTextField();
		txtSid.setBounds(55, 318, -4, 6);
		panel_3.add(txtSid);
		txtSid.setColumns(10);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.BLACK);
		menuBar.setBorderPainted(false);
		menuBar.setBorder(null);
		menuBar.setBackground(Color.BLACK);
		menuBar.setBounds(0, 0, 1331, 27);
		ManageSesFrm.getContentPane().add(menuBar);
		
		textField = new JTextField();
		textField.setText("                                                                       Time Table Management System");
		textField.setForeground(Color.WHITE);
		textField.setFont(new Font("Tahoma", Font.PLAIN, 23));
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBackground(Color.GRAY);
		textField.setBounds(0, 37, 1334, 65);
		ManageSesFrm.getContentPane().add(textField);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setForeground(Color.RED);
		panel_5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
		panel_5.setBackground(Color.BLACK);
		panel_5.setBounds(0, 99, 1334, 38);
		ManageSesFrm.getContentPane().add(panel_5);
		
		JLabel lblManageSessions = new JLabel("Manage Sessions");
		lblManageSessions.setHorizontalAlignment(SwingConstants.CENTER);
		lblManageSessions.setForeground(Color.RED);
		lblManageSessions.setFont(new Font("Arial Black", Font.BOLD, 19));
		lblManageSessions.setBounds(507, 0, 278, 31);
		panel_5.add(lblManageSessions);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(Color.GRAY);
		panel_1_1.setBounds(0, 133, 174, 157);
		ManageSesFrm.getContentPane().add(panel_1_1);
		
		JButton btnAddLecturer = new JButton("ADD LECTURER");
		btnAddLecturer.setForeground(Color.WHITE);
		btnAddLecturer.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnAddLecturer.setBackground(Color.BLACK);
		btnAddLecturer.setBounds(0, 289, 174, 35);
		ManageSesFrm.getContentPane().add(btnAddLecturer);
		
		JButton btnManageLecturer = new JButton("MANAGE LECTURERS");
		btnManageLecturer.setForeground(Color.WHITE);
		btnManageLecturer.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnManageLecturer.setBackground(Color.BLACK);
		btnManageLecturer.setBounds(0, 323, 174, 29);
		ManageSesFrm.getContentPane().add(btnManageLecturer);
		
		JButton btnAddSession = new JButton("ADD SUBJECT");
		btnAddSession.setForeground(Color.WHITE);
		btnAddSession.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnAddSession.setBackground(Color.BLACK);
		btnAddSession.setBounds(0, 349, 174, 35);
		ManageSesFrm.getContentPane().add(btnAddSession);
		
		JButton btnUpdateSession = new JButton("MANAGE SUBJECTS");
		btnUpdateSession.setForeground(Color.WHITE);
		btnUpdateSession.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnUpdateSession.setBackground(Color.BLACK);
		btnUpdateSession.setBounds(0, 383, 174, 29);
		ManageSesFrm.getContentPane().add(btnUpdateSession);
		
		JButton btnManageLsession = new JButton("ADD SESSION");
		btnManageLsession.setForeground(Color.WHITE);
		btnManageLsession.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnManageLsession.setBackground(Color.BLACK);
		btnManageLsession.setBounds(0, 410, 174, 35);
		ManageSesFrm.getContentPane().add(btnManageLsession);
		
		JButton btnManageSession = new JButton("MANAGE SESSION");
		btnManageSession.setForeground(Color.WHITE);
		btnManageSession.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnManageSession.setBackground(Color.BLACK);
		btnManageSession.setBounds(0, 443, 174, 35);
		ManageSesFrm.getContentPane().add(btnManageSession);
		
		JButton btnManageSession_1 = new JButton("SEARCH SESSION");
		btnManageSession_1.setForeground(Color.RED);
		btnManageSession_1.setFont(new Font("Arial Black", Font.BOLD, 11));
		btnManageSession_1.setBackground(Color.BLACK);
		btnManageSession_1.setBounds(0, 477, 174, 35);
		ManageSesFrm.getContentPane().add(btnManageSession_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.GRAY);
		panel_1.setBounds(0, 510, 174, 118);
		ManageSesFrm.getContentPane().add(panel_1);
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setBackground(Color.GRAY);
		panel_2_1.setBounds(0, 624, 174, 54);
		ManageSesFrm.getContentPane().add(panel_2_1);
		
		JButton btnDelete = new JButton("<<Back");
		btnDelete.setForeground(new Color(240, 248, 255));
		btnDelete.setFont(new Font("SansSerif", Font.BOLD, 13));
		btnDelete.setBackground(Color.BLACK);
		panel_2_1.add(btnDelete);
		
		
		//generate session signature
		btnGenerateSessionSign.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String lecregx = "-";
				String lecrs = "----------Select Lecturer 1 ----------";
				String namer = "----------Select Subject----------";
				String tagr = "------------Select Tag ------------";
				String grpidr = "--------Select Group/Sub Group ID--------";
				
				if(lecr1.getSelectedItem().toString().equals(lecrs)||sbj.getSelectedItem().toString().equals(namer)|| tg.getSelectedItem().toString().equals(tagr)|| grpId.getSelectedItem().toString().equals(grpidr)|| noStud.getValue().equals(0)|| duration.getValue().equals(0))
				{
					JOptionPane.showMessageDialog(null, "       Please Enter Values","Alert",JOptionPane.WARNING_MESSAGE);
	
					
				}else {
				if(lecr1.getSelectedItem().toString().matches(lecregx ));
				{
					sign.setText(lecr1.getSelectedItem().toString()+ " - "+ cod.getText()+" - "+ sbj.getSelectedItem().toString()
							+" - "+tg.getSelectedItem().toString()+" - "+grpId.getSelectedItem().toString()+" - "+noStud.getValue().toString()+" - "+
							duration.getValue().toString());
					
				}
				
				if(!(lecr2.getSelectedItem().toString().matches(lecregx)))
				{
					
					sign.setText(lecr1.getSelectedItem().toString()+ " - "+ lecr2.getSelectedItem().toString()+ " - "+cod.getText()+" - "+ sbj.getSelectedItem().toString()
							+" - "+tg.getSelectedItem().toString()+" - "+grpId.getSelectedItem().toString()+" - "+noStud.getValue().toString()+" - "+
							duration.getValue().toString());
				
				}
				
				JLabel label8 = new JLabel("Session Signature Updated Successfully");
				label8.setHorizontalAlignment(SwingConstants.CENTER);
				JOptionPane.showMessageDialog(null, label8);
			}
			}
		});
		
		
		//Update Session details
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try { 


					Connection con = DBConnection.connect(); 

					String query="Update session set lec1 = '"+lecr1.getSelectedItem().toString()+"' , lec2 = '"+lecr2.getSelectedItem().toString()+"' ,subCode = '"+cod.getText()+"',"
							+ "subName = '"+sbj.getSelectedItem().toString()+"', tag = '"+tg.getSelectedItem().toString()+"',studentGroup = '"+grpId.getSelectedItem().toString()+"',NoOfStudents = '"+noStud.getValue()+"',duration='"+duration.getValue()+"',"
									+ "sessionSignature = '"+sign.getText()+"' where sessionID = '"+txtSid.getText()+"' ";

					PreparedStatement pst=con.prepareStatement(query);

					pst.executeUpdate();
					refreshtable();
					JLabel label = new JLabel("Session Updated Successfully");
					label.setHorizontalAlignment(SwingConstants.CENTER);
					JOptionPane.showMessageDialog(null, label);
					

					
					//JOptionPane.showMessageDialog(null, "Data Updated"); pst.close();

				} catch(Exception ea) {
					ea.printStackTrace(); 
				}
				
			}
		});
		
		
		//delete session
		btnDel.addActionListener(new ActionListener() {

			@Override public void actionPerformed(ActionEvent arg0) { 
				// TOD Auto-generated method stub


				try { 
					Connection con = DBConnection.connect();
					String  query="Delete from session where sessionID='"+txtSid.getText()+"'";
					PreparedStatement pst=con.prepareStatement(query); 
					pst.execute();
					refreshtable();
					JOptionPane.showMessageDialog(null, "       Session Deleted Successfully","Message",JOptionPane.INFORMATION_MESSAGE);
					pst.close();
					cod.setText("");
					lecr1.setSelectedIndex(0);
					lecr2.setSelectedIndex(0);
					sbj.setSelectedIndex(0);
					tg.setSelectedIndex(0);
					grpId.setSelectedIndex(0);
					sign.setText("");
					noStud.setValue(0);
					duration.setValue(0);
					
					//table.revalidate();

				} catch(Exception en) { en.printStackTrace();

				}

			} });
		
		//clear button
				btnClear.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {

						cod.setText("");
						lecr1.setSelectedIndex(0);
						lecr2.setSelectedIndex(0);
						sbj.setSelectedIndex(0);
						tg.setSelectedIndex(0);
						grpId.setSelectedIndex(0);
						sign.setText("");
						noStud.setValue(0);
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
