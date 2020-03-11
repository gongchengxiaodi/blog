package com.huihui.controller.view;

import com.github.pagehelper.PageInfo;
import com.huihui.domain.Blog;
import com.huihui.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@Controller
public class ArchivesViewController {

    @Autowired
    private BlogService blogService ;

    @RequestMapping("/toArchives")
    public String toArchives(Model model,
                             @RequestParam(name = "startIndex",defaultValue = "1") Integer startIndex){
        Map<Integer,PageInfo<Blog>> map = blogService.queryBlogsArchivew(startIndex);
        int count = blogService.queryCount();
        model.addAttribute("map",map);
        model.addAttribute("count",count);
        return "view/archives";
    }
}
