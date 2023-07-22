package com.teste.demo.controller;

import com.teste.demo.service.UploadImageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.List;

@Controller
public class ControllerMcv {

    private static final String DIRECTORY = "/home/ubuntu/demo/src/main/resources/static/imgs-produtos";

    @GetMapping("/")
    public ModelAndView index() {
        return new ModelAndView("index");
    }
    @GetMapping("/***")
    public ModelAndView errors() {
        return new ModelAndView("redirect:/");
    }



    @GetMapping("/pegarImagem/{imagem}")
    @ResponseBody
    public byte[] retornarImagem(@PathVariable String imagem) throws IOException {
        File imagemArquivo = new File(DIRECTORY + File.separator + imagem);
        if (imagem != null || imagem.trim().length() > 0) {
            return Files.readAllBytes(imagemArquivo.toPath());
        }
        return null;
    }

    @PostMapping("/salvarImagem")
    public ModelAndView salvarImagem(@RequestParam("file") List<MultipartFile> files) {
        if (!files.isEmpty()) {
            for (MultipartFile fileImagem : files) {
                UploadImageService.uploadImage(fileImagem, "1");
            }
        }
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/deletarImagem/{imagem}")
    public void deletarImagem(@PathVariable String imagem) {
        if (!imagem.isEmpty()) {
            UploadImageService.deleteImage(imagem);
        }
    }


}
