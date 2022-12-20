package jpabook.jpashop.domain;

import javax.persistence.Entity;

@Entity
public class Book extends Item{
    private String authur;
    private String isbn;

    public String getAuthur() {
        return authur;
    }

    public void setAuthur(String authur) {
        this.authur = authur;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
