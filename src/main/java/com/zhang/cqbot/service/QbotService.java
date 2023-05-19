package com.zhang.cqbot.service;

import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

public interface QbotService {
    void QqRobotEvenHandle(HttpServletRequest request);
}
