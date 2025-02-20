package com.karthik.insta.datamodel.repository;

import com.karthik.insta.datamodel.model.InboxItem;
import com.karthik.insta.datamodel.model.identifier.InboxItemId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InboxRepository extends JpaRepository<InboxItem, InboxItemId> {
}
