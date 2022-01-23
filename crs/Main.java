import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Book> bookList = setBook();

        //вывод по количеству страниц снизу вверх
        bookList.stream().sorted(Comparator.comparing(Book::getPages)).forEach(System.out::println);

        System.out.println();
        //вывод по количеству страниц сверху вниз
        bookList.stream().sorted(Comparator.comparing(Book::getPages).reversed()).forEach(System.out::println);

        System.out.println();
        //фильтр по рейтингу
        bookList.stream().filter(book -> book.getRating() > 8).forEach(System.out::println);

        System.out.println();
        //фильтр по рейтингу и группировка
        Map<Integer, List<Book>> groupBookByRating = bookList.stream().collect(Collectors.
                groupingBy(Book::getRating));
        groupBookByRating.forEach((rating, book) -> {
            System.out.println(rating);
            book.forEach(System.out::println);
        });

        System.out.println();
        //минимальный объект
        bookList.stream().min(Comparator.comparing(Book::getRating)).ifPresent(System.out::println);

        System.out.println();
        //максимальный объект
        bookList.stream().max(Comparator.comparing(Book::getRating)).ifPresent(System.out::println);

        System.out.println();

        //вывод на экран результат проверки методами allMatch, anyMatch, noneMatch
        System.out.println(bookList.stream().allMatch(book -> book.getRating() == 10));
        System.out.println(bookList.stream().anyMatch(book -> book.getBookName().equals("истории")));
        System.out.println(bookList.stream().noneMatch(book -> book.getBookName().equals("no book")));
    }

    private static List<Book> setBook() {
        return Arrays.asList(new Book("учим JAVA", 321, 10),
                new Book("истории", 100, 7),
                new Book("сказки", 149, 9),
                new Book("раскраски", 30, 10));
    }
}
