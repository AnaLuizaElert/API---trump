package br.senai.sc.supertrunfofrutas.business.model.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PersonEditDTO {

    @NotEmpty(message = "Field current password is empty")
    @Size(max = 255, message = "Field current password has more than 255 characters")
    private String currentPassword;

    @NotEmpty(message = "Field password is empty")
    @Size(max = 255, message = "Field password has more than 255 characters")
    private String password;

    @NotEmpty(message = "Field password is empty")
    @Size(max = 255, message = "Field password has more than 255 characters")
    private String name;
}
