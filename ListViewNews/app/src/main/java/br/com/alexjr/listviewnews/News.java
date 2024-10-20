package br.com.alexjr.listviewnews;

public class News {
    private String title;
    private String description;
    private String newsDate;
    private int imageResId;
    private String fullText;
    private String author;

    public News(String title, String description, String newsDate, int imageResId, String fullText, String author) {
        this.title = title;
        this.description = description;
        this.newsDate = newsDate;
        this.imageResId = imageResId;
        this.fullText = fullText;
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getNewsDate() {
        return newsDate;
    }

    public int getImageResId() {
        return imageResId;
    }

    public String getFullText() {
        return fullText;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
