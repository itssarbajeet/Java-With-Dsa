import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import java.util.List;

public class ExpenseNavigatorGUI extends JFrame {
    private List<Person> persons = new ArrayList<>();
    private JTextArea transactionArea, balanceArea, personalArea, summaryArea, allTransactionsArea;
    private JTextField amountField, personalAmountField, budgetAmountField;
    private JComboBox<String> payerCombo, categoryCombo, budgetCategoryCombo, personalCategoryCombo;
    private JList<String> personsList;
    private DefaultListModel<String> personsListModel;
    private int numPeople;
    private CardLayout cardLayout;
    private JPanel cardPanel;
    private JTabbedPane tabbedPane;
    private static final String PERSON_IMAGE_PATH = "C:\\Users\\sarba_lcvi2cc\\Downloads\\th (1).jpeg";
    private static final String MONEY_IMAGE_PATH = "C:\\Users\\sarba_lcvi2cc\\Downloads\\th (2).jpeg";
    private static final String DATA_PATH = "C:\\Users\\sarba_lcvi2cc\\Java-With-Dsa\\.vscode\\experiment\\";
    private int mode = 1; // 1: Bill Splitter, 2: Individual Expense Tracker

    // Color Scheme
    private static final Color BACKGROUND_COLOR = Color.WHITE; // #FFFFFF
    private static final Color BUTTON_COLOR = new Color(25, 118, 210); // #1976D2
    private static final Color TEXT_COLOR = new Color(33, 33, 33); // #212121
    private static final Color BORDER_COLOR = new Color(120, 144, 156); // #78909C

    static class Person implements Serializable {
        String name;
        Map<Integer, Double> balances = new HashMap<>();
        Map<String, Double> personalExpenses = new HashMap<>();
        Map<String, Double> budgets = new HashMap<>();

        public Person(String name, int totalPersons) {
            this.name = name;
            for (int i = 1; i <= totalPersons; i++) {
                balances.put(i, 0.0);
            }
        }
    }

    static class Transaction implements Serializable {
        String payer;
        double amount;
        String category;
        List<String> paidFor;
        boolean isPersonal;
        String description;

        Transaction(String payer, double amount, String category, List<String> paidFor, boolean isPersonal, String description) {
            this.payer = payer;
            this.amount = amount;
            this.category = category;
            this.paidFor = paidFor;
            this.isPersonal = isPersonal;
            this.description = description;
        }
    }

    private List<Transaction> transactions = new ArrayList<>();
    private String[] categories = {"Food", "Travel", "Rent", "Utilities", "Entertainment", "Other"};

    public ExpenseNavigatorGUI() {
        super("Expense Navigator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        initComponents();
        getContentPane().setBackground(BACKGROUND_COLOR);
        pack();
    }

    private void initComponents() {
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);
        cardPanel.setBackground(BACKGROUND_COLOR);

        // Setup Panel
        JPanel setupPanel = createStyledPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(20, 20, 20, 20);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        JLabel titleLabel = createStyledLabel("Expense Navigator", Font.BOLD, 40, SwingConstants.CENTER);
        titleLabel.setForeground(BUTTON_COLOR);
        gbc.gridy = 0;
        setupPanel.add(titleLabel, gbc);

        JLabel modeLabel = createStyledLabel("Select Mode", Font.PLAIN, 18, SwingConstants.LEFT);
        gbc.gridy = 1;
        setupPanel.add(modeLabel, gbc);

        String[] modes = {"Bill Splitter", "Individual Expense Tracker"};
        JComboBox<String> modeCombo = new JComboBox<>(modes);
        styleComboBox(modeCombo);
        gbc.gridy = 2;
        setupPanel.add(modeCombo, gbc);

        JLabel startOptionLabel = createStyledLabel("Start Option", Font.PLAIN, 18, SwingConstants.LEFT);
        gbc.gridy = 3;
        setupPanel.add(startOptionLabel, gbc);

        String[] startOptions = {"Start New", "Load Previous Calculations"};
        JComboBox<String> startOptionCombo = new JComboBox<>(startOptions);
        styleComboBox(startOptionCombo);
        gbc.gridy = 4;
        setupPanel.add(startOptionCombo, gbc);

        JButton startButton = createStyledButton("Get Started", BUTTON_COLOR);
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.NONE;
        setupPanel.add(startButton, gbc);

        // Main Panel with Tabs
        JPanel mainPanel = createStyledPanel(new BorderLayout(20, 20));
        tabbedPane = new JTabbedPane();
        tabbedPane.setFont(new Font("Roboto", Font.BOLD, 18));
        tabbedPane.setBackground(BACKGROUND_COLOR);
        tabbedPane.setForeground(BUTTON_COLOR);

        JPanel transactionTab = createTransactionTab();
        JPanel personalTab = createPersonalTab();
        JPanel budgetTab = createBudgetTab();
        JPanel allTransactionsTab = createStyledPanel(new BorderLayout(20, 20));
        allTransactionsArea = createStyledTextArea(20, 50);
        allTransactionsTab.add(new JScrollPane(allTransactionsArea), BorderLayout.CENTER);
        JPanel summaryTab = createSummaryTab();

        tabbedPane.addTab("Add Transaction", transactionTab);
        tabbedPane.addTab("Personal Expenses", personalTab);
        tabbedPane.addTab("Budget Settings", budgetTab);
        tabbedPane.addTab("Transaction History", allTransactionsTab);
        tabbedPane.addTab("Summary", summaryTab);
        mainPanel.add(tabbedPane, BorderLayout.CENTER);

        cardPanel.add(setupPanel, "Setup");
        cardPanel.add(mainPanel, "Main");
        add(cardPanel, BorderLayout.CENTER);

        modeCombo.addActionListener(e -> mode = modeCombo.getSelectedIndex() + 1);
        startButton.addActionListener(e -> startApplication(startOptionCombo.getSelectedIndex() == 0));

        addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                adjustFontSizes(getWidth(), getHeight());
            }
        });
    }

    private JPanel createTransactionTab() {
        JPanel transactionTab = createStyledPanel(new BorderLayout(20, 20));
        JPanel inputPanel = createStyledPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        gbc.gridx = 0; gbc.gridy = 0;
        inputPanel.add(createIconLabel(MONEY_IMAGE_PATH, "💵", 35), gbc);
        gbc.gridx = 1;
        inputPanel.add(createStyledLabel("Amount", Font.PLAIN, 18, SwingConstants.LEFT), gbc);
        gbc.gridx = 2;
        amountField = createStyledTextField(15);
        inputPanel.add(amountField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        inputPanel.add(new JLabel(), gbc);
        gbc.gridx = 1;
        inputPanel.add(createStyledLabel("Category", Font.PLAIN, 18, SwingConstants.LEFT), gbc);
        gbc.gridx = 2;
        categoryCombo = new JComboBox<>(categories);
        styleComboBox(categoryCombo);
        inputPanel.add(categoryCombo, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        inputPanel.add(new JLabel(), gbc);
        gbc.gridx = 1;
        inputPanel.add(createStyledLabel("Description", Font.PLAIN, 18, SwingConstants.LEFT), gbc);
        gbc.gridx = 2;
        JTextField descriptionField = createStyledTextField(20);
        inputPanel.add(descriptionField, gbc);

        gbc.gridx = 0; gbc.gridy = 3;
        inputPanel.add(createIconLabel(PERSON_IMAGE_PATH, "👤", 35), gbc);
        gbc.gridx = 1;
        inputPanel.add(createStyledLabel("Paid by", Font.PLAIN, 18, SwingConstants.LEFT), gbc);
        gbc.gridx = 2;
        payerCombo = new JComboBox<>();
        styleComboBox(payerCombo);
        inputPanel.add(payerCombo, gbc);

        gbc.gridx = 0; gbc.gridy = 4;
        inputPanel.add(createIconLabel(PERSON_IMAGE_PATH, "👥", 35), gbc);
        gbc.gridx = 1;
        inputPanel.add(createStyledLabel("Split among (Bill Splitter)", Font.PLAIN, 18, SwingConstants.LEFT), gbc);
        gbc.gridx = 2; gbc.weighty = 1.0; gbc.fill = GridBagConstraints.BOTH;
        personsListModel = new DefaultListModel<>();
        personsList = new JList<>(personsListModel);
        personsList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        personsList.setBackground(BACKGROUND_COLOR);
        personsList.setBorder(BorderFactory.createLineBorder(BORDER_COLOR, 1, true));
        personsList.setFont(new Font("Roboto", Font.PLAIN, 16));
        JScrollPane personsScroll = new JScrollPane(personsList);
        personsScroll.setPreferredSize(new Dimension(250, 150));
        inputPanel.add(personsScroll, gbc);

        JPanel buttonPanel = createStyledPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));
        JButton addTransactionButton = createStyledButton("Add Transaction", BUTTON_COLOR);
        buttonPanel.add(addTransactionButton);

        transactionArea = createStyledTextArea(15, 50);
        transactionTab.add(new JScrollPane(inputPanel), BorderLayout.NORTH);
        transactionTab.add(new JScrollPane(transactionArea), BorderLayout.CENTER);
        transactionTab.add(buttonPanel, BorderLayout.SOUTH);

        addTransactionButton.addActionListener(e -> processTransaction(descriptionField.getText()));
        return transactionTab;
    }

    private JPanel createPersonalTab() {
        JPanel personalTab = createStyledPanel(new BorderLayout(20, 20));
        JPanel inputPanel = createStyledPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        gbc.gridx = 0; gbc.gridy = 0;
        inputPanel.add(createIconLabel(MONEY_IMAGE_PATH, "💵", 35), gbc);
        gbc.gridx = 1;
        inputPanel.add(createStyledLabel("Amount", Font.PLAIN, 18, SwingConstants.LEFT), gbc);
        gbc.gridx = 2;
        personalAmountField = createStyledTextField(15);
        inputPanel.add(personalAmountField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        inputPanel.add(new JLabel(), gbc);
        gbc.gridx = 1;
        inputPanel.add(createStyledLabel("Description", Font.PLAIN, 18, SwingConstants.LEFT), gbc);
        gbc.gridx = 2;
        JTextField descriptionField = createStyledTextField(20);
        inputPanel.add(descriptionField, gbc);

        gbc.gridx = 0; gbc.gridy = 2;
        inputPanel.add(new JLabel(), gbc);
        gbc.gridx = 1;
        inputPanel.add(createStyledLabel("Category", Font.PLAIN, 18, SwingConstants.LEFT), gbc);
        gbc.gridx = 2;
        personalCategoryCombo = new JComboBox<>(categories);
        styleComboBox(personalCategoryCombo);
        inputPanel.add(personalCategoryCombo, gbc);

        personalArea = createStyledTextArea(15, 50);
        JButton addPersonalButton = createStyledButton("Add Personal Expense", BUTTON_COLOR);

        personalTab.add(new JScrollPane(inputPanel), BorderLayout.NORTH);
        personalTab.add(new JScrollPane(personalArea), BorderLayout.CENTER);
        personalTab.add(addPersonalButton, BorderLayout.SOUTH);

        addPersonalButton.addActionListener(e -> processPersonalTransaction(descriptionField.getText()));
        return personalTab;
    }

    private JPanel createBudgetTab() {
        JPanel budgetTab = createStyledPanel(new BorderLayout(20, 20));
        JPanel inputPanel = createStyledPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 15, 15, 15);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1.0;

        gbc.gridx = 0; gbc.gridy = 0;
        inputPanel.add(createIconLabel(MONEY_IMAGE_PATH, "💰", 35), gbc);
        gbc.gridx = 1;
        inputPanel.add(createStyledLabel("Budget Amount", Font.PLAIN, 18, SwingConstants.LEFT), gbc);
        gbc.gridx = 2;
        budgetAmountField = createStyledTextField(15);
        inputPanel.add(budgetAmountField, gbc);

        gbc.gridx = 0; gbc.gridy = 1;
        inputPanel.add(new JLabel(), gbc);
        gbc.gridx = 1;
        inputPanel.add(createStyledLabel("Category", Font.PLAIN, 18, SwingConstants.LEFT), gbc);
        gbc.gridx = 2;
        budgetCategoryCombo = new JComboBox<>(categories);
        styleComboBox(budgetCategoryCombo);
        inputPanel.add(budgetCategoryCombo, gbc);

        gbc.gridx = 0; gbc.gridy = 0;
        inputPanel.add(new JLabel(), gbc);
        gbc.gridx = 1;
        inputPanel.add(createStyledLabel("Person", Font.PLAIN, 18, SwingConstants.LEFT), gbc);
        gbc.gridx = 2;
        JComboBox<String> budgetPersonCombo = new JComboBox<>();
        styleComboBox(budgetPersonCombo);
        inputPanel.add(budgetPersonCombo, gbc);

        JButton setBudgetButton = createStyledButton("Set Budget", BUTTON_COLOR);

        budgetTab.add(new JScrollPane(inputPanel), BorderLayout.NORTH);
        budgetTab.add(setBudgetButton, BorderLayout.SOUTH);

        payerCombo.addActionListener(e -> {
            budgetPersonCombo.removeAllItems();
            for (Person p : persons) budgetPersonCombo.addItem(p.name);
            budgetPersonCombo.setSelectedItem(payerCombo.getSelectedItem());
        });

        setBudgetButton.addActionListener(e -> {
            try {
                double amount = Double.parseDouble(budgetAmountField.getText());
                if (amount < 0) throw new NumberFormatException("Negative amount");
                String category = (String) budgetCategoryCombo.getSelectedItem();
                String person = (String) budgetPersonCombo.getSelectedItem();
                if (person == null) throw new IllegalStateException("No person selected");
                persons.stream().filter(p -> p.name.equals(person)).findFirst()
                    .ifPresent(p -> p.budgets.put(category, amount));
                JOptionPane.showMessageDialog(this, "Budget set for " + person + " in " + category, "Success", JOptionPane.INFORMATION_MESSAGE);
                budgetAmountField.setText("");
                saveData();
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Invalid amount: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalStateException ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        return budgetTab;
    }

    private JPanel createSummaryTab() {
        JPanel summaryTab = createStyledPanel(new BorderLayout(20, 20));
        balanceArea = createStyledTextArea(20, 50);
        summaryArea = createStyledTextArea(20, 50);
        JButton calculateButton = createStyledButton("Calculate Summary", BUTTON_COLOR);
        JButton exportButton = createStyledButton("Export Summary", BUTTON_COLOR);

        JPanel buttonPanel = createStyledPanel(new FlowLayout(FlowLayout.CENTER, 20, 15));
        buttonPanel.add(calculateButton);
        buttonPanel.add(exportButton);

        JLabel summaryLabel = createIconLabel(MONEY_IMAGE_PATH, "Summary", Font.BOLD, 32, 40, SwingConstants.CENTER);
        summaryLabel.setForeground(BUTTON_COLOR);
        summaryTab.add(summaryLabel, BorderLayout.NORTH);
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(balanceArea), new JScrollPane(summaryArea));
        splitPane.setResizeWeight(0.5);
        summaryTab.add(splitPane, BorderLayout.CENTER);
        summaryTab.add(buttonPanel, BorderLayout.SOUTH);

        calculateButton.addActionListener(e -> calculateAndShowSummary());
        exportButton.addActionListener(e -> exportSummary());
        return summaryTab;
    }

    private void adjustFontSizes(int width, int height) {
        int baseSize = Math.min(width, height) / 40;
        titleLabelFontSize = Math.max(32, baseSize);
        labelFontSize = Math.max(18, baseSize / 2);
        componentFontSize = Math.max(16, baseSize / 3);

        Component[] components = cardPanel.getComponents();
        for (Component comp : components) {
            if (comp instanceof JPanel) {
                updateComponentFonts((JPanel) comp);
            }
        }
    }

    private int titleLabelFontSize = 40;
    private int labelFontSize = 18;
    private int componentFontSize = 16;

    private void updateComponentFonts(JPanel panel) {
        for (Component comp : panel.getComponents()) {
            if (comp instanceof JLabel) {
                JLabel label = (JLabel) comp;
                if (label.getText().equals("Expense Navigator")) {
                    label.setFont(new Font("Roboto", Font.BOLD, titleLabelFontSize));
                } else {
                    label.setFont(new Font("Roboto", Font.PLAIN, labelFontSize));
                }
            } else if (comp instanceof JTextField || comp instanceof JComboBox || comp instanceof JTextArea) {
                comp.setFont(new Font("Roboto", Font.PLAIN, componentFontSize));
            } else if (comp instanceof JButton) {
                comp.setFont(new Font("Roboto", Font.BOLD, labelFontSize));
            } else if (comp instanceof JPanel) {
                updateComponentFonts((JPanel) comp);
            } else if (comp instanceof JTabbedPane) {
                JTabbedPane tabs = (JTabbedPane) comp;
                tabs.setFont(new Font("Roboto", Font.BOLD, labelFontSize));
                for (int i = 0; i < tabs.getTabCount(); i++) {
                    updateComponentFonts((JPanel) tabs.getComponentAt(i));
                }
            }
        }
    }

    private void startApplication(boolean startNew) {
        if (startNew) {
            persons.clear();
            payerCombo.removeAllItems();
            personsListModel.clear();
            transactions.clear();
            transactionArea.setText("");
            allTransactionsArea.setText("");
            balanceArea.setText("");
            personalArea.setText("");
            summaryArea.setText("");

            switch (mode) {
                case 1: // Bill Splitter
                    String numPeopleInput = JOptionPane.showInputDialog(this, "Enter the number of people to split bills among:", "Bill Splitter Setup", JOptionPane.PLAIN_MESSAGE);
                    try {
                        numPeople = Integer.parseInt(numPeopleInput);
                        if (numPeople <= 0) throw new NumberFormatException("Number must be positive");
                        for (int i = 1; i <= numPeople; i++) {
                            String name = showCustomNameDialog("Enter name for person " + i + ":");
                            if (name != null && !name.trim().isEmpty()) {
                                persons.add(new Person(name, numPeople));
                                payerCombo.addItem(name);
                                personsListModel.addElement(name);
                            } else {
                                i--;
                            }
                        }
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(this, "Please enter a valid positive number", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    break;

                case 2: // Individual Expense Tracker
                    numPeople = 1;
                    String name = showCustomNameDialog("Enter your name:");
                    if (name != null && !name.trim().isEmpty()) {
                        persons.add(new Person(name, numPeople));
                        payerCombo.addItem(name);
                        personsListModel.addElement(name);
                    } else {
                        JOptionPane.showMessageDialog(this, "Name cannot be empty", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    break;
            }
            saveData();
        } else {
            loadData();
            if (persons.isEmpty()) {
                JOptionPane.showMessageDialog(this, "No previous data found for this mode. Starting new.", "Info", JOptionPane.INFORMATION_MESSAGE);
                startApplication(true);
                return;
            }
            updateUIFromData();
            calculateAndShowSummary();
        }

        tabbedPane.setEnabledAt(1, mode == 2); // Enable Personal Expenses tab only in Individual mode
        cardLayout.show(cardPanel, "Main");
    }

    private void processTransaction(String description) {
        try {
            double amount = Double.parseDouble(amountField.getText());
            if (amount < 0) throw new NumberFormatException("Negative amount");
            String payer = (String) payerCombo.getSelectedItem();
            if (payer == null) throw new IllegalStateException("No payer selected");
            String category = (String) categoryCombo.getSelectedItem();
            int[] paidForIndices = personsList.getSelectedIndices();

            if (mode == 1 && paidForIndices.length == 0) throw new IllegalStateException("No beneficiaries selected");
            double payerShare = (mode == 1) ? amount / paidForIndices.length : amount;

            if (!checkAndConfirmBudget(payer, category, payerShare)) {
                amountField.setText("");
                personsList.clearSelection();
                return;
            }

            switch (mode) {
                case 1:
                    double splitAmount = amount / paidForIndices.length;
                    List<String> paidFor = new ArrayList<>();
                    for (int index : paidForIndices) paidFor.add(persons.get(index).name);
                    Transaction t = new Transaction(payer, amount, category, paidFor, false, description);
                    transactions.add(t);
                    StringBuilder transactionText = new StringBuilder(String.format("Transaction: %s paid %.2f for %s (%s)\n", payer, amount, category, description));
                    transactionText.append("Split among: " + String.join(", ", paidFor) + "\n");
                    int payerIndex = persons.indexOf(persons.stream().filter(p -> p.name.equals(payer)).findFirst().orElse(null));
                    for (int index : paidForIndices) {
                        if (index != payerIndex) {
                            String text = String.format("%.2f to be paid to %s by %s\n", splitAmount, payer, persons.get(index).name);
                            transactionText.append(text);
                            persons.get(index).balances.put(payerIndex + 1,
                                persons.get(index).balances.getOrDefault(payerIndex + 1, 0.0) + splitAmount);
                        }
                    }
                    transactionText.append("\n");
                    transactionArea.append(transactionText.toString());
                    allTransactionsArea.append(transactionText.toString());
                    break;

                case 2:
                    persons.stream().filter(p -> p.name.equals(payer)).findFirst()
                        .ifPresent(p -> p.personalExpenses.merge(category, amount, Double::sum));
                    Transaction pt = new Transaction(payer, amount, category, Collections.singletonList(payer), true, description);
                    transactions.add(pt);
                    String personalText = String.format("%s spent %.2f on %s (%s - %s)\n\n", payer, amount, category, category, description);
                    transactionArea.append(personalText);
                    allTransactionsArea.append(personalText);
                    break;
            }
            amountField.setText("");
            personsList.clearSelection();
            saveData();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid amount: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalStateException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void processPersonalTransaction(String description) {
        try {
            double amount = Double.parseDouble(personalAmountField.getText());
            if (amount < 0) throw new NumberFormatException("Negative amount");
            String payer = (String) payerCombo.getSelectedItem();
            if (payer == null) throw new IllegalStateException("No payer selected");
            String category = (String) personalCategoryCombo.getSelectedItem();

            if (!checkAndConfirmBudget(payer, category, amount)) {
                personalAmountField.setText("");
                return;
            }

            persons.stream().filter(p -> p.name.equals(payer)).findFirst()
                .ifPresent(p -> p.personalExpenses.merge(category, amount, Double::sum));
            Transaction t = new Transaction(payer, amount, category, Collections.singletonList(payer), true, description);
            transactions.add(t);
            personalArea.append(String.format("%s spent %.2f on %s (%s)\n", payer, amount, description, category));
            allTransactionsArea.append(String.format("%s spent %.2f on %s (%s)\n", payer, amount, description, category));
            personalAmountField.setText("");
            saveData();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Invalid amount: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (IllegalStateException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private boolean checkAndConfirmBudget(String personName, String category, double amountToCheck) {
        Person person = persons.stream().filter(p -> p.name.equals(personName)).findFirst().orElse(null);
        if (person != null && person.budgets.containsKey(category)) {
            double budget = person.budgets.get(category);
            double spent = (mode == 1 ? transactions.stream()
                .filter(t -> t.payer.equals(personName) && t.category.equals(category) && !t.isPersonal)
                .mapToDouble(t -> t.amount / t.paidFor.size()).sum() : person.personalExpenses.getOrDefault(category, 0.0));
            double newTotal = spent + amountToCheck;

            if (newTotal > budget) {
                int response = JOptionPane.showConfirmDialog(this,
                    String.format("%s will exceed the %s budget (Budget: %.2f, Spent: %.2f, New Total: %.2f).\nContinue?", 
                        personName, category, budget, spent, newTotal),
                    "Budget Exceeded",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.WARNING_MESSAGE);
                return response == JOptionPane.YES_OPTION;
            } else if (newTotal >= budget * 0.8) {
                JOptionPane.showMessageDialog(this,
                    String.format("Warning: %s is nearing the %s budget limit (80%% reached)", personName, category),
                    "Budget Alert",
                    JOptionPane.WARNING_MESSAGE);
            }
        }
        return true;
    }

    private void calculateAndShowSummary() {
        balanceArea.setText("Group Expenses/Bill Settlement:\n");
        summaryArea.setText("Personal Expenses Summary:\n");

        if (persons.isEmpty()) {
            balanceArea.append("No transactions to settle.\n");
            summaryArea.append("No personal expenses recorded.\n");
            return;
        }

        switch (mode) {
            case 1:
                Map<String, Double> netBalances = new HashMap<>();
                for (Person p : persons) netBalances.put(p.name, 0.0);
                for (Person debtor : persons) {
                    for (int creditorIndex = 0; creditorIndex < numPeople; creditorIndex++) {
                        double amountOwed = debtor.balances.getOrDefault(creditorIndex + 1, 0.0);
                        if (amountOwed > 0) {
                            String creditorName = persons.get(creditorIndex).name;
                            netBalances.put(creditorName, netBalances.get(creditorName) + amountOwed);
                            netBalances.put(debtor.name, netBalances.get(debtor.name) - amountOwed);
                        }
                    }
                }
                List<String> finalTransactions = new ArrayList<>();
                Map<String, Double> tempBalances = new HashMap<>(netBalances);
                List<Map.Entry<String, Double>> debtors = new ArrayList<>();
                List<Map.Entry<String, Double>> creditors = new ArrayList<>();
                for (Map.Entry<String, Double> entry : tempBalances.entrySet()) {
                    double balance = entry.getValue();
                    if (balance < -0.01) debtors.add(entry);
                    else if (balance > 0.01) creditors.add(entry);
                }
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
                            finalTransactions.add(String.format("%.2f to be paid to %s by %s\n", amount, creditorName, debtorName));
                            tempBalances.put(debtorName, tempBalances.get(debtorName) + amount);
                            tempBalances.put(creditorName, tempBalances.get(creditorName) - amount);
                            debt += amount;
                            credit -= amount;
                            if (credit < 0.01) creditorIterator.remove();
                            else creditor.setValue(credit);
                        }
                    }
                }
                if (finalTransactions.isEmpty()) balanceArea.append("All balances are settled!\n");
                else finalTransactions.forEach(balanceArea::append);
                break;

            case 2:
                balanceArea.append("Mode set to Individual Tracking - No group settlement needed.\n");
                break;
        }

        for (Person p : persons) {
            summaryArea.append("\n" + p.name + ":\n");
            double total = 0;
            for (String cat : categories) {
                double spent = p.personalExpenses.getOrDefault(cat, 0.0);
                double budget = p.budgets.getOrDefault(cat, 0.0);
                if (spent > 0 || budget > 0) {
                    summaryArea.append(String.format("  %s: Spent %.2f / Budget %.2f\n", cat, spent, budget));
                    total += spent;
                }
            }
            double groupSpent = transactions.stream()
                .filter(t -> t.payer.equals(p.name) && !t.isPersonal)
                .mapToDouble(t -> t.amount / t.paidFor.size()).sum();
            if (groupSpent > 0) summaryArea.append(String.format("  Group Expenses (Personal Share): %.2f\n", groupSpent));
            summaryArea.append(String.format("  Total Personal Expenses: %.2f\n", total));
        }
    }

    private void saveData() {
        try {
            File dir = new File(DATA_PATH);
            if (!dir.exists() && !dir.mkdirs()) {
                throw new IOException("Failed to create directory: " + DATA_PATH);
            }

            String prefix = (mode == 1) ? "bill_splitter_" : "individual_";
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_PATH + prefix + "persons.dat"))) {
                oos.writeObject(persons);
            }
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(DATA_PATH + prefix + "transactions.dat"))) {
                oos.writeObject(transactions);
            }
            try (PrintWriter pw = new PrintWriter(new FileWriter(DATA_PATH + prefix + "mode.txt"))) {
                pw.println(mode);
                pw.println(numPeople);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error saving data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadData() {
        try {
            String prefix = (mode == 1) ? "bill_splitter_" : "individual_";
            File personsFile = new File(DATA_PATH + prefix + "persons.dat");
            File transactionsFile = new File(DATA_PATH + prefix + "transactions.dat");
            File modeFile = new File(DATA_PATH + prefix + "mode.txt");

            if (personsFile.exists() && transactionsFile.exists() && modeFile.exists()) {
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(personsFile))) {
                    persons = (List<Person>) ois.readObject();
                }
                try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(transactionsFile))) {
                    transactions = (List<Transaction>) ois.readObject();
                }
                try (BufferedReader br = new BufferedReader(new FileReader(modeFile))) {
                    mode = Integer.parseInt(br.readLine());
                    numPeople = Integer.parseInt(br.readLine());
                }
            } else {
                persons.clear();
                transactions.clear();
            }
        } catch (IOException | ClassNotFoundException e) {
            JOptionPane.showMessageDialog(this, "Error loading data: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            persons.clear();
            transactions.clear();
        }
    }

    private void updateUIFromData() {
        payerCombo.removeAllItems();
        personsListModel.clear();
        transactionArea.setText("");
        allTransactionsArea.setText("");
        balanceArea.setText("");
        personalArea.setText("");
        summaryArea.setText("");

        for (Person p : persons) {
            payerCombo.addItem(p.name);
            personsListModel.addElement(p.name);
        }

        for (Transaction t : transactions) {
            if (t.isPersonal) {
                personalArea.append(String.format("%s spent %.2f on %s (%s)\n", t.payer, t.amount, t.description, t.category));
                allTransactionsArea.append(String.format("%s spent %.2f on %s (%s)\n", t.payer, t.amount, t.description, t.category));
            } else {
                StringBuilder transactionText = new StringBuilder(String.format("Transaction: %s paid %.2f for %s (%s)\n", t.payer, t.amount, t.category, t.description));
                transactionText.append("Split among: " + String.join(", ", t.paidFor) + "\n");
                double splitAmount = t.amount / t.paidFor.size();
                int payerIndex = persons.indexOf(persons.stream().filter(p -> p.name.equals(t.payer)).findFirst().orElse(null));
                for (String name : t.paidFor) {
                    int index = persons.indexOf(persons.stream().filter(p -> p.name.equals(name)).findFirst().orElse(null));
                    if (index != payerIndex) {
                        transactionText.append(String.format("%.2f to be paid to %s by %s\n", splitAmount, t.payer, name));
                    }
                }
                transactionText.append("\n");
                transactionArea.append(transactionText.toString());
                allTransactionsArea.append(transactionText.toString());
            }
        }
    }

    private void exportSummary() {
        calculateAndShowSummary();
        try {
            String prefix = (mode == 1) ? "bill_splitter_" : "individual_";
            try (PrintWriter pw = new PrintWriter(new FileWriter(DATA_PATH + prefix + "summary_export.txt"))) {
                pw.println("Expense Navigator Summary - " + new Date());
                pw.println("Mode: " + (mode == 1 ? "Bill Splitter" : "Individual Expense Tracker"));
                pw.println("\n" + balanceArea.getText());
                pw.println("\n" + summaryArea.getText());
                JOptionPane.showMessageDialog(this, "Summary exported to " + DATA_PATH + prefix + "summary_export.txt", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error exporting summary: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // UI Helper Methods
    private JPanel createStyledPanel(LayoutManager layout) {
        JPanel panel = new JPanel(layout);
        panel.setBackground(BACKGROUND_COLOR);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        return panel;
    }

    private JLabel createStyledLabel(String text, int style, int size, int alignment) {
        JLabel label = new JLabel(text);
        label.setFont(new Font("Roboto", style, size));
        label.setForeground(TEXT_COLOR);
        label.setHorizontalAlignment(alignment);
        return label;
    }

    private JTextField createStyledTextField(int columns) {
        JTextField field = new JTextField(columns);
        field.setFont(new Font("Roboto", Font.PLAIN, componentFontSize));
        field.setBackground(BACKGROUND_COLOR);
        field.setForeground(TEXT_COLOR);
        field.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(BORDER_COLOR, 1, true),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        return field;
    }

    private JTextArea createStyledTextArea(int rows, int cols) {
        JTextArea area = new JTextArea(rows, cols);
        area.setFont(new Font("Roboto", Font.PLAIN, componentFontSize));
        area.setBackground(BACKGROUND_COLOR);
        area.setForeground(TEXT_COLOR);
        area.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(BORDER_COLOR, 1, true),
            BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        area.setEditable(false);
        area.setLineWrap(true);
        area.setWrapStyleWord(true);
        return area;
    }

    private JButton createStyledButton(String text, Color bgColor) {
        JButton button = new JButton(text);
        button.setFont(new Font("Roboto", Font.BOLD, labelFontSize));
        button.setBackground(BUTTON_COLOR);
        button.setForeground(Color.WHITE);
        button.setOpaque(true);
        button.setBorderPainted(false);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createEmptyBorder(12, 25, 12, 25));
        button.setCursor(new Cursor(Cursor.HAND_CURSOR));
        return button;
    }

    private void styleComboBox(JComboBox<String> combo) {
        combo.setFont(new Font("Roboto", Font.PLAIN, componentFontSize));
        combo.setBackground(BACKGROUND_COLOR);
        combo.setForeground(TEXT_COLOR);
        combo.setBorder(BorderFactory.createLineBorder(BORDER_COLOR, 1, true));
    }

    private JLabel createIconLabel(String imagePath, String fallback, int size) {
        try {
            ImageIcon originalIcon = new ImageIcon(imagePath);
            Image scaledImage = originalIcon.getImage().getScaledInstance(size, size, Image.SCALE_SMOOTH);
            JLabel label = new JLabel(new ImageIcon(scaledImage));
            label.setForeground(BUTTON_COLOR);
            return label;
        } catch (Exception e) {
            JLabel label = new JLabel(fallback);
            label.setFont(new Font("Roboto", Font.PLAIN, size));
            label.setForeground(BUTTON_COLOR);
            System.out.println("Failed to load image: " + imagePath + " - " + e.getMessage());
            return label;
        }
    }

    private JLabel createIconLabel(String imagePath, String text, int style, int size, int imageSize, int alignment) {
        JLabel label;
        try {
            ImageIcon originalIcon = new ImageIcon(imagePath);
            Image scaledImage = originalIcon.getImage().getScaledInstance(imageSize, imageSize, Image.SCALE_SMOOTH);
            label = new JLabel(text, new ImageIcon(scaledImage), alignment);
        } catch (Exception e) {
            label = new JLabel(text + " 💸", alignment);
            System.out.println("Failed to load image: " + imagePath + " - " + e.getMessage());
        }
        label.setFont(new Font("Roboto", style, size));
        label.setForeground(BUTTON_COLOR);
        label.setIconTextGap(12);
        return label;
    }

    private String showCustomNameDialog(String prompt) {
        JPanel panel = new JPanel(new BorderLayout(20, 20));
        panel.setBackground(BACKGROUND_COLOR);
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel iconLabel = createIconLabel(PERSON_IMAGE_PATH, "👤", 50);
        JLabel messageLabel = new JLabel(prompt);
        messageLabel.setFont(new Font("Roboto", Font.PLAIN, labelFontSize));
        messageLabel.setForeground(TEXT_COLOR);
        JTextField nameField = createStyledTextField(15);

        panel.add(iconLabel, BorderLayout.WEST);
        panel.add(messageLabel, BorderLayout.NORTH);
        panel.add(nameField, BorderLayout.CENTER);

        int result = JOptionPane.showConfirmDialog(this, panel, "Enter Person's Name", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        return (result == JOptionPane.OK_OPTION) ? nameField.getText().trim() : null;
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception e) {
            e.printStackTrace();
        }
        SwingUtilities.invokeLater(() -> new ExpenseNavigatorGUI().setVisible(true));
    }
}