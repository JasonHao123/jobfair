package jason.app.jobfair.security.service;

import jason.app.jobfair.security.entity.AclClassImpl;
import jason.app.jobfair.security.entity.AclEntryImpl;
import jason.app.jobfair.security.entity.AclObjectIdentityImpl;
import jason.app.jobfair.security.entity.AclSidImpl;
import jason.app.jobfair.security.model.AclClass;
import jason.app.jobfair.security.model.AclInfo;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import org.springframework.security.acls.model.ObjectIdentity;

public interface IAclDao {

    List<AclObjectIdentityImpl> findChildren(Serializable identifier, String type);

    AclObjectIdentityImpl getObjectIdentity(String type, Serializable identifier);

    void createObjectIdentity(AclObjectIdentityImpl identity);

    List<AclSidImpl> findAclSidList(Boolean valueOf, String sidName);

    AclSidImpl createAclSid(AclSidImpl sid2);

    List<AclClassImpl> findAclClassList(String type);

    AclClassImpl createAclClass(AclClassImpl clazz);

    void deleteEntries(AclObjectIdentityImpl oidPrimaryKey);

    void deleteObjectIdentity(AclObjectIdentityImpl oidPrimaryKey);

    void createEntries(List<AclEntryImpl> entries);

    boolean updateObjectIdentity(AclObjectIdentityImpl aclObject);

    AclSidImpl findAclSid(String principal);

    List<AclInfo> findParentsToLookup(Set<Long> findNow);

    List<AclInfo> findParentsToLookup(Collection<ObjectIdentity> objectIdentities);

}
