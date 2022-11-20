package com.torukobyte.kodlama_io_dev.business.concretes;

import com.torukobyte.kodlama_io_dev.business.abstracts.TechnologyService;
import com.torukobyte.kodlama_io_dev.business.constants.Message;
import com.torukobyte.kodlama_io_dev.business.requests.technologies.CreateTechnologyRequest;
import com.torukobyte.kodlama_io_dev.business.requests.technologies.UpdateTechnologyRequest;
import com.torukobyte.kodlama_io_dev.business.responses.technologies.CreateTechnologyResponse;
import com.torukobyte.kodlama_io_dev.business.responses.technologies.GetAllTechnologyResponse;
import com.torukobyte.kodlama_io_dev.business.responses.technologies.GetTechnologyResponse;
import com.torukobyte.kodlama_io_dev.business.responses.technologies.UpdateTechnologyResponse;
import com.torukobyte.kodlama_io_dev.entities.concretes.Technology;
import com.torukobyte.kodlama_io_dev.mappers.TechnologyMapper;
import com.torukobyte.kodlama_io_dev.repository.abstracts.TechnologyRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TechnologyManager implements TechnologyService {
    TechnologyRepository technologyRepository;
    TechnologyMapper mapper;

    @Override
    public List<GetAllTechnologyResponse> getAll() {
        List<Technology> technologies = technologyRepository.findAll();
        return mapper.toGetAllTechnologyResponse(technologies);
    }

    @Override
    public GetTechnologyResponse getById(int id) {
        Technology technology = technologyRepository.findById(id).get();
        return mapper.toTechnology(technology);
    }

    @Override
    public CreateTechnologyResponse create(CreateTechnologyRequest request) {
        Technology technology = mapper.toTechnology(request);

        if (checkTechnologyNameValid(technology)) {
            throw new RuntimeException(Message.LANGUAGE_NAME_IS_NOT_VALID);
        }

        if (isTechnologyExists(technology)) {
            throw new RuntimeException(Message.LANGUAGE_ALREADY_EXISTS);
        }

        technologyRepository.save(technology);

        return mapper.toCreateTechnologyResponse(technology);
    }

    @Override
    public UpdateTechnologyResponse update(UpdateTechnologyRequest request, int id) {
        Technology technology = technologyRepository.findById(id).get();
        mapper.update(technology, request);

        if (checkTechnologyNameValid(technology)) {
            throw new RuntimeException(Message.LANGUAGE_NAME_IS_NOT_VALID);
        }

        if (technology.getLanguage().getId() == request.getLanguageId()) {
            if (isTechnologyExists(technology)) {
                throw new RuntimeException(Message.LANGUAGE_ALREADY_EXISTS);
            }
        }

        // TODO: Will fix this later
        try {
            technologyRepository.save(technology);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            technologyRepository.save(technology);
        }

        return mapper.toUpdateTechnologyResponse(technology);
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
