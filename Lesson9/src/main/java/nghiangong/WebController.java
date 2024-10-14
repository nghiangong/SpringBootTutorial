package nghiangong;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class WebController {

    @GetMapping("/profile")
    public String profile(Model model){
        // Tạo ra thông tin
        List<Info> profile = new ArrayList<>();
        profile.add(new Info("fullname", "Nguyễn Mạnh Nghĩa"));
        profile.add(new Info("nickname", "Goose55"));
        profile.add(new Info("gmail", "nghiangong@gmail.com"));
        profile.add(new Info("facebook", "https://www.facebook.com/nghiangong"));
        profile.add(new Info("website", "https://nghiangong.me"));

        // Đưa thông tin vào Model
        model.addAttribute("nghiaProfile", profile);

        // TRả về template profile.html
        return "profile";
    }
}