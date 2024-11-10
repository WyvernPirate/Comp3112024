package lab7;

import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.table.AbstractTableModel;
import java.util.List;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class TaskModel {

    private List<Task> tasks;
    private List<Task> undoStack;
    private List<Task> redoStack;

    public TaskModel() {
        tasks = new ArrayList<>();
        undoStack = new ArrayList<>();
        redoStack = new ArrayList<>();
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void addTask(Task task) {
        tasks.add(task);
        undoStack.add(new Task(task.getTitle(), task.getPriority(), task.getDueDate(), task.getStatus()));
        redoStack.clear();
    }

    public void updateTask(int index, Task updatedTask) {
        undoStack.add(new Task(tasks.get(index).getTitle(), tasks.get(index).getPriority(),
                tasks.get(index).getDueDate(), tasks.get(index).getStatus()));
        redoStack.clear();
        tasks.set(index, updatedTask);
    }

    public void deleteTask(int index) {
        undoStack.add(new Task(tasks.get(index).getTitle(), tasks.get(index).getPriority(),
                tasks.get(index).getDueDate(), tasks.get(index).getStatus()));
        redoStack.clear();
        tasks.remove(index);
    }

    public void undo() {
        if (!undoStack.isEmpty()) {
            Task lastTask = undoStack.remove(undoStack.size() - 1);
            redoStack.add(lastTask);
            tasks.remove(lastTask);
        }
    }

    public void redo() {
        if (!redoStack.isEmpty()) {
            Task task = redoStack.remove(redoStack.size() - 1);
            tasks.add(task);
            undoStack.add(task);
        }
    }

    public List<Task> filterTasks(String criteria) {
        List<Task> filteredTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getPriority().equalsIgnoreCase(criteria)
                    || task.getDueDate().equalsIgnoreCase(criteria)
                    || task.getStatus().equalsIgnoreCase(criteria)) {
                filteredTasks.add(task);
            }
        }
        return filteredTasks;
    }
}

class Task {

    private String title;
    private String priority;
    private String dueDate;
    private String status;

    public Task(String title, String priority, String dueDate, String status) {
        this.title = title;
        this.priority = priority;
        this.dueDate = dueDate;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public String getPriority() {
        return priority;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getStatus() {
        return status;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null || getClass() != obj.getClass())
            return false;
        Task task = (Task) obj;
        return title.equals(task.title) && priority.equals(task.priority) && dueDate.equals(task.dueDate)
                && status.equals(task.status);
    }
}

class TaskView extends JFrame {

    private JTextField titleField;
    private JTextField priorityField;
    private JTextField dueDateField;
    private JTextField statusField;
    private JButton addButton;
    private JButton updateButton;
    private JButton deleteButton;
    private JButton undoButton;
    private JButton redoButton;
    JTable taskTable;
    private TaskTableModel taskTableModel;
    private JComboBox<String> priorityComboBox;

    public TaskView() {
        setTitle("Task Manager");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create top panel for task details
        JPanel topPanel = new JPanel(new GridLayout(2, 3));
        topPanel.add(new JLabel("Title:"));
        titleField = new JTextField();
        topPanel.add(titleField);

        topPanel.add(new JLabel("Priority:"));
        priorityComboBox = new JComboBox<>(new String[] { "High", "Medium", "Low" });
        topPanel.add(priorityComboBox);

        topPanel.add(new JLabel("Due Date:"));
        dueDateField = new JTextField();
        topPanel.add(dueDateField);

        topPanel.add(new JLabel("Status:"));
        statusField = new JTextField();
        topPanel.add(statusField);

        // Create center panel for task table
        taskTableModel = new TaskTableModel();
        taskTable = new JTable(taskTableModel);
        JScrollPane scrollPane = new JScrollPane(taskTable);

        // Create bottom panel for buttons
        JPanel bottomPanel = new JPanel();
        addButton = new JButton("Add Task");
        updateButton = new JButton("Update Task");
        deleteButton = new JButton("Delete Task");
        undoButton = new JButton("Undo");
        redoButton = new JButton("Redo");

        bottomPanel.add(addButton);
        bottomPanel.add(updateButton);
        bottomPanel.add(deleteButton);
        bottomPanel.add(undoButton);
        bottomPanel.add(redoButton);

        // Add panels to the frame
        add(topPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

    }

    public String getTitleInput() {
        return titleField.getText();
    }

    public String getPriorityInput() {
        return (String) priorityComboBox.getSelectedItem();
    }

    public String getDueDateInput() {
        return dueDateField.getText();
    }

    public String getStatusInput() {
        return statusField.getText();
    }

    public void addTaskActionListener(ActionListener listener) {
        addButton.addActionListener(listener);
    }

    public void updateTaskActionListener(ActionListener listener) {
        updateButton.addActionListener(listener);
    }

    public void deleteTaskActionListener(ActionListener listener) {
        deleteButton.addActionListener(listener);
    }

    public void undoActionListener(ActionListener listener) {
        undoButton.addActionListener(listener);
    }

    public void redoActionListener(ActionListener listener) {
        redoButton.addActionListener(listener);
    }

    public void setTaskList(java.util.List<Task> tasks) {
        taskTableModel.setTasks(tasks);
    }
}

class TaskTableModel extends AbstractTableModel {

    private List<Task> tasks;
    private final String[] columnNames = { "Title", "Priority", "Due Date", "Status" };

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
        fireTableDataChanged();
    }

    @Override
    public int getRowCount() {
        return tasks != null ? tasks.size() : 0;
    }

    @Override
    public int getColumnCount() {
        return columnNames.length;
    }

    @Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Task task = tasks.get(rowIndex);
        switch (columnIndex) {
            case 0:
                return task.getTitle();
            case 1:
                return task.getPriority();
            case 2:
                return task.getDueDate();
            case 3:
                return task.getStatus();
        }
        return null;
    }
}

class TaskController {

    private TaskModel model;
    private TaskView view;

    public TaskController(TaskModel model, TaskView view) {
        this.model = model;
        this.view = view;

        view.addTaskActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String title = view.getTitleInput();
                String priority = view.getPriorityInput();
                String dueDate = view.getDueDateInput();
                String status = view.getStatusInput();
                Task task = new Task(title, priority, dueDate, status);
                model.addTask(task);
                updateTaskView();
            }
        });

        view.updateTaskActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = view.taskTable.getSelectedRow();
                if (selectedRow >= 0) {
                    String title = view.getTitleInput();
                    String priority = view.getPriorityInput();
                    String dueDate = view.getDueDateInput();
                    String status = view.getStatusInput();
                    Task updatedTask = new Task(title, priority, dueDate, status);
                    model.updateTask(selectedRow, updatedTask);
                    updateTaskView();
                }
            }
        });

        view.deleteTaskActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = view.taskTable.getSelectedRow();
                if (selectedRow >= 0) {
                    model.deleteTask(selectedRow);
                    updateTaskView();
                }
            }
        });

        view.undoActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.undo();
                updateTaskView();
            }
        });

        view.redoActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                model.redo();
                updateTaskView();
            }
        });
    }

    private void updateTaskView() {
        List<Task> tasks = model.getTasks();
        view.setTaskList(tasks);
    }
}