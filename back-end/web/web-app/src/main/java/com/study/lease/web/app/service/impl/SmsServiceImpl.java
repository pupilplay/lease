package com.study.lease.web.app.service.impl;

import com.study.lease.web.app.service.SmsService;
import org.springframework.stereotype.Service;

@Service
public class SmsServiceImpl implements SmsService {

    @Override
    public void sendCode(String phone, String code) {
        return;
    }
}
