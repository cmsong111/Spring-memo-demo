package deu.gdsc.memo.controller;

import deu.gdsc.memo.dto.MemoEditRequestForm;
import deu.gdsc.memo.dto.MemoRequestForm;
import org.springframework.ui.Model;

public interface MemoController {

    /**
     * 메모 리스트 요청
     *
     * @param model Model
     * @return 메모 리스트
     */
    String getMemoList(Model model);

    /**
     * 메모 생성 페이지 요청 (Get)
     *
     * @param model Model
     * @return 메모 생성 페이지
     */
    String requestMemoForm(Model model);

    /**
     * 메모 생성 요청 (Post)
     *
     * @param memoRequestForm 메모 생성 요청 정보
     * @return 메모 리스트 화면으로 redirect
     */
    String createMemo(MemoRequestForm memoRequestForm);

    /**
     * 메모 수정 페이지 요청 (GET)
     *
     * @param id    메모 ID
     * @param model Model
     * @return 메모 수정 페이지
     */
    String requestEditMemoForm(Long id, Model model);

    /**
     * 메모 수정 요청 (POST)
     *
     * @param id                  메모 ID
     * @param memoEditRequestForm 수정할 메모 정보
     * @return 수정 결과 페이지
     */
    String editMemo(Long id, MemoEditRequestForm memoEditRequestForm);

    /**
     * 메모 삭제 요청
     *
     * @param id 메모 ID
     * @return 메인 페이지
     */
    String deleteMemo(Long id);
}
