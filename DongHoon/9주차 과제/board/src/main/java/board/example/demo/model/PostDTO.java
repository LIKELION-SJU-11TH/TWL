package board.example.demo.model;

public class PostDTO {
    private Long member_id;
    private String title;
    private String content;

    public Long getMember_id() {
        return member_id;
    }

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
}
