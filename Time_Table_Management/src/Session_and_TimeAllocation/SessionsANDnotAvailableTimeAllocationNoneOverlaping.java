
package Advanced;

import java.awt.EventQueue;
import java.awt.Font;
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

public class SessionsANDnotAvailableTimeAllocationNoneOverlaping {

	
	
	private JFrame frmAddStudentGroup;
	private JTable table;
	private JComboBox comboBox_ps;
	
	
	// fill session 1
	public void fillsesions() {
			
			try {
				
				 Connection con = DBConnection.connect();
				 
				 String query="select * from session";
				 
				 PreparedStatement pst = con.prepareStatement(query);
				 ResultSet rs = pst.executeQuery();
				 
				 while(rs.next()) {
					 
					 String name =rs.getString("sessionSignature");
					 comboBox_ps.addItem(name);
					 //comboBox_4_1.addItem(rs.getString("SubGroupID"));
					 
				}
				con.close();
			}
			
			catch(Exception e) {
				
					e.printStackTrace();
				}
			
	  }
	  
	  
		//refresh table
		public void refreshTable() {
			
			try {
				Connection con = DBConnection.connect();
				
				String query="select * from nonOverlapping ";
				PreparedStatement pst=con.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
				
				
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
					SessionsANDnotAvailableTimeAllocationNoneOverlaping window = new SessionsANDnotAvailableTimeAllocationNoneOverlaping();
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
	public SessionsANDnotAvailableTimeAllocationNoneOverlaping() {
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
		frmAddStudentGroup.setTitle(" Time Table Management System");
		frmAddStudentGroup.setSize(1350, 728);
		frmAddStudentGroup.setBounds(0, 0, 1350, 700);
		frmAddStudentGroup.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddStudentGroup.getContentPane().setLayout(null);
		frmAddStudentGroup.setExtendedState(frmAddStudentGroup.getExtendedState() | JFrame.MAXIMIZED_BOTH);
		frmAddStudentGroup.setIconImage(logo);
		frmAddStudentGroup.setLocationRelativeTo(null); // this method display the JFrame to center position of a screen
		frmAddStudentGroup.setVisible(true);
		
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBackground(SystemColor.activeCaption);
		panel_6.setBounds(267, 167, 1081, 486);
		frmAddStudentGroup.getContentPane().add(panel_6);
		
		
		
		
		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.DARK_GRAY);
		panel_7.setLayout(null);
		panel_7.setBounds(80, 10, 928, 456);
		panel_6.add(panel_7);
		
		
		
		
		
		JLabel lblNewLabel_4 = new JLabel("Session 1");
		lblNewLabel_4.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblNewLabel_4.setBounds(52, 29, 80, 21);
		panel_7.add(lblNewLabel_4);
		
		comboBox_ps = new JComboBox();
		comboBox_ps.setFont(new Font("Tahoma", Font.BOLD, 14));
		comboBox_ps.setModel(new DefaultComboBoxModel(new String[] {"------------select session_---------------"}));
		comboBox_ps.setBounds(156, 29, 723, 33);
		panel_7.add(comboBox_ps);
		
		fillsesions();
		
		
		
		
		
		
		
		
		//Add non overlapping sessions
		JButton btnNewButton_2 = new JButton("ADD");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				String session=comboBox_ps.getSelectedItem().toString();
				
				
				
				
				 try {
					 Connection con = DbConnection.connect();

	                    String query = "INSERT INTO nonOverlapping values(null, '" + session + "')";

	                    Statement sta = con.createStatement();
	                    int x = sta.executeUpdate(query);
	                    if (x == 0) {
	                    	JOptionPane.showMessageDialog(null, "       This is alredy exist","Alert",JOptionPane.WARNING_MESSAGE);
		                      
	                    } else {
	                    	
	                    	JLabel label = new JLabel("Non overlapping Sessions added Sucessfully!");
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
		btnNewButton_2.setBounds(520, 122, 167, 40);
		panel_7.add(btnNewButton_2);
		
		
		
		
		
		//clear input feilds
		JButton btnNewButton_3 = new JButton("CLEAR");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				comboBox_ps.setSelectedIndex(0);
				
			
			}
		});
		
		
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_3.setBackground(Color.BLACK);
		btnNewButton_3.setBounds(715, 122, 164, 40);
		panel_7.add(btnNewButton_3);
		
		
		
		
		
		
		//table view
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 244, 827, 151);
		panel_7.add(scrollPane);
		
		table = new JTable();
		table.setRowHeight(30);
		//table header
		JTableHeader h = table.getTableHeader();
		h.setBackground(new Color(153,153,153));
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
			Connection con = DbConnection.connect();
			
			String query="select * from nonOverlapping  ";
			PreparedStatement pst=con.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
			
			JButton btnNewButton_2_1 = new JButton("Conseccutive Sessions");
			btnNewButton_2_1.setBounds(0, 234, 268, 37);
			frmAddStudentGroup.getContentPane().add(btnNewButton_2_1);
			btnNewButton_2_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			
			JButton btnNewButton_2_1_1 = new JButton("Parallel Sessions");
			btnNewButton_2_1_1.setBounds(0, 270, 275, 37);
			frmAddStudentGroup.getContentPane().add(btnNewButton_2_1_1);
			btnNewButton_2_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
			
			JButton btnNewButton_2_1_2 = new JButton("Non Overlapping Sessions");
			btnNewButton_2_1_2.setBounds(0, 303, 275, 37);
			frmAddStudentGroup.getContentPane().add(btnNewButton_2_1_2);
			btnNewButton_2_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
			
			JButton btnNewButton_2_1_3 = new JButton("Not Available Times");
			btnNewButton_2_1_3.setBounds(0, 339, 268, 37);
			frmAddStudentGroup.getContentPane().add(btnNewButton_2_1_3);
			btnNewButton_2_1_3.setFont(new Font("Tahoma", Font.BOLD, 14));
			btnNewButton_2_1_3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				//NotAvailableTime not= new NotAvailableTime();
				//not.main(null);
				frmAddStudentGroup.dispose();
				new  NotAvailableTime();
				
			}
		});
			btnNewButton_2_1_2 .addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					
					frmAddStudentGroup.dispose();
					new  SessionsANDnotAvailableTimeAllocationNoneOverlaping();
					
				}
			});
			btnNewButton_2_1_1 .addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					
					
					frmAddStudentGroup.dispose();
					new  Parallel_sessions();
					
				}
			});
			btnNewButton_2_1 .addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				
				frmAddStudentGroup.dispose();
				new  Consecutive_sessions();
				
			}
		});
			
			
			
			TableColumnModel columnModel = table.getColumnModel();
			columnModel.getColumn(0).setPreferredWidth(6);
			columnModel.getColumn(1).setPreferredWidth(700);
			
			
			
			
			//refreshTable();
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
