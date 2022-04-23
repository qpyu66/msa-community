package com.bithumb.msacommunity.service;

import com.bithumb.msacommunity.domain.Board;
import com.bithumb.msacommunity.repository.BoardRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    // 게시글 조회
    @Override
    public Mono<Board> findById(Integer id) {
        return this.boardRepository.findById(id);
    }

    //게시글 저장
    @Override
    public Mono<Board> saveBoard(Board board) {
        return this.boardRepository.save(board);
    }


}
