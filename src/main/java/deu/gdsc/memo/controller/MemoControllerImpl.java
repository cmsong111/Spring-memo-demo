package deu.gdsc.memo.controller;

import deu.gdsc.memo.dto.MemoEditRequestForm;
import deu.gdsc.memo.dto.MemoRequestForm;
import deu.gdsc.memo.dto.MemoResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MemoControllerImpl implements MemoController {

    @Value("${spring.application.name}")
    private String appName;

    @Override
    @GetMapping("/")
    public String getMemoList(Model model) {
        //TODO: 메모 리스트를 가져와서 model에 담아서 memo-list.html로 이동
        List<MemoResponse> memoList = new ArrayList<>();
        model.addAttribute("appName", appName);
        model.addAttribute("memoList", memoList);
        return "memo-list";
    }

    @Override
    @GetMapping("/create")
    public String requestMemoForm(Model model) {
        model.addAttribute("memoRequestForm", new MemoRequestForm());
        return "memo-form";
    }

    @Override
    @PostMapping("/create")
    public String createMemo(MemoRequestForm memoRequestForm) {
        //TODO: 메모 생성 요청
        return "redirect:/";
    }

    @Override
    @GetMapping("/{id}/edit")
    public String requestEditMemoForm(
            @PathVariable Long id, Model model) {
        //TODO: 메모 수정 객체 가져오기
        model.addAttribute("memoEditRequestForm", new MemoEditRequestForm());
        return "memo-edit";
    }

    @Override
    @PostMapping("/{id}/edit")
    public String editMemo(
            @PathVariable Long id, MemoEditRequestForm memoEditRequestForm) {
        //TODO: 메모 수정 요청 처리
        return "redirect:/";
    }

    @Override
    @GetMapping("/{id}/delete")
    public String deleteMemo(
            @PathVariable Long id) {
        // TODO: 메모 삭제 요청 처리
        return "redirect:/";
    }
}
