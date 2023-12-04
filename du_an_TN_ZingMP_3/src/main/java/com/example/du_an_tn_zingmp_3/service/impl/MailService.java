package com.example.du_an_tn_zingmp_3.service.impl;

import com.example.du_an_tn_zingmp_3.model.MailStructure;
import com.example.du_an_tn_zingmp_3.model.User;
import com.example.du_an_tn_zingmp_3.repository.IUserRepository;
import com.example.du_an_tn_zingmp_3.repository.MailRepository;
import com.example.du_an_tn_zingmp_3.service.IMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService implements IMailService {
    @Autowired
    private MailRepository mailRepository;
    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private IUserRepository iUserRepository;
    @Value("spring.mail.username")
    private String fromMail;

    public void sendMail(MailStructure mailStructure){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(fromMail);
        simpleMailMessage.setSubject(mailStructure.getTitle());
        simpleMailMessage.setText(mailStructure.getContentEmail());
        simpleMailMessage.setTo(mailStructure.getReceiptEmail());

        mailSender.send(simpleMailMessage);
    }

    public Boolean register(User users) {
        String email = users.getEmail();
        String name = users.getUserName();
        String phone = users.getPhone();
        if(isDuplicateEmail(email) || isDuplicateName(name) || isDuplicatePhone(phone)){
            return false;
        }
        String link = "http://localhost:8080/mail/active/" + email;
        String subject = "Active account " + name;
        String text = "Hello, " + name
                + "\n Please confirm this link to active your account: " + link;
        if (iUserRepository.findByUserName(name) == null ){
            iUserRepository.save(users);
            MailStructure mailStructure = new MailStructure(subject,text,email);
            sendMail(mailStructure);
            return true;
        }
        return false;
    }

    public Boolean activeAccount(String name){
        User account = iUserRepository.findByUserName(name);
        if (account != null){
            iUserRepository.save(account);
            return true;
        }
        return false;
    }
    public boolean isDuplicateEmail(String name){
        User users = iUserRepository.findByUserName(name);
        if (users != null){
            return false;
        }
        return true;
    }
    public boolean isDuplicatePhone(String phone){
        User users = iUserRepository.findByPhone(phone);
        if (users != null){
            return false;
        }
        return true;

    }
    public boolean isDuplicateName(String userName){
        User users = iUserRepository.findByUserName(userName);
        if (users != null){
            return false;
        }
        return true;
    }
}
