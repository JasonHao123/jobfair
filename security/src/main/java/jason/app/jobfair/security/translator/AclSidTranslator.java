package jason.app.jobfair.security.translator;

import jason.app.jobfair.security.entity.AclSidImpl;
import jason.app.jobfair.security.model.AclSid;

public class AclSidTranslator {

	public static AclSid toDTO(AclSidImpl sid2) {
        AclSid sid = new AclSid();
        sid.setId(sid2.getId());
        sid.setPrincipal(sid2.getPrincipal());
        sid.setSid(sid2.getSid());
        return sid;
	}

}
