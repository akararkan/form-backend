package com.ak_meer.form_app.service;

import com.ak_meer.form_app.model.IdCard;
import com.ak_meer.form_app.repo.IdCardRepository;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class IdCardService {
    private final IdCardRepository idCardRepository;

    public IdCard saveIdCard(IdCard idCard){
        IdCard newIdCard = IdCard.builder()
                .id(idCard.getId())
                .fullname(idCard.getFullname())
                .age(idCard.getAge())
                .city(idCard.getCity())
                .department(idCard.getDepartment())
                .build();
        return idCardRepository.save(newIdCard);
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


}
