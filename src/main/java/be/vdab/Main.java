package be.vdab;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class Main {
    private static JpaBookRepository bookRepository;

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Books");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        entityManager.getTransaction().begin();

        bookRepository = new JpaBookRepository(entityManager);
        printAllBooks();

        entityManager.getTransaction().commit();
        entityManager.close();
        entityManagerFactory.close();
    }

    private static void printAllBooks() {
        List<Book> books = bookRepository.findAllBooks();
        for (Book book : books) {
            System.out.println(book);
        }
    }
}
