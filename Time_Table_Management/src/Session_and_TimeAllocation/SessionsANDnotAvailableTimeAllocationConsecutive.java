

package Session_and_TimeAllocation;

import java.awt.EventQueue;



import java.awt.Font;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.SystemColor;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import javax.swing.border.MatteBorder;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.border.TitledBorder;
import java.awt.List;
import java.awt.ScrollPane;
import java.awt.Button;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;

import DBC.DBConnection;
import Timetable.Lecturer;

import net.proteanit.sql.DbUtils;

import javax.swing.border.LineBorder;
import java.awt.Panel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.JMenuBar;

public class SessionsANDnotAvailableTimeAllocationConsecutive {

	
	
	
	private JFrame frmAddStudentGroup;
	private JTable table;
	private JComboBox comboBox_s1;
	private JComboBox comboBox_s2;
	private JComboBox comboBox_s3;
	private JTextField gensession;
	private JTextField textField;
	
	
	//fill  session 1
	  public void fillsesions1() {
			
			try {
				
				 Connection con = DBConnection.connect();
				 
				 String query="select * from session";
				 
				 PreparedStatement pst = con.prepareStatement(query);
				 ResultSet rs = pst.executeQuery();
				 
				 while(rs.next()) {
					 
					 String name =rs.getString("sessionSignature");
					 comboBox_s1.addItem(name);
					 //comboBox_4_1.addItem(rs.getString("SubGroupID"));
					 
				}
				con.close();
			}
			
			catch(Exception e) {
				
					e.printStackTrace();
				}
			
	     	}
	     
	
	  //fill session 2 
	  public void fillsesions2() {
			
			try {
				
				 Connection con = DBConnection.connect();
				 
				 String query="select * from session";
				 
				 PreparedStatement pst = con.prepareStatement(query);
				 ResultSet rs = pst.executeQuery();
				 
				 while(rs.next()) {
					 
					 String name =rs.getString("sessionSignature");
					 comboBox_s2.addItem(name);
					 //comboBox_4_1.addItem(rs.getString("SubGroupID"));
					 
				}
				con.close();
			}
			
			catch(Exception e) {
				
					e.printStackTrace();
				}
			
	     	}
	  
	  
	 //fill session 3
	  public void fillsesions3() {
			
			try {
				
				 Connection con = DBConnection.connect();
				 
				 String query="select * from session";
				 
				 PreparedStatement pst = con.prepareStatement(query);
				 ResultSet rs = pst.executeQuery();
				 
				 while(rs.next()) {
					 
					 String name =rs.getString("sessionSignature");
					 comboBox_s3.addItem(name);
					 //comboBox_4_1.addItem(rs.getString("SubGroupID"));
					 
				}
				con.close();
			}
			
			catch(Exception e) {
				
					e.printStackTrace();
				}
			
	     	}
	  
	  

	  
	  //refresh method
	  public void refreshTable() {
			
			try {
				Connection con = DBConnection.connect();
				
				String query="select conSessionID AS SID,conSession AS ConsecutiveSession from consecutiveSession ";
				PreparedStatement pst=con.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
				
				TableColumnModel columnModel = table.getColumnModel();
				columnModel.getColumn(0).setPreferredWidth(6);
				columnModel.getColumn(1).setPreferredWidth(900);
				
				
				
				
				
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
					SessionsANDnotAvailableTimeAllocationConsecutive window = new SessionsANDnotAvailableTimeAllocationConsecutive();
					window.frmAddStudentGroup.setVisible(true);
					
				
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	
     
     
	
	/**
	 * Create the application.
	 */
	public SessionsANDnotAvailableTimeAllocationConsecutive() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddStudentGroup = new JFrame();
		frmAddStudentGroup.getContentPane().setBackground(SystemColor.activeCaption);
		frmAddStudentGroup.setBackground(Color.YELLOW);
		frmAddStudentGroup.setResizable(false);
		frmAddStudentGroup.setTitle(" Time Table Management System ");
		frmAddStudentGroup.setSize(1350, 728);
		frmAddStudentGroup.setBounds(0, 0, 1350, 700);
		frmAddStudentGroup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddStudentGroup.getContentPane().setLayout(null);
		frmAddStudentGroup.setExtendedState(frmAddStudentGroup.getExtendedState() | JFrame.MAXIMIZED_BOTH);

		
		frmAddStudentGroup.setLocationRelativeTo(null); // this method display the JFrame to center position of a screen
		frmAddStudentGroup.setVisible(true);
		
		
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(SystemColor.activeCaption);
		panel_6.setBounds(268, 152, 1081, 501);
		frmAddStudentGroup.getContentPane().add(panel_6);
		
		
		
		
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.DARK_GRAY);
		panel_7.setLayout(null);
		panel_7.setBounds(10, 10, 1030, 476);
		panel_6.add(panel_7);
		
		
		
		
		//session 1
		JLabel lblNewLabel_4_1 = new JLabel("Session 1");
		lblNewLabel_4_1.setForeground(Color.WHITE);
		lblNewLabel_4_1.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_4_1.setBounds(24, 24, 80, 21);
		panel_7.add(lblNewLabel_4_1);
		
		comboBox_s1 = new JComboBox();
		comboBox_s1.setFont(new Font("Times New Roman", Font.BOLD, 14));
		comboBox_s1.setModel(new DefaultComboBoxModel(new String[] {"-"}));
		comboBox_s1.setBounds(189, 13, 764, 32);
		panel_7.add(comboBox_s1);
		
		fillsesions1();

	
		
		//session 2
		JLabel lblNewLabel_4 = new JLabel("Session 2");
		lblNewLabel_4.setForeground(Color.WHITE);
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_4.setBounds(24, 87, 80, 21);
		panel_7.add(lblNewLabel_4);
		
		

	    comboBox_s2 = new JComboBox();
	    comboBox_s2.setFont(new Font("Times New Roman", Font.BOLD, 14));
	    comboBox_s2.setModel(new DefaultComboBoxModel(new String[] {"-"}));
		comboBox_s2.setBounds(189, 76, 764, 32);
		panel_7.add(comboBox_s2);
		
		
		fillsesions2();
		
		
		//session 3
		JLabel lblNewLabel_5 = new JLabel("Session 3");
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_5.setBounds(24, 150, 96, 16);
		panel_7.add(lblNewLabel_5);
		
		comboBox_s3 = new JComboBox();
		comboBox_s3.setFont(new Font("Times New Roman", Font.BOLD, 14));
		comboBox_s3.setModel(new DefaultComboBoxModel(new String[] {"-"}));
		comboBox_s3.setBounds(189, 142, 764, 32);
		panel_7.add(comboBox_s3);
		
		
		fillsesions3();
		
		
		
		
		gensession = new JTextField();
		gensession.setBackground(UIManager.getColor("Button.light"));
		gensession.setEnabled(false);
		gensession.setBounds(24, 300, 890, 3);
		panel_7.add(gensession);
		gensession.setColumns(10);
		
		
		//add consecutive sessions
		JButton btnNewButton_2 = new JButton("ADD");
		btnNewButton_2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				gensession.setText(comboBox_s1.getSelectedItem().toString()+"+"+comboBox_s2.getSelectedItem().toString()+"+"+comboBox_s3.getSelectedItem().toString());
				
				String session1=comboBox_s1.getSelectedItem().toString();
				String session2=comboBox_s2.getSelectedItem().toString();
				String session3=comboBox_s3.getSelectedItem().toString();
				String session = gensession.getText();
				
			
				
				 try {
					 
					 Connection con = DBConnection.connect();
					 
					  

	                    String query = "INSERT INTO consecutiveSession values(null, '" + session1 + "', '" + session2+ "', '" + session3 + "', '" + session + "')";

	                    Statement sta = con.createStatement();
	                    int x = sta.executeUpdate(query);
	                    if (x == 0) {
	                    	JOptionPane.showMessageDialog(null, "       This is alredy exist","Alert",JOptionPane.WARNING_MESSAGE);
		                      
	                    } else {
	                    	
	                    	
	                    	JLabel label = new JLabel("Consective Sessions added Sucessfully");
	    					label.setHorizontalAlignment(SwingConstants.CENTER);
	    					JOptionPane.showMessageDialog(null, label);
	    					
	    					refreshTable();
	                    }
	                    con.close();
	                } catch (Exception exception) {
	                	
	                	System.out.println("xxxxxxxxxxxxxxxxxxxxxxx");
	                	
	                }
				
				
				
			}
		});
		
		
		
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_2.setBackground(Color.BLACK);
		btnNewButton_2.setBounds(607, 203, 164, 40);
		panel_7.add(btnNewButton_2);
		
		
		
		//clear input feilds
		JButton btnNewButton_3 = new JButton("CLEAR");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				comboBox_s1.setSelectedIndex(0);
				comboBox_s2.setSelectedIndex(0);
				comboBox_s3.setSelectedIndex(0);
				
				
			
			}
		});
		
		
		
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_3.setBackground(Color.BLACK);
		btnNewButton_3.setBounds(798, 203, 155, 40);
		panel_7.add(btnNewButton_3);
		
		
		
	
		
		//table view
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 303, 1006, 142);
		panel_7.add(scrollPane);
		
		
		table = new JTable();
		table.setRowHeight(30);
		
		
		//table header
		JTableHeader h = table.getTableHeader();
		h.setBackground(new Color(153, 153, 153));
		h.setForeground(Color.WHITE);
		h.setFont(new Font("Times New Roman", Font.BOLD, 17));
		
		
		table.setFont(new Font("Times New Roman", Font.BOLD, 14));
		table.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
			}
		));
		scrollPane.setViewportView(table);
		try {
			
			
			Connection con = DBConnection.connect();
			 
			 
			String query="select conSessionID AS SID,conSession AS ConsecutiveSession from consecutiveSession ";
			PreparedStatement pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			JButton btnNewButton_2_1 = new JButton("Conseccutive Sessions");
			btnNewButton_2_1.setForeground(Color.RED);
			btnNewButton_2_1.setBackground(Color.BLACK);
			btnNewButton_2_1.setBounds(-11, 284, 280, 37);
			frmAddStudentGroup.getContentPane().add(btnNewButton_2_1);
			btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			
			JButton btnNewButton_2_1_1 = new JButton("Parallel Sessions");
			btnNewButton_2_1_1.setForeground(Color.WHITE);
			btnNewButton_2_1_1.setBackground(Color.BLACK);
			btnNewButton_2_1_1.setBounds(-1, 321, 275, 37);
			frmAddStudentGroup.getContentPane().add(btnNewButton_2_1_1);
			btnNewButton_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			
			JButton btnNewButton_2_1_2 = new JButton("Non Overlapping Sessions");
			btnNewButton_2_1_2.setForeground(Color.WHITE);
			btnNewButton_2_1_2.setBackground(Color.BLACK);
			btnNewButton_2_1_2.setBounds(-1, 357, 275, 37);
			frmAddStudentGroup.getContentPane().add(btnNewButton_2_1_2);
			btnNewButton_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
			
			JButton btnNewButton_2_1_3 = new JButton("Not Available Times");
			btnNewButton_2_1_3.setForeground(Color.WHITE);
			btnNewButton_2_1_3.setBackground(Color.BLACK);
			btnNewButton_2_1_3.setBounds(-1, 393, 270, 37);
			frmAddStudentGroup.getContentPane().add(btnNewButton_2_1_3);
			btnNewButton_2_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
			
			textField = new JTextField();
			textField.setText("                                                                       Time Table Management System");
			textField.setForeground(Color.WHITE);
			textField.setFont(new Font("Tahoma", Font.PLAIN, 23));
			textField.setEditable(false);
			textField.setColumns(10);
			textField.setBackground(Color.GRAY);
			textField.setBounds(-1, 35, 1334, 74);
			frmAddStudentGroup.getContentPane().add(textField);
			
			JPanel panel_5 = new JPanel();
			panel_5.setLayout(null);
			panel_5.setForeground(Color.RED);
			panel_5.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.LIGHT_GRAY));
			panel_5.setBackground(Color.BLACK);
			panel_5.setBounds(-1, 102, 1334, 42);
			frmAddStudentGroup.getContentPane().add(panel_5);
			
			JLabel lblConsecutiveSessions = new JLabel("CONSECUTIVE SESSIONS");
			lblConsecutiveSessions.setHorizontalAlignment(SwingConstants.CENTER);
			lblConsecutiveSessions.setForeground(Color.RED);
			lblConsecutiveSessions.setFont(new Font("Arial Black", Font.BOLD, 19));
			lblConsecutiveSessions.setBounds(504, 10, 321, 31);
			panel_5.add(lblConsecutiveSessions);
			
			JMenuBar menuBar = new JMenuBar();
			menuBar.setForeground(Color.BLACK);
			menuBar.setBorderPainted(false);
			menuBar.setBorder(null);
			menuBar.setBackground(Color.BLACK);
			menuBar.setBounds(-1, 0, 1344, 37);
			frmAddStudentGroup.getContentPane().add(menuBar);
			
			JPanel panel_1_1 = new JPanel();
			panel_1_1.setBackground(Color.GRAY);
			panel_1_1.setBounds(-1, 144, 270, 141);
			frmAddStudentGroup.getContentPane().add(panel_1_1);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBackground(Color.GRAY);
			panel_1.setBounds(0, 428, 269, 182);
			frmAddStudentGroup.getContentPane().add(panel_1);
			
			JPanel panel_2_1 = new JPanel();
			panel_2_1.setBackground(Color.GRAY);
			panel_2_1.setBounds(-1, 609, 270, 54);
			frmAddStudentGroup.getContentPane().add(panel_2_1);
			
			JButton btnDelete = new JButton("<<Back");
			btnDelete.setForeground(new Color(240, 248, 255));
			btnDelete.setFont(new Font("SansSerif", Font.BOLD, 13));
			btnDelete.setBackground(Color.BLACK);
			panel_2_1.add(btnDelete);
			btnNewButton_2_1_3.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					
					//NotAvailableTime not= new NotAvailableTime();
					//not.main(null);
					frmAddStudentGroup.dispose();
					new  Not_Available_Time();
					
				}
			});
			btnNewButton_2_1_2.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
				
					frmAddStudentGroup.dispose();
					new  SessionsANDnotAvailableTimeAllocationNoneOverlaping();
					
				}
			});
			btnNewButton_2_1_1.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					
					frmAddStudentGroup.dispose();
					new  SessionsANDnotAvailableTimeAllocationParallel();
					
				}
			});
			btnNewButton_2_1.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					
					frmAddStudentGroup.dispose();
					new  SessionsANDnotAvailableTimeAllocationConsecutive();
					
				}
			});
			
			
			TableColumnModel columnModel = table.getColumnModel();
			columnModel.getColumn(0).setPreferredWidth(6);
			columnModel.getColumn(1).setPreferredWidth(900);
			
			
			
			
			
			//refreshTable();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		

		
	}
}
