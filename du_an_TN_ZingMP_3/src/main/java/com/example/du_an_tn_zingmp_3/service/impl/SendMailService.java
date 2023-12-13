package com.example.du_an_tn_zingmp_3.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@Service
public class SendMailService {
    @Autowired
    private JavaMailSender javaMailSender;
    public void sendEmail(String toEmail, String subject, String content) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("trung96ecvn@gmail.com");
        simpleMailMessage.setTo(toEmail);
        simpleMailMessage.setSubject("Thông báo khóa tài khoản");
        simpleMailMessage.setText("Bạn đã được mở khóa tài khoản! Làm ơn lần sau đừng láo");
        javaMailSender.send(simpleMailMessage);
    }

    public void sendEmail(String toEmail) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("trung96ecvn@gmail.com");
        simpleMailMessage.setTo(toEmail);
        simpleMailMessage.setSubject("Thông báo khóa tài khoản");
        simpleMailMessage.setText("Tài khoản của bạn đã bị khóa. Vui lòng liên hệ quản trị viên để mở khóa tài khoản");
        javaMailSender.send(simpleMailMessage);
    }
    public void sendEmailOpen(String toEmail){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("trung96ecvn@gmail.com");
        simpleMailMessage.setTo(toEmail);
        simpleMailMessage.setSubject("Thông báo khóa tài khoản");
        simpleMailMessage.setText("Bạn đã được mở khóa tài khoản! Làm ơn lần sau đừng láo");
        javaMailSender.send(simpleMailMessage);
    }
    public void sendEmailUpdatePassword(String toEmail, String passwordNew){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("trung96ecvn@gmail.com");
        simpleMailMessage.setTo(toEmail);
        simpleMailMessage.setSubject("Thông báo khóa tài khoản");
        simpleMailMessage.setText("Bạn vừa mới đổi mật khẩu thành công thành: " + passwordNew + "Đừng để lộ thông tin, xing cảm ơn đã xử dụng dịch vụ.");
        javaMailSender.send(simpleMailMessage);
    }
}
