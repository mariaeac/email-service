package com.meac.email_service.core.dtos;

public record EmailRequest(String to, String subject, String body) {
}
