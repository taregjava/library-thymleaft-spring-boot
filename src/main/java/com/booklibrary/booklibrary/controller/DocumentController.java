package com.booklibrary.booklibrary.controller;

import com.booklibrary.booklibrary.entity.Book;
import com.booklibrary.booklibrary.entity.Document;
import com.booklibrary.booklibrary.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Controller
public class DocumentController {

    @Autowired
    private DocumentService service;

    @GetMapping("/")
    public String list(Model model) {
        List<Document> list = service.getAllBook();
        model.addAttribute("list", list);
        return "book";
    }
    @GetMapping("/admin")
    public String admin(Model model){
        Document document= new Document();
        model.addAttribute("document",document);

        List<Document> list = service.getAllBook();
        model.addAttribute("listfile", list);
        return "admin";
    }
    @PostMapping("/upload-file")
    public String fileUpload(@RequestParam("file") MultipartFile file, Model model) throws IOException {
        Document documet = new Document();
        String fileName = file.getOriginalFilename();
        documet.setProfilePicture(fileName);
        documet.setContent(file.getBytes());
        documet.setUploadTime(new Date());

        String result = fileName.substring(0, fileName.indexOf("."));
        documet.setName(result);
        documet.setSize(file.getSize());
        service.createBook(documet);
        model.addAttribute("success", "File Uploaded Successfully!!!");
        List<Document> list = service.getAllBook();
        model.addAttribute("listfile", list);
        return "admin";

    }
    @GetMapping("/download-file")
    public void downloadFile(@Param("id") Long id , Model model, HttpServletResponse response) throws IOException {
        Optional<Document> temp = service.findDocumentById(id);
        if(temp!=null) {
            Document document = temp.get();
            response.setContentType("application/octet-stream");
            String headerKey = "Content-Disposition";
            String headerValue = "attachment; filename = "+document.getProfilePicture();
            response.setHeader(headerKey, headerValue);
            ServletOutputStream outputStream = response.getOutputStream();
            outputStream.write(document.getContent());
            outputStream.close();
        }
    }

    @GetMapping("/image-file")
    public void showImage(@Param("id") Long id, HttpServletResponse response, Optional<Document> document)
            throws ServletException, IOException {

        document = service.findDocumentById(id);
        response.setContentType("image/jpeg, image/jpg, image/png, image/gif, image/pdf");
        response.getOutputStream().write(document.get().getContent());
        response.getOutputStream().close();
    }
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id") long id, Model model) {
        service.deleteById(id);
        return "redirect:/admin";
    }

   /*@GetMapping("/delete_book")
    public String handleDeleteUser(@RequestParam Long id) {
       User user = userRepository.findById(id)
        return "redirect:/admin";
    }*/

    @GetMapping("/files")
    public String getListFiles(Model model) {
        List<Document> list = service.getAllBook();
        model.addAttribute("listfile", list);
        return "files";
    }
}
