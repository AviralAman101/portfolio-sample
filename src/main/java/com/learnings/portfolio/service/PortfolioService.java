package com.learnings.portfolio.service;

import com.learnings.portfolio.dto.DetailDTO;
import com.learnings.portfolio.dto.ModalDTO;
import com.learnings.portfolio.entity.AcademicExperience;
import com.learnings.portfolio.entity.Message;
import com.learnings.portfolio.entity.Modal;
import com.learnings.portfolio.entity.PersonalDetails;
import com.learnings.portfolio.entity.WorkExperience;
import com.learnings.portfolio.repository.AcademicExperienceRepository;
import com.learnings.portfolio.repository.MessageRepository;
import com.learnings.portfolio.repository.ModalRepository;
import com.learnings.portfolio.repository.PersonalDetailsRepository;
import com.learnings.portfolio.repository.WorkExperienceRepository;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PortfolioService {

    @Autowired
    private ModalRepository modalRepo;

    @Autowired
    private AcademicExperienceRepository aExpRepo;

    @Autowired
    private WorkExperienceRepository wExpRepo;

    @Autowired
    private PersonalDetailsRepository pdRepo;

    @Autowired
    private MessageRepository msgRep;

    public List<ModalDTO> getAllModals(){
        ArrayList<ModalDTO> modalDTOS = new ArrayList<>();
        Iterable<Modal> allModals = modalRepo.findAll();
        allModals.forEach(modal -> {
            if(modal.getContentType() == 1){
                Optional<WorkExperience> wExpData = wExpRepo.findById(Integer.parseInt(modal.getContentId()));
                if(wExpData.isPresent())
                    modalDTOS.add(mapWorkExperience(modal, wExpData.get()));
            } else {
                Optional<AcademicExperience> aExpData = aExpRepo.findById(Integer.parseInt(modal.getContentId()));
                if(aExpData.isPresent())
                    modalDTOS.add(mapAcademicExperience(modal, aExpData.get()));
            }
        });
        return modalDTOS;
    }

    public ModalDTO mapWorkExperience(Modal modal, WorkExperience wExp){
        ModalDTO modalDTO = new ModalDTO();
        modalDTO.setName(wExp.getCompanyName());
        modalDTO.setDescription(modal.getDescription());
        modalDTO.setEndDate(wExp.getEndDate().toString());
        modalDTO.setStartDate(wExp.getStartDate().toString());
        modalDTO.setTags(modal.getTags());
        modalDTO.setImageName("./images/" + modal.getImageName());
        modalDTO.setLink(modal.getLink());
        modalDTO.setExtraDetails(modal.getExtraDetails());
        return modalDTO;

    }
    public ModalDTO mapAcademicExperience(Modal modal, AcademicExperience aExp){
        ModalDTO modalDTO = new ModalDTO();
        modalDTO.setName(aExp.getName());
        modalDTO.setDescription(modal.getDescription());
        modalDTO.setEndDate(aExp.getEndDate().toString());
        modalDTO.setStartDate(aExp.getStartDate().toString());
        modalDTO.setTags(modal.getTags());
        modalDTO.setImageName("./images/" + modal.getImageName());
        modalDTO.setLink(modal.getLink());
        modalDTO.setExtraDetails(modal.getExtraDetails());

        return modalDTO;

    }

    public DetailDTO getUserDetails(){
        Optional<PersonalDetails> byId = pdRepo.findById(1);
        return mapToDetailDTO(byId.get());
    }

    public DetailDTO mapToDetailDTO(PersonalDetails pdDAO){
        DetailDTO detailDTO = new DetailDTO();
        detailDTO.setName(pdDAO.getName());
        detailDTO.setDesignation(pdDAO.getDesignation());
        detailDTO.setEmail(pdDAO.getEmailId());
        detailDTO.setImageName("./images/" + pdDAO.getProfilePictureName());
        return detailDTO;
    }

    public void saveMessage(String email, String message){
        Message messageDTO = new Message();
        messageDTO.setEmail(email);
        messageDTO.setMesage(message);
        messageDTO.setCreateDate(new Date(System.currentTimeMillis()));
        msgRep.save(messageDTO);
    }
}
