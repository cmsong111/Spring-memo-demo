package deu.gdsc.memo.service;

import deu.gdsc.memo.dto.MemoEditRequestForm;
import deu.gdsc.memo.dto.MemoRequestForm;
import deu.gdsc.memo.dto.MemoResponse;

import java.util.List;

public interface MemoService {

    /**
     * 모든 메모 리스트를 가져온다.
     *
     * @return List<MemoResponse> 메모 리스트
     */
    List<MemoResponse> getMemoList();

    /**
     * 특정 메모를 가져온다.
     *
     * @param id 메모 ID
     * @return MemoResponse 메모
     */
    MemoResponse getMemo(Long id);

    /**
     * 메모를 생성한다.
     *
     * @param memoRequestForm 생성할 메모 정보
     * @return MemoResponse 생성된 메모
     */
    MemoResponse createMemo(MemoRequestForm memoRequestForm);

    /**
     * 메모 수정용 객체를 가져온다.
     *
     * @param id 메모 ID
     * @return MemoEditRequestForm 수정할 메모 정보
     */
    MemoEditRequestForm getEditMemoForm(Long id);

    /**
     * 메모를 수정한다.
     *
     * @param id           메모 ID
     * @param memoEditRequestForm 수정할 메모 정보
     * @return MemoResponse 수정된 메모
     */
    MemoResponse editMemo(Long id, MemoEditRequestForm memoEditRequestForm);

    /**
     * 메모를 삭제한다.
     *
     * @param id 메모 ID
     * @return 삭제 여부
     */
    boolean deleteMemo(Long id);
}
