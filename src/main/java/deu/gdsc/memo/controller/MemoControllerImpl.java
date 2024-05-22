package deu.gdsc.memo.controller;

import deu.gdsc.memo.dto.MemoEditRequestForm;
import deu.gdsc.memo.dto.MemoRequestForm;
import deu.gdsc.memo.service.MemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemoControllerImpl implements MemoController {

    @Value("${spring.application.name}")
    private String appName;

    private final MemoService memoService;

    @Autowired
    public MemoControllerImpl(MemoService memoService) {
        this.memoService = memoService;
    }

    @Override
    @GetMapping("/")
    public String getMemoList(Model model) {
        model.addAttribute("appName", appName);
        model.addAttribute("memoList", memoService.getMemoList());
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
        memoService.createMemo(memoRequestForm);
        return "redirect:/";
    }

    @Override
    @GetMapping("/edit/{id}")
    public String requestEditMemoForm(
            @PathVariable Long id, Model model) {
        model.addAttribute("memoEditRequestForm", memoService.getEditMemoForm(id));
        return "memo-edit";
    }

    @Override
    @PostMapping("/edit/{id}")
    public String editMemo(
            @PathVariable Long id, MemoEditRequestForm memoEditRequestForm) {
        memoService.editMemo(id, memoEditRequestForm);
        return "redirect:/";
    }

    @Override
    @GetMapping("/delete/{id}")
    public String deleteMemo(
            @PathVariable Long id) {
        memoService.deleteMemo(id);
        return "redirect:/";
    }
}
