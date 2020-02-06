package com.rahul.mapstruct.dto;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class BookDTO implements Serializable {
    
    private UUID id;
    
    @NotNull
    private String name;
    
    @NotNull
    private String author;
    
    @NotNull
    private LocalDateTime publishedDate;
    
    private UUID libraryId;
    
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
    
    public String getAuthor() {
        return author;
    }
    
    public void setAuthor(final String author) {
        this.author = author;
    }
    
    public LocalDateTime getPublishedDate() {
        return publishedDate;
    }
    
    public void setPublishedDate(final LocalDateTime publishedDate) {
        this.publishedDate = publishedDate;
    }
    
    public UUID getLibraryId() {
        return libraryId;
    }
    
    public void setLibraryId(final UUID libraryId) {
        this.libraryId = libraryId;
    }
    
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        BookDTO bookDTO = (BookDTO) o;
        return Objects.equals(id, bookDTO.id) &&
                Objects.equals(name, bookDTO.name) &&
                Objects.equals(author, bookDTO.author) &&
                Objects.equals(publishedDate, bookDTO.publishedDate) &&
                Objects.equals(libraryId, bookDTO.libraryId);
    }
    
    @Override
    public int hashCode() {
        return Objects.hash(id, name, author, publishedDate, libraryId);
    }
    
    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BookDTO{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", author='").append(author).append('\'');
        sb.append(", publishedDate=").append(publishedDate);
        sb.append(", libraryId=").append(libraryId);
        sb.append('}');
        return sb.toString();
    }
}
