package waa.labs.lab4.services.impl;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import waa.labs.lab4.domains.Comment;
import waa.labs.lab4.domains.dtos.CommentDto;
import waa.labs.lab4.helpers.ListMapper;
import waa.labs.lab4.repositories.ICommentRepo;
import waa.labs.lab4.services.ICommentService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class CommentService implements ICommentService {
    ICommentRepo commentRepo;
    ModelMapper modelMapper;
    ListMapper<Comment, CommentDto> commentListMapperToDto;

    public CommentService(
            ICommentRepo commentRepo,
            ModelMapper modelMapper,
            ListMapper<Comment, CommentDto> commentListMapper
    ) {
        this.commentRepo = commentRepo;
        this.modelMapper = modelMapper;
        this.commentListMapperToDto = commentListMapper;
    }

    @Override
    public List<CommentDto> getAllComments() {
        return commentListMapperToDto.mapList(commentRepo.findAll(), CommentDto.class);
    }

    @Override
    public CommentDto getCommentById(Long commentId) {
        return modelMapper.map(commentRepo.findById(commentId).orElse(null), CommentDto.class);
    }
}
