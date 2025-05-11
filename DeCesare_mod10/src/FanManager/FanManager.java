package FanManager;

/*
Anton DeCesare - Module 10

This program connects to a MySQL database and provides a GUI to display and update fan records.
Users enter an ID to load a fan’s information or edit and update it in the database using Swing buttons.
DB: fanclubdb
USER: fanmember
PASSWORD: pass
*/

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class FanManager extends JFrame {
    private JTextField idField, firstNameField, lastNameField, teamField;
    private JButton displayButton, updateButton;

    // JDBC connection details (uses fanmember login)
    private static final String DB_URL = "jdbc:mysql://localhost:3306/fanclubdb?allowPublicKeyRetrieval=true&useSSL=false";
    private static final String DB_USER = "fanmember";
    private static final String DB_PASS = "pass";

    public FanManager() {
        // Set up the GUI window and fields
        setTitle("Fan Manager");
        setLayout(null);
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Create and label text fields
        JLabel idLabel = new JLabel("ID:");
        JLabel firstLabel = new JLabel("First Name:");
        JLabel lastLabel = new JLabel("Last Name:");
        JLabel teamLabel = new JLabel("Favorite Team:");

        idField = new JTextField();
        firstNameField = new JTextField();
        lastNameField = new JTextField();
        teamField = new JTextField();

        displayButton = new JButton("Display");
        updateButton = new JButton("Update");

        // Position GUI components
        idLabel.setBounds(30, 20, 100, 25);
        idField.setBounds(150, 20, 200, 25);
        firstLabel.setBounds(30, 60, 100, 25);
        firstNameField.setBounds(150, 60, 200, 25);
        lastLabel.setBounds(30, 100, 100, 25);
        lastNameField.setBounds(150, 100, 200, 25);
        teamLabel.setBounds(30, 140, 100, 25);
        teamField.setBounds(150, 140, 200, 25);

        displayButton.setBounds(60, 190, 100, 30);
        updateButton.setBounds(200, 190, 100, 30);

        // Add all components to the frame
        add(idLabel); add(idField);
        add(firstLabel); add(firstNameField);
        add(lastLabel); add(lastNameField);
        add(teamLabel); add(teamField);
        add(displayButton); add(updateButton);

        // Button actions
        displayButton.addActionListener(e -> displayRecord());
        updateButton.addActionListener(e -> updateRecord());

        setVisible(true);
    }

    // Display record based on ID entered
    private void displayRecord() {
        /*
         - Get the ID from the ID field
         - Connect to the database
         - Query the "fans" table using the ID
         - If record is found:
             - Set the first name, last name, and favorite team fields with returned values
         - Else:
             - Show a "Not found" message
         */
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            String query = "SELECT * FROM fans WHERE ID = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, Integer.parseInt(idField.getText()));
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                firstNameField.setText(rs.getString("firstname"));
                lastNameField.setText(rs.getString("lastname"));
                teamField.setText(rs.getString("favoriteteam"));
            } else {
                JOptionPane.showMessageDialog(this, "No record found.");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    // Update the record with new values from the text fields
    private void updateRecord() {
        /*
         - Get the ID and new values from all fields
         - Connect to the database
         - Run an UPDATE query using the new values and the given ID
         - If the update affects a row:
             - Show success message
         - Else:
             - Show "No record found" message
         */
        try (Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASS)) {
            String update = "UPDATE fans SET firstname=?, lastname=?, favoriteteam=? WHERE ID=?";
            PreparedStatement stmt = conn.prepareStatement(update);
            stmt.setString(1, firstNameField.getText());
            stmt.setString(2, lastNameField.getText());
            stmt.setString(3, teamField.getText());
            stmt.setInt(4, Integer.parseInt(idField.getText()));

            int rows = stmt.executeUpdate();
            if (rows > 0) {
                JOptionPane.showMessageDialog(this, "Record updated.");
            } else {
                JOptionPane.showMessageDialog(this, "No record found.");
            }

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        /*
         - Load the MySQL JDBC driver
         - Launch the FanManager window on the Swing event thread
         */
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            JOptionPane.showMessageDialog(null, "MySQL JDBC Driver not found.");
            return;
        }

        SwingUtilities.invokeLater(() -> new FanManager());
    }
}