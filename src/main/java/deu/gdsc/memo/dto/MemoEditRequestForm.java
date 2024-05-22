package deu.gdsc.memo.dto;

public class MemoEditRequestForm {
    private Long id;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    // Constructor
    public MemoEditRequestForm(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    public MemoEditRequestForm() {
    }

    // toString
    @Override
    public String toString() {
        return "MemeEditRequestForm{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
