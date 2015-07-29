package org.geeksexception.liquidityratio.dao;

import org.geeksexception.liquidityratio.model.NoteHeader;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NoteHeaderRepository extends JpaRepository<NoteHeader, Long> {

}