import java.util.*;

public class BookBuddy {
    private ArrayList<String>bookshelf;
    public BookBuddy(){
        bookshelf=new ArrayList<>();
    }
    public void addBook(String title,String author){
        bookshelf.add(title+"-"+author);
    }
//    public void sortBoook(){
//        Collections.sort(bookshelf);
//    }
    public void searchBook_by_author(String author){
        System.out.println(author);
        for(String x:bookshelf){
            String[] str=x.split("-");
            if(str.length==2&&str[1].equals(author)){
                System.out.println(x);
            }
        }
    }

    public void sortBoook() {
        for (int i = 0; i < bookshelf.size() - 1; i++) {
            for (int j = 0; j < bookshelf.size() - i - 1; j++) {
                if (bookshelf.get(j).compareTo(bookshelf.get(j + 1)) > 0) {
                    String temp = bookshelf.get(j);
                    bookshelf.set(j, bookshelf.get(j + 1));
                    bookshelf.set(j + 1, temp);
                }
            }
        }
    }
    public static void main(String[] args) {
BookBuddy myshelf=new BookBuddy();
myshelf.addBook("Romio&juliet","shakesphire");
myshelf.addBook("anandamath","saratchandra");
myshelf.sortBoook();
myshelf.searchBook_by_author("saratchandra");

    }
}