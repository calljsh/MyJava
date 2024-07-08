import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class LibraryGUI extends JFrame {
    private BookManager bookManager;

    public LibraryGUI() {
        bookManager = new BookManager();
        setTitle("Library Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 设置主面板
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        // 添加书籍面板
        JPanel addBookPanel = new JPanel();
        addBookPanel.setLayout(new GridLayout(5, 2));
        addBookPanel.add(new JLabel("Title:"));
        JTextField titleField = new JTextField();
        addBookPanel.add(titleField);

        addBookPanel.add(new JLabel("Author:"));
        JTextField authorField = new JTextField();
        addBookPanel.add(authorField);

        addBookPanel.add(new JLabel("Publisher:"));
        JTextField publisherField = new JTextField();
        addBookPanel.add(publisherField);

        addBookPanel.add(new JLabel("Year:"));
        JTextField yearField = new JTextField();
        addBookPanel.add(yearField);

        JButton addButton = new JButton("Add Book");
        addBookPanel.add(addButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = titleField.getText();
                String author = authorField.getText();
                String publisher = publisherField.getText();
                int year = Integer.parseInt(yearField.getText());

                try {
                    bookManager.addBook(title, author, publisher, year);
                    JOptionPane.showMessageDialog(null, "Book added successfully!");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error adding book: " + ex.getMessage());
                }
            }
        });

        mainPanel.add(addBookPanel, BorderLayout.NORTH);

        // 显示书籍面板
        JTextArea bookListArea = new JTextArea();
        mainPanel.add(new JScrollPane(bookListArea), BorderLayout.CENTER);

        JButton listButton = new JButton("List Books");
        mainPanel.add(listButton, BorderLayout.SOUTH);

        listButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    bookListArea.setText(""); // 清空文本区
                    bookManager.listBooks();
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, "Error listing books: " + ex.getMessage());
                }
            }
        });
        add(mainPanel);
    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new LibraryGUI().setVisible(true);
            }
        });
    }
}
