package mvc;


import lombok.Data;

/**
 * Model
 */
@Data
public class Student {
    private String idNo;
    private String name;

    public Student() {
    }

    public Student(String name, String idNo) {
        this.name = name;
        this.idNo = idNo;
    }
}
