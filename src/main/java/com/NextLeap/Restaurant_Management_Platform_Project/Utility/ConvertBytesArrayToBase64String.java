package com.NextLeap.Restaurant_Management_Platform_Project.Utility;

import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.util.Base64;

@Component
@NoArgsConstructor
public class ConvertBytesArrayToBase64String {

    public String convertToBase64(byte[] imageBytes) {
        return Base64.getEncoder().encodeToString(imageBytes);
    }
}
