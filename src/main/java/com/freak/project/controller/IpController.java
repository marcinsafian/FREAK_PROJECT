package com.freak.project.controller;

import com.freak.project.service.ip.IpUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/adm")
public class IpController {
    String remoteAddress;

    @Autowired
    private IpUser ipUser;

    @GetMapping()
    public String getIpUser(){return
        remoteAddress = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes())
                .getRequest().getRemoteAddr();
    }
}
