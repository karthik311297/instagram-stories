package com.karthik.insta.datamodel.inbox.repository;

import com.karthik.insta.datamodel.inbox.model.InboxItem;
import com.karthik.insta.datamodel.inbox.identifier.InboxItemId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InboxRepository extends JpaRepository<InboxItem, InboxItemId> {
}
