package shark.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import shark.security.dto.Msg;

/**
 * @author zhuhh 2019/1/24
 */
@Controller
public class HomeController {

    @RequestMapping("/")
    public String index(Model model) {
        Msg msg = new Msg("测试标题", "测试内容", "额外信息仅对管理员展示");
        model.addAttribute("msg", msg);
        System.out.println("返回首页");
        return "index";
    }
}
