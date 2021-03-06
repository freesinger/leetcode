package mvc;

public class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }

    public String getStudentName() {
        return model.getName();
    }

    public void setStudentName(String name) {
        model.setName(name);
    }

    public String getStudentId() {
        return model.getIdNo();
    }

    public void setStudentId(String id) {
        model.setIdNo(id);
    }

    public void updateView() {
        view.printStudentsInfo(model.getName(), model.getIdNo());
    }
}
