package lab7;

import java.util.List;
import java.util.stream.Collectors;

import javax.swing.DefaultListModel;

public class TaskController {

    private TaskManagerGUI view;
    private TaskModel model;

    public TaskController(TaskManagerGUI view, TaskModel model) {
        this.view = view;
        this.model = model;
    }

    public void addTask() {
        String taskName = view.getTaskName();
        String taskDescription = view.getTaskDescription();
        Task task = new Task(taskName, taskDescription);
        model.addTask(task);
        updateTaskList();
    }

    public void updateTask() {
        int selectedIndex = view.getTaskList().getSelectedIndex();
        if (selectedIndex != -1) {
            Task task = model.getTasks().get(selectedIndex);
            String newTaskName = view.getTaskName();
            String newTaskDescription = view.getTaskDescription();
            task.setName(newTaskName);
            task.setDescription(newTaskDescription);
            updateTaskList();
        }
    }

    public void deleteTask() {
        int selectedIndex = view.getTaskList().getSelectedIndex();
        if (selectedIndex != -1) {
            model.removeTask(selectedIndex);
            updateTaskList();
        }
    }

    public void selectTask() {
        int selectedIndex = view.getTaskList().getSelectedIndex();
        if (selectedIndex != -1) {
            Task task = model.getTasks().get(selectedIndex);
            view.setTaskName(task.getName());
            view.setTaskDescription(task.getDescription());
        }
    }

    private void updateTaskList() {
        List<Task> tasks = model.getTasks();
        DefaultListModel<Task> listModel = new DefaultListModel<>();
        for (Task task : tasks) {
            listModel.addElement(task);
        }
        view.setTaskListModel(listModel);
    }

    public void filterTasks(String filterCriteria) {
        List<Task> filteredTasks = model.getTasks().stream()
                .filter(task -> task.getName().toLowerCase().contains(filterCriteria.toLowerCase())
                        || task.getDescription().toLowerCase().contains(filterCriteria.toLowerCase()))
                .collect(Collectors.toList());

        DefaultListModel<Task> listModel = new DefaultListModel<>();
        for (Task task : filteredTasks) {
            listModel.addElement(task);
        }
        view.setTaskListModel(listModel);
    }
}