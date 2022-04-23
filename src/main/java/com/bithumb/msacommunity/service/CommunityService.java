package com.bithumb.msacommunity.service;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public interface CommunityService {
    // 게시판 열람
    public Map<String, String> viewNoticeBoard(Map<String, String> param);

    // 게시글 작성
    public Map<String, String> writeBoard(Map<String, String> param);

    // 댓글 작성
    public Map<String, String> writeComment(Map<String, String> param);

    // 게시글, 댓글 숨김처리
    public Map<String, String> showNoticeContentYn(Map<String, String> param);
}
