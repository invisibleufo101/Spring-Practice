package org.zerock.ex00.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.zerock.ex00.mappers.BoardMapper;

@Transactional
@RequiredArgsConstructor
@Log4j2
@Service
public class BoardService {

    private final BoardMapper boardMapper;
}
