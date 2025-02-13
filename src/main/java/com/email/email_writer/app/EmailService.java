package com.email.email_writer.app;

import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class EmailService
{
    public String generateEmailReply(EmailRequest emailRequest)
    {
        //String prompt = buildPrompt(EmailRequest);
        String prompt = buildPrompt(emailRequest);
        Map<String, Object> requestBody = Map.of(
                "contents", new Object[]
                        {
                                Map.of
                                        (
                                        "parts", new Object[]
                                                {
                                                        "text, prompt"
                                                }
                                        )
                        }
        );
    }
    private String buildPrompt(EmailRequest emailRequest)
    {
        StringBuilder propmt = new StringBuilder();
        propmt.append("Generate a professional email replay for the following email. Please don't generate a subject line.");
        propmt.append("\n");
        if (emailRequest.getTone() != null && !emailRequest.getTone().isEmpty())
        {
            propmt.append("Use a").append(emailRequest.getTone()).append(" tone.");

        }
        propmt.append("\n Original email: \n").append(emailRequest.getEmailContent());

        return propmt.toString();
    }
}
