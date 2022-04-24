//package com.bithumb.msacommunity.service;
//
//import com.bithumb.msacommunity.domain.Community;
//import com.bithumb.msacommunity.repository.CommunityRepository;
//import org.springframework.stereotype.Service;
//import reactor.core.publisher.Mono;
//
//@Service
//public class CommunityServiceImpl implements CommunityService {
//    private final CommunityRepository communityRepository;
//
//    public CommunityServiceImpl(CommunityRepository communityRepository) {
//        this.communityRepository = communityRepository;
//    }
//
//
//    //게시글 저장
//    @Override
//    public Mono<Community> saveBoard(Community community) {
//        return this.communityRepository.save(community);
//    }
//}
