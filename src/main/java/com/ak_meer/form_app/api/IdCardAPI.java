package com.ak_meer.form_app.api;

import com.ak_meer.form_app.model.IdCard;
import com.ak_meer.form_app.repo.IdCardRepository;
import com.ak_meer.form_app.service.IdCardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @PostMapping("/validate-qr-code")
    public ResponseEntity<Map<String, Boolean>> validateQrCode(@RequestBody Map<String, String> request) {
        String qrCodeData = request.get("data");
        boolean isValid = idCardService.validateQrCode(qrCodeData);

        Map<String, Boolean> response = new HashMap<>();
        response.put("isValid", isValid);

        return ResponseEntity.ok(response);
    }


}
