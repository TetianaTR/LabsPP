//5.	Book: id, Назва, Автор, Видавництво, Рік видання, Кількість сторінок, Ціна.
//        Скласти масив об'єктів. Вивести:
//        a) список книг заданого автора;
//        b) список книг, що видані заданим видавництвом;
//        c) список книг, що випущені після заданого року.
package lab2.Book;
public class Book {
    private int id;
    private String name;
    private String author;
    private String publishing;
    private int year;
    private int pages;
    private double price;
    public Book(int id_b, String name_a, String author_n, String publish_h, int year_b, int pages_b, double price_b){
        this.id=id_b;
        this.name=name_a;
        this.author=author_n;
        this.publishing=publish_h;
        this.year=year_b;
        this.pages=pages_b;
        this.price=price_b;
    }

    public void setAuthor(String author) { this.author = author; }
    public void setName(String name) { this.name = name; }
    public void setId(int id) {this.id = id;}
    public void setPages(int pages){this.pages=pages;}
    public void setPrice(double price) { this.price = price;}
    public void setPublishing(String publishing) { this.publishing = publishing;}

    public String getPublishing() { return publishing; }
    public String getAuthor() { return author;  }
    public int getYear() {return year; }
    @Override
    public String toString() {
        return "Id - " + id +"  | "+
                "Name - " + name +"  | "+
                "Author - " + author +"  | "+
                "Publish house - " + publishing +"  | "+
                "Year - " + year +"  | "+
                "Pages - " + pages +"  | "+
                "Price - " + price;
    }
}
