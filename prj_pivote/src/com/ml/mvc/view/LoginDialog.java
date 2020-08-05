package com.ml.mvc.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.ml.mvc.data.model.Usuario;
import com.ml.mvc.service.UsuarioService;

public class LoginDialog extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			LoginDialog dialog = new LoginDialog();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public LoginDialog() {
		setTitle("Acceso al Sistema");
		setBounds(100, 100, 213, 182);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(new GridLayout(0, 1, 5, 5));
		{
			JLabel lblNewLabel = new JLabel("Usuario");
			contentPanel.add(lblNewLabel);
		}
		{
			textField = new JTextField();
			contentPanel.add(textField);
			textField.setColumns(10);
		}
		{
			JLabel lblNewLabel_1 = new JLabel("Contrase\u00F1a");
			contentPanel.add(lblNewLabel_1);
		}
		{
			passwordField = new JPasswordField();
			contentPanel.add(passwordField);
		}
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						actionPerformedPrincipal(arg0);
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						actionPerformedPrincipal(arg0);
					}
				});
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}

	public void actionPerformedPrincipal(ActionEvent e) {
	    String cmd = e.getActionCommand();

	    if ("OK".equals(cmd)) { //Process the password.
	        char[] input = passwordField.getPassword();
	        if (isPasswordCorrect(input)) {
	            JOptionPane.showMessageDialog( this,
	                "Success! You typed the right password.");
	        } else {
////	            JOptionPane.showMessageDialog(controllingFrame,
////	                "Invalid password. Try again.",
////	                "Error Message",
////	                JOptionPane.ERROR_MESSAGE);
	        }

	        //Zero out the possible password, for security.
	        ///Arrays.fill(input, '0');

	        passwordField.selectAll();
//	       // resetFocus();
	    } else {
	    	//handle the Help button...
	    }
	}
	
	public void comprobarAcceso() {
		UsuarioService usuarioService = new UsuarioService();
		Usuario usuario = usuarioService.findByName(textField.getText());
		String password = new String(passwordField.getPassword());
		if (password.equals(usuario.getPassword())) {
			System.out.println("Password Correcto");
		}
	}
	
	private static boolean isPasswordCorrect(char[] input) {
	    boolean isCorrect = true;
	    char[] correctPassword = { 'b', 'u', 'g', 'a', 'b', 'o', 'o' };

	    if (input.length != correctPassword.length) {
	        isCorrect = false;
	    } else {
	        isCorrect = Arrays.equals (input, correctPassword);
	    }

	    //Zero out the password.
	    Arrays.fill(correctPassword,'0');

	    return isCorrect;
	}

}
