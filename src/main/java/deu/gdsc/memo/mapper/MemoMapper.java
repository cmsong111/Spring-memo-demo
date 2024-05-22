package deu.gdsc.memo.mapper;

import deu.gdsc.memo.dto.MemoEditRequestForm;
import deu.gdsc.memo.dto.MemoRequestForm;
import deu.gdsc.memo.dto.MemoResponse;
import deu.gdsc.memo.entity.Memo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.sql.Timestamp;
import java.time.format.DateTimeFormatter;

@Mapper(componentModel = "spring")
public interface MemoMapper {
    // 메모 생성 요청 정보를 메모 엔티티로 변환
    Memo toMemo(MemoRequestForm memoRequestForm);

    // 메모 수정 요청 정보를 메모 엔티티로 변환
    Memo toMemo(MemoEditRequestForm memoEditRequestForm);

    // 메모 엔티티를 메모 응답 정보로 변환
    @Mapping(target = "createdAt", expression = "java(timeStampToFomattedString(memo.getCreatedAt()))")
    @Mapping(target = "updatedAt", expression = "java(timeStampToFomattedString(memo.getUpdatedAt()))")
    MemoResponse toMemoResponse(Memo memo);

    // 메모 수정 객체
    MemoEditRequestForm toMemoEditRequestForm(Memo memo);

    default String timeStampToFomattedString(Timestamp timestamp) {
        return timestamp.toLocalDateTime().format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일 HH시 mm분"));
    }
}
