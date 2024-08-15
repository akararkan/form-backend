package com.ak_meer.form_app.api;

import com.ak_meer.form_app.model.IdCard;
import com.ak_meer.form_app.service.IdCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/id-card")
@RequiredArgsConstructor
public class IdCardAPI {
    private final IdCardService idCardService;
    @PostMapping("/save")
    public IdCard saveIdCard(@RequestBody IdCard idCard){
        return idCardService.saveIdCard(idCard);
    }
    @GetMapping("/getAll")
    public List<IdCard> getAllIdCards(){
        return idCardService.getAllIdCard();
    }
    @PutMapping("/update/{id}")
    public IdCard updateIdCard(@PathVariable Long id, IdCard idCard) throws Exception {
        return idCardService.updateIdCard(id  , idCard);
    }
    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id){
        idCardService.deleteIdCardById(id);
    }
}
