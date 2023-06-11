package com.learnings.portfolio.controller;

import com.learnings.portfolio.dto.DetailDTO;
import com.learnings.portfolio.dto.ModalDTO;
import com.learnings.portfolio.repository.ModalRepository;
import com.learnings.portfolio.repository.PersonalDetailsRepository;
import com.learnings.portfolio.service.PortfolioService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private PersonalDetailsRepository pdRepo;

    @Autowired
    private ModalRepository modalRepo;

    @Autowired
    private PortfolioService portfolioService;

    @GetMapping
    public String getWelcomePage(Model m){
        //DetailDTO user = getUserDTO();
        m.addAttribute("user", portfolioService.getUserDetails());
        ArrayList<ModalDTO> modalDTOS = new ArrayList<>();
        modalRepo.findAll().forEach(dao -> {
            ModalDTO modatDTO = getModatDTO();
            modatDTO.setName(dao.getImageName());
            modalDTOS.add(modatDTO);
        });
        modalDTOS.add(getModatDTO());
        ModalDTO modatDTO = getModatDTO();
        modatDTO.setTags("Academic education");
        modalDTOS.add(modatDTO);
        List<ModalDTO> allModals = portfolioService.getAllModals();
        m.addAttribute("modals", allModals);
        return "index";
    }

    public DetailDTO getUserDTO(){
        DetailDTO user = new DetailDTO();
        user.setName("Aviral Aman");
        user.setRole("Web Application Developer | Java | Spring Boot");
        user.setDesignation("Senior Software Engineer");
        user.setEmail("aviralaman25@gmail.com");
        return user;
    }

    public ModalDTO getModatDTO(){
        ModalDTO dto = new ModalDTO();
        dto.setName("TechnePlus PVT LTD");
        dto.setDescription("Lorem Ipsum has been the  unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries,");
        dto.setEndDate("End Date");
        dto.setImageName("03.jpg");
        dto.setStartDate("Start Date");
        dto.setExtraDetails("Extra Details");
        dto.setTags("Work Experience");
        dto.setLink("Techneplus.com");
        return dto;
    }

    @PostMapping("/save")
    public String saveRequests(String email, String message){
        System.out.println(email);
        System.out.println(message);
        return "index";
    }
    @GetMapping("/save/{email}/{message}")
    public String saveRequestss(String email, String message){
        System.out.println(email);
        System.out.println(message);
        return "index";
    }


}
