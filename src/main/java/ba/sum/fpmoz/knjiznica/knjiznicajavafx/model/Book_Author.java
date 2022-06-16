package ba.sum.fpmoz.knjiznica.knjiznicajavafx.model;

public class Book_Author extends Table{
    @Entity(type = "INTEGER", size = 32, primary = true)
    int id;

    @ForeignKey(table = "Book", attribute = "id")
    @Entity(type = "INTEGER", size = 32)
    int book_id;

    @ForeignKey(table = "Author", attribute = "id")
    @Entity(type = "INTEGER", size = 32)
    int author_id;

    public int getId() {
        return id;
    }

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getAuthor_id() {
        return author_id;
    }

    public void setAuthor_id(int author_id) {
        this.author_id = author_id;
    }
}
