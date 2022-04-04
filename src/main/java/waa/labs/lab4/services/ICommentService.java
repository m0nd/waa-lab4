package waa.labs.lab4.services;

import waa.labs.lab4.domains.dtos.CommentDto;

import java.util.List;

public interface ICommentService {
    List<CommentDto> getAllComments();

    CommentDto getCommentById(Long commentId);
}
