//5.	Book: id, Назва, Автор, Видавництво, Рік видання, Кількість сторінок, Ціна.
//        Скласти масив об'єктів. Вивести:
//        a) список книг заданого автора;
//        b) список книг, що видані заданим видавництвом;
//        c) список книг, що випущені після заданого року.
package lab2.main;
import lab2.Book.Book;
import  java.util.Scanner;
public class Main {
    public static void exactauthor(Book[] books,String author_name){
        int count=0;
        for(int j=0;j< books.length;j++){
            if((books[j].getAuthor().toLowerCase()).equals(author_name.toLowerCase())){
                System.out.println(books[j]);
            count++;}
        }
        if(count==0){System.out.println("There are no books of that author");}
    }
    public static void exactpublishing_house(Book[] books,String publishing){
        int kst=0;
        for(int j=0;j< books.length;j++){
            if((books[j].getPublishing().toLowerCase()).equals(publishing.toLowerCase())){
                System.out.println(books[j]);
            kst++;}
        }
        if(kst==0){System.out.println("There are no books from that publishing house");}
    }
    public static void afteryear(Book[] books,int years) {
        int count=0;
        for (int k = 0; k < books.length; k++) {
            if (books[k].getYear()>years){
                System.out.println(books[k]);
            count++;}
        }
        if(count==0){System.out.println("There are no books,that was published after this year");}
    }
    public static void main(String[] args) {
        Scanner scanStr = new Scanner(System.in);
        Scanner scanint = new Scanner(System.in);
        Scanner scanDouble = new Scanner(System.in);
        System.out.print("How many objects do you want to enter: ");
        int kst= scanint.nextInt();
        Book[] books= new Book[kst];
        for(int i=0;i<kst;i++){
            System.out.print("Enter Id: ");
            int ID= scanint.nextInt();
            System.out.print("Enter Name of the book: ");
            String name= scanStr.nextLine();
            System.out.print("Enter author of the book: ");
            String author= scanStr.nextLine();
            System.out.print("Enter publishing house: ");
            String publish_h= scanStr.nextLine();
            System.out.print("Enter year of publishing: ");
            int year= scanint.nextInt();
            System.out.print("Enter amount of pages in the book: ");
            int pages= scanint.nextInt();
            System.out.print("Enter price of the book: ");
            double pricing= scanDouble.nextDouble();
            books[i]=new Book(ID,name,author,publish_h,year,pages,pricing);
        }
        System.out.print("Enter the author you want to find: ");
        String  author_name= scanStr.next();
        exactauthor(books,author_name);
        System.out.print("You want to find books, that was published after year: ");
        int years= scanint.nextInt();
        afteryear(books,years);
        System.out.print("Book from which publish house you are looking for: ");
        String  publishing= scanStr.next();
        exactpublishing_house(books,publishing);
    }
}