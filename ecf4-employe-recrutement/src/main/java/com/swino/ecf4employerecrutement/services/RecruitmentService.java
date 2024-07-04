package com.swino.ecf4employerecrutement.services;

import com.swino.ecf4employerecrutement.entities.Application;
import com.swino.ecf4employerecrutement.entities.Interview;
import com.swino.ecf4employerecrutement.entities.Offer;
import com.swino.ecf4employerecrutement.repositories.ApplicationRepository;
import com.swino.ecf4employerecrutement.repositories.InterviewRepository;
import com.swino.ecf4employerecrutement.repositories.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecruitmentService {

    @Autowired
    private OfferRepository offerRepository;

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private InterviewRepository interviewRepository;

    public Offer createOffer(Offer offer) {
        return offerRepository.save(offer);
    }


    public Offer getOfferById(Long id) {
        return offerRepository.findById(id).orElse(null);
    }


    public Offer updateOffer(Offer offer) {
        return offerRepository.save(offer);
    }


    public void deleteOffer(Long id) {
        offerRepository.deleteById(id);
    }


    public List<Offer> getAllOffers() {
        return offerRepository.findAll();
    }


    public Application applyToOffer(Application application) {
        return applicationRepository.save(application);
    }


    public Application getApplicationById(Long id) {
        return applicationRepository.findById(id).orElse(null);
    }


    public Application updateApplication(Application application) {
        return applicationRepository.save(application);
    }


    public void deleteApplication(Long id) {
        applicationRepository.deleteById(id);
    }


    public List<Application> getApplicationsForOffer(Long offerId) {
        return applicationRepository.findByOfferId(offerId);
    }


    public Interview scheduleInterview(Interview interview) {
        return interviewRepository.save(interview);
    }


    public Interview getInterviewById(Long id) {
        return interviewRepository.findById(id).orElse(null);
    }


    public Interview updateInterview(Interview interview) {
        return interviewRepository.save(interview);
    }


    public void deleteInterview(Long id) {
        interviewRepository.deleteById(id);
    }
}

