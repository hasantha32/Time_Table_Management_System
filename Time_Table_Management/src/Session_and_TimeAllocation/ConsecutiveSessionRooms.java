

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
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


import DBC.DBConnection;

import Timetable.Lecturer;

import javax.swing.DefaultComboBoxModel;

public class ConsecutiveSessionRooms {
	
	

	
	private JFrame crframe;
	private JTable crtable;
	private JTable crtable_1;
	private JTable crtable_2;
	private JComboBox consession;
	private JComboBox consessionroom;
	
	
	public  void  loadConSession(){ 
		  try {

				Connection con = DBConnection.connect();

				String query="select * from consecutiveSession ";
				PreparedStatement pst=con.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				
				while(rs.next())
				{
					String name =rs.getString("conSession");
					consession.addItem(name);
					 
				}

				con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}

}
	 public void loadConsessionRoom() {
		 try {
			 
			 Connection con = DbConnection.connect();
			 
			 String query ="select * from location";
			 PreparedStatement pst=con.prepareStatement(query);
			 ResultSet rs =pst.executeQuery();
			 
			 while(rs.next()) {
				 String room = rs.getString("roomName");
				 consessionroom.addItem(room);
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
					ConsecutiveSessionRooms window = new ConsecutiveSessionRooms();
					window.crframe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ConsecutiveSessionRooms() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		crframe = new JFrame();
		crframe.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
		crframe.setBackground(Color.YELLOW);
		crframe.setResizable(false);
		crframe.setTitle("Time Table Management System");
		crframe.setSize(1400, 860);
		crframe.setBounds(0, 0, 1350, 700);
		crframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		crframe.getContentPane().setLayout(null);
	
		crframe.setLocationRelativeTo(null);
		crframe.setVisible(true);
		
		/*JLabel rlblNewLabel_1 = new JLabel(" Manage Sessions Rooms");
		rlblNewLabel_1.setForeground(new Color(32, 178, 170));
		rlblNewLabel_1.setBackground(new Color(32, 178, 170));
		rlblNewLabel_1.setBounds(262, 69, 1082, 36);
		rlblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		rlblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 22));
		rframe.getContentPane().add(rlblNewLabel_1);*/
		
		JSeparator separator = new JSeparator();
		separator.setBounds(262, 108, 1082, 12);
		separator.setForeground(new Color(32, 178, 170));
		separator.setBackground(new Color(0, 139, 139));
		crframe.getContentPane().add(separator);
		
		JPanel crpanel_2 = new JPanel();
		crpanel_2.setBackground(new Color(230, 230, 250));
		crpanel_2.setBounds(262, 108, 1082, 563);
		crframe.getContentPane().add(crpanel_2);
		crpanel_2.setLayout(null);
		
		JPanel crpanel_3 = new JPanel();
		crpanel_3.setBounds(138, 83, 756, 428);
		crpanel_2.add(crpanel_3);
		crpanel_3.setLayout(null);
		
		JLabel crlblNewLabel = new JLabel("Select Consecutive Session");
		crlblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
		crlblNewLabel.setBounds(73, 79, 161, 13);
		crpanel_3.add(crlblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Select Room");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setBounds(462, 79, 78, 13);
		crpanel_3.add(lblNewLabel_1);
		
		JLabel crlblNewLabel_2 = new JLabel("Selected ConsecutiveSession Room");
		crlblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		crlblNewLabel_2.setBounds(73, 164, 200, 32);
		crpanel_3.add(crlblNewLabel_2);
		
		JTextArea generateConSesRoom = new JTextArea();
		generateConSesRoom.setBounds(276, 169, 339, 82);
		crpanel_3.add(generateConSesRoom);
		
		JButton crbtnNewButton_4 = new JButton("SUBMIT");
		crbtnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		crbtnNewButton_4.setForeground(new Color(255, 255, 255));
		crbtnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generateConSesRoom.setText(consession.getSelectedItem().toString()+"\n"+"-"+consessionroom.getSelectedItem().toString());
				
				String consessionCode=consession.getSelectedItem().toString();
				String cRoom=consessionroom.getSelectedItem().toString();
				String consessionRoomCode = generateConSesRoom.getText();
				
				try {
					Connection con = DBConnection.connect();
					
					String query = "INSERT INTO roomconsecutivesession values (null,'"+consessionCode+"','"+cRoom+"','"+consessionRoomCode+"')";
					Statement sta = con.createStatement();
					int x = sta.executeUpdate(query);
					if(x==0) {
						JLabel label = new JLabel("This is alredy exist");
    					label.setHorizontalAlignment(SwingConstants.CENTER);
    					JOptionPane.showMessageDialog(null, label);
					}else {
    						JLabel label = new JLabel("Inserted Sucessfully");
	    					label.setHorizontalAlignment(SwingConstants.CENTER);
	    					JOptionPane.showMessageDialog(null, label);
	    					
    					}
						
    					con.close();
					
				}catch(Exception exception) {
					exception.printStackTrace();
					
				}
			}
		});
		crbtnNewButton_4.setBackground(new Color(0, 139, 139));
		crbtnNewButton_4.setBounds(317, 291, 105, 32);
		crpanel_3.add(crbtnNewButton_4);
		
		JButton crbtnNewButton_5 = new JButton("CLEAR");
		crbtnNewButton_5.setFont(new Font("Tahoma", Font.BOLD, 12));
		crbtnNewButton_5.setForeground(new Color(255, 255, 255));
		crbtnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				generateConSesRoom.setText("");
				consessionroom.setSelectedIndex(0);
				consession.setSelectedIndex(0);
				
			}
		});
		crbtnNewButton_5.setBackground(new Color(0, 139, 139));
		crbtnNewButton_5.setBounds(490, 291, 105, 32);
		crpanel_3.add(crbtnNewButton_5);
		
		consession = new JComboBox();
		consession.setModel(new DefaultComboBoxModel(new String[] {"Select Consecutive Session-------"}));
		consession.setBounds(262, 76, 176, 21);
		crpanel_3.add(consession);
		
		loadConSession();
		
		consessionroom = new JComboBox();
		consessionroom.setModel(new DefaultComboBoxModel(new String[] {"Select Room-----------"}));
		consessionroom.setBounds(550, 76, 161, 21);
		crpanel_3.add(consessionroom);
		
		loadConsessionRoom();
		
		JPanel srpanel_6 = new JPanel();
		srpanel_6.setBounds(0, 0, 1082, 49);
		crpanel_2.add(srpanel_6);
		srpanel_6.setLayout(null);
		
		
		JLabel lollblNewLabel_1 = new JLabel("Add Consecutive Session Rooms");
		lollblNewLabel_1.setForeground(new Color(0, 128, 128));
		lollblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lollblNewLabel_1.setBounds(406, 13, 278, 31);
		srpanel_6.add(lollblNewLabel_1);
		
		//addsessionroom button
		
		JButton btnNewButton = new JButton("Add SessionRooms");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ManageSessionsRooms manage_ro = new ManageSessionsRooms();
				//manage_ro.main(null);
				crframe.dispose();
				new SessionsRooms();
			}
		});
		btnNewButton.setBounds(0, 319, 179, 39);
		crframe.getContentPane().add(btnNewButton);
		
		//add consession button
		JButton btnNewButton_2 = new JButton("Add ConsecutiveSessionsRooms");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ConsecutiveSessionRooms add_con = new ConsecutiveSessionRooms();
				//add_con.main(null);
				crframe.dispose();
				new ConsecutiveSessionRooms();
			}
		});
		btnNewButton_2.setBounds(0, 356, 251, 39);
		crframe.getContentPane().add(btnNewButton_2);
		
	}
}
