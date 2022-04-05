package waa.labs.lab4.dtos.request;

import lombok.Data;

@Data
public class RequestPostDto {
    long id;
    String title;
    String content;
    long authorId;
}
