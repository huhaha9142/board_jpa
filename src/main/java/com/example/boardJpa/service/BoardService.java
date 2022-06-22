package com.example.boardJpa.service;

import com.example.boardJpa.entity.Board;
import com.example.boardJpa.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    //  게시글 작성
    public void boardWrite(Board board) {

        boardRepository.save(board);
    }

    //  게시글 리스트
    public List<Board> boardList() {

        return boardRepository.findAll();
    }

    //  게시글 상세 페이지
    public Board boardView(Integer id) {

        return  boardRepository.findById(id).get();


    }

    //  게시글 삭제 (id에 맞는)
    public void boardDelete(Integer id) {

        boardRepository.deleteById(id);
    }

}
