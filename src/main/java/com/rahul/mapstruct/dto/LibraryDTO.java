package com.rahul.mapstruct.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

public class LibraryDTO implements Serializable {
    
    private UUID id;
    
    @NotNull
    private String name;
    
    @NotNull
    private List<BookDTO> bookDTOs = new ArrayList<>();
    
    public UUID getId() {
        return id;
    }
    
    public void setId(final UUID id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(final String name) {
        this.name = name;
    }
    
    public List<BookDTO> getBookDTOs() {
        return bookDTOs;
    }
    
    public void setBookDTOs(final List<BookDTO> bookDTOs) {
        this.bookDTOs = bookDTOs;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LibraryDTO that = (LibraryDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(bookDTOs, that.bookDTOs);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, name, bookDTOs);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("LibraryDTO{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", bookDTOs=").append(bookDTOs);
        sb.append('}');
        return sb.toString();
    }
}