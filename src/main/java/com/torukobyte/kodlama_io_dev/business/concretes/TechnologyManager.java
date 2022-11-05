package com.torukobyte.kodlama_io_dev.business.concretes;

import com.torukobyte.kodlama_io_dev.business.abstracts.TechnologyService;
import com.torukobyte.kodlama_io_dev.business.constants.Message;
import com.torukobyte.kodlama_io_dev.business.requests.technologies.CreateTechnologyRequest;
import com.torukobyte.kodlama_io_dev.business.requests.technologies.UpdateTechnologyRequest;
import com.torukobyte.kodlama_io_dev.business.responses.technologies.GetAllTechnologiesResponse;
import com.torukobyte.kodlama_io_dev.business.responses.technologies.GetTechnologyByIdResponse;
import com.torukobyte.kodlama_io_dev.entities.concretes.Language;
import com.torukobyte.kodlama_io_dev.entities.concretes.Technology;
import com.torukobyte.kodlama_io_dev.mappers.TechnologyMapper;
import com.torukobyte.kodlama_io_dev.repository.abstracts.LanguageRepository;
import com.torukobyte.kodlama_io_dev.repository.abstracts.TechnologyRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TechnologyManager implements TechnologyService {
    TechnologyRepository technologyRepository;
    TechnologyMapper technologyMapper;
    LanguageRepository languageRepository;

    public TechnologyManager(
            TechnologyRepository technologyRepository,
            TechnologyMapper technologyMapper,
            LanguageRepository languageRepository) {
        this.technologyRepository = technologyRepository;
        this.technologyMapper = technologyMapper;
        this.languageRepository = languageRepository;
    }

    @Override
    public List<GetAllTechnologiesResponse> getAll() {
        List<Technology> technologies = technologyRepository.findAll();
        return technologyMapper.toTechnologies(technologies);
    }

    @Override
    public GetTechnologyByIdResponse getById(int id) {
        Technology technology = technologyRepository.findById(id).get();
        return technologyMapper.toTechnology(technology);
    }

    @Override
    public CreateTechnologyRequest create(CreateTechnologyRequest request) {
        Technology technology = technologyMapper.toCreateTechnologyRequest(request);

        Language language = languageRepository.findById(request.getLanguageId()).get();
        technology.setLanguage(language);

        if (checkTechnologyNameValid(technology)) {
            throw new RuntimeException(Message.LANGUAGE_NAME_IS_NOT_VALID);
        }

        if (isTechnologyExists(technology)) {
            throw new RuntimeException(Message.LANGUAGE_ALREADY_EXISTS);
        }

        technologyRepository.save(technology);

        return request;
    }

    @Override
    public UpdateTechnologyRequest update(UpdateTechnologyRequest request, int id) {
        Technology technology = technologyRepository.findById(id).get();
        technologyMapper.update(technology, request);

        if (checkTechnologyNameValid(technology)) {
            throw new RuntimeException(Message.LANGUAGE_NAME_IS_NOT_VALID);
        }

        if (technology.getLanguage().getId() == request.getLanguageId()) {
            if (isTechnologyExists(technology)) {
                throw new RuntimeException(Message.LANGUAGE_ALREADY_EXISTS);
            }
        }

        Language language = languageRepository.findById(request.getLanguageId()).get();
        technology.setLanguage(language);

        technologyRepository.save(technology);

        return request;
    }

    @Override
    public void delete(int id) {
        technologyRepository.deleteById(id);
    }

    public boolean isTechnologyExists(Technology technology) {
        return technologyRepository.existsByName(technology.getName());
    }

    public boolean checkTechnologyNameValid(Technology technology) {
        return technology.getName().isEmpty() || technology.getName().isBlank();
    }
}
