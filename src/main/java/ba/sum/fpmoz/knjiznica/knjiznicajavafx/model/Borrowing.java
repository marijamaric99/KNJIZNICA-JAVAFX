package ba.sum.fpmoz.knjiznica.knjiznicajavafx.model;

public class Borrowing extends Table{
    @Entity(type = "INTEGER", size = 50, primary = true)
    int id;

    @Entity(type="DATETIME", size=6, isnull = false)
    String borrow_date;

    @Entity(type = "DATETIME", size=6, isnull = false)
    String return_date;

    @ForeignKey(table = "Book", attribute = "id")
    @Entity(type = "INTEGER", size = 32)
    int book_id;

    @ForeignKey(table = "User", attribute = "id")
    @Entity(type = "INTEGER", size = 32)
    int user_id;

    public int getId() {
        return id;
    }


    public String getBorrow_date() {
        return borrow_date;
    }

    public void setBorrow_date(String borrow_date) {
        this.borrow_date = borrow_date;
    }

    public String getReturn_date() {
        return return_date;
    }

    public void setReturn_date(String return_date) {this.return_date = return_date;}

    public int getBook_id() {
        return book_id;
    }

    public void setBook_id(int book_id) {
        this.book_id = book_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
