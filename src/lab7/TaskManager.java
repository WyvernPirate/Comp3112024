package lab7;

public class TaskManager {
    public static void main(String[] args) {
        try {
            TaskModel model = new TaskModel();
            TaskView view = new TaskView();
            TaskController controller = new TaskController(model, view);

            view.setVisible(true);
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}