package org.geeksexception.liquidityratio.service.impl;

import javax.inject.Inject;

import org.geeksexception.liquidityratio.dao.NoteRepository;
import org.geeksexception.liquidityratio.model.Note;
import org.geeksexception.liquidityratio.service.NoteService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
public class NoteServiceImpl implements NoteService {
	
	private @Inject NoteRepository noteRepository;
	
	public NoteServiceImpl() { }
	
	public Note findNoteByNoteId(Long noteId) {
		return noteRepository.findOne(noteId);
	}

}