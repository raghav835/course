package com.cms.service;

import com.cms.model.DatabaseSequence;
import com.cms.repository.DatabaseSequenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SequenceGeneratorService {

    private DatabaseSequenceRepository sequenceRepository;

    @Autowired
    public SequenceGeneratorService(DatabaseSequenceRepository sequenceRepository) {
        this.sequenceRepository = sequenceRepository;
    }

    public long generateSequence(String sequenceName) {
        DatabaseSequence sequence = sequenceRepository.findById(sequenceName)
                .orElse(new DatabaseSequence(sequenceName, 0));

        long nextValue = sequence.getSeq() + 1;
        sequence.setSeq(nextValue);
        sequenceRepository.save(sequence);

        return nextValue;
    }
}
