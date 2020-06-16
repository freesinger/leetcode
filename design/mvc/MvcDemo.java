package mvc;

public class MvcDemo {
    public static void main(String[] args) {
        Student model = constructStudentRecord();
        StudentController studentController = new StudentController(model, new StudentView());

        studentController.updateView();
        studentController.setStudentName("Ann");
        studentController.updateView();
        studentController.setStudentId("1105");
        studentController.updateView();
    }

    private static Student constructStudentRecord() {
        Student student = new Student("Shane", "1207");
        return student;
    }
}
