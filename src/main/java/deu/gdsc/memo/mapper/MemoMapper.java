package deu.gdsc.memo.mapper;

import deu.gdsc.memo.dto.MemoEditRequestForm;
import deu.gdsc.memo.dto.MemoRequestForm;
import deu.gdsc.memo.dto.MemoResponse;
import deu.gdsc.memo.entity.Memo;

public interface MemoMapper {
    // 메모 생성 요청 정보를 메모 엔티티로 변환
    Memo toMemo(MemoRequestForm memoRequestForm);

    // 메모 수정 요청 정보를 메모 엔티티로 변환
    Memo toMemo(MemoEditRequestForm memoEditRequestForm);

    // 메모 엔티티를 메모 응답 정보로 변환
    MemoResponse toMemoResponse(Memo memo);
}
