package com.greenart.book_admin.api;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greenart.book_admin.data.AdminInfoVO;
import com.greenart.book_admin.mapper.AdminMapper;
import com.greenart.book_admin.utils.AESAlgorithm;

import lombok.experimental.Delegate;

@RestController
@RequestMapping("/api/admin")
public class AdminAPIController {
    @Autowired AdminMapper admin_mapper;
    @PutMapping("/add")
    public ResponseEntity<Map<String, Object>> putAdminInfo(@RequestBody AdminInfoVO data) throws Exception {
        Map<String, Object> m = new LinkedHashMap<String, Object>();
        
        String pwd = data.getAi_pwd();
        pwd = AESAlgorithm.Encrypt(pwd);
        data.setAi_pwd(pwd);
        System.out.println(data);
        try{
            admin_mapper.insertAdmin(data);
        }
        catch(DuplicateKeyException e) {
            m.put("status", false);
            m.put("message", data.getAi_id()+"은(는) 이미 등록된 아이디입니다.");
            return new ResponseEntity<Map<String, Object>>(m,HttpStatus.BAD_REQUEST);
        }

        m.put("status", "true");
        m.put("message", "관리자가 추가되었습니다");
        return new ResponseEntity<Map<String, Object>>(m,HttpStatus.OK);
    }

    @PostMapping("/login")
    public Map<String, Object> postAdminLogin(@RequestBody AdminInfoVO data, HttpSession session) throws Exception {
        Map<String, Object> m = new LinkedHashMap<String, Object>();
        
        data.setAi_pwd(AESAlgorithm.Encrypt(data.getAi_pwd()));
        AdminInfoVO user = admin_mapper.loginAdmin(data);
        
        if(user == null) {
            m.put("status", false);
            m.put("message", "아이디 혹은 비밀번호 오류입니다.");
        } else {
            m.put("status", true);
            // resultMap.put("ip", ip);
            m.put("message", "로그인 성공");
            session.setAttribute("loginUser", user);
        }
        
        return m;
    }
    
    @DeleteMapping("/delete")
    public Map<String, Object> deleteAdmin(@RequestParam Integer seq) {
        Map<String, Object> m = new LinkedHashMap<String, Object>();
        
        admin_mapper.deleteAdmin(seq);
        m.put("status", true);
        m.put("message", "삭제되었습니다.");
        
        return m;
    }
    @GetMapping("/info")
    public AdminInfoVO getAdmin(@RequestParam Integer seq) {
        return admin_mapper.selectAdminBySeq(seq);
    }
    
    @PatchMapping("/modify")
    public ResponseEntity<Map<String, Object>> patchAdminInfo(@RequestBody AdminInfoVO data) throws Exception {
        Map<String, Object> m = new LinkedHashMap<String, Object>();

        if(data.getAi_pwd() == null || data.getAi_pwd().equals("")) {
            m.put("status", false);
            m.put("message", "비밀번호를 입력하지 않았음.");
            return new ResponseEntity<Map<String, Object>>(m,HttpStatus.BAD_REQUEST);
        }
        if(data.getAi_name() == null || data.getAi_name().equals("")) {
            m.put("status", false);
            m.put("message", "이름을 입력하지 않았음.");
            return new ResponseEntity<Map<String, Object>>(m,HttpStatus.BAD_REQUEST);
        }
        // if(data.getAi_role() == null) {
        //     m.put("status", false);
        //     m.put("message", "계정 유형을 입력하지 않앗음.");
        //     return new ResponseEntity<Map<String, Object>>(m,HttpStatus.BAD_REQUEST);
        // }

        String pwd = data.getAi_pwd();
        pwd = AESAlgorithm.Encrypt(pwd);
        data.setAi_pwd(pwd);

        admin_mapper.updateAdmin(data);
        m.put("status", true);
        m.put("message", "계정 정보를 수정하였습니다.");
        return new ResponseEntity<Map<String, Object>>(m,HttpStatus.OK);

    }
}
