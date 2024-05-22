package deu.gdsc.memo.service;

import deu.gdsc.memo.dto.MemoEditRequestForm;
import deu.gdsc.memo.dto.MemoRequestForm;
import deu.gdsc.memo.dto.MemoResponse;
import deu.gdsc.memo.entity.Memo;
import deu.gdsc.memo.mapper.MemoMapper;
import deu.gdsc.memo.repository.MemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MemoServiceImpl implements MemoService {

    private final MemoMapper memoMapper;

    private final MemoRepository memoRepository;

    @Autowired
    public MemoServiceImpl(MemoMapper memoMapper, MemoRepository memoRepository) {
        this.memoMapper = memoMapper;
        this.memoRepository = memoRepository;
    }

    @Override
    public List<MemoResponse> getMemoList() {
        List<Memo> memoList = memoRepository.findAll();

        // Entity 리스트를 반환용 DTO 리스트로 변환
        List<MemoResponse> memoResponseList = new ArrayList<>();
        for (Memo memo : memoList) {
            memoResponseList.add(memoMapper.toMemoResponse(memo));
        }

        return memoResponseList;
    }

    @Override
    public MemoResponse getMemo(Long id) {
        // Optional를 사용하는 이유는 findById 메소드의 반환값이 null일 수도 있기 때문
        Optional<Memo> memo = memoRepository.findById(id);
        if (memo.isEmpty()) {
            return null;
        }
        return memoMapper.toMemoResponse(memo.get());
    }

    @Override
    public MemoResponse createMemo(MemoRequestForm memoRequestForm) {
        // 메모 생성 요청 정보를 메모 엔티티로 변환
        Memo memo = memoMapper.toMemo(memoRequestForm);

        // 생성 및 수정 시간 설정
        memo.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        memo.setUpdatedAt(new Timestamp(System.currentTimeMillis()));

        // 메모 저장
        Memo savedMemo = memoRepository.save(memo);

        // Entity를 반환용 DTO로 변환
        return memoMapper.toMemoResponse(savedMemo);
    }

    @Override
    public MemoEditRequestForm getEditMemoForm(Long id) {
        // Optional를 사용하는 이유는 findById 메소드의 반환값이 null일 수도 있기 때문
        Optional<Memo> memo = memoRepository.findById(id);
        if (memo.isEmpty()) {
            return null;
        }

        // 조회된 Entity를 수정용 DTO로 변환
        return memoMapper.toMemoEditRequestForm(memo.get());
    }

    @Override
    public MemoResponse editMemo(Long id, MemoEditRequestForm memoEditRequestForm) {
        // Optional을 통해 메모 조회
        Optional<Memo> memo = memoRepository.findById(id);
        if (memo.isEmpty()) {
            return null;
        }
        Memo editedMemo = memo.get();
        editedMemo.setTitle(memoEditRequestForm.getTitle());
        editedMemo.setContent(memoEditRequestForm.getContent());
        editedMemo.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
        Memo savedMemo = memoRepository.save(editedMemo);
        return memoMapper.toMemoResponse(savedMemo);
    }

    @Override
    public boolean deleteMemo(Long id) {
        Optional<Memo> memo = memoRepository.findById(id);
        if (memo.isEmpty()) {
            return false;
        }
        memoRepository.deleteById(id);
        return true;
    }
}
