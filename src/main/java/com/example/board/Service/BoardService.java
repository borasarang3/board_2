package com.example.board.Service;

import com.example.board.DTO.BoardDTO;
import com.example.board.Entity.BoardEntity;
import com.example.board.Repository.BoardRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
@Transactional //데이터베이스에 작업할 레코드들을 모아서 한번에 처리
@RequiredArgsConstructor//자동 주입, 클래스 ,생성자를 통해 생성 후 사용, Audi
public class BoardService {
    //@Autowired
    //private BoardRepositroy boardRepository;
    private final BoardRepository boardRepository; //사용할 SQL문
    private final ModelMapper modelMapper; //AppConfig에서 선언 = new ModelMapper()

    //Controller과 Service는 DTO로 전달
    public void insert(BoardDTO boardDTO) { //삽입, 입력폼에서 입력폼에서 입력받은 내용을 데이터베이스 저장
        //DTO로 Entity변환
        //map은 변수, 값으로 구성된 배열
        //boardDTO 변수들을 BoardEntity의 변수에 맞게 변환
        BoardEntity boardedEntity = modelMapper.map(boardDTO, BoardEntity.class);

        boardRepository.save(boardedEntity);
    }
    public void update(BoardDTO boardDTO) { //수정, 수정폼에서 수정된 내용을 데이터베이스 저장
        Optional<BoardEntity> boardEntity = boardRepository.findById(boardDTO.getId());
        if (boardEntity.isPresent()) {
            BoardEntity boardEntitys = modelMapper.map(boardDTO, BoardEntity.class);

            boardRepository.save(boardEntitys);
        }
    }

    public void delete(Integer id) { //삭제, 게시글번호로 해당 자료를 데이터베이스에서 삭제
        boardRepository.deleteById(id);
    }

    public List<BoardDTO> list() { //전체목록, 데이터베이스에서 모든 데이터를 화면에 출력
        //필드:필드:필드-레코드(map)
        //레코드:레코드:레코드(List)
        List<BoardEntity> boardEntities = boardRepository.findAll(); //모두 조회
        //Repository<->Service Entity<->DTO Controller
        //여러개의 레코드를 하나씩 DTO로 변환해서 다시 배열에 저장 후 List 변환
        List<BoardDTO> boardDTOS = Arrays.asList(modelMapper.map(boardEntities, BoardDTO[].class));
        return boardDTOS;
    }

    public BoardDTO read(Integer id) { //개별정보, 게시글번호와 데이터를 화면에 출력
        Optional<BoardEntity> boardEntity = boardRepository.findById(id);

        BoardDTO boardDTO = modelMapper.map(boardEntity, BoardDTO.class);
        return boardDTO;
    }

    //접근자 전달자 메소드명(인수,...)
    //전달자: 메소드에서 처리된 결과값을 전달
    //인수 : 메소드에서 처리를 위한 값을 전달
}
