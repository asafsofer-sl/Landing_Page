package com.example.landingpage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LandingPageController {

    // Keep settings in memory for this simple example
    private final PageSettings pageSettings = new PageSettings();

    @GetMapping("/")
    public String viewPage(Model model) {
        model.addAttribute("settings", pageSettings);
        return "index";
    }

    @PostMapping("/update-settings")
    public String updateSettings(@ModelAttribute PageSettings updatedSettings) {
        pageSettings.setTitle(updatedSettings.getTitle());
        pageSettings.setSubtitle(updatedSettings.getSubtitle());
        pageSettings.setBackgroundColor(updatedSettings.getBackgroundColor());
        pageSettings.setCtaText(updatedSettings.getCtaText());
        return "redirect:/";
    }
}
