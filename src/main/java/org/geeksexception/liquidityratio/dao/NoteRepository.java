package org.geeksexception.liquidityratio.dao;

import org.geeksexception.liquidityratio.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteRepository extends JpaRepository<Note, Long> {

}