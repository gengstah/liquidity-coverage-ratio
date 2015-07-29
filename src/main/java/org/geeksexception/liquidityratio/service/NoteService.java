package org.geeksexception.liquidityratio.service;

import org.geeksexception.liquidityratio.model.Note;

public interface NoteService {
	
	Note findNoteByNoteId(Long noteId);
	
}