package com.swino.ecf4employerecrutement.controller;

import com.swino.ecf4employerecrutement.entities.Application;
import com.swino.ecf4employerecrutement.entities.Offer;
import com.swino.ecf4employerecrutement.services.RecruitmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
@Controller
@RequestMapping("/recruitement")
public class RecruitmentController {
    @Autowired
    private RecruitmentService recruitmentService;

    @GetMapping("/offers")
    public String getAllOffers(Model model) {
        List<Offer> offers = recruitmentService.getAllOffers();
        model.addAttribute("offers", offers);
        return "offer-list";
    }

    @GetMapping("/offers/{id}")
    public String getOfferDetails(@PathVariable("id") Long id, Model model) {
        Offer offer = recruitmentService.getOfferById(id);
        List<Application> applications = recruitmentService.getApplicationsForOffer(id);
        model.addAttribute("offer", offer);
        model.addAttribute("applications", applications);
        return "offer-details";
    }
}
