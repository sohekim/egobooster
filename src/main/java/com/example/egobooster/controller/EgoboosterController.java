package com.example.egobooster.controller;

import com.example.egobooster.apicontroller.BoosterController;
import com.example.egobooster.apicontroller.LoveController;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class EgoboosterController {

  final BoosterController boosterController;
  final LoveController loveController;

  @GetMapping("/")
  public String init(Model model) {
    model.addAttribute("booster", boosterController.findRandomBooster().getBody());
    model.addAttribute("love", loveController.getCount().getBody());
    return "index";
  }

  @GetMapping("{id}/giftee/{giftee}")
  public String slipOnlyGiftee(Model model, @PathVariable(value = "id") Long id,
      @PathVariable(value = "giftee") String giftee) {
    model.addAttribute("booster", boosterController.findCustomBooster(id, giftee, "").getBody());
    return "slip";
  }

  @GetMapping("{id}/gifter/{gifter}")
  public String slipOnlyGifter(Model model, @PathVariable(value = "id") Long id,
      @PathVariable(value = "gifter") String gifter) {
    model.addAttribute("booster", boosterController.findCustomBooster(id, "", gifter).getBody());
    return "slip";
  }

  @GetMapping("{id}/{giftee}/{gifter}")
  public String slipBoth(Model model, @PathVariable(value = "id") Long id,
      @PathVariable(value = "giftee") String giftee,
      @PathVariable(value = "gifter") String gifter) {
    model.addAttribute("booster", boosterController.findCustomBooster(id, giftee, gifter).getBody());
    return "slip";
  }

}
