package com.greenart.book_admin.api;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.greenart.book_admin.data.UserInfoVO;
import com.greenart.book_admin.mapper.UserMapper;
import com.greenart.book_admin.utils.AESAlgorithm;

@RestController
@RequestMapping("/api/user")
public class UserAPIController {
    @Autowired UserMapper user_mapper;
    @GetMapping("/info")
    public UserInfoVO getUserInfo(@RequestParam Integer seq) {

        return user_mapper.getUserBySeq(seq);
    }

    @PatchMapping("/update")
    public ResponseEntity<Map<String, Object>> patchUserInfo(@RequestBody UserInfoVO data) throws Exception {
        Map<String, Object> m = new LinkedHashMap<String, Object>();

        if(data.getUi_pwd() == null || data.getUi_pwd().equals("")) {
            m.put("status", false);
            m.put("message", "비밀번호를 입력하지 않았음.");
            return new ResponseEntity<Map<String, Object>>(m,HttpStatus.BAD_REQUEST);
        }
        if(data.getUi_name() == null || data.getUi_name().equals("")) {
            m.put("status", false);
            m.put("message", "이름을 입력하지 않았음.");
            return new ResponseEntity<Map<String, Object>>(m,HttpStatus.BAD_REQUEST);
        }

        String pwd = data.getUi_pwd();
        pwd = AESAlgorithm.Encrypt(pwd);
        data.setUi_pwd(pwd);

        user_mapper.updateUser(data);
        m.put("status", true);
        m.put("message", "수정완료되었습니다.");

        return new ResponseEntity<Map<String, Object>>(m,HttpStatus.OK);
    }

    @DeleteMapping("/delete")
    public Map<String, Object> deleteUser(@RequestParam Integer seq) {
        Map<String, Object> m = new LinkedHashMap<String, Object>();

        user_mapper.deleteUser(seq);
        m.put("status", true);
        m.put("message", "삭제되었습니다.");

        return m;
    }
}
