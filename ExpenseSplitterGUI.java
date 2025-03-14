import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class ExpenseSplitterGUI extends JFrame {
    private List<Person> persons = new ArrayList<>();
    private JTextArea transactionArea;
    private JTextArea balanceArea;
    private JTextField amountField;
    private JComboBox<String> payerCombo;
    private JList<String> personsList;
    private DefaultListModel<String> personsListModel;
    private int numPeople;
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JTabbedPane tabbedPane;
    private JTextArea allTransactionsArea;
    private static final String PERSON_IMAGE_PATH = "C:\\Users\\sarba_lcvi2cc\\Downloads\\th (1).jpeg";
    private static final String MONEY_IMAGE_PATH = "C:\\Users\\sarba_lcvi2cc\\Downloads\\th (2).jpeg";

    static class Person {
        String name;
        Map<Integer, Double> balances = new HashMap<>();

        public Person(String name, int totalPersons) {
            this.name = name;
            for (int i = 1; i <= totalPersons; i++) {
                balances.put(i, 0.0);
            }
        }
    }

    public ExpenseSplitterGUI() {
        super("Expense Splitter");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        setSize(900, 650);
        setLocationRelativeTo(null);
        getContentPane().setBackground(new Color(245, 245, 245));
    }

    private void initComponents() {
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        cardPanel.setBackground(new Color(245, 245, 245));

        // Setup Panel
        JPanel setupPanel = createStyledPanel(new GridLayout(5, 1, 10, 20));
        JLabel titleLabel = new JLabel("Expense Splitter");
        titleLabel.setFont(new Font("Segoe UI", Font.BOLD, 32));
        titleLabel.setForeground(new Color(30, 30, 30));
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel subtitleLabel = createIconLabel(MONEY_IMAGE_PATH, "Split expenses with ease", Font.ITALIC, 16, 40);
        subtitleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel numPeopleLabel = createStyledLabel("Number of People:");
        JTextField numPeopleField = createStyledTextField(5);
        JButton startButton = createStyledButton("Get Started");

        setupPanel.add(titleLabel);
        setupPanel.add(subtitleLabel);
        setupPanel.add(numPeopleLabel);
        setupPanel.add(numPeopleField);
        setupPanel.add(startButton);

        // Main Panel with Tabs
        JPanel mainPanel = createStyledPanel(new BorderLayout(15, 15));
        tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("Segoe UI", Font.PLAIN, 16));
        tabbedPane.setBackground(new Color(245, 245, 245));
        tabbedPane.setForeground(new Color(30, 30, 30));

        // Transaction Tab
        JPanel transactionTab = createStyledPanel(new BorderLayout(15, 15));
        JPanel inputPanel = createStyledPanel(new GridLayout(5, 2, 15, 15));
        
        JLabel amountLabel = createStyledLabel("Amount:");
        amountField = createStyledTextField(10);
        JLabel payerLabel = createStyledLabel("Paid by:");
        payerCombo = new JComboBox<>();
        payerCombo.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        payerCombo.setBackground(Color.WHITE);
        payerCombo.setForeground(new Color(30, 30, 30));
        JLabel paidForLabel = createStyledLabel("Split among:");
        personsListModel = new DefaultListModel<>();
        personsList = new JList<>(personsListModel);
        personsList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        personsList.setBackground(Color.WHITE);
        personsList.setForeground(new Color(30, 30, 30));
        personsList.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        JButton addTransactionButton = createStyledButton("Add Transaction");

        inputPanel.add(createIconLabel(MONEY_IMAGE_PATH, "💵", 40));
        inputPanel.add(amountLabel);
        inputPanel.add(new JLabel());
        inputPanel.add(amountField);
        inputPanel.add(createIconLabel(PERSON_IMAGE_PATH, "👤", 40));
        inputPanel.add(payerLabel);
        inputPanel.add(new JLabel());
        inputPanel.add(payerCombo);
        inputPanel.add(createIconLabel(PERSON_IMAGE_PATH, "👥", 40));
        inputPanel.add(paidForLabel);
        
        JPanel buttonPanel = createStyledPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        buttonPanel.add(addTransactionButton);
        
        transactionArea = createStyledTextArea(12, 40);
        transactionTab.add(inputPanel, BorderLayout.NORTH);
        transactionTab.add(new JScrollPane(personsList), BorderLayout.CENTER);
        transactionTab.add(new JScrollPane(transactionArea), BorderLayout.EAST);
        transactionTab.add(buttonPanel, BorderLayout.SOUTH);

        // All Transactions Tab
        JPanel allTransactionsTab = createStyledPanel(new BorderLayout(15, 15));
        allTransactionsArea = createStyledTextArea(20, 40);
        allTransactionsTab.add(new JScrollPane(allTransactionsArea), BorderLayout.CENTER);

        // Balance Tab
        JPanel balanceTab = createStyledPanel(new BorderLayout(15, 15));
        balanceArea = createStyledTextArea(20, 40);
        JButton backButton = createStyledButton("Back to Transactions");
        JButton calculateBalanceButton = createStyledButton("Calculate Balance");
        
        JPanel balanceButtonPanel = createStyledPanel(new FlowLayout(FlowLayout.CENTER, 15, 0));
        balanceButtonPanel.add(calculateBalanceButton);
        balanceButtonPanel.add(backButton);
        
        balanceTab.add(createIconLabel(MONEY_IMAGE_PATH, "Final Settlement", Font.BOLD, 20, 40, SwingConstants.CENTER), 
                      BorderLayout.NORTH);
        balanceTab.add(new JScrollPane(balanceArea), BorderLayout.CENTER);
        balanceTab.add(balanceButtonPanel, BorderLayout.SOUTH);

        tabbedPane.addTab("Add Transaction", transactionTab);
        tabbedPane.addTab("Transaction History", allTransactionsTab);
        tabbedPane.addTab("Final Settlement", balanceTab);
        mainPanel.add(tabbedPane, BorderLayout.CENTER);

        cardPanel.add(setupPanel, "Setup");
        cardPanel.add(mainPanel, "Main");

        add(cardPanel);

        // Action Listeners
        startButton.addActionListener(e -> startApplication(numPeopleField));
        addTransactionButton.addActionListener(e -> processTransaction());
        calculateBalanceButton.addActionListener(e -> calculateAndShowFinalBalance());
        backButton.addActionListener(e -> tabbedPane.setSelectedIndex(0));
    }

    private JPanel createStyledPanel(LayoutManager layout) {
        JPanel panel = new JPanel(layout);
        panel.setBackground(new Color(245, 245, 245));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        return panel;
    }

    private JLabel createStyledLabel(String text) {
        return createStyledLabel(text, Font.PLAIN, 16, SwingConstants.LEFT);
    }

    private JLabel createStyledLabel(String text, int style, int size, int alignment) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Segoe UI", style, size));
        label.setForeground(new Color(30, 30, 30));
        label.setHorizontalAlignment(alignment);
        return label;
    }

    private JTextField createStyledTextField(int columns) {
        JTextField field = new JTextField(columns);
        field.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        field.setBackground(Color.WHITE);
        field.setForeground(new Color(30, 30, 30));
        field.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200)),
            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        return field;
    }

    private JTextArea createStyledTextArea(int rows, int cols) {
        JTextArea area = new JTextArea(rows, cols);
        area.setFont(new Font("Segoe UI", Font.PLAIN, 14));
        area.setBackground(Color.WHITE);
        area.setForeground(new Color(30, 30, 30));
        area.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(new Color(200, 200, 200)),
            BorderFactory.createEmptyBorder(5, 5, 5, 5)));
        area.setEditable(false);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        return area;
    }

    private JButton createStyledButton(String text) {
        JButton button = new JButton(text);
        button.setFont(new Font("Segoe UI", Font.BOLD, 14));
        button.setBackground(new Color(30, 30, 30));
        button.setForeground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }

    private JLabel createIconLabel(String imagePath, String fallback, int size) {
        try {
            ImageIcon originalIcon = new ImageIcon(imagePath);
            Image scaledImage = originalIcon.getImage().getScaledInstance(size, size, Image.SCALE_SMOOTH);
            return new JLabel(new ImageIcon(scaledImage));
        } catch (Exception e) {
            JLabel label = new JLabel(fallback);
            label.setFont(new Font("Segoe UI", Font.PLAIN, size));
            label.setForeground(new Color(100, 100, 100));
            System.out.println("Failed to load image: " + imagePath + " - " + e.getMessage());
            return label;
        }
    }

    private JLabel createIconLabel(String imagePath, String text, int style, int size, int imageSize) {
        return createIconLabel(imagePath, text, style, size, imageSize, SwingConstants.LEFT);
    }

    private JLabel createIconLabel(String imagePath, String text, int style, int size, int imageSize, int alignment) {
        JLabel label;
        try {
            ImageIcon originalIcon = new ImageIcon(imagePath);
            Image scaledImage = originalIcon.getImage().getScaledInstance(imageSize, imageSize, Image.SCALE_SMOOTH);
            label = new JLabel(text, new ImageIcon(scaledImage), alignment);
        } catch (Exception e) {
            label = new JLabel(text + " " + "💸", alignment);
            System.out.println("Failed to load image: " + imagePath + " - " + e.getMessage());
        }
        label.setFont(new Font("Segoe UI", style, size));
        label.setForeground(new Color(30, 30, 30));
        label.setIconTextGap(10);
        return label;
    }

    private String showCustomNameDialog(String prompt) {
        JPanel panel = new JPanel(new BorderLayout(15, 15));
        panel.setBackground(new Color(245, 245, 245));
        panel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JLabel iconLabel = createIconLabel(PERSON_IMAGE_PATH, "👤", 50);
        
        JLabel messageLabel = new JLabel(prompt);
        messageLabel.setFont(new Font("Segoe UI", Font.PLAIN, 18));
        messageLabel.setForeground(new Color(30, 30, 30));
        
        JTextField nameField = createStyledTextField(15);
        
        panel.add(iconLabel, BorderLayout.WEST);
        panel.add(messageLabel, BorderLayout.NORTH);
        panel.add(nameField, BorderLayout.CENTER);

        int result = JOptionPane.showConfirmDialog(this, panel, 
            "Enter Person's Name", JOptionPane.OK_CANCEL_OPTION, 
            JOptionPane.PLAIN_MESSAGE);
        
        if (result == JOptionPane.OK_OPTION) {
            return nameField.getText().trim();
        }
        return null;
    }

    private void startApplication(JTextField numPeopleField) {
        try {
            numPeople = Integer.parseInt(numPeopleField.getText());
            if (numPeople <= 0) throw new NumberFormatException();
            persons.clear();
            payerCombo.removeAllItems();
            personsListModel.clear();
            transactionArea.setText("");
            allTransactionsArea.setText("");
            balanceArea.setText("");
            for (int i = 1; i <= numPeople; i++) {
                String name = showCustomNameDialog("Enter name for person " + i + ":");
                if (name != null && !name.isEmpty()) {
                    persons.add(new Person(name, numPeople));
                    payerCombo.addItem(name);
                    personsListModel.addElement(name);
                } else {
                    i--; // Repeat if name is empty or cancelled
                }
            }
            cardLayout.show(cardPanel, "Main");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, 
                "Please enter a valid positive number", "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    private void processTransaction() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            if (amount < 0) {
                JOptionPane.showMessageDialog(this, 
                    "Amount cannot be negative", "Error", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            int payerIndex = payerCombo.getSelectedIndex();
            int[] paidForIndices = personsList.getSelectedIndices();
            
            if (paidForIndices.length == 0) {
                JOptionPane.showMessageDialog(this, 
                    "Please select who was paid for", "Error", 
                    JOptionPane.ERROR_MESSAGE);
                return;
            }

            double splitAmount = amount / paidForIndices.length;
            
            try (BufferedWriter balanceWriter = new BufferedWriter(
                    new FileWriter("balance.txt", true))) {
                StringBuilder transactionText = new StringBuilder("Transaction:\n");
                balanceWriter.write("Transaction:\n");
                for (int index : paidForIndices) {
                    if (index != payerIndex) {
                        String transaction = String.format("%.2f to be paid to %s by %s\n",
                            splitAmount, persons.get(payerIndex).name, 
                            persons.get(index).name);
                        balanceWriter.write(transaction);
                        transactionText.append(transaction);
                        persons.get(index).balances.put(payerIndex + 1,
                            persons.get(index).balances.get(payerIndex + 1) + splitAmount);
                    }
                }
                balanceWriter.write("\n");
                transactionText.append("\n");
                transactionArea.append(transactionText.toString());
                allTransactionsArea.append(transactionText.toString());
            } catch (IOException ex) {
                transactionArea.append("Error writing to file: " + ex.getMessage() + "\n");
            }

            amountField.setText("");
            personsList.clearSelection();

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, 
                "Please enter a valid amount", "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }

    private void calculateAndShowFinalBalance() {
        balanceArea.setText("Final Settlement Summary:\n");
        
        if (persons.isEmpty()) {
            balanceArea.append("No transactions to settle.\n");
            return;
        }

        try (BufferedWriter settlementWriter = new BufferedWriter(
                new FileWriter("settlement.txt"))) {
            settlementWriter.write("Final Settlement Summary:\n");

            // Step 1: Calculate net balances
            Map<String, Double> netBalances = new HashMap<>();
            for (Person p : persons) {
                netBalances.put(p.name, 0.0);
            }

            // Aggregate all debts (who owes what to whom)
            for (Person debtor : persons) {
                for (int creditorIndex = 0; creditorIndex < numPeople; creditorIndex++) {
                    double amountOwed = debtor.balances.getOrDefault(creditorIndex + 1, 0.0);
                    if (amountOwed > 0) {
                        String creditorName = persons.get(creditorIndex).name;
                        String debtorName = debtor.name;
                        netBalances.put(creditorName, netBalances.get(creditorName) + amountOwed);
                        netBalances.put(debtorName, netBalances.get(debtorName) - amountOwed);
                    }
                }
            }

            // Step 2: Simplify transactions
            List<String> finalTransactions = new ArrayList<>();
            Map<String, Double> tempBalances = new HashMap<>(netBalances);
            
            // Separate debtors and creditors
            List<Map.Entry<String, Double>> debtors = new ArrayList<>();
            List<Map.Entry<String, Double>> creditors = new ArrayList<>();
            for (Map.Entry<String, Double> entry : tempBalances.entrySet()) {
                double balance = entry.getValue();
                if (balance < -0.01) debtors.add(entry);
                else if (balance > 0.01) creditors.add(entry);
            }

            // Match debtors with creditors
            for (Map.Entry<String, Double> debtor : debtors) {
                String debtorName = debtor.getKey();
                double debt = debtor.getValue();
                Iterator<Map.Entry<String, Double>> creditorIterator = creditors.iterator();
                
                while (debt < -0.01 && creditorIterator.hasNext()) {
                    Map.Entry<String, Double> creditor = creditorIterator.next();
                    String creditorName = creditor.getKey();
                    double credit = creditor.getValue();
                    double amount = Math.min(-debt, credit);
                    
                    if (amount > 0) {
                        String transaction = String.format("%.2f to be paid to %s by %s\n",
                            amount, creditorName, debtorName);
                        finalTransactions.add(transaction);
                        tempBalances.put(debtorName, tempBalances.get(debtorName) + amount);
                        tempBalances.put(creditorName, tempBalances.get(creditorName) - amount);
                        debt += amount;
                        credit -= amount;
                        
                        if (credit < 0.01) {
                            creditorIterator.remove();
                        } else {
                            creditor.setValue(credit);
                        }
                    }
                }
            }

            // Step 3: Display results
            if (finalTransactions.isEmpty()) {
                balanceArea.append("All balances are settled!\n");
                settlementWriter.write("All balances are settled!\n");
            } else {
                for (String transaction : finalTransactions) {
                    balanceArea.append(transaction);
                    settlementWriter.write(transaction);
                }
            }
            
            balanceArea.append("\nResults saved to balance.txt and settlement.txt");
            balanceArea.revalidate();
            balanceArea.repaint();
        } catch (IOException ex) {
            balanceArea.append("Error writing to file: " + ex.getMessage() + "\n");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ExpenseSplitterGUI().setVisible(true);
        });
    }
}