package org.example.onlinebookstore.cart;


import org.example.onlinebookstore.book.Book;
import org.example.onlinebookstore.book.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

@RestController
public class CartController {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    CartRepository cartRepository;

    @PostMapping("/add-to-cart")
    public RedirectView addToCart(@RequestParam("bookid") int bookid) {
        addBookToCart(bookid);
        return new RedirectView("/books");
    }

    public void addBookToCart(int bookid) {

        Book book = bookRepository.findById(bookid)
                .orElseThrow(()-> new IllegalArgumentException("Invalid book id"+bookid));

//        Cart cart=cartRepository.findByUserId();
//        cart.setBooks(new ArrayList<>(Arrays.asList(book)));
//        cartRepository.save(cart);

    }
}
