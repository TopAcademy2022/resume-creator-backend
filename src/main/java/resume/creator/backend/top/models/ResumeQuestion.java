package resume.creator.backend.top.models;

public class ResumeQuestion {
    public String Text;

    public String FieldType;

    public ResumeQuestion(String text, String fieldType) {
        this.Text = text;
        this.FieldType = fieldType;
    }
}
