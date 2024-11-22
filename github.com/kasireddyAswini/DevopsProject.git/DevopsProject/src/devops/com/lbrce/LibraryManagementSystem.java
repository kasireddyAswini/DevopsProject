package devops.com.lbrce;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
public class LibraryManagementSystem {
    // List to store books
    private static List<Book> books = new ArrayList<>();

    public static void main(String[] args) {
        // Create the main frame
        JFrame frame = new JFrame("Library Management System");
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        // Create the top panel for adding books
        JPanel addBookPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        JLabel nameLabel = new JLabel("Book Name:");
        JTextField nameField = new JTextField();
        JLabel authorLabel = new JLabel("Author:");
        JTextField authorField = new JTextField();
        JButton addButton = new JButton("Add Book");

        addBookPanel.add(nameLabel);
        addBookPanel.add(nameField);
        addBookPanel.add(authorLabel);
        addBookPanel.add(authorField);
        addBookPanel.add(new JLabel()); // Empty space
        addBookPanel.add(addButton);

        // Create the bottom panel for displaying books
        JTextArea bookListArea = new JTextArea();
        bookListArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(bookListArea);

        // Action listener for adding a book
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText().trim();
                String author = authorField.getText().trim();
                if (!name.isEmpty() && !author.isEmpty()) {
                    books.add(new Book(name, author));
                    nameField.setText("");
                    authorField.setText("");
                    updateBookList(bookListArea);
                } else {
                    JOptionPane.showMessageDialog(frame, "Please enter both name and author.");
                }
            }
        });

        // Add panels to the frame
        frame.add(addBookPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);

        // Display the frame
        frame.setVisible(true);
    }

    // Method to update the book list in the text area
    private static void updateBookList(JTextArea bookListArea) {
        StringBuilder bookList = new StringBuilder("Available Books:\n");
        for (Book book : books) {
            bookList.append(book.getName()).append(" by ").append(book.getAuthor()).append("\n");
        }
        bookListArea.setText(bookList.toString());
    }

    // Book class to represent a book
    static class Book {
        private String name;
        private String author;

        public Book(String name, String author) {
            this.name = name;
            this.author = author;
        }

        public String getName() {
            return name;
        }

        public String getAuthor() {
            return author;
        }
    }
}