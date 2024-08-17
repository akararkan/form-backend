package com.ak_meer.form_app.service;

import com.ak_meer.form_app.model.IdCard;
import com.ak_meer.form_app.repo.IdCardRepository;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class IdCardService {
    private final IdCardRepository idCardRepository;

    public IdCard saveIdCard(IdCard idCard) {
        // Generate a unique token for the ID card

        // Build the IdCard with the unique token
        IdCard newIdCard = IdCard.builder()
                .id(idCard.getId())
                .fullname(idCard.getFullname())
                .age(idCard.getAge())
                .city(idCard.getCity())
                .department(idCard.getDepartment())
                .uniqueToken(idCard.getUniqueToken()) // Save the token
                .build();

        // Save the IdCard entity
        idCardRepository.save(newIdCard);
        return newIdCard;
    }

    public List<IdCard> getAllIdCard(){
      return  idCardRepository.findAll();
    }

    public IdCard updateIdCard(Long id, IdCard idCardDetails) throws Exception {
        // Find the existing IdCard by ID
        Optional<IdCard> searchIdCard = idCardRepository.findById(id);

        if (searchIdCard.isPresent()) {
            IdCard existingIdCard = searchIdCard.get();

            // Update the fields with the new data
            existingIdCard.setFullname(idCardDetails.getFullname());
            existingIdCard.setCity(idCardDetails.getCity());
            existingIdCard.setAge(idCardDetails.getAge());
            existingIdCard.setDepartment(idCardDetails.getDepartment());

            // Save the updated IdCard to the database
            return idCardRepository.save(existingIdCard);
        } else {
            throw new Exception("IdCard not found with id: " + id);
        }
    }

    public void deleteIdCardById(Long id){
         idCardRepository.deleteById(id);
    }

    public boolean validateQrCode(String qrCodeData) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            JsonNode jsonNode = objectMapper.readTree(qrCodeData);

            String uniqueToken = jsonNode.get("uniqueToken").asText();

            // Check if an IdCard with this uniqueToken exists in the database
            Optional<IdCard> idCard = idCardRepository.findByUniqueToken(uniqueToken);

            return idCard.isPresent();
        } catch (Exception e) {
            // If there's any error parsing the JSON or finding the IdCard, consider it invalid
            return false;
        }
    }





}
