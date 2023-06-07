package com.booklibrary.booklibrary.service;

import com.booklibrary.booklibrary.entity.Document;
import com.booklibrary.booklibrary.repository.DocumentRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.List;
import java.util.Optional;

@Service
public class DocumentService {

    @Autowired
    private DocumentRepository repository;
    public Document createBook(Document document) {
        return repository.save(document);

    }
    public List<Document> getAllBook(){
        return repository.findAll();

    }

    public Optional<Document> findDocumentById(long id){
        return repository.findById(id);
    }

    public void deleteById(long id){
        Document document = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book Id:" + id));
        repository.delete(document);
    }

    public void delete(long fileId) {
      repository.deleteById(fileId);
    }

}


