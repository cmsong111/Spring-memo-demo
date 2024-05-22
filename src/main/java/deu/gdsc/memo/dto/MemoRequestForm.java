package deu.gdsc.memo.dto;

public class MemoRequestForm {
    private String title;
    private String content;

    // Getters and Setters
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    // Constructor
    public MemoRequestForm(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public MemoRequestForm() {
    }

    // toString
    @Override
    public String toString() {
        return "MemeRequestForm{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
